package com.macro.ob.service;


import com.macro.ob.pojo.Dealer;

import java.util.Map;

/**
* @author youth
* @description 针对表【dealer(经销商)】的数据库操作Service
* @createDate 2022-09-05 10:49:00
*/
public interface DealerService {
    /**
     * 获取查询经销商的基本信息
     * @param dealer
     * @return
     */
    Map<String,Object> queryDealerInfoByLike(Dealer dealer);
    /**
     * 获取查询经销商账号的维护信息
     * @param dealer
     * @return
     */
    Map<String,Object> queryDealerMaintainInfo(Dealer dealer);
    /**
     * 获取修改经销商的基本信息
     * @param dealer
     * @return
     */
    Map<String,Object> alterDealerInfo(Dealer dealer);



}
