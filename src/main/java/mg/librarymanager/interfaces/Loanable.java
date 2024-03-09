package mg.librarymanager.interfaces;

import mg.librarymanager.dataModels.Item;
import mg.librarymanager.dataModels.Library;
import mg.librarymanager.dataModels.Loan;
import mg.librarymanager.dataModels.User;

public interface Loanable {
    Loan createLoan(Item item, User borrower, User librarian, Library library);
}
