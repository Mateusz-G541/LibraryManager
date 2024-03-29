package mg.librarymanager.dataModels;

import mg.librarymanager.enums.LoanStatus;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
@Builder
@Getter
public class Loan {

    private UUID id;
    private UUID borrowedBy;
    private Item item;
    private UUID lentBy;
    private LoanStatus loanStatus;
    private LocalDateTime borrowedAt;
    private LocalDateTime returnedAt;
    private LocalDateTime deletedAt;
    private BigDecimal punishmentAmount;
    private Library library;

    public Optional<BigDecimal> getPunishmentAmount() {
        return Optional.ofNullable(punishmentAmount);
    }
}
