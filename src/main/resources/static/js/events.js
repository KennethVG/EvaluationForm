let subtopics = [];

let selectedCourse;
let selectedInstructor;

$("select").change(function () {
    //let subtopic= $("#select-subtopic").find("option:selected").text();
    let course= $("#dropdownlist-course").find("option:selected");
    let instructor = $("#dropdownlist-instructor").find("option:selected");
    

    selectedCourse = course.val();
    selectedInstructor = instructor.val();

   // subtopics.push(value);
});

$("#submit").click(function () {
    for (const topic of subtopics) {
        console.log("Topic: " + topic);
    }    

    $(this).attr('action', 'mailto:kenneth.vangijsel@oak3.be');
    $(this).attr('method', 'post');

    $("#myform").submit();
});

$("#print").click(function () {
    print();
});

