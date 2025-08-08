package org.YronJack;

import java.util.ArrayList;
import java.util.List;

public class PersonList {

    private List<Person> persons;

    public PersonList() {
        persons = new ArrayList<>();
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public Person findByName(String name) {

        if (!name.matches("^\\S+\\s\\S+$")) {
            throw new IllegalArgumentException("El formato del nombre debe ser 'firstName lastName'");
        }


        for (Person person : this.persons) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }


    public Person clone(Person original, int newId) {
        return new Person(newId, original.getName(), original.getAge(), original.getOccupation());
    }


}
