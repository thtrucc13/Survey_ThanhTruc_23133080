<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <title>Survey Result</title>
    <link rel="stylesheet" href="styles/survey.css">
</head>

<body>
    <form>
        <!-- Tiêu đề -->
        <h1>Survey Result</h1>
        
        <p>Thanks for taking our survey!</p>
        <p>Here is the information that you entered:</p>

        <table>
            <tr>
                <th>Email</th>
                <td>${user.email}</td>
            </tr>
            <tr>
                <th>First Name</th>
                <td>${user.firstName}</td>
            </tr>
            <tr>
                <th>Last Name</th>
                <td>${user.lastName}</td>
            </tr>
            <tr>
                <th>Heard From</th>
                <td>${user.heardFrom}</td>
            </tr>
            <tr>
                <th>Wants Update</th>
                <td>${user.wantsUpdate ? "Yes" : "No"}</td>
            </tr>
            <tr>
                <th>Contact Via</th>
                <td>${user.contactVia}</td>
            </tr>
        </table>

        <p class="pad_top">To submit another survey, click on the Return button below.</p>

        <form action="${pageContext.request.contextPath}/survey" method="get">
            <input type="hidden" name="action" value="join">
            <input type="submit" value="Return">
        </form>
    </form>
</body>
</html>
