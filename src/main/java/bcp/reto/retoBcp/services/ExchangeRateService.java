package bcp.reto.retoBcp.services;

import bcp.reto.retoBcp.controller.dto.ExchangeRateResponseWebDto;
import bcp.reto.retoBcp.domain.ExchangeRate;
import bcp.reto.retoBcp.domain.RequestExchangeRate;
import rx.Observable;

/**
 * @author Carlos Lazaro
 * @project reto-bcp
 * */

public interface ExchangeRateService {
   Observable<ExchangeRateResponseWebDto>  ExchangeRate(RequestExchangeRate requestExchangeRate);
   Observable<Boolean> update(ExchangeRate exchangeRate);
}
