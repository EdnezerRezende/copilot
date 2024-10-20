package br.gov.ccee.copilot.controller.exceptions;

public class InsufficientFundsException extends RuntimeException  {
    public InsufficientFundsException(final String accountNumber) {
        super("Fundos insuficientes na conta: " + accountNumber);
    }
}
