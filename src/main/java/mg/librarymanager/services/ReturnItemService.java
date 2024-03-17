package mg.librarymanager.services;

import mg.librarymanager.dataModels.Loan;
import mg.librarymanager.enums.LoanStatus;
import mg.librarymanager.interfaces.Returnable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Component
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
