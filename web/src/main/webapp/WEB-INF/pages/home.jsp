<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>DCTApp home</title>
</head>
<body>
<h3>Click
    <a href="${pageContext.request.contextPath}/service/version">here </a>
    to See DCTApp version
</h3>

    <h3>Enter triangle sides to check correctness</h3>
    <form action="${pageContext.request.contextPath}/service/checkTriangle" method="POST" enctype="application/json">
        <label>A:</label>
        <input name="a"> <br>
        <label>B:</label>
        <input name="b"> <br>
        <label>C:</label>
        <input name="c"> <br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
