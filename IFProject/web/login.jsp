<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta name="viewport" content="width=device-width, user-scalable=no">
    <link rel="stylesheet" href="bootstrap.min.css">
    <script
            src="https://code.jquery.com/jquery-3.3.1.js"
            integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="master.css">
    <link rel="stylesheet" href="log_bg.css">
</head>
<body>

<!--콘텐츠 영역-->
<div class="container-fluid">
    <div class="content-sec row sec-scroll">
        <div class="bg">
            <img src="imgs/log_bg.jpg" alt="">
            <div class="main">
            <span>채식주의자의<br>행복과 공존,</span><br>
            <h2>베지:투게더</h2>
            <div class="log_box">
                <form id="loginForm">
                    <div class="box">
                        <input type="text" id="userid" name= "userid" placeholder="유저 아이디">
                    </div>
                    <div class="box">
                        <input type="password" id="userpw" name="userpw" placeholder="비밀번호">
                    </div>
                    <button class="login"><input type="submit" value="로그인"></button>
                </form>
                    <button class="register"><a href="#">회원가입</a></button>
            </div>
        </div>
        </div>
    </div>
</div>

<script>
    $("#loginForm").on('submit', function(e){
        e.preventDefault();

        var formData = {
            'userid': $("#userid").val(),
            'userpw': $("#userpw").val()
        };

        $.ajax({
            type:"post",
            url:"/api/login",
            data: formData,
            dataType : "json",
            success: function(data){
                console.log(data);
            },
            error: function(xhr, status, error) {
                alert(error);
            }
        });
    });
</script>

</body>
</html>