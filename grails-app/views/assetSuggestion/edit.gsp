<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>View Suggested Asset</title>

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
        <div id="edit-assetSuggestion" class="content scaffold-edit" role="main">
            <h1>Edit Suggested Asset</h1>

            <form action="<g:createLink action='save'/>" method="POST">

                <input type="hidden" name="id" value="${sug.id}" />
                <input type="hidden" name="version" value="${sug.version}" />

                <fieldset class="form">

                    <div class="fieldcontain required">
                        <label for="name">
                            Asset Name
                        </label>
                        <input type="text" name="name" size="50" required value="${sug.name}" id="name" />
                    </div>

                    <div class="fieldcontain">
                        <label for="organization">
                            Organization
                        </label>
                        <input type="text" name="organization" size="50" value="${sug.organization}" id="organization" />
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
                        </label>
                        <textarea name="description" maxlength="1000" required="" id="description" >${sug.description}</textarea>
                    </div>

                    <div class="fieldcontain required">
                        <label for="location">
                            Location
                        </label>
                        <input type="text" name="location" size="70" value="${sug.location}" id="location" />
                        <a href="${mapLink}" target="_blank">Map</a>
                    </div>

                    <div class="fieldcontain">
                        <label for="url">
                            Web Page
                        </label>
                        <input type="text" name="url" size="70" value="${sug.url}" id="url" />
                        <a href="${sug.url}" target="_blank">View</a>
                    </div>

                    <div class="fieldcontain">
                        <label for="emailAddress">
                            Email Address
                        </label>
                        <input type="text" name="emailAddress" value="${sug.emailAddress}" id="emailAddress" />
                    </div>

                    <div class="fieldcontain">
                        <label for="phoneNumber">
                            Phone Number
                        </label>
                        <input type="text" name="phoneNumber" value="${sug.phoneNumber}" id="phoneNumber" />
                    </div>

                    <div class="fieldcontain">
                        <label for="administratorComment">
                            Administrator Comments
                        </label>
                        <textarea name="administratorComment" id="administratorComment" >${sug.administratorComment}</textarea>
                    </div>

                    <div class="fieldcontain">
                        <label for="suggesterName">
                            Submitter's Name
                        </label>
                        <input type="text" name="suggesterName" value="${sug.suggesterName}" id="suggesterName" />
                    </div>

                    <div class="fieldcontain">
                        <label for="suggesterContactInfo">
                            Submitter's Contact Info
                        </label>
                        <input type="text" name="suggesterContactInfo" value="${sug.suggesterContactInfo}" id="suggesterContactInfo" />
                    </div>

                    <div class="fieldcontain">
                        <label for="suggesterComment">
                            Submitter's Comments
                        </label>
                        <textarea name="suggesterComment" id="suggesterComment" >${sug.suggesterComment}</textarea>
                    </div>
                </fieldset>

                <fieldset class="buttons">
                    <input type="submit" name="button" value="Update" class="save" />
                    <input type="submit" name="button" value="Accept" class="accept" />
                    <input type="submit" name="button" value="Reject" class="reject" />
                </fieldset>
            </form>
        </div>
    </body>
</html>