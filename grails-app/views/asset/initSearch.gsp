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
    <h1>Search Assets</h1>
    <form action="<g:createLink controller='Asset' action='search'/>" method="POST">
        <fieldset class="form">

            <div class="fieldcontain">
                <label for="community">
                    Community
                    <span class="required-indicator">*</span>
                </label>
                <select id="communityId" name="communityId" required="" >
                    <option value="null">Select One...</option>
                    <g:each in="${communities}" var="community">
                        <option value="${community.id}">${community.name}</option>
                    </g:each>
                </select>
            </div>

            <div class="fieldcontain">
                <label for="walkingDistance">
                    How far away?
                </label>
                <input type="text" name="walkingDistance" size="3" value="5" id="walkingDistance" />
            </div>

            <div class="fieldcontain">
                <label for="q">
                    Search for?
                </label>
                <input type="text" name="q" size="50" autofocus="yup" value="" id="q" />
            </div>
        </fieldset>

        <fieldset class="buttons">
            <input type="submit" name="search" value="Search" class="doSearch" />
        </fieldset>

    </form>
</body>
</html>
