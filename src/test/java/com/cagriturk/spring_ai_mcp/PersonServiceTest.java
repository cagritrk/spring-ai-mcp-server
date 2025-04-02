package com.cagriturk.spring_ai_mcp;

import com.cagriturk.spring_ai_mcp.model.Person;
import com.cagriturk.spring_ai_mcp.service.PersonService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration tests for the PersonService implementation.
 * Uses @SpringBootTest to load the application context and autowire the service.
 */
@SpringBootTest // Loads the full application context
class PersonServiceTest {

    @Autowired
    private PersonService personService; // Autowire the service bean

    private static final int INITIAL_PERSON_COUNT = 100;
    private Person testPerson;

    @BeforeEach
    void setUp() {
        // Create a fresh test person instance before each test if needed for creation/update/delete tests
        testPerson = new Person(0, "Test", "User", "test.user@example.com", "Other", "127.0.0.1", "Tester", 25);
    }

    @Test
    @DisplayName("Context Loads and Service is Autowired")
    void contextLoads() {
        assertNotNull(personService, "PersonService should be autowired and not null");
    }

    @Test
    @DisplayName("Get All Persons - Initial Load")
    void getAllPersons_initialLoad_shouldReturnCorrectCount() {
        List<Person> persons = personService.getAllPersons();
        assertNotNull(persons, "Person list should not be null");
        assertEquals(INITIAL_PERSON_COUNT, persons.size(), "Initial person count should be " + INITIAL_PERSON_COUNT);
        // Check if the list is unmodifiable
        assertThrows(UnsupportedOperationException.class, () -> persons.add(testPerson),
                     "getAllPersons should return an unmodifiable list");
    }

    @Test
    @DisplayName("Get Person By ID - Existing")
    void getPersonById_existingId_shouldReturnPerson() {
        int existingId = 1; // Assuming ID 1 exists from CSV data
        Optional<Person> personOpt = personService.getPersonById(existingId);
        assertTrue(personOpt.isPresent(), "Person with ID " + existingId + " should be found");
        assertEquals(existingId, personOpt.get().id(), "Returned person should have the correct ID");
        assertEquals("Fons", personOpt.get().firstName(), "Returned person should have the correct first name");
    }

    @Test
    @DisplayName("Get Person By ID - Non-Existing")
    void getPersonById_nonExistingId_shouldReturnEmptyOptional() {
        int nonExistingId = 9999;
        Optional<Person> personOpt = personService.getPersonById(nonExistingId);
        assertFalse(personOpt.isPresent(), "Person with non-existing ID " + nonExistingId + " should not be found");
    }

    @Test
    @DisplayName("Create Person - Valid Data")
    void createPerson_validData_shouldReturnCreatedPersonWithId() {
        int initialSize = personService.getAllPersons().size();
        Person createdPerson = personService.createPerson(testPerson);

        assertNotNull(createdPerson, "Created person should not be null");
        assertTrue(createdPerson.id() > INITIAL_PERSON_COUNT, "Generated ID should be greater than initial max ID");
        assertEquals(testPerson.firstName(), createdPerson.firstName());
        assertEquals(testPerson.lastName(), createdPerson.lastName());
        assertEquals(testPerson.email(), createdPerson.email());

        // Verify it was added
        assertEquals(initialSize + 1, personService.getAllPersons().size(), "Total person count should increase by 1");
        Optional<Person> retrievedPersonOpt = personService.getPersonById(createdPerson.id());
        assertTrue(retrievedPersonOpt.isPresent(), "Created person should be retrievable by its new ID");
        assertEquals(createdPerson, retrievedPersonOpt.get(), "Retrieved person should match the created person");

        // Clean up - delete the created person
        personService.deletePerson(createdPerson.id());
    }

     @Test
    @DisplayName("Create Person - Null Data")
    void createPerson_nullData_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> personService.createPerson(null),
                     "Creating person with null data should throw IllegalArgumentException");
    }


    @Test
    @DisplayName("Update Person - Existing")
    void updatePerson_existingId_shouldUpdateAndReturnTrue() {
        // Create a person to update safely
        Person personToUpdate = personService.createPerson(testPerson);
        int idToUpdate = personToUpdate.id();

        Person updateData = new Person(0, "Updated", "User", "updated.user@example.com", "Female", "192.168.0.1", "Senior Tester", 26);
        boolean result = personService.updatePerson(idToUpdate, updateData);

        assertTrue(result, "Updating existing person should return true");

        Optional<Person> updatedPersonOpt = personService.getPersonById(idToUpdate);
        assertTrue(updatedPersonOpt.isPresent(), "Updated person should still exist");
        assertEquals(idToUpdate, updatedPersonOpt.get().id(), "Updated person should retain the original ID");
        assertEquals(updateData.firstName(), updatedPersonOpt.get().firstName(), "First name should be updated");
        assertEquals(updateData.lastName(), updatedPersonOpt.get().lastName(), "Last name should be updated");
        assertEquals(updateData.email(), updatedPersonOpt.get().email(), "Email should be updated");
        assertEquals(updateData.age(), updatedPersonOpt.get().age(), "Age should be updated");

        // Clean up
        personService.deletePerson(idToUpdate);
    }

    @Test
    @DisplayName("Update Person - Non-Existing")
    void updatePerson_nonExistingId_shouldReturnFalse() {
        int nonExistingId = 9998;
        Person updateData = new Person(0, "Non", "Existent", "ne@example.com", "Male", "1.1.1.1", "Ghost", 99);
        boolean result = personService.updatePerson(nonExistingId, updateData);

        assertFalse(result, "Updating non-existing person should return false");
    }

     @Test
    @DisplayName("Update Person - Null Data")
    void updatePerson_nullData_shouldThrowException() {
        // Create a person first
        Person created = personService.createPerson(testPerson);
        int id = created.id();
        assertThrows(IllegalArgumentException.class, () -> personService.updatePerson(id, null),
                     "Updating person with null data should throw IllegalArgumentException");
        // Clean up
        personService.deletePerson(id);
    }

    @Test
    @DisplayName("Delete Person - Existing")
    void deletePerson_existingId_shouldDeleteAndReturnTrue() {
         // Create a person to delete safely
        Person personToDelete = personService.createPerson(testPerson);
        int idToDelete = personToDelete.id();
        int sizeBeforeDelete = personService.getAllPersons().size();

        boolean result = personService.deletePerson(idToDelete);

        assertTrue(result, "Deleting existing person should return true");
        assertEquals(sizeBeforeDelete - 1, personService.getAllPersons().size(), "Total person count should decrease by 1");
        assertFalse(personService.getPersonById(idToDelete).isPresent(), "Deleted person should not be found");
    }

    @Test
    @DisplayName("Delete Person - Non-Existing")
    void deletePerson_nonExistingId_shouldReturnFalse() {
        int nonExistingId = 9997;
        int sizeBeforeDelete = personService.getAllPersons().size();
        boolean result = personService.deletePerson(nonExistingId);

        assertFalse(result, "Deleting non-existing person should return false");
         assertEquals(sizeBeforeDelete, personService.getAllPersons().size(), "Total person count should not change");
    }

    @Test
    @DisplayName("Search By Job Title - Case Insensitive Match")
    void searchByJobTitle_caseInsensitive_shouldFindMatches() {
        String query = "developer"; // Lowercase
        List<Person> results = personService.searchByJobTitle(query);
        assertNotNull(results);
        assertFalse(results.isEmpty(), "Should find persons with 'Developer' in job title");
        assertTrue(results.stream().allMatch(p -> p.jobTitle().toLowerCase().contains(query)),
                   "All found persons should contain the query in their job title (case-insensitive)");
        // Check if the list is unmodifiable
        assertThrows(UnsupportedOperationException.class, () -> results.add(testPerson));
    }

     @Test
    @DisplayName("Search By Job Title - Exact Match")
    void searchByJobTitle_exactMatch_shouldFindMatches() {
        String query = "Senior Developer"; // Exact title from data
        List<Person> results = personService.searchByJobTitle(query);
        assertNotNull(results);
        assertFalse(results.isEmpty(), "Should find persons with exact job title 'Senior Developer'");
        assertTrue(results.stream().allMatch(p -> p.jobTitle().equals(query)),
                   "All found persons should have the exact job title");
    }

    @Test
    @DisplayName("Search By Job Title - No Match")
    void searchByJobTitle_noMatch_shouldReturnEmptyList() {
        String query = "NonExistentJobTitleXYZ";
        List<Person> results = personService.searchByJobTitle(query);
        assertNotNull(results);
        assertTrue(results.isEmpty(), "Should not find persons with a non-existent job title");
    }

     @Test
    @DisplayName("Search By Job Title - Null or Blank Query")
    void searchByJobTitle_nullOrBlank_shouldReturnEmptyList() {
        List<Person> resultsNull = personService.searchByJobTitle(null);
        List<Person> resultsBlank = personService.searchByJobTitle("   ");
        assertNotNull(resultsNull);
        assertTrue(resultsNull.isEmpty(), "Search with null query should return empty list");
        assertNotNull(resultsBlank);
        assertTrue(resultsBlank.isEmpty(), "Search with blank query should return empty list");
    }

    @Test
    @DisplayName("Filter By Sex - Case Insensitive Match")
    void filterBySex_caseInsensitive_shouldFindMatches() {
        String filter = "male"; // Lowercase
        List<Person> results = personService.filterBySex(filter);
        assertNotNull(results);
        assertFalse(results.isEmpty(), "Should find persons with sex 'Male'");
        assertTrue(results.stream().allMatch(p -> p.sex().equalsIgnoreCase(filter)),
                   "All found persons should have the specified sex (case-insensitive)");
         // Check if the list is unmodifiable
        assertThrows(UnsupportedOperationException.class, () -> results.add(testPerson));
    }

    @Test
    @DisplayName("Filter By Sex - No Match")
    void filterBySex_noMatch_shouldReturnEmptyList() {
        String filter = "Unknown";
        List<Person> results = personService.filterBySex(filter);
        assertNotNull(results);
        assertTrue(results.isEmpty(), "Should not find persons with sex 'Unknown'");
    }

     @Test
    @DisplayName("Filter By Sex - Null or Blank Filter")
    void filterBySex_nullOrBlank_shouldReturnEmptyList() {
        List<Person> resultsNull = personService.filterBySex(null);
        List<Person> resultsBlank = personService.filterBySex("");
        assertNotNull(resultsNull);
        assertTrue(resultsNull.isEmpty(), "Filter with null sex should return empty list");
        assertNotNull(resultsBlank);
        assertTrue(resultsBlank.isEmpty(), "Filter with blank sex should return empty list");
    }

    @Test
    @DisplayName("Filter By Age - Exact Match")
    void filterByAge_exactMatch_shouldFindMatches() {
        int ageFilter = 40; // Age present in the initial data
        List<Person> results = personService.filterByAge(ageFilter);
        assertNotNull(results);
        assertFalse(results.isEmpty(), "Should find persons with age " + ageFilter);
        assertTrue(results.stream().allMatch(p -> p.age() == ageFilter),
                   "All found persons should have the exact age " + ageFilter);
         // Check if the list is unmodifiable
        assertThrows(UnsupportedOperationException.class, () -> results.add(testPerson));
    }

    @Test
    @DisplayName("Filter By Age - No Match")
    void filterByAge_noMatch_shouldReturnEmptyList() {
        int ageFilter = 150; // Unlikely age
        List<Person> results = personService.filterByAge(ageFilter);
        assertNotNull(results);
        assertTrue(results.isEmpty(), "Should not find persons with age " + ageFilter);
    }

     @Test
    @DisplayName("Filter By Age - Negative Age")
    void filterByAge_negativeAge_shouldReturnEmptyList() {
        int ageFilter = -5;
        List<Person> results = personService.filterByAge(ageFilter);
        assertNotNull(results);
        assertTrue(results.isEmpty(), "Filter with negative age should return empty list");
    }
}