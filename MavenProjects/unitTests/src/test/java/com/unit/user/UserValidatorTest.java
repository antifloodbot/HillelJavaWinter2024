package com.unit.user;

import com.unit.user.exceptions.AgeException;
import com.unit.user.exceptions.EmailException;
import com.unit.user.exceptions.PhoneValidationException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("User validator test")
class UserValidatorTest {
    private User user;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("--> before all method");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("---->> after all method");
    }

    @BeforeEach
    public void beforeEach() {
        user = new User()
                .setName("alex")
                .setAge(18)
                .setEmail("email@test.com")
                .setPhone("+38050...");
        System.out.println("---->> before each method");
    }

    @AfterEach
    public void afterAEach() {
        System.out.println("---->> after each method");
    }

    @DisplayName("correct behaviour")
    @RepeatedTest(value = 10, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    void validate_noException() {
        assertDoesNotThrow(() -> {
            new UserValidator().validate(user);
        });

    }

    @DisplayName("age exception")
    @Test
    void validate_AgeException() {
        user.setAge(10);
        assertThrows(AgeException.class, () -> {
            new UserValidator().validate(user);
        });
    }

    @DisplayName("email exception")
    @Test
    void validate_EmailEcxeption() {
        user.setEmail("email");
        assertThrows(EmailException.class, () -> {
            new UserValidator().validate(user);
        });
    }

    @DisplayName("phone exception")
    @Test
    void validate_PhoneException() {
        user.setPhone("1234567");
        assertThrows(PhoneValidationException.class, () -> {
            new UserValidator().validate(user);
        });
    }

    @Test
    void valid() {
        assertDoesNotThrow(() -> {
            new UserValidator().validate(user);
        });
    }

    @ParameterizedTest
    @MethodSource("generator")
    void exceptionValidation(User user) {
        assertThrows(RuntimeException.class, () -> {
            new UserValidator().validate(user);
        });
    }

    private static Stream<User> generator() {
        return Stream.of(
                new User().setName("alex").setAge(10).setEmail("email@test.com").setPhone("+38050..."),
                new User().setName("alex").setAge(18).setEmail("emailtest.com").setPhone("+38050..."),
                new User().setName("alex").setAge(18).setEmail("email@test.com").setPhone("38050...")
        );
    }
}