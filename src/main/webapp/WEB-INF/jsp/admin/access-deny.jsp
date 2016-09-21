<%--
  Created by IntelliJ IDEA.
  User: quangphuong
  Date: 9/20/16
  Time: 8:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Themes Lab - Creative Laborator</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta content="" name="description" />
    <meta content="themes-lab" name="author" />
    <link rel="shortcut icon" href="global/images/favicon.png">
    <link href="global/css/style.css" rel="stylesheet">
    <link href="global/css/ui.css" rel="stylesheet">
</head>
<body class="sidebar-condensed error-page">
<div class="row">
    <div class="col-lg-4 col-lg-offset-4 col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2 col-xs-12">
        <div class="error-container">
            <div class="error-main">
                <h1><span id="404"></span></h1>
                <h3><span id="404-txt"></span></h3>
                <h4><span id="404-txt-2"></span></h4>
                <br>
                <div class="row" id="content-404">
                    <div class="col-md-6 col-md-offset-3 text-center">
                        <div class="input-icon">
                            <i class="fa fa-search"></i>
                            <input type="text" class="form-control form-white" placeholder="Search for page">
                        </div>
                        <br>
                        <button class="btn btn-dark" type="button">Search</button>
                    </div>
                    <div class="col-md-12 text-center">
                        <br><br>
                        <p>OR</p>
                        <br><br><br>
                        <div class="btn-group">
                            <a class="btn btn-white" href="/login">
                                <i class="fa fa-angle-left"></i> Go back
                            </a>
                            <a class="btn btn-white btn-home" href="dashboard.html">
                                <i class="icon-home"></i> Home Page
                            </a>
                            <a class="btn btn-white" href="/login">
                                <i class="icon-login"></i> Login
                            </a>
                            <a class="btn btn-white btn-message" href="mailbox-send.html">
                                <i class="icon-envelope"></i> Send us a message
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="footer">
    <div class="copyright">© Copyright Themes Lab, 2015 Themes Lab Inc.</div>
</div>
<script src="global/plugins/jquery/jquery-1.11.1.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script src="global/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="global/plugins/typed/typed.js"></script>
<script>
    $(function(){
        $("#404").typed({
            strings: ["403"],
            typeSpeed: 200,
            backDelay: 500,
            loop: false,
            contentType: 'html',
            loopCount: false,
            callback: function() {
                $('h1 .typed-cursor').css('-webkit-animation', 'none').animate({opacity: 0}, 400);
                $("#404-txt").typed({
                    strings: ["Sorry! You don't have permission to access this page."],
                    typeSpeed: 1,
                    backDelay: 500,
                    loop: false,
                    contentType: 'html',
                    loopCount: false,
                    callback: function() {
                        $('h3 .typed-cursor').css('-webkit-animation', 'none').animate({opacity: 0}, 400);
                        $("#404-txt-2").typed({
                            strings: ["Go back to login page or <a href='mailbox-send.html'>contact us</a> about the problem. "],
                            typeSpeed: 1,
                            backDelay: 500,
                            loop: false,
                            contentType: 'html',
                            loopCount: false,
                            callback: function() {
                                $('#content-404').delay(300).slideDown();
                            },
                        });
                    }
                });
            }
        });
    });
</script>
<script src="admin/layout2/js/layout.js"></script>
</body>
</html>