package com.macro.ocp.service;


import com.macro.ocp.pojo.DealerAccountNumber;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
* @author zhangkein
* @description 针对表【dealer_account_number(经销商总账号)】的数据库操作Service
* @createDate 2022-09-05 15:05:40
*/
public interface DealerAccountNumberService {
    /**
     * <p>根据传进的账户编码和密码进行查询，判断账号正确与否</p>
     * @param dealerAccountNumber:
     * @return Map<String,Object>
     * @author zhangkein
     * @date 2022/9/5 16:36
     */
    Map<String,Object> selectAccountByCode(DealerAccountNumber dealerAccountNumber);
    /**
     * <p>根据账户修改密码</p>
     * @param dealerAccountNumber:
     * @return Map<String,Object>
     * @author zhangkein
     * @date 2022/9/5 17:37
     */
    Map<String,Object> updatePassword(HttpServletRequest request, DealerAccountNumber dealerAccountNumber);

    /**
     * <p>添加一个子账号</p>
     * @param request:
     * @param dealerAccountNumber:
     * @return Map<String,Object>
     * @author zhangkein
     * @date 2022/9/7 12:10
     */
    Map<String,Object> insertSubAccount(HttpServletRequest request,DealerAccountNumber dealerAccountNumber);

    /**
     * <p>查询子账号</p>
     * @param request: HttpServlet对象，用于获得会话session
     * @param dealerAccountNumber: DealerAccountNumber对象，用于保存查询信息
     * @return Map<String, Object>
     * @author zhangkein
     * @date 2022/9/7 17:15
     */
    Map<String,Object> selectSubAccountByParent(HttpServletRequest request,DealerAccountNumber dealerAccountNumber);

    /**
     * <p>重置子账号密码</p>
     * @param request:
     * @param dealerAccountNumber:
     * @return Map<String, Object>
     * @author zhangkein
     * @date 2022/9/8 9:11
     */
    Map<String,Object> resetPassword(HttpServletRequest request,DealerAccountNumber dealerAccountNumber);

    /**
     * <p>修改子账号信息</p>
     * @param request:
     * @param dealerAccountNumber:
     * @return Map<String, Object>
     * @author zhangkein
     * @date 2022/9/8 10:09
     */
    Map<String, Object> updateSubAccount(HttpServletRequest request, DealerAccountNumber dealerAccountNumber);
}
