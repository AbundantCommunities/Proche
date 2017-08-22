<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>Edit Asset</title>

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
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="/ABCD/">Home</a></li>
                <li><a href="<g:createLink controller='asset' action='initSearch'/>" class="list">Search Assets</a></li>
            </ul>
        </div>

        <div id="edit-asset" class="content scaffold-edit" role="main">
            <h1>Edit Asset</h1>

            <form action="<g:createLink controller='Asset' action='save'/>" method="POST">

                <input type="hidden" name="id" value="${asset.id}" />
                <input type="hidden" name="version" value="${asset.version}" id="version" />

                <fieldset class="form">

                    <div class="fieldcontain  required">
                        <label for="name">
                            Asset Name
                            <span class="required-indicator">*</span>
                        </label>
                        <input type="text" name="name" size="50" required="" value="${asset.name}" id="name" />
                    </div>

                    <div class="fieldcontain  required">
                        <label for="organization">
                            Organization
                            <span class="required-indicator">*</span>
                        </label>
                        <input type="text" name="organization" size="50" required="" value="${asset.organization}" id="organization" />
                    </div>

                    <div class="fieldcontain  ">
                        <label for="zeroCost">
                            Free
                            <span class="required-indicator">&nbsp;</span>
                        </label>
                        <g:checkBox name="zeroCost" value="${asset.zeroCost}"/>
                    </div>

                    <div class="fieldcontain  required">
                        <label for="description">
                            Description
                            <span class="required-indicator">*</span>
                        </label>
                        <textarea name="description" maxlength="1000" required="" id="description" >${asset.description}</textarea>
                    </div>

                    <div class="fieldcontain">
                        <label for="schedule">
                            Schedule
                            <span class="required-indicator">&nbsp;</span>
                        </label>
                        <input type="text" name="schedule" size="70" value="${asset.schedule}" id="schedule" />
                    </div>

                    <div class="fieldcontain">
                        <label for="location">
                            Location
                            <span class="required-indicator">&nbsp;</span>
                        </label>
                        <input type="text" name="location" size="60" value="${asset.location}" id="location" />
                        <a href="${mapLink}">MAP</a>
                    </div>

                    <div class="fieldcontain">
                        <label for="url">
                            Web Page
                            <span class="required-indicator">&nbsp;</span>
                        </label>
                        <input type="text" name="url" size="70" value="${asset.url}" id="url" />
                    </div>

                    <div class="fieldcontain">
                        <label for="emailAddress">
                            Email Address
                            <span class="required-indicator">&nbsp;</span>
                        </label>
                        <input type="text" name="emailAddress" value="${asset.emailAddress}" id="emailAddress" />
                    </div>

                    <div class="fieldcontain">
                        <label for="phoneNumber">
                            Phone Number
                            <span class="required-indicator">&nbsp;</span>
                        </label>
                        <input type="text" name="phoneNumber" value="${asset.phoneNumber}" id="phoneNumber" />
                    </div>

                    <div class="fieldcontain">
                        <label for="keywords">
                            Keywords
                            <span class="required-indicator">&nbsp;</span>
                        </label>
                        <textarea name="keywords" maxlength="1000" id="keywords" >${asset.keywords}</textarea>
                    </div>

                    <div class="fieldcontain">
                        <label for="dateCreated">
                            Date entered
                            <span class="required-indicator">&nbsp;</span>
                        </label>
                        <input type="text" name="dateCreated" readonly value="${asset.dateCreated}" id="dateCreated" />
                    </div>

                </fieldset>

                <fieldset class="buttons">
                    <input type="submit" name="save" value="Update" class="save" />
                </fieldset>
            </form>
        </div>
    </body>
</html>