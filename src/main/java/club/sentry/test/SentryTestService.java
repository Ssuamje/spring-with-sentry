package club.sentry.test;

import io.sentry.Sentry;
import io.sentry.SentryEvent;
import io.sentry.SentryLevel;
import io.sentry.protocol.Message;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SentryTestService {

	public void justLog() {
		log.info("This is a test log message");
	}


	public void messageWithEvent() {
		Message message = new Message();
		message.setMessage("This is a test warning message");

		SentryEvent event = new SentryEvent();
		event.setTag("test_id", UUID.randomUUID().toString());
		event.setLevel(SentryLevel.WARNING);
		event.setMessage(message);

		Sentry.captureEvent(event);
	}

	public void justThrow() {
		try {
			throw new RuntimeException("This is a test exception");
		} catch (Exception e) {
			Sentry.captureException(e);
		}
	}
}