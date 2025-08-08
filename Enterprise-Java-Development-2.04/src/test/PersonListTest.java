package org.YronJack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonListTest {
@Test
void findByNameReturnsPersonWhenNameMatches() {
    PersonList personList = new PersonList();
    Person person = new Person(1, "John Doe", 30, "Engineer");
    personList.getPersons().add(person);

    Person result = personList.findByName("John Doe");

    assertNotNull(result);
    assertEquals("John Doe", result.getName());
}

@Test
void findByNameThrowsExceptionForInvalidNameFormat() {
    PersonList personList = new PersonList();

    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
        personList.findByName("InvalidName");
    });

    assertEquals("El formato del nombre debe ser 'firstName lastName'", exception.getMessage());
}

@Test
void findByNameReturnsNullWhenNoMatchFound() {
    PersonList personList = new PersonList();
    personList.getPersons().add(new Person(1, "Jane Doe", 28, "Doctor"));

    Person result = personList.findByName("John Doe");

    assertNull(result);
}

@Test
void cloneCreatesNewPersonWithDifferentId() {
    PersonList personList = new PersonList();
    Person original = new Person(1, "John Doe", 30, "Engineer");

    Person cloned = personList.clone(original, 2);

    assertNotNull(cloned);
    assertEquals(2, cloned.getId());
    assertEquals("John Doe", cloned.getName());
    assertEquals(30, cloned.getAge());
    assertEquals("Engineer", cloned.getOccupation());
}


}