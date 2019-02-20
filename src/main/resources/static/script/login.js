var token;
function login() {
    var params = {};
    params.name = $("#name").val();
    params.password = $("#password").val();
    $.ajax({
        url:'/api/login',
        dataType:'json',
        data:{userId: params.name, passWord: params.password},
        success: function (data) {
            console.log(data);
            token = data.token;
            alert("登录成功")
            }
    })
}

function getMessage() {
    var currentCookie = document.cookie.split(',')[0];
    $.ajax({
        url:'/api/getMessage',
        dataType:'json',
        headers: {
            'Content-Type': 'application/json',
            'token': token
        },
        success: function (data) {
            window.location = 'index.html';
        }
    })
}