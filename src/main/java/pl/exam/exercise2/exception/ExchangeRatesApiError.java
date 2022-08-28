package pl.exam.exercise2.exception;

public class ExchangeRatesApiError extends RuntimeException {

    public ExchangeRatesApiError(String message) {
        super(message);
    }
}
