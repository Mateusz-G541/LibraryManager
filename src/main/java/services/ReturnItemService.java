package services;

import configuration.Config;
import dataModels.Loan;
import helpers.enums.LoanStatus;
import interfaces.Returnable;

import java.math.BigDecimal;

public class ReturnItemService implements Returnable {

    @Override
    public boolean returnItem(Loan loan) {
        if (loan.getLoanStatus() != LoanStatus.ACTIVE ||
                (loan.getPunishmentAmount().orElse(BigDecimal.ZERO)
                        .compareTo(BigDecimal.ZERO) > 0)) {
            return false;
        } else {
            return true;
        }
    }
}
