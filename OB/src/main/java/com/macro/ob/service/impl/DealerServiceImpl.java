package com.macro.ob.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.macro.ob.mapper.DealerMapper;
import com.macro.ob.pojo.Dealer;
import com.macro.ob.service.DealerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author youth
* @description 针对表【dealer(经销商)】的数据库操作Service实现
* @createDate 2022-09-05 10:49:00
*/
@Service
public class DealerServiceImpl implements DealerService{
    @Resource
    private DealerMapper dealerMapper;
    @Override
    public Map<String, Object> queryDealerInfoByLike(Dealer dealer) {
        Map<String,Object> map = new HashMap<>();
        PageHelper.startPage(dealer.getPageNum(),dealer.getPageSize());
        List<Dealer> list = dealerMapper.selectDealerInfoByLike(dealer);
        PageInfo<Dealer> pageInfo = new PageInfo<>(list);
        if (list.size() > 0){
            map.put("code", 0);
            map.put("flag", true);
            map.put("info",list);
            map.put("rows",list.size());
            map.put("pageNum",pageInfo.getPageNum());
            map.put("pageSize",pageInfo.getPageSize());
            map.put("message", "查询成功！");
        }else {
            map.put("code", 1);
            map.put("flag", false);
            map.put("message", "查询失败！");
        }
        return map;
    }

    @Override
    public Map<String, Object> queryDealerMaintainInfo(Dealer dealer) {
        Map<String,Object> map = new HashMap<>();
        List<Dealer> list = dealerMapper.selectDealerMaintainInfo(dealer);
        if (list.size() > 0){
            map.put("code", 0);
            map.put("flag", true);
            map.put("info",list);
            map.put("rows",list.size());
            map.put("message", "查询成功！");
        }else {
            map.put("code", 1);
            map.put("flag", false);
            map.put("message", "查询失败！");
        }
        return map;
    }

    @Override
    public Map<String, Object> alterDealerInfo(Dealer dealer) {
        Map<String,Object> map = new HashMap<>();
        Integer rows = dealerMapper.updataDealerInfo(dealer);
        if (rows > 0){
            map.put("code", 0);
            map.put("flag", true);
            map.put("info",rows);
            map.put("message", "修改成功！");
        }else {
            map.put("code", 1);
            map.put("flag", false);
            map.put("message", "修改失败！");
        }
        return map;
    }
}
