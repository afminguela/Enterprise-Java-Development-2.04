# Enterprise Java Development 2.04

## Overview

This project is a Java lab exercise focused on **exception handling** in enterprise Java development. It implements a person management system with robust error handling, validation, and data persistence capabilities.

## Technologies Used

- **Java 17** - Programming language
- **Maven** - Build automation and dependency management
- **JUnit 5** - Unit testing framework
- **JUnit 4** - Additional testing support

## Project Structure

```
Enterprise-Java-Development-2.04/
├── src/
│   ├── main/java/org/YronJack/
│   │   ├── Person.java          # Person entity class
│   │   ├── PersonList.java      # Person collection management
│   │   └── Main.java            # Main application entry point
│   └── test/java/org/YronJack/
│       ├── PersonTest.java      # Unit tests for Person class
│       └── PersonListTest.java  # Unit tests for PersonList class
├── pom.xml                      # Maven configuration
├── Instruccuines               # Project specifications (Spanish)
└── README.md                   # This file
```

## Key Features

### Person Class
- **Properties**: id, name, age, occupation
- **Age Validation**: Prevents setting negative ages with proper exception handling
- **Equality Comparison**: Compares persons based on name, age, and occupation (excluding id)
- **File Writing**: Saves person information to files with comprehensive error handling

### PersonList Class
- **Collection Management**: Manages a list of Person objects
- **Name Search**: Finds persons by exact name match with format validation
- **Name Format Validation**: Ensures names follow "firstName lastName" format
- **Object Cloning**: Creates new Person instances with different IDs

## Building and Running

### Prerequisites
- Java 17 or higher
- Maven 3.6+

### Build the Project
```bash
mvn compile
```

### Run Tests
```bash
mvn test
```

### Package the Application
```bash
mvn package
```

## Class Documentation

### Person Class

#### Constructor
```java
public Person(int id, String name, int age, String occupation)
```

#### Key Methods
- `setAge(int age)` - Sets age with validation (throws exception for negative values)
- `equals(Object o)` - Compares persons excluding the id property
- `writePersonToFile(Person person, String filePath)` - Static method to write person data to file

#### Example Usage
```java
Person person = new Person(1, "John Doe", 30, "Engineer");
person.setAge(35); // Valid
person.setAge(-5); // Prints error message, age remains unchanged

Person.writePersonToFile(person, "output.txt");
```

### PersonList Class

#### Key Methods
- `findByName(String name)` - Finds person by exact name match
- `clone(Person original, int newId)` - Creates a copy with new ID

#### Example Usage
```java
PersonList personList = new PersonList();
personList.getPersons().add(new Person(1, "John Doe", 30, "Engineer"));

// Find person
Person found = personList.findByName("John Doe"); // Valid format
// personList.findByName("John"); // Throws IllegalArgumentException

// Clone person
Person cloned = personList.clone(found, 2);
```

## Exception Handling Features

This project demonstrates several exception handling patterns:

1. **Input Validation**: Age validation prevents invalid data
2. **Format Validation**: Name format checking with custom exceptions
3. **File I/O Error Handling**: Graceful handling of file writing errors
4. **Test Coverage**: Comprehensive tests for all exception scenarios

## Test Cases

The project includes extensive unit tests covering:

- ✅ Age validation (positive and negative scenarios)
- ✅ Name format validation
- ✅ Person search functionality
- ✅ Object cloning
- ✅ File I/O operations
- ✅ Exception handling scenarios

## Running Individual Test Classes

```bash
# Run specific test class
mvn test -Dtest=PersonTest
mvn test -Dtest=PersonListTest

# Run specific test method
mvn test -Dtest=PersonTest#setAgeUpdatesAgeWhenValid
```

## Development Notes

- The project follows Maven standard directory layout
- All classes are in the `org.YronJack` package
- Exception handling is implemented throughout the codebase
- Unit tests provide comprehensive coverage of functionality and edge cases
- File operations include proper resource management with try-with-resources

## Contributing

This is an educational project for learning exception handling in Java. When contributing:

1. Ensure all tests pass
2. Maintain the existing code style
3. Add tests for new functionality
4. Handle exceptions appropriately
