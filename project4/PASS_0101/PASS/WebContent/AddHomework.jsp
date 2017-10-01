<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" import="model.*"%>
<%@ page contentType="text/html; charset=UTF-8" import="DAO.*"%>
<%
  	User user=(User)session.getAttribute("role");
	Course course=(Course)session.getAttribute("course");;
	int role=user.getRole();
	String roleName="";
	if(role==1)roleName="老師";
	else if(role==2)roleName="TA";
	else if(role==3)roleName="學生";
	else if(role==4)roleName="管理者";
	System.out.println(course.getInfo());
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Bootstrap Material Admin by Bootstrapious.com</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="robots" content="all,follow">
    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
    <!-- Fontastic Custom icon font-->
    <link rel="stylesheet" href="css/fontastic.css">
    <!-- Font Awesome CSS-->
    <link rel="stylesheet" href="vendor/font-awesome/css/font-awesome.min.css">
    <!-- Google fonts - Poppins -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,700">
    <!-- theme stylesheet-->
    <link rel="stylesheet" href="css/style.violet.css" id="theme-stylesheet">
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet" href="css/custom.css">
    <!-- Favicon-->
    <link rel="shortcut icon" href="favicon.png">
    <!-- Tweaks for older IEs--><!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
  </head>
  <body>
    <div class="page home-page">
      <!-- Main Navbar-->
      <!-- Main Navbar-->
      <header class="header">
        <nav class="navbar">
          <!-- Search Box-->
          <div class="container-fluid">
            <div class="navbar-holder d-flex align-items-center justify-content-between">
              <!-- Navbar Header-->
              <div class="navbar-header">
                <!-- Navbar Brand --><a href="index.html" class="navbar-brand">
                  <div class="brand-text brand-big"><span>Programming Assignment Submission System</span><strong></strong></div>
                  <div class="brand-text brand-small"><strong>PASS</strong></div></a>
                <!-- Toggle Button--><a id="toggle-btn" href="#" class="menu-btn active"><span></span><span></span><span></span></a>
              </div>
              <!-- Navbar Menu -->
              <ul class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">
                <!-- Logout --> 
                <li class="nav-item"><a href="Login" class="nav-link logout">Logout<i class="fa fa-sign-out"></i></a></li>
              </ul>
            </div>
          </div>
        </nav>
      </header>
      <div class="page-content d-flex align-items-stretch">
        <!-- Side Navbar -->
        <nav class="side-navbar"> <!--最左邊那一排-->
        <!-- Sidebar Header-->
          <div class="sidebar-header d-flex align-items-center">
            <div class="avatar"><img src="img/S.png" alt="..." class="img-fluid rounded-circle"></div>
            <div class="title">
              <h1 class="h4"><%=user.getName()%></h1>
              <p><%=roleName%></p>
            </div>
          </div>
          <!-- Sidebar Navidation Menus-->
          <span class="heading">Main</span>
          <ul class="list-unstyled">
            <li> <a href="HomePage"><i class="icon-home"></i>Home</a></li>
            <li class="active"><a href="Information"> <i class="icon-grid"></i>帳號資訊 </a></li>
            <li> <a href="T_Homework"> <i class="icon-grid"></i>作業管理 </a></li>
          </ul>
        </nav> <!--最左邊那一排-->
        <div class="content-inner">
          <!-- Page Header-->
          <header class="page-header">
            <div class="container-fluid">
              <h2 class="no-margin-bottom">home</h2>
            </div>
          </header>
         <section class="forms">
         	<div class="container-fluid">
         		<div class="row">
         			<!-- Basic Form-->
                    <div class="col-lg-6">
                    	<div class="card">
                            <div class="card-header d-flex align-items-center">
                            	<h3 class="h4">作業列表</h3>
                            </div>
                            <form id="login-form" action = AddHomework method=POST>
                            	<div class="card-body">
                            	<table style="width:100%">
                            		<!-- <tr>
                            			<th>作業名稱</th>
                            			<td>
                                        	<input type="text" id="homeworkname">
                                        </td>
                                    </tr>-->
                                    <tr>
                                    	<td>繳交期限</td>
                                    	<td>
                                          	<input type="text" name="dateline">
                                        </td>
                                    </tr>
                                    <tr>
                                    	<td>作業內容</td>
                                    	<td>
                                          	<input type="text" name="homeworkcontent">
                                        </td>
                                    </tr>
                                </table>
                                <input type="submit" id="Add" class="btn btn-primary" value=AddHomework>
                             </div>
                          </form>
                       </div>
                    </div>
                </div>
            </div>
          </section>
          <!-- Dashboard Header Section    -->
          <section class="dashboard-header">
            <div class="container-fluid">
              <div class="row">
              </div>
            </div>
          </section>
          <!-- Page Footer-->
        </div>
      </div>
      <footer class="main-footer">
        <div class="container-fluid">
          <div class="row">
            <div class="col-sm-6">
              <p>Your company &copy; 2017-2019</p>
            </div>
            <div class="col-sm-6 text-right">
              <p>Design by <a href="https://bootstrapious.com/admin-templates" class="external">Bootstrapious</a></p>
               <!-- Please do not remove the backlink to us unless you support further theme's development at https://bootstrapious.com/donate. It is part of the license conditions. Thank you for understanding :)-->
            </div>
          </div>
        </div>
      </footer>
    </div>
    <!-- Javascript files-->
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="vendor/popper.js/umd/popper.min.js"> </script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="vendor/jquery.cookie/jquery.cookie.js"> </script>
    <script src="vendor/jquery-validation/jquery.validate.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
    <script src="js/charts-home.js"></script>
    <script src="js/front.js"></script>
  </body>
</html>