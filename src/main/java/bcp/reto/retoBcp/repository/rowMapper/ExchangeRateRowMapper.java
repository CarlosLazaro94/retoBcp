package bcp.reto.retoBcp.repository.rowMapper;

import bcp.reto.retoBcp.domain.ExchangeRate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Carlos Lazaro
 * @project reto-bcp
 * */

@Component
public class ExchangeRateRowMapper implements RowMapper<ExchangeRate> {
    @Override
    public ExchangeRate mapRow(ResultSet rs, int rowNum) throws SQLException {
        return ExchangeRate.builder()
                .id(rs.getString("id"))
                .originCoin(rs.getString("originCoin"))
                .destinyCoin(rs.getString("destinyCoin"))
                .value(rs.getString("value"))
                .status(rs.getString("status"))
                .build();
    }
}
