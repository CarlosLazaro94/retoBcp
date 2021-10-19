package bcp.reto.retoBcp.repository;

import bcp.reto.retoBcp.domain.ExchangeRate;

import java.util.List;

/**
 * @author Carlos Lazaro
 * @project reto-bcp
 * */

public interface ExchangeRateRepository {

    List<ExchangeRate> getAllExchangeRate();

    String updateExchangeRate(ExchangeRate coin);

}
