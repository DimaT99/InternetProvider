<#include "security.ftlh">

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
            aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-item nav-link active" href="/">Home <span class="sr-only">(current)</span></a>
            <#if known>
                <a class="nav-item nav-link" href="/tariffs">Tariffs</a>
                <a class="nav-item nav-link" href="/tariff-page">Pages</a>
                <a class="nav-item nav-link" href="/logout">Logout</a>
                <#if isAdmin>
                    <a class="nav-item nav-link" href="/add-user-from-admin">Admin-panel</a>
                </#if>
                <#if known>
                    <a class="nav-item nav-link" href="/user/profile">${name}</a>
                </#if>
            <#else>
                <a class="nav-item nav-link" href="/registration">registration</a>
                <a class="nav-item nav-link" href="/registration">Оплата</a>
                <a class="nav-item nav-link" href="/login">Особистий кабінет</a>
            </#if>
        </div>
    </div>
</nav>