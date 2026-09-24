package Service;

import Entity.Question;
import Strategy.SearchStrategy;

import java.util.List;

public class SearchService {
    private SearchStrategy searchStrategy;

    public SearchService(SearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }
    public void setSearchStrategy(SearchStrategy searchStrategy){
        this.searchStrategy = searchStrategy;
    }
    public List<Question> search(List<Question> questions,String query){
        return searchStrategy.search(questions,query);
    }
}
