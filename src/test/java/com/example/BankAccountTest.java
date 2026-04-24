package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount account;

    @Test
    void testCreateBankAccount() {
        account = new BankAccount();
        assertNotNull(account);
    }

    @Test
    void testInitBankAccountWithZeroBalance() {
        BankAccount bankAccount = new BankAccount();
        assertEquals(0 ,bankAccount.getAmount());
    }

    @Test
    void testAfterInitBankAccountIsIdentical() {
        BankAccount bankAccount = new BankAccount();
        assertNotNull(bankAccount.getId());
    }

    @Test
    void testTwoAccountsHasDifferentId() {
        BankAccount bankAccount1 = new BankAccount();
        BankAccount bankAccount2 = new BankAccount();
        assertNotEquals(bankAccount1.getId(), bankAccount2.getId());
    }
}