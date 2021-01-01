<!DOCTYPE html>
<head>
    <title>Logout</title>
</head>
<#include "/_menu.ftl">
<body>
<br /><br />
    <h3>Logout User</h3>
    <div>
        Currently logged in user's username: <b type="text"  class="user">__user.getName()</b>
        <form action="/logout" method="POST">
            <input type="submit" value="Logout"/>
        </form>
    </div>
</body>
</html>
