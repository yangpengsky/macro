package com.macro.ob.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.macro.ob.pojo.Dealer;

import java.util.List;

/**
* @author youth
* @description 针对表【dealer(经销商)】的数据库操作Mapper
* @createDate 2022-09-05 10:49:00
* @Entity com.macro.ob.pojo.Dealer
*/
public interface DealerMapper extends BaseMapper<Dealer> {
    /**
     * 查询经销商的基本信息
     * @param dealer
     * @return
     */
    List<Dealer> selectDealerInfoByLike(Dealer dealer);
    /**
     * 查询经销商的账号维护信息
     * @param dealer
     * @return
     */
    List<Dealer> selectDealerMaintainInfo(Dealer dealer);

    /**
     * 修改经销商的信息
     * @param dealer
     * @return
     */
    Integer updataDealerInfo(Dealer dealer);

}
