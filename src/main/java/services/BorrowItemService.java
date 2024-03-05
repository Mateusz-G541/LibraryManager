package services;

import dataModels.Item;
import dataModels.User;
import helpers.enums.UserType;
import interfaces.Borrowable;

public class BorrowItemService implements Borrowable {
    @Override
    public boolean borrow(User user, User lender, Item item) {

        if (user.getAlreadyBorrowedBooks() >= 14 || item.isAvailable() != true || user.isAllowedToBorrow() != true) {
            return false;
        } else if (user.getUserType() == UserType.LECTURER && item.isAvailable()) {
            item.setAvailable(false);
            return true;
        } else if (user.getUserType() == UserType.STUDENT && item.isAvailable() && user.getAlreadyBorrowedBooks() < 7) {
            item.setAvailable(false);
            return true;
        } else if (user.getUserType() == UserType.OUT_OF_UNIVERSITY && item.isAvailable() && user.getAlreadyBorrowedBooks() < 4) {
            item.setAvailable(false);
            return true;
        } else {
            return false;
        }
    }
}
