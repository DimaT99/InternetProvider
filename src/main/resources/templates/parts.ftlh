<#import "parts/common.ftlh" as c>

<@c.page>

    <h1>Tariff List</h1>

    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Speed</th>
            <th>Price</th>
        </tr>
        </thead>
        <tbody>
        <#list tariffPage as tariff>
            <tr>
                <td>${tariff.getId()}</td>
                <td>${tariff.getName()}</td>
                <td>${tariff.getSpeed()}</td>
                <td>${tariff.getPrice()}</td>
            </tr>
        </#list>
        </tbody>
    </table>

    <div>
        <#if currentPage?number gt 0>
            <a href="/tariff-page?page=${currentPage - 1}">Previous</a>
        </#if>

        Page ${currentPage + 1} of ${totalPages}

        <#if currentPage < totalPages - 1>
            <a href="/tariff-page?page=${currentPage + 1}">Next</a>
        </#if>
    </div>

</@c.page>