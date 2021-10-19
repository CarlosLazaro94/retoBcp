package bcp.reto.retoBcp.services;

import bcp.reto.retoBcp.controller.dto.ExchangeRateResponseWebDto;
import bcp.reto.retoBcp.domain.ExchangeRate;
import bcp.reto.retoBcp.domain.RequestExchangeRate;
import bcp.reto.retoBcp.domain.ResponseExchangeRate;
import bcp.reto.retoBcp.repository.ExchangeRateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rx.Observable;

/**
 * @author Carlos Lazaro
 * @project reto-bcp
 * */

@Service
@AllArgsConstructor
public class ExchangeRateServiceImpl implements ExchangeRateService{

    private final ExchangeRateRepository exchangeRateRepository;

    @Override
    public Observable<ExchangeRateResponseWebDto> ExchangeRate(RequestExchangeRate requestExchangeRate) {

         Observable<ExchangeRate> result = Observable.from(exchangeRateRepository.getAllExchangeRate())
                .filter(item-> item.getOriginCoin().equals(requestExchangeRate.getOriginCoin().toUpperCase())
                        && item.getDestinyCoin().equals(requestExchangeRate.getDestinyCoin().toUpperCase()));

         return result.map( item -> {
             ResponseExchangeRate response = new ResponseExchangeRate();
             response.setExchangeRate(item.getValue());
             response.setAmount(requestExchangeRate.getAmount());
             response.setOriginCoin(item.getOriginCoin());
             response.setDestinyCoin(item.getDestinyCoin());
             response.setAmountExchangeRate(calculateAmountExchangeRate(requestExchangeRate.getAmount(),item.getValue()));
             ExchangeRateResponseWebDto rateResponseWebDto = new ExchangeRateResponseWebDto();
             rateResponseWebDto.setExchangeRate(response);
             return rateResponseWebDto;
         });
    }

    private static String calculateAmountExchangeRate(String amount, String rate){
        double operation = Double.parseDouble(amount) * Double.parseDouble(rate);
        return Double.toString(operation);
    }


    @Override
    public Observable<Boolean> update(ExchangeRate exchangeRate) {
        Observable<String> result = Observable.just(exchangeRateRepository.updateExchangeRate(exchangeRate));
        return result.map(item -> {
                    if(item.equals("0")){
                        return false;
                    }
                    return !item.isEmpty();
                })
                .doOnError(throwable -> { throw new RuntimeException("unexcepted");});
    }
}
