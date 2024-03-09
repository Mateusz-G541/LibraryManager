package mg.librarymanager.services;

import mg.librarymanager.configuration.Config;
import mg.librarymanager.dataModels.Loan;
import mg.librarymanager.interfaces.Punishable;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;

public class CalculatePunishmentService implements Punishable {

    @Override
    public BigDecimal calculatePunishmentAmount(Loan loan) {
        var daysFromBorrowToReturn = loan.getReturnedAt().until(loan.getBorrowedAt(), ChronoUnit.DAYS);

        if (daysFromBorrowToReturn < Config.getInstance().gerLowerDaysLimitToPunishment()) {
            return BigDecimal.ZERO;
        } else if (daysFromBorrowToReturn >= 30 || daysFromBorrowToReturn <= Config.getInstance().gerHigherDaysLimitToPunishment()) {
            return BigDecimal.valueOf(daysFromBorrowToReturn).multiply(
                    Config.getLowerValueDailyPunishment());

        } else {
            return BigDecimal.valueOf(daysFromBorrowToReturn).multiply(
                    Config.getHigherValueDailyPunishment());
        }
    }
}
