package factions;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

/**
 * Unit tests of the factions
 * 
 */
class FactionTest {
	Faction capitalists;
	Faction communists;
	Faction ecologists;
	Faction liberals;
	Faction loyalists;
	Faction militarists;
	Faction nationalists;
	Faction religious;
	TestInfo testInfo;
	TestReporter testReporter;

	@BeforeAll
	void initialization(TestInfo testInfo, TestReporter testReporter) {
		this.testInfo = testInfo;
		this.testReporter = testReporter;

		testReporter
				.publishEntry(String.format("Testing %s with tags %s", testInfo.getDisplayName(), testInfo.getTags()));
	}

	@Test
	void testSubClasses() {
		assertAll(
				() -> assertTrue(capitalists instanceof Faction,
						String.format("%s should be a subclass of %s", capitalists.getClass().getName(),
								Faction.class.getName())),
				() -> assertTrue(communists instanceof Faction,
						String.format("%s should be a subclass of %s", communists.getClass().getName(),
								Faction.class.getName())),
				() -> assertTrue(ecologists instanceof Faction,
						String.format("%s should be a subclass of %s", ecologists.getClass().getName(),
								Faction.class.getName())),
				() -> assertTrue(liberals instanceof Faction,
						String.format("%s should be a subclass of %s", liberals.getClass().getName(),
								Faction.class.getName())),
				() -> assertTrue(loyalists instanceof Faction,
						String.format("%s should be a subclass of %s", loyalists.getClass().getName(),
								Faction.class.getName())),
				() -> assertTrue(militarists instanceof Faction,
						String.format("%s should be a subclass of %s", militarists.getClass().getName(),
								Faction.class.getName())),
				() -> assertTrue(nationalists instanceof Faction,
						String.format("%s should be a subclass of %s", nationalists.getClass().getName(),
								Faction.class.getName())),
				() -> assertTrue(religious instanceof Faction, String.format("%s should be a subclass of %s",
						religious.getClass().getName(), Faction.class.getName()))

		);
	}

}
