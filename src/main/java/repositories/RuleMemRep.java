package repositories;

import models.Rule;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RuleMemRep implements BasicCrudRep<Rule> {
    private final Map<Integer, Rule> store = new HashMap<>();

    @PostConstruct
    private void postConstruct() {
        this.addAll(List.of(
                Rule.of(1, "rule 1"),
                Rule.of(2, "rule 2"),
                Rule.of(3, "rule 3")
        ));
    }

    @Override
    public void add(Rule item) {
        store.put(item.getId(), item);
    }

    @Override
    public void addAll(List<Rule> items) {
        items.forEach(this::add);
    }

    @Override
    public <V> Rule getBy(int id) {
        return store.get(id);
    }

    @Override
    public <V> List<Rule> getBy(String fieldName, V value) {
        throw new UnsupportedOperationException("This interface method doesn't realise yet.");
    }

    @Override
    public List<Rule> getAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void update(Rule item) {
        throw new UnsupportedOperationException("This interface method doesn't realise yet.");
    }

    @Override
    public void updateAll(List<Rule> items) {
        throw new UnsupportedOperationException("This interface method doesn't realise yet.");
    }

    @Override
    public void delete(Rule item) {
        throw new UnsupportedOperationException("This interface method doesn't realise yet.");
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("This interface method doesn't realise yet.");
    }

    @Override
    public void deleteAll(List<Rule> items) {
        throw new UnsupportedOperationException("This interface method doesn't realise yet.");
    }
}
