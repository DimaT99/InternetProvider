<#include "parts/security.ftlh">
<#import "parts/common.ftlh" as c>
<@c.page>

<div></div>
<body>
<div class="main-content color1">
    <h1>Internet Provider</h1>
</div>
<div>
    <#if known>
        Hello ${user.getEmail()}!
    <#else>
        Hello unknown!
    </#if>
</div>
<div class="menu">
    <h2>Перегляд даних по категоріям</h2>
</div>
<div class="container">
    <ul>
        <li><a href="/spring" target="_parent">Інформація
                про послуги</a></li>
        <li><a href="/tariffs" target="_parent">Інформація
                про тарифи</a></li>
    </ul>

</div>

<hr>

<h3>Створення категорій</h3>

<div class="flex-container">
    <ul>
        <li><a href="/spring" target="_parent">Створити курс</a></li>
        <li><a href="/spring">Створити лекцію</a></li>
        <li><a href="/spring">Створити вчителя</a></li>
        <li><a href="/tariff">Створити тариф</a></li>

    </ul>
</div>

<hr>

<h3>Обліковий запис</h3>
<div class="flex-container">
    <ol>
        <li><a href="/login" target="_parent">Вхід</a></li>
        <li><a href="/registration">Реєстрація</a></li>
    </ol>
</div>

<footer>
    <p>©.All rights reserved</p>
</footer>

</body>
</@c.page>