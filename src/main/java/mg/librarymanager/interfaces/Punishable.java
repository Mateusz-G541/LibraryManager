package mg.librarymanager.interfaces;

import mg.librarymanager.dataModels.Loan;

import java.math.BigDecimal;

public interface Punishable {

    BigDecimal calculatePunishmentAmount(Loan loan);
}
