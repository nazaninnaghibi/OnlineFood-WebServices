/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicepack.MyWebService_Service;
import servicepack.OrderModel;




/**
 *
 * @author 14168
 */
@WebServlet(name = "OrderReportHandler", urlPatterns = {"/OrderReportHandler"})
public class OrderReportHandler extends HttpServlet {

    public List<List<OrderModel>> getOrderReformed( List<OrderModel> uniqOrderList){
      
        List<OrderModel> orderList=new ArrayList<>();
        List< List<OrderModel>> allOrderList=new ArrayList<>();
        boolean flag=false;
        
        for(int i=0;i<uniqOrderList.size();i++)
        {
            
            if(uniqOrderList.get(i).getOrderId()!=-1){
                orderList.add(uniqOrderList.get(i));
               flag=true;
            }
            else if(uniqOrderList.get(i).getOrderId()==-1 && flag)
            {
                allOrderList.add(orderList);
                orderList=new ArrayList<>();;
                 flag=false;
            }
        }
        /*
         System.out.println("--------client----------");
        for(int i=0;i<allOrderList.size();i++)
        {
              System.out.println("--------order number :"+i+"-----------");
            for(int j=0;j<(allOrderList.get(i)).size();j++)
            {
                  System.out.println( allOrderList.get(i).get(j).toString());
            }
              System.out.println(" ********************");
              System.out.println(" ********************");
       
    }*/
        return allOrderList;
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OrderReportHandler</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OrderReportHandler at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
       String user_id=(String) request.getSession().getAttribute("user_id");
       
        MyWebService_Service service=new MyWebService_Service();
        servicepack.MyWebService port = service.getMyWebServicePort();
        List<List<OrderModel>> allOrders=getOrderReformed(port.getOrder(user_id));
         
        request.setAttribute("allOrders", allOrders);
        ServletContext sc=getServletContext();
        RequestDispatcher rd=sc.getRequestDispatcher("/pages/orderreport.jsp");
       
        rd.forward(request,response);
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
       String orderId=request.getParameter("orderId");
        MyWebService_Service service=new MyWebService_Service();
        servicepack.MyWebService port = service.getMyWebServicePort();
        
        port.setReceived(orderId);
        doGet(request,response);
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
