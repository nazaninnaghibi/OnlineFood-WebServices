var manage_foods_btn=document.getElementsByClassName("manage-foods-btn")[0];
var order_reports_btn=document.getElementsByClassName("order-reports-btn")[0];


var report_container=document.getElementsByClassName("report-container")[0];
var manage_container=document.getElementsByClassName("manage-container")[0];

manage_foods_btn.addEventListener('click',manage_foode_handler);
order_reports_btn.addEventListener('click',order_reports_handler);

function manage_foode_handler() {
    manage_container.setAttribute('style','display:block');
    report_container.setAttribute('style','display:none');
}
function order_reports_handler() {
    report_container.setAttribute('style','display:block');
    manage_container.setAttribute('style','display:none');
}

/**********************add food food manage***************/
var add_food_btn=document.getElementsByClassName("add-food-btn")[0];
var addfood_popup=document.getElementsByClassName("addfood-popup")[0];
var background=document.getElementsByClassName("background")[0];
var body=document.body;
add_food_btn.addEventListener('click',add_food_handler);
background.addEventListener('click',background_hide);


function popup_addfood_show() {
    addfood_popup.setAttribute('style','display:block');
}
function popup_addfood_hide() {
    addfood_popup.setAttribute('style','display:none');
}
function add_food_handler() {
    popup_addfood_show();
    background_show();
}

function   background_show() {
    background.setAttribute('style','display:block');
    body.setAttribute('style','    overflow-y: hidden;');

}
function background_hide() {
    background.setAttribute('style','display:none');
    popup_addfood_hide();
    body.setAttribute('style','    overflow-y: scroll;');
}




