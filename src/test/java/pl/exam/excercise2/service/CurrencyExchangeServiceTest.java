package pl.exam.excercise2.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import pl.exam.excercise2.controller.CurrencyExchangeController;
import pl.exam.excercise2.controller.CurrencyJsonController;
import pl.exam.excercise2.exception.ExchangeRatesApiError;

import java.io.IOException;

import static org.junit.Assert.*;

public class CurrencyExchangeServiceTest {
    private CurrencyExchangeService currencyExchangeService;
    private String apiResultOK = "{\"result\": 47.28369}";
    private String apiResultNok = "{\"error\": {\"code\": \"invalid_from_currency\",\"message\": \"(....)\"}}";

    @Mock
    private CurrencyExchangeController currencyExchangeControllerMock;



    public CurrencyExchangeServiceTest() {
    }

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
        currencyExchangeService = new CurrencyExchangeService(currencyExchangeControllerMock);
    }

    @Test(expected = ExchangeRatesApiError.class)
    public void shouldThrowExchangesRatesApiErrorWhenResponseHaveErrorMessage() throws IOException {
        Mockito.when(currencyExchangeControllerMock.getConvertRequest()).thenReturn(apiResultNok);
        new CurrencyJsonController(currencyExchangeControllerMock.getConvertRequest()).getResultFromJson();
    }

    @Test(expected = ExchangeRatesApiError.class)
    public void shouldThrowExchangesRatesApiErrorWhenCurrencyIsInvalid() throws IOException {
        currencyExchangeService.exchange("esur", "eur", 10.0);
    }

    @Test
    public void shouldReturn10WhenExchanging10AmountOfSameCurrency() throws IOException {
        double result = currencyExchangeService.exchange("eur", "eur", 10.0);
        assertEquals(10, result, 0.001);
    }

}