package tests;

import dataModels.Book;
import dataModels.Library;
import dataModels.User;
import helpers.enums.LoanStatus;
import helpers.enums.UserType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import services.CreateLoanService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class CreateLoanServiceTest {
    private User librarian;
    private User borrower;
    private Library library;
    private Book book;
    CreateLoanService createLoanService;

    @BeforeEach
    public void setup() {
        createLoanService = new CreateLoanService();

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

    @DisplayName("Test check that is loan correctly created with all valid data.")
    @Test
    public void shouldCorrectlyCreateLoanWithValidDataTest() {
        var loan = createLoanService.createLoan(book, borrower, librarian, library);

        Assertions.assertEquals(loan.getLoanStatus(), LoanStatus.ACTIVE);
        Assertions.assertEquals(loan.getItem(), book);
        Assertions.assertEquals(loan.getLentBy(), librarian.getId());
        Assertions.assertEquals(loan.getBorrowedBy(), borrower.getId());
    }

}
