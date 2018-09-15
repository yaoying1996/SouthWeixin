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
	    
	//��ʾ�ĵ�����ı���
    private String title;
    //�����������
    private String[] rowName;
    //�������ļ���
    private String fileName;

    private List<Object[]> dataList = new ArrayList<Object[]>();
    
    private HttpServletResponse response;
    
    //���췽��������Ҫ����������
    public CommonExcel(String title, String[] rowName, List<Object[]> dataList,HttpServletResponse response, String fileName) {
        this.dataList = dataList;
        this.rowName = rowName;
        this.title = title;
        this.response = response;
        this.fileName = fileName;
    }
    
    /*
     * ��������
     */
    public void downloadExcel(String email,String content) throws Exception {
    
        try {
        	
            HSSFWorkbook workbook = new HSSFWorkbook();                     // ��������������
            HSSFSheet sheet = workbook.createSheet(title);                  // ����������

            // ������������
            HSSFRow rowm = sheet.createRow(0);
            HSSFCell cellTiltle = rowm.createCell(0);

            //sheet��ʽ���塾getColumnTopStyle()/getStyle()��Ϊ�Զ��巽�� - ������  - ����չ��
            HSSFCellStyle columnTopStyle = this.getColumnTopStyle(workbook);//��ȡ��ͷ��ʽ����
            HSSFCellStyle style = this.getStyle(workbook);                  //��Ԫ����ʽ����

            sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, (rowName.length - 1)));
            cellTiltle.setCellStyle(columnTopStyle);
            cellTiltle.setCellValue(title);

            // ������������
            int columnNum = rowName.length;
            HSSFRow rowRowName = sheet.createRow(2);                // ������2��λ�ô�����(��˵��п�ʼ�ĵڶ���)

            // ����ͷ���õ�sheet�ĵ�Ԫ����
            for (int n = 0; n < columnNum; n++) {
                HSSFCell cellRowName = rowRowName.createCell(n);               //������ͷ��Ӧ�����ĵ�Ԫ��
                cellRowName.setCellType(HSSFCell.CELL_TYPE_STRING);             //������ͷ��Ԫ�����������
                HSSFRichTextString text = new HSSFRichTextString(rowName[n]);
                cellRowName.setCellValue(text);                                 //������ͷ��Ԫ���ֵ
                cellRowName.setCellStyle(columnTopStyle);                       //������ͷ��Ԫ����ʽ
            }

            //����ѯ�����������õ�sheet��Ӧ�ĵ�Ԫ����
            for (int i = 0; i < dataList.size(); i++) {
            
            	//System.out.println(dataList.get(i));
                Object[] obj = dataList.get(i);//����ÿ������
                HSSFRow row = sheet.createRow(i + 3);//�������������
            	System.out.println(obj[0].toString());
                for (int j = 0; j < obj.length; j++) {
                    HSSFCell cell = null;   //���õ�Ԫ�����������
                   
                        cell = row.createCell(j, HSSFCell.CELL_TYPE_STRING);
                        if ( obj[j] != null) {
                        	
                            cell.setCellValue(obj[j].toString());                       //���õ�Ԫ���ֵ
                        }
                    
                    cell.setCellStyle(style);                                   //���õ�Ԫ����ʽ
                }
            }
            //���п����ŵ������г��Զ���Ӧ
            for (int colNum = 0; colNum < columnNum; colNum++) {
                int columnWidth = sheet.getColumnWidth(colNum) / 256;
                for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
                    HSSFRow currentRow;
                    //��ǰ��δ��ʹ�ù�
                    if (sheet.getRow(rowNum) == null) {
                        currentRow = sheet.createRow(rowNum);
                    } else {
                        currentRow = sheet.getRow(rowNum);
                    }
                    if (currentRow.getCell(colNum) != null) {
                        HSSFCell currentCell = currentRow.getCell(colNum);
                        if (currentCell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
                        	//������Ը���excel�Ŀ��
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
     * ��ͷ��Ԫ����ʽ
     */
    public HSSFCellStyle getColumnTopStyle(HSSFWorkbook workbook) {

        // ��������
        HSSFFont font = workbook.createFont();
        //���������С
        font.setFontHeightInPoints((short) 12);
        //����Ӵ�
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //������������
        font.setFontName("΢���ź�");
        //������ʽ;
        HSSFCellStyle style = workbook.createCellStyle();
        //���õױ߿�;
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        //���õױ߿���ɫ;
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        //������߿�;
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        //������߿���ɫ;
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        //�����ұ߿�;
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        //�����ұ߿���ɫ;
        style.setRightBorderColor(HSSFColor.BLACK.index);
        //���ö��߿�;
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //���ö��߿���ɫ;
        style.setTopBorderColor(HSSFColor.BLACK.index);
        //����ʽ��Ӧ�����õ�����;
        style.setFont(font);
        //�����Զ�����;
        style.setWrapText(false);
        //����ˮƽ�������ʽΪ���ж���;
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //���ô�ֱ�������ʽΪ���ж���;
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

        return style;

    }

    /*
     * ��������Ϣ��Ԫ����ʽ
     */
    public HSSFCellStyle getStyle(HSSFWorkbook workbook) {
        // ��������
        HSSFFont font = workbook.createFont();
        //������������
        font.setFontName("΢���ź�");
        //������ʽ;
        HSSFCellStyle style = workbook.createCellStyle();
        //���õױ߿�;
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        //���õױ߿���ɫ;
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        //������߿�;
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        //������߿���ɫ;
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        //�����ұ߿�;
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        //�����ұ߿���ɫ;
        style.setRightBorderColor(HSSFColor.BLACK.index);
        //���ö��߿�;
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //���ö��߿���ɫ;
        style.setTopBorderColor(HSSFColor.BLACK.index);
        //����ʽ��Ӧ�����õ�����;
        style.setFont(font);
        //�����Զ�����;
        style.setWrapText(false);
        //����ˮƽ�������ʽΪ���ж���;
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //���ô�ֱ�������ʽΪ���ж���;
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        return style;
    }
    
    public  boolean sendMail(String subject, String to, String content, InputStream is) throws Exception {
    	 boolean isFlag = false; 
         // �ռ��˵�������
         //String to = "�ռ�������";

         // �����˵�������
         String from = "412822875@qq.com";

         // ָ�������ʼ�������Ϊ smtp.qq.com
         String host = "smtp.qq.com";  //QQ �ʼ�������

         // ��ȡϵͳ����
         Properties properties = System.getProperties();

         // �����ʼ�������
         properties.setProperty("mail.smtp.host", host);
         
         properties.put("mail.smtp.auth", "true");
         MailSSLSocketFactory sf = new MailSSLSocketFactory();
         sf.setTrustAllHosts(true);
         properties.put("mail.smtp.ssl.enable", "true");
         properties.put("mail.smtp.ssl.socketFactory", sf);
         // ��ȡĬ��session����
         authenticator = new MailAuthenticator("412822875@qq.com", "jzxretiocbbcbhcg");
         session = Session.getInstance(properties, authenticator);
         
         
         try{// ����Ĭ�ϵ� MimeMessage ����
         MimeMessage message = new MimeMessage(session);

         // Set From: ͷ��ͷ�ֶ�
         message.setFrom(new InternetAddress(from));

         // Set To: ͷ��ͷ�ֶ�
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

         // Set Subject: ͷ��ͷ�ֶ�
         message.setSubject(subject);

         // ������Ϣ��
         // ������Ϣ����
         BodyPart messageBodyPart = new MimeBodyPart();

         // ��Ϣ
         messageBodyPart.setText(content);

         // ����������Ϣ
         Multipart multipart = new MimeMultipart();

         // �����ı���Ϣ����
         multipart.addBodyPart(messageBodyPart);
         
         // ��������
         messageBodyPart = new MimeBodyPart();
         String filename = subject+".xls";
         DataSource source = new ByteArrayDataSource(is, "application/msexcel");
         messageBodyPart.setDataHandler(new DataHandler(source));
         messageBodyPart.setFileName(filename);
         multipart.addBodyPart(messageBodyPart);


         // ����������Ϣ
         message.setContent(multipart);


         // ������Ϣ
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


