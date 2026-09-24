package Service;

import Entity.Answer;
import Entity.Question;
import Entity.Tag;
import Entity.User;
import Repository.QuestionRepository;

import java.util.List;
import java.util.UUID;

public class QuestionService{
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question createQuestion(User user, String title, String description, List<Tag> tags){
        if(user== null) throw new IllegalArgumentException("User can not be null");
        if(title==null || title.isBlank()){
            throw new IllegalArgumentException("Title can not be empty");
        }
        Question question = new Question(UUID.randomUUID().toString(),title,description,user);
        for(Tag tag:tags){
            question.addTags(tag);
        }
        questionRepository.save(question);
        return question;
    }
    public void acceptAnswer(
            User user,
            String questionId,
            Answer answer) {

        Question question =
                questionRepository.findById(questionId);

        if (question == null) {
            throw new IllegalArgumentException(
                    "Question not found"
            );
        }
        if(question.getAuthor()!= user) throw new RuntimeException("You are not allowed");

        question.acceptAnswer(answer,user);
    }

}
