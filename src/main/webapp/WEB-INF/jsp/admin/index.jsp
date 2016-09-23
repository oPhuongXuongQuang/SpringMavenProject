<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<!doctype html>
<html class="no-js" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8">
    <meta name="csrf-token" content="${ _csrf.token }">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="admin-themes-lab">
    <meta name="author" content="themes-lab">
    <link rel="shortcut icon" href="global/images/favicon.png" type="image/png">
    <title>Make | Admin Template</title>
    <link href="global/css/style.css" rel="stylesheet">
    <link href="global/css/theme.css" rel="stylesheet">
    <link href="global/css/ui.css" rel="stylesheet">
    <link href="global/plugins/metrojs/metrojs.min.css" rel="stylesheet">
    <link href="global/plugins/maps-amcharts/ammap/ammap.min.css" rel="stylesheet">
    <link href="global/plugins/slick/slick.css" rel="stylesheet">
    <link href="global/plugins/icheck/skins/all.css" rel="stylesheet">
    <link href="global/plugins/bootstrap-tags-input/bootstrap-tagsinput.css" rel="stylesheet" />
    <link href="global/plugins/bootstrap-datepicker/css/bootstrap-datepicker.css" rel="stylesheet" />
    <link href="global/plugins/rateit/rateit.css" rel="stylesheet" />
    <link href="global/plugins/colorpicker/spectrum.css" rel="stylesheet" />
    <link href="global/plugins/step-form-wizard/css/step-form-wizard.css" rel="stylesheet" />
    <link href="global/plugins/step-form-wizard/plugins/parsley/parsley.css" rel="stylesheet" />
    <link href="global/plugins/ion-slider/ion.rangeSlider.css" rel="stylesheet" />
    <link href="global/plugins/ion-slider/style.css" rel="stylesheet" />
    <link href="global/plugins/bootstrap-loading/lada.min.css" rel="stylesheet" />
    <link href="global/plugins/cke-editor/skins/bootstrapck/editor.css" rel="stylesheet" />
    <link href="global/plugins/summernote/summernote.css" rel="stylesheet" />
    <link href="global/plugins/cropper/cropper.css" rel="stylesheet" />
    <link href="global/plugins/magnific/magnific-popup.css" rel="stylesheet" />
    <link href="global/plugins/hover-effects/hover-effects.min.css" rel="stylesheet">
    <link href="global/plugins/fullcalendar/fullcalendar.min.css" rel="stylesheet" />
    <link href="global/plugins/prettify/prettify.css" rel="stylesheet" />
    <link href="global/plugins/jstree/dist/themes/default/style.css" rel="stylesheet" />
    <link href="global/plugins/datatables/dataTables.min.css" rel="stylesheet" />
    <link href="global/plugins/dropzone/dropzone.min.css" rel="stylesheet" />
    <link href="global/plugins/input-text/style.min.css" rel="stylesheet" />
    <link href="global/plugins/font-awesome-animation/font-awesome-animation.min.css" rel="stylesheet" />
    <!-- BEGIN ANGULARJS STYLE -->
    <link href="css/angular-theme.css" rel="stylesheet">
    <!-- END ANGULARJS STYLE -->
    <!-- BEGIN LAYOUT STYLE -->
    <link href="admin/layout2/css/layout.css" rel="stylesheet">
    <!-- END LAYOUT STYLE -->
    <script src="global/plugins/modernizr/modernizr-2.6.2-respond-1.1.0.min.js"></script>
</head>
<body ng-app="newApp" class="sidebar-condensed fixed-topbar fixed-sidebar theme-sdtl color-default" ng-controller="mainCtrl">
<!--[if lt IE 7]>
<p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->

<!-- BEGIN PAGE SPINNER -->
<div ng-spinner-loader class="page-spinner-loader">
    <div class="bounce1"></div>
    <div class="bounce2"></div>
    <div class="bounce3"></div>
</div>
<!-- END PAGE SPINNER -->
<section>
    <!-- BEGIN SIDEBAR -->
    <div class="sidebar">
        <div class="logopanel">
            <h1>
                <a href="#/"></a>
            </h1>
        </div>
        <div class="sidebar-inner">
            <div class="sidebar-top big-img">
                <div class="user-image">
                    <img src="global/images/profil_page/friend8.jpg" class="img-responsive img-circle" alt="friend 8">
                </div>
                <h4>${USER}</h4>
                <div class="dropdown user-login">
                    <button class="btn btn-xs dropdown-toggle btn-rounded" type="button" data-toggle="dropdown" data-hover="dropdown" data-close-others="true" data-delay="300">
                        <i class="online"></i><span>Available</span> <i class="fa fa-angle-down"></i>
                    </button>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#"><i class="busy"></i><span>Busy</span></a>
                        </li>
                        <li>
                            <a href="#"><i class="turquoise"></i>
                                <span>Invisible</span></a>
                        </li>
                        <li>
                            <a href="#"><i class="away"></i>
                                <span>Away</span></a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="menu-title">
                Navigation
                <div class="pull-right menu-settings">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true" data-delay="300">
                        <i class="icon-settings"></i>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#" id="reorder-menu" class="reorder-menu">Reorder menu</a></li>
                        <li><a href="#" id="remove-menu" class="remove-menu">Remove elements</a></li>
                        <li><a href="#" id="hide-top-sidebar" class="hide-top-sidebar">Hide user &amp; search</a></li>
                    </ul>
                </div>
            </div>
            <ul class="nav nav-sidebar">
                <li class="nav-parent">
                    <a href=""><i class="icon-home"></i><span>Home</span><span class="fa arrow"></span></a>
                    <ul class="children collapse">
                        <li ng-class="{ active  : isActive('/tables-editable')}"><a href="#product"> Product Management</a></li>
                        <li ng-class="{ active  : isActive('/tables-editable')}"><a href="#category"> Category Management</a></li>
                        <li ng-class="{ active  : isActive('/tables-editable')}"><a href="#staff"> Staff Management</a></li>
                        <li ng-class="{ active  : isActive('/tables-editable')}"><a href="#news"> News Management</a></li>
                    </ul>
                </li>
            </ul>
            <!-- SIDEBAR WIDGET -->
            <div class="sidebar-footer clearfix">
                <a class="pull-left footer-settings" href="#" data-rel="tooltip" data-placement="top" data-original-title="Settings">
                    <i class="icon-settings"></i>
                </a>
                <a class="pull-left toggle_fullscreen" href="#" data-rel="tooltip" data-placement="top" data-original-title="Fullscreen">
                    <i class="icon-size-fullscreen"></i>
                </a>
                <a class="pull-left" href="#" data-rel="tooltip" data-placement="top" data-original-title="Lockscreen">
                    <i class="icon-lock"></i>
                </a>
                <a class="pull-left btn-effect" href="/logout" data-modal="modal-1" data-rel="tooltip" data-placement="top" data-original-title="Logout">
                    <i class="icon-power"></i>
                </a>
            </div>
        </div>
    </div>
    <!-- END SIDEBAR -->
    <div class="main-content">
        <!-- BEGIN TOPBAR -->
        <div class="topbar">
            <div class="header-left">
                <div class="topnav">
                    <a class="menutoggle" href="#" data-toggle="sidebar-collapsed"><span class="menu__handle"><span>Menu</span></span></a>
                    <ul class="nav nav-icons">
                        <li><a href="#" class="toggle-sidebar-top"><span class="icon-user-following"></span></a></li>
                        <%--<li><a href="mailbox.html"><span class="octicon octicon-mail-read"></span></a></li>--%>
                        <%--<li><a href="#"><span class="octicon octicon-flame"></span></a></li>--%>
                        <%--<li><a href="builder-page.html"><span class="octicon octicon-rocket"></span></a></li>--%>
                    </ul>
                </div>
            </div>
            <div class="header-right">
                <ul class="header-menu nav navbar-nav">
                    <!-- BEGIN USER DROPDOWN -->
                    <li class="dropdown" id="user-header">
                        <a href="#" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
                            <img src="global/images/avatars/user1.png" alt="user image">
                            <span class="username">Hi, ${USER}</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li>
                                <a data-target="#"><i class="icon-user"></i><span>My Profile</span></a>
                            </li>
                            <li>
                                <a data-target="#"><i class="icon-calendar"></i><span>My Calendar</span></a>
                            </li>
                            <li>
                                <a data-target="#"><i class="icon-settings"></i><span>Account Settings</span></a>
                            </li>
                            <li>
                                <a href="/logout"><i class="icon-logout"></i><span>Logout</span></a>
                            </li>
                        </ul>
                    </li>
                    <!-- END USER DROPDOWN -->
                    <!-- CHAT BAR ICON -->
                    <li id="quickview-toggle"><a href="#"><i class="icon-bubbles"></i></a></li>
                </ul>
            </div>
            <!-- header-right -->
        </div>
        <!-- END TOPBAR -->
        <!-- BEGIN PAGE CONTENT -->
        <div ng-view class="at-view-slide-in-left page-content" ng-view-class=" page-wizard : /forms-wizard , page-thin : / , page-contact : /pages-contact,
                    page-profil : /user-profile, page-app : /user-profile" >
        </div>
        <!-- END PAGE CONTENT -->
    </div>
    <!-- END MAIN CONTENT -->
    <!-- BEGIN BUILDER -->
    <div class="builder hidden-sm hidden-xs" id="builder">
        <a class="builder-toggle"><i class="icon-wrench"></i></a>
        <div class="inner">
            <div class="builder-container">
                <a href="#" class="btn btn-sm btn-default" id="reset-style">reset default style</a>
                <h4>Layout options</h4>
                <div class="layout-option">
                    <span> Fixed Sidebar</span>
                    <label class="switch pull-right">
                        <input data-layout="sidebar" id="switch-sidebar" type="checkbox" class="switch-input" checked>
                        <span class="switch-label" data-on="On" data-off="Off"></span>
                        <span class="switch-handle"></span>
                    </label>
                </div>
                <div class="layout-option">
                    <span> Sidebar on Hover</span>
                    <label class="switch pull-right">
                        <input data-layout="sidebar-hover" id="switch-sidebar-hover" type="checkbox" class="switch-input">
                        <span class="switch-label" data-on="On" data-off="Off"></span>
                        <span class="switch-handle"></span>
                    </label>
                </div>
                <div class="layout-option">
                    <span> Submenu on Hover</span>
                    <label class="switch pull-right">
                        <input data-layout="submenu-hover" id="switch-submenu-hover" type="checkbox" class="switch-input">
                        <span class="switch-label" data-on="On" data-off="Off"></span>
                        <span class="switch-handle"></span>
                    </label>
                </div>
                <div class="layout-option">
                    <span>Fixed Topbar</span>
                    <label class="switch pull-right">
                        <input data-layout="topbar" id="switch-topbar" type="checkbox" class="switch-input" checked>
                        <span class="switch-label" data-on="On" data-off="Off"></span>
                        <span class="switch-handle"></span>
                    </label>
                </div>
                <div class="layout-option">
                    <span>Boxed Layout</span>
                    <label class="switch pull-right">
                        <input data-layout="boxed" id="switch-boxed" type="checkbox" class="switch-input">
                        <span class="switch-label" data-on="On" data-off="Off"></span>
                        <span class="switch-handle"></span>
                    </label>
                </div>
                <h4 class="border-top">Color</h4>
                <div class="row">
                    <div class="col-xs-12">
                        <div class="theme-color bg-dark" data-main="default" data-color="#2B2E33"></div>
                        <div class="theme-color background-primary" data-main="primary" data-color="#319DB5"></div>
                        <div class="theme-color bg-red" data-main="red" data-color="#C75757"></div>
                        <div class="theme-color bg-green" data-main="green" data-color="#1DA079"></div>
                        <div class="theme-color bg-orange" data-main="orange" data-color="#D28857"></div>
                        <div class="theme-color bg-purple" data-main="purple" data-color="#B179D7"></div>
                        <div class="theme-color bg-blue" data-main="blue" data-color="#4A89DC"></div>
                    </div>
                </div>
                <h4 class="border-top">Theme</h4>
                <div class="row row-sm">
                    <div class="col-xs-6">
                        <div class="theme clearfix sdtl" data-theme="sdtl">
                            <div class="header theme-left"></div>
                            <div class="header theme-right-light"></div>
                            <div class="theme-sidebar-dark"></div>
                            <div class="bg-light"></div>
                        </div>
                    </div>
                    <div class="col-xs-6">
                        <div class="theme clearfix sltd" data-theme="sltd">
                            <div class="header theme-left"></div>
                            <div class="header theme-right-dark"></div>
                            <div class="theme-sidebar-light"></div>
                            <div class="bg-light"></div>
                        </div>
                    </div>
                    <div class="col-xs-6">
                        <div class="theme clearfix sdtd" data-theme="sdtd">
                            <div class="header theme-left"></div>
                            <div class="header theme-right-dark"></div>
                            <div class="theme-sidebar-dark"></div>
                            <div class="bg-light"></div>
                        </div>
                    </div>
                    <div class="col-xs-6">
                        <div class="theme clearfix sltl" data-theme="sltl">
                            <div class="header theme-left"></div>
                            <div class="header theme-right-light"></div>
                            <div class="theme-sidebar-light"></div>
                            <div class="bg-light"></div>
                        </div>
                    </div>
                </div>
                <h4 class="border-top">Background</h4>
                <div class="row">
                    <div class="col-xs-12">
                        <div class="bg-color bg-clean" data-bg="clean" data-color="#F8F8F8"></div>
                        <div class="bg-color bg-lighter" data-bg="lighter" data-color="#EFEFEF"></div>
                        <div class="bg-color bg-light-default" data-bg="light-default" data-color="#E9E9E9"></div>
                        <div class="bg-color bg-light-blue" data-bg="light-blue" data-color="#E2EBEF"></div>
                        <div class="bg-color bg-light-purple" data-bg="light-purple" data-color="#E9ECF5"></div>
                        <div class="bg-color bg-light-dark" data-bg="light-dark" data-color="#DCE1E4"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- END BUILDER -->
</section>
<!-- BEGIN QUICKVIEW SIDEBAR -->
<div id="quickview-sidebar">
    <div class="quickview-header">
        <ul class="nav nav-tabs">
            <li class="active"><a href="#chat" data-toggle="tab">Chat</a></li>
            <li><a href="#notes" data-toggle="tab">Notes</a></li>
            <li><a href="#settings" data-toggle="tab" class="settings-tab">Settings</a></li>
        </ul>
    </div>
    <div class="quickview">
        <div class="tab-content">
            <div class="tab-pane fade active in" id="chat">
                <div class="chat-body current">
                    <div class="chat-search">
                        <form class="form-inverse" action="#" role="search">
                            <div class="append-icon">
                                <input type="text" class="form-control" placeholder="Search contact...">
                                <i class="icon-magnifier"></i>
                            </div>
                        </form>
                    </div>
                    <div class="chat-groups">
                        <div class="title">GROUP CHATS</div>
                        <ul>
                            <li><i class="turquoise"></i> Favorites</li>
                            <li><i class="turquoise"></i> Office Work</li>
                            <li><i class="turquoise"></i> Friends</li>
                        </ul>
                    </div>
                    <div class="chat-list">
                        <div class="title">FAVORITES</div>
                        <ul>
                            <li class="clearfix">
                                <div class="user-img">
                                    <img src="global/images/avatars/avatar13.png" alt="avatar" />
                                </div>
                                <div class="user-details">
                                    <div class="user-name">Bobby Brown</div>
                                    <div class="user-txt">On the road again...</div>
                                </div>
                                <div class="user-status">
                                    <i class="online"></i>
                                </div>
                            </li>
                            <li class="clearfix">
                                <div class="user-img">
                                    <img src="global/images/avatars/avatar5.png" alt="avatar" />
                                    <div class="pull-right badge badge-danger">3</div>
                                </div>
                                <div class="user-details">
                                    <div class="user-name">Alexa Johnson</div>
                                    <div class="user-txt">Still at the beach</div>
                                </div>
                                <div class="user-status">
                                    <i class="away"></i>
                                </div>
                            </li>
                            <li class="clearfix">
                                <div class="user-img">
                                    <img src="global/images/avatars/avatar10.png" alt="avatar" />
                                </div>
                                <div class="user-details">
                                    <div class="user-name">Bobby Brown</div>
                                    <div class="user-txt">On stage...</div>
                                </div>
                                <div class="user-status">
                                    <i class="busy"></i>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div class="chat-list">
                        <div class="title">FRIENDS</div>
                        <ul>
                            <li class="clearfix">
                                <div class="user-img">
                                    <img src="global/images/avatars/avatar7.png" alt="avatar" />
                                    <div class="pull-right badge badge-danger">3</div>
                                </div>
                                <div class="user-details">
                                    <div class="user-name">James Miller</div>
                                    <div class="user-txt">At work...</div>
                                </div>
                                <div class="user-status">
                                    <i class="online"></i>
                                </div>
                            </li>
                            <li class="clearfix">
                                <div class="user-img">
                                    <img src="global/images/avatars/avatar11.png" alt="avatar" />
                                </div>
                                <div class="user-details">
                                    <div class="user-name">Fred Smith</div>
                                    <div class="user-txt">Waiting for tonight</div>
                                </div>
                                <div class="user-status">
                                    <i class="offline"></i>
                                </div>
                            </li>
                            <li class="clearfix">
                                <div class="user-img">
                                    <img src="global/images/avatars/avatar8.png" alt="avatar" />
                                </div>
                                <div class="user-details">
                                    <div class="user-name">Ben Addams</div>
                                    <div class="user-txt">On my way to NYC</div>
                                </div>
                                <div class="user-status">
                                    <i class="offline"></i>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="chat-conversation">
                    <div class="conversation-header">
                        <div class="user clearfix">
                            <div class="chat-back">
                                <i class="icon-action-undo"></i>
                            </div>
                            <div class="user-details">
                                <div class="user-name">James Miller</div>
                                <div class="user-txt">On the road again...</div>
                            </div>
                        </div>
                    </div>
                    <div class="conversation-body">
                        <ul>
                            <li class="img">
                                <div class="chat-detail">
                                    <span class="chat-date">today, 10:38pm</span>
                                    <div class="conversation-img">
                                        <img src="global/images/avatars/avatar4.png" alt="avatar 4" />
                                    </div>
                                    <div class="chat-bubble">
                                        <span>Hi you!</span>
                                    </div>
                                </div>
                            </li>
                            <li class="img">
                                <div class="chat-detail">
                                    <span class="chat-date">today, 10:45pm</span>
                                    <div class="conversation-img">
                                        <img src="global/images/avatars/avatar4.png" alt="avatar 4" />
                                    </div>
                                    <div class="chat-bubble">
                                        <span>Are you there?</span>
                                    </div>
                                </div>
                            </li>
                            <li class="img">
                                <div class="chat-detail">
                                    <span class="chat-date">today, 10:51pm</span>
                                    <div class="conversation-img">
                                        <img src="global/images/avatars/avatar4.png" alt="avatar 4" />
                                    </div>
                                    <div class="chat-bubble">
                                        <span>Send me a message when you come back.</span>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div class="conversation-message">
                        <input type="text" placeholder="Your message..." class="form-control form-white send-message" />
                        <div class="item-footer clearfix">
                            <div class="footer-actions">
                                <i class="icon-rounded-marker"></i>
                                <i class="icon-rounded-camera"></i>
                                <i class="icon-rounded-paperclip-oblique"></i>
                                <i class="icon-rounded-alarm-clock"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="tab-pane fade" id="notes">
                <div class="list-notes current withScroll">
                    <div class="notes ">
                        <div class="row">
                            <div class="col-md-12">
                                <div id="add-note">
                                    <i class="fa fa-plus"></i>ADD A NEW NOTE
                                </div>
                            </div>
                        </div>
                        <div id="notes-list">
                            <div class="note-item media current fade in">
                                <button class="close">×</button>
                                <div>
                                    <div>
                                        <p class="note-name">Reset my account password</p>
                                    </div>
                                    <p class="note-desc hidden">Break security reasons.</p>
                                    <p><small>Tuesday 6 May, 3:52 pm</small></p>
                                </div>
                            </div>
                            <div class="note-item media fade in">
                                <button class="close">×</button>
                                <div>
                                    <div>
                                        <p class="note-name">Call John</p>
                                    </div>
                                    <p class="note-desc hidden">He have my laptop!</p>
                                    <p><small>Thursday 8 May, 2:28 pm</small></p>
                                </div>
                            </div>
                            <div class="note-item media fade in">
                                <button class="close">×</button>
                                <div>
                                    <div>
                                        <p class="note-name">Buy a car</p>
                                    </div>
                                    <p class="note-desc hidden">I'm done with the bus</p>
                                    <p><small>Monday 12 May, 3:43 am</small></p>
                                </div>
                            </div>
                            <div class="note-item media fade in">
                                <button class="close">×</button>
                                <div>
                                    <div>
                                        <p class="note-name">Don't forget my notes</p>
                                    </div>
                                    <p class="note-desc hidden">I have to read them...</p>
                                    <p><small>Wednesday 5 May, 6:15 pm</small></p>
                                </div>
                            </div>
                            <div class="note-item media current fade in">
                                <button class="close">×</button>
                                <div>
                                    <div>
                                        <p class="note-name">Reset my account password</p>
                                    </div>
                                    <p class="note-desc hidden">Break security reasons.</p>
                                    <p><small>Tuesday 6 May, 3:52 pm</small></p>
                                </div>
                            </div>
                            <div class="note-item media fade in">
                                <button class="close">×</button>
                                <div>
                                    <div>
                                        <p class="note-name">Call John</p>
                                    </div>
                                    <p class="note-desc hidden">He have my laptop!</p>
                                    <p><small>Thursday 8 May, 2:28 pm</small></p>
                                </div>
                            </div>
                            <div class="note-item media fade in">
                                <button class="close">×</button>
                                <div>
                                    <div>
                                        <p class="note-name">Buy a car</p>
                                    </div>
                                    <p class="note-desc hidden">I'm done with the bus</p>
                                    <p><small>Monday 12 May, 3:43 am</small></p>
                                </div>
                            </div>
                            <div class="note-item media fade in">
                                <button class="close">×</button>
                                <div>
                                    <div>
                                        <p class="note-name">Don't forget my notes</p>
                                    </div>
                                    <p class="note-desc hidden">I have to read them...</p>
                                    <p><small>Wednesday 5 May, 6:15 pm</small></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="detail-note note-hidden-sm">
                    <div class="note-header clearfix">
                        <div class="note-back">
                            <i class="icon-action-undo"></i>
                        </div>
                        <div class="note-edit">Edit Note</div>
                        <div class="note-subtitle">title on first line</div>
                    </div>
                    <div id="note-detail">
                        <div class="note-write">
                            <textarea class="form-control" placeholder="Type your note here"></textarea>
                        </div>
                    </div>
                </div>
            </div>
            <div class="tab-pane fade" id="settings">
                <div class="settings">
                    <div class="title">ACCOUNT SETTINGS</div>
                    <div class="setting">
                        <span> Show Personal Statut</span>
                        <label class="switch pull-right">
                            <input type="checkbox" class="switch-input" checked>
                            <span class="switch-label" data-on="On" data-off="Off"></span>
                            <span class="switch-handle"></span>
                        </label>
                        <p class="setting-info">Lorem ipsum dolor sit amet consectetuer.</p>
                    </div>
                    <div class="setting">
                        <span> Show my Picture</span>
                        <label class="switch pull-right">
                            <input type="checkbox" class="switch-input" checked>
                            <span class="switch-label" data-on="On" data-off="Off"></span>
                            <span class="switch-handle"></span>
                        </label>
                        <p class="setting-info">Lorem ipsum dolor sit amet consectetuer.</p>
                    </div>
                    <div class="setting">
                        <span> Show my Location</span>
                        <label class="switch pull-right">
                            <input type="checkbox" class="switch-input">
                            <span class="switch-label" data-on="On" data-off="Off"></span>
                            <span class="switch-handle"></span>
                        </label>
                        <p class="setting-info">Lorem ipsum dolor sit amet consectetuer.</p>
                    </div>
                    <div class="title">CHAT</div>
                    <div class="setting">
                        <span> Show User Image</span>
                        <label class="switch pull-right">
                            <input type="checkbox" class="switch-input" checked>
                            <span class="switch-label" data-on="On" data-off="Off"></span>
                            <span class="switch-handle"></span>
                        </label>
                    </div>
                    <div class="setting">
                        <span> Show Fullname</span>
                        <label class="switch pull-right">
                            <input type="checkbox" class="switch-input" checked>
                            <span class="switch-label" data-on="On" data-off="Off"></span>
                            <span class="switch-handle"></span>
                        </label>
                    </div>
                    <div class="setting">
                        <span> Show Location</span>
                        <label class="switch pull-right">
                            <input type="checkbox" class="switch-input">
                            <span class="switch-label" data-on="On" data-off="Off"></span>
                            <span class="switch-handle"></span>
                        </label>
                    </div>
                    <div class="setting">
                        <span> Show Unread Count</span>
                        <label class="switch pull-right">
                            <input type="checkbox" class="switch-input" checked>
                            <span class="switch-label" data-on="On" data-off="Off"></span>
                            <span class="switch-handle"></span>
                        </label>
                    </div>
                    <div class="title">STATISTICS</div>
                    <div class="settings-chart">
                        <div class="clearfix">
                            <div class="chart-title">Stat 1</div>
                            <div class="chart-number">82%</div>
                        </div>
                        <div class="progress">
                            <div class="progress-bar progress-bar-primary setting1" data-transitiongoal="82"></div>
                        </div>
                    </div>
                    <div class="settings-chart">
                        <div class="clearfix">
                            <div class="chart-title">Stat 2</div>
                            <div class="chart-number">43%</div>
                        </div>
                        <div class="progress">
                            <div class="progress-bar progress-bar-primary setting2" data-transitiongoal="43"></div>
                        </div>
                    </div>
                    <div class="m-t-30" style="width:100%">
                        <canvas id="setting-chart" height="300"></canvas>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- END QUICKVIEW SIDEBAR -->
<!-- BEGIN SEARCH -->
<div id="morphsearch" class="morphsearch">
    <form class="morphsearch-form">
        <input class="morphsearch-input" type="search" placeholder="Search..." />
        <button class="morphsearch-submit" type="submit">Search</button>
    </form>
    <div class="morphsearch-content withScroll">
        <div class="dummy-column user-column">
            <h2>Users</h2>
            <a class="dummy-media-object" href="#">
                <img src="global/images/avatars/avatar1_big.png" alt="Avatar 1" />
                <h3>John Smith</h3>
            </a>
            <a class="dummy-media-object" href="#">
                <img src="global/images/avatars/avatar2_big.png" alt="Avatar 2" />
                <h3>Bod Dylan</h3>
            </a>
            <a class="dummy-media-object" href="#">
                <img src="global/images/avatars/avatar3_big.png" alt="Avatar 3" />
                <h3>Jenny Finlan</h3>
            </a>
            <a class="dummy-media-object" href="#">
                <img src="global/images/avatars/avatar4_big.png" alt="Avatar 4" />
                <h3>Harold Fox</h3>
            </a>
            <a class="dummy-media-object" href="#">
                <img src="global/images/avatars/avatar5_big.png" alt="Avatar 5" />
                <h3>Martin Hendrix</h3>
            </a>
            <a class="dummy-media-object" href="#">
                <img src="global/images/avatars/avatar6_big.png" alt="Avatar 6" />
                <h3>Paul Ferguson</h3>
            </a>
        </div>
        <div class="dummy-column">
            <h2>Articles</h2>
            <a class="dummy-media-object" href="#">
                <img src="global/images/gallery/1.jpg" alt="1" />
                <h3>How to change webdesign?</h3>
            </a>
            <a class="dummy-media-object" href="#">
                <img src="global/images/gallery/2.jpg" alt="2" />
                <h3>News From the sky</h3>
            </a>
            <a class="dummy-media-object" href="#">
                <img src="global/images/gallery/3.jpg" alt="3" />
                <h3>Where is the cat?</h3>
            </a>
            <a class="dummy-media-object" href="#">
                <img src="global/images/gallery/4.jpg" alt="4" />
                <h3>Just another funny story</h3>
            </a>
            <a class="dummy-media-object" href="#">
                <img src="global/images/gallery/5.jpg" alt="5" />
                <h3>How many water we drink every day?</h3>
            </a>
            <a class="dummy-media-object" href="#">
                <img src="global/images/gallery/6.jpg" alt="6" />
                <h3>Drag and drop tutorials</h3>
            </a>
        </div>
        <div class="dummy-column">
            <h2>Recent</h2>
            <a class="dummy-media-object" href="#">
                <img src="global/images/gallery/7.jpg" alt="7" />
                <h3>Design Inspiration</h3>
            </a>
            <a class="dummy-media-object" href="#">
                <img src="global/images/gallery/8.jpg" alt="8" />
                <h3>Animals drawing</h3>
            </a>
            <a class="dummy-media-object" href="#">
                <img src="global/images/gallery/9.jpg" alt="9" />
                <h3>Cup of tea please</h3>
            </a>
            <a class="dummy-media-object" href="#">
                <img src="global/images/gallery/10.jpg" alt="10" />
                <h3>New application arrive</h3>
            </a>
            <a class="dummy-media-object" href="#">
                <img src="global/images/gallery/11.jpg" alt="11" />
                <h3>Notification prettify</h3>
            </a>
            <a class="dummy-media-object" href="#">
                <img src="global/images/gallery/12.jpg" alt="12" />
                <h3>My article is the last recent</h3>
            </a>
        </div>
    </div>
    <!-- /morphsearch-content -->
    <span class="morphsearch-close"></span>
</div>
<!-- END SEARCH -->
<!-- BEGIN PRELOADER -->
<div class="loader-overlay">
    <div class="spinner">
        <div class="bounce1"></div>
        <div class="bounce2"></div>
        <div class="bounce3"></div>
    </div>
</div>
<!-- BEGIN ANGULARJS SCRIPTS -->
<script src="plugins/angular/angular.js"></script>
<script src="plugins/json3/lib/json3.js"></script>
<script src="plugins/angular-resource/angular-resource.js"></script>
<script src="plugins/angular-cookies/angular-cookies.js"></script>
<script src="plugins/angular-sanitize/angular-sanitize.js"></script>
<script src="plugins/angular-animate/angular-animate.js"></script>
<script src="plugins/angular-touch/angular-touch.js"></script>
<script src="plugins/angular-route/angular-route.js"></script>
<script src="plugins/angular-bootstrap/ui-bootstrap-tpls-0.12.1.js"></script>
<script src="app.js"></script>
<script src="directives/ngViewClass.js"></script>
<!-- END ANGULARJS SCRIPTS -->
<script src="global/plugins/jquery/jquery-1.11.1.min.js"></script>
<script src="global/plugins/jquery/jquery-migrate-1.2.1.min.js"></script>
<script src="global/plugins/jquery-ui/jquery-ui-1.11.2.min.js"></script>
<script src="global/plugins/gsap/main-gsap.min.js"></script>
<script src="global/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="global/plugins/jquery-cookies/jquery.cookies.min.js"></script>
<script src="global/plugins/jquery-block-ui/jquery.blockUI.min.js"></script>
<script src="global/plugins/bootbox/bootbox.min.js"></script>
<script src="global/plugins/mcustom-scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
<script src="global/plugins/bootstrap-dropdown/bootstrap-hover-dropdown.min.js"></script>
<script src="global/plugins/charts-sparkline/sparkline.min.js"></script>
<script src="global/plugins/retina/retina.min.js"></script>
<script src="global/plugins/select2/select2.min.js"></script>
<script src="global/plugins/icheck/icheck.min.js"></script>
<script src="global/plugins/backstretch/backstretch.min.js"></script>
<script src="global/plugins/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
<script src="global/js/sidebar_hover.js"></script>
<script src="global/js/widgets/notes.js"></script>
<script src="global/js/pages/search.js"></script>
<%--<script src="global/plugins/quickSearch/quicksearch.js"></script>--%>
<script src="global/plugins/slick/slick.js"></script>
<script src="global/plugins/icheck/icheck.js"></script>
<script src="global/plugins/switchery/switchery.js"></script>
<script src="global/plugins/timepicker/jquery-ui-timepicker-addon.js"></script>
<script src="global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
<script src="global/plugins/colorpicker/spectrum.js"></script>
<script src="global/plugins/touchspin/jquery.bootstrap-touchspin.js"></script>
<script src="global/plugins/step-form-wizard/js/step-form-wizard.js"></script>
<script src="global/plugins/step-form-wizard/plugins/parsley/parsley.min.js"></script>
<script src="global/plugins/jquery-validation/jquery.validate.js"></script>
<script src="global/plugins/bootstrap-slider/bootstrap-slider.js"></script>
<script src="global/plugins/ion-slider/ion.rangeSlider.js"></script>
<script src="global/plugins/bootstrap/js/jasny-bootstrap.js"></script>
<script src="global/plugins/isotope/isotope.pkgd.min.js"></script>
<script src="global/plugins/magnific/jquery.magnific-popup.js"></script>
<script src="global/plugins/moment/moment.min.js"></script>
<script src="global/plugins/fullcalendar/fullcalendar.min.js"></script>
<script src="global/plugins/countup/countUp.js"></script>
<script src="http://maps.google.com/maps/api/js?sensor=true"></script>
<script src="global/plugins/google-maps/gmaps.js"></script>
<script src="global/plugins/google-maps/markerclusterer.js"></script>
<script src="global/plugins/maps-amcharts/ammap/ammap.min.js"></script>
<script src="global/plugins/maps-amcharts/ammap/maps/js/worldLow.min.js"></script>
<script src="global/plugins/maps-amcharts/ammap/themes/black.min.js"></script>
<script src="global/plugins/maps-amcharts/ammap/ammap_amcharts_extension.js"></script>
<script src="global/plugins/maps-amcharts/ammap/maps/js/continentsLow.js"></script>
<script src="global/plugins/maps-amcharts/ammap/maps/js/worldLow.js"></script>
<script src="global/plugins/maps-amcharts/ammap/maps/js/usaLow.js"></script>
<script src="global/plugins/bootstrap-loading/lada.min.js"></script>
<script src="global/plugins/jstree/jstree.js"></script>
<script src="global/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="global/plugins/typed/typed.js"></script>
<script src="global/plugins/cke-editor/ckeditor.js"></script>
<script src="global/plugins/cke-editor/config.js"></script>
<script src="global/plugins/cke-editor/styles.js"></script>
<script src="global/plugins/cke-editor/adapters/adapters.min.js"></script>
<script src="global/plugins/cke-editor/lang/en.js"></script>
<script src="global/plugins/cke-editor/skins/bootstrapck/skin.js"></script>
<script src="global/plugins/summernote/summernote.js"></script>
<script src="global/plugins/prettify/prettify.js"></script>
<script src="global/plugins/dropzone/dropzone.min.js"></script>
<script src="global/plugins/idle-timeout/jquery.idletimeout.min.js"></script>
<script src="global/plugins/idle-timeout/jquery.idletimer.min.js"></script>
<script src="global/plugins/cropper/cropper.js"></script>
<script src="global/plugins/noty/jquery.noty.packaged.min.js"></script>
<script src="global/plugins/bootstrap-editable/js/bootstrap-editable.min.js"></script>
<script src="global/plugins/bootstrap-context-menu/bootstrap-contextmenu.min.js"></script>
<script src="global/plugins/multidatepicker/multidatespicker.min.js"></script>
<script src="global/js/widgets/todo_list.js"></script>
<script src="global/plugins/metrojs/metrojs.min.js"></script>
<script src="global/plugins/charts-chartjs/Chart.min.js"></script>
<script src="global/plugins/charts-highstock/js/highstock.min.js"></script>
<script src="global/plugins/charts-highstock/js/modules/exporting.min.js"></script>
<script src="global/plugins/skycons/skycons.min.js"></script>
<script src="global/plugins/simple-weather/jquery.simpleWeather.js"></script>
<script src="global/plugins/bootstrap-tags-input/bootstrap-tagsinput.js"></script>
<script src="global/plugins/rateit/jquery.rateit.min.js"></script>
<script src="global/plugins/charts-highstock/js/highcharts-more.min.js"></script>
<script src="global/plugins/charts-highstock/js/modules/exporting.min.js"></script>
<script src="global/plugins/autosize/autosize.min.js"></script>
<script src="global/js/widgets/widget_weather.js"></script>
<script src="global/js/pages/ecommerce.js"></script>
<!-- BEGIN CUSTOM ANGULARJS SCRIPTS -->
<script src="js/pages/dashboard.js"></script>
<script src="js/pages/charts.js"></script>
<script src="js/pages/charts_finance.js"></script>
<script src="js/pages/layouts_api.js"></script>
<script src="js/builder.js"></script>
<script src="js/application.js"></script>
<script src="js/plugins.js"></script>
<script src="js/quickview.js"></script>
<script src="dashboard/dashboardCtrl.js"></script>
<script src="charts/charts/chartsCtrl.js"></script>
<script src="charts/financialCharts/financialChartsCtrl.js"></script>
<script src="uiElements/tabs/tabsCtrl.js"></script>
<script src="uiElements/buttons/buttonsCtrl.js"></script>
<script src="uiElements/modals/modalsCtrl.js"></script>
<script src="uiElements/components/componentsCtrl.js"></script>
<script src="uiElements/animations/animationsCtrl.js"></script>
<script src="uiElements/icons/iconsCtrl.js"></script>
<script src="uiElements/portlets/portletsCtrl.js"></script>
<script src="uiElements/nestableList/nestableListCtrl.js"></script>
<script src="uiElements/treeView/treeViewCtrl.js"></script>
<script src="uiElements/notifications/notificationsCtrl.js"></script>
<script src="uiElements/typography/typographyCtrl.js"></script>
<script src="uiElements/helperClasses/helperClassesCtrl.js"></script>
<script src="mailbox/mailboxTemplatesCtrl.js"></script>
<script src="mailbox/mailboxCtrl.js"></script>
<script src="mailbox/mailSendCtrl.js"></script>
<script src="mainCtrl.js"></script>
<script src="medias/croping/cropingCtrl.js"></script>
<script src="medias/hover/hoverCtrl.js"></script>
<script src="medias/sortable/sortableCtrl.js"></script>
<script src="forms/editors/editorsCtrl.js"></script>
<script src="forms/elements/elementsCtrl.js"></script>
<script src="forms/inputMasks/inputMasksCtrl.js"></script>
<script src="forms/plugins/pluginsCtrl.js"></script>
<script src="forms/sliders/slidersCtrl.js"></script>
<script src="forms/validation/validationCtrl.js"></script>
<script src="forms/wizard/wizardCtrl.js"></script>
<script src="pages/timeline/timelineCtrl.js"></script>
<script src="pages/blank/blankCtrl.js"></script>
<script src="pages/contact/contactCtrl.js"></script>
<script src="extra/fullCalendar/fullCalendarCtrl.js"></script>
<script src="extra/widgets/widgetsCtrl.js"></script>
<script src="extra/slider/sliderCtrl.js"></script>
<script src="extra/google/googleCtrl.js"></script>
<script src="extra/vector/vectorCtrl.js"></script>
<script src="ecommerce/pricingTable/pricingTableCtrl.js"></script>
<script src="ecommerce/invoice/invoiceCtrl.js"></script>
<script src="ecommerce/cart/cartCtrl.js"></script>
<script src="layout/apiCtrl.js"></script>
<script src="tables/dynamic/dynamicCtrl.js"></script>
<script src="tables/editable/editableCtrl.js"></script>
<script src="tables/editable/categoryCtrl.js"></script>
<script src="tables/editable/staffCtrl.js"></script>
<script src="tables/editable/newsCtrl.js"></script>
<script src="tables/filter/filterCtrl.js"></script>
<script src="tables/styling/stylingCtrl.js"></script>
<script src="user/profile/profileCtrl.js"></script>
<script src="user/sessionTimeout/sessionTimeoutCtrl.js"></script>

<!-- END CUSTOM ANGULARJS SCRIPTS -->
</body>
</html>