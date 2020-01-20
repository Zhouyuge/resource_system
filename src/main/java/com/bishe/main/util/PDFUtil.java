package com.bishe.main.util;

/**
 * @author Kirito
 * @Date 2019/11/30 13:49
 */
import com.bishe.main.vo.SelfDetailVO;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.FileOutputStream;

public class PDFUtil{
    private static Font headfont ;// 设置字体大小
    private static Font keyfont;// 设置字体大小
    private static Font textfont;// 设置字体大小

    static{
        BaseFont bfChinese;
        try {
            //bfChinese = BaseFont.createFont("STSong-Light","UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
            bfChinese = BaseFont.createFont("STSong-Light","UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);//支持中文

            headfont = new Font(bfChinese, 10, Font.BOLD);// 设置字体大小
            keyfont = new Font(bfChinese, 10, Font.BOLD);// 设置字体大小
            textfont = new Font(bfChinese, 8, Font.NORMAL);// 设置字体大小
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String writeCharpter(SelfDetailVO selfDetailVO) throws Exception{
//新建document对象  第一个参数是页面大小。接下来的参数分别是左、右、上和下页边距。
        Document document = new Document(PageSize.A4, 20, 20, 20, 20);
//建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中。

        String file = "d:\\ITextTest.pdf";

        PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream(file));
//打开文件
        document.open();
        //加列表
        PdfPTable table = new PdfPTable(4);
        //// 设置表格宽度比例为%100
        table.setWidthPercentage(80);
        // 设置表格的宽度
        table.setTotalWidth(500);
        // 也可以每列分别设置宽度
//        table.setTotalWidth(new float[] { 200, 100, 100, 100 });
        // 锁住宽度
//        table.setLockedWidth(true);
        // 设置表格上面空白宽度
        table.setSpacingBefore(10f);
        // 设置表格下面空白宽度
        table.setSpacingAfter(10f);
        // 设置表格默认为无边框
        table.getDefaultCell().setBorder(0);

        // 在表格添加图片
        Image cellimg = Image.getInstance("http://localhost:10086/img/h_img/mine.png");
        PdfPCell cell=new PdfPCell(cellimg,true);
//        PdfPCell cell = new PdfPCell(new Phrase("头像",keyfont));
        cell.setRowspan(4);
        // 设置距左边的距离
        cell.setPaddingLeft(10);
        // 设置无边框
        cell.setBorder(Rectangle.NO_BORDER);
        // 设置高度
        cell.setFixedHeight(20);
        // 设置垂直居中
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);


        PdfPCell pCell2 = new PdfPCell();
        pCell2.setPhrase(new Phrase("姓名: "+ selfDetailVO.getName(),textfont));
        pCell2.setBorder(Rectangle.NO_BORDER);
        // 设置占用列数
        pCell2.setColspan(3);
        pCell2.setPaddingLeft(10);
        pCell2.setFixedHeight(20);
        // 设置内容水平居中显示
        pCell2.setHorizontalAlignment(Element.ALIGN_LEFT);
        // 设置垂直居中
        pCell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(pCell2);

        PdfPCell pCell3 = new PdfPCell();
        pCell3.setBorder(Rectangle.NO_BORDER);
        pCell3.setPhrase(new Phrase("年龄: " + selfDetailVO.getAge(),textfont));
        pCell3.setColspan(1);
        pCell3.setPaddingLeft(10);
        pCell3.setFixedHeight(20);
        // 设置内容水平居中显示
        pCell3.setHorizontalAlignment(Element.ALIGN_LEFT);
        // 设置垂直居中
        pCell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(pCell3);

        PdfPCell pCell6 = new PdfPCell();
        pCell6.setBorder(Rectangle.NO_BORDER);
        pCell6.setPhrase(new Phrase("教育：" + selfDetailVO.getEdu(),textfont));
        pCell6.setColspan(1);
        pCell6.setPaddingLeft(10);
        pCell6.setFixedHeight(20);
        // 设置内容水平居中显示
        pCell6.setHorizontalAlignment(Element.ALIGN_LEFT);
        // 设置垂直居中
        pCell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(pCell6);

        PdfPCell pCellS = new PdfPCell();
        pCellS.setBorder(Rectangle.NO_BORDER);
        pCellS.setPhrase(new Phrase("毕业学校：" + selfDetailVO.getSchool(),textfont));
        pCellS.setColspan(1);
        pCellS.setPaddingLeft(10);
        pCellS.setFixedHeight(20);
        // 设置内容水平居中显示
        pCellS.setHorizontalAlignment(Element.ALIGN_LEFT);
        // 设置垂直居中
        pCellS.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(pCellS);


        PdfPCell pCellSkill = new PdfPCell();
        pCellSkill.setBorder(Rectangle.NO_BORDER);
        pCellSkill.setPhrase(new Phrase("个人技能：" + selfDetailVO.getSkill(),textfont));
        pCellSkill.setColspan(4);
        pCellSkill.setPaddingLeft(10);
        pCellSkill.setFixedHeight(20);
        // 设置内容水平居中显示
        pCellSkill.setHorizontalAlignment(Element.ALIGN_LEFT);
        // 设置垂直居中
        pCellSkill.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(pCellSkill);

        PdfPCell pCell4 = new PdfPCell();
        pCell4.setBorder(Rectangle.NO_BORDER);
        pCell4.setPhrase(new Phrase("电话: " + selfDetailVO.getTel(), textfont));
        pCell2.setColspan(1);
        pCell4.setPaddingLeft(10);
        pCell4.setFixedHeight(20);
        // 设置内容水平居中显示
        pCell4.setHorizontalAlignment(Element.ALIGN_LEFT);
        // 设置垂直居中
        pCell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(pCell4);

        PdfPCell pCell5 = new PdfPCell();
        pCell5.setBorder(Rectangle.NO_BORDER);
        pCell5.setPhrase(new Phrase("邮箱: " + selfDetailVO.getEmail(), textfont));
        pCell5.setColspan(1);
        pCell5.setPaddingLeft(10);
        pCell5.setFixedHeight(20);
        // 设置内容水平居中显示
        pCell5.setHorizontalAlignment(Element.ALIGN_CENTER);
        // 设置垂直居中
        pCell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(pCell5);

        PdfPCell pCellSex = new PdfPCell();
        pCellSex.setBorder(Rectangle.NO_BORDER);
        pCellSex.setPhrase(new Phrase("性别 : " + selfDetailVO.getSex(), textfont));
        pCellSex.setColspan(1);
        pCellSex.setPaddingLeft(10);
        pCellSex.setFixedHeight(20);
        // 设置内容水平居中显示
        pCellSex.setHorizontalAlignment(Element.ALIGN_CENTER);
        // 设置垂直居中
        pCellSex.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(pCellSex);

        PdfPCell pCell7 = new PdfPCell();
        pCell7.setBorder(Rectangle.NO_BORDER);
        pCell7.setPhrase(new Phrase("| 自我描述",keyfont));
        pCell7.setColspan(4);
        pCell7.setPaddingLeft(10);
        pCell7.setFixedHeight(20);
        table.addCell(pCell7);

        PdfPCell pCell8 = new PdfPCell();
        pCell8.setBorder(Rectangle.NO_BORDER);
        pCell8.setPhrase(new Phrase(selfDetailVO.getSelfDesc(),textfont));
        pCell8.setColspan(4);
        pCell8.setPaddingLeft(10);
        pCell8.setFixedHeight(20);
        pCell8.setHorizontalAlignment(Element.ALIGN_LEFT);
        pCell8.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(pCell8);

        PdfPCell workExp = new PdfPCell();
        workExp.setBorder(Rectangle.NO_BORDER);
        workExp.setPhrase(new Phrase("| 工作经历",keyfont));
        workExp.setColspan(4);
        workExp.setPaddingLeft(10);
        workExp.setFixedHeight(20);
        workExp.setHorizontalAlignment(Element.ALIGN_LEFT);
        workExp.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(workExp);

        PdfPCell corpName = new PdfPCell();
        corpName.setBorder(Rectangle.NO_BORDER);
        corpName.setPhrase(new Phrase("公司名称: " + selfDetailVO.getWorkName(),textfont));
        corpName.setColspan(1);
        corpName.setPaddingLeft(10);
        corpName.setFixedHeight(20);
        corpName.setHorizontalAlignment(Element.ALIGN_LEFT);
        corpName.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(corpName);

        PdfPCell corpTime = new PdfPCell();
        corpTime.setBorder(Rectangle.NO_BORDER);
        corpTime.setPhrase(new Phrase("时间: " + selfDetailVO.getWorkDate(),textfont));
        corpTime.setColspan(1);
        corpTime.setPaddingLeft(10);
        corpTime.setFixedHeight(20);
        corpTime.setHorizontalAlignment(Element.ALIGN_LEFT);
        corpTime.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(corpTime);


        PdfPCell workName = new PdfPCell();
        workName.setBorder(Rectangle.NO_BORDER);
        workName.setPhrase(new Phrase("任职职务: " + selfDetailVO.getWorkType(),textfont));
        workName.setColspan(3);
        workName.setPaddingLeft(10);
        workName.setFixedHeight(20);
        workName.setHorizontalAlignment(Element.ALIGN_LEFT);
        workName.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(workName);

        PdfPCell workExperience = new PdfPCell();
        workExperience.setBorder(Rectangle.NO_BORDER);
        workExperience.setPhrase(new Phrase("工作内容: " + selfDetailVO.getWorkExpirence(),textfont));
        workExperience.setColspan(4);
        workExperience.setPaddingLeft(10);
        workExperience.setFixedHeight(20);
        workExperience.setHorizontalAlignment(Element.ALIGN_LEFT);
        workExperience.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(workExperience);

        PdfPCell jobExp = new PdfPCell();
        jobExp.setBorder(Rectangle.NO_BORDER);
        jobExp.setPhrase(new Phrase("| 项目经历",keyfont));
        jobExp.setColspan(4);
        jobExp.setPaddingLeft(10);
        jobExp.setFixedHeight(20);
        jobExp.setHorizontalAlignment(Element.ALIGN_LEFT);
        jobExp.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(jobExp);


        PdfPCell jobName = new PdfPCell();
        jobName.setBorder(Rectangle.NO_BORDER);
        jobName.setPhrase(new Phrase("项目名称: " + selfDetailVO.getProductName(),textfont));
        jobName.setColspan(1);
        jobName.setPaddingLeft(10);
        jobName.setFixedHeight(20);
        jobName.setHorizontalAlignment(Element.ALIGN_LEFT);
        jobName.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(jobName);

        PdfPCell jobTime = new PdfPCell();
        jobTime.setBorder(Rectangle.NO_BORDER);
        jobTime.setPhrase(new Phrase("项目时间: " + selfDetailVO.getProductDate(),textfont));
        jobTime.setColspan(1);
        jobTime.setPaddingLeft(10);
        jobTime.setFixedHeight(20);
        jobTime.setHorizontalAlignment(Element.ALIGN_LEFT);
        jobTime.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(jobTime);

        PdfPCell jobType = new PdfPCell();
        jobType.setBorder(Rectangle.NO_BORDER);
        jobType.setPhrase(new Phrase("担任职务: " + selfDetailVO.getWorkType(),textfont));
        jobType.setColspan(3);
        jobType.setPaddingLeft(10);
        jobType.setFixedHeight(20);
        jobType.setHorizontalAlignment(Element.ALIGN_LEFT);
        jobType.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(jobType);


        PdfPCell jobDescr = new PdfPCell();
        jobDescr.setBorder(Rectangle.NO_BORDER);
        jobDescr.setPhrase(new Phrase("项目经历: " + selfDetailVO.getProductExpirence(),textfont));
        jobDescr.setColspan(4);
        jobDescr.setPaddingLeft(10);
        jobDescr.setFixedHeight(20);
        jobDescr.setHorizontalAlignment(Element.ALIGN_LEFT);
        jobDescr.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(jobDescr);

        document.add(table);

//关闭文档
        document.close();
        return file;
    }

    public static void main(String[] args) throws Exception {

    }
}