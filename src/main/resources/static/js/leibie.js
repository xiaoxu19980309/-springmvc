var chak=document.getElementById('chak');
var lb=document.getElementById('lb');
var person = document.getElementById("person")
var personList = document.getElementById("personList")
chak.onmouseover = function () {
    lb.style.display='block';
}
chak.onmouseout = function () {
    lb.style.display='none';
}
lb.onmouseover = function () {
    lb.style.display='block';
}
lb.onmouseout = function () {
    lb.style.display='none';
}
person.onmouseover = function(){
    personList.style.display = "block";
}
person.onmouseout = function(){
    personList.style.display = "none";
}
personList.onmouseover = function(){
    personList.style.display = "block";
}
personList.onmouseout = function(){
    personList.style.display = "none";
}