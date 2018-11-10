<!DOCTYPE html>
<html lang="ko">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta name="viewport" content="width=device-width, user-scalable=no">
    <link rel="stylesheet" href="bootstrap.min.css">
    <link rel="stylesheet" href="master.css">
    <link rel="stylesheet" href="main.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

    <%
        if(session.getAttribute("user_id") == null){
            response.sendRedirect("/login.jsp");
        }
    %>
</head>
<body>
    <!--전체 컨테이너 (max-width 902px = 꽉찬 컨테이너)-->
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
        </nav>

        <!--콘텐츠 영역-->
        <div class="content-sec row sec-scroll">

            <!--메인 슬라이드-->
            <div id="carouselExampleIndicators" class="carousel slide main-slide" data-ride="carousel">
                <!--슬라이드 이미지-->
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <div class="slide-img" style="background-image: url('http://res.heraldm.com/phpwas/restmb_idxmake.php?idx=507&simg=/content/image/2017/04/19/20170419000874_0.jpg')"></div>

                        <div class="carousel-caption slide-content">
                            <div class="slide-title-box">
                                <h3>베지투게더<br>일간</br>레시피</h3>
                            </div>

                            <div class="slide-info-box">
                                <span class="writer">by.이 루다</span>
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

                    <div class="carousel-item active">
                        <div class="slide-img" style="background-image: url('https://s-i.huffpost.com/gen/2116230/images/n-VEGETARIAN-PROTEIN-628x314.jpg')"></div>

                        <div class="carousel-caption slide-content">
                            <div class="slide-title-box">
                                <h3>베지투게더<br>일간</br>매거진</h3>
                            </div>

                            <div class="slide-info-box">
                                <span class="writer">by.이 루다</span>
                                <div class="subline"></div>
                                <span class="subname">입문자 추천드리는</span>
                                <h4 class=slide-name">비건 비빔 국수</h4>
                            </div>
                        </div>
                        <div class="info-box">
                            <span> <img src="imgs/heart.png" alt=""> 320</span>
                        </div>

                    </div>
                </div>
                <!--다음 이전 버튼-->
                <a class="carousel-control-prev slide-btn" href="#carouselExampleIndicators" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next slide-btn" href="#carouselExampleIndicators" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
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


    <script>
        $.ajax({
            t
        })
    </script>
</body>
</html>