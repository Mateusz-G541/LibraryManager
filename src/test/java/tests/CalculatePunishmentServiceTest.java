package tests;

import mg.librarymanager.dataModels.Book;
import mg.librarymanager.dataModels.Library;
import mg.librarymanager.dataModels.Loan;
import mg.librarymanager.dataModels.User;
import mg.librarymanager.enums.LoanStatus;
import mg.librarymanager.enums.UserType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import mg.librarymanager.services.CalculatePunishmentService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class CalculatePunishmentServiceTest {
    private User librarian;
    private User borrower;
    private Library library;
    private Book book;
    private Loan loan;
    private CalculatePunishmentService calculatePunishmentService = new CalculatePunishmentService();

    @BeforeEach
    public void setup() {
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

        borrower = User.builder()
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
                .build();
    }

    @Test
    public void punishmentShouldBeEqualToZeroWhenItemReturnedBefore31DaysTest() {
        loan = Loan.builder()
                .id(UUID.randomUUID())
                .lentBy(librarian.getId())
                .borrowedBy(borrower.getId())
                .item(book)
                .loanStatus(LoanStatus.ACTIVE)
                .borrowedAt(LocalDateTime.now().minusDays(30))
                .returnedAt(LocalDateTime.now())
                .build();

        Assertions.assertEquals(BigDecimal.ZERO, calculatePunishmentService.calculatePunishmentAmount(loan));
    }

    @Test
    public void checkPunishmentWhenBetween31And180DaysTest() {
        loan = Loan.builder()
                .id(UUID.randomUUID())
                .lentBy(librarian.getId())
                .borrowedBy(borrower.getId())
                .item(book)
                .loanStatus(LoanStatus.ACTIVE)
                .borrowedAt(LocalDateTime.now().minusDays(30))
                .returnedAt(LocalDateTime.now())
                .build();

        Assertions.assertEquals(BigDecimal.ZERO, calculatePunishmentService.calculatePunishmentAmount(loan));
    }
}
