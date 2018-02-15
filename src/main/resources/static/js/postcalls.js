
//******************* Objects ***********************************************
function Evaluation(comments, course, instructor, student) {
    this.comments = comments;
    this.course = course;
    this.instructor = instructor;
    this.student = student;
}

function Course (id){
    this.id=id;
}

function Instructor (id){
    this.id=id;
}

function Student(id){
    this.id = id;
}

//******************* Post calls ***********************************************
function postEvaluation() {

    course = new Course(selectedCourse);
    instructor = new Instructor(selectedInstructor);
    student = new Student(1);

    let comments= $("#CommentsTextarea").val();


    evaluation = new Evaluation(comments, course, instructor, student);

    console.log("JSON TO POST: " + JSON.stringify(evaluation));

    $.ajax({
        type: "post",
        url: url + "/evaluation",
        data: JSON.stringify(evaluation),
        contentType: "application/json",
        success: function (response) {
            alert("Evaluatie toegevoegd");
        },
        error: function(response){
            alert("Evaluatie niet toegevoegd");
        }
    });
}