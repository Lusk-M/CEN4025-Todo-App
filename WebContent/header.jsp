  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
  <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100;400;700&family=Roboto&family=Noto+Sans&display=swap" rel="stylesheet">
</head>
<body>
  <header>
  <div id="header-container">
    <span id="header-text">CEN 4025</span><span id="header-subtext">Todo App</span>
      <nav>
    <ul>
      <a href="create-todo.jsp"><li class="nav-button">Add Todo</li></a>
      <a href=""> <li class="nav-button"><form action="TodosController" method="POST">
            <input class="nav-input" type="submit" name="displayTodos" value="View Todos">     
        </form></li></a>
    </ul>
  </nav>
    </div>
  </header>
  <div id="content-container">
  <div id="projects-container">