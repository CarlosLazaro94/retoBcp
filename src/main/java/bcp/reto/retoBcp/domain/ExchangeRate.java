package bcp.reto.retoBcp.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Carlos Lazaro
 * @project reto-bcp
 * */

@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExchangeRate implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String originCoin;
    private String destinyCoin;
    private String value;
    private String status;
}
