<!DOCTYPE html>
<html>
<head>
    <title>Home page</title>
    <meta charset="UTF-8">
</head>
<body>
<a href="/logout">Log Out</a>
<h2>Reading List for ${reader}</h2>
<table>
    <tr>
    <th>Title</th>
    <th>Author</th>
    </tr>
    <#list books as book>
        <tr>
            <td> ${book.title} </td>
            <td>${book.author}</td>
        </tr>
    </#list>
</body>
</table>
<a href="/addBook">Add more books </a>
</html>
