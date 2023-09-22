package spofo.portfolio.domain.tradelog.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import spofo.portfolio.domain.tradelog.dto.response.TradeLogResponse;
import spofo.portfolio.domain.tradelog.entity.TradeLog;
import spofo.portfolio.domain.tradelog.service.TradeLogService;

@RestController
@RequiredArgsConstructor
public class TradeLogController {

    private final TradeLogService tradeLogService;

    // 종목 이력 조회
    @GetMapping("/portfolios/{portfolioId}/stocks/{stockId}/trade-log")
    public List<TradeLogResponse> viewTradeLogs(@PathVariable String stockId,
            @PathVariable String portfolioId) {
        return tradeLogService.getTradeLogs(Long.valueOf(stockId));
    }

}
