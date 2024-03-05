package interfaces;

import dataModels.Item;
import dataModels.User;

public interface Borrowable {

    boolean borrow(User user, User lender, Item item);
}
