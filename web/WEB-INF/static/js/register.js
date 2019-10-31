var zin =document.getElementById('zin');
var zh1 =document.getElementById('zh1');

function onn(a,b) {
    a.style.transform = 'scale(0.8)';
    a.style.transition = '0.1s linear';
    a.style.width = 'auto';
    a.style.height = '12px';
    a.style.fontSize = '12px';
    a.style.lineHeight = '12px';
    a.style.color = "#4090fe";
    a.style.top = '-6px';
    a.style.background = 'white';
    b.style.border = '1px solid #4090fe';
}
function otwr(a,b) {
    a.style.color = "";
    a.style.transform = 'scale(0.8)';
    a.style.transition = '0.1s linear';
    a.style.width = 'auto';
    a.style.height = '12px';
    a.style.fontSize = '12px';
    a.style.lineHeight = '12px';
    a.style.top = '-6px';
    a.style.background = 'white';
    b.style.border = '';
}
function otww(a,b) {
    a.style.transform = 'scale(0.8)';
    a.style.transition = '0.1s linear';
    a.style.width = 'auto';
    a.style.height = '12px';
    a.style.fontSize = '12px';
    a.style.lineHeight = '12px';
    a.style.top = '-6px';
    a.style.background = 'white';
    a.style.color = "red";
    b.style.border = '1px solid red';
}
function otn(a,b) {
    a.style.transform = '';
    a.style.transition = '0.1s linear';
    a.style.width = '';
    a.style.height = '';
    a.style.fontSize = '';
    a.style.lineHeight = '';
    a.style.color = "";
    a.style.top = '';
    a.style.left = '';
    a.style.background = '';
    b.style.border = '';
}

zh1.onclick = function () {
    zin.focus();
};

zin.onfocus = function bx() {
    onn(zh1,zin);
    zh1.style.left = '5px';
};
var zh_reg = /^[a-zA-Z0-9]\w{5,10}$|^1[35678]\d{9}$|^[a-zA-Z0-9]\w{5,10}@[a-zA-Z]{2,8}\.[a-zA-Z]{2,4}(\.[a-zA-Z]{2,4})?$/;
zin.onblur = function () {
    var val = zin.value;
    if(val){
        var test = zh_reg.test(val);
        if(test){
            otwr(zh1,zin);
        }else{
            otww(zh1,zin);
        }
        zh1.style.left = '5px';
    }else{
        otn(zh1,zin);
    }
};
var min =document.getElementById('min');
var mm =document.getElementById('mm');

mm.onclick = function () {
    min.focus();
};

min.onfocus = function bx() {
    onn(mm,min);
    mm.style.left = '10px';
};

min.onblur = function () {
    var val = min.value;
    if(val){
        var mm_reg = /^[a-zA-Z0-9]\w{5,10}$/;
        var test = mm_reg.test(val);
        if(test){
            otwr(mm,min);
        }else{
            otww(mm,min);
        }
        mm.style.left = '10px';
    }else{
        otn(mm,min);
    }
};

var remin =document.getElementById('remin');
var rem =document.getElementById('rem');

rem.onclick = function () {
    remin.focus();
};

remin.onfocus = function bx() {
    onn(rem,remin);
    rem.style.left = '10px';
};

remin.onblur = function () {
    var val = remin.value;
    if(val){
        if(val===min.value){
            otwr(rem,remin);
        }else{
            otww(rem,remin);
        }
        rem.style.left = '10px';
    }else{
        otn(rem,remin);
    }
};