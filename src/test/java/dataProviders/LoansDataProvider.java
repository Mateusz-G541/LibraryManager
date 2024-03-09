package dataProviders;

import mg.librarymanager.dataModels.Book;
import mg.librarymanager.dataModels.Library;
import mg.librarymanager.dataModels.Loan;
import mg.librarymanager.dataModels.User;
import mg.librarymanager.enums.LoanStatus;
import mg.librarymanager.enums.UserType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.stream.Stream;

public class LoansDataProvider {

    static User librarian;
    static User borrower;
    static Library library;
    static Book book;

    static {
        librarian = User.builder()
                .id(UUID.randomUUID())
                .firstName("John")
                .lastName("Doe")
                .pesel("1234567890")
                .address("123 Main St")
                .postalCode("12345")
                .userType(UserType.LIBRARIAN)
                .birthDate(LocalDate.of(1980, 1, 1))
                .build();

        borrower = User.builder()
                .id(UUID.randomUUID())
                .firstName("John")
                .lastName("Doe")
                .pesel("1234567890")
                .address("123 Main St")
                .postalCode("12345")
                .userType(UserType.STUDENT)
                .birthDate(LocalDate.of(1970, 1, 1))
                .build();

        library = Library.builder()
                .id(UUID.randomUUID())
                .address("Kraków, Lipska 49/21")
                .build();

        book = Book.builder()
                .id(UUID.randomUUID())
                .rating(BigDecimal.ZERO)
                .title("W pustyni i w puszczy")
                .author("Henryk Sienkiewicz")
                .location(library.getId())
                .isAvailable(true)
                .build();
    }


    public static Stream<Loan> loanWithNotActiveStatus() {
        return Stream.of(
                Loan.builder()
                        .id(UUID.randomUUID())
                        .borrowedBy(borrower.getId())
                        .lentBy(librarian.getId())
                        .item(book)
                        .loanStatus(LoanStatus.DELETED)
                        .borrowedAt(LocalDateTime.now())
                        .build(),
                Loan.builder()
                        .id(UUID.randomUUID())
                        .borrowedBy(borrower.getId())
                        .lentBy(librarian.getId())
                        .item(book)
                        .loanStatus(LoanStatus.LOST)
                        .borrowedAt(LocalDateTime.now())
                        .build(),
                Loan.builder()
                        .id(UUID.randomUUID())
                        .borrowedBy(borrower.getId())
                        .lentBy(librarian.getId())
                        .item(book)
                        .loanStatus(LoanStatus.INACTIVE)
                        .borrowedAt(LocalDateTime.now())
                        .build()

        );
    }

    public static Stream<Loan> loanWithPunishment() {
        return Stream.of(
                Loan.builder()
                        .id(UUID.randomUUID())
                        .borrowedBy(borrower.getId())
                        .lentBy(librarian.getId())
                        .item(book)
                        .loanStatus(LoanStatus.ACTIVE)
                        .punishmentAmount(BigDecimal.ONE)
                        .borrowedAt(LocalDateTime.now())
                        .build()

        );
    }

    public static Stream<Loan> loanWithPossibleData() {
        return Stream.of(
                Loan.builder()
                        .id(UUID.randomUUID())
                        .borrowedBy(borrower.getId())
                        .lentBy(librarian.getId())
                        .item(book)
                        .loanStatus(LoanStatus.ACTIVE)
                        .borrowedAt(LocalDateTime.now())
                        .build()

        );
    }
}
