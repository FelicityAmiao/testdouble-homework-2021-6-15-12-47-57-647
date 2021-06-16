package com.tw.banking;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

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
}
