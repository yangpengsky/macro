package com.macro.ob.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.macro.ob.config.SimpleDate;
import com.macro.ob.mapper.OrdersMapper;
import com.macro.ob.pojo.Orders;
import com.macro.ob.service.OrdersService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author 37656
 * @description 针对表【orders(订单表)】的数据库操作Service实现
 * @createDate 2022-09-02 15:31:23
 */
@Service
public class OrdersServiceImpl implements OrdersService {


    @Resource
    private OrdersMapper ordersMapper;


    @Override
    public Map<String, Object> selectOrderIF(Orders orders) {
        PageHelper.startPage(orders.getPageNum(), orders.getPageSize());
        List<Orders> list = ordersMapper.selectOrderIF(orders);
        PageInfo<Orders> pageInfo = new PageInfo<>(list);
        Map<String, Object> map = new HashMap<>();
        if (list.size() > 0) {
            map.put("code", 0);
            map.put("flag", true);
            map.put("pageNum", pageInfo.getPageNum());
            map.put("pageSize", pageInfo.getPageSize());
            map.put("row", list.size());
            map.put("info", list);

            map.put("message", "查询成功！");
        } else {

            map.put("code", 0);
            map.put("flag", false);
            map.put("message", "查询失败！");
        }
        return map;
    }

    @Override
    public Map<String, Object> updateOrderPass(Orders orders) {
        int i = ordersMapper.updateOrderPass(orders);
        Map<String, Object> map = new HashMap<>();
        if (i > 0) {
            map.put("code", 0);
            map.put("flag", true);
            map.put("row", i);
            map.put("message", "初审核已通过！");
        } else {
            map.put("code", 1);
            map.put("flag", false);
            map.put("message", "修改失败！");
        }
        return map;
    }

    @Override
    public Map<String, Object> updateOrderNoPass(Orders orders) {
        int i = ordersMapper.updateOrderNoPass(orders);
        Map<String, Object> map = new HashMap<>();
        if (i > 0) {

            map.put("code", 0);
            map.put("flag", true);
            map.put("message", "初审核已驳回！");
        } else {
            map.put("code", 1);
            map.put("flag", false);
            map.put("message", "修改失败！");
        }

        return map;
    }

    @Override
    public Map<String, Object> selectOrderByOrderCode(Orders orders) {
        List<Orders> list = ordersMapper.selectOrderByOrderCode(orders);
        Map<String, Object> map = new HashMap<>();
        if (list.size() > 0) {
            map.put("code", 0);
            map.put("flag", true);
            map.put("row", list.size());
            map.put("info", list);
            map.put("message", "订单查询成功！");
        } else {
            map.put("code", 0);
            map.put("flag", false);
            map.put("message", "订单查询失败！");
        }
        return map;
    }

    @Override
    public Map<String, Object> exportTable(Orders orders) throws IOException {
        List<Orders> list = ordersMapper.selectOrderIF(orders);
        String PATH = "C:\\Users\\37656\\Desktop\\";
        String fileName = PATH + "orders_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + ".xlsx";
        // 1.创建工作簿
        Workbook workbook = new XSSFWorkbook();
        // 2.创建表名
        Sheet sheet = workbook.createSheet("订单表");
        //3.创建单元格并写入数据
        Row rowHead = sheet.createRow(0);
        rowHead.createCell(0).setCellValue("订单号");
        rowHead.createCell(1).setCellValue("订单类型");
        rowHead.createCell(2).setCellValue("经销商订单状态");
        rowHead.createCell(3).setCellValue("运营后台订单状态码");
        rowHead.createCell(4).setCellValue("提货方式");
        rowHead.createCell(5).setCellValue("出库仓库");
        rowHead.createCell(6).setCellValue("入库仓库");
        rowHead.createCell(7).setCellValue("详细送货地址");
        rowHead.createCell(8).setCellValue("收货人");
        rowHead.createCell(9).setCellValue("联系电话");

        for (int i = 0; i < list.size(); i++) {
            int j = 0;

            Row row = sheet.createRow(i + 1);
            row.createCell(j++).setCellValue(list.get(i).getOrderCode());
            row.createCell(j++).setCellValue(list.get(i).getOrderType());
            row.createCell(j++).setCellValue(list.get(i).getOrderStatus());
            row.createCell(j++).setCellValue(list.get(i).getObOrderStatus());
            row.createCell(j++).setCellValue(list.get(i).getDeliveryMethod());
            row.createCell(j++).setCellValue(list.get(i).getOutWarehouse());
            row.createCell(j++).setCellValue(list.get(i).getInWarehouse());
            row.createCell(j++).setCellValue(list.get(i).getDeliveryAddress());
            row.createCell(j++).setCellValue(list.get(i).getReceiver());
            row.createCell(j++).setCellValue(list.get(i).getContactNumber());

        }
        //4.创建流用于输出
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //5.输出
        workbook.write(fileOutputStream);
        //6.关闭
        workbook.close();
        Map<String, Object> map = new HashMap<>();
        if (list.size() > 0) {
            map.put("code", 0);
            map.put("flag", true);
            map.put("info", list);
            map.put("message", "导出表成功！");
        } else {

            map.put("code", 1);
            map.put("flag", false);
            map.put("message", "导出表失败！");
        }

        return map;
    }

    @Override
    public Map<String, Object> selectOrderConformIF(Orders orders) {
        List<Orders> list = ordersMapper.selectOrderConformIF(orders);
        Map<String, Object> map = new HashMap<>();
        if (list.size() > 0) {
            map.put("code", 0);
            map.put("flag", true);
            map.put("row", list.size());
            map.put("info", list);
            map.put("message", "复核查询成功！");
        } else {

            map.put("code", 1);
            map.put("flag", false);
            map.put("message", "复核查询失败！");
        }
        return map;
    }

    @Override
    public Map<String, Object> selectOrderStockList(Orders orders) {
        List<Orders> list = ordersMapper.selectOrderStockList(orders);
        Map<String, Object> map = new HashMap<>();
        if (list.size() > 0) {
            map.put("code", 0);
            map.put("flag", true);
            map.put("info", list);
            map.put("message", "查询备货计划列表成功！");
        } else {
            map.put("code", 1);
            map.put("flag", false);
            map.put("message", "查询备货计划列表失败！");
        }
        return map;
    }

    @Override
    public Map<String, Object> selectOrderStockListExport(Orders orders) throws IOException {
        List<Orders> list = ordersMapper.selectOrderStockListExport(orders);
        String path = "C:\\Users\\37656\\Desktop\\";
        String fileName = path + "orders_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-hh-mm-ss")) + ".xlsx";
        // 1.创建工作簿
        Workbook workbook = new XSSFWorkbook();
        // 2.创建表格
        Sheet sheet = workbook.createSheet();
        // 3.创建单元格并写入数据
        Row sheetRow = sheet.createRow(0);
        sheetRow.createCell(0).setCellValue("订单编号");
        sheetRow.createCell(1).setCellValue("订单类型-备货-批发");
        sheetRow.createCell(2).setCellValue("经销商订单状态");
        sheetRow.createCell(3).setCellValue("运营后台订单状态编码");
        sheetRow.createCell(4).setCellValue("提货方式");
        sheetRow.createCell(5).setCellValue("出库仓库");
        sheetRow.createCell(6).setCellValue("入库仓库");
        sheetRow.createCell(7).setCellValue("详细送货地址 ");
        sheetRow.createCell(8).setCellValue("收货人");
        sheetRow.createCell(9).setCellValue("联系电话");
        sheetRow.createCell(10).setCellValue(" 备注 ");
        sheetRow.createCell(11).setCellValue("经销商账号编码 ");
        sheetRow.createCell(12).setCellValue("总数量");
        sheetRow.createCell(13).setCellValue("总体积");
        sheetRow.createCell(14).setCellValue("总金额");
        sheetRow.createCell(15).setCellValue("开票价格");
        sheetRow.createCell(16).setCellValue("订单初审人");
        sheetRow.createCell(17).setCellValue("订单复审人");
        sheetRow.createCell(18).setCellValue("创建人");
        sheetRow.createCell(19).setCellValue("下单日期");
        sheetRow.createCell(20).setCellValue("更新人");
        sheetRow.createCell(21).setCellValue("更新时间 ");
        sheetRow.createCell(22).setCellValue("汇总计划编号 ");
        for (int i = 0; i < list.size(); i++) {
            int j = 0;
            Row sheetRow1 = sheet.createRow(i + 1);
            sheetRow1.createCell(j++).setCellValue(list.get(i).getOrderCode());
            sheetRow1.createCell(j++).setCellValue(list.get(i).getOrderType());
            sheetRow1.createCell(j++).setCellValue(list.get(i).getOrderStatus());
            sheetRow1.createCell(j++).setCellValue(list.get(i).getObOrderStatus());
            sheetRow1.createCell(j++).setCellValue(list.get(i).getDeliveryMethod());
            sheetRow1.createCell(j++).setCellValue(list.get(i).getOutWarehouse());
            sheetRow1.createCell(j++).setCellValue(list.get(i).getInWarehouse());
            sheetRow1.createCell(j++).setCellValue(list.get(i).getDeliveryAddress());
            sheetRow1.createCell(j++).setCellValue(list.get(i).getReceiver());
            sheetRow1.createCell(j++).setCellValue(list.get(i).getContactNumber());
            sheetRow1.createCell(j++).setCellValue(list.get(i).getRemarks());
            sheetRow1.createCell(j++).setCellValue(list.get(i).getDealerCode());
            sheetRow1.createCell(j++).setCellValue(list.get(i).getProductQuantity());
            sheetRow1.createCell(j++).setCellValue(list.get(i).getBulkVolume().toString());
            sheetRow1.createCell(j++).setCellValue(list.get(i).getAggregateAmount().toString());
            sheetRow1.createCell(j++).setCellValue(list.get(i).getInvoicePrice().toString());
            sheetRow1.createCell(j++).setCellValue(list.get(i).getOrderPreliminaryAudit());
            sheetRow1.createCell(j++).setCellValue(list.get(i).getOrderReviewAudit());
            sheetRow1.createCell(j++).setCellValue(list.get(i).getCreatedBy());
            sheetRow1.createCell(j++).setCellValue(SimpleDate.myDateFormat(list.get(i).getCreatedTime()));
            sheetRow1.createCell(j++).setCellValue(list.get(i).getUpdatedBy());
            sheetRow1.createCell(j++).setCellValue(SimpleDate.myDateFormat(list.get(i).getUpdatedTime()));
        }
        //4.创建流用于输出
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //5.输出
        workbook.write(fileOutputStream);
        //6.关闭
        workbook.close();
        Map<String, Object> map = new HashMap<>();
        if (list.size() > 0) {
            map.put("code", 0);
            map.put("flag", true);
            map.put("info", list);
            map.put("message", "导出表格数据成功！");
        } else {

            map.put("code", 1);
            map.put("flag", false);
            map.put("message", "导出数据失败！");
        }
        return map;
    }


}
