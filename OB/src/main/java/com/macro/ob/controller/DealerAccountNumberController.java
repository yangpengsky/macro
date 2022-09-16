package com.macro.ob.controller;

import com.macro.ob.pojo.DealerAccountNumber;
import com.macro.ob.service.DealerAccountNumberService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/dealerAccountNumber")
public class DealerAccountNumberController {
    @Resource
    private DealerAccountNumberService dealerAccountNumberService;
    @PostMapping("/addDealerAccountNumberInfo")
    public Map<String, Object> addDealerAccountNumberInfo(@RequestBody DealerAccountNumber dealerAccountNumber){
        return dealerAccountNumberService.addDealerAccountNumberInfo(dealerAccountNumber);
    }
    @DeleteMapping("/removeDealerAccountNumberInfoById")
    public Map<String, Object> removeDealerAccountNumberInfoById(@RequestBody DealerAccountNumber dealerAccountNumber){
        return dealerAccountNumberService.removeDealerAccountNumberInfoById(dealerAccountNumber);
    }
    @PutMapping("/alterDealerAccountNumberInfo")
    public Map<String, Object> alterDealerAccountNumberInfo(@RequestBody DealerAccountNumber dealerAccountNumber){
        return dealerAccountNumberService.alterDealerAccountNumberInfo(dealerAccountNumber);
    }
    @PostMapping("/queryDealerAccountNumberInfoByLike")
    public Map<String, Object> queryDealerAccountNumberInfoByLike(HttpServletRequest request, @RequestBody DealerAccountNumber dealerAccountNumber){
        HttpSession session = request.getSession();
        Map<String, Object> map = dealerAccountNumberService.queryDealerAccountNumberInfoByLike(dealerAccountNumber);
        session.setAttribute("info",map.get("info"));
        return map;
    }

}
