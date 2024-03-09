package dataProviders;

import mg.librarymanager.dataModels.User;
import mg.librarymanager.enums.UserType;

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
                        .isAllowedToBorrow(true)
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
                        .isAllowedToBorrow(true)
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
                        .isAllowedToBorrow(true)
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
                        .isAllowedToBorrow(true)
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
                        .isAllowedToBorrow(true)
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
                        .isAllowedToBorrow(true)
                        .birthDate(LocalDate.of(1999, 1, 1))
                        .build()

        );
    }

    public static Stream<User> provideUsersNotAllowedToBorrowBooks() {
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
                        .isAllowedToBorrow(false)
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
                        .isAllowedToBorrow(false)
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
                        .isAllowedToBorrow(false)
                        .birthDate(LocalDate.of(1999, 1, 1))
                        .build()

        );
    }
}
