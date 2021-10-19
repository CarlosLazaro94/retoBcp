package bcp.reto.retoBcp.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Carlos Lazaro
 * @project reto-bcp
 * */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestExchangeRate implements Serializable {
        private static final long serialVersionUID = 1L;
        private String amount;
        private String originCoin;
        private String destinyCoin;
}
