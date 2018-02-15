package be.oak3.evaluationform.service;

import be.oak3.evaluationform.model.Subtopic;

import java.util.List;

public interface SubtopicService {

    int addSubtopic(Subtopic subtopic);
    int updateSubtopic(Subtopic subtopic);
    int deleteSubtopic(Subtopic subtopic);

    List<Subtopic> findAll();

    List<Subtopic> findSubtopicsByTopicId(int topicId);
}
