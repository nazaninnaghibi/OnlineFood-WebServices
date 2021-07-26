<%-- 
    Document   : home
    Created on : Apr 11, 2021, 6:55:17 PM
    Author     : 14168
--%>

<%@page import="java.net.InetAddress"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="servicepack.FoodModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <link rel="icon" href="http://localhost:8080/icon.ico">
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>online foods</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/assets/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/assets/css/drinkFood.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/assets/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/assets/css/footer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/assets/css/myfrmw.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/assets/css/popup.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.css">
<%
  //  String domainName="http://" + InetAddress.getLocalHost().toString().split("/")[1]+":"+request.getServerPort();

    List<FoodModel> foodList=( List<FoodModel>)request.getAttribute("foodList");
    List<FoodModel> drinkList=( List<FoodModel>)request.getAttribute("drinkList");
    List<FoodModel> sauceList=( List<FoodModel>)request.getAttribute("sauceList");
    
   // int allFoodsNumber=foodList.size()+drinkList.size()+sauceList.size();

    boolean signed_in=false;
    String non_dis="non-dis";
    String var_non_dis="non-dis";
    String nameOfUser=" ";
    String isAdmin="non-dis";
    String isNotAdmin="";
    if(request.getSession().getAttribute("user_name")!=null){
         nameOfUser=(String)request.getSession().getAttribute("user_name");
         signed_in=true;
         var_non_dis="";
         if(nameOfUser.equals("admin"))
         {
             isAdmin="";
             var_non_dis="non-dis";
             isNotAdmin="non-dis";
         }
    }
   
    %>
    
</head>

<body>
<div class="sign-popup ">
    <div class="background"></div>
    <div class="popup">
        <div class="sign-in-popup">
            <form action="<%=request.getContextPath()%>/SigninHandler" method="post" id="signin-form">
                <div class="f-center popup-header">
                    <h2>sign in</h2>
                </div>
                <table class="aut-mrg">
                    <tr>

                        <td> </i><input type="text" name="si-username" placeholder="username"></td>
                    </tr>
                    <tr>

                        <td><input type="password" placeholder="password" name="si-password"></td>
                    </tr>
                    <tr class="f-center">

                        <td><input class=" signin-btn button submit-btn" value="sign in" type="button"></td>
                    </tr>
                </table>
            </form>
        </div>
        <div class="sign-up-popup">
            <form action="<%=request.getContextPath()%>/SignupHandler" method="post" id="signup-form">
                <div class="f-center popup-header">
                    <h2>sign up</h2>
                </div>
                <table class="aut-mrg">
                    <tr>
                        <td><input type="text" placeholder="full name" name="fullname" required></td>
                    </tr>
                    <tr>
                        <td><input type="text" placeholder="username" name="su-username" required></td>
                    </tr>
                    <tr>
                        <td><input type="password" placeholder="password" name="su-password" required></td>
                    </tr>
                    <tr>
                        <td><textarea type="text" placeholder="address" name="address" required></textarea></td>
                    </tr>
                    <tr>
                        <td><input type="text" placeholder="phone number" name="phone" required></td>
                    </tr>
                    <tr class="f-center">
                        <td><input type="submit" class="signup-btn button submit-btn" value="sign up"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>

<header>
    <div class="overlay f-center">
        <div class="flex fx-jus-cen fx-al-cen f-center customer-pannel fx-wp <%if(!signed_in)out.println(non_dis);%>">
            <a class="<%=isNotAdmin%>" href="<%=request.getContextPath()%>/OrderReportHandler">
                <button class=" order-list">MY ORDERS</button>
            </a>
            <a class="<%=isAdmin%>" href="<%=request.getContextPath()%>/AdminPageServlet">
                <button class=" order-list">MANAGE ORDERS</button>
            </a>
            <a href="<%=request.getContextPath()%>/HomeHandlerServlet?signed=signed_out">
                <button class="sign-out-btn ">SIGN OUT</button>
            </a>
            <h2 class="">dear <%=nameOfUser%> , welcome</h2>
        </div>
        <h1>Try Our Best Foods !</h1>
        <div class="signin-section <%if(signed_in)out.println(non_dis);%>">
            <h3>sign in to order</h3>
            <br>

            <button class="mr-btm-50 signin-btn" id="global-signin-btn">SIGN IN</button>
            <button class="mr-btm-50 signup-btn" id="global-signup-btn">SIGN UP</button>
        </div>
    </div>
</header>
<div class="mmain">
<div class="f-container main-border f-center">
    <div class="f-section ">

        <div onclick="
        let parent=this.parentElement;
        if(flag1){
        parent.childNodes[3].setAttribute('style','display:none');
        flag1=false;
        }
        else{
             parent.childNodes[3].setAttribute('style','display:flex');
             flag1=true;
        }

" class="f-center food-head">
            <h3 class="food-container-head food-container-head-food">FOODS</h3>
        </div>
        <div class="food-container">
<%    
    
    for(int i=0;i<foodList.size();i++)
    {
        String isAvaluable="";
          if(foodList.get(i).getIsAvailable()==0)
                       isAvaluable="unavaluable";

          
            out.print("<div class=\"food-section\">\n" +
          "                <div class=\""+isAvaluable+"\"></div>\n" +
          "                <div class=\"card center\">\n" +
          "                    <div class=\"front\">\n" +
          "                        <img  class=\"product-img\" src=\""+foodList.get(i).getFoodPicPath()+"\"\n" +
          "                             alt=\""+foodList.get(i).getFoodName()+"\">\n" +
          "                    </div>\n" +
          "                    <div class=\"back\">\n" +
          "                        <div class=\"back-content center\">\n" +
          "                            <h2>"+foodList.get(i).getFoodName()+"</h2>\n" +
          "                            <h2>price: "+foodList.get(i).getFoodPrice()+"$</h2>\n" +
          "\n" +
          "\n" +
          "                        </div>\n" +
          "                    </div>\n" +
          "                </div>\n" +
           "                <div class=\"food-count "+var_non_dis+"\">\n" +
          "                    <span class=\"count\">count</span>\n" +
          "                    <input style=\"background-color:#c78a8a\" type=\"text\" name=\"foodname\" value=\"0\" food_id=\"" +foodList.get(i).getFoodId()+ "\">\n   " +
          "                    <i onclick=\"\n" +
          "            let parent=this.parentElement;\n" +
          "            parent.childNodes[3].value++;\n" +
          "if(parent.childNodes[3].value>0)\n" +
          "    parent.childNodes[3].setAttribute('style','background-color:#b2dab2');\n" +
          "else\n" +
          "    parent.childNodes[3].setAttribute('style','background-color:brown');\n" +
          "\n" +
          "\" class=\"fas fa-plus\"></i>\n" +
          "                    <i onclick=\"\n" +
          "            let parent=this.parentElement;\n" +
          "            if( parent.childNodes[3].value>0)\n" +
          "           parent.childNodes[3].value--;\n" +
          "\n" +
          "            if(parent.childNodes[3].value>0)\n" +
          "    parent.childNodes[3].setAttribute('style','background-color:#b2dab2');\n" +
          "else\n" +
          "    parent.childNodes[3].setAttribute('style','background-color:#c78a8a');\n" +
          "\n" +
          "\" class=\"fas fa-minus\"></i>\n" +
          "\n" +
          "\n" +
          "                </div>\n" +
          "\n" +
          "            </div>");
    }
%>
        </div>
    </div>
</div>
<div class="f-container main-border f-center">
    <div class="f-section ">

        <div onclick="
        let parent=this.parentElement;
        if(flag2){
        parent.childNodes[3].setAttribute('style','display:none');
        flag2=false;
        }
        else{
             parent.childNodes[3].setAttribute('style','display:flex');
             flag2=true;
        }

" class="f-center food-head">
            <h3 class="food-container-head food-container-head-drink">DRINKS</h3>
        </div>
        <div class="food-container">             
<%      
   
    for(int i=0;i<drinkList.size();i++)
    {
         String isAvaluabled="";
          if(drinkList.get(i).getIsAvailable()==0)
                       isAvaluabled="unavaluable";
          
            out.print("<div class=\"food-section\">\n" +
          "                <div class=\""+isAvaluabled+"\"></div>\n" +
          "                <div class=\"card center\">\n" +
          "                    <div class=\"front\">\n" +
          "                        <img class=\"product-img\" src=\""+drinkList.get(i).getFoodPicPath()+"\"\n" +
          "                             alt=\""+drinkList.get(i).getFoodName()+"\">\n" +
          "                    </div>\n" +
          "                    <div class=\"back\">\n" +
          "                        <div class=\"back-content center\">\n" +
          "                            <h2>"+drinkList.get(i).getFoodName()+"</h2>\n" +
          "                            <h2>price: "+drinkList.get(i).getFoodPrice()+"$</h2>\n" +         
          "\n" +
          "\n" +
          "                        </div>\n" +
          "                    </div>\n" +
          "                </div>\n" +
          "                <div class=\"food-count "+var_non_dis+"\">\n" +
                  "                    <span class=\"count\">count</span>\n" +
          "                    <input style=\"background-color:#c78a8a\" type=\"text\" name=\"foodname\" value=\"0\"  food_id=\"" +drinkList.get(i).getFoodId()+ "\" >\n " +
          "                    <i onclick=\"\n" +
          "            let parent=this.parentElement;\n" +
          "            parent.childNodes[3].value++;\n" +
          "if(parent.childNodes[3].value>0)\n" +
          "    parent.childNodes[3].setAttribute('style','background-color:#b2dab2');\n" +
          "else\n" +
          "    parent.childNodes[3].setAttribute('style','background-color:brown');\n" +
          "\n" +
          "\" class=\"fas fa-plus\"></i>\n" +
          "                    <i onclick=\"\n" +
          "            let parent=this.parentElement;\n" +
          "            if( parent.childNodes[3].value>0)\n" +
          "           parent.childNodes[3].value--;\n" +
          "\n" +
          "            if(parent.childNodes[3].value>0)\n" +
          "    parent.childNodes[3].setAttribute('style','background-color:#b2dab2');\n" +
          "else\n" +
          "    parent.childNodes[3].setAttribute('style','background-color:#c78a8a');\n" +
          "\n" +
          "\" class=\"fas fa-minus\"></i>\n" +
          "\n" +
          "\n" +
          "                </div>\n" +
          "\n" +
          "            </div>");
    }
%>
        </div>
    </div>
</div>
      <div class="f-container main-border f-center">
    <div class="f-section ">

        <div onclick="
        let parent=this.parentElement;
        if(flag3){
        parent.childNodes[3].setAttribute('style','display:none');
        flag3=false;
        }
        else{
             parent.childNodes[3].setAttribute('style','display:flex');
             flag3=true;
        }

" class="f-center food-head">
            <h3 class="food-container-head food-container-head-sauce">SALAD AND SAUCE</h3>
        </div>
        <div class="food-container">
         <%      
   
    for(int i=0;i<sauceList.size();i++)
    {
         String isAvaluables="";
          if(sauceList.get(i).getIsAvailable()==0)
                       isAvaluables="unavaluable";

            out.print("<div class=\"food-section\">\n" +
          "                <div class=\""+isAvaluables+"\"></div>\n" +
          "                <div class=\"card center\">\n" +
          "                    <div class=\"front\">\n" +
          "                        <img class=\"product-img\"  src=\""+sauceList.get(i).getFoodPicPath()+"\"\n" +
          "                             alt=\""+sauceList.get(i).getFoodName()+"\">\n" +
          "                    </div>\n" +
          "                    <div class=\"back\">\n" +
          "                        <div class=\"back-content center\">\n" +
          "                            <h2>"+sauceList.get(i).getFoodName()+"</h2>\n" +
          "                            <h2>price: "+sauceList.get(i).getFoodPrice()+"$</h2>\n" +         
          "\n" +
          "\n" +
          "                        </div>\n" +
          "                    </div>\n" +
          "                </div>\n" +
          "                <div class=\"food-count "+var_non_dis+"\">\n" +
          "                    <span class=\"count\">count</span>\n" +
          "                    <input style=\"background-color:#c78a8a\" type=\"text\" name=\"foodname\" food_id=\"" +sauceList.get(i).getFoodId()+ "\" value=\"0\">\n" +
          "                    <i onclick=\"\n" +
          "            let parent=this.parentElement;\n" +
          "            parent.childNodes[3].value++;\n" +
          "if(parent.childNodes[3].value>0)\n" +
          "    parent.childNodes[3].setAttribute('style','background-color:#b2dab2');\n" +
          "else\n" +
          "    parent.childNodes[3].setAttribute('style','background-color:brown');\n" +
          "\n" +
          "\" class=\"fas fa-plus\"></i>\n" +
          "                    <i onclick=\"\n" +
          "            let parent=this.parentElement;\n" +
          "            if( parent.childNodes[3].value>0)\n" +
          "           parent.childNodes[3].value--;\n" +
          "\n" +
          "            if(parent.childNodes[3].value>0)\n" +
          "    parent.childNodes[3].setAttribute('style','background-color:#b2dab2');\n" +
          "else\n" +
          "    parent.childNodes[3].setAttribute('style','background-color:#c78a8a');\n" +
          "\n" +
          "\" class=\"fas fa-minus\"></i>\n" +
          "\n" +
          "\n" +
          "                </div>\n" +
          "\n" +
          "            </div>");
    }
%>


        </div>
    </div>
</div>
<div class="f-center">
<form id="foodorder-form" action="<%=request.getContextPath()%>/OrderHandler" method="post" >
    <input type="text" id="order_list_temp" name="orderList" class="non-dis" value=""/>
    <%=   
    "<input type=\"button\" class=\"order-it-btn  "+var_non_dis+" button\" id=\"orderit\" value=\"order it now !\">"
    %>
</form>
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

<script src="${pageContext.request.contextPath}/pages/assets/js/sign-popup.js"></script>
<script src="${pageContext.request.contextPath}/pages/assets/js/foodorder.js"></script>
<script>
    var flag1=true;
    var flag2=true;
    var flag3=true;
</script>
<%
   int delaytime=200;
   if(request.getAttribute("addUserReport")!=null ){
        String messag=(String)request.getAttribute("addUserReport");
        if(!messag.equals("1"))
        out.println("<script> setTimeout(function(){ alert('user already exists please sign in!');},"+delaytime+");</script>");
      
    }
   else if(request.getAttribute("signinReport")!=null  ){
        String messag=(String)request.getAttribute("signinReport");
        if(!messag.equals("1"))
        out.println("<script>setTimeout(function(){alert('username or password is incorrect please try again!');},"+delaytime+");</script>");
        
    }
    else if(request.getAttribute("ordermessage")!=null ){
        String messag=(String)request.getAttribute("ordermessage");
        if(messag.equals("1"))
        out.println("<script>setTimeout(function(){alert('your order is taking care of !');},"+delaytime+");</script>");
        
    }
%>
<script>
    if ( window.history.replaceState ) {
        window.history.replaceState( null, null, window.location.href );
    }
 /*   var domainPort= "http://"+window.location.href.split("/")[2];
    var  product_img=document.getElementsByClassName("product-img") ;
    var temp;
    var output;
    for(let i=0;i<product_img;i++){
        temp=product_img[i].getAttribute('src');
        output=domainPort+temp;
        product_img[i].setAttribute('src',output);
    }*/
</script>

</body>
</html>


