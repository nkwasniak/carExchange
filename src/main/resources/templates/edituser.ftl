<!DOCTYPE html>
<head>
    <title>Edit User Profile</title>
    <link href="css/register.css" type="text/css" rel="stylesheet"/>
</head>
<#include "/_menu.ftl">
<body>
<div class="app">
    <h3>Edit User Profile</h3>
    <form action="edit-profile" modelAttribute="userDTO" method="post" class="register-form">
        <label class="label-name">Enter new name:</label>
        <br/>
        <input type="text" name="name" value=${user.name}>
        <br/>
        <label class="label-name">Enter new username:</label>
        <br/>
        <input type="text" name="username" value=${user.username}>
        <br/>
        <label class="label-name">Enter new phone number:</label>
        <br/>
        <input type="text" name="phone" value=${user.phone}>
        <br/>
        <label class="label-name">Enter new e-mail address:</label>
        <br/>
        <input type="email" name="email" value=${user.email}>
        <br/>
        <input type="submit" value="Save"/>
    </form>
</div>
</body>
</html>
