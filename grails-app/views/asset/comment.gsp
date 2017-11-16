<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Comment on Public Asset</title>

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
    <h1>Comment</h1>
    <form action="<g:createLink action='saveComment'/>" method="POST">

        <input type="hidden" name="id" value="${asset.id}" />
        <input type="hidden" name="version" value="${asset.version}" />

        <fieldset class="form">

            <div class="fieldcontain">
                <label for="name">
                    Asset Name
                    <span class="required-indicator">&nbsp;</span>
                </label>
                    <input type="text" name="name" size="50" readonly="" value="${asset.name}" />
            </div>

            <div class="fieldcontain">
                <label for="organization">
                    Organization
                    <span class="required-indicator">&nbsp;</span>
                </label>
                    <input type="text" name="organization" size="50" readonly="" value="${asset.organization}" />
            </div>

            <div class="fieldcontain">
                <label for="description">
                    Description
                    <span class="required-indicator">&nbsp;</span>
                </label>
                <textarea name="description" readonly="" id="description" >${asset.description}</textarea>
            </div>

            <div class="fieldcontain  required">
                <label for="submitterName">
                    Your Name
                    <span class="required-indicator">*</span>
                </label>
                <input type="text" name="submitterName" size="50" autofocus="yup" required="" value="" />
            </div>

            <div class="fieldcontain  required">
                <label for="submitterContactInfo">
                    Your Contact Info (email, phone, etc)
                    <span class="required-indicator">*</span>
                </label>
                <input type="text" name="submitterContactInfo" size="70" required="" value="" />
            </div>

            <div class="fieldcontain  required">
                <label for="says">
                    Comment
                    <span class="required-indicator">*</span>
                </label>
                <textarea name="says" maxlength="2000" required="" ></textarea>
            </div>
        </fieldset>

        <fieldset class="buttons">
            <input type="submit" name="button" value="Submit" class="save" />
        </fieldset>
    </form>
    </div>
</body>
</html>
