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
        <div id="edit-asset" class="content scaffold-edit" role="main">
            <h1>Edit Asset</h1>
            <b>Categories</b>
            <table>
            <g:each in="${asset.categories}" var="category">
                <tr>
                    <td width="30%">
                        ${category.name}
                    </td>
                    <td width="70%">
                        ${category.description}
                    </td>
                </tr>
            </g:each>
            </table>

            <form action="<g:createLink action='save'/>" method="POST">

                <input type="hidden" name="id" value="${asset.id}" />
                <input type="hidden" name="version" value="${asset.version}" />

                <fieldset class="form">
                    <div>
                        <a href="<g:createLink action='editClassification' id='${asset.id}' />">Edit Classification</a>
                    </div>

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
                        </label>
                        <g:checkBox name="zeroCost" value="${asset.zeroCost}"/>
                    </div>

                    <div class="fieldcontain  required">
                        <label for="description">
                            Description
                            <span class="required-indicator">*</span>
                        </label>
                        <textarea name="description" maxlength="500" required="" id="description" >${asset.description}</textarea>
                    </div>

                    <div class="fieldcontain">
                        <label for="keywords">
                            Keywords
                            <span class="required-indicator">&nbsp;</span>
                        </label>
                        <textarea name="keywords" maxlength="300" id="keywords" >${asset.keywords}</textarea>
                    </div>

                    <div class="fieldcontain">
                        <label for="location">
                            Location
                            <span class="required-indicator">&nbsp;</span>
                        </label>
                        <input type="text" name="location" size="70" required="" value="${asset.location}" id="location" />
                        <a href="${mapLink}" target="_blank">Map</a>
                    </div>

                    <div class="fieldcontain">
                        <label for="community">
                            Community
                            <span class="required-indicator">*</span>
                        </label>
                        <g:select
                            id="community"
                            name='asset.community.id'
                            value="${asset.community?.id}"
                            noSelection="${['null':'Select One...']}"
                            from="${abcd.Community.list()}"
                            optionKey="id"
                            optionValue="name">
                        </g:select>
                    </div>

                    <div class="fieldcontain">
                        <label for="url">
                            Web Page
                            <span class="required-indicator">&nbsp;</span>
                        </label>
                        <input type="text" name="url" size="70" value="${asset.url}" id="url" />
                        <a href="${asset.url}" target="_blank">View</a>
                    </div>

                    <div class="fieldcontain">
                        <label for="emailAddress">
                            Email Address
                            <span class="required-indicator">&nbsp;</span>
                        </label>
                        <input type="email" name="emailAddress" value="${asset.emailAddress}" id="emailAddress" />
                    </div>

                    <div class="fieldcontain">
                        <label for="phoneNumber">
                            Phone Number
                            <span class="required-indicator">&nbsp;</span>
                        </label>
                        <input type="text" name="phoneNumber" value="${asset.phoneNumber}" id="phoneNumber" />
                    </div>
                </fieldset>

                <fieldset class="buttons">
                    <input type="submit" name="button" value="Submit" class="save" />
                </fieldset>
            </form>
        </div>
    </body>
</html>