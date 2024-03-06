package tests;

import dataModels.Book;
import dataModels.Library;
import dataModels.Loan;
import dataModels.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import services.ReturnItemService;

class ReturnItemServiceTest {

    ReturnItemService returnItemService = new ReturnItemService();

    @DisplayName("Test positive return of book.")
    @ParameterizedTest
    @MethodSource("dataProviders.LoansDataProvider#loanWithPossibleData")
    public void shouldCorrectlyReturnBookTest(Loan loan){
        Assertions.assertTrue(returnItemService.returnItem(loan));
    }

    @DisplayName("Test negative return of loans with loan status different than active.")
    @ParameterizedTest
    @MethodSource("dataProviders.LoansDataProvider#loanWithNotActiveStatus")
    public void shouldNotBePossibleToReturnNotActiveLoanTest(Loan loan){
        Assertions.assertFalse(returnItemService.returnItem(loan));
    }

    @DisplayName("Test negative return of loans with punishment amount bigger than zero.")
    @ParameterizedTest
    @MethodSource("dataProviders.LoansDataProvider#loanWithPunishment")
    public void shouldNotBePossibleToReturnBookWithActivePunishmentTest(Loan loan){
        Assertions.assertFalse(returnItemService.returnItem(loan));
    }




}