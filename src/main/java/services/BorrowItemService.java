package services;

import configuration.Config;
import dataModels.Item;
import dataModels.User;
import helpers.enums.UserType;
import interfaces.Borrowable;

public class BorrowItemService implements Borrowable {

    Config config = Config.getInstance();

    @Override
    public boolean borrowItem(User user, User lender, Item item) {

        if (user.getAlreadyBorrowedBooks() >= Integer.valueOf(config.getProperty("lecturer_limit")) || !item.isAvailable() || !user.isAllowedToBorrow()) {
            return false;
        } else if (user.getUserType() == UserType.LECTURER && item.isAvailable()) {
            item.setAvailable(false);
            return true;
        } else if (user.getUserType() == UserType.STUDENT
                && item.isAvailable() && user.getAlreadyBorrowedBooks()
                < Integer.valueOf(config.getProperty("student_limit"))) {
            item.setAvailable(false);
            return true;
        } else if (user.getUserType() == UserType.OUT_OF_UNIVERSITY
                && item.isAvailable() && user.getAlreadyBorrowedBooks() <
                Integer.valueOf(config.getProperty("person_out_of_university_limit"))) {
            item.setAvailable(false);
            return true;
        } else {
            return false;
        }
    }
}
