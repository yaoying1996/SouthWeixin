package com.south.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;

import com.sun.mail.util.MailSSLSocketFactory;



public class CommonExcel {
	
	public final static String path1="D:/reportExcel/";
	
	  public static MailAuthenticator authenticator;
	  
	  private Session session;
	    
	//显示的导出表的标题
    private String title;
    //导出表的列名
    private String[] rowName;
    //导出的文件名
    private String fileName;

    private List<Object[]> dataList = new ArrayList<Object[]>();
    
    private HttpServletResponse response;
    
    //构造方法，传入要导出的数据
    public CommonExcel(String title, String[] rowName, List<Object[]> dataList,HttpServletResponse response, String fileName) {
        this.dataList = dataList;
        this.rowName = rowName;
        this.title = title;
        this.response = response;
        this.fileName = fileName;
    }
    
    /*
     * 导出数据
     */
    public void downloadExcel(String email,String content) throws Exception {
    
        try {
        	
            HSSFWorkbook workbook = new HSSFWorkbook();                     // 创建工作簿对象
            HSSFSheet sheet = workbook.createSheet(title);                  // 创建工作表

            // 产生表格标题行
            HSSFRow rowm = sheet.createRow(0);
            HSSFCell cellTiltle = rowm.createCell(0);

            //sheet样式定义【getColumnTopStyle()/getStyle()均为自定义方法 - 在下面  - 可扩展】
            HSSFCellStyle columnTopStyle = this.getColumnTopStyle(workbook);//获取列头样式对象
            HSSFCellStyle style = this.getStyle(workbook);                  //单元格样式对象

            sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, (rowName.length - 1)));
            cellTiltle.setCellStyle(columnTopStyle);
            cellTiltle.setCellValue(title);

            // 定义所需列数
            int columnNum = rowName.length;
            HSSFRow rowRowName = sheet.createRow(2);                // 在索引2的位置创建行(最顶端的行开始的第二行)

            // 将列头设置到sheet的单元格中
            for (int n = 0; n < columnNum; n++) {
                HSSFCell cellRowName = rowRowName.createCell(n);               //创建列头对应个数的单元格
                cellRowName.setCellType(HSSFCell.CELL_TYPE_STRING);             //设置列头单元格的数据类型
                HSSFRichTextString text = new HSSFRichTextString(rowName[n]);
                cellRowName.setCellValue(text);                                 //设置列头单元格的值
                cellRowName.setCellStyle(columnTopStyle);                       //设置列头单元格样式
            }

            //将查询出的数据设置到sheet对应的单元格中
            for (int i = 0; i < dataList.size(); i++) {
            
            	//System.out.println(dataList.get(i));
                Object[] obj = dataList.get(i);//遍历每个对象
                HSSFRow row = sheet.createRow(i + 3);//创建所需的行数
            	System.out.println(obj[0].toString());
                for (int j = 0; j < obj.length; j++) {
                    HSSFCell cell = null;   //设置单元格的数据类型
                   
                        cell = row.createCell(j, HSSFCell.CELL_TYPE_STRING);
                        if ( obj[j] != null) {
                        	
                            cell.setCellValue(obj[j].toString());                       //设置单元格的值
                        }
                    
                    cell.setCellStyle(style);                                   //设置单元格样式
                }
            }
            //让列宽随着导出的列长自动适应
            for (int colNum = 0; colNum < columnNum; colNum++) {
                int columnWidth = sheet.getColumnWidth(colNum) / 256;
                for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
                    HSSFRow currentRow;
                    //当前行未被使用过
                    if (sheet.getRow(rowNum) == null) {
                        currentRow = sheet.createRow(rowNum);
                    } else {
                        currentRow = sheet.getRow(rowNum);
                    }
                    if (currentRow.getCell(colNum) != null) {
                        HSSFCell currentCell = currentRow.getCell(colNum);
                        if (currentCell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
                        	//这里可以更改excel的宽度
                            int length = currentCell.getStringCellValue().getBytes().length+4;
                            if (columnWidth < length) {
                                columnWidth = length;
                            }
                        }
                    }
                }
                if (colNum == 0) {
                    sheet.setColumnWidth(colNum, (columnWidth - 2) * 256);
                } else {
                    sheet.setColumnWidth(colNum, (columnWidth + 4) * 256);
                }
            }

            if (workbook != null) {
                try {
                   /* if (response != null) {
                        response.setContentType("application/vnd.ms-excel;charset=utf-8");
                        response.setHeader("Content-Disposition", "attachment;filename=\""+new String(fileName.getBytes("gb2312"),"ISO8859-1"));
                        OutputStream out = response.getOutputStream();
                        workbook.write(out);
                        out.close();
                    
                       
                    } else {*/
                    	
                    	/*File file=new File(path1);
                    	if(!file.exists()) file.mkdirs();
                        FileOutputStream outputStream = new FileOutputStream(path1+fileName);
                        workbook.write(outputStream);
                        outputStream.close();*/
                        
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        workbook.write(baos);
                        baos.flush();
                        byte[] bt = baos.toByteArray();
                        InputStream is = new ByteArrayInputStream(bt, 0, bt.length);
                        baos.close();
                        
                       sendMail(fileName, email, content , is);
                    //}
                    
                    
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
      
    }

    /*
     * 列头单元格样式
     */
    public HSSFCellStyle getColumnTopStyle(HSSFWorkbook workbook) {

        // 设置字体
        HSSFFont font = workbook.createFont();
        //设置字体大小
        font.setFontHeightInPoints((short) 12);
        //字体加粗
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //设置字体名字
        font.setFontName("微软雅黑");
        //设置样式;
        HSSFCellStyle style = workbook.createCellStyle();
        //设置底边框;
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        //设置底边框颜色;
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        //设置左边框;
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        //设置左边框颜色;
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        //设置右边框;
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        //设置右边框颜色;
        style.setRightBorderColor(HSSFColor.BLACK.index);
        //设置顶边框;
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //设置顶边框颜色;
        style.setTopBorderColor(HSSFColor.BLACK.index);
        //在样式用应用设置的字体;
        style.setFont(font);
        //设置自动换行;
        style.setWrapText(false);
        //设置水平对齐的样式为居中对齐;
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

        return style;

    }

    /*
     * 列数据信息单元格样式
     */
    public HSSFCellStyle getStyle(HSSFWorkbook workbook) {
        // 设置字体
        HSSFFont font = workbook.createFont();
        //设置字体名字
        font.setFontName("微软雅黑");
        //设置样式;
        HSSFCellStyle style = workbook.createCellStyle();
        //设置底边框;
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        //设置底边框颜色;
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        //设置左边框;
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        //设置左边框颜色;
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        //设置右边框;
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        //设置右边框颜色;
        style.setRightBorderColor(HSSFColor.BLACK.index);
        //设置顶边框;
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //设置顶边框颜色;
        style.setTopBorderColor(HSSFColor.BLACK.index);
        //在样式用应用设置的字体;
        style.setFont(font);
        //设置自动换行;
        style.setWrapText(false);
        //设置水平对齐的样式为居中对齐;
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        return style;
    }
    
    public  boolean sendMail(String subject, String to, String content, InputStream is) throws Exception {
    	 boolean isFlag = false; 
         // 收件人电子邮箱
         //String to = "收件人邮箱";

         // 发件人电子邮箱
         String from = "412822875@qq.com";

         // 指定发送邮件的主机为 smtp.qq.com
         String host = "smtp.qq.com";  //QQ 邮件服务器

         // 获取系统属性
         Properties properties = System.getProperties();

         // 设置邮件服务器
         properties.setProperty("mail.smtp.host", host);
         
         properties.put("mail.smtp.auth", "true");
         MailSSLSocketFactory sf = new MailSSLSocketFactory();
         sf.setTrustAllHosts(true);
         properties.put("mail.smtp.ssl.enable", "true");
         properties.put("mail.smtp.ssl.socketFactory", sf);
         // 获取默认session对象
         authenticator = new MailAuthenticator("412822875@qq.com", "jzxretiocbbcbhcg");
         session = Session.getInstance(properties, authenticator);
         
         
         try{// 创建默认的 MimeMessage 对象
         MimeMessage message = new MimeMessage(session);

         // Set From: 头部头字段
         message.setFrom(new InternetAddress(from));

         // Set To: 头部头字段
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

         // Set Subject: 头部头字段
         message.setSubject(subject);

         // 设置消息体
         // 创建消息部分
         BodyPart messageBodyPart = new MimeBodyPart();

         // 消息
         messageBodyPart.setText(content);

         // 创建多重消息
         Multipart multipart = new MimeMultipart();

         // 设置文本消息部分
         multipart.addBodyPart(messageBodyPart);
         
         // 附件部分
         messageBodyPart = new MimeBodyPart();
         String filename = subject+".xls";
         DataSource source = new ByteArrayDataSource(is, "application/msexcel");
         messageBodyPart.setDataHandler(new DataHandler(source));
         messageBodyPart.setFileName(filename);
         multipart.addBodyPart(messageBodyPart);


         // 发送完整消息
         message.setContent(multipart);


         // 发送消息
         Transport.send(message);
         System.out.println("Sent message successfully....from runoob.com");
         isFlag = true; 
         }catch (MessagingException mex) {
             mex.printStackTrace();
             isFlag = false; 
         }
         return isFlag;
    }
    
    
}


