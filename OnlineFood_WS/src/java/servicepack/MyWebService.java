/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicepack;

import dbhandler.DBHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import models.CustomerModel;
import models.FoodModel;
import models.OrderModel;



/**
 * @author 14168
 */
@WebService(serviceName = "MyWebService")
public class MyWebService {
    DBHandler dbh = new DBHandler();
 
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "getFoodsHome")
    public List<FoodModel> getFoodsHome() {
        List<FoodModel> foodList = new ArrayList<>();
        Statement mystat = (Statement) dbh.getConnection();

        try {

            String q = "SELECT * FROM `food`";
            ResultSet rs = mystat.executeQuery(q);

            while (rs.next()) {
                FoodModel food = new FoodModel();
                food.setFood_id(rs.getInt("food_id"));
                food.setFoodName(rs.getString("foodName"));
                food.setFoodPrice(rs.getDouble("foodPrice"));
                food.setIsAvailable(rs.getInt("isAvaluable"));
                food.setFoodPicPath(rs.getString("foodPicPath"));
                food.setType(rs.getString("type"));

                foodList.add(food);

            }
            rs.close();
            mystat.close();

            return foodList;
        } catch (SQLException e) {
            System.out.println("[------me-----]getFoodsHome method problem : " + e.getMessage());
        }
        return null;
    }


    @WebMethod(operationName = "addUser")
    public String addUser(CustomerModel customer) {

        Statement mystat = (Statement) dbh.getConnection();
        //validate that does username already exist or not
        try {

            String q = "SELECT `customer_id`,`username` FROM `customer` WHERE (`username` = '" + customer.getUsername() + "');";
            ResultSet rs = mystat.executeQuery(q);
           // String customer_id;
            if (rs.next()) {
             //   customer_id = rs.getString("customer_id");
               /// return customer_id + ",0";
               return "0";
            }
            rs.close();

        } catch (SQLException e) {
            System.out.println("[------me-----]addUser does exist part WB method problem : " + e.getMessage());
        }
        //adding new user
        try {

            String q = "INSERT INTO `customer`  (`fullName`, `username`, `password`, `address`, `phone`) VALUES('" + customer.getFullName() + "', '" + customer.getUsername() + "', '" + customer.getPassword() + "', '" + customer.getAddress() + "', '" + customer.getPhone() + "'); ";
            mystat.executeUpdate(q);

            String q1 = "SELECT `customer_id`,`username` FROM `customer` WHERE (`username` = '" + customer.getUsername() + "');";
            ResultSet rs = mystat.executeQuery(q1);
            String customer_id;
            rs.next();
            customer_id = rs.getString("customer_id");

            return customer_id ;
        } catch (SQLException e) {
            System.out.println("[------me-----]addUser adding part WB method problem : " + e.getMessage());
            return "-1";
        }

    }

    @WebMethod(operationName = "signin")
    public String signin(String username, String password) {
        Statement mystat = (Statement) dbh.getConnection();
        try {

            String q = "SELECT `username`,`password` FROM `customer` WHERE (`username` = '" + username + "'  ) AND (`password` = '" + password + "'  );";
            ResultSet rs = mystat.executeQuery(q);

            if (rs.next()) {

                String q1 = "SELECT `customer_id`,`fullName` FROM `customer` WHERE (`username` = '" + username + "');";
                ResultSet rs1 = mystat.executeQuery(q1);
                rs1.next();
                String fullName = rs1.getString("fullName");
                int customer_id = rs1.getInt("customer_id");
                return fullName + "," + customer_id + ",1";

            }


            return "0";

        } catch (SQLException e) {
            System.out.println("[------me-----]signin WB method problem : " + e.getMessage());
        }
        return "-1";
    }


    @WebMethod(operationName = "setOrder")
    public String setOrder(String orderList, String userId) {
        String[] orderListArray = orderList.split(";");
        String orderTime = getCurrentTimeStamp();
        String status = "cooking";
        double totalPrice = 0;
        int order_id;

        Statement mystat = (Statement) dbh.getConnection();
        //insert into order table
        try {
            for (int i = 0; i < orderListArray.length; i++) {
                String[] count_foodid = orderListArray[i].split(":");
                int food_id = Integer.parseInt(count_foodid[0]);
                int food_count = Integer.parseInt(count_foodid[1]);
                totalPrice += getTotalPrice(food_id, food_count);
            }

            String q = "INSERT INTO `order`  (`orderTime`, `status`, `customer_id`, `total_price`) VALUES('" + orderTime + "', '" + status + "', '" + userId + "', '" + totalPrice + "'); ";
            mystat.executeUpdate(q);

            String q1 = "SELECT `order_id` FROM `order`WHERE (`orderTime`= '" + orderTime + "') AND (`customer_id`='" + userId + "');";

            ResultSet rs = mystat.executeQuery(q1);

            rs.next();
            order_id = rs.getInt("order_id");

            //insert into order_detail table

            for (int i = 0; i < orderListArray.length; i++) {
                String[] count_foodid = orderListArray[i].split(":");
                int food_id = Integer.parseInt(count_foodid[0]);
                int food_count = Integer.parseInt(count_foodid[1]);
                setOrderDetail(food_id, order_id, food_count);

            }
            return "1";
        } catch (SQLException e) {
            System.out.println("[------me-----]setOrder WB method problem : " + e.getMessage());
            // return "-1";
        }
        return "-1";


    }


    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }

    @WebMethod(operationName = "setOrderDetail")
    public void setOrderDetail(int food_id, int order_id, int count) {
        Statement mystat = (Statement) dbh.getConnection();
        try {

            String q = "INSERT INTO `order_detail`  (`order_id`, `food_id`, `count`) VALUES('" + order_id + "', '" + food_id + "', '" + count + "'); ";
            mystat.executeUpdate(q);


        } catch (SQLException e) {
            System.out.println("[------me-----]setOrderDetail WB method problem : " + e.getMessage());
            // return "-1";
        }

    }

    @WebMethod(operationName = "getTotalPrice")
    public double getTotalPrice(int food_id, int count) {
        double foodPrice = 0;
        Statement mystat = (Statement) dbh.getConnection();
        try {

            String q = "SELECT `foodPrice` FROM `food`   WHERE (`food_id`=" + food_id + "); ";
            ResultSet rs = mystat.executeQuery(q);
            rs.next();
            foodPrice = rs.getDouble("foodPrice");


        } catch (SQLException e) {
            System.out.println("[------me-----]getTotalPrice WB method problem : " + e.getMessage());
            // return "-1";
        }

        return foodPrice * count;
    }


    @WebMethod(operationName = "getOrder")
    public List<OrderModel> getOrder(String userId) {
        Statement mystat = (Statement) dbh.getConnection();
        List<Integer> numberOfOrderId1 = new ArrayList<>();
        List<OrderModel> orderList = new ArrayList<>();

        int[] numberOfOrderId;
        try {

            String q = "SELECT `order_id` FROM `order` WHERE (`customer_id`='" + userId + "');";
            ResultSet rs = mystat.executeQuery(q);

            while (rs.next()) {
                //all ordeers for 1 customer
                numberOfOrderId1.add(rs.getInt("order_id"));
            }

        } catch (SQLException e) {
            System.out.println("[------me-----]getOrder  part1   method problem : " + e.getMessage());

        }
        numberOfOrderId = removeDuplicates(numberOfOrderId1);

        try {
            for (int i = 0; i < numberOfOrderId.length; i++) {


                //System.out.println("--------order number :"+i+"-----------");
                String q1 = "SELECT `order`.`order_id`,`order`.`orderTime`,`order`.`status`,`order`.`total_price`," +
                        "`order`.`deliverTime`,`order_detail`.`count`,`food`.`foodName`,`food`.`foodPrice`" +
                        " FROM `order`  " +
                        "INNER JOIN `order_detail`" +
                        "		ON `order`.`order_id`= `order_detail`.`order_id`" +
                        "INNER JOIN `food`" +
                        "		ON `order_detail`.`food_id`=`food`.`food_id`" +
                        "WHERE (`order`.`customer_id`=" + userId + ") AND (`order`.`order_id`=" + numberOfOrderId[i] + ")";
                ResultSet rs1 = mystat.executeQuery(q1);

                while (rs1.next()) {
                    OrderModel order = new OrderModel();
                    order.setOrder_id(rs1.getInt("order_id"));
                    order.setTotal_price(rs1.getDouble("total_price"));
                    order.setFoodPrice(rs1.getDouble("foodPrice"));
                    order.setStatus(rs1.getString("status"));
                    order.setOrderTime(rs1.getTimestamp("orderTime"));
                    order.setDeliverTime(rs1.getTimestamp("deliverTime"));
                    order.setCount(rs1.getInt("count"));
                    order.setFoodName(rs1.getString("foodName"));

                    orderList.add(order);
                   
                }
                OrderModel spliter = new OrderModel();
                spliter.setOrder_id(-1);

                orderList.add(spliter);


               

            }


        } catch (SQLException e) {
            System.out.println("[------me-----]getOrder  part2   method problem : " + e.getMessage());

        }


       /* for (int j = 0; j < orderList.size(); j++) {
            System.out.println(orderList.get(j).toString());
        }*/

        return orderList;

    }


    public static int[] convertToArray(List<Integer> l) {
        int[] output = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            output[i] = l.get(i);

        }
        return output;
    }

    public static int[] removeDuplicates(List<Integer> l) {
        int[] arr = convertToArray(l);
        int end = arr.length;

        for (int i = 0; i < end; i++) {
            for (int j = i + 1; j < end; j++) {
                if (arr[i] == arr[j]) {
                    int shiftLeft = j;
                    for (int k = j + 1; k < end; k++, shiftLeft++) {
                        arr[shiftLeft] = arr[k];
                    }
                    end--;
                    j--;
                }
            }
        }

        int[] whitelist = new int[end];
        for (int i = 0; i < end; i++) {
            whitelist[i] = arr[i];
        }
        return whitelist;
    }
    
    
      //for just testing
  @WebMethod(operationName = "getOrderReformed")
      public void getOrderReformed( ){
      List<OrderModel> uniqOrderList=getOrder("32");
        List<OrderModel> orderList=new ArrayList<>();
        List< List<OrderModel>> allOrderList=new ArrayList<>();
        boolean flag=false;
        
        for(int i=0;i<uniqOrderList.size();i++)
        {
            
            if(uniqOrderList.get(i).getOrder_id()!=-1){
                orderList.add(uniqOrderList.get(i));
               flag=true;
            }
            else if(uniqOrderList.get(i).getOrder_id()==-1 && flag)
            {
                allOrderList.add(orderList);
                orderList=new ArrayList<>();;
                 flag=false;
            }
        }
        
         /*
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
        
    }

    @WebMethod(operationName = "setReceived")
      public void setReceived(String orderId)
      {
          String orderTime = getCurrentTimeStamp();
          Statement mystat = (Statement) dbh.getConnection();
        try {

            String q = "UPDATE `order` SET `deliverTime`='"+orderTime+"' , `status`='received' WHERE (`order_id`="+orderId+");";
            mystat.executeUpdate(q);


        } catch (SQLException e) {
            System.out.println("[------me-----]setReceived WB method problem : " + e.getMessage());
           
        }
          
          
      }
      
      
          @WebMethod(operationName = "getAllOrders")
       public List<OrderModel> getAllOrders() {
           Statement mystat = (Statement) dbh.getConnection();
        List<Integer> numberOfOrderId1 = new ArrayList<>();
         List<Integer> userIdesl = new ArrayList<>();
        List<OrderModel> orderList = new ArrayList<>();
        int[] userIdes;
        try {

            String q = "SELECT `customer_id` FROM `order` ;";
            ResultSet rs = mystat.executeQuery(q);

            while (rs.next()) {
                //all users that has order
                userIdesl.add(rs.getInt("customer_id"));
            }

        } catch (SQLException e) {
            System.out.println("[------me-----]getAllOrders  part1   method problem : " + e.getMessage());

        }
         userIdes = removeDuplicates(userIdesl);
        
         
         for (int w = 0; w < userIdes.length; w++)
         {
                int[] numberOfOrderId;
                try {

                    String q = "SELECT `order_id` FROM `order` WHERE (`customer_id`='" + userIdes[w] + "');";
                    ResultSet rs = mystat.executeQuery(q);

                    while (rs.next()) {
                        //all ordeers for 1 customer
                        numberOfOrderId1.add(rs.getInt("order_id"));
                    }

                } catch (SQLException e) {
                    System.out.println("[------me-----]getAllOrders  part2   method problem : " + e.getMessage());

                }
                numberOfOrderId = removeDuplicates(numberOfOrderId1);

                try {
                    for (int i = 0; i < numberOfOrderId.length; i++) {


                        //System.out.println("--------order number :"+i+"-----------");
                        String q1 = "SELECT `customer`.`customer_id`,`customer`.`fullName`,`customer`.`phone`,`customer`.`address`,`order`.`order_id`,`order`.`orderTime`,`order`.`status`,`order`.`total_price`," +
                                "`order`.`deliverTime`,`order_detail`.`count`,`food`.`foodName`,`food`.`foodPrice`" +
                                " FROM `order`  " +
                                "INNER JOIN `order_detail`" +
                                "		ON `order`.`order_id`= `order_detail`.`order_id`" +
                                "INNER JOIN `food`" +
                                "		ON `order_detail`.`food_id`=`food`.`food_id`" +
                                "INNER JOIN `customer`"+
                                "                  ON `customer`.`customer_id`=`order`.`customer_id`"+
                                "WHERE (`order`.`customer_id`=" + userIdes[w] + ") AND (`order`.`order_id`=" + numberOfOrderId[i] + ")";
                        ResultSet rs1 = mystat.executeQuery(q1);

                        while (rs1.next()) {
                            OrderModel order = new OrderModel();
                            order.setOrder_id(rs1.getInt("order_id"));
                            order.setFullName(rs1.getString("fullName"));
                            order.setPhone(rs1.getString("phone"));
                            order.setStatus(rs1.getString("status"));
                            order.setAddress(rs1.getString("address"));
                            order.setFoodName(rs1.getString("foodName"));
                            order.setCount(rs1.getInt("count"));
                            order.setTotal_price(rs1.getDouble("total_price"));
                            order.setFoodPrice(rs1.getDouble("foodPrice"));
                             order.setOrderTime(rs1.getTimestamp("orderTime"));
                           
                            order.setCustomerId(rs1.getInt("customer_id"));
                            orderList.add(order);
                        }
                        OrderModel spliter = new OrderModel();
                        spliter.setOrder_id(-1);
                        

                        orderList.add(spliter);


                    }


                } catch (SQLException e) {
                    System.out.println("[------me-----]getAllOrders  part3   method problem : " + e.getMessage());

                }
                OrderModel spliter = new OrderModel();
                spliter.setOrder_id(-2);

                orderList.add(spliter);

         }
         
/*
        for (int j = 0; j < orderList.size(); j++) {
            System.out.println(orderList.get(j).toString());
        }
*/
        return orderList;
       }

       //for just testing
@WebMethod(operationName = "getAllOrderReformed")
      public void getAllOrderReformed( ){
      List<OrderModel> uniqOrderList=getAllOrders();
        List<OrderModel> orderList=new ArrayList<>();
       List<List<OrderModel>> allOrderList=new ArrayList<>();
        List< List<List<OrderModel>>> allOrderListAll=new ArrayList<>();
        boolean flag1=false;
           boolean flag2=false;
           
         for(int i=0;i<uniqOrderList.size();i++)
        {
            
            
             if(uniqOrderList.get(i).getOrder_id()!=-2){
               
                if(uniqOrderList.get(i).getOrder_id()!=-1){
                orderList.add(uniqOrderList.get(i));
                flag1=true;
                }
                else if(uniqOrderList.get(i).getOrder_id()==-1 && flag1)
                {
                    allOrderList.add(orderList);
                    orderList=new ArrayList<>();;
                     flag1=false;
                }
                
                
               flag2=true;
            }
            else if(uniqOrderList.get(i).getOrder_id()==-2 && flag2)
            {
                allOrderListAll.add(allOrderList);
                allOrderList=new ArrayList<>();;
                 flag2=false;
            }
        }
         
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
            
       
         }
    }

      
       @WebMethod(operationName = "setSend")
      public void setSend(String orderId)
      {
          Statement mystat = (Statement) dbh.getConnection();
        try {

            String q = "UPDATE `order` SET  `status`='sending' WHERE (`order_id`="+orderId+");";
            mystat.executeUpdate(q);


        } catch (SQLException e) {
            System.out.println("[------me-----]setSend WB method problem : " + e.getMessage());
            // return "-1";
        }
          
          
      }
    
   @WebMethod(operationName = "setAvaluable")
    public String setAvaluable(String foodId) {
        
        Statement mystat = (Statement) dbh.getConnection();
        int isAvlu;
        try {
            String q1;
            String q = "SELECT `isAvaluable` FROM `food` WHERE (`food_id`="+foodId+");";
           ResultSet rs= mystat.executeQuery(q);
           rs.next();
           isAvlu=rs.getInt("isAvaluable");
           if(isAvlu==1)
               q1="UPDATE `food` SET `isAvaluable`=0  WHERE (`food_id`="+foodId+");";
           else
               q1="UPDATE `food` SET `isAvaluable`=1  WHERE (`food_id`="+foodId+");";
            
             mystat.executeUpdate(q1);
             return "1";
           
        } catch (SQLException e) {
            System.out.println("[------me-----]setAvaluable WB method problem : " + e.getMessage());
         return "0";
        }
   


    }
    
      @WebMethod(operationName = "deleteFood")
    public String deleteFood(String foodId) {
        
        Statement mystat = (Statement) dbh.getConnection();
  
        try {
            String q = "DELETE FROM `food` WHERE (`food_id`="+foodId+");";
          
            mystat.executeUpdate(q);
            return "1";
           
        } catch (SQLException e) {
            return "0";
        }
  // return "-1";


    }

    
    @WebMethod(operationName = "addFood")
    public String addFood(String foodName,int foodPrice,String type,String picPath) {

        Statement mystat = (Statement) dbh.getConnection();
       
       
        try {

            String q = "INSERT INTO `food`  (`foodName`, `foodPrice`, `isAvaluable`,`foodPicPath`, `type`) VALUES('" + foodName + "', " + foodPrice + ", 1, '/"+picPath+".jpg','" + type  + "'); ";
            mystat.executeUpdate(q);


            return "1";
        } catch (SQLException e) {
            System.out.println("[------me-----]addFood adding part WB method problem : " + e.getMessage());
            return "0";
        }

    }

    
    

}



  
