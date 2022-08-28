package pl.exam.exercise2.controller;

import org.junit.Before;
import org.junit.Test;
import pl.exam.exercise2.configuration.Configuration;

import java.io.IOException;

import static org.junit.Assert.*;

public class CurrencyExchangeControllerTest {

    private CurrencyExchangeController currencyExchangeController;

    @Before
    public void init() {
        Configuration configuration = new Configuration();
        currencyExchangeController = new CurrencyExchangeController(configuration);
    }

    @Test
    public void responseFromApiShouldBeNotNull() throws IOException {
        assertNotNull(currencyExchangeController.getConvertRequest("pln", "eur", 10));
    }


}