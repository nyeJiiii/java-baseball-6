package baseball;

import static baseball.ErrorMessage.ERROR_WRONG_SELECTED_VALUE;
import static baseball.ErrorMessage.ERROR_WRONG_USER_NUMBER;

public class CheckException {
    private final String RIGHT_USER_NUMBER = "([1-9])(?!\\1)([1-9])(?!\\1|\\2)([1-9])";
    private final String RIGHT_SELECTED_VALUE = "[12]";

    public void checkWrongUserNumberException(String st) {
        if (!st.matches(RIGHT_USER_NUMBER)) {
            throw new IllegalArgumentException(ERROR_WRONG_USER_NUMBER);
        }
    }

    public void checkWrongSelectedValueException(String st) {
        if (!st.matches(RIGHT_SELECTED_VALUE)) {
            throw new IllegalArgumentException(ERROR_WRONG_SELECTED_VALUE);
        }
    }
}
