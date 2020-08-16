<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp"%>


<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sign in</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $(function () {
            $("#datepicker").datepicker();
        });
    </script>
</head>
<body>
<p class="materialize-red-text"><spring:message code="${errorMessage}"/></p>
<form:form id="formInscription" method="POST" action="/DLivres/inscription/send" modelAttribute="inscriptionForm">
    <h1>Inscription</h1>
    <ul>
        <li><form:label for="userName" path="userName"><spring:message code="userName"/></form:label>
            <form:input path="userName" id="userName"></form:input></li>
        <li><form:label for="email" path="email"><spring:message code="email"/></form:label>
            <form:input id="email" path="email"></form:input></li>
        <li><form:label for="name" path="name"><spring:message code="name"/></form:label>
            <form:input id="name" path="name"></form:input><p style="color:red;"></li>
        <li><form:label for="firstName" path="firstName"><spring:message code="firstName"/></form:label>
            <form:input id="firstName" path="firstName"></form:input></li>
        <li><form:label for="phoneNumber" path="phoneNumber"><spring:message code="phoneNumber"/></form:label>
            <form:input id="phoneNumber" path="phoneNumber"></form:input></li>





        <li><form:label for="street" path="street"><spring:message code="street"/></form:label>
            <form:input id="street" path="street"></form:input></li>
        <li><form:label for="streetNumber" path="streetNumber"><spring:message code="streetNumber"/></form:label>
            <form:input id="streetNumber" path="streetNumber"/></li>
        <li><form:label for="postalCode" path="postalCode"><spring:message code="postalCode"/></form:label>
            <form:input id="postalCode" path="postalCode"></form:input></li>
        <li><form:label for="city" path="city"><spring:message code="city"/></form:label>
            <form:input id="city" path="city"></form:input></li>
        <li><form:label for="country" path="country"><spring:message code="country"/></form:label>
            <form:input id="country" path="country"></form:input></li>
        <li><form:label for="password" path="password" ><spring:message code="password"/></form:label>
            <form:input type="password" id="password" path="password"></form:input></li>
        <li><form:label for="confirmPassword" path="confirmPassword"><spring:message code="confirmPassword"/></form:label>
            <form:input type="password" id="confirmPassword" path="confirmPassword"></form:input></li>


        <li><form:button>Send</form:button></li>
    </ul>
</form:form>
</body>
</html>