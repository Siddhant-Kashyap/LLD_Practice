package Repository;

import Entity.Answer;

import java.util.HashMap;
import java.util.Map;

public class AnswerRepository {
    private final Map<String, Answer> answers = new HashMap<>();

    public void save(Answer answer){
        answers.put(answer.getId(), answer);
    }
    public Answer getById(String id){
        return answers.get(id);
    }
}
