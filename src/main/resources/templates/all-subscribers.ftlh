<#import "parts/common.ftlh" as c>

<@c.page>

    <table border="2px">
        <thead>
        <tr>
            <th>subscriber id</th>
            <th>username</th>
            <th>firstname</th>
            <th>lastname</th>
            <th>email</th>
            <th>password</th>

        </tr>
        </thead>
        <tbody>
        <#list subscribers as subscriber>
            <tr>
                <td><a href="/subscribers/${subscriber.getId()}"><p>${subscriber.getId()}</a></td>
                <td>${subscriber.getUsername()}</td>
                <td>${subscriber.getFirstname()}</td>
                <td>${subscriber.getLastname()}</td>
                <td>${subscriber.getEmail()}</td>
                <td>${subscriber.getPassword()}</td>

                <td><a href="/subscribers/delete/${subscriber.getId()}"><p>DELETE</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
    <ul>
        <li><a href="/" target="_parent">Main</a></li>
    </ul>

</@c.page>