package Strategy;

import Entity.Question;

import java.util.List;

public interface SearchStrategy {
    List<Question> search(List<Question> questions ,String query);
}
