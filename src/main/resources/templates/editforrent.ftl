<!DOCTYPE html>
<head>
    <title>Edit For Rent Ad</title>
    <link href="css/register.css" type="text/css" rel="stylesheet"/>
    <link href="css/add-forrent.css" type="text/css" rel="stylesheet"/>
</head>
<#include "/_menu.ftl">
<body>
<div class="app">
    <h3>Edit Your For Rent Ad</h3>
    <form action="edit-${adsId}" modelAttribute="forRent" method="post" enctype="utf8">
        <label class="label-name">Enter model:</label>
        <br/>
        <input type="text" name="model" value="${forRent.model}">
        <br/>
        <label class="label-name">Enter make:</label>
        <br/>
        <input type="text" name="make" value="${forRent.make}">
        <br/>
        <label class="label-name">Enter new months of cautions:</label>
        <br/>
        <input type="number" name="cautionMonths" value="${forRent.cautionMonths}">
        <br/>
        <label class="label-name">Enter distance:</label>
        <br/>
        <input type="number" name="distance" value="${forRent.distance}">
        <br/>
        <label class="label-name">Enter monthly rent ($):</label>
        <br/>
        <input type="number" name="monthlyRent" value="${forRent.monthlyRent}">
        <select name="currencyMonthlyRent">
            <#list enumValues as enum>
                <option value="${enum}">${enum}</option>
            </#list>
        </select>
        <br/>
        <label class="label-name">Enter description:</label>
        <br/>
        <input type="text" name="description" value="${forRent.description}">
        <br/>
        <input type="submit" value="Submit"/>
    </form>
</div>
</body>
</html>
