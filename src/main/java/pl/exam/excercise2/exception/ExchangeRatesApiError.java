package pl.exam.excercise2.exception;

public class ExchangeRatesApiError extends RuntimeException {

    public ExchangeRatesApiError(String message) {
        super(message);
    }
}
