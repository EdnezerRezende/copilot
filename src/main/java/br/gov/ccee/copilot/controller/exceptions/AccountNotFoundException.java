package br.gov.ccee.copilot.controller.exceptions;

public class AccountNotFoundException extends RuntimeException {

        public AccountNotFoundException(final String accountNumber) {
            super("Conta não encontrada com o número: " + accountNumber);
        }
}
