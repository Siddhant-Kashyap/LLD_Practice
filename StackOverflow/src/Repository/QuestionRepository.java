package Repository;

import Entity.Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionRepository {
    private final Map<String, Question> questions = new HashMap<>();

    public  void save(Question question){
        questions.put(question.getId(),question);
    }
    public Question findById(String id){
        return questions.get(id);
    }
    public List<Question> findAll(){
        return new ArrayList<>(questions.values());
    }
}
