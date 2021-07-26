/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uploadpic;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author 14168
 */
public class UploadPic {
    
    private String foodName;
    private String type;
    private int foodPrice;
     private  boolean flag=false;
     private String foodPicPath;

    public String getFoodName() {
        return foodName;
    }

    public String getType() {
        return type;
    }

    public int getFoodPrice() {
        return foodPrice;
    }

    public boolean isFlag() {
        return flag;
    }

    public String getFoodPicPath() {
        return foodPicPath;
    }
  
    
      public void upload(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
        
        String foodName = null;
        String picFile=null;
        String type=null;
        String foodPrice=null;
        
      
         SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String addTime=  formatter.format(new Date());
   
       
        
        String glassFishPathConfig;
         String glassFishPathDocroot;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
        if (!isMultipartContent) {
            return ;
        }
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
      
            List < org.apache.commons.fileupload.FileItem > fields = upload.parseRequest(request);
            Iterator < org.apache.commons.fileupload.FileItem > it = fields.iterator();
            if (!it.hasNext()) {
                return;
            }
            
            while (it.hasNext()) {
                org.apache.commons.fileupload.FileItem fileItem = it.next();
                boolean isFormField = fileItem.isFormField();
                if (isFormField) {
                    if (foodName== null) 
                        if(fileItem.getFieldName().equals("foodName") )
                        	foodName = fileItem.getString();
                        
                    if (type== null)     
                          if(fileItem.getFieldName().equals("type")) 
                        	type = fileItem.getString();
                    if (foodPrice== null) 
                         if(fileItem.getFieldName().equals("foodPrice")) 
                        	foodPrice = fileItem.getString();
                        
                    
                } else {
                    if (fileItem.getSize() > 0) {
                    //    fileItem.write(new File("E:\\uploaded_files\\" + fileItem.getName()));
                    	
                        picFile=fileItem.getName();
                         glassFishPathConfig=System.getProperty("user.dir");
                         glassFishPathDocroot= glassFishPathConfig.replace("config", "docroot");
                        File f=new File(glassFishPathDocroot+"\\img\\" + foodName+addTime+".jpg");
                       // File f = new File("../docroot/img");
                        fileItem.write(f);
                        System.out.println("Present Project Directory : "+glassFishPathDocroot);

                     }
                }
            }
                /*System.out.println(">>>>>>>>------name------"+foodName);
                System.out.println(">>>>>>>>------price------"+foodPrice);
                System.out.println(">>>>>>>>------type------"+type);
                */
            
          
            //System.out.println(foodName+","+foodPrice+","+type);
            this.foodName=foodName;
            this.foodPrice=Integer.parseInt(foodPrice);
            this.foodPicPath=("img/" +foodName+addTime);
            this.flag=true;
            this.type=type;
            //output=foodName+","+foodPrice+","+type+","+("img/" +foodName+addTime);//last is pic path name
             //       System.out.println(output);
        } catch (Exception e) {
            System.out.println("error while updode pic and ... "+e.getMessage());
        } 
       
    }
}
