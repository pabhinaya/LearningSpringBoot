<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Log in</title>
</head>
<body>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
    </ul>
</nav>

<h1>Add Book to your list</h1>

<form name="addBookForm" action="/addToBookList" method="post">

    <div>
        <label for="title">Title</label>
        <input type="text" name="title" id="title" required autofocus/>
    </div>
    <div>
        <label for="author">Author</label>
        <input type="text" name="author" id="author" required />
    </div>
    <div>
        <label for="isbn">ISBN</label>
        <input type="text" name="isbn" id="isbn" required />
    </div>
    <div>
        <label for="description">Description</label>
        <input type="text" name="description" id="description" required/>
    </div>
    <button type="submit">Add to List</button>
</form>
</body>
</html>