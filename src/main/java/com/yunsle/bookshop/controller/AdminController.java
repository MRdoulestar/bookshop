package com.yunsle.bookshop.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.yunsle.bookshop.entity.Myorder;
import com.yunsle.bookshop.service.OrderService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Doublestar on 2018/1/11 16:30).
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    OrderService orderService;

    @RequestMapping("books")
    public String books() {
        return "admin/books";
    }

    @RequestMapping("orders")
    public String orders() {
        return "admin/orders";
    }

    //导出订单Excel
    @RequestMapping("/download")
    public void download(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 告诉浏览器用什么软件可以打开此文件
        response.setHeader("content-Type", "application/vnd.ms-excel");
        // 下载文件的默认名称
        response.setHeader("Content-Disposition", "attachment;filename=orders.xls");
        List<Myorder> list = orderService.getAllOrders();
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), Myorder.class, list);
        workbook.write(response.getOutputStream());
    }

    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.removeAttribute("isAdmin");
        return "redirect:/adminlogin";
    }
}
