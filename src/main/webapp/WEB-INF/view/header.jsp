<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="language" value="${not empty sessionScope.language ? sessionScope.language : \"en\"}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="messages"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>l-m-s</title>
    <%--<link rel="stylesheet" href="../css/w3.css">--%>
    <style>
        <%@include file="../css/w3.css" %>
    </style>

</head>
<body>
<header class="w3-container w3-blue-grey w3-opacity w3-teal w3-center">
    <h1><fmt:message key="conference-management-system"/></h1>
</header>
