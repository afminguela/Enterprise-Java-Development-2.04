package org.YronJack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void setAgeUpdatesAgeWhenValid() throws Exception {
        Person person = new Person(1, "John Doe", 25, "Engineer");
        person.setAge(30);
        assertEquals(30, person.getAge());
    }

    @Test
    void setAgeDoesNotUpdateAgeWhenInvalid() throws Exception {
        Person person = new Person(1, "John Doe", 25, "Engineer");
        person.setAge(-5);
        assertEquals(25, person.getAge());
    }

    @Test
    void setAgeHandlesExceptionGracefully() {
        Person person = new Person(1, "John Doe", 25, "Engineer");
        assertDoesNotThrow(() -> person.setAge(0));
    }

    @Test
    void writePersonToFile() {
        Person person = new Person(1, "John Doe", 25, "Engineer");
        assertEquals("John Doe", person.getName());

    }

    @Test
    void writePersonToFileWritesCorrectly() throws java.io.IOException {
        Person person = new Person(1, "John Doe", 25, "Engineer");
        String filePath = "test_person_output.txt";
        Person.writePersonToFile(person, filePath);

        java.nio.file.Path path = java.nio.file.Paths.get(filePath);
        String content = java.nio.file.Files.readString(path);
        assertTrue(content.contains("John Doe"));
        java.nio.file.Files.deleteIfExists(path);
    }

    @Test
    void writePersonToFileHandlesIOExceptionGracefully() {
        Person person = new Person(1, "John Doe", 25, "Engineer");
        String invalidFilePath = "/invalid_path/test_person_output.txt";

        assertDoesNotThrow(() -> Person.writePersonToFile(person, invalidFilePath));
    }
}