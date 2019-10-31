var zin =document.getElementById('zin');
var zh1 =document.getElementById('zh1');



zh1.onclick = function () {
  zin.focus();
};

zin.onfocus = function bx() {
    zh1.style.transform = 'scale(0.8)';
    zh1.style.transition = '0.1s linear';
    zh1.style.width = 'auto';
    zh1.style.height = '12px';
    zh1.style.fontSize = '12px';
    zh1.style.lineHeight = '12px';
    zh1.style.color = "#4090fe";
    zh1.style.top = '-6px';
    zh1.style.left = '5px';
    zh1.style.background = 'white';
    zin.style.border = '1px solid #4090fe';
};


zin.onblur = function () {
    var val = zin.value;
    if(val){
        var zh_reg = /^[a-zA-Z0-9]\w{5,10}$|^1[35678]\d{9}$|^[a-zA-Z0-9]\w{5,10}@[a-zA-Z]{2,8}\.[a-zA-Z]{2,4}(\.[a-zA-Z]{2,4})?$/;
        var test = zh_reg.test(val);
        if(test){
            zin.style.border = '';
            zh1.style.color = "";
        }else{
            zin.style.border = '1px solid red';
            zh1.style.color = "red";
        }
        zh1.style.transform = 'scale(0.8)';
        zh1.style.transition = '0.1s linear';
        zh1.style.width = 'auto';
        zh1.style.height = '12px';
        zh1.style.fontSize = '12px';
        zh1.style.lineHeight = '12px';
        zh1.style.top = '-6px';
        zh1.style.left = '5px';
        zh1.style.background = 'white';


    }else{
        zh1.style.transform = '';
        zh1.style.transition = '0.1s linear';
        zh1.style.width = '';
        zh1.style.height = '';
        zh1.style.fontSize = '';
        zh1.style.lineHeight = '';
        zh1.style.color = "";
        zh1.style.top = '';
        zh1.style.left = '';
        zh1.style.background = '';
        zin.style.border = '';
    }
};
var min =document.getElementById('min');
var mm =document.getElementById('mm');

mm.onclick = function () {
    min.focus();
};

min.onfocus = function bx() {
    mm.style.transform = 'scale(0.8)';
    mm.style.transition = '0.1s linear';
    mm.style.width = 'auto';
    mm.style.height = '12px';
    mm.style.fontSize = '12px';
    mm.style.lineHeight = '12px';
    mm.style.color = "#4090fe";
    mm.style.top = '-6px';
    mm.style.left = '10px';
    mm.style.background = 'white';
    min.style.border = '1px solid #4090fe';
};

min.onblur = function () {
    var val = min.value;
    if(val){
        var mm_reg = /^[a-zA-Z0-9]\w{5,10}$/;
        var test = mm_reg.test(val);
        if(test){
            min.style.border = '';
            mm.style.color = "";
        }else{
            min.style.border = '1px solid red';
            mm.style.color = "red";
        }
        mm.style.transform = 'scale(0.8)';
        mm.style.transition = '0.1s linear';
        mm.style.width = 'auto';
        mm.style.height = '12px';
        mm.style.fontSize = '12px';
        mm.style.lineHeight = '12px';
        mm.style.top = '-6px';
        mm.style.left = '5px';
        mm.style.background = 'white';
    }else{
        mm.style.transform = '';
        mm.style.transition = '0.1s linear';
        mm.style.width = '';
        mm.style.height = '';
        mm.style.fontSize = '';
        mm.style.lineHeight = '';
        mm.style.color = '';
        mm.style.top = '';
        mm.style.left = '';
        mm.style.background = '';
        min.style.border = '';
    }
};

var lg = document.getElementById('lg');

lg.onclick= function() {
    var zh_val = zin.value;
    var zh_reg = /^[a-zA-Z0-9]\w{5,10}$|^1[35678]\d{9}$|^[a-zA-Z0-9]\w{5,10}@[a-zA-Z]{2,8}\.[a-zA-Z]{2,4}(\.[a-zA-Z]{2,4})?$/;
    var zh_test = zh_reg.test(zh_val);
    var mm_val = min.value;
    var mm_reg = /^[a-zA-Z0-9]\w{5,10}$/;
    var mm_test = mm_reg.test(mm_val);
    if(!zh_test){
        alert('账号格式不正确！');
        console.log(zh_test);
        return false;
    }else if(!mm_test){
        alert('密码格式不正确！');
        return false;
    }
};
















