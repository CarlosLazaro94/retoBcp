package bcp.reto.retoBcp.controller;

import bcp.reto.retoBcp.Utils.JwtUtils;
import bcp.reto.retoBcp.controller.dto.ExchangeRateResponseWebDto;
import bcp.reto.retoBcp.domain.ExchangeRate;
import bcp.reto.retoBcp.domain.RequestExchangeRate;
import bcp.reto.retoBcp.services.ExchangeRateService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rx.Observable;
import rx.Single;

/**
 * @author Carlos Lazaro
 * @project reto-bcp
 * */

@Slf4j
@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/reto/v1")
public class ApiController {

        private final ExchangeRateService exchangeRateService;
        private final JwtUtils jwtUtils;

        /**
         * Method for get exchange rate
         * @param token
         * @param requestExchangeRate
         * @return ExchangeRateResponseWebDto
         */
        @PostMapping("/exchange")
        public HttpEntity<Single<ExchangeRateResponseWebDto>> exchange(@RequestHeader(value = "Authorization") String token,
                                                                       @RequestBody RequestExchangeRate requestExchangeRate){
                String resultToken = jwtUtils.getKey(token);
                if(resultToken == null){
                        return null;
                }
                Observable<ExchangeRateResponseWebDto> responseWebDto = exchangeRateService.ExchangeRate(requestExchangeRate);
                return ResponseEntity
                        .status(HttpStatus.OK.value())
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(responseWebDto.toSingle());
        }


        /**
         * Method for get exchange rate
         * @param token
         * @param request
         * @return register VALUES true or false
         * */
        @PutMapping("/exchange")
        public HttpEntity<Single<JSONObject>> updateExchange(@RequestHeader(value = "Authorization") String token,
                                                                       @RequestBody ExchangeRate request){
                String resultToken = jwtUtils.getKey(token);
                if(resultToken == null){
                        return null;
                }
                Observable<Boolean> responseWebDto = exchangeRateService.update(request);
                Single<JSONObject> jsonObject = responseWebDto.toSingle().map(item -> {
                        JSONObject object = new JSONObject();
                        object.put("register", item);
                        return object;
                });

                return ResponseEntity
                        .status(HttpStatus.OK.value())
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(jsonObject);
        }

        /**
         * Method for get token
         * */
        @GetMapping("/token")
        public HttpEntity<JSONObject> getToken(){
                String token = jwtUtils.create("1","user@gmail.com");
                JSONObject json = new JSONObject();
                json.put("token", token);
                return ResponseEntity
                        .status(HttpStatus.OK.value())
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(json);
        }
}
