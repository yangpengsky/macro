package com.macro.ob.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.macro.ob.mapper.OperatingAccountMapper;
import com.macro.ob.pojo.OperatingAccount;
import com.macro.ob.service.OperatingAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author youth
* @description 针对表【operating_account(运营账号表)】的数据库操作Service实现
* @createDate 2022-09-01 16:28:51
*/
@Service
public class OperatingAccountServiceImpl implements OperatingAccountService{
    @Resource
    private OperatingAccountMapper operatingAccountMapper;
    @Override
    public Map<String, Object> addOperatingAccountInfo(OperatingAccount operatingAccount) {
        Map<String,Object> map = new HashMap<>();
        Integer rows = operatingAccountMapper.insertOperatingAccountInfo(operatingAccount);
        if (rows > 0){
            map.put("code", 0);
            map.put("flag", true);
            map.put("rows",rows);
            map.put("message", "运营账号添加成功！");
        }else {
            map.put("code", 1);
            map.put("flag", false);
            map.put("message", "运营账号添加失败！");
        }
        return map;
    }

    @Override
    public Map<String, Object> removeOperatingAccountInfoById(OperatingAccount operatingAccount) {
        Map<String,Object> map = new HashMap<>();
        Integer rows = operatingAccountMapper.deleteOperatingAccountInfoById(operatingAccount);
        if (rows > 0){
            map.put("code", 0);
            map.put("flag", true);
            map.put("rows",rows);
            map.put("message", "运营账号删除成功！");
        }else {
            map.put("code", 1);
            map.put("flag", false);
            map.put("message", "运营账号删除失败！");
        }
        return map;
    }

    @Override
    public Map<String, Object> alterOperatingAccountInfoById(OperatingAccount operatingAccount) {
        Map<String,Object> map = new HashMap<>();
        Integer rows = operatingAccountMapper.updateOperatingAccountInfo(operatingAccount);
        if (rows > 0){
            map.put("code", 0);
            map.put("flag", true);
            map.put("rows",rows);
            map.put("message", "运营账号修改成功！");
        }else {
            map.put("code", 1);
            map.put("flag", false);
            map.put("message", "运营账号修改失败！");
        }
        return map;
    }

    @Override
    public Map<String, Object> queryOperatingAccountInfoByLike(OperatingAccount operatingAccount) {
        Map<String,Object> map = new HashMap<>();
        PageHelper.startPage(operatingAccount.getPageNum(),operatingAccount.getPageSize());
        List<OperatingAccount> list = operatingAccountMapper.selectOperatingAccountInfoLike(operatingAccount);
        PageInfo<OperatingAccount> pageInfo = new PageInfo <>(list);
        if (list.size() > 0){
            map.put("code", 0);
            map.put("flag", true);
            map.put("info",list);
            map.put("pageNum",pageInfo.getPageNum());
            map.put("pageSize",pageInfo.getPageSize());
            map.put("rows",list.size());
            map.put("message", "运营账号查询成功！");
        }else {
            map.put("code", 1);
            map.put("flag", false);
            map.put("message", "运营账号查询失败！");
        }
        return map;
    }
}
