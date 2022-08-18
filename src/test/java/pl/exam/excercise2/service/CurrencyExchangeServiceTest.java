//package pl.exam.excercise2.service;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import pl.exam.excercise2.controller.CurrencyExchangeController;
//import pl.exam.excercise2.controller.CurrencyJsonController;
//import pl.exam.excercise2.exception.ExchangeRatesApiError;
//
//import java.io.IOException;
//
//import static org.junit.Assert.*;
//
//public class CurrencyExchangeServiceTest {
//    private CurrencyExchangeService currencyExchangeService;
//    private String apiResultOK = "{\"result\": 47.28369}";
//    private String apiResultNok = "{\"error\": {\"code\": \"invalid_from_currency\",\"message\": \"(....)";
//
//    @Mock
//    CurrencyExchangeController currencyExchangeControllerMock;
//
//    @Mock
//    CurrencyJsonController currencyJsonControllerMock;
//
//    @Before
//    public void init() {
//        MockitoAnnotations.openMocks(this);
//       // currencyExchangeService = new CurrencyExchangeService();
//    }
//
////    @Test(expected = ExchangeRatesApiError.class)
////    public void shouldThrowExchangesRatesApiErrorWhenCurrencyIsInvalid() throws IOException {
////        Mockito.when(currencyExchangeControllerMock.getConvertRequest()).thenReturn(apiResultNok);
////
////    }
//
//    @Test
//    public void shouldReturn10WhenExchanging10AmountOfSameCurrency() throws IOException {
//        // CurrencyExchangeService ces = new Currencynew CurrencyExchangeController(), new CurrencyJsonController());
//        //assertEquals(10, ces.exchange("EUR", "EUR", 10), 0.01);
//        // Mockito.when(currencyJsonControllerMock.getResultFromJson(apiResult)).
//    }
//
//}