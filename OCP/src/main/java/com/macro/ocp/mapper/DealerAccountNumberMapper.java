package com.macro.ocp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.macro.ocp.pojo.DealerAccountNumber;

import java.util.List;

/**
* @author zhangkein
* @description 针对表【dealer_account_number(经销商总账号)】的数据库操作Mapper
* @createDate 2022-09-05 15:42:13
* @Entity com.macro.ocp.pojo.DealerAccountNumber
*/
public interface DealerAccountNumberMapper extends BaseMapper<DealerAccountNumber> {

    /**
     * <p>根据账户编码查询账户信息</p>
     * @param userName:
     * @return DealerAccountNumber
     * @author zhangkein
     * @description 根据账户编码查询账户信息
     * @date 2022/9/5 16:03
     */
    DealerAccountNumber selectAccountByCode(String userName);
    /**
     * <p>根据账户修改密码</p>
     * @param dealerAccountNumber:
     * @return Integer
     * @author zhangkein
     * @date 2022/9/5 17:35
     */
    Integer updatePassword(DealerAccountNumber dealerAccountNumber);
    /**
     * <p>添加一个子账号</p>
     * @param dealerAccountNumber:
     * @return Integer
     * @author zhangkein
     * @date 2022/9/7 12:09
     */
    Integer insertSubAccount(DealerAccountNumber dealerAccountNumber);

    /**
     * <p>根据dealerAccountNumber中的信息查询满足条件的子账号</p>
     * @param dealerAccountNumber:
     * @return List<DealerAccountNumber>
     * @author zhangkein
     * @date 2022/9/7 17:13
     */
    List<DealerAccountNumber> selectSubAccountByParent(DealerAccountNumber dealerAccountNumber);

    /**
     * <p>判断用户名是否被使用</p>
     * @param userName:  用于判断用户名是否存在
     * @return Integer 返回账户存在的行数
     * @author zhangkein
     * @date 2022/9/7 19:55
     */
    Integer countSubAccount(String userName);

    /**
     * <p>修改子账号信息</p>
     * @param dealerAccountNumber:
     * @return Integer
     * @author zhangkein
     * @date 2022/9/8 9:48
     */
    Integer updateSubAccount(DealerAccountNumber dealerAccountNumber);
}
