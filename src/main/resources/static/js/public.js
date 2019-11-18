var token = sessionStorage.getItem("token")?sessionStorage.getItem("token"):null;
var toShopCar = document.getElementsByClassName("img2")[0]

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
                var blocks = document.getElementsByClassName("isLogin")
                var outbtn = document.getElementsByClassName("login-out")
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

function loginOut(){
    sessionStorage.removeItem("token");
    alert("您已退出登录！")
    window.location.href="./login";
}

toShopCar.addEventListener("click",function(){
    window.location.href='./shopcar'
})