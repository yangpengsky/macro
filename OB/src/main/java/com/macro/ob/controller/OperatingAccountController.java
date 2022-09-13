package com.macro.ob.controller;

import com.macro.ob.pojo.OperatingAccount;
import com.macro.ob.service.OperatingAccountService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 运营账号控制类
 */
@CrossOrigin
@RestController
@RequestMapping("/operatingAccount")
public class OperatingAccountController {
    @Resource
    private OperatingAccountService operatingAccountService;
    @PostMapping("/addOperatingAccountInfo")
    public Map<String, Object> addOperatingAccountInfo(@RequestBody OperatingAccount operatingAccount) {
        return operatingAccountService.addOperatingAccountInfo(operatingAccount);
    }
    @DeleteMapping("/removeOperatingAccountInfoById")
    public Map<String, Object> removeOperatingAccountInfoById(@RequestBody OperatingAccount operatingAccount){
        return operatingAccountService.removeOperatingAccountInfoById(operatingAccount);
    }
    @PutMapping("/alterOperatingAccountInfoById")
    public Map<String, Object> alterOperatingAccountInfoById(@RequestBody OperatingAccount operatingAccount){
        return operatingAccountService.alterOperatingAccountInfoById(operatingAccount);
    }
    @PostMapping("/queryOperatingAccountInfoByLike")
    public Map<String, Object> queryOperatingAccountInfoByLike(@RequestBody OperatingAccount operatingAccount){
        return operatingAccountService.queryOperatingAccountInfoByLike(operatingAccount);
    }
    @PostMapping("/queryOperatingAccountInfoByUserName")
    public Map<String, Object> queryOperatingAccountInfoByUserName(HttpServletRequest request,@RequestBody OperatingAccount operatingAccount){
        HttpSession session = request.getSession();
        Map<String, Object> map = operatingAccountService.queryOperatingAccountInfoByUserName(operatingAccount);
        OperatingAccount operatingAccount2 =(OperatingAccount) map.get("info");
        session.setAttribute("info",operatingAccount2);
        return map;
    }
}
