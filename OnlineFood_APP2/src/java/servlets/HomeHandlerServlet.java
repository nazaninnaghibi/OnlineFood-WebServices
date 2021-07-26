/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URLDecoder;
import java.net.UnknownHostException;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import servicepack.FoodModel;
import servicepack.MyWebService_Service;

/**
 *
 * @author 14168
 */
@WebServlet(name = "HomeHandlerServlet", urlPatterns = {"/HomeHandlerServlet"})
public class HomeHandlerServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/OnlineFood_WS/MyWebService.wsdl")
    private MyWebService_Service service;

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
            // TODO output your page here. You may use following sample code.
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletHandler</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletHandler at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } 
       //doGet(request,response);
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


           //    System.out.println("start of home servlet");
        String signout=req.getParameter("signed");
        if(signout!=null && signout.equals("signed_out"))
        {
            req.getSession().removeAttribute("user_name");
              req.getSession().removeAttribute("user_id");
        }
        MyWebService_Service service=new MyWebService_Service();
       
         servicepack.MyWebService port = service.getMyWebServicePort();
         List<FoodModel> allFoodList=port.getFoodsHome();
         
         List<FoodModel> foodList=new ArrayList<>();
         List<FoodModel> drinkList=new ArrayList<>();
         List<FoodModel> sauceList=new ArrayList<>();
         
          for(int i=0;i<allFoodList.size();i++)
              switch(allFoodList.get(i).getType()){
                  case "food":
                      foodList.add(allFoodList.get(i));
                      break;
                  case "drink":
                       drinkList.add(allFoodList.get(i));
                      break;
                  case "sas":
                       sauceList.add(allFoodList.get(i));
                      break;
                      
              }
          
          req.setAttribute("foodList",foodList);
          req.setAttribute("drinkList",drinkList);
          req.setAttribute("sauceList",sauceList);
          
         /* System.out.println(foodList.toString());
          System.out.println(drinkList.toString());
          System.out.println(sauceList.toString());
         */ 
        
     
        ServletContext sc=getServletContext();
        RequestDispatcher rd=sc.getRequestDispatcher("/pages/home.jsp");
        rd.forward(req,resp);

           // System.out.println((String)req.getSession().getAttribute("user"));

        
      
      
        
               //        System.out.println("end of home servlet");

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
     //   System.out.println("do post home servlet");
        doGet(req,resp);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
    
   
}
// </editor-fold>

    


