package com.xhx.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.junit.Test;

import java.io.FileOutputStream;

public class InnerMessagePDF {


    @Test
    public void testPDF() throws Exception {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, new FileOutputStream("/media/xuhaixing/programe/a.pdf"));
        document.open();

        BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font f10 = new Font(bfChinese, 13, Font.NORMAL);
        Font f12 = new Font(bfChinese, 15, Font.BOLD);

        PdfPTable table1 = new PdfPTable(3);
        table1.getDefaultCell().setBorderWidth(1f);
        int[] widths = new int[]{6, 90, 4};
        table1.setWidths(widths);
        table1.setSpacingBefore(25);
        table1.setSpacingAfter(25);

        //介绍信存根
        Paragraph p1 = new Paragraph("党\n员\n介\n绍\n信\n存\n根\n", f12);
        PdfPCell cungen = new PdfPCell(new Phrase(p1));
        cungen.setBorderWidth(1f);
        setHoriAndVertiAli(cungen);
        table1.addCell(cungen);


        //主体内容
        Paragraph p21 = new Paragraph("网字第 00001 号",f10);
        p21.setAlignment(Element.ALIGN_RIGHT);
        PdfPCell cell2 = new PdfPCell();
        cell2.setPaddingRight(25f);
        cell2.setBorderWidth(1f);
        cell2.addElement(p21);

        StringBuffer name = new StringBuffer("沈弘");
        int length = 9-name.length();
        char[] charSeque=new char[]{'\u3000','\u3000','\u3000','\u3000','\u3000','\u3000',
                '\u3000','\u3000','\u3000','\u3000','\u3000','\u3000','\u3000','\u3000',
                '\u3000','\u3000','\u3000','\u3000','\u3000','\u3000','\u3000','\u3000'};
        name.append(charSeque,0,length>0?length:0);
        Chunk chunk = new Chunk(name.toString(),f10);

        System.out.println("-----"+name.toString()+"-----");
        chunk.setUnderline(0.5f,-3f);
        Paragraph p22 = new Paragraph(chunk);
        cell2.addElement(p22);



        table1.addCell(cell2);


        //第一联
        Paragraph p3 = new Paragraph("第\n一\n联\n", f10);
        PdfPCell diyilian = new PdfPCell(new Phrase(p3));
        diyilian.setBorderWidth(1f);
        setHoriAndVertiAli(diyilian);
        table1.addCell(diyilian);

        document.add(table1);
        document.close();
    }




    /**
     * 水平垂直居中
     * @param cell
     */
    public void setHoriAndVertiAli(PdfPCell cell){
        setHorizonAli(cell);
        setVerticalAli(cell);
    }

    public void setHorizonAli(PdfPCell cell){
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    }
    public void setVerticalAli(PdfPCell cell){
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    }
}
