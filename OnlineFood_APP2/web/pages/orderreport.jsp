<%-- 
    Document   : order
    Created on : Apr 12, 2021, 3:08:38 AM
    Author     : 14168
--%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="servicepack.OrderModel"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html><html>
<head>
   <link rel="icon" href="http://localhost:8080/icon.ico"> 
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>order - online foods</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/assets/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/assets/css/drinkFood.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/assets/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/assets/css/footer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/assets/css/myfrmw.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/assets/css/popup.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/assets/css/order.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.css">
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
    margin-top: 20px;
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
    <%
        String nameOfUser="";
         if(request.getSession().getAttribute("user_name")!=null){
            nameOfUser=(String)request.getSession().getAttribute("user_name");
         }
         

         
       
        %>
<header>
    <div class="overlay f-center">
        <div class="flex fx-jus-cen fx-al-cen f-center customer-pannel fx-wp">
            <a href="<%=request.getContextPath()%>/HomeHandlerServlet">
                <button class=" order-list">HOME</button>
            </a>
              <a href="<%=request.getContextPath()%>/HomeHandlerServlet?signed=signed_out">
                <button class="sign-out-btn ">SIGN OUT</button>
            </a>
            <h2 class=""><%=nameOfUser%>,your order</h2>
        </div>
        <h1>Try Our Best Foods !</h1>
<div style="padding-bottom: 16px;"></div>
    </div>
</header>
<div class="order-filter">
    <select name="filter" id="filter">

        <option value="cooking"> Cooking orders</option>
        <option value="received"> Received orders</option>
       <option value="sending"> Sendeing orders</option>
    </select>
</div>

<div class="content">
   <div class="sending-order-section" >
    <%
       int sending_order_count=0;
       int sending_ount=0;
        List<List<OrderModel>> allOrders=(List<List<OrderModel>>)request.getAttribute("allOrders");
      /* if(allOrders.size()==0)
           out.println("<div class=\"f-container main-border f-center order-container\">\n"+
               "<h2 class=\"no-order\">you dont have any order list yet!</h2></div>");*/
       for (int i=0;i<allOrders.size();i++){
            String rows="";
            String deliverTime="";
            String rowspan="";
            String orderTime="";
            Date   deliverTimeD;       
            Date    orderTimeD;
            String non_dis="";      
                 
            String rowspan2="";
             SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd    HH:mm:ss");
 
              for (int a=0;a<allOrders.get(i).size();a++)
                    { sending_ount=0;
                     non_dis="non-dis";
                     if(allOrders.get(i).get(a).getStatus().equals("sending"))
                            non_dis="";
                      orderTimeD=allOrders.get(i).get(a).getOrderTime().toGregorianCalendar().getTime();
                    orderTime= formatter.format(orderTimeD);

                    
                     deliverTime="-";
                     if(allOrders.get(i).get(a).getDeliverTime()!=null){
                       deliverTimeD=allOrders.get(i).get(a).getDeliverTime().toGregorianCalendar().getTime();
                       deliverTime= formatter.format(deliverTimeD);
                        
                      
                     } 
                     rowspan2="";
                     rowspan="class=\"non-dis\"";
                     if(a==0)
                         rowspan="rowspan=\""+allOrders.get(i).size()+"\""; 
                     else{rowspan2="non-dis";}
                    if( allOrders.get(i).get(a).getStatus().equals("sending")){sending_ount++;
                     rows+="    <tr>\n"+      
                    "                    <td >"+allOrders.get(i).get(a).getFoodName()+"</td>\n"+
                    "                    <td >"+allOrders.get(i).get(a).getFoodPrice()+" $</td>\n"+
                    "                    <td >"+allOrders.get(i).get(a).getCount()+"</td>\n"+
                    "                    <td class=\"sm-non-dis "+rowspan2 +"\" "+rowspan+">"+allOrders.get(i).get(a).getStatus()+"</td>\n"+
                    "                    <td class=\"sm-non-dis "+rowspan2 +"\"  "+rowspan+">"+deliverTime+"</td>\n"+
                    "                    <td  "+rowspan+">"+orderTime+"</td>\n"+

                    "                </tr>\n";}
                    }    
       if(sending_ount!=0){

         sending_order_count++;
         out.println("<div class=\"f-container main-border f-center order-container\">\n"+
                "<div class=\"order-list-container\">   \n"+
                "        <h3>order number : "+allOrders.get(i).get(0).getOrderId()+"</h3>\n"+
              
                "            <table>\n"+
                "                <tr>\n"+
                "                    <th>food</th>\n"+
                "                    <th>Price</th>\n"+
                "                    <th>Count</th>\n"+
                "                    <th class=\"sm-non-dis\" >Status</th>\n"+
                "                    <th class=\"sm-non-dis\" >Deliver Time</th>\n"+
                "                    <th>Order Time</th>\n"+

                "\n"+
                "                </tr>\n"+
                        rows+
                "            </table>\n"+
                "            <h2 class=\"f-center total-price\">total price : "+allOrders.get(i).get(0).getTotalPrice()+" $</h2><br/>\n"+
                "\n"+

                "        <form class="+ non_dis+" action=\""+request.getContextPath()+"/OrderReportHandler\" method=\"post\">\n"+
                "                HAVE YOU JUST RECIEVED YOU ORDER ?\n"+
                "                <input type=\"text\" class=\"non-dis\" name=\"orderId\" value="+allOrders.get(i).get(0).getOrderId()+">\n"+
                "                <input type=\"submit\" class=\"button recieve-food\"  value=\"YES\">\n"+
                "       </form>\n"+
                "    </div></div>");}
                
             }
         if(sending_order_count==0)
                  out.println("<div class=\"f-container main-border f-center order-container\">\n"+
                     "<h2 class=\"no-order\">you dont have any sending order list yet!</h2></div>"); 
    

    %>
   </div>
 <div class="cooking-order-section" >
    <%
       int cooking_order_count=0;
       int cooking_ount=0;
     /*  if(allOrders.size()==0)
           out.println("<div class=\"f-container main-border f-center order-container\">\n"+
               "<h2 class=\"no-order\">you dont have any order list yet!</h2></div>");*/
       for (int i=0;i<allOrders.size();i++){
            String rows="";
            String deliverTime="";
            String rowspan="";
            String orderTime="";
            Date   deliverTimeD;       
            Date    orderTimeD;
            String non_dis="";      
            String rowspan2="";
             SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd    HH:mm:ss");
 
              for (int a=0;a<allOrders.get(i).size();a++)
                    { cooking_ount=0;
                     non_dis="non-dis";
                     if(allOrders.get(i).get(a).getStatus().equals("sending"))
                           non_dis="";
                      orderTimeD=allOrders.get(i).get(a).getOrderTime().toGregorianCalendar().getTime();
                    orderTime= formatter.format(orderTimeD);

                    
                     deliverTime="-";
                     if(allOrders.get(i).get(a).getDeliverTime()!=null){
                       deliverTimeD=allOrders.get(i).get(a).getDeliverTime().toGregorianCalendar().getTime();
                       deliverTime= formatter.format(deliverTimeD);
                        
                      
                     } 
                     rowspan2="";
                     rowspan="class=\"non-dis\"";
                     if(a==0)
                         rowspan="rowspan=\""+allOrders.get(i).size()+"\""; 
                     else{rowspan2="non-dis";}
                    if( allOrders.get(i).get(a).getStatus().equals("cooking")){cooking_ount++;
                     rows+="    <tr>\n"+      
                    "                    <td >"+allOrders.get(i).get(a).getFoodName()+"</td>\n"+
                    "                    <td >"+allOrders.get(i).get(a).getFoodPrice()+" $</td>\n"+
                    "                    <td >"+allOrders.get(i).get(a).getCount()+"</td>\n"+
                    "                    <td  class=\"sm-non-dis "+rowspan2 +"\" "+rowspan+">"+allOrders.get(i).get(a).getStatus()+"</td>\n"+
                    "                    <td  class=\"sm-non-dis "+rowspan2 +"\" "+rowspan+">"+deliverTime+"</td>\n"+
                    "                    <td  "+rowspan+">"+orderTime+"</td>\n"+

                    "                </tr>\n";}
                    }    
       if(cooking_ount!=0){

         cooking_order_count++;
         out.println("<div class=\"f-container main-border f-center order-container\">\n"+
                "<div class=\"order-list-container\">   \n"+
                "        <h3>order number : "+allOrders.get(i).get(0).getOrderId()+"</h3>\n"+
              
                "            <table>\n"+
                "                <tr>\n"+
                "                    <th>food</th>\n"+
                "                    <th>Price</th>\n"+
                "                    <th>Count</th>\n"+
                "                    <th class=\"sm-non-dis\" >Status</th>\n"+
                "                    <th class=\"sm-non-dis\" >Deliver Time</th>\n"+
                "                    <th>Order Time</th>\n"+

                "\n"+
                "                </tr>\n"+
                        rows+
                "            </table>\n"+
                "            <h2 class=\"f-center total-price\">total price : "+allOrders.get(i).get(0).getTotalPrice()+" $</h2><br/>\n"+
                "\n"+

                "        <form class="+ non_dis+" action=\""+request.getContextPath()+"/OrderReportHandler\" method=\"post\">\n"+
                "                HAVE YOU JUST RECIEVED YOU ORDER ?\n"+
                "                <input type=\"text\" class=\"non-dis\" name=\"orderId\" value="+allOrders.get(i).get(0).getOrderId()+">\n"+
                "                <input type=\"submit\" class=\"button recieve-food\"  value=\"YES\">\n"+
                "       </form>\n"+
                "    </div></div>");}
                
             }
         if(cooking_order_count==0)
                  out.println("<div class=\"f-container main-border f-center order-container\">\n"+
                     "<h2 class=\"no-order\">you dont have any cooking order list yet!</h2></div>"); 
    

    %>
   </div>

 <div class="received-order-section" >
    <%
       int received_order_count=0;
       int received_ount=0;
     /*  if(allOrders.size()==0)
           out.println("<div class=\"f-container main-border f-center order-container\">\n"+
               "<h2 class=\"no-order\">you dont have any order list yet!</h2></div>");*/
       for (int i=0;i<allOrders.size();i++){
            String rows="";
            String deliverTime="";
            String rowspan="";
            String orderTime="";
            Date   deliverTimeD;       
            Date    orderTimeD;
            String non_dis="";      
             String rowspan2="";
             SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd    HH:mm:ss");
 
              for (int a=0;a<allOrders.get(i).size();a++)
                    { received_ount=0;
                     non_dis="non-dis";
                     if(allOrders.get(i).get(a).getStatus().equals("sending"))
                         non_dis="";
                      orderTimeD=allOrders.get(i).get(a).getOrderTime().toGregorianCalendar().getTime();
                    orderTime= formatter.format(orderTimeD);

                    
                     deliverTime="-";
                     if(allOrders.get(i).get(a).getDeliverTime()!=null){
                       deliverTimeD=allOrders.get(i).get(a).getDeliverTime().toGregorianCalendar().getTime();
                       deliverTime= formatter.format(deliverTimeD);
                        
                      
                     }rowspan2="";
                     rowspan="class=\"non-dis\"";
                     if(a==0)
                         rowspan="rowspan=\""+allOrders.get(i).size()+"\""; 
                     else{ rowspan2="non-dis";
                     }
                    if( allOrders.get(i).get(a).getStatus().equals("received")){received_ount++;
                     rows+="    <tr>\n"+      
                    "                    <td >"+allOrders.get(i).get(a).getFoodName()+"</td>\n"+
                    "                    <td >"+allOrders.get(i).get(a).getFoodPrice()+" $</td>\n"+
                    "                    <td >"+allOrders.get(i).get(a).getCount()+"</td>\n"+
                    "                    <td  class=\"sm-non-dis "+rowspan2 +"\" "+rowspan+">"+allOrders.get(i).get(a).getStatus()+"</td>\n"+
                    "                    <td  class=\"sm-non-dis "+rowspan2 +"\" "+rowspan+">"+deliverTime+"</td>\n"+
                    "                    <td  "+rowspan+">"+orderTime+"</td>\n"+

                    "                </tr>\n";}
                 
                    }   
       if(received_ount!=0){

         received_order_count++;
         out.println("<div class=\"f-container main-border f-center order-container\">\n"+
                "<div class=\"order-list-container\">   \n"+
                "        <h3>order number : "+allOrders.get(i).get(0).getOrderId()+"</h3>\n"+
              
                "            <table>\n"+
                "                <tr>\n"+
                "                    <th>food</th>\n"+
                "                    <th>Price</th>\n"+
                "                    <th>Count</th>\n"+
                "                    <th class=\"sm-non-dis\" >Status</th>\n"+
                "                    <th class=\"sm-non-dis\" >Deliver Time</th>\n"+
                "                    <th>Order Time</th>\n"+

                "\n"+
                "                </tr>\n"+
                        rows+
                "            </table>\n"+
                "            <h2 class=\"f-center total-price\">total price : "+allOrders.get(i).get(0).getTotalPrice()+" $</h2><br/>\n"+
                "\n"+

                "        <form class="+ non_dis+" action=\""+request.getContextPath()+"/OrderReportHandler\" method=\"post\">\n"+
                "                HAVE YOU JUST RECIEVED YOU ORDER ?\n"+
                "                <input type=\"text\" class=\"non-dis\" name=\"orderId\" value="+allOrders.get(i).get(0).getOrderId()+">\n"+
                "                <input type=\"submit\" class=\"button recieve-food\"  value=\"YES\">\n"+
                "       </form>\n"+
                "    </div></div>");}
                
             }
         if(received_order_count==0)
                  out.println("<div class=\"f-container main-border f-center order-container\">\n"+
                     "<h2 class=\"no-order\">you dont have any received order list yet!</h2></div>"); 
    

    %>
   </div>

</div>

<footer>
    <div class="overlay f-center">
        <div class="row footer-info">
            <div class="col-s-12 col-m-8 col-l-6">
                <h3>Address</h3>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.  </div>
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
</body>
</html>


