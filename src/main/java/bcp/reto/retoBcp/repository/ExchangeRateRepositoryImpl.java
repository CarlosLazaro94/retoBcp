package bcp.reto.retoBcp.repository;

import bcp.reto.retoBcp.domain.ExchangeRate;
import bcp.reto.retoBcp.repository.rowMapper.ExchangeRateRowMapper;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Carlos Lazaro
 * @project reto-bcp
 * */

@Repository
@AllArgsConstructor
public class ExchangeRateRepositoryImpl implements ExchangeRateRepository {
     private final JdbcTemplate template;
     private final ExchangeRateRowMapper exchangeRateRowMapper;
     private static final String FIND_ALL_EXCHANGE_COIN = "SELECT * FROM ExchangeRate WHERE status = '1'";
     private static final String UPDATE_EXCHANGE_COIN = "UPDATE ExchangeRate SET originCoin = ? , destinyCoin = ? , value = ?, status = ? WHERE id = ?";


    @Override
    public List<ExchangeRate> getAllExchangeRate() {
        return template.query(FIND_ALL_EXCHANGE_COIN, exchangeRateRowMapper);
    }

    @Override
    public String updateExchangeRate(ExchangeRate coin) {
        int update = template.update(UPDATE_EXCHANGE_COIN,
                coin.getOriginCoin(),
                coin.getDestinyCoin(),
                coin.getValue(),
                coin.getStatus(),
                coin.getId()
        );
        return String.valueOf(update);
    }
}
