package com.xhx.pdf.jasper;

import net.sf.jasperreports.engine.JasperRunManager;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;

/**
 * @author xuhaixing
 * @date 2018/4/25 11:47
 */
public class jasper {

    @Test
    public void testPDF() throws Exception {
        File fileName = new File("E:/ireport/report1.jasper");

        HashMap<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("name", "xuhaixing");
        byte[] bytes = JasperRunManager.runReportToPdf(fileName.getPath(), parameters);

        FileOutputStream outputStream = new FileOutputStream(new File("d:/pdf.pdf"));
        outputStream.write(bytes);
        outputStream.flush();
        outputStream.close();
    }
}
