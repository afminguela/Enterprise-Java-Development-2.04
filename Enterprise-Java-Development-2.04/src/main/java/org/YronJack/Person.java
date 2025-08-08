package org.YronJack;

import java.util.Objects;

public class Person {
    private int id;
    private String name;
    private int age;
    private String occupation;


    public Person(int id, String name, int age, String occupation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.occupation = occupation;


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

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws Exception {
        try { if (age>0){ this.age = age; }
        else { System.out.println("Invalid age"); }
        }
        catch (Exception e) { System.out.println("Error: "+ e);}


    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person person)) return false;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(occupation, person.occupation);
    }

    private String toString(Person person) {
        return "person: " +getName()+getOccupation()+getAge();
    }


    public static void writePersonToFile(Person person, String filePath) {
            try (java.io.FileWriter writer = new java.io.FileWriter(filePath, true)) {
                writer.write(person.toString(person) + System.lineSeparator());
            } catch (java.io.IOException e) {
                System.out.println("Error al escribir en el archivo: " + e.getMessage());
            }
        }

}
