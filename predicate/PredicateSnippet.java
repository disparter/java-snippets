package predicate;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateSnippet {
    List<SimpleObject> objects;

    public PredicateSnippet(List<SimpleObject> objects){
        this.objects = objects;
    }

    public PredicateSnippet filter(Predicate<SimpleObject> predicate){
        this.objects = objects.stream().filter(predicate).collect(Collectors.toList());
        return this;
    }

    public List<SimpleObject> collect(){
        return this.objects;
    }

}
