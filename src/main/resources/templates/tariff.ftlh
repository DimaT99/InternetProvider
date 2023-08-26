<#import "parts/common.ftlh" as c>

<@c.page>

${tariff}

<div class="form-row">
    <div class="form-group col-md-6">
        <form method="post" action="/edit/${id}" class="form-inline">
            <input type="text" name="name" class="form-control" placeholder="tariff name">
            <input type="number" name="speed" class="form-control" placeholder="tariff speed">
            <input type="number" name="price" class="form-control" placeholder="tariff price">

            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit" class="btn btn-primary ml-2">Edit tariff</button>
        </form>
    </div>
</div>
<ul>
    <li><a href="/" target="_parent">Main</a></li>
</ul>
</@c.page>