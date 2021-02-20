package markers;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

import exceptions.AccumulationException;

class MarkerTest {
	TestInfo testInfo;
	TestReporter testReporter;
	DefaultMarker treasury;
	DefaultMarker agriculture;
	DefaultMarker agricultureException;
	DefaultMarker industry;

	@BeforeEach
	void initialization(TestInfo testInfo, TestReporter testReporter) {
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		treasury = new Treasury(0.5f, 2000);
		agriculture = new Agriculture(0.5f, 100);
		agricultureException = new Agriculture(0.51f, 100);
		industry = new Industry(0.25f);
		testReporter
				.publishEntry(String.format("Testing %s with tags %s", testInfo.getDisplayName(), testInfo.getTags()));
	}

	@Nested
	@DisplayName("Exceptions test cases.")
	@Tag("Exceptions")
	class ExceptionTest {
		@Test
		void testMarkerAccumulationMessageException() {
			String accumulationExceptionMessage = "The accumulation between these two markers is not possible";
			Throwable accumulationException = assertThrows(AccumulationException.class, () -> {
				throw new AccumulationException("The accumulation between these two markers is not possible");
			});
			assertEquals(accumulationExceptionMessage, accumulationException.getMessage(),
					() -> String.format("The %s and %s should be equals.", accumulationExceptionMessage,
							accumulationException.getMessage()));
		}

		@Test
		void testMarkerAccumulationException() {
			assertThrows(AccumulationException.class, () -> treasury.markerAccumulation(agricultureException),
					() -> String.format("An %s should be thrown.", AccumulationException.class));
		}
	}

	@Test
	void testSubClasses() {
		testReporter
				.publishEntry(String.format("Testing %s with tags %s", testInfo.getDisplayName(), testInfo.getTags()));
		assertAll(
				() -> assertTrue(industry instanceof DefaultMarker,
						String.format("%s should be a subclass of %s", industry.getClass().getName(),
								DefaultMarker.class.getName())),
				() -> assertTrue(treasury instanceof DefaultMarker,
						String.format("%s should be a subclass of %s", treasury.getClass().getName(),
								DefaultMarker.class.getName())),
				() -> assertTrue(agriculture instanceof DefaultMarker, String.format("%s should be a subclass of %s",
						agriculture.getClass().getName(), DefaultMarker.class.getName())));
	}
	
	@Test
	void testAggregation() throws AccumulationException {
		assertEquals(treasury.markerAccumulation(agriculture), treasury.getMarkerRate()+agriculture.getMarkerRate());
	}

}
