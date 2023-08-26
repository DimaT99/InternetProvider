<#import "parts/common.ftlh" as c>

<@c.page>

<table border="2px">
    <thead>
    <tr>
        <th>tariff id</th>
        <th>name</th>
        <th>speed</th>
        <th>price</th>

    </tr>
    </thead>
    <tbody>
    <#list tariffs as tariff>
        <tr>
            <td><a href="/tariffs/${tariff.getId()}"><p>${tariff.getId()}</a></td>
            <td>${tariff.getName()}</td>
            <td>${tariff.getSpeed()}</td>
            <td>${tariff.getPrice()}</td>

            <td><a href="/tariffs/delete/${tariff.getId()}"><p>DELETE</a></td>
        </tr>
    </#list>
    </tbody>
</table>
<ul>
    <li><a href="/" target="_parent">Main</a></li>
</ul>

</@c.page>