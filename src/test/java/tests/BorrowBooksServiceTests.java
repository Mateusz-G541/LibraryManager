package tests;

import dataModels.Book;
import dataModels.Library;
import dataModels.User;
import helpers.enums.UserType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import services.BorrowItemService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class BorrowBooksServiceTests {
    private User librarian;
    private Library library;
    private Book book;

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

    }

    @DisplayName("Test positive borrowing of available book")
    @ParameterizedTest()
    @MethodSource("dataProviders.UsersDataProvider#provideUsersToPositiveBorrowBooks")
    public void shouldBePossibleToBorrowAvailableBooksTest(User expectedUser) {

        BorrowItemService borrowItemService = new BorrowItemService();

        User borrower = expectedUser;

        boolean borrowResult = borrowItemService.borrow(borrower, librarian, book);

        Assertions.assertTrue(borrowResult, String.format("There was an error when borrowing book with id %s by borrower of type %s with id %s and " +
                "it was lending by librarian with id %s", book.getId(), borrower.getId(), borrower.getUserType(), librarian.getId()));

    }

    @Test()
    @DisplayName("Test negative borrowing of book twice")
    public void shouldNotBePossibleToBorrowBookBeforeItIsReturnedTest() {

        BorrowItemService borrowItemService = new BorrowItemService();

        User borrower = User.builder()
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
                .build();

        boolean borrowResult = borrowItemService.borrow(borrower, librarian, book);

        Assertions.assertTrue(borrowResult, String.format("There was an error when borrowing book with id %s by borrower of type %s with id %s and " +
                "it was lending by librarian with id %s", book.getId(), borrower.getId(), borrower.getUserType(), librarian.getId()));

        boolean borrowResultAfter = borrowItemService.borrow(borrower, librarian, book);

        Assertions.assertFalse(borrowResultAfter, "Book with id %s should not be borrowed twice");
    }

    @DisplayName("Test negative borrowing forbidden number of books")
    @ParameterizedTest()
    @MethodSource("dataProviders.UsersDataProvider#provideUsersToNegativeBorrowBooks")
    public void shouldNotBePossibleToBorrowMoreThanDefinedInRequirementsTest(User expectedUser) {

        BorrowItemService borrowItemService = new BorrowItemService();

        User borrower = expectedUser;

        boolean borrowResult = borrowItemService.borrow(borrower, librarian, book);

        Assertions.assertFalse(borrowResult, String.format("Book with id %s should not be borrowed when user with type %s already had %s books borrowed books",
                borrower.getId(), borrower.getUserType().name(), String.valueOf(borrower.getAlreadyBorrowedBooks())));
    }

    @DisplayName("Test negative borrowing forbidden when user is not allowed to borrow a book")
    @ParameterizedTest()
    @MethodSource("dataProviders.UsersDataProvider#provideUsersNotAllowedToBorrowBooks")
    public void shouldNotBePossibleToBorrowWhenUserNotAllowed(User expectedUser) {

        BorrowItemService borrowItemService = new BorrowItemService();

        User borrower = expectedUser;

        boolean borrowResult = borrowItemService.borrow(borrower, librarian, book);

        Assertions.assertFalse(borrowResult, String.format("Book with id %s should not be borrowed when user with type ids is not allowed",
                borrower.getId()));
    }
}
