package com.macro.ob.controller;

import com.macro.ob.pojo.Dealer;
import com.macro.ob.service.DealerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;
@CrossOrigin
@RestController
@RequestMapping("/dealer")
public class DealerController {
    @Resource
    private DealerService dealerService;

    @PostMapping("/queryDealerInfoByLike")
    public Map<String, Object> queryDealerInfoByLike(@RequestBody Dealer dealer){
        return dealerService.queryDealerInfoByLike(dealer);
    }
    @PostMapping("/queryDealerMaintainInfo")
    public Map<String, Object> queryDealerMaintainInfo(@RequestBody Dealer dealer){
        return dealerService.queryDealerMaintainInfo(dealer);
    }
    @PutMapping("/alterDealerInfo")
    public Map<String, Object> alterDealerInfo(@RequestBody Dealer dealer){
        return dealerService.alterDealerInfo(dealer);
    }

}
