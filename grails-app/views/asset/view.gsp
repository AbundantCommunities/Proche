<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>View Asset</title>

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
            <h1>Asset Details</h1>

            <form>
                <fieldset class="form">
                    <div class="fieldcontain">
                        <label for="name">
                            Asset Name
                        </label>
                        <input type="text" name="name" readonly size="50" value="${asset.name}" id="name" />
                    </div>

                    <div class="fieldcontain">
                        <label for="organization">
                            Organization
                        </label>
                        <input type="text" name="organization" readonly size="50" value="${asset.organization}" id="organization" />
                    </div>

                    <div class="fieldcontain  ">
                        <label for="zeroCost">
                            Free
                        </label>
                        <g:checkBox name="zeroCost" readonly value="${asset.zeroCost}"/>
                    </div>

                    <div class="fieldcontain">
                        <label for="description">
                            Description
                        </label>
                        <textarea name="description" readonly maxlength="1000" id="description" >${asset.description}</textarea>
                    </div>

                    <div class="fieldcontain">
                        <label for="schedule">
                            Schedule
                        </label>
                        <input type="text" name="schedule" readonly size="70" value="${asset.schedule}" id="schedule" />
                    </div>

                    <div class="fieldcontain">
                        <label for="location">
                            Location
                        </label>
                        <input type="text" name="location" readonly size="60" value="${asset.location}" id="location" />
                        <a href="${mapLink}">MAP</a>
                    </div>

                    <div class="fieldcontain">
                        <label for="url">
                            Web Page
                        </label>
                        <input type="text" name="url" readonly size="70" value="${asset.url}" id="url" />
                    </div>

                    <div class="fieldcontain">
                        <label for="emailAddress">
                            Email Address
                        </label>
                        <input type="text" name="emailAddress" readonly value="${asset.emailAddress}" id="emailAddress" />
                    </div>

                    <div class="fieldcontain">
                        <label for="phoneNumber">
                            Phone Number
                        </label>
                        <input type="text" name="phoneNumber" readonly value="${asset.phoneNumber}" id="phoneNumber" />
                    </div>

                    <div class="fieldcontain">
                        <label for="keywords">
                            Keywords
                        </label>
                        <textarea name="keywords" readonly maxlength="1000" id="keywords" >${asset.keywords}</textarea>
                    </div>

                    <div class="fieldcontain">
                        <label for="dateCreated">
                            Date entered
                        </label>
                        <input type="text" name="dateCreated" readonly value="${asset.dateCreated}" id="dateCreated" />
                    </div>
                </fieldset>
            </form>
        </div>
    </body>
</html>