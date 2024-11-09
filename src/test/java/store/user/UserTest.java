package store.user;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import store.domain.User;

public class UserTest {
    @Test
    @DisplayName("올바른 구매 입력이 입력되었다.")
    public void testValidBuyingInput() {
        String buyingInput = "[사이다-2],[감자칩-1]";
        User user = new User(buyingInput);
        assertTrue(user.isValidString(buyingInput));
    }

    @ParameterizedTest
    @ValueSource(strings = {"[사이다-2", "[사이다-2],[chips-1]", "[사이다-a]", "[-2]"})
    @DisplayName("올바르지 않은 구매 입력이 입력되었다.")
    public void testInvalidBuyingInput(String invalidBuyingInputs) {
        User user = new User();

        assertThrows(IllegalArgumentException.class, () -> {
            user.isValidString(invalidBuyingInputs);
        });
    }
}
