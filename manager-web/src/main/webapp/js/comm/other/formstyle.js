// JavaScript Document

/*CUSTOM FORM ELEMENTS

Created by Ryan Fait

The only thing you need to change in this file is the following
variables: checkboxHeight, radioHeight and selectWidth.

Replace the first two numbers with the height of the checkbox and
radio button. The actual height of both the checkbox and radio
images should be 4 times the height of these two variables. The
selectWidth value should be the width of your select list image.

You may need to adjust your images a bit if there is a slight
vertical movement during the different stages of the button
activation.

*/
function cls(){
//捕获触发事件的对象，并设置为以下语句的默认对象
with(event.srcElement)
     //如果当前值为默认值，则清空
if(value==defaultValue) value=""
}
function res(){
//捕获触发事件的对象，并设置为以下语句的默认对象
with(event.srcElement)
//如果当前值为空，则重置为默认值
if(value=="") value=defaultValue
}

var checkboxHeight = "17";
var radioHeight = "17";
var selectWidth = "190";

/* No need to change anything after this */

document.write('<style type="text/css">input.styled { display: none; } select.styled { position: relative; width: ' + selectWidth + 'px; opacity: 0; filter: alpha(opacity=0); z-index: 5; }</style>');

var Custom = {
 init: function() {
 var inputs = document.getElementsByTagName("input"), span = Array(), textnode, option, active;
 for(a = 0; a < inputs.length; a++) {
 if((inputs[a].type == "checkbox" || inputs[a].type == "radio") && inputs[a].className == "styled") {
 span[a] = document.createElement("span");
 span[a].className = inputs[a].type;

 if(inputs[a].checked == true) {
 if(inputs[a].type == "checkbox") {
 position = "0 -" + (checkboxHeight*2) + "px";
 span[a].style.backgroundPosition = position;
 } else {
 position = "0 -" + (radioHeight*2) + "px";
 span[a].style.backgroundPosition = position;
 }
 }
 inputs[a].parentNode.insertBefore(span[a], inputs[a]);
 inputs[a].onchange = Custom.clear;
 span[a].onmousedown = Custom.pushed;
 span[a].onmouseup = Custom.check;
 document.onmouseup = Custom.clear;
 }
 }
 inputs = document.getElementsByTagName("select");
 for(a = 0; a < inputs.length; a++) {
 if(inputs[a].className == "styled") {
 option = inputs[a].getElementsByTagName("option");
 active = option[0].childNodes[0].nodeValue;
 textnode = document.createTextNode(active);
 for(b = 0; b < option.length; b++) {
 if(option[b].selected == true) {
 textnode = document.createTextNode(option[b].childNodes[0].nodeValue);
 }
 }
 span[a] = document.createElement("span");
 span[a].className = "select";
 span[a].id = "select" + inputs[a].name;
 span[a].appendChild(textnode);
 inputs[a].parentNode.insertBefore(span[a], inputs[a]);
 inputs[a].onchange = Custom.choose;
 }
 }
 },
 pushed: function() {
 element = this.nextSibling;
 if(element.checked == true && element.type == "checkbox") {
 this.style.backgroundPosition = "0 -" + checkboxHeight*3 + "px";
 } else if(element.checked == true && element.type == "radio") {
 this.style.backgroundPosition = "0 -" + radioHeight*3 + "px";
 } else if(element.checked != true && element.type == "checkbox") {
 this.style.backgroundPosition = "0 -" + checkboxHeight + "px";
 } else {
 this.style.backgroundPosition = "0 -" + radioHeight + "px";
 }
 },
 check: function() {
 element = this.nextSibling;
 if(element.checked == true && element.type == "checkbox") {
 this.style.backgroundPosition = "0 0";
 element.checked = false;
 } else {
 if(element.type == "checkbox") {
 this.style.backgroundPosition = "0 -" + checkboxHeight*2 + "px";
 } else {
 this.style.backgroundPosition = "0 -" + radioHeight*2 + "px";
 group = this.nextSibling.name;
 inputs = document.getElementsByTagName("input");
 for(a = 0; a < inputs.length; a++) {
 if(inputs[a].name == group && inputs[a] != this.nextSibling) {
 inputs[a].previousSibling.style.backgroundPosition = "0 0";
 }
 }
 }
 element.checked = true;
 }
 },
 clear: function() {
 inputs = document.getElementsByTagName("input");
 for(var b = 0; b < inputs.length; b++) {
 if(inputs[b].type == "checkbox" && inputs[b].checked == true && inputs[b].className == "styled") {
 inputs[b].previousSibling.style.backgroundPosition = "0 -" + checkboxHeight*2 + "px";
 } else if(inputs[b].type == "checkbox" && inputs[b].className == "styled") {
 inputs[b].previousSibling.style.backgroundPosition = "0 0";
 } else if(inputs[b].type == "radio" && inputs[b].checked == true && inputs[b].className == "styled") {
 inputs[b].previousSibling.style.backgroundPosition = "0 -" + radioHeight*2 + "px";
 } else if(inputs[b].type == "radio" && inputs[b].className == "styled") {
 inputs[b].previousSibling.style.backgroundPosition = "0 0";
 }
 }
 },
 choose: function() {
 option = this.getElementsByTagName("option");
 for(d = 0; d < option.length; d++) {
 if(option[d].selected == true) {
 document.getElementById("select" + this.name).childNodes[0].nodeValue = option[d].childNodes[0].nodeValue;
 }
 }
 }
}
window.onload = Custom.init;