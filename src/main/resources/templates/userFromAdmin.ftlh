<#import "parts/common.ftlh" as c>
<@c.page>
    <ul>
        <li><a href="/subscribers" target="_parent">All subscribers</a></li>
    </ul>
    <div class="form-row">
        <div class="form-group col-md-6">
            <form method="post" action="/registration-from-admin" class="form-inline">
                <input type="text" name="username" class="form-control" placeholder="username">
                <input type="text" name="firstname" class="form-control" placeholder="firstname">
                <input type="text" name="lastname" class="form-control" placeholder="lastname">
                <input type="password" name="password" class="form-control" placeholder="user password">
                <input type="email" name="email" class="form-control" placeholder="email">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <button type="submit" class="btn btn-primary ml-2">Save</button>
            </form>
        </div>
    </div>

</@c.page>



