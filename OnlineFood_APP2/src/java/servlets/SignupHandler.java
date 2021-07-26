/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicepack.CustomerModel;
import servicepack.FoodModel;
import servicepack.MyWebService_Service;

/**
 *
 * @author 14168
 */
@WebServlet(name = "SignupHandler", urlPatterns = {"/SignupHandler"})
public class SignupHandler extends HttpServlet {

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
             //TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SignupHandler</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignupHandler at " + request.getContextPath() + "</h1>");
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ServletContext sc=getServletContext();
        RequestDispatcher rd=sc.getRequestDispatcher("/HomeHandlerServlet");
        rd.forward(req,resp);
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //System.out.println("ddddddddddddo post SignupHandler");
        
        String fullName=req.getParameter("fullname");
        String userName=req.getParameter("su-username");
        String password=req.getParameter("su-password");
        String address=req.getParameter("address");
        String phone=req.getParameter("phone");
        
        
        CustomerModel customer=new CustomerModel();
        
        customer.setFullName(fullName);
        customer.setUsername(userName);
        customer.setAddress(address);
        customer.setPhone(phone);
        customer.setPassword(password);
        
        MyWebService_Service service=new MyWebService_Service();
        servicepack.MyWebService port = service.getMyWebServicePort();
         
        String addUserReport=port.addUser(customer);
       
      /*  if(addUserReport.contains("1")){
            String[] arr= addUserReport.split(",");
            req.getSession().setAttribute("user_name", arr[1]);
            req.getSession().setAttribute("user_id", arr[0]);
            addUserReport="1";
        }*/
      if(!addUserReport.equals("0")){
        
           // req.getSession().setAttribute("user_name", arr[1]);
           req.getSession().setAttribute("user_name",fullName );
            req.getSession().setAttribute("user_id", addUserReport);
            addUserReport="1";
        }
      
        System.out.println(addUserReport);
        
        req.setAttribute("addUserReport", addUserReport);
       
        
        ServletContext sc=getServletContext();
        RequestDispatcher rd=sc.getRequestDispatcher("/HomeHandlerServlet");
        rd.forward(req,resp);
        
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
