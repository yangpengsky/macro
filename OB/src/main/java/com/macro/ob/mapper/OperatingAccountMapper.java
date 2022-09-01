package com.macro.ob.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.macro.ob.pojo.OperatingAccount;

/**
* @author youth
* @description 针对表【operating_account(运营账号表)】的数据库操作Mapper
* @createDate 2022-09-01 16:28:51
* @Entity com.macro.ob.pojo.OperatingAccount
*/
public interface OperatingAccountMapper extends BaseMapper<OperatingAccount> {
    Integer insertOperatingAccountInfo(OperatingAccount operatingAccount);
}
