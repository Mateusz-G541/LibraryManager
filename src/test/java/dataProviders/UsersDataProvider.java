package dataProviders;

import dataModels.User;
import helpers.enums.UserType;

import java.time.LocalDate;
import java.util.UUID;
import java.util.stream.Stream;

public class UsersDataProvider {

    public static Stream<User> provideUsersToPositiveBorrowBooks() {
        return Stream.of(
                User.builder()
                        .id(UUID.randomUUID())
                        .firstName("John")
                        .lastName("Doe")
                        .pesel("1234567890")
                        .address("123 Main St")
                        .postalCode("12345")
                        .userType(UserType.STUDENT)
                        .alreadyBorrowedBooks(1)
                        .birthDate(LocalDate.of(1999, 1, 1))
                        .build(),
                User.builder()
                        .id(UUID.randomUUID())
                        .firstName("John")
                        .lastName("Doe")
                        .pesel("1234567890")
                        .address("123 Main St")
                        .postalCode("12345")
                        .userType(UserType.LECTURER)
                        .alreadyBorrowedBooks(10)
                        .birthDate(LocalDate.of(1979, 1, 1))
                        .build(),
                User.builder()
                        .id(UUID.randomUUID())
                        .firstName("John")
                        .lastName("Doe")
                        .pesel("1234567890")
                        .address("123 Main St")
                        .postalCode("12345")
                        .userType(UserType.OUT_OF_UNIVERSITY)
                        .alreadyBorrowedBooks(1)
                        .birthDate(LocalDate.of(1999, 1, 1))
                        .build()

        );
    }

    public static Stream<User> provideUsersToNegativeBorrowBooks() {
        return Stream.of(
                User.builder()
                        .id(UUID.randomUUID())
                        .firstName("John")
                        .lastName("Doe")
                        .pesel("1234567890")
                        .address("123 Main St")
                        .postalCode("12345")
                        .userType(UserType.STUDENT)
                        .alreadyBorrowedBooks(7)
                        .birthDate(LocalDate.of(1999, 1, 1))
                        .build(),
                User.builder()
                        .id(UUID.randomUUID())
                        .firstName("John")
                        .lastName("Doe")
                        .pesel("1234567890")
                        .address("123 Main St")
                        .postalCode("12345")
                        .userType(UserType.LECTURER)
                        .alreadyBorrowedBooks(14)
                        .birthDate(LocalDate.of(1979, 1, 1))
                        .build(),
                User.builder()
                        .id(UUID.randomUUID())
                        .firstName("John")
                        .lastName("Doe")
                        .pesel("1234567890")
                        .address("123 Main St")
                        .postalCode("12345")
                        .userType(UserType.OUT_OF_UNIVERSITY)
                        .alreadyBorrowedBooks(4)
                        .birthDate(LocalDate.of(1999, 1, 1))
                        .build()

        );
    }
}
