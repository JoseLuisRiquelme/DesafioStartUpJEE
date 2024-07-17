<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="html/head.jsp" %>
<body>
<div class="container">
<%@ include file="html/nav.jsp" %>
<h1>HOME</h1>
<h2>Bienvenido <strong>${usuario.nombre}!</strong></h2>
<h3>Tu correo es: ${usuario.correo}</h3>
<a  href="${pageContext.request.contextPath}" class="btn btn-primary mb-3">Regresar</a>
<%@ include file="html/footer.jsp" %>
</div>
</body>
</html>