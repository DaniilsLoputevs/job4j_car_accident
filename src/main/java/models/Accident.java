package models;

import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.StringJoiner;

@Component
public class Accident {
    private int id;
    private String name;
    private String text;
    private String address;

    public Accident() {
    }

    public Accident(int id, String name, String text, String address) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.address = address;
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

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Accident accident = (Accident) object;
        return id == accident.id
                && Objects.equals(name, accident.name)
                && Objects.equals(text, accident.text)
                && Objects.equals(address, accident.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, text, address);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Accident.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("text='" + text + "'")
                .add("address='" + address + "'")
                .toString();
    }
}
