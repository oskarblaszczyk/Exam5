package pl.exam.exercise2.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import pl.exam.exercise2.controller.CurrencyExchangeController;
import pl.exam.exercise2.exception.ExchangeRatesApiError;

import java.io.IOException;

import static org.junit.Assert.*;

public class CurrencyExchangeServiceTest {
    private CurrencyExchangeService currencyExchangeService;

    @Mock
    private CurrencyExchangeController currencyExchangeControllerMock;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
        currencyExchangeService = new CurrencyExchangeService(currencyExchangeControllerMock, new ObjectMapper());
    }

    @Test(expected = ExchangeRatesApiError.class)
    public void shouldThrowExchangesRatesApiErrorWhenResponseHaveErrorMessage() throws IOException {
        String apiResultNok = "{\"error\": {\"code\": \"invalid_from_currency\",\"message\": \"(....)\"}}";
        Mockito.when(currencyExchangeControllerMock.getConvertRequest(Mockito.anyString(), Mockito.anyString(), Mockito.anyDouble())).thenReturn(apiResultNok);
        currencyExchangeService.exchange(Mockito.anyString(), Mockito.anyString(), Mockito.anyDouble());
    }


    @Test
    public void shouldReturn10WhenExchanging10AmountOfSameCurrency() throws IOException {
        String apiResultOK = "{\"result\": 47.28369}";
        Mockito.when(currencyExchangeControllerMock.getConvertRequest(Mockito.anyString(), Mockito.anyString(), Mockito.anyDouble())).thenReturn(apiResultOK);
        double result = currencyExchangeService.exchange(Mockito.anyString(), Mockito.anyString(), Mockito.anyDouble());
        assertEquals(47.28369, result, 0.001);

    }

}