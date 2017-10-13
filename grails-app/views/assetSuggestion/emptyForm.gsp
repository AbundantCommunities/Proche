<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>Suggest a New Asset</title>

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
        <div id="edit-assetSuggestion" class="content scaffold-edit" role="main">
            <h1>Asset Suggestion (<a href="https://public.3.basecamp.com/p/qB5JKpEC5Yts3Tjk6L38wHnK">Help</a>)</h1>

            <form action="<g:createLink controller='AssetSuggestion' action='saveOffer'/>" method="POST">

                <fieldset class="form">

                    <div class="fieldcontain  required">
                        <label for="name">
                            Asset Name
                            <span class="required-indicator">*</span>
                        </label>
                        <input type="text" name="name" size="50" required="" value="" id="name" />
                    </div>

                    <div class="fieldcontain  required">
                        <label for="organization">
                            Organization
                            <span class="required-indicator">*</span>
                        </label>
                        <input type="text" name="organization" size="50" required="" value="" id="organization" />
                    </div>

                    <div class="fieldcontain  ">
                        <label for="zeroCost">
                            Free
                        </label>
                        <g:checkBox name="zeroCost" value=""/>
                    </div>

                    <div class="fieldcontain  required">
                        <label for="description">
                            Description
                            <span class="required-indicator">*</span>
                        </label>
                        <textarea name="description" maxlength="1000" required="" id="description" ></textarea>
                    </div>

                    <div class="fieldcontain">
                        <label for="schedule">
                            Schedule
                            <span class="required-indicator">&nbsp;</span>
                        </label>
                        <input type="text" name="schedule" size="70" value="" id="schedule" />
                    </div>

                    <div class="fieldcontain">
                        <label for="location">
                            Location
                            <span class="required-indicator">&nbsp;</span>
                        </label>
                        <input type="text" name="location" size="70" value="" id="location" />
                    </div>

                    <div class="fieldcontain">
                        <label for="url">
                            Web Page
                            <span class="required-indicator">&nbsp;</span>
                        </label>
                        <input type="text" name="url" size="70" value="" id="url" />
                    </div>

                    <div class="fieldcontain">
                        <label for="emailAddress">
                            Email Address
                            <span class="required-indicator">&nbsp;</span>
                        </label>
                        <input type="text" name="emailAddress" value="" id="emailAddress" />
                    </div>

                    <div class="fieldcontain">
                        <label for="phoneNumber">
                            Phone Number
                            <span class="required-indicator">&nbsp;</span>
                        </label>
                        <input type="text" name="phoneNumber" value="" id="phoneNumber" />
                    </div>

                    <div class="fieldcontain">
                        <label for="suggesterName">
                            YOUR Name
                            <span class="required-indicator">&nbsp;</span>
                        </label>
                        <input type="text" name="suggesterName" value="" id="suggesterName" />
                    </div>

                    <div class="fieldcontain">
                        <label for="suggesterContactInfo">
                            YOUR Contact Info
                            <span class="required-indicator">&nbsp;</span>
                        </label>
                        <input type="text" name="suggesterContactInfo" value="" id="suggesterContactInfo" />
                    </div>

                    <div class="fieldcontain">
                        <label for="suggesterComment">
                            YOUR Comments
                            <span class="required-indicator">&nbsp;</span>
                        </label>
                        <textarea name="suggesterComment" id="suggesterComment" ></textarea>
                    </div>
                </fieldset>

                <div class="g-recaptcha" data-sitekey="6LddMzMUAAAAAJFsqRBHKFWB0dCC1vvzJmX5yp6S"></div>

                <fieldset class="buttons">
                    <input type="submit" name="button" value="Submit" class="save" />
                </fieldset>
            </form>
        </div>
    </body>
</html>