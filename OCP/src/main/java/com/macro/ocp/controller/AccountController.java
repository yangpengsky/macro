package com.macro.ocp.controller;

import com.macro.ocp.pojo.DealerAccountNumber;
import com.macro.ocp.service.DealerAccountNumberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * <p>账户登录和管理信息即子账号模块</p>
 *
 * @projectName: OCP
 * @package: com.macro.ocp.controller
 * @className: AccountController
 * @author: zhangkein
 * @date: 2022/9/5 16:50
 * @version: 1.0.0
 */
@Api(tags = "账户类接口")
@CrossOrigin
@RestController
@RequestMapping("/account")
public class AccountController {


    @Resource
    private DealerAccountNumberService dealerAccountNumberService;

    /**
     * <p>登录</p>
     *
     * @param request:
     * @param dealerAccountNumber:
     * @return Map<String, Object>
     * @author zhangkein
     * @date 2022/9/5 17:45
     */


    @ApiOperation("登录")
    @PostMapping("/login")
    public Map<String, Object> login(HttpServletRequest request
            , @RequestBody DealerAccountNumber dealerAccountNumber) {
        Map<String, Object> map = dealerAccountNumberService.selectAccountByCode(dealerAccountNumber);
        if (map.get("flag") != null
                && ((boolean) map.get("flag")) == true) {
            request.getSession().setAttribute("account", map.get("account"));
        }
        return map;
    }

    /**
     * <p>修改密码</p>
     *
     * @param request:
     * @param dealerAccountNumber:
     * @return Map<String, Object>
     * @author zhangkein
     * @date 2022/9/5 17:52
     */
    @PutMapping("/updatePassword")
    public Map<String, Object> updatePassword(HttpServletRequest request
            , @RequestBody DealerAccountNumber dealerAccountNumber) {
        return dealerAccountNumberService.updatePassword(request, dealerAccountNumber);
    }

    /**
     * <p>新建Map映射</p>
     *
     * @param request:             HttpServletRequest对象，用于获取会话中的sesion
     * @param dealerAccountNumber: DealerAccountNumber对象，用于保存子账号信息
     * @return Map<String, Object>
     * @author zhangkein
     * @date 2022/9/7 19:12
     */
    @PostMapping("/insertSubAccount")
    public Map<String, Object> insertSubAccount(HttpServletRequest request
            , @RequestBody DealerAccountNumber dealerAccountNumber) {
        return dealerAccountNumberService.insertSubAccount(request, dealerAccountNumber);
    }

    /**
     * <p>查询子账号信息</p>
     *
     * @param request:
     * @param dealerAccountNumber:
     * @return Map<String, Object>
     * @author zhangkein
     * @date 2022/9/7 20:47
     */
    @GetMapping("/selectSubAccountByParent")
    public Map<String, Object> selectSubAccountByParent(HttpServletRequest request
            , @RequestBody DealerAccountNumber dealerAccountNumber) {
        return dealerAccountNumberService.selectSubAccountByParent(request, dealerAccountNumber);
    }

    /**
     * <p>重置密码</p>
     *
     * @param request:
     * @param dealerAccountNumber:
     * @return Map<String, Object>
     * @author zhangkein
     * @date 2022/9/8 12:05
     */
    @GetMapping("/resetPassword")
    public Map<String, Object> resetPassword(HttpServletRequest request
            , @RequestBody DealerAccountNumber dealerAccountNumber) {
        return dealerAccountNumberService.resetPassword(request, dealerAccountNumber);
    }

    /**
     * <p>更新子账号信息</p>
     * @param request:
     * @param dealerAccountNumber:
     * @return Map<String, Object>
     * @author zhangkein
     * @date 2022/9/8 12:07
     */
    @PutMapping("/updateSubAccount")
    public Map<String, Object> updateSubAccount(HttpServletRequest request
            , @RequestBody DealerAccountNumber dealerAccountNumber) {
        return dealerAccountNumberService.updateSubAccount(request, dealerAccountNumber);
    }

}
