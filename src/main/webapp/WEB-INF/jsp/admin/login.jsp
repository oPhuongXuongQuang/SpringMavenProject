<%--
  Created by IntelliJ IDEA.
  User: quangphuong
  Date: 9/20/16
  Time: 1:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8">
    <title>Themes Lab - Creative Laborator</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta content="" name="description" />
    <meta content="themes-lab" name="author" />
    <link rel="shortcut icon" href="global/images/favicon.png">
    <link href="global/css/style.css" rel="stylesheet">
    <link href="global/css/ui.css" rel="stylesheet">
    <link href="global/plugins/bootstrap-loading/lada.min.css" rel="stylesheet">
</head>
<body class="account separate-inputs" data-page="login">
<!-- BEGIN LOGIN BOX -->
<div class="container" id="login-block">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <div class="account-wall">
                <i class="user-img icons-faces-users-03"></i>
                <c:if test="${not empty error}">
                    <div class="alert alert-danger alert-dismissible" role="alert">
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <strong>Opppps!</strong> You have entered incorrect username or password. Please try again.
                    </div>
                </c:if>
                <c:if test="${not empty logout}">
                    <div class="alert alert-warning alert-dismissible" role="alert">
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            ${logout}
                    </div>
                </c:if>
                <form class="form-signin" name='loginForm' role="form" th:action="@{/login}" method='POST'>
                    <div class="append-icon">
                        <input type="text" name="username" class="form-control form-white username" placeholder="Username" required>
                        <i class="icon-user"></i>
                    </div>
                    <div class="append-icon m-b-20">
                        <input type="password" name="password" class="form-control form-white password" placeholder="Password" required>
                        <i class="icon-lock"></i>
                    </div>
                    <input type="submit" name="submit" id="submit-form" class="btn btn-lg btn-danger btn-block ladda-button" data-style="expand-left" value="Sign In"/>
                    <div class="social-btn">
                        <button type="button" class="btn-fb btn btn-lg btn-block btn-primary"><i class="icons-socialmedia-08 pull-left"></i>Connect with Facebook</button>
                        <button type="button" class="btn btn-lg btn-block btn-blue"><i class="icon-social-twitter pull-left"></i>Login with Twitter</button>
                    </div>
                    <div class="clearfix">
                        <p class="pull-left m-t-20"><a id="password" href="#">Forgot password?</a></p>
                        <p class="pull-right m-t-20"><a href="user-signup-v1.html">New here? Sign up</a></p>
                    </div>

                    <input type="hidden" name="${_csrf.parameterName}"
                           value="${_csrf.token}" />
                </form>
                <form class="form-password" role="form">
                    <div class="append-icon m-b-20">
                        <input type="password" name="password" class="form-control form-white password" placeholder="Password" required>
                        <i class="icon-lock"></i>
                    </div>
                    <button type="submit" id="submit-password" class="btn btn-lg btn-danger btn-block ladda-button" data-style="expand-left">Send Password Reset Link</button>
                    <div class="clearfix">
                        <p class="pull-left m-t-20"><a id="login" href="#">Already got an account? Sign In</a></p>
                        <p class="pull-right m-t-20"><a href="user-signup-v1.html">New here? Sign up</a></p>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <p class="account-copyright">
        <span>Copyright © 2015 </span><span>THEMES LAB</span>.<span>All rights reserved.</span>
    </p>
    <div id="account-builder">
        <form class="form-horizontal" role="form">
            <div class="row">
                <div class="col-md-12">
                    <i class="fa fa-spin fa-gear"></i>
                    <h3><strong>Customize</strong> Login Page</h3>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label class="col-xs-8 control-label">Social Login</label>
                        <div class="col-xs-4">
                            <label class="switch m-r-20">
                                <input id="social-cb" type="checkbox" class="switch-input" checked>
                                <span class="switch-label" data-on="On" data-off="Off"></span>
                                <span class="switch-handle"></span>
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-8 control-label">Boxed Form</label>
                        <div class="col-xs-4">
                            <label class="switch m-r-20">
                                <input id="boxed-cb" type="checkbox" class="switch-input">
                                <span class="switch-label" data-on="On" data-off="Off"></span>
                                <span class="switch-handle"></span>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label class="col-xs-8 control-label">Background Image</label>
                        <div class="col-xs-4">
                            <label class="switch m-r-20">
                                <input id="image-cb" type="checkbox" class="switch-input" checked>
                                <span class="switch-label" data-on="On" data-off="Off"></span>
                                <span class="switch-handle"></span>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label class="col-xs-8 control-label">Background Slides</label>
                        <div class="col-xs-4">
                            <label class="switch m-r-20">
                                <input id="slide-cb" type="checkbox" class="switch-input">
                                <span class="switch-label" data-on="On" data-off="Off"></span>
                                <span class="switch-handle"></span>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label class="col-xs-8 control-label">Separated Inputs</label>
                        <div class="col-xs-4">
                            <label class="switch m-r-20">
                                <input id="input-cb" type="checkbox" class="switch-input">
                                <span class="switch-label" data-on="On" data-off="Off"></span>
                                <span class="switch-handle"></span>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label class="col-xs-8 control-label">User Image</label>
                        <div class="col-xs-4">
                            <label class="switch m-r-20">
                                <input id="user-cb" type="checkbox" class="switch-input">
                                <span class="switch-label" data-on="On" data-off="Off"></span>
                                <span class="switch-handle"></span>
                            </label>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>

</div>
<script src="global/plugins/jquery/jquery-1.11.1.min.js"></script>
<script src="global/plugins/jquery/jquery-migrate-1.2.1.min.js"></script>
<script src="global/plugins/gsap/main-gsap.min.js"></script>
<script src="global/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="global/plugins/backstretch/backstretch.min.js"></script>
<script src="global/plugins/bootstrap-loading/lada.min.js"></script>
<script src="global/js/pages/login-v1.js"></script>
</body>
</html>
