//background and pop ups
var body=document.body;
var background=document.getElementsByClassName("background")[0];
var global_signin_btn=document.getElementById("global-signin-btn");
var global_signup_btn=document.getElementById("global-signup-btn");

var signin_popup=document.getElementsByClassName("sign-in-popup")[0];
var signup_popup=document.getElementsByClassName("sign-up-popup")[0];

var inpopup_signup_btn=document.getElementsByClassName("signup-btn")[0];
var inpopup_signin_btn=document.getElementsByClassName("signin-btn")[0];

var signin_form=document.getElementById("signin-form");
var signup_form=document.getElementById("signup-form");

global_signin_btn.addEventListener('click',popup_signin_show);
global_signup_btn.addEventListener('click',popup_signup_show);
background.addEventListener('click',background_hide);
inpopup_signup_btn.addEventListener('click',submit_signup);
inpopup_signin_btn.addEventListener('click',submit_signin);

function popup_signup_show() {
    background_show();
    signup_popup.setAttribute('style','display:block');
}
function popup_signup_hide() {
    signup_popup.setAttribute('style','display:none');
}

function popup_signin_show() {
    background_show();
    signin_popup.setAttribute('style','display:block');
}
function popup_signin_hide() {
    signin_popup.setAttribute('style','display:none');
}
function   background_show() {
    background.setAttribute('style','display:block');
    body.setAttribute('style','    overflow-y: hidden;');

}
function background_hide() {
    background.setAttribute('style','display:none');
    popup_signup_hide();
    popup_signin_hide();
    body.removeAttribute('style');
}
function submit_signup() {
    let fullname=document.getElementsByName("fullname")[0].value;
    let username=document.getElementsByName("su-username")[0].value;
    let password=document.getElementsByName("su-password")[0].value;
    let address=document.getElementsByName("address")[0].value;
    let phone=document.getElementsByName("phone")[0].value;
    if(fullname==="")
        alert("please enter your full name");
    else if(username==="")
        alert("please enter your username");
    else if(password==="")
        alert("please enter your password");
    else if(address==="")
        alert("please enter your address");
    else if(phone==="")
        alert("please enter your phone");
    else
        signup_form.submit();

}
function submit_signin() {
    let username=document.getElementsByName("si-username")[0].value;
    let password=document.getElementsByName("si-password")[0].value;

    if(username==="")
        alert("please enter your username");
    else if(password==="")
        alert("please enter your password");
    else
        signin_form.submit();

}
