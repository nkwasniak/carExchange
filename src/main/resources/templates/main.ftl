<!DOCTYPE html>
<head>
    <link href="css/main.css" type="text/css" rel="stylesheet"/>
    <link href="css/error.css" type="text/css" rel="stylesheet"/>
</head>
<#include "/_menu.ftl">
<body>
<div class="container-fluid">
    <div class="row home">
        <div class="col-md-12 splash">
            <#if !(__user??)>
                <a href="/login">
                    <div class="intro">
                        <h1>Search car for you!</h1>
                    </div>
                    <button type="button" class="btn btn-default CTA">Login</button>
                </a>
            <#else >
                <a href="/all-forrent">
                    <div class="intro">
                        <h1>Search car for you!</h1>
                    </div>
                    <button type="button" class="btn btn-default CTA">GO TO ADVERTS</button>
                </a>
            </#if>
        </div>
    </div>
</div>
</body>
</html>
