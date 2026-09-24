package Strategy;

import Entity.Question;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class KeyWordSearch implements SearchStrategy{
    @Override
    public List<Question> search(List<Question> questions, String query) {
        String keyword = query.toLowerCase();
        return questions.stream()
                .filter(question -> question.getTitle().toLowerCase().contains(keyword) ||
                        question.getDescription().toLowerCase().contains(keyword))
                .collect(Collectors.toList());
    }
}
