<!DOCTYPE html>
<#include "/_menu.ftl">
<head>
    <title>Add New For Rent Advert</title>
    <link href="css/register.css" type="text/css" rel="stylesheet"/>
    <link href="css/add-forrent.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div class="app">
    <h3>Add New For Rent Advert</h3>
    <form action="/add-forrent" modelAttribute="forRent" method="post" enctype="utf8" class="register-form">
        <label class="label-name">Enter model:</label>
        <br />
        <input type="text" name="model">
        <br />
        <label class="label-name">Enter make:</label>
        <br />
        <input type="text" name="make">
        <br />
        <label class="label-name">Enter months of cautions:</label>
        <br />
        <input type="number" name="cautionMonths">
        <br />
        <label class="label-name">Enter distance:</label>
        <br />
        <input type="number" name="distance">
        <br />
        <label class="label-name">Enter monthly rent:</label>
        <br />
        <div class="monthlyRent">
            <input type="number" name="monthlyRent">
            <select name="currencyMonthlyRent">
                <#list enumValues as enum>
                    <option value="${enum}">${enum}</option>
                </#list>
            </select>
        </div>
        <br />
        <label class="label-name">Enter description</label>
        <br />
        <input type="text" name="description">
        <br />
        <input type="submit" value="Submit" />
    </form>
</div>
</body>
</html>
