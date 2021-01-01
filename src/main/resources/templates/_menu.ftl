<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="css/navbar.css" type="text/css" rel="stylesheet" />
    <link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
</head>
<body>
<div class="bg-dark">
    <div class="container">
        <ul class="nav" id="main-nav">
            <li class="nav-item">
                <a href=" /main" class="nav-logo nav-link">Car RENTAL</a>
            </li>
            <li class="nav-item">
                <a href="/all-forrent" class="nav-link">For Rent Adverts</a>
            </li>
            <li class="nav-item">
                <#if !(__user??)>
                    <a href="/login" class="nav-link">
                        Login
                    </a>
                <#else>
                    <a href="#!" class="nav-link">
                        Profile <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dp-menu level-1">
                        <li class="dp-item">
                            <a href="/add-forrent" class="dp-link">
                                Add for rent ad<i class="fa fa-caret-right"></i>
                            </a>
                        </li>
                        <li class="dp-item">
                            <a href="/user-forrent" class="dp-link">
                                My Adverts <i class="fa fa-caret-right"></i>
                            </a>
                        </li>
                        <li class="dp-item">
                            <a href="/edit-profile" class="dp-link">Edit profile</a>
                        </li>
                        <li class="dp-item">
                            <a href="/logout" class="dp-link">Logout</a>
                        </li>
                    </ul>
                </#if>
            </li>
        </ul>
    </div>
</div>
</body>
