var s31=document.getElementById('s31');
var s32=document.getElementById('s32');
var s33=document.getElementById('s33');
s31.onclick =function () {
    if(parseInt(s32.value)>1){
        var p1=parseInt(s32.value);
        s32.value=p1-1;
    }else{
        s32.value=1;
    }
};
s33.onclick =function () {
    if(parseInt(s32.value)>=1){
        var p2=parseInt(s32.value);
        s32.value=p2+1;
    }else{
        s32.value=2;
    }
};