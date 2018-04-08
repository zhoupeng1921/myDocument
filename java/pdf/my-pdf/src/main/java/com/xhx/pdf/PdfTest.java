package com.xhx.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.junit.After;
import org.junit.Test;

import java.io.FileOutputStream;

/**
 * Hello world!
 */
public class PdfTest {
    public static Document document;
    public static PdfWriter writer;

    static {
        try {
            document = new Document(PageSize.A4); //其他参数为边距
            //document = new Document(PageSize.A4.rotate());//横向的
            writer = PdfWriter.getInstance(document, new FileOutputStream("/media/xuhaixing/programe/a.pdf"));
            document.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 任何文本都借助 com.itextpdf.text.Paragraph 来进行添加
     */
    @Test
    public void testPDF() throws Exception {
        Paragraph p = new Paragraph();
        p.add("study learn export pdf");
        p.setAlignment(Element.ALIGN_CENTER);
        document.add(p);

        p=new Paragraph(" \n");
        document.add(p);

        p = new Paragraph("————————————————————————————————————————");
        document.add(p);
    }

    /**
     * 链接
     * @throws Exception
     */
    @Test
    public void testAnchor() throws Exception{
        Anchor anchorTarget = new Anchor("First page of the document.");
        anchorTarget.setName("BackToTop");
        Paragraph paragraph1 = new Paragraph();
        paragraph1.setSpacingBefore(50);
        paragraph1.add(anchorTarget);
        document.add(paragraph1);
        document.add(new Paragraph("Some more text on the  first page with different color and font type.", FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new CMYKColor(0, 255, 0, 0))));

        Paragraph title1 = new Paragraph("Chapter 1", FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLDITALIC, new CMYKColor(0, 255, 255, 17)));
        Chapter chapter1 = new Chapter(title1,1);
        chapter1.setNumberDepth(0);
        Paragraph title11 = new Paragraph("This is Section 1 in Chapter 1", FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD, new CMYKColor(0, 255, 255,17)));
        Section section1 = chapter1.addSection(title11);
        Paragraph title2 = new Paragraph("Using Anchor",FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD,
                        new CMYKColor(0, 255, 0, 0)));
        section1.add(title2);
        title2.setSpacingBefore(5000);
        Anchor anchor2 = new Anchor("Back To Top");
        anchor2.setReference("#BackToTop");
        section1.add(anchor2);
        document.add(section1);

    }

    /**
     * 创建一个新的章节
     * @throws Exception
     */
    @Test
    public void testChapter() throws Exception {
        Paragraph title1 = new Paragraph("Chapter 1", FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLDITALIC, new CMYKColor(0, 255, 255, 17)));
        Chapter chapter1 = new Chapter(title1,1); //章节前面编号
        chapter1.setNumberDepth(1);//将编号深度设置为 0，这样就不会在页面上显示章编号
        document.add(chapter1);
    }

    /**
     * 节是章的子元素
     * @throws Exception
     */
    @Test
    public void testSection() throws Exception{
        Paragraph title1 = new Paragraph("Chapter 1", FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLDITALIC, new CMYKColor(0, 255, 255, 17)));
        Chapter chapter1 = new Chapter(title1,1);
        chapter1.setNumberDepth(0);
        Paragraph title11 = new Paragraph("This is Section 1 in Chapter 1", FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD, new CMYKColor(0, 255, 255,17)));
        Section section1 = chapter1.addSection(title11);
        Paragraph someSectionText = new Paragraph("This text comes as part of section 1 of chapter 1.");
        section1.add(someSectionText);
        someSectionText = new Paragraph("Following is a 3 X 2 table.");
        section1.add(someSectionText);
        document.add(chapter1);//最后再add，在前面add试了试不生效
    }

    /**
     * PdfPTable 创建一个表格对象
     * @throws Exception
     */
    @Test
    public void testTable() throws Exception{

        PdfPTable table = new PdfPTable(3);
        int width3[] = {30,20,10};
        table.setWidths(width3); //批量设置宽度

        table.getDefaultCell().setBorder(0); //只对 table.addCell("...");有效，对new的PdfPCell无效

        table.setSpacingBefore(25);
        table.setSpacingAfter(25);
        PdfPCell c1 = new PdfPCell(new Phrase("Header1"));
        c1.setBorder(0);
        c1.setBorderWidthTop(2f);
        table.addCell(c1);
        PdfPCell c2 = new PdfPCell(new Phrase("Header2"));
        c2.setBorder(0);
        c2.setBorderWidthTop(2f);
        table.addCell(c2);
        PdfPCell c3 = new PdfPCell(new Phrase("Header3"));
        c3.setBorder(0);
        c3.setBorderWidthTop(2f);
        table.addCell(c3);

        table.addCell("1.1");
        table.addCell("1.2");
        table.addCell("1.3");

        PdfPCell cell = new PdfPCell(new Phrase("colSpan"));
        cell.setColspan(3);  //合并列
        cell.setFixedHeight(30);//设置固定高度
        table.addCell(cell);

        PdfPCell cell2 = new PdfPCell(new Phrase("rowSpan"));
        cell2.setRowspan(2); //合并行
        cell2.setHorizontalAlignment(Element.ALIGN_CENTER); //水平居中

        cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中


        table.addCell(cell2);

        table.addCell("2.2");
        table.addCell("2.3");
        table.addCell("3.2");
        table.addCell("3.3");


        document.add(table);
    }

    /**
     * 将一个列表添加到 PDF 文档中,列表包含多个 ListItem
     * @throws Exception
     */
    @Test
    public void testList() throws Exception{
        List list = new List(true,false,10); //第一个参数true带编号
        list.add(new ListItem("First item of List"));
        list.add(new ListItem("Second item of List"));
        document.add(list);
    }

    @Test
    public void testImage() throws Exception{
        Image image = Image.getInstance("/home/xuhaixing/Pictures/tt.png");
        image.scaleAbsolute(120f,120f);
        document.add(image);
    }


    /**
     * 中文字体  引itext-asian这个包
     * @throws Exception
     */
    @Test
    public void testChinese() throws Exception{
        BaseFont bfChinese = null;
        // FontFactory.getFont(FontFactory.COURIER,14, Font.BOLD, new CMYKColor(0, 255, 0, 0);
        bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
        Font f10 = new Font(bfChinese, 10, Font.NORMAL);
        Font f12 = new Font(bfChinese, 12, Font.BOLD);
        document.add(new Paragraph("中文字体" , f10));
        document.add(new Paragraph("是中文字体" , f12));

    }


    @After
    public void testClose(){
        document.close();//必须有close，否则打开文件提示文件损坏
    }

}
