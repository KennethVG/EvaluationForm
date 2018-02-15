let subtopics = [];

$("select").change(function () {
    let value= $("#select-subtopic").find("option:selected").text();
    subtopics.push(value);
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

