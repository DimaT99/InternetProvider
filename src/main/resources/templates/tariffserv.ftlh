<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Create student</title>
</head>
<body>

<div class="form-row">
    <div class="form-group col-md-6">
        <form method="post" action="/add" class="form-inline">
            <input type="text" name="name" class="form-control" placeholder="tariff name">
            <input type="number" name="courseId" class="form-control" placeholder="tariff speed">
            <input type="number" name="courseId" class="form-control" placeholder="tariff price">

            <button type="submit" class="btn btn-primary ml-2">Add new tariff</button>
        </form>
    </div>
</div>
<ul>
    <li><a href="/" target="_parent">Main</a></li>
</ul>
</body>
</html>