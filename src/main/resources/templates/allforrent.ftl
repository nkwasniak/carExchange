<!DOCTYPE html>
<head>
    <title>All For Rent Ads</title>
    <link href="css/advert-table.css" type="text/css" rel="stylesheet" />
</head>
<#include "/_menu.ftl">
<body>
<div class="table-wrapper">
    <table class="fl-table">
        <thead>
        <tr>
            <th>Make</th>
            <th>Model</th>
            <th>Distance</th>
            <th>Monthly Rent ($)</th>
            <th>Caution (Months)</th>
            <th>Description</th>
            <th>Contact via e-mail</th>
            <th>Contact via phone</th>
        </tr>
        </thead>

        <tbody>
        <#foreach forrent in forrentAds>
        <tr class="pure-table-odd">
            <td>${forrent.make}</td>
            <td>${forrent.model}</td>
            <td>${forrent.distance}</td>
            <td>${forrent.monthlyRent}</td>
            <td>${forrent.cautionMonths}</td>
            <td>${forrent.description}</td>
            <td>${forrent.userDTO.email}</td>
            <td>${forrent.userDTO.phone}</td>
        </tr>
        </#foreach>
        </tbody>
    </table>
</div>
</body>
</html>
