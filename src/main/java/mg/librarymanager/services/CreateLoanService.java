package mg.librarymanager.services;

import mg.librarymanager.dataModels.Item;
import mg.librarymanager.dataModels.Library;
import mg.librarymanager.dataModels.Loan;
import mg.librarymanager.dataModels.User;
import mg.librarymanager.enums.LoanStatus;
import mg.librarymanager.interfaces.Loanable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
@Component
public class CreateLoanService implements Loanable {
    @Override
    public Loan createLoan(Item item, User borrower, User librarian, Library library) {
        var loan = Loan.builder()
                .id(UUID.randomUUID())
                .item(item)
                .loanStatus(LoanStatus.ACTIVE)
                .lentBy(librarian.getId())
                .borrowedAt(LocalDateTime.now())
                .borrowedBy(librarian.getId())
                .borrowedBy(borrower.getId())
                .punishmentAmount(BigDecimal.ZERO)
                .build();
        return loan;
    }
}
