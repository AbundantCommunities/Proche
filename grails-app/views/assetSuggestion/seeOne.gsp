<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>Edit Suggested Asset</title>

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
        <script src='https://www.google.com/recaptcha/api.js'></script>
        <meta name="layout" content="main">
    </head>

    <body>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="/ABCD/">Home</a></li>
                <li><a href="<g:createLink controller='AssetSuggestion' action='list'/>" class="list">List Suggested Assets</a></li>
            </ul>
        </div>

        <div id="edit-assetSuggestion" class="content scaffold-edit" role="main">
            <h1>Edit Suggested Asset</h1>

            <form action="<g:createLink controller='AssetSuggestion' action='save'/>" method="POST">

                <input type="hidden" name="id" value="${sug.id}" />
                <input type="hidden" name="version" value="${sug.version}" id="version" />

                <fieldset class="form">

                    <div class="fieldcontain  required">
                        <label for="name">
                            Asset Name
                            <span class="required-indicator">*</span>
                        </label>
                        <input type="text" name="name" size="50" required="" value="${sug.name}" id="name" />
                    </div>

                    <div class="fieldcontain  required">
                        <label for="organization">
                            Organization
                            <span class="required-indicator">*</span>
                        </label>
                        <input type="text" name="organization" size="50" required="" value="${sug.organization}" id="organization" />
                    </div>

                    <div class="fieldcontain  ">
                        <label for="zeroCost">
                            Free
                        </label>
                        <g:checkBox name="zeroCost" value="${sug.zeroCost}"/>
                    </div>

                    <div class="fieldcontain  required">
                        <label for="description">
                            Description
                            <span class="required-indicator">*</span>
                        </label>
                        <textarea name="description" maxlength="1000" required="" id="description" >${sug.description}</textarea>
                    </div>

                    <div class="fieldcontain">
                        <label for="schedule">
                            Schedule
                            <span class="required-indicator">&nbsp;</span>
                        </label>
                        <input type="text" name="schedule" size="70" value="${sug.schedule}" id="schedule" />
                    </div>

                    <div class="fieldcontain">
                        <label for="location">
                            Location
                            <span class="required-indicator">&nbsp;</span>
                        </label>
                        <input type="text" name="location" size="70" value="${sug.location}" id="location" />
                    </div>

                    <div class="fieldcontain">
                        <label for="url">
                            Web Page
                            <span class="required-indicator">&nbsp;</span>
                        </label>
                        <input type="text" name="url" size="70" value="${sug.url}" id="url" />
                    </div>

                    <div class="fieldcontain">
                        <label for="emailAddress">
                            Email Address
                            <span class="required-indicator">&nbsp;</span>
                        </label>
                        <input type="text" name="emailAddress" value="${sug.emailAddress}" id="emailAddress" />
                    </div>

                    <div class="fieldcontain">
                        <label for="phoneNumber">
                            Phone Number
                            <span class="required-indicator">&nbsp;</span>
                        </label>
                        <input type="text" name="phoneNumber" value="${sug.phoneNumber}" id="phoneNumber" />
                    </div>

                    <div class="fieldcontain">
                        <label for="keywords">
                            Keywords
                            <span class="required-indicator">&nbsp;</span>
                        </label>
                        <textarea name="keywords" maxlength="1000" id="keywords" >${sug.keywords}</textarea>
                    </div>

                    <div class="fieldcontain">
                        <label for="administratorComment">
                            Administrator Comment
                            <span class="required-indicator">&nbsp;</span>
                        </label>
                        <textarea name="administratorComment" maxlength="2000" id="administratorComment" >${sug.administratorComment}</textarea>
                    </div>

                    <div class="fieldcontain">
                        <label for="dateCreated">
                            Date entered
                            <span class="required-indicator">&nbsp;</span>
                        </label>
                        <input type="text" name="dateCreated" readonly value="${sug.dateCreated}" id="dateCreated" />
                    </div>

                    <div class="fieldcontain">
                        <label for="suggesterName">
                            Suggester Name
                            <span class="required-indicator">&nbsp;</span>
                        </label>
                        <input type="text" name="suggesterName" readonly value="${sug.suggesterName}" id="suggesterName" />
                    </div>

                    <div class="fieldcontain">
                        <label for="suggesterContactInfo">
                            Suggester Contact Info
                            <span class="required-indicator">&nbsp;</span>
                        </label>
                        <input type="text" name="suggesterContactInfo" readonly value="${sug.suggesterContactInfo}" id="suggesterContactInfo" />
                    </div>

                    <div class="fieldcontain">
                        <label for="suggesterComment">
                            Suggester Comment
                            <span class="required-indicator">&nbsp;</span>
                        </label>
                        <textarea name="suggesterComment" readonly id="suggesterComment" >${sug.suggesterComment}</textarea>
                    </div>
                </fieldset>

                <fieldset class="buttons">
                    <input type="submit" name="button" value="Update" class="save" />
                    <input type="submit" name="button" value="Accept" class="accept" />
                    <input type="submit" name="button" value="Reject" class="reject" />
                </fieldset>
                
                <div class="g-recaptcha" data-sitekey="6LddMzMUAAAAAJFsqRBHKFWB0dCC1vvzJmX5yp6S"></div>
            </form>
        </div>
    </body>
</html>