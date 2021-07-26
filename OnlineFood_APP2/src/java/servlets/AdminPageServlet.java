/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;
/*
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
*/
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import servicepack.FoodModel;
import servicepack.MyWebService_Service;
import servicepack.OrderModel;



import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;
import javax.jws.WebMethod;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import java.util.Iterator;
import uploadpic.UploadPic;


/**
 *
 * @author 14168
 */
@WebServlet(name = "AdminPageServlet", urlPatterns = {"/AdminPageServlet"})
public class AdminPageServlet extends HttpServlet {

    public List< List<List<OrderModel>>> getAllOrderReformed(List<OrderModel> uniqOrderList ){

        List<OrderModel> orderList=new ArrayList<>();
        List<List<OrderModel>> allOrderList=new ArrayList<>();
        List< List<List<OrderModel>>> allOrderListAll=new ArrayList<>();
        boolean flag1=false;
        boolean flag2=false;
           
         for(int i=0;i<uniqOrderList.size();i++)
        {
            
            
             if(uniqOrderList.get(i).getOrderId()!=-2){
               
                if(uniqOrderList.get(i).getOrderId()!=-1){
                orderList.add(uniqOrderList.get(i));
                flag1=true;
                }
                else if(uniqOrderList.get(i).getOrderId()==-1 && flag1)
                {
                    allOrderList.add(orderList);
                    orderList=new ArrayList<>();;
                     flag1=false;
                }
                
                
               flag2=true;
            }
            else if(uniqOrderList.get(i).getOrderId()==-2 && flag2)
            {
                allOrderListAll.add(allOrderList);
                allOrderList=new ArrayList<>();;
                 flag2=false;
            }
        }
         /*
         System.out.println("--------show----------");
        for(int i=0;i<allOrderListAll.size();i++)
        {
              System.out.println("--------customer number :"+i+"-----------");
            for(int j=0;j<allOrderListAll.get(i).size();j++)
            {
                
                System.out.println("--------order number :"+j+"-----------");
                for(int k=0;k<allOrderListAll.get(i).get(j).size();k++)
                {
                    System.out.println( allOrderListAll.get(i).get(j).get(k).toString());
                }
                 System.out.println(" ********************");
            }
              System.out.println(" ********************");
            
       
         }*/
        return allOrderListAll;
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       doPost(request,response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          MyWebService_Service service=new MyWebService_Service();
        servicepack.MyWebService port = service.getMyWebServicePort();
        
          //String foodName=request.getParameter("foodName");
            //String type=request.getParameter("type");
            //String foodPrice=request.getParameter("foodPrice");
             //UploadPic up=new UploadPic(); 
             
           //  String uploadPicResult=uploadPic(request,response);
         //    System.out.println("*********  uploadPicResult :"+uploadPicResult);
               UploadPic up=new UploadPic();
               up.upload(request, response);
               
        if(up.isFlag()){
             //  System.out.println(">>>>>>>>>>>>>>>>>>>> not null");
               // String addFoodInfo=up.getOutput(request, response);
               //  System.out.println(">>>>>>>>------output------"+up.getOutput());
            /*  System.out.println(">>>>>>>>------name------"+addFoodInfo[0]);
                System.out.println(">>>>>>>>------price------"+addFoodInfo[1]);
                System.out.println(">>>>>>>>------type------"+addFoodInfo[2]); 
              */ 
            
            
             String foodName=up.getFoodName();
            int foodPrice=up.getFoodPrice();
            String type=up.getType();
            String picPath=up.getFoodPicPath();
            String addFoodResult=port.addFood(foodName, foodPrice, type,picPath);
            request.setAttribute("addFoodResult", addFoodResult);
           //  System.out.println("********* addFoodResult :"+addFoodResult);
            //    System.out.println("********* addFoodResult ");
            
           }    
              else
                 System.out.println(">>>>>>>>>>>>>>>>>>>>upload null");
           
               
            
            
                
       
        
       
        
         String FoodId_avaluableFood=request.getParameter("avaluable");
        String FoodId_deleteFood=request.getParameter("delete");
         
          
        
          
         
         
        String orderId=request.getParameter("orderId");
       if(orderId!=null)
            port.setSend(orderId);
        
       if(FoodId_deleteFood!=null){
           String deleteFooodResult=port.deleteFood(FoodId_deleteFood);
           request.setAttribute("deleteFooodResult", deleteFooodResult);
           
       }
           
        if(FoodId_avaluableFood!=null){
          String availableResult=port.setAvaluable(FoodId_avaluableFood); 
          request.setAttribute("availableResult", availableResult);
        }
           
           List<FoodModel> allFoodList=port.getFoodsHome();  
       
        List< List<List<OrderModel>>> allOrderListAll=getAllOrderReformed(port.getAllOrders());
        
        request.setAttribute("allOrderListAll", allOrderListAll);
        request.setAttribute("allFoodList", allFoodList);
        
       ServletContext sc=getServletContext();
        RequestDispatcher rd=sc.getRequestDispatcher("/pages/admin.jsp");
        rd.forward(request,response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

   
    
  

}
