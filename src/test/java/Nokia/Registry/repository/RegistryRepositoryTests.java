package Nokia.Registry.repository;

import Nokia.Registry.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RegistryRepositoryTests {
	@Autowired
	private RegistryRepository repo;

	@AfterEach
	void cleanRepo(){
		repo.clean();
	}

	@Test
	void addMultipleEntries_allAreIn() {
		assertTrue(repo.add("Adam", "Ben", "1"));
		assertEquals(1, repo.size());
		assertTrue(repo.add("Adam", "Ben", "2"));
		assertEquals(2, repo.size());
		assertTrue(repo.add("Riki", "Hen", "3"));
		assertEquals(3, repo.size());
	}

	@Test
	void addMultipleEntries_oneIsAlreadyIn_failsToAdd() {
		assertTrue(repo.add("Adam", "Ben", "1"));
		assertEquals(1, repo.size());
		assertFalse(repo.add("Adam", "Ben", "1"));
		assertEquals(1, repo.size());
		assertTrue(repo.add("Riki", "Hen", "3"));
		assertEquals(2, repo.size());
	}

	@Test
	void deleteFromRepo_oneEntryInRepo_deleteAll() {
		repo.add("Adam", "Ben", "1");
		assertTrue(repo.delete("Adam", "Ben"));
		assertEquals(0, repo.size());
		assertFalse(repo.delete("Adam", "Ben"));
	}

	@Test
	void deleteMultipleFromRepo_threeEntryInRepo_deleteAll() {
		repo.add("Adam", "Ben", "1");
		repo.add("Adam", "Ben", "2");
		repo.add("Riki", "Hen", "3");
		assertEquals(3, repo.size());
		assertTrue(repo.delete("Adam", "Ben"));
		assertTrue(repo.delete("Adam", "Ben"));
		assertTrue(repo.delete("Riki", "Hen"));
		assertEquals(0, repo.size());
	}

	@Test
	void deleteFromRepo_entryDoesNotExist_failsToDeleteOne() {
		assertFalse(repo.delete("Adam", "Ben"));
	}

	@Test
	void searchInRepo_entryExists_allOK(){
		repo.add("Adam", "Ben", "1");
		repo.add("Adam", "Ben", "2");
		Person[] people = repo.search("Adam", "Ben");
		assertEquals(2, people.length);
		Person adam1 = new Person("Adam", "Ben", "1");
		Person adam2 = new Person("Adam", "Ben", "2");
		assertEquals(adam1, people[0]);
		assertEquals(adam2, people[1]);
	}

	@Test
	void searchInRepo_entryDoesNotExists_nullIsReturned(){
		Person[] people = repo.search("Adam", "Ben");
		assertNull(people);
	}

}
//// Get current size of heap in bytes
//long heapSize = Runtime.getRuntime().totalMemory();
//
//// Get maximum size of heap in bytes. The heap cannot grow beyond this size.
//// Any attempt will result in an OutOfMemoryException.
//long heapMaxSize = Runtime.getRuntime().maxMemory();
//
//// Get amount of free memory within the heap in bytes. This size will increase
//// after garbage collection and decrease as new objects are created.
//long heapFreeSize = Runtime.getRuntime().freeMemory();