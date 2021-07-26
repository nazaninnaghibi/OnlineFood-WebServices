var allfood=document.getElementsByName("foodname");
var orderit=document.getElementById("orderit");
var allfoodlist;
var foodorder_form=document.getElementById("foodorder-form");


orderit.addEventListener('click',orderit_handler);
function orderit_handler(){
    allfoodlist="";
    var anyOrder=false;
    for (let i = 0; i < allfood.length; i++) {
        if(allfood[i].value!=="0")
        {
           allfoodlist+=allfood[i].getAttribute('food_id')+":"+allfood[i].value+";";
           anyOrder=true;
        }
   }
    if(anyOrder){
        var order_list_temp=document.getElementById("order_list_temp");
        order_list_temp.setAttribute('value',allfoodlist);
        
        setTimeout(function (){foodorder_form.submit()},400);
    }
    else
        alert("please choose some food to order");
}
