package Strategy;

import Entity.Question;

import java.util.List;
import java.util.stream.Collectors;

public class TagSearch implements SearchStrategy{
    @Override
    public List<Question> search(List<Question> questions, String query) {
        String tagName = query.toLowerCase();

        return questions.stream()
                .filter(question -> question.getTags().stream()
                        .anyMatch(tag -> tag.getName().equalsIgnoreCase(tagName)))
                .collect(Collectors.toList());
    }
}
