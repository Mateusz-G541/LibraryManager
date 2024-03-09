package mg.librarymanager.interfaces;

import mg.librarymanager.dataModels.Loan;

public interface Returnable {
    boolean returnItem(Loan loan);
}
