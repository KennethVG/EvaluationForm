let subtopics = [];

let selectedCourse;
let selectedInstructor;

$("select").change(function () {
    //let subtopic= $("#select-subtopic").find("option:selected").text();

    let course = $("#dropdownlist-course").find("option:selected");
    let instructor = $("#dropdownlist-instructor").find("option:selected");

    selectedCourse = course.val();
    selectedInstructor = instructor.val();

    // subtopics.push(value);
});

$("#print").click(function () {
    print();
});

