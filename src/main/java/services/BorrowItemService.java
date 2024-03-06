package services;

import configuration.Config;
import dataModels.Item;
import dataModels.Library;
import dataModels.User;
import helpers.enums.UserType;
import interfaces.Borrowable;

public class BorrowItemService implements Borrowable {

    Config config = Config.getInstance();
    CreateLoanService createLoanService = new CreateLoanService();

    @Override
    public boolean borrowItem(User borrower, User librarian, Item item, Library library) {

        if (borrower.getAlreadyBorrowedBooks() >= Integer.valueOf(config.getProperty("lecturer_limit")) || !item.isAvailable() || !borrower.isAllowedToBorrow()) {
            return false;
        } else if (borrower.getUserType() == UserType.LECTURER && item.isAvailable()) {
            item.setAvailable(false);
            createLoanService.createLoan(item, borrower, librarian, library);
            return true;
        } else if (borrower.getUserType() == UserType.STUDENT
                && item.isAvailable() && borrower.getAlreadyBorrowedBooks()
                < Integer.valueOf(config.getProperty("student_limit"))) {
            item.setAvailable(false);
            createLoanService.createLoan(item, borrower, librarian, library);
            return true;
        } else if (borrower.getUserType() == UserType.OUT_OF_UNIVERSITY
                && item.isAvailable() && borrower.getAlreadyBorrowedBooks() <
                Integer.valueOf(config.getProperty("person_out_of_university_limit"))) {
            item.setAvailable(false);
            createLoanService.createLoan(item, borrower, librarian, library);
            return true;
        } else {
            return false;
        }
    }
}
