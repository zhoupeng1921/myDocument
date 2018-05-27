package com.xhx.pdf.myjasper.jasper;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;

/**
 * @author xuhaixing
 * @date 2018/4/25 11:47
 */
@Service
public class JasperService {

    public void testPDF() throws Exception {
        HashMap<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("applicantName", "徐海兴");
        parameters.put("age", "12");
        parameters.put("NATION", "汉");
        parameters.put("sex","√");

       // File fileName = new File("E:\\ireport\\report1.jasper");


  /*      FileOutputStream outputStream = new FileOutputStream(new File("d:/pdf.pdf"));*/

    //   byte[] bytes = JasperRunManager.runReportToPdf(fileName.getPath(), parameters);

 /*      JasperPrint jasperPrint = JasperFillManager.fillReport(fileName.getPath(), parameters);
        JasperExportManager.exportReportToPdfStream(jasperPrint,outputStream);*/

      //  outputStream.write(bytes);
      //  outputStream.flush();
      //  outputStream.close();




        File reportFile = new File("E:\\ireport\\report1.jrxml");
        JasperReport report = JasperCompileManager.compileReport(reportFile.getPath());
        JasperPrint jasperPrint2 = JasperFillManager.fillReport(report, parameters);
        JRPdfExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint2);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,
                new FileOutputStream("d:/pdf3.pdf"));
        exporter.exportReport();// 导出





    }
}
