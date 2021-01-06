<!DOCTYPE html>
<head>
    <title>Sign up!</title>
    <link href="css/form.css" type="text/css" rel="stylesheet"/>
</head>
<#include "/_menu.ftl">
<div class="app">
    <h3>Create New User</h3>
    <form action="/adduser" modelAttribute="User" method="post" enctype="utf8" class="register-form">
        <div class="inputs">
            <label class="label-name">Enter name:</label>
            <br/>
            <input type="text" name="name"/>
            <br/>
            <label class="label-name">Enter username:</label>
            <br/>
            <input type="text" name="username"/>
            <br/>
            <label class="label-name">Enter password:</label>
            <br/>
            <input type="password" name="password"/>
            <br/>
            <label class="label-name">Enter phone number:</label>
            <br/>
            <input type="text" name="phone"/>
            <br/>
            <label class="label-name">Enter e-mail address:</label>
            <br/>
            <input type="email" name="email"/>
            <br/>
            <input type="submit" value="Register" class="register"/>
        </div>
    </form>
</div>
</html>
