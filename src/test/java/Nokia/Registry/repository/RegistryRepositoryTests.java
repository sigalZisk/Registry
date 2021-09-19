package Nokia.Registry.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RegistryRepositoryTests {
	@Autowired
	private RegistryRepository repo;

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
}
