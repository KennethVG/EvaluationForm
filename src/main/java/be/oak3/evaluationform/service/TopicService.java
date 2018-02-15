package be.oak3.evaluationform.service;

import be.oak3.evaluationform.model.Topic;

import java.util.List;

public interface TopicService {

    int addTopic(Topic topic);
    int updateTopic(Topic topic);
    int deleteTopic(Topic opic);

    List<Topic> findAll();

    Topic findOne(int id);
}
