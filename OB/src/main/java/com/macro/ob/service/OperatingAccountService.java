package com.macro.ob.service;

import com.macro.ob.pojo.OperatingAccount;

import java.util.Map;

/**
* @author youth
* @description 针对表【operating_account(运营账号表)】的数据库操作Service
* @createDate 2022-09-01 16:28:51
*/
public interface OperatingAccountService {
    /**
     * 获取添加运营账号的详细信息
     * @param operatingAccount
     * @return
     */
    Map<String,Object> addOperatingAccountInfo(OperatingAccount operatingAccount);
    /**
     * 按照运营账号编号进行删除
     * @param operatingAccount
     * @return
     */
    Map<String,Object> removeOperatingAccountInfoById(OperatingAccount operatingAccount);
    /**
     * 修改运营账号的详细信息
     * @param operatingAccount
     * @return
     */
    Map<String,Object> alterOperatingAccountInfoById(OperatingAccount operatingAccount);
    /**
     * 查询运营账号的信息
     * @param operatingAccount
     * @return
     */
    Map<String,Object> queryOperatingAccountInfoByLike(OperatingAccount operatingAccount);

}
