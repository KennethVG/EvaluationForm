const currentDate = new Date();
const day = currentDate.getDate();
const month = currentDate.getMonth() + 1;
const year = currentDate.getFullYear();

$(function () {
    showAllInstructors();
    showAllCourses();
    showAllQuestions();
    showAllTopics();

    $("#currentDate").html(day.toString() + "-" + month.toString() + "-" + year.toString());

    $("#submit").click(function() { 
        postEvaluation();
    });


});