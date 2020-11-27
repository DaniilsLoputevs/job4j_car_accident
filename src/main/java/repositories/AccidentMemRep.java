package repositories;

import models.Accident;
import models.AccidentType;
import models.Rule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class AccidentMemRep implements BasicCrudRep<Accident> {
    private static final Logger LOG = LoggerFactory.getLogger(AccidentMemRep.class);

    private final Map<Integer, Accident> store = new HashMap<>();
    private int lastIndex = 0;

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
            store.put(this.lastIndex, item);
        } else {
            store.put(item.getId(), item);
        }
        this.lastIndex++;
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
        int id = item.getId();
        if (!store.containsKey(id)) {
            store.replace(id, item);
        } else {
            LOG.info("WARN LOG: AccidentMemRep - update() FAIL (details below):");
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
            LOG.info("WARN LOG: AccidentMemRep - delete() FAIL (details below):");
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
            LOG.info("WARN LOG: AccidentMemRep - delete() FAIL (details below):");
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
//            LOG.info("WARN LOG: AccidentMemRep - " + logMethod + "() FAIL (details below):");
//            LOG.info("id = " + id);
//            LOG.info("toSting() :: " + item.toString());
//        }
//    }
}
