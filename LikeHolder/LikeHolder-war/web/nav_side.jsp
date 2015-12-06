<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar-default navbar-side" role="navigation">
    <div class="sidebar-collapse">
        <ul class="nav" id="main-menu">
            <li class="text-center">
                <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="home.jsp">LikeHolder</a> 
                    </div>
                </nav>
            </li>
            <li class="text-center">
                <img src="img/find_user.png" class="user-image img-responsive"/>
                <%@ include file= "aut_acesso.jsp" %>
            </li>
            <li>
                <a class="active-menu"  href="home.jsp"><i class="fa fa-dashboard fa-3x"></i> HOME</a>
            </li>
             <li>
                <a  href="artist.jsp"><i class="fa fa-desktop fa-3x"></i> ARTIST</a>
            </li>
            <li>
                <a   href="music.jsp"><i class="fa fa-bar-chart-o fa-3x"></i> MUSICS</a>
            </li>	
            <li>
                <a  href="events.jsp"><i class="fa fa-table fa-3x"></i> EVENTS</a>
            </li>
        </ul>
    </div>
</nav> 