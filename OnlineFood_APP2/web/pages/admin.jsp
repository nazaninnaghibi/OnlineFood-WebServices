<%-- 
    Document   : admin
    Created on : Apr 13, 2021, 12:08:39 AM
    Author     : 14168
--%>

<%@page import="servicepack.FoodModel"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="servicepack.OrderModel"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="icon" href="http://localhost:8080/icon.ico">
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>manage - online foods</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/assets/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/assets/css/drinkFood.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/assets/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/assets/css/footer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/assets/css/myfrmw.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/assets/css/admin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/assets/css/popup.css">
      <style>
   .order-filter > select>option{font-size: .75em;}
    .order-filter > select{
        text-shadow: 0 0 20px #350a0a8c;
        /* padding-top: 40px; */
        /* padding: 200px 0; */
        font-size: 1.8em;
        background: #644377;
        background: -webkit-linear-gradient(to right, #9116a5 0%,#ef4900 100%);
        background: -moz-linear-gradient(to right, #9116a5 0%,#ef4900 100%);
        background: linear-gradient(to right, #9116a5 0%, #ef4900 100%);
        -webkit-background-clip: text;
        -webkit-text-fill-color: transparent;
        width: auto!important;
        text-align: center;
        /*margin-top: 20px;*/
        margin-bottom: -32px;
    }
    .order-filter{
        text-align: center;
    }
   .received-order-section{
         display:none;
   }
   .sending-order-section{
         display:none;
   }
</style> 
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.css">
   <%
        
        if(request.getSession().getAttribute("user_name")==null)
        {
            ServletContext sc1=getServletContext();
             RequestDispatcher rd1=sc1.getRequestDispatcher("/HomeHandlerServlet");
             rd1.forward(request,response);
        }
    
  %>
</head>

<body>

<header>
    <div class="overlay f-center">
        <div class="flex fx-jus-cen fx-al-cen f-center customer-pannel fx-wp">
             <a href="<%=request.getContextPath()%>/HomeHandlerServlet">
                <button class=" order-list">HOME</button>
            </a>
            <a href="<%=request.getContextPath()%>/HomeHandlerServlet?signed=signed_out">
                <button class="sign-out-btn ">SIGN OUT</button>
            </a>
            <h2 class="">ADMINISTRATOR PANNEL</h2>
        </div>
        <button class="manage-foods-btn">Manage Foods</button>
        <button class="order-reports-btn">Order Reports</button>

    </div>
</header>

<div class="addfood-popup-container">
    <div class="background"></div>
    <div class="addfood-popup">
        <form action="<%=request.getContextPath()%>/AdminPageServlet"  enctype="multipart/form-data" id="addfood-form" method="post">
            <div class="f-center popup-header">
                <h2>Add Food</h2>
            </div>
            <table class="aut-mrg">
                <tr>
                    <td><input required type="text" placeholder="Food Name" name="foodName"></td>
                </tr>
                <tr>
                    <td><input  required type="text" placeholder="Food Price" name="foodPrice"></td>
                </tr>
                <tr>
                    <td>food pic<br/><input required type="file" name="file2" ></td>
                </tr>
                <tr>
                    <td>
                        <select required name="type" id="">
                            <option value="drink">drink</option>
                            <option value="food">food</option>
                            <option value="sas">sauce</option>
                        </select>
                    </td>
                </tr>
                <tr class="f-center">
                    <td><input type="submit" class="add-food-final-btn button" value="Add"></td>
                </tr>
            </table>
        </form>
    </div>
</div>
                
                
<!--//main-->

<div class="f-container  f-center ">

    <div class="report-container ">
        <h3 class="admin-head">order reports</h3>
        
        <div class="order-filter">
            <select name="filter" id="filter">

                <option value="cooking"> Cooking orders</option>
                <option value="received"> Received orders</option>
               <option value="sending"> Sendeing orders</option>
            </select>
        </div>
        
        
        
        
      <div class="received-order-section" >  
        <%
        List< List<List<OrderModel>>> allOrderListAll=(List< List<List<OrderModel>>>)request.getAttribute("allOrderListAll");
        {
 int received_order_count=0;
 int received_section_count=0;
  int received_user_count=0;
       /* if(allOrderListAll.size()==0)
           out.println("<div class=\"f-container main-border f-center order-container\">\n"+
               "<h2 class=\"no-order\">you dont have any order list yet!</h2></div>");
*/
        String outpage="";
        String userInfo="";
        String orderTable="";
        String orderSection="";
        
        String orderTime="";
        Date orderTimed;
        String rowspan="";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        
        String name="";
        String phone="";
        String address="";
        String non_dis="";
         String rowspan2="";
        int orderId=0;
        
      for(int i=0;i<allOrderListAll.size();i++)
        {
              for(int j=0;j<allOrderListAll.get(i).size();j++)
            {
                for(int k=0;k<allOrderListAll.get(i).get(j).size();k++)
                {
                     name=allOrderListAll.get(i).get(j).get(k).getFullName();
                     phone=allOrderListAll.get(i).get(j).get(k).getPhone();
                     address=allOrderListAll.get(i).get(j).get(k).getAddress();
                }
            }
              userInfo ="<div class=\"main-border f-center\">\n"+
        "    <ul class=\"basic-info-user f-center\">\n"+
        "        <li><span>name</span><span>"+name+"</span></li>\n"+
        "        <li><span>phone</span><span>"+phone+"</span></li>\n"+
        "        <li><span>address</span><span>"+address+"</span></li>\n"+
        "    </ul>\n";
              
              
            orderSection="";
            received_section_count=0;
            
            for(int j=0;j<allOrderListAll.get(i).size();j++)
            {
                
                
                
                
                
                orderTable="<div class=\"report-order-section admin-section\">\n"+
        "        <div class=\"order-info\">\n"+
        "            <table>\n"+
        "                <tr>\n"+
        "                    <th>Food Name</th>\n"+
        "                    <th>Count</th>\n"+
        "                    <th  class=\"sm-non-dis\">Price</th>\n"+
        "                    <th  class=\"sm-non-dis\">Status</th>\n"+
        "                    <th>Order Time</th>\n"+
        "                    <th>Total Price</th>\n"+
        "                </tr>\n";
                received_order_count=0;
                for(int k=0;k<allOrderListAll.get(i).get(j).size();k++)
                {
                   if(allOrderListAll.get(i).get(j).get(k).getStatus().equals("received")){
                            received_order_count++;
                             rowspan2="";
                            orderId=  allOrderListAll.get(i).get(j).get(k).getOrderId();
                            non_dis="non-dis";
                            if(allOrderListAll.get(i).get(j).get(k).getStatus().equals("cooking"))
                                non_dis="";
                             rowspan="class=\"non-dis\"";
                             if(k==0)
                                 rowspan="rowspan=\""+allOrderListAll.get(i).get(j).size()+"\"";
                             else{
                                 rowspan2="non-dis";
                             }
                            orderTimed=allOrderListAll.get(i).get(j).get(k).getOrderTime().toGregorianCalendar().getTime();
                            orderTime= formatter.format(orderTimed);
                            orderTable+=" <tr>\n"+
                            "            <td>"+allOrderListAll.get(i).get(j).get(k).getFoodName()+"</td>\n"+
                            "           <td>"+allOrderListAll.get(i).get(j).get(k).getCount()+"</td>\n"+
                            "           <td  class=\"sm-non-dis\">"+allOrderListAll.get(i).get(j).get(k).getFoodPrice()+" $ </td>\n"+
                            "           <td  class=\"sm-non-dis "+rowspan2+"\" "+rowspan+" >"+allOrderListAll.get(i).get(j).get(k).getStatus()+"</td>\n"+
                            "           <td "+rowspan+" >"+orderTime+"</td>\n"+
                            "           <td "+rowspan+" >"+allOrderListAll.get(i).get(j).get(k).getTotalPrice()+" $ </td>\n"+
                            "           </tr>";
                   }
                   
                }
                 orderTable+="</table>\n"+
        "            <form class=\""+non_dis+"\" action=\""+request.getContextPath()+"/AdminPageServlet\" method=\"post\">\n"+
        "                DID YOU JUST SEND THIS ORDER ?<br/>\n"+
        "                <input type=\"text\" class=\"non-dis\" name=\"orderId\" value="+orderId+">\n"+

        "                <input type=\"submit\" class=\"button send-order-btn\" value=\"YES\">\n"+
        "            </form>\n"+
        "        </div>\n"+
        "\n"+
        "    </div>";
                 
                 if(received_order_count!=0){
                    orderSection+=orderTable;
                    received_section_count++;
                 }
                 
            }
            if(received_section_count!=0){
                outpage +=userInfo+orderSection+"</div>";
                received_user_count++;
            }
          

         }

            if(received_user_count!=0)
                out.println(outpage);
            else{
                 out.println("<div class=\"f-container main-border f-center order-container\">\n"+
                     "<h2 class=\"no-order\">you dont have any received order list yet!</h2></div>"); 
   
            }
                                             
}%>
      </div>
  <div class="sending-order-section" >  
        <%
        {
 int sending_order_count=0;
 int sending_section_count=0;
  int sending_user_count=0;
      /*  if(allOrderListAll.size()==0)
           out.println("<div class=\"f-container main-border f-center order-container\">\n"+
               "<h2 class=\"no-order\">you dont have any order list yet!</h2></div>");
*/
        String outpage="";
        String userInfo="";
        String orderTable="";
        String orderSection="";
        
        String orderTime="";
        Date orderTimed;
        String rowspan="";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        
        String name="";
        String phone="";
        String address="";
        String non_dis="";
         String rowspan2="";
        int orderId=0;
        
      for(int i=0;i<allOrderListAll.size();i++)
        {
              for(int j=0;j<allOrderListAll.get(i).size();j++)
            {
                for(int k=0;k<allOrderListAll.get(i).get(j).size();k++)
                {
                     name=allOrderListAll.get(i).get(j).get(k).getFullName();
                     phone=allOrderListAll.get(i).get(j).get(k).getPhone();
                     address=allOrderListAll.get(i).get(j).get(k).getAddress();
                }
            }
              userInfo ="<div class=\"main-border f-center\">\n"+
        "    <ul class=\"basic-info-user f-center\">\n"+
        "        <li><span>name</span><span>"+name+"</span></li>\n"+
        "        <li><span>phone</span><span>"+phone+"</span></li>\n"+
        "        <li><span>address</span><span>"+address+"</span></li>\n"+
        "    </ul>\n";
              
              
            orderSection="";
            sending_section_count=0;
            
            for(int j=0;j<allOrderListAll.get(i).size();j++)
            {
                
                
                
                
                
                orderTable="<div class=\"report-order-section admin-section\">\n"+
        "        <div class=\"order-info\">\n"+
        "            <table>\n"+
        "                <tr>\n"+
        "                    <th>Food Name</th>\n"+
        "                    <th>Count</th>\n"+
        "                    <th  class=\"sm-non-dis\">Price</th>\n"+
        "                    <th  class=\"sm-non-dis\">Status</th>\n"+
        "                    <th>Order Time</th>\n"+
        "                    <th>Total Price</th>\n"+
        "                </tr>\n";
               sending_order_count=0;
                for(int k=0;k<allOrderListAll.get(i).get(j).size();k++)
                {
                   if(allOrderListAll.get(i).get(j).get(k).getStatus().equals("sending")){
                            sending_order_count++;
                              rowspan2="";
                            orderId=  allOrderListAll.get(i).get(j).get(k).getOrderId();
                            non_dis="non-dis";
                            if(allOrderListAll.get(i).get(j).get(k).getStatus().equals("cooking"))
                                non_dis="";
                             rowspan="class=\"non-dis\"";
                             if(k==0)
                                 rowspan="rowspan=\""+allOrderListAll.get(i).get(j).size()+"\"";
                             else{
                                 rowspan2="non-dis";
                             }
                            orderTimed=allOrderListAll.get(i).get(j).get(k).getOrderTime().toGregorianCalendar().getTime();
                            orderTime= formatter.format(orderTimed);
                            orderTable+=" <tr>\n"+
                            "            <td>"+allOrderListAll.get(i).get(j).get(k).getFoodName()+"</td>\n"+
                            "           <td>"+allOrderListAll.get(i).get(j).get(k).getCount()+"</td>\n"+
                            "           <td   class=\"sm-non-dis\"> "+allOrderListAll.get(i).get(j).get(k).getFoodPrice()+" $ </td>\n"+
                            "           <td   class=\"sm-non-dis "+rowspan2+"\""+rowspan+" >"+allOrderListAll.get(i).get(j).get(k).getStatus()+"</td>\n"+
                            "           <td "+rowspan+" >"+orderTime+"</td>\n"+
                            "           <td "+rowspan+" >"+allOrderListAll.get(i).get(j).get(k).getTotalPrice()+" $ </td>\n"+
                            "           </tr>";
                   }
                   
                }
                 orderTable+="</table>\n"+
        "            <form class=\""+non_dis+"\" action=\""+request.getContextPath()+"/AdminPageServlet\" method=\"post\">\n"+
        "                DID YOU JUST SEND THIS ORDER ?<br/>\n"+
        "                <input type=\"text\" class=\"non-dis\" name=\"orderId\" value="+orderId+">\n"+

        "                <input type=\"submit\" class=\"button send-order-btn\" value=\"YES\">\n"+
        "            </form>\n"+
        "        </div>\n"+
        "\n"+
        "    </div>";
                 
                 if(sending_order_count!=0){
                    orderSection+=orderTable;
                    sending_section_count++;
                 }
                 
            }
            if(sending_section_count!=0){
                outpage +=userInfo+orderSection+"</div>";
                sending_user_count++;
            }
          

         }

            if(sending_user_count!=0)
                out.println(outpage);
            else{
                 out.println("<div class=\"f-container main-border f-center order-container\">\n"+
                     "<h2 class=\"no-order\">you dont have any sending order list yet!</h2></div>"); 
   
            }
                                             
}%>
      </div>
       <div class="cooking-order-section" >  
        <%
        {
 int cooking_order_count=0;
 int cooking_section_count=0;
  int cooking_user_count=0;
       /*  if(allOrderListAll.size()==0)
           out.println("<div class=\"f-container main-border f-center order-container\">\n"+
               "<h2 class=\"no-order\">you dont have any order list yet!</h2></div>");
*/
        String outpage="";
        String userInfo="";
        String orderTable="";
        String orderSection="";
        
        String orderTime="";
        Date orderTimed;
        String rowspan="";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        
        String name="";
        String phone="";
        String address="";
        String non_dis="";
        String rowspan2="";
        int orderId=0;
        
      for(int i=0;i<allOrderListAll.size();i++)
        {
              for(int j=0;j<allOrderListAll.get(i).size();j++)
            {
                for(int k=0;k<allOrderListAll.get(i).get(j).size();k++)
                {
                     name=allOrderListAll.get(i).get(j).get(k).getFullName();
                     phone=allOrderListAll.get(i).get(j).get(k).getPhone();
                     address=allOrderListAll.get(i).get(j).get(k).getAddress();
                }
            }
              userInfo ="<div class=\"main-border f-center\">\n"+
        "    <ul class=\"basic-info-user f-center\">\n"+
        "        <li><span>name</span><span>"+name+"</span></li>\n"+
        "        <li><span>phone</span><span>"+phone+"</span></li>\n"+
        "        <li><span>address</span><span>"+address+"</span></li>\n"+
        "    </ul>\n";
              
              
            orderSection="";
           cooking_section_count=0;
            
            for(int j=0;j<allOrderListAll.get(i).size();j++)
            {
                
                
                
                
                
                orderTable="<div class=\"report-order-section admin-section\">\n"+
        "        <div class=\"order-info\">\n"+
        "            <table>\n"+
        "                <tr>\n"+
        "                    <th>Food Name</th>\n"+
        "                    <th>Count</th>\n"+
        "                    <th class=\"sm-non-dis\" >Price</th>\n"+
        "                    <th class=\"sm-non-dis\" >Status</th>\n"+
        "                    <th>Order Time</th>\n"+
        "                    <th>Total Price</th>\n"+
        "                </tr>\n";
               cooking_order_count=0;
                for(int k=0;k<allOrderListAll.get(i).get(j).size();k++)
                {
                   if(allOrderListAll.get(i).get(j).get(k).getStatus().equals("cooking")){
                           cooking_order_count++;
                             rowspan2="";
                            orderId=  allOrderListAll.get(i).get(j).get(k).getOrderId();
                            non_dis="non-dis";
                            if(allOrderListAll.get(i).get(j).get(k).getStatus().equals("cooking"))
                                non_dis="";
                             rowspan="class=\"non-dis\"";
                             if(k==0)
                                 rowspan="rowspan=\""+allOrderListAll.get(i).get(j).size()+"\"";
                             else{
                                 rowspan2="non-dis";
                             }
                            orderTimed=allOrderListAll.get(i).get(j).get(k).getOrderTime().toGregorianCalendar().getTime();
                            orderTime= formatter.format(orderTimed);
                            orderTable+=" <tr>\n"+
                            "            <td>"+allOrderListAll.get(i).get(j).get(k).getFoodName()+"</td>\n"+
                            "           <td>"+allOrderListAll.get(i).get(j).get(k).getCount()+"</td>\n"+
                            "           <td  class=\"sm-non-dis\" >"+allOrderListAll.get(i).get(j).get(k).getFoodPrice()+" $ </td>\n"+
                            "           <td  class=\"sm-non-dis "+rowspan2+ "\" "+rowspan+" >"+allOrderListAll.get(i).get(j).get(k).getStatus()+"</td>\n"+
                            "           <td "+rowspan+" >"+orderTime+"</td>\n"+
                            "           <td "+rowspan+" >"+allOrderListAll.get(i).get(j).get(k).getTotalPrice()+" $ </td>\n"+
                            "           </tr>";
                   }
                   
                }
                 orderTable+="</table>\n"+
        "            <form class=\""+non_dis+"\" action=\""+request.getContextPath()+"/AdminPageServlet\" method=\"post\">\n"+
        "                DID YOU JUST SEND THIS ORDER ?<br/>\n"+
        "                <input type=\"text\" class=\"non-dis\" name=\"orderId\" value="+orderId+">\n"+

        "                <input type=\"submit\" class=\"button send-order-btn\" value=\"YES\">\n"+
        "            </form>\n"+
        "        </div>\n"+
        "\n"+
        "    </div>";
                 
                 if(cooking_order_count!=0){
                    orderSection+=orderTable;
                    cooking_section_count++;
                 }
                 
            }
            if(cooking_section_count!=0){
                outpage +=userInfo+orderSection+"</div>";
               cooking_user_count++;
            }
          

         }

            if(cooking_user_count!=0)
                out.println(outpage);
            else{
                 out.println("<div class=\"f-container main-border f-center order-container\">\n"+
                     "<h2 class=\"no-order\">you dont have any cooking order list yet!</h2></div>"); 
   
            }
                                             
}%>
      </div>
                                             
                                             
                                             
                                             
                                             
                                             
    </div>


    <div class="manage-container">
        <h3 class="admin-head">manage foods</h3>
        <div class="food-table">
            <table>
                <tr>
                    <th>picture</th>
                    <th>food name</th>
                    <th>operations</th>

                </tr>
<%
       List<FoodModel> allFoodList= (List<FoodModel>)request.getAttribute("allFoodList");
    String isAvaluable="";
    for(int i=0;i<allFoodList.size();i++){
        isAvaluable="unavailable";
        if(allFoodList.get(i).getIsAvailable()==1)
            isAvaluable="available";
         out.println("  <tr>\n"+

        "                        <td><img src=\""+allFoodList.get(i).getFoodPicPath()+"\" class=\"thubnails-pic\" alt=\"\"></td>\n"+
        "                        <td>"+allFoodList.get(i).getFoodName()+"</td>\n"+
                
        "                        <td>"
        +                        "<form class=\"inlb-dis\" action=\""+request.getContextPath()+"/AdminPageServlet\" method=\"post\">\n"+
        "                              <input type=\"text\" class=\"non-dis\" name=\"delete\" value="+allFoodList.get(i).getFoodId()+">\n"+
        "                              <input type=\"submit\" class=\"button delete-food-btn\" value=\"Delete Food\">\n"+
        "                        </form>\n"+
        "                        <form  class=\"inlb-dis\" action=\""+request.getContextPath()+"/AdminPageServlet\" method=\"post\">\n"+
        "                               <input type=\"text\" class=\"non-dis\" name=\"avaluable\" value="+allFoodList.get(i).getFoodId()+">\n"+    
        "                               <input type=\"submit\" class=\"button "+isAvaluable+"-btn\" value=\""+isAvaluable+"\">\n"+
        "                        </form>\n"+
        "                        </td>\n"+

        "                </tr>");
    }
  
              
               
%>
            </table>
            <h3><i class="add-food-btn fas fa-plus"></i></h3>
        </div>
    </div>
</div>
        
<footer>
    <div class="overlay f-center">
        <div class="row footer-info">
            <div class="col-s-12 col-m-8 col-l-6">
                <h3>Address</h3> Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</div>
            <div class="col-s-12 col-m-4 col-l-6">
                <h3>connect us </h3>
                <ul>
                    <li>phone:9844878638</li>
                    <li>open times: tue,wed,fri,mon</li>

                </ul>
            </div>

        </div>
        <div class="row all-right  f-center">
            All right reserved.2021 (c)
        </div>
    </div>
</footer>
<%
     int delaytime=200;
   if(request.getAttribute("deleteFooodResult")!=null ){
        String messag=(String)request.getAttribute("deleteFooodResult");
        if(messag.equals("0"))
            out.println("<script> setTimeout(function(){document.getElementsByClassName('manage-foods-btn')[0].click(); },10); setTimeout(function(){ alert('cannot delete this food because this food has been ordered by some customer');},"+delaytime+");</script>");
        else  if(messag.equals("1"))
            out.println("<script> setTimeout(function(){document.getElementsByClassName('manage-foods-btn')[0].click(); },10);</script>");
        
      
    }
   else if(request.getAttribute("addFoodResult")!=null ){
        String messag=(String)request.getAttribute("addFoodResult");
        if(messag.equals("1"))
            out.println("<script> setTimeout(function(){document.getElementsByClassName('manage-foods-btn')[0].click(); },10);</script>");
      
    }
    else if(request.getAttribute("availableResult")!=null ){
        String messag=(String)request.getAttribute("availableResult");
        if(messag.equals("1"))
            out.println("<script> setTimeout(function(){document.getElementsByClassName('manage-foods-btn')[0].click(); },10);</script>");
      
    }


    %>
    <script>
    var filter = document.getElementById("filter");
    var received_order_section=document.getElementsByClassName("received-order-section")[0];
    var cooking_order_section=document.getElementsByClassName("cooking-order-section")[0];
    var sending_order_section=document.getElementsByClassName("sending-order-section")[0];

   
    filter.addEventListener('change',filterHandler);
    function filterHandler() {
        if(filter.value==="received")
        {
            received_order_section.setAttribute('style','display:block');
            cooking_order_section.setAttribute('style','display:none');
            sending_order_section.setAttribute('style','display:none');
        }
        else if(filter.value==="cooking")
        {
            received_order_section.setAttribute('style','display:none');
            cooking_order_section.setAttribute('style','display:block');
            sending_order_section.setAttribute('style','display:none');
        }
        else if(filter.value==="sending")
        {
            received_order_section.setAttribute('style','display:none');
            cooking_order_section.setAttribute('style','display:none');
            sending_order_section.setAttribute('style','display:block');
        }
    }

</script>
<script>
    if ( window.history.replaceState ) {
        window.history.replaceState( null, null, window.location.href );
    }
</script>
<script src="${pageContext.request.contextPath}/pages/assets/js/admin.js">
</script>
</body>
</html>


