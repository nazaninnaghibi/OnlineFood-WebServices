/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicepack.MyWebService_Service;

/**
 *
 * @author 14168
 */
@WebServlet(name = "SigninHandler", urlPatterns = {"/SigninHandler"})
public class SigninHandler extends HttpServlet {

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
       ServletContext sc=getServletContext();
        RequestDispatcher rd=sc.getRequestDispatcher("/HomeHandlerServlet");
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
       // System.out.println("start sign in servlet");
        String userName=req.getParameter("si-username");
        String password=req.getParameter("si-password");
       
         MyWebService_Service service=new MyWebService_Service();
        servicepack.MyWebService port = service.getMyWebServicePort();
         ServletContext sc=getServletContext();
          RequestDispatcher rd;
                  
        if(userName.equals("admin") && password.equals("admin")){
                req.getSession().setAttribute("user_name", "admin");
                req.getSession().setAttribute("user_id","admin" );
                 rd=sc.getRequestDispatcher("/HomeHandlerServlet");
        }
        else{
             String signinReport=port.signin(userName,password);
             
            String[] arr;
            if(signinReport.contains("1")){
                arr=signinReport.split(",");
                req.getSession().setAttribute("user_name", arr[0]);
                req.getSession().setAttribute("user_id", arr[1]);

                // System.out.println("nammmmmmme0: "+arr[1]);
                signinReport="1";    
            }
            req.setAttribute("signinReport", signinReport);
             rd=sc.getRequestDispatcher("/HomeHandlerServlet");
        }
        
       rd.forward(req,resp);
       
        
        
       
      //  System.out.println("end sign in servlet");
        
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
