package com.tw.banking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TransactionTest {

  @Test
  void should_return_1_when_call_compareTo_given_transaction_small() {
    Transaction given = new Transaction("23/02/2018", 1);
    Transaction transaction = new Transaction("23/02/2019", 1);

    int result = transaction.compareTo(given);

    assertEquals(1, result);
  }
}
