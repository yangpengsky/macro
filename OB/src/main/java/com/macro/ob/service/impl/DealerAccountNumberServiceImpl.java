package com.macro.ob.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.macro.ob.mapper.DealerAccountNumberMapper;
import com.macro.ob.pojo.DealerAccountNumber;
import com.macro.ob.service.DealerAccountNumberService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author youth
* @description 针对表【dealer_account_number(经销商总账号)】的数据库操作Service实现
* @createDate 2022-09-05 11:26:13
*/
@Service
public class DealerAccountNumberServiceImpl implements DealerAccountNumberService{
    @Resource
    private DealerAccountNumberMapper dealerAccountNumberMapper;

    @Override
    public Map<String, Object> addDealerAccountNumberInfo(DealerAccountNumber dealerAccountNumber) {
        Map<String,Object> map = new HashMap<>();
        List<DealerAccountNumber> list = dealerAccountNumberMapper.selectDealerAccountNumberInfoByUserName(dealerAccountNumber);
        if (list.size() > 0){
            map.put("message", "用户名存在！");
        }else {
            Integer rows = dealerAccountNumberMapper.insertDealerAccountNumberInfo(dealerAccountNumber);
            if (rows > 0){
                map.put("code", 0);
                map.put("flag", true);
                map.put("rows",rows);
                map.put("message", "经销商总账号添加成功！");
            }else {
                map.put("code", 1);
                map.put("flag", false);
                map.put("message", "经销商总账号添加失败！");
            }
        }
        return map;
    }

    @Override
    public Map<String, Object> removeDealerAccountNumberInfoById(DealerAccountNumber dealerAccountNumber) {
        Map<String,Object> map = new HashMap<>();
        Integer rows = dealerAccountNumberMapper.deleteDealerAccountNumberInfoById(dealerAccountNumber);
        if (rows > 0){
            map.put("code", 0);
            map.put("flag", true);
            map.put("rows",rows);
            map.put("message", "经销商总账号删除成功！");
        }else {
            map.put("code", 1);
            map.put("flag", false);
            map.put("message", "经销商总账号删除失败！");
        }
        return map;
    }

    @Override
    public Map<String, Object> alterDealerAccountNumberInfo(DealerAccountNumber dealerAccountNumber) {
        Map<String,Object> map = new HashMap<>();
        Integer rows = dealerAccountNumberMapper.updataDealerAccountNumberInfo(dealerAccountNumber);
        if (rows > 0){
            map.put("code", 0);
            map.put("flag", true);
            map.put("rows",rows);
            map.put("message", "经销商总账号修改成功！");
        }else {
            map.put("code", 1);
            map.put("flag", false);
            map.put("message", "经销商总账号修改失败！");
        }
        return map;
    }

    @Override
    public Map<String, Object> queryDealerAccountNumberInfoByLike(DealerAccountNumber dealerAccountNumber) {
        Map<String,Object> map = new HashMap<>();
        PageHelper.startPage(dealerAccountNumber.getPageNum(),dealerAccountNumber.getPageSize());
        List<DealerAccountNumber> list = dealerAccountNumberMapper.selectDealerAccountNumberInfoByLike(dealerAccountNumber);
        PageInfo<DealerAccountNumber> pageInfo = new PageInfo<>(list);
        if (list.size() > 0){
            map.put("code", 0);
            map.put("flag", true);
            map.put("info",list);
            map.put("rows",list.size());
            map.put("pageNum",pageInfo.getPageNum());
            map.put("pageSize",pageInfo.getPageSize());
            map.put("message", "经销商总账号查询成功！");
        }else {
            map.put("code", 1);
            map.put("flag", false);
            map.put("message", "经销商总账号查询失败！");
        }
        return map;
    }


}
