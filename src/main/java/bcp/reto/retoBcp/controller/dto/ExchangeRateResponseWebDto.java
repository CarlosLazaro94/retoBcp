package bcp.reto.retoBcp.controller.dto;

import bcp.reto.retoBcp.domain.ResponseExchangeRate;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

/**
 * @author Carlos Lazaro
 * @project reto-bcp
 * */

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExchangeRateResponseWebDto extends RepresentationModel<ExchangeRateResponseWebDto> implements Serializable {
    private static final long serialVersionUID = 1L;
    private ResponseExchangeRate exchangeRate;
}
