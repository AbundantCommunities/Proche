<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Assets</title>

        <link rel="stylesheet" href="/ABCD/assets/main.css?compile=false" />
        <link rel="stylesheet" href="/ABCD/assets/mobile.css?compile=false" />
        <link rel="stylesheet" href="/ABCD/assets/application.css?compile=false" />

        <script src="/ABCD/assets/application.js?compile=false" type="text/javascript" ></script>

        <meta name="layout" content="main">
    </head>

    <body>
        <h1>Enter Search Term</h1>
            <form action="<g:createLink controller='Asset' action='search'/>" method="POST">

                <fieldset class="form">

                    <div class="fieldcontain  required">
                        <label for="q">
                            Term
                        </label>
                        <input type="text" name="q" size="50" required value="" id="q" />
                    </div>

                <fieldset class="buttons">
                    <input type="submit" name="search" value="Search" class="search" />
                </fieldset>
            </form>
    </body>
</html>
