package com.macro.ob.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.macro.ob.pojo.OperatingAccount;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

/**
* @author youth
* @description 针对表【operating_account(运营账号表)】的数据库操作Mapper
* @createDate 2022-09-01 16:28:51
* @Entity com.macro.ob.pojo.OperatingAccount
*/
public interface OperatingAccountMapper extends BaseMapper<OperatingAccount> {

    /**
     * 添加运营账号信息
     * @param operatingAccount
     * @return
     */
    Integer insertOperatingAccountInfo(OperatingAccount operatingAccount);
    /**
     * 按照运营账号编号批量删除员工信息
     * @param operatingAccount
     * @return
     */
    Integer deleteOperatingAccountInfoById(OperatingAccount operatingAccount);
    /**
     * 修改运营账号的信息
     * @param operatingAccount
     * @return
     */
    Integer updateOperatingAccountInfo(OperatingAccount operatingAccount);
    /**
     * 查询运营账号信息
     * @param operatingAccount
     * @return
     */
    List<OperatingAccount> selectOperatingAccountInfoLike(OperatingAccount operatingAccount);

    /**
     * 登录查询账号信息
     * @param operatingAccount
     * @return
     */
    List<OperatingAccount> selectOperatingAccountInfoByUserName(OperatingAccount operatingAccount);

}