package com.tw.banking;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

class AccountTest {

  @Test
  void should_invoke_addDeposit_amount_1_when_call_deposit_given_amount_1() {
    TransactionRepository spyTransactionRepository = mock(TransactionRepository.class);
    Account account = new Account(spyTransactionRepository, mock(Printer.class));

    account.deposit(1);

    verify(spyTransactionRepository, times(1)).addDeposit(1);
  }
}
