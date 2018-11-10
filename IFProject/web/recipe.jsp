<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta name="viewport" content="width=device-width, user-scalable=no">
    <link rel="stylesheet" href="bootstrap.min.css">
    <link rel="stylesheet" href="master.css">
    <link rel="stylesheet" href="main.css">
    <link rel="stylesheet" href="recipe.css">
    <script
            src="https://code.jquery.com/jquery-3.3.1.js"
            integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</head>
<body>
<div class="container-fluid">

    <!--위 내브바-->
    <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top nav-top">
        <div class="w-100">
            <a class="navbar-brand logo" href="#">
                <h1>베지:투게더</h1>
            </a>
            <div class="search-icon">
                <img src="" alt="">
            </div>
        </div>
        <div class="row select-navbar">
            <ul>
                <li class="select-nav nav-active">
                    <a href="#">세미</a>
                </li>
                <li class="select-nav">
                    <a href="#">페스코</a>
                </li>
                <li class="select-nav">
                    <a href="#">락토</a>
                </li>
                <li class="select-nav">
                    <a href="#">오보</a>
                </li>
                <li class="select-nav">
                    <a href="#">락토 오보</a>
                </li>
                <li class="select-nav">
                    <a href="#">비건</a>
                </li>
                <li class="select-nav">
                    <a href="#">프루테리언</a>
                </li>
            </ul>
        </div>
    </nav>

    <!--콘텐츠 영역-->
    <div class="content-sec row sec-scroll">

        <!--메인 슬라이드-->
        <div id="carouselExampleIndicators" class="carousel slide main-slide" data-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <!--슬라이드 이미지-->
                    <div class="slide-img" style="background-image: url('http://res.heraldm.com/phpwas/restmb_idxmake.php?idx=507&simg=/content/image/2017/04/19/20170419000874_0.jpg')"></div>
                    <div class="carousel-caption slide-content">
                        <div class="slide-info-box">
                            <div class="profile-box">
                                <div class="profile-img " style="background-image: url('data:image/jpeg;base64,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')"></div>
                                <span class="writer">by.이 루다</span>
                            </div>
                            <div class="subline"></div>
                            <span class="subname">입문자 추천드리는</span>
                            <h4 class="slide-name">비건 비빔 국수</h4>
                        </div>
                    </div>
                    <div class="info-box">
                        <span> <img src="imgs/talk.png" alt=""> 320</span>
                        <span> <img src="imgs/heart.png" alt=""> 320</span>
                    </div>

                </div>
            </div>
        </div>


        <div class="card-box">
           <div class="row">
               <div class="col-6 p-0">
                   <div class="card" style="">
                       <img class="card-img-top" src="http://res.heraldm.com/phpwas/restmb_idxmake.php?idx=507&simg=/content/image/2017/04/19/20170419000874_0.jpg" alt="Card image cap">
                       <div class="card-body">
                           <h5 class="card-title">밴 브로드</h5>
                           <span>야생전은 어썸할 거야</span>
                       </div>
                   </div>
               </div>

               <div class="col-6 p-0">
                   <div class="card" style="">
                       <img class="card-img-top" src="http://res.heraldm.com/phpwas/restmb_idxmake.php?idx=507&simg=/content/image/2017/04/19/20170419000874_0.jpg" alt="Card image cap">
                       <div class="card-body">
                           <h5 class="card-title">밴 브로드</h5>
                           <span>야생전은 어썸할 거야</span>
                       </div>
                   </div>
               </div>
           </div>

            <div class="row">
                <div class="col-6 p-0">
                    <div class="card" style="">
                        <img class="card-img-top" src="http://res.heraldm.com/phpwas/restmb_idxmake.php?idx=507&simg=/content/image/2017/04/19/20170419000874_0.jpg" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">밴 브로드</h5>
                            <span>야생전은 어썸할 거야</span>
                        </div>
                    </div>
                </div>

                <div class="col-6 p-0">
                    <div class="card" style="">
                        <img class="card-img-top" src="http://res.heraldm.com/phpwas/restmb_idxmake.php?idx=507&simg=/content/image/2017/04/19/20170419000874_0.jpg" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">밴 브로드</h5>
                            <span>야생전은 어썸할 거야</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>


    <!--밑 네브바-->
    <nav class="navbar navbar-expand-lg navbar-light bg-light nav-bottom fixed-bottom">
        <ul class="nav-menu">
            <li>
                <a href="#">
                    <div class="icon">
                        <img src="imgs/homeon.png" alt="">
                    </div>
                    <span>홈</span>
                </a>
            </li>
            <li>
                <a href="#">
                    <div class="icon">
                        <img src="imgs/recipeon.png" alt="">
                    </div>
                    <span>레시피</span>
                </a>
            </li>
            <li>
                <a href="#">
                    <div class="icon">
                        <img src="imgs/paperon.png" alt="">
                    </div>
                    <span>메거진</span>
                </a>
            </li>
            <li>
                <a href="#">
                    <div class="icon">
                        <img src="imgs/useron.png" alt="">
                    </div>
                    <span>마이페이지</span>
                </a>
            </li>
        </ul>
    </nav>
</div>
</body>
<script>
    $(document).ready(function(){
        var formData = {
            'levels': 1
        };
        $.ajax({
            type:"get",
            url:"/api/recipe_best",
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
</html>