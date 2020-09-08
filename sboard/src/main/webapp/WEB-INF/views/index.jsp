<%@ page contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 로그인 안했을 시 즉, sessionScope에 멤버가 없을시 -->
<c:if test="${empty member}">
<jsp:forward page="/user/login"></jsp:forward>
</c:if>
<!-- 로그인 했을 시 즉, sessionScope에 멤버가 있을시 -->
<c:if test="${member}">
<jsp:forward page="/list"></jsp:forward>
</c:if>