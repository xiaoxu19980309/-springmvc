var token = sessionStorage.getItem("token")?sessionStorage.getItem("token"):null;
var toShopCar = document.getElementsByClassName("img2")[0]
var blocks = document.getElementsByClassName("isLogin")
var outbtn = document.getElementsByClassName("login-out")

var carItem
var header_right = document.getElementsByClassName("ul-bar-right")[0]
if(header_right){
    carItem = header_right.getElementsByClassName("a0")[0]
}

function checkToken(){
    $.ajax({
        url: '/api/user/checkToken',
        type: 'post',
        data: {
        },
        beforeSend: function(request){
            request.setRequestHeader("Authorization",token);
        },
        success: function(data){
            if(data.data!=null){
                for(var i=0;i<blocks.length;i++){
                    blocks[i].style.display = "none";
                }
                for(var i=0;i<outbtn.length;i++){
                    outbtn[i].style.display = "block";
                }
            }else{
                alert("登录失效，请重新登录！");
                sessionStorage.removeItem("token");
                window.location.href="./login";
            }
        },
        error: function(e){
            alert("登录失效，请重新登录！");
            sessionStorage.removeItem("token");
            window.location.href="./login";
        }
    })
}

function checkTokenHeader(){
    $.ajax({
        url: '/api/user/checkToken',
        type: 'post',
        data: {
        },
        beforeSend: function(request){
            request.setRequestHeader("Authorization",token);
        },
        success: function(data){
            if(data.data!=null){
                for(var i=0;i<blocks.length;i++){
                    blocks[i].style.display = "none";
                }
                for(var i=0;i<outbtn.length;i++){
                    outbtn[i].style.display = "block";
                }
            }else{
                sessionStorage.removeItem("token");
            }
        },
        error: function(e){
        }
    })
}

function loginOut(){
    sessionStorage.removeItem("token");
    alert("您已退出登录！")
    window.location.href="./login";
}

if(toShopCar!=null){
    toShopCar.addEventListener("click",function(){
        window.location.href='./shopcar'
    })
}

function getCar(){
    $.ajax({
        url: "/api/shopping/getShoppingCar",
        type: "POST",
        data: {
            token: sessionStorage.getItem("token")
        },
        beforeSend: function(request){
            request.setRequestHeader("Authorization",token);
        },
        success: function(res){
            if(res.resultCode!=200){
                $.growl.error({
                    title: "提示",
                    message: "获取购物车列表失败!"
                })
            }else{
                carItem.innerHTML = res.data.length
            }
        },
        error: function(e){

        }
    })
}