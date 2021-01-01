<!DOCTYPE html>
<head>
    <title>Login</title>
    <link href="css/login.css" type="text/css" rel="stylesheet" />
</head>
<#include "/_menu.ftl">
    <div class="app">
        <h3>Login User</h3>
        <#if RequestParameters.error??>
            <p class="error">
                Bad Credentials - Try again!
            </p>
        </#if>
        <form action="/login" method="POST" class="login-form">
            <div class="inputs">
                <input type="text" name="username" placeholder="username"/>
                <input type="password" name="password" placeholder="Enter your password"/>
                <input class="login" type="submit" value="Login"/>
            </div>

        </form>
        <footer>
            <p>Don't have an account? <a href="/adduser" class="btn btn-info" role="button">Sign Up</a></p>
        </footer>
</div>
</html>