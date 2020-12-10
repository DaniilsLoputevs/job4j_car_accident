package repositories;

import models.Accident;
import models.AccidentType;
import models.Rule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;

@Repository
public class AccidentMemRep implements BasicCrudRep<Accident> {
    private static final Logger LOG = LoggerFactory.getLogger(AccidentMemRep.class);

    private final Map<Integer, Accident> store = new HashMap<>();
    private final AtomicInteger index = new AtomicInteger(0);

    public AccidentMemRep() {
    }

    @PostConstruct
    private void postConstruct() {
        this.addAll(List.of(
                new Accident(1, "name1", "text1", "address1",
                        AccidentType.of(1, "type1"),
                        Set.of(Rule.of(1, "rule 1"))),
                new Accident(2, "name2", "text2", "address2",
                        AccidentType.of(2, "type2"),
                        Set.of(Rule.of(2, "rule 2"))),
                new Accident(3, "name3", "text2", "address3",
                        AccidentType.of(3, "type3"),
                        Set.of(Rule.of(3, "rule 3")))
        ));
    }

    @Override
    public void add(Accident item) {
        int id = item.getId();
        if (id == 0) {
            store.put(index.getAndIncrement(), item);
        } else {
            store.put(item.getId(), item);
        }
        index.getAndIncrement();
    }

    @Override
    public void addAll(List<Accident> items) {
        items.forEach(this::add);
    }

    @Override
    public Accident getBy(int id) {
        return store.get(id);
    }

    @Override
    public <V> List<Accident> getBy(String fieldName, V value) {
        throw new UnsupportedOperationException("This interface method doesn't realise yet.");
    }

    @Override
    public List<Accident> getAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void update(Accident item) {
        this.coreDataManipulation(item, store::replace, "update(accident)");
    }

    @Override
    public void updateAll(List<Accident> items) {
        items.forEach(this::update);
    }

    @Override
    public void delete(Accident item) {
        this.coreDataManipulation(item, store::remove, "delete(accident)");
    }

    @Override
    public void delete(int id) {
        var temp = new Accident();
        temp.setId(id);
        this.coreDataManipulation(temp, store::remove, "delete(id)");
    }

    @Override
    public void deleteAll(List<Accident> items) {
        items.forEach(this::delete);
    }

    private void coreDataManipulation(Accident item,
                                      BiConsumer<Integer, Accident> function,
                                      String methodNameForLog) {
        int id = item.getId();
        if (store.containsKey(id)) {
            function.accept(id, item);
        } else {
            LOG.warn("AccidentMemRep - {} FAIL:", methodNameForLog);
            LOG.warn("id={} do not contains in repository", id);
            LOG.warn("details: {}", item);
        }
    }

    @Override
    public int size() {
        return this.store.size();
    }

}
