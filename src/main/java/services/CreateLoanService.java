package services;

import dataModels.Item;
import dataModels.Library;
import dataModels.Loan;
import dataModels.User;
import helpers.enums.LoanStatus;
import interfaces.Loanable;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

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
