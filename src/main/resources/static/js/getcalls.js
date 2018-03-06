const url = "http://localhost:8080/evaluationform";
studentId = 1;
evaluationId= 1;

//*******************functions ************************************************************************
function showAllInstructors() {
    $.getJSON(url + "/instructors",
        function (response) {
            let dynamicHTML = "";
            for (let instr of response) {
                dynamicHTML += `<option value=${instr.id}>${instr.id}  ${instr.name}</option>`;
            }
            $("#dropdownlist-instructor").html(dynamicHTML);
        }
    );
}

function showAllCourses() {
    $.getJSON(url + "/courses",
        function (response) {
            let dynamicHTML = "";
            for (let course of response) {
                dynamicHTML += `<option value=${course.id}>${course.id}  ${course.name}</option>`;
            }
            $("#dropdownlist-course").html(dynamicHTML);
        }
    );
}

function showQuestionsByCategory(category) {

    $.getJSON(url + "/questions/" + category,
        function (response) {
            let dynamicHTML = "";
            for (let aQuestion of response) {
                dynamicHTML += `<div class="col-md-6 col-sm-12 col-xs-12">
                                <label>
                                    ${aQuestion.name}
                                </label>
                            </div>
                            <div class="col-md-6 col-sm-12 col-xs-12">
                                <div class="form-check form-check-inline">
                                    <label class="form-check-label">
                                        <input class="form-check-input" type="radio" name=${aQuestion.category}Q${aQuestion.id} id=${aQuestion.id} value="1" required>1
                                    </label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <label class="form-check-label">
                                        <input class="form-check-input" type="radio" name=${aQuestion.category}Q${aQuestion.id} id=${aQuestion.id} value="2" required>2
                                    </label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <label class="form-check-label">
                                        <input class="form-check-input" type="radio" name=${aQuestion.category}Q${aQuestion.id} id=${aQuestion.id} checked value="3" required>3
                                    </label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <label class="form-check-label">
                                        <input class="form-check-input" type="radio" name=${aQuestion.category}Q${aQuestion.id} id=${aQuestion.id} value="4" required>4
                                    </label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <label class="form-check-label">
                                        <input class="form-check-input" type="radio" name=${aQuestion.category}Q${aQuestion.id} id=${aQuestion.id} value="5" required>5
                                    </label>
                                </div>
                            </div>`;
            }
            category = category.toLowerCase();
            $("#questions-cat-" + category).html(dynamicHTML);
        }
    );
}

function showAllQuestions() {
    showQuestionsByCategory("GENERAL");
    showQuestionsByCategory("CONTENT");
    showQuestionsByCategory("CLASSROOM");
    showQuestionsByCategory("INSTRUCTOR");
}

function showAllTopics() {
    $.getJSON(url + "/topics",
        function (response) {
            let dynamicHTML = "";
            for (let aTopic of response) {
                dynamicHTML += `<optgroup id=topic${aTopic.id} label=${aTopic.name} class="topic">
                            </optgroup>`;
            }
            $("#select-subtopic").html(dynamicHTML);
            showAllSubtopics();
        }
    );
}

function showAllSubtopics() {
    //get all <optgroup> elements in document
    let allOptgroups = document.getElementsByClassName("topic");
    for (let aOptgroup of allOptgroups) {
        // extract id of optgroup by deleting the word "topic" of "topic#"
        let aTopicId = aOptgroup.id.substring(5);
        showAllSubtopicsByTopicId(aTopicId);
    }
}

function showAllSubtopicsByTopicId(topicId) {
    $.getJSON(url + "/subtopics/" + topicId,
        function (response) {
            let dynamicHTML = "";
            for (let aSubtopic of response) {
                dynamicHTML += `<option value=${aSubtopic.id}>${aSubtopic.name}</option>`;
            }
            $("#topic" + topicId).html(dynamicHTML);
        }
    );
}