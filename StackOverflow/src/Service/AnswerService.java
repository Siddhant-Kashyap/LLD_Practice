package Service;

import Entity.Answer;
import Entity.Question;
import Entity.User;
import Repository.AnswerRepository;
import Repository.QuestionRepository;

import java.lang.ref.PhantomReference;
import java.util.UUID;

public class AnswerService {
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    public AnswerService(AnswerRepository answerRepository,QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository=questionRepository;
    }

    public Answer createAnswer(User user, String questionId,String content){
        Question question = questionRepository.findById(questionId);
        if(question==null) throw new IllegalArgumentException("Question does not exists");
        if(content==null) throw new IllegalArgumentException("Content can not be empty");

        Answer answer = new Answer(UUID.randomUUID().toString(),content,user,question);
        question.addAnswer(answer);
        answerRepository.save(answer);
        return answer;
    }


}
