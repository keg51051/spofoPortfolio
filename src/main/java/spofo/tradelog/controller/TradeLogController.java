package spofo.tradelog.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import spofo.tradelog.dto.response.TradeLogResponse;
import spofo.tradelog.service.TradeLogService;

@RestController
@RequiredArgsConstructor
public class TradeLogController {

    private final TradeLogService tradeLogService;

    // 종목 이력 조회
    @GetMapping("/portfolios/{portfolioId}/stocks/{stockId}/trade-log")
    public ResponseEntity<List<TradeLogResponse>> viewTradeLogs(
            @PathVariable("stockId") Long stockId,
            @PathVariable("portfolioId") Long portfolioId) {
        List<TradeLogResponse> tradeLogResponseList = tradeLogService.getTradeLogs(stockId);
        return ok().body(tradeLogResponseList);
    }

}
