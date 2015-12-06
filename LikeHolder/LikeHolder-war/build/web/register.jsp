<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Register - LikeHolder</title>
            <!-- BOOTSTRAP STYLES-->
        <link href="css/bootstrap.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
        <link href="css/custom.css" rel="stylesheet" />
         <!-- GOOGLE FONTS-->
       <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
       <style>
           body{
               background-image:url("img/back.jpg"); 
           }
       </style>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1" style="margin-top: 7%;">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h2>Register</h2>  
                        </div>
                        <div class="panel-body">
                            <form role="form">
                                <br/>
                                <div class="form-group input-group">
                                    <span class="input-group-addon"></span>
                                    <input type="text" class="form-control" placeholder="Name" name="name"/>
                                </div>
                                <div class="form-group input-group">
                                    <span class="input-group-addon"></span>
                                    <input type="text" class="form-control" placeholder="Username" name="username"/>
                                </div>
                                <div class="form-group input-group">
                                    <span class="input-group-addon"></span>
                                    <input type="email" class="form-control" placeholder="E-mail" name="email"/>
                                </div>
                                <div class="form-group input-group">
                                    <span class="input-group-addon"></span>
                                    <input type="password" class="form-control" placeholder="Password" name="password1"/>
                                </div>
                                <div class="form-group input-group">
                                    <span class="input-group-addon"></span>
                                    <input type="password" class="form-control" placeholder="Retype Password" name="password2"/>
                                </div>
                                <div class="form-group input-group">
                                    <input type="hidden" class="form-control" name="command" value="register"/>
                                </div>
                                <a href="#" class="btn btn-primary " onclick="$(this).closest('form').submit()">Register</a>
                                <hr />
                                Already Registered ?  <a href="index.jsp" >Click Here</a>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
        <!-- JQUERY SCRIPTS -->
        <script src="js/jquery-1.10.2.js"></script>
          <!-- BOOTSTRAP SCRIPTS -->
        <script src="js/bootstrap.min.js"></script>
        <!-- METISMENU SCRIPTS -->
        <script src="js/jquery.metisMenu.js"></script>
          <!-- CUSTOM SCRIPTS -->
        <script src="js/custom.js"></script>
    </body>
</html>
