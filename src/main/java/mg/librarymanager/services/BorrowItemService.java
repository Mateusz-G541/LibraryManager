package mg.librarymanager.services;

import mg.librarymanager.configuration.Config;
import mg.librarymanager.dataModels.Item;
import mg.librarymanager.dataModels.Library;
import mg.librarymanager.dataModels.User;
import mg.librarymanager.enums.UserType;
import mg.librarymanager.interfaces.Borrowable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class BorrowItemService implements Borrowable {

    private Config config = Config.getInstance();
    private CreateLoanService createLoanService = new CreateLoanService();

    @Override
    public boolean borrowItem(User borrower, User librarian, Item item, Library library) {

        if (generalLimitsReached(borrower, item)) {
            return false;
        } else if (borrower.getUserType().equals(UserType.LECTURER)) {
            item.setAvailable(false);
            createLoanService.createLoan(item, borrower, librarian, library);
            return true;
        } else if (isStudentLimitAvaliable(borrower, item)) {
            item.setAvailable(false);
            createLoanService.createLoan(item, borrower, librarian, library);
            return true;
        } else if (isPersonOutOfUniversityLimitAvaliable(borrower, item)) {
            item.setAvailable(false);
            createLoanService.createLoan(item, borrower, librarian, library);
            return true;
        } else {
            return false;
        }
    }

    private boolean isPersonOutOfUniversityLimitAvaliable(User borrower, Item item) {
        return borrower.getUserType() == UserType.OUT_OF_UNIVERSITY
                && borrower.getAlreadyBorrowedBooks() <
                Integer.valueOf(config.getPersonOutOfUniversityLimit());
    }

    private boolean isStudentLimitAvaliable(User borrower, Item item) {
        return borrower.getUserType() == UserType.STUDENT
                && borrower.getAlreadyBorrowedBooks()
                < Integer.valueOf(config.getStudentLimit());
    }

    private boolean generalLimitsReached(User borrower, Item item) {
        return borrower.getAlreadyBorrowedBooks() >= Integer.valueOf(config.getLecturerLimit())
                || !item.isAvailable() || !borrower.isAllowedToBorrow();
    }
}
