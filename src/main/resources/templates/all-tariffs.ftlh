<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>tariffs</title>
</head>
<body>

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

</body>
</html>