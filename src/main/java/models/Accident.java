package models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

@Component
@Entity
@Table(name = "accidents")
public class Accident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String text;
    private String address;
    
    @OneToOne(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JoinColumn(name = "type_id")
    private AccidentType type;
    
    @OneToMany(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JoinColumn(name = "rulesid")
    private Set<Rule> rules;
    
    public Accident() {
    }
    
    public Accident(int id, String name, String text,
                    String address, AccidentType type,
                    Set<Rule> rules) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.address = address;
        this.type = type;
        this.rules = rules;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public AccidentType getType() {
        return type;
    }
    
    public void setType(AccidentType type) {
        this.type = type;
    }
    
    public Set<Rule> getRules() {
        return rules;
    }
    
    public void setRules(Set<Rule> rules) {
        this.rules = rules;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Accident accident = (Accident) o;
        return id == accident.id && Objects.equals(name, accident.name) && Objects.equals(text, accident.text) && Objects.equals(address, accident.address) && Objects.equals(type, accident.type) && Objects.equals(rules, accident.rules);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, name, text, address, type, rules);
    }
    
    @Override
    public String toString() {
        return new StringJoiner(", ", Accident.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("text='" + text + "'")
                .add("address='" + address + "'")
                .add("type=" + type)
                .add("rules=" + rules)
                .toString();
    }
}
