package interfaces;

import dataModels.Item;
import dataModels.Loan;
import dataModels.User;

public interface Returnable {
    boolean returnItem(Loan loan);
}
