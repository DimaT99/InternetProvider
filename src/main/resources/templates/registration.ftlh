<#import "parts/common.ftlh" as c>

<@c.page>
    <style>
        .error {
            color: red;
        }
    </style>
    <script>
        function validateForm() {
            let username = document.forms["myForm"]["username"].value;
            let password = document.forms["myForm"]["password"].value;
            let email = document.forms["myForm"]["email"].value;
            let isValid = true;

            if (username === "") {
                document.getElementById("usernameError").textContent = "Enter a username";
                isValid = false;
            }
            if (password === "") {
                document.getElementById("passwordError").textContent = "Enter a password";
                isValid = false;
            }
            if (email === "") {
                document.getElementById("emailError").textContent = "Enter email";
                isValid = false;
            }

            return isValid;
        }
    </script>
</head>
<body>
<div class="form-row">
    <form name="myForm" method="post" onsubmit="return validateForm()" class="form-inline">
        <input type="text" name="username" class="form-control" placeholder="username"><br>
        <span id="usernameError" class="error"></span><br><br>
        <input type="password" name="password" class="form-control" placeholder="user password"><br>
        <span id="passwordError" class="error"></span><br><br>
        <input type="email" name="email" class="form-control" placeholder="email"><br>
        <span id="emailError" class="error"></span><br><br>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit">Save</button>
    </form>
</div>

</@c.page>