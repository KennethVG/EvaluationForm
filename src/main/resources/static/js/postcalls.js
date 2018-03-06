
//******************* Objects **************************************************
function Evaluation(comments, course, instructor, student) {
    this.comments = comments;
    this.course = course;
    this.instructor = instructor;
    this.student = student;
}

function Student(eMail, firstName, name) {
    this.eMail = eMail;
    this.firstName = firstName;
    this.name = name;
}

function EvaluationPerQuestion(score, question, evaluation) {
    this.score = score;
    this.question = question;
    this.evaluation = evaluation;
}

//******************* Post calls ***********************************************
function postEvaluation() {
    let s = postStudent();

    let comments = $("#CommentsTextarea").val();
    let course = { id: selectedCourse };
    let instructor = { id: selectedInstructor };

    let fullURL = url + "/laststudent";
    console.log("FullUrl: " + fullURL);

    $.getJSON(fullURL,
        function (response) {
            console.log("StudentId= " + response.id);
            let student = { id: (response.id + 1) };

            let evaluation = new Evaluation(comments, course, instructor, student);

            postData("evaluation", evaluation);
        }
    );
}

function postStudent() {
    let email = $("#student-email").val();
    let firstname = $("#student-firstname").val();
    let lastname = $("#student-lastname").val();

    let student = new Student(email, firstname, lastname);

    postData("student", student);

    return student;
}

function postScores() {

    postEvaluation();

    let fullURL = url + "/lastevaluation";

    $.getJSON(fullURL,
        function (response) {
            console.log("EvaluationId= " + response.id);

            let evaluation = { id: (response.id + 1) };

            // 3= number of GENERAL questions in Databank
            for (let i = 1; i <= 3; i++) {
                const score = $("input[name=GENERALQ" + i + "]:checked").val();
                let question = { id: i };
                let evaluationPerQuestion = new EvaluationPerQuestion(score, question, evaluation);

                postData("evaluationquestion", evaluationPerQuestion);
            }

            // 6= number of INSTRUCTOR questions in Databank
            for (let i = 4; i <= 9; i++) {
                const score = $("input[name=INSTRUCTORQ" + i + "]:checked").val();
                let question = { id: i };
                let evaluationPerQuestion = new EvaluationPerQuestion(score, question, evaluation);

                postData("evaluationquestion", evaluationPerQuestion);
            }

            // 2= number of CLASSROOM questions in Databank
            for (let i = 10; i <= 11; i++) {
                const score = $("input[name=CLASSROOMQ" + i + "]:checked").val();
                let question = { id: i };
                let evaluationPerQuestion = new EvaluationPerQuestion(score, question, evaluation);

                postData("evaluationquestion", evaluationPerQuestion);
            }

            // 4= number of CONTENT questions in Databank
            for (let i = 12; i <= 15; i++) {
                const score = $("input[name=CONTENTQ" + i + "]:checked").val();
                let question = { id: i };
                let evaluationPerQuestion = new EvaluationPerQuestion(score, question, evaluation);

                postData("evaluationquestion", evaluationPerQuestion);
            }
        }
    );
}

function postData(extendedUrl, data) {
    console.log("JSON TO POST: " + JSON.stringify(data));
    $.ajax({
        type: "post",
        url: url + "/" + extendedUrl,
        data: JSON.stringify(data),
        contentType: "application/json",
        success: function (response) {
            console.log("toegevoegd!");
        },
        error: function (response) {
            console.log("niet toegevoegd!");
        }
    });
}