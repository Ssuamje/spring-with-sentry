package club.sentry.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SentryTestServiceTest {

	@Autowired
	private SentryTestService sentryTestService;

	@Test
	public void test() {
		sentryTestService.justLog();
		sentryTestService.messageWithEvent();
		sentryTestService.justThrow();
	}
}