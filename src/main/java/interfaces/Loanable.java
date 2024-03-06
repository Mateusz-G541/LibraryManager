package interfaces;

import dataModels.Item;
import dataModels.Library;
import dataModels.Loan;
import dataModels.User;

public interface Loanable {
    Loan createLoan(Item item, User borrower, User librarian, Library library);
}
