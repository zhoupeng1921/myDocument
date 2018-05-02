package com.xhx.pdf.myjasper.controller;

import com.xhx.pdf.myjasper.jasper.JasperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuhaixing
 * @date 2018/5/2 14:14
 */
@RestController
@RequestMapping("pdf")
public class PdfController {

    @Autowired
    private JasperService jasperService;

    @RequestMapping(value = "testPdf")
    public int testPdf() throws Exception{
        jasperService.testPDF();
        return 1;
    }
}
