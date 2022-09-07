package com.macro.ob.service;

import com.macro.ob.pojo.DealerAccountNumber;

import java.util.Map;

/**
* @author youth
* @description 针对表【dealer_account_number(经销商总账号)】的数据库操作Service
* @createDate 2022-09-05 11:26:13
*/
public interface DealerAccountNumberService {
    /**
     * 获取添加经销商总账号的详细信息
     * @param dealerAccountNumber
     * @return
     */
    Map<String,Object> addDealerAccountNumberInfo(DealerAccountNumber dealerAccountNumber);
    /**
     * 按照经销商总账号编码删除经销商总帐号的信息
     * @param dealerAccountNumber
     * @return
     */
    Map<String,Object> removeDealerAccountNumberInfoById(DealerAccountNumber dealerAccountNumber);
    /**
     * 获取修改经销商总账号的详细信息
     * @param dealerAccountNumber
     * @return
     */
    Map<String,Object> alterDealerAccountNumberInfo(DealerAccountNumber dealerAccountNumber);
    /**
     * 条件查询经销商总账号的详细信息
     * @param dealerAccountNumber
     * @return
     */
    Map<String,Object> queryDealerAccountNumberInfoByLike(DealerAccountNumber dealerAccountNumber);


}
