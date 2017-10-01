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
	System.out.println("information name: " + user.getName());
	System.out.println("information account: " + user.getAccount());
	System.out.println("information password: " + user.getPassword());
	System.out.println("information email: " + user.getEmail());
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
  <link rel="stylesheet" href="css/style.default.css" id="theme-stylesheet">
  <!-- Custom stylesheet - for your changes-->
  <link rel="stylesheet" href="css/custom.css">
  <!-- Favicon-->
  <link rel="shortcut icon" href="favicon.png">
  <!-- Tweaks for older IEs--><!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
</head>
<body>
<div class="page charts-page">
  <!-- Main Navbar-->
  <header class="header"> <!--最上面那一排-->
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
            <li class="nav-item"><a href="" class="nav-link account">Account <i class="fa fa-user-circle"></i></a></li>
            <li class="nav-item"><a href="Login" class="nav-link logout">Logout<i class="fa fa-sign-out"></i></a></li>
          </ul>
        </div>
      </div>
    </nav>
  </header> <!--最上面那一排-->
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
    <div class="content-inner"> <!--table-->
      <!-- Page Header-->
      <header class="page-header">
        <div class="container-fluid">
          <h2 class="no-margin-bottom">帳號管理</h2>
        </div>
      </header>
      <section class="tables">
        <div class="container-fluid">
          <div class="row">
            <div class="col-lg-6">
              <div class="card">
                <div class="card-header d-flex align-items-center">
                  <h3 class="h4">基本資料</h3>
                </div>
                <div class="card-body">
                  <table class="table table-bordered">
                    <tbody>
                    <tr>
                      <th scope="row">姓名</th>
                      <td>
                      	<span name="UserName" id="UserName"><%=user.getName()%></span>
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">身分</th>
                      <td>
                      	<span name="Role"><%=roleName%></span>
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">帳號</th>
                      <td>
                      	<span name="Account"><%=user.getAccount()%></span>
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">密碼</th>
                      <td>
                      	<input class="form-control" type="password" value=<%=user.getPassword()%> id="Password" name="Password">
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">Email</th>
                      <td><input class="form-control" type="text" value=<%=user.getEmail()%> id="Email" name="Email"></td>
                    </tr>
                    </tbody>
                  </table>
                </div>
                <!-- Button trigger modal -->
                
                	<div class="modal-footer">
	                  <button style="float: right" type="button" class="btn btn-primary" data-toggle="modal" 
	                  		data-target="#exampleModal" onclick="show()">確定</button>
	                  <button style="float: right" type="button" class="btn btn-secondary" 
	                  		onclick="relocate_home()">取消</button>
	                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
      <!-- Page Footer-->

    </div> <!--table-->
  </div>
</div>
<footer class="main-footer"> <!--最下面那一排-->
  <div class="container-fluid">
    <div class="row">
      <div class="col-sm-6">
        <p>ISLAB1221 &copy; 2017</p>
      </div>
      <div class="col-sm-6 text-right">
        <p>Design by <a href="https://islab.csie.ntut.edu.tw/" class="external">智慧型系統實驗室</a></p>
        <!-- Please do not remove the backlink to us unless you support further theme's development at https://bootstrapious.com/donate. It is part of the license conditions. Thank you for understanding :)-->
      </div>
    </div>
  </div>
</footer>  <!--最下面那一排-->
<!-- Javascript files-->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="vendor/popper.js/umd/popper.min.js"> </script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="vendor/jquery.cookie/jquery.cookie.js"> </script>
<script src="vendor/jquery-validation/jquery.validate.min.js"></script>
<script src="js/front.js"></script>
<!--use for information.html button-->
<script>
    function relocate_home()
    {
        location.href = "information.html";
    }
    function show()
    {
        /*console.log(document.getElementById("email").value);
        console.log(showup.text);*/
        var password=document.getElementById("Password").value;
        var email= document.getElementById("Email").value;
        document.getElementById("showup").innerHTML = "Password:  "+ password+"<br>Email:  "+email;
        document.getElementById("email").value = email;
        document.getElementById("password").value = password;
        //showup.text(document.getElementById("email").value);
    }
</script>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">更新內容</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <form id="information-form" action = Information method=POST>
      <div class="modal-body">
        <label name="showup" id="showup">123</label>
        <input type="hidden" id="password" name="password" value=""> 
        <input type="hidden" id="email" name="email" value=""> 
      </div>
      	<div class="modal-footer">
	        <input type="submit" id="EditInformation" class="btn btn-primary" value="更改">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">關閉</button>
	    </div>
      </form>
    </div>
  </div>
</div>

</body>
</html>