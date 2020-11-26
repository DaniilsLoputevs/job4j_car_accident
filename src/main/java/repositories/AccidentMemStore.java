package repositories;

import models.Accident;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AccidentMemStore implements DbCrudStore<Accident> {
    private static final Logger LOG = LoggerFactory.getLogger(AccidentMemStore.class);

    private final Map<Integer, Accident> store = new HashMap<>();

    public AccidentMemStore() {
    }

    @PostConstruct
    private void postConstruct() {
        this.addAll(List.of(
                new Accident(1, "name1", "text1", "address1"),
                new Accident(2, "name2", "text2", "address2"),
                new Accident(3, "name3", "text2", "address3")
        ));
    }

    @Override
    public void add(Accident item) {
        store.put(item.getId(), item);
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
        return null;
    }

    @Override
    public List<Accident> getAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void update(Accident item) {
        int id = item.getId();
        if (!store.containsKey(id)) {
            store.replace(id, item);
        } else {
            LOG.info("WARN LOG: AccidentMemStore - update() FAIL (details below):");
            LOG.info("id = " + id);
            LOG.info("toSting() :: " + item.toString());
        }
    }

    @Override
    public void updateAll(List<Accident> items) {
        items.forEach(this::update);
    }

    @Override
    public void delete(Accident item) {
        int id = item.getId();
        if (!store.containsKey(id)) {
            store.remove(id, item);
        } else {
            LOG.info("WARN LOG: AccidentMemStore - delete() FAIL (details below):");
            LOG.info("id = " + id);
            LOG.info("toSting() :: " + item.toString());
        }
//        this.delete(item.getId());
    }

    @Override
    public void delete(int id) {
        if (!store.containsKey(id)) {
            store.remove(id);
        } else {
            LOG.info("WARN LOG: AccidentMemStore - delete() FAIL (details below):");
            LOG.info("id = " + id);
        }
//        var temp = new Accident();
//        temp.setId(id);
//        this.coreManipulation(temp, store::remove, "delete");
    }

    @Override
    public void deleteAll(List<Accident> items) {
        items.forEach(this::delete);
    }

//    private void coreManipulation(Accident item,
//                                  Function<Accident, Accident> function,
//                                  String logMethod) {
//        int id = item.getId();
//        if (!store.containsKey(id)) {
//            function.apply(id);
//        } else {
//            LOG.info("WARN LOG: AccidentMemStore - " + logMethod + "() FAIL (details below):");
//            LOG.info("id = " + id);
//            LOG.info("toSting() :: " + item.toString());
//        }
//    }
}
