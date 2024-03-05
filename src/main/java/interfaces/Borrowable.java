package interfaces;

import dataModels.Item;
import dataModels.User;

import java.util.UUID;

public interface Borrowable {

    public boolean borrow(User user, User lender, Item item);
}
