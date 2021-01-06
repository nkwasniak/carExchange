<!DOCTYPE html>
<head>
    <title>Edit User Profile</title>
    <link href="css/form.css" type="text/css" rel="stylesheet"/>
</head>
<#include "/_menu.ftl">
<body>
<div class="app">
    <form action="delete-account" method="post">
        <label class="label-name"><b>Name:</b> ${user.name}</label>
        </br>
        <label class="label-name"><b>Username:</b> ${user.username}</label>
        </br>
        <label class="label-name"><b>Phone number:</b> ${user.phone}</label>
        </br>
        <label class="label-name"><b>E-mail address:</b> ${user.email}</label>
        </br>
        <input type="submit" value="Delete Account"/>
    </form>
</div>
</body>
</html>
