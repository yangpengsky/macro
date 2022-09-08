package com.macro.ob.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.macro.ob.pojo.DealerAccountNumber;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
* @author youth
* @description 针对表【dealer_account_number(经销商总账号)】的数据库操作Mapper
* @createDate 2022-09-05 11:26:13
* @Entity com.macro.ob.pojo.DealerAccountNumber
*/
public interface DealerAccountNumberMapper extends BaseMapper<DealerAccountNumber> {
    /**
     * 添加经销商总账号
     * @param dealerAccountNumber
     * @return
     */
    Integer insertDealerAccountNumberInfo(DealerAccountNumber dealerAccountNumber);
    /**
     * 删除经销商总账号
     * @param dealerAccountNumber
     * @return
     */
    Integer deleteDealerAccountNumberInfoById(DealerAccountNumber dealerAccountNumber);
    /**
     * 修改经销商总账号
     * @param dealerAccountNumber
     * @return
     */
    Integer updataDealerAccountNumberInfo(DealerAccountNumber dealerAccountNumber);
    /**
     * 查询经销商总帐号
     * @param dealerAccountNumber
     * @return
     */
    List<DealerAccountNumber> selectDealerAccountNumberInfoByLike(DealerAccountNumber dealerAccountNumber);

    /**
     * 查询经销商的用户名
     * @param dealerAccountNumber
     * @return
     */
    List<DealerAccountNumber> selectDealerAccountNumberInfoByUserName(DealerAccountNumber dealerAccountNumber);

}
