<!DOCTYPE html>
<head>
    <title>My For Rent Ads</title>
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
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        </thead>

        <tbody>
        <tbody>
        <#foreach forrent in forrentAds>
            <tr class="pure-table-odd">
                <td>${forrent.make}</td>
                <td>${forrent.model}</td>
                <td>${forrent.distance}</td>
                <td>${forrent.monthlyRent}</td>
                <td>${forrent.cautionMonths}</td>
                <td>${forrent.description}</td>
                <td><a href="delete-${forrent.adId}"><div style="height:100%;width:100%">Delete</div></a>
                <td><a href="edit-${forrent.adId}"><div style="height:100%;width:100%">Edit</div></a>
            </tr>
        </#foreach>
        </tbody>
    </table>
</div>
</body>
</html>
