import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTest {

    private static final Logger log = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    void loggerTest() {
        log.debug("Debug test message");
        log.info("Info test message");
        log.warn("Warning test message");
        log.error("Error test message");
    }
}
