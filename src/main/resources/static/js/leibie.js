var chak=document.getElementById('chak');
var lb=document.getElementById('lb');
chak.onmouseover = function () {
    console.log(12111111111)
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
