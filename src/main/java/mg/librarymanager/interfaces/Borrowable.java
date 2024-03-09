package mg.librarymanager.interfaces;

import mg.librarymanager.dataModels.Item;
import mg.librarymanager.dataModels.Library;
import mg.librarymanager.dataModels.User;

public interface Borrowable {

    boolean borrowItem(User user, User lender, Item item, Library library);
}
