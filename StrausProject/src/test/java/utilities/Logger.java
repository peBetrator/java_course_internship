package utilities;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.slf4j.LoggerFactory;

public class Logger {
    private static final String MESSAGE_EXPECTED_ACTUAL = "%s%s - [ EXPECTED]: %s%s - [ ACTUAL  ]: %s";

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(Logger.class);

    public static <T> void assertThat(String message, T actual, Matcher<T> matcher) {
        String fullMessage = "Assert that " + message;
        String logMessage = String.format(MESSAGE_EXPECTED_ACTUAL, fullMessage, System.lineSeparator(), matcher.toString(), System.lineSeparator(), actual);

        try {
            MatcherAssert.assertThat(fullMessage, actual, matcher);
            logger.info(logMessage);
        } catch (AssertionError error) {
            logger.error(logMessage);
            throw new AssertionError(error.getMessage());
        }
    }
}