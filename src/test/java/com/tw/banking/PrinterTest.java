package com.tw.banking;

import static com.tw.banking.Printer.STATEMENT_HEADER;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

class PrinterTest {

  @Test
  void should_print_statement_header_when_call_print_given_anyTransactions() {
    Console spyConsole = mock(Console.class);
    Printer printer = new Printer(spyConsole);

    printer.print(anyList());

    verify(spyConsole, times(1)).printLine(STATEMENT_HEADER);
  }

}
