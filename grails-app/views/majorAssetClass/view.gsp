<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Top of Hierarchy</title>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="shortcut icon" href="/ABCD/assets/favicon.ico" type="image/x-icon">
    <link rel="apple-touch-icon" href="/ABCD/assets/apple-touch-icon.png">
    <link rel="apple-touch-icon" sizes="114x114" href="/ABCD/assets/apple-touch-icon-retina.png">
    <link rel="stylesheet" href="/ABCD/assets/main.css?compile=false" />
    <link rel="stylesheet" href="/ABCD/assets/mobile.css?compile=false" />
    <link rel="stylesheet" href="/ABCD/assets/application.css?compile=false" />

    <script src="/ABCD/assets/application.js?compile=false" type="text/javascript" ></script>

    <meta name="layout" content="main">
</head>

<body>
        <div id="edit-asset" class="content scaffold-edit" role="main">
            <h1>Top of Hierarchy</h1>

            <form>
                <fieldset class="form">
                    <div class="fieldcontain">
                        <label for="name">
                            Name
                        </label>
                        <input type="text" name="name" readonly size="50" value="${major.name}" id="name" />
                    </div>

                    <div class="fieldcontain">
                        <label for="description">
                            Description
                        </label>
                        <textarea name="description" readonly maxlength="1000" id="description" >${major.description}</textarea>
                    </div>

                    <div class="fieldcontain">
                        <label for="keywords">
                            Keywords
                        </label>
                        <textarea name="keywords" readonly maxlength="1000" id="keywords" >${major.keywords}</textarea>
                    </div>

                    <div class="fieldcontain">
                        <label for="lastUpdated">
                            Last Updated
                        </label>
                        <input type="text" name="lastUpdated" readonly value="${major.lastUpdated}" id="lastUpdated" />
                    </div>
                </fieldset>
            </form>
        </div>
</body>
</html>
