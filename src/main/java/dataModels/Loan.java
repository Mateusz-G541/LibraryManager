package dataModels;

import helpers.enums.LoanStatus;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;
@Builder
public class Loan {

    private UUID loanId;
    private UUID borrowedBy;
    private UUID lentBy;
    private LoanStatus loanStatus;
    private LocalDateTime borrowedAt;
    private LocalDateTime returnedAt;
    private LocalDateTime deletedAt;

}
