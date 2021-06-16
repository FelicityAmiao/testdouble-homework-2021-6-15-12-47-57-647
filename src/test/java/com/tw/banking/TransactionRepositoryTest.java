package com.tw.banking;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.Test;

class TransactionRepositoryTest {

  @Test
  void should_cannot_change_returned_transactions_when_call_allTransactions() {
    Clock dummyClock = mock(Clock.class);
    TransactionRepository transactionRepository = new TransactionRepository(dummyClock);

    List<Transaction> transactions = transactionRepository.allTransactions();
    assertThrows(UnsupportedOperationException.class, () -> {
      transactions.add(new Transaction("23/03/2018", 1));
    });
  }

  @Test
  void should_add_one_transaction_with_currentDate_and_amount_when_call_addDeposit_given_amount() {
    Clock stubClock = mock(Clock.class);
    TransactionRepository transactionRepository = new TransactionRepository(stubClock);
    when(stubClock.todayAsString()).thenReturn("16/06/2021");

    transactionRepository.addDeposit(1);

    List<Transaction> result = transactionRepository.allTransactions();
    assertEquals("16/06/2021", result.get(0).date());
    assertEquals(1, result.get(0).amount());
  }
}
