<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>DCTApp home</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/service/version">Click here to See DCTApp version</a>

    <form action="${pageContext.request.contextPath}/service/checkTriangle" method="POST" enctype="application/json">
        <input name="a">
        <input name="b">
        <input name="c">
        <input type="submit" value="Submit">
    </form>

    <%--<form:form method="post" action="${pageContext.request.contextPath}/service/checkTriangle" modelAttribute="triangledata">

        <table>
            <tr>
                <td><form:label path="a">A:</form:label></td>
                <td><form:input path="a" /></td>
            </tr>
            <tr>
                <td><form:label path="b">B:</form:label></td>
                <td><form:input path="b" /></td>
            </tr>
            <tr>
                <td><form:label path="c">C:</form:label></td>
                <td><form:input path="c" /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Check"/>
                </td>
            </tr>
        </table>

    </form:form>--%>
</body>
</html>
