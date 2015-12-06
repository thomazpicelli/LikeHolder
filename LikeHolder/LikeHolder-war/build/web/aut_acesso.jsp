<!-------------------------
ACESSE O LINK PARA PEGAR A AUTENTICAÇÃO DE SESSAO
https://github.com/thomazpicelli/Cinema/blob/master/Cinema/web/header.jsp
---------------------------->

<c:choose>
    <c:when test="${usuario != null && usuario != ''}">
        <p class='nome' style="color: white;"> Olá <c:out value="${usuario.getNmUsuario()}"></c:out>
        <c:out value=" - Acesso Premmium"></c:out>
    </c:when>
    <c:otherwise>
        <c:redirect url="index.jsp"></c:redirect>
    </c:otherwise>
</c:choose>  
<p><a href="./index.jsp">SAIR</a></p>