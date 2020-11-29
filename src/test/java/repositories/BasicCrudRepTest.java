package repositories;

import models.Accident;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BasicCrudRepTest {
    private final BasicCrudRep<Accident> rep = new AccidentMemRep();

    @Before
    public void setUp() throws Exception {
        var one = new Accident();
        var two = new Accident();
        var three = new Accident();
        one.setId(1);
        two.setId(2);
        three.setId(3);
        rep.addAll(List.of(one, two, three));
    }

    @Test
    public void update() {
        // update
        var updAcc = new Accident();
        updAcc.setId(1);
        updAcc.setName("UPD");
        rep.update(updAcc);
        assertEquals("UPD", rep.getBy(1).getName());
    }

    @Test
    public void deleteById() {
        // delete
        rep.delete(3);
        assertEquals(2, rep.size());
    }

    @Test
    public void deleteByItem() {
        var delAcc = new Accident();
        delAcc.setId(2);
        rep.delete(delAcc);
        assertEquals(2, rep.size());
    }
}
