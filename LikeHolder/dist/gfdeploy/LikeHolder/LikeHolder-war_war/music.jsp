<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Music - LikeHolder</title>
        <!-- MORRIS CHART STYLES-->
        <link href="js/morris/morris-0.4.3.min.css" rel="stylesheet" />
        <!-- BOOTSTRAP STYLES-->
        <link href="css/bootstrap.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
        <link href="css/custom.css" rel="stylesheet" />
         <!-- GOOGLE FONTS-->
       <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    </head>
    <body>
        <div id="wrapper">

            <!-- /. NAV TOP  -->
            <%//@include file= "nav.jsp" %>

            <!-- /. NAV SIDE  -->
            <%@ include file= "nav_side.jsp" %>

            <div id="page-wrapper" >
                <div id="page-inner">
                    <div class="row">
                        <div class="col-md-12">
                             <h2>Music</h2>   
                        </div>
                    </div>      
                    <div class="row">
                        <div class="col-md-5" style="margin-left: 50%;">
                            <form action="FrontController" method="POST">
                                <div class="form-group input-group">
                                    <input type="text" class="form-control" placeholder="Search" name="busc_musica"/>
                                    <span class="input-group-btn">
                                        <button class="btn btn-info btn-sm" type="submit">#
                                        </button>
                                    </span>
                                    <input type="hidden" name="command" value="BuscaCommand_musica">
                                </div>
                            </form>
                        </div>
                    </div>
                    <c:if test="${buscaMusica != null}">
                        <div class="row">
                            <div class="col-md-9 col-sm-12 col-xs-12">
                        
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                       Search Results for: <b>${bm}</b>
                                    </div>
                                    <div class="panel-body">
                                        <div class="table-responsive">
                                            <table class="table table-striped table-bordered table-hover">
                                                <thead>
                                                    <tr>
                                                        <th>Prev</th>
                                                        <th>Name</th>
                                                        <th>Artist</th>
                                                        <th>Link</th>
                                                        <th>Like</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="bm" items="${buscaMusica}">
                                                    <tr> 
                                                        <td><iframe src="https://embed.spotify.com/?uri=${bm.getDcUri()}" width="250" height="80" frameborder="0" allowtransparency="true"></iframe></td>
                                                        <td>${bm.getNmMusica()}</td>
                                                        <td>${bm.getNmArtista()}</td>
                                                        <td><a href="${bm.getDcUrl()}" target="blank">View Musica</a></td>
                                                        <td>
                                                            <form action="FrontController" method="POST">
                                                                <input type="hidden" name="command" value="CurtirCommand_musica">
                                                                <input type="hidden" name="id" value="${bm.getDcId()}">
                                                                <button type="submit" class="btn btn-danger btn-sm">Like</button>
                                                            </form>
                                                        </td>
                                                    </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:if>
                    <div class="row">
                        <div class="col-md-12">
                             <h3>Favorities</h3>   
                        </div>
                    </div>
                    <div class="row">
                        <c:forEach var="m" items="${musica}">
                            <div class="col-md-9 col-sm-9">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4><a href="${m.getDcUrl()}" target="blank">${m.getNmMusica()}</a></h4>
                                    </div>
                                    <div class="panel-body">
                                        <div style="float: left; margin-right: 5%;">
                                            <iframe src="https://embed.spotify.com/?uri=${m.getDcUri()}" width="250" height="350" frameborder="0" allowtransparency="true"></iframe>
                                        </div>
                                        <div>
                                            <p><b>Name:</b> ${m.getNmMusica()}</p>
                                            <p><b>Artist:</b> ${m.getNmArtista()}</p>
                                            <p><b>Id: </b> ${m.getDcId()}</p>
                                        </div>    
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div> 
                </div>
            </div>
        </div>
         <!-- /. WRAPPER  -->
        <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
        <!-- JQUERY SCRIPTS -->
        <script src="assets/js/jquery-1.10.2.js"></script>
          <!-- BOOTSTRAP SCRIPTS -->
        <script src="assets/js/bootstrap.min.js"></script>
        <!-- METISMENU SCRIPTS -->
        <script src="assets/js/jquery.metisMenu.js"></script>
         <!-- MORRIS CHART SCRIPTS -->
         <script src="assets/js/morris/raphael-2.1.0.min.js"></script>
        <script src="assets/js/morris/morris.js"></script>
          <!-- CUSTOM SCRIPTS -->
        <script src="assets/js/custom.js"></script>
    </body>
</html>
