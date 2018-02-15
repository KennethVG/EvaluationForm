package be.oak3.evaluationform.controller;

import be.oak3.evaluationform.model.*;
import be.oak3.evaluationform.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/evaluationform")
@CrossOrigin
public class EvaluationFormController {

    private final InstructorService instructorService;
    private final CourseService courseService;
    private final EvaluationService evaluationService;
    private final QuestionService questionService;
    private final StudentService studentService;
    private final EvaluationQuestionService evaluationQuestionService;
    private final TopicService topicService;
    private final SubtopicService subtopicService;

    @Autowired
    public EvaluationFormController(InstructorService instructorService, CourseService courseService, EvaluationService evaluationService, QuestionService questionService, StudentService studentService, EvaluationQuestionService evaluationQuestionService, TopicService topicService, SubtopicService subtopicService) {
        this.instructorService = instructorService;
        this.courseService = courseService;
        this.evaluationService = evaluationService;
        this.questionService = questionService;
        this.studentService = studentService;
        this.evaluationQuestionService = evaluationQuestionService;
        this.topicService = topicService;
        this.subtopicService = subtopicService;
    }

    @GetMapping("/instructors")
    public ResponseEntity findAllInstructors() {
        System.out.println("Controller : @GetMapping(\"/instructors\")");
        return ResponseEntity.ok(instructorService.findAll());
    }

    @PostMapping("/instructor")
    public ResponseEntity addInstructor(@RequestBody Instructor instructor) {
        return ResponseEntity.ok(instructorService.addInstructor(instructor));
    }

    @GetMapping("/courses")
    public ResponseEntity findAllCourses() {
        return ResponseEntity.ok(courseService.findAll());
    }

    @PostMapping("/course")
    public ResponseEntity addCourse(@RequestBody Course course) {
        return ResponseEntity.ok(courseService.addCourse(course));
    }

    @GetMapping("/questions")
    public ResponseEntity findAllQuestions() {
        return ResponseEntity.ok(questionService.findAll());
    }

    @PostMapping("/question")
    public ResponseEntity addQuestion(@RequestBody Question question) {
        return ResponseEntity.ok(questionService.addQuestion(question));
    }

    @GetMapping("/evaluationquestions")
    public ResponseEntity findAllEvaluationQuestions() {
        return ResponseEntity.ok(evaluationQuestionService.findAll());
    }

    @PostMapping("/evaluationquestion")
    public ResponseEntity addEvaluationQuestion(@RequestBody EvaluationQuestion evaluationQuestion) {
        return ResponseEntity.ok(evaluationQuestionService.addEvaluationQuestion(evaluationQuestion));
    }

    @GetMapping("/topics")
    public ResponseEntity findAllTopics() {
        return ResponseEntity.ok(topicService.findAll());
    }

    @PostMapping("/topic")
    public ResponseEntity addTopic(@RequestBody Topic topic) {
        return ResponseEntity.ok(topicService.addTopic(topic));
    }

    @GetMapping("/subtopics")
    public ResponseEntity findAllSubtopics() {
        return ResponseEntity.ok(subtopicService.findAll());
    }

    @PostMapping("/subtopic")
    public ResponseEntity addSubtopic(@RequestBody Subtopic subtopic) {
        return ResponseEntity.ok(subtopicService.addSubtopic(subtopic));
    }

    @GetMapping("/subtopics/{topicId}")
    public ResponseEntity findSubTopicsByTopic(@PathVariable int topicId) {
        return ResponseEntity.ok(subtopicService.findSubtopicsByTopicId(topicId));
    }

    @GetMapping("/students")
    public ResponseEntity findAllStudents() {
        return ResponseEntity.ok(studentService.findAll());
    }

    @PostMapping("/student")
    public ResponseEntity addStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.addStudent(student));
    }

    @GetMapping("/evaluations")
    public ResponseEntity findAllEvaluations() {
        return ResponseEntity.ok(evaluationService.findAll());
    }

    @PostMapping("/evaluation")
    public ResponseEntity addEvaluation(@RequestBody Evaluation evaluation) {
        return ResponseEntity.ok(evaluationService.addEvaluation(evaluation));
    }

    @GetMapping("/questions/{category}")
    public ResponseEntity findQuestionsByCategory(@PathVariable Category category) {
        return ResponseEntity.ok(questionService.findByCategory(category));
    }

}
