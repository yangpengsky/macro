package com.macro.ocp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.macro.ocp.mapper.DealerAccountNumberMapper;
import com.macro.ocp.pojo.DealerAccountNumber;
import com.macro.ocp.service.DealerAccountNumberService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>针对表【dealer_account_number(经销商总账号)】的数据库操作Service实现</p>
 *
 * @author zhangkein
 * @date  2022-09-05 15:05:40
 */
@Service
public class DealerAccountNumberServiceImpl implements DealerAccountNumberService {

    @Resource
    private DealerAccountNumberMapper dealerAccountNumberMapper;

    /**
     * 默认状态
     */
    @Value("${defaultStatus}")
    private String defaultStatus;

    /**
     * 默认密码
     */
    @Value("${defaultPassword}")
    private String defaultPassword;
    /**
     * <p>根据传进的账户编码和密码进行查询，判断账号正确与否 的实现</p>
     *
     * @param dealerAccountNumber:
     * @return Map<String, Object>
     * @author zhangkein
     * @date 2022/9/5 17:46
     */
    @Override
    public Map<String, Object> selectAccountByCode(DealerAccountNumber dealerAccountNumber) {
        //返回值映射
        Map<String, Object> map = new HashMap<>();
        //登录账号
        String userName = dealerAccountNumber.getUserName();
        //登录密码
        String password = dealerAccountNumber.getPassword();
        //判断账号是否为空
        if (userName != null) {
            //根据账号查询账号信息
            DealerAccountNumber account = dealerAccountNumberMapper.selectAccountByCode(userName);
            //判断是否有返回值
            if (account != null) {
                //判断密码是否与账号一致
                if (account.getPassword().equals(password)) {
                    map.put("code", 0);
                    map.put("flag", true);
                    map.put("message","登录成功");
                    map.put("account", account);
                } else {
                    //密码不一致
                    map.put("code", 2);
                    map.put("flag", false);
                    map.put("message","密码不一致");
                }
            } else {
                //没有返回值，则不存在该账号
                map.put("code", 3);
                map.put("flag", false);
                map.put("message","账号不存在");
            }

        } else {
            //账号传输有误
            map.put("code", 4);
            map.put("flag", false);
            map.put("message","未知异常，请重试");
        }
        return map;
    }

    /**
     * <p>根据账户修改密码</p>
     *
     * @param dealerAccountNumber:
     * @return Map<String, Object>
     * @author zhangkein
     * @date 2022/9/5 17:48
     */
    @Override
    public Map<String, Object> updatePassword(HttpServletRequest request, DealerAccountNumber dealerAccountNumber) {
        //返回结果
        Map<String, Object> map = new HashMap<>();
        //声明session中的账户
        DealerAccountNumber account = null;
        //得到session中的账户信息
        Object attribute = request.getSession().getAttribute("account");
        //类型判断并进行转换
        if (attribute instanceof DealerAccountNumber) {
            account = (DealerAccountNumber) attribute;
        }
        //判断session中有没有账户
        if (account != null) {
            //判断账号及原密码是否一致
            if (account.getAccountCode().equals(dealerAccountNumber.getAccountCode())
                    && account.getPassword().equals(dealerAccountNumber.getOriginPassword())) {
                Integer integer = dealerAccountNumberMapper.updatePassword(dealerAccountNumber);
                //执行成功
                if (integer > 0) {
                    map.put("code", 0);
                    map.put("flag", true);
                    map.put("message", "成功");
                    //更新session中的密码
                    account.setPassword(dealerAccountNumber.getPassword());
                    request.getSession().setAttribute("account", account);
                } else {
                    map.put("code", 3);
                    map.put("flag", false);
                    map.put("message", "未知错误，请重试！");
                }
            } else {
                map.put("code", 5);
                map.put("flag", false);
                map.put("message", "原密码错误");
            }

        } else {
            map.put("code", 4);
            map.put("flag", false);
            map.put("message", "请登录");
        }
        return map;
    }

    /**
     * <p>添加一个子账号</p>
     *
     * @param request:             HttpServletRequest请求对象
     * @param dealerAccountNumber: DealerAccountNumber对象
     * @return Map<String, Object>
     * @author zhangkein
     * @date 2022/9/7 12:11
     */
    @Override
    public Map<String, Object> insertSubAccount(HttpServletRequest request, DealerAccountNumber dealerAccountNumber) {
        //声明返回映射
        Map<String, Object> map = new HashMap<>();
        //校验必填数据是否为空
        if (dealerAccountNumber.getUserName() != null
                && dealerAccountNumber.getContacts() != null
                && dealerAccountNumber.getRole() != null
                && dealerAccountNumber.getGender() != null) {
            //从request中获取登录的总帐号信息
            DealerAccountNumber account = null;
            Object attribute = request.getSession().getAttribute("account");
            if (attribute instanceof DealerAccountNumber) {
                account = (DealerAccountNumber) attribute;
            }
            if (account != null) {
                //校验登陆人员是否有权限新建子账号
                if (account.getParentAccountCode() == null){
                    //有权限则的情况下，将插入的子账号的创建人和父账号编码
                    dealerAccountNumber.setCreatedBy(account.getContacts());
                    //设置总帐号编码
                    dealerAccountNumber.setParentAccountCode(account.getAccountCode());
                    //默认账号为激活状态
                    dealerAccountNumber.setDealerStatus(defaultStatus);
                    //设置默认密码
                    dealerAccountNumber.setPassword(defaultPassword);
                    //判断用户名是否存在
                    if (dealerAccountNumberMapper.countSubAccount(dealerAccountNumber.getUserName()) > 0){
                        map.put("code", 1);
                        map.put("flag", false);
                        map.put("message", "账户已存在");
                    }else {
                        //尝试新建账号
                        if (dealerAccountNumberMapper.insertSubAccount(dealerAccountNumber) > 0){
                            map.put("code", 0);
                            map.put("flag", true);
                            map.put("message", "添加成功");
                        }else {
                            map.put("code", 2);
                            map.put("flag", false);
                            map.put("message", "未知错误，请重试");
                        }
                    }

                }else {
                    map.put("code", 3);
                    map.put("flag", false);
                    map.put("message", "没有权限");
                }
            } else {
                map.put("code", 4);
                map.put("flag", false);
                map.put("message", "请登录");
            }
        } else {
            map.put("code", 6);
            map.put("flag", false);
            map.put("message", "数据不完整");
        }
        return map;
    }

    /**
     * <p>查询子账号</p>
     * @param request: HttpServlet对象，用于获得会话session
     * @param dealerAccountNumber:  DealerAccountNumber对象，用于保存查询信息
     * @return Map<String, Object>
     * @author zhangkein
     * @date 2022/9/7 17:16
     */
    @Override
    public Map<String, Object> selectSubAccountByParent(HttpServletRequest request, DealerAccountNumber dealerAccountNumber) {
        //声明返回值Map
        Map<String,Object> map = new HashMap<>();
        //得到登录账号信息
        DealerAccountNumber account = null;
        Object attribute = request.getSession().getAttribute("account");
        if (attribute instanceof DealerAccountNumber) {
            account = (DealerAccountNumber) attribute;
        }
        //设置分页
        if (dealerAccountNumber.getPageNum() != null && dealerAccountNumber.getPageSize() != null){
            PageHelper.startPage(dealerAccountNumber.getPageNum(),dealerAccountNumber.getPageSize());
        }else {
            PageHelper.startPage(1,5);
        }
        //判断是否登录
        if (account != null){
            //设置父类编码
            dealerAccountNumber.setParentAccountCode(account.getAccountCode());
            //尝试查询
            List<DealerAccountNumber> list = dealerAccountNumberMapper.selectSubAccountByParent(dealerAccountNumber);
            //分页处理
            if (list != null){
                PageInfo<DealerAccountNumber> info = new PageInfo<>(list);
                map.put("code", 0);
                map.put("flag", true);
                map.put("message", "查询成功");
                map.put("info",info);
            }else {
                map.put("code", 1);
                map.put("flag", true);
                map.put("message", "没有查到相应信息");
            }
        }else {
            map.put("code", 4);
            map.put("flag", false);
            map.put("message", "请登录");
        }

        return map;
    }

    /**
     * <p>重置子账号密码</p>
     * @param request:
     * @param dealerAccountNumber:
     * @return Map<String, Object>
     * @author zhangkein
     * @date 2022/9/8 9:11
     */
    @Override
    public Map<String, Object> resetPassword(HttpServletRequest request, DealerAccountNumber dealerAccountNumber) {
        //创建返回值map
        Map<String,Object> map = new HashMap<>();
        //获得登录账号信息
        DealerAccountNumber account = null;
        Object attribute = request.getSession().getAttribute("account");
        if (attribute instanceof DealerAccountNumber) {
            account = (DealerAccountNumber) attribute;
        }
        //判断账号是否登录
        if (account == null){
            map.put("code", 4);
            map.put("flag", false);
            map.put("message", "请登录");
            return map;
        }
        //判断是否有权限
        if (account.getParentAccountCode() != null){
            map.put("code", 3);
            map.put("flag", false);
            map.put("message", "没有权限重置");
            return map;
        }
        //将总账号编码及密码放入
        dealerAccountNumber.setPassword(defaultPassword);
        dealerAccountNumber.setParentAccountCode(account.getAccountCode());
        //重置密码
        if (dealerAccountNumberMapper.updatePassword(dealerAccountNumber) > 0){
            map.put("code", 0);
            map.put("flag", true);
            map.put("message", "成功");
        }else {
            map.put("code", 1);
            map.put("flag", false);
            map.put("message", "请重试");
        }
        return map;
    }

    /**
     * <p>修改子账号信息</p>
     * @param request:
     * @param dealerAccountNumber:
     * @return Map<String, Object>
     * @author zhangkein
     * @date 2022/9/8 10:09
     */
    @Override
    public Map<String, Object> updateSubAccount(HttpServletRequest request, DealerAccountNumber dealerAccountNumber) {
        //设置返回映射
        Map<String,Object> map = new HashMap<>();
        //得到登录信息
        DealerAccountNumber account = null;
        Object attribute = request.getSession().getAttribute("account");
        if (attribute instanceof DealerAccountNumber) {
            account = (DealerAccountNumber) attribute;
        }
        //判断账号是否登录
        if (account == null){
            map.put("code", 4);
            map.put("flag", false);
            map.put("message", "请登录");
            return map;
        }
        //判断是否有权限
        if (account.getParentAccountCode() != null){
            map.put("code", 3);
            map.put("flag", false);
            map.put("message", "没有权限修改");
            return map;
        }
        //判断子账号编码是否存在
        if (dealerAccountNumber.getAccountCode() == null){
            map.put("code",2);
            map.put("flag",false);
            map.put("message","没有子账号编码");
            return map;
        }
        //设置总账号
        dealerAccountNumber.setParentAccountCode(account.getAccountCode());
        //修改
        if (dealerAccountNumberMapper.updateSubAccount(dealerAccountNumber) > 0){
            map.put("code", 0);
            map.put("flag", true);
            map.put("message", "成功");
        }else {
            map.put("code", 1);
            map.put("flag", false);
            map.put("message", "请重试");
        }
        return map;
    }
}
