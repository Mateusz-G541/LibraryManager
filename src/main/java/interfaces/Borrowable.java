package interfaces;

import dataModels.Item;
import dataModels.Library;
import dataModels.User;

public interface Borrowable {

    boolean borrowItem(User user, User lender, Item item, Library library);
}
