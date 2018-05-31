<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New Category</title>
    <meta name="layout" content="main">
</head>

<body>
    <div id="edit-assetSuggestion" class="content scaffold-edit" role="main">
        <h1>Enter New Category</h1>

        <form action="<g:createLink action='save'/>" method="POST">

            <fieldset class="form">

                <div class="fieldcontain required">
                    <label for="name">
                        Category Name
                        <span class="required-indicator">*</span>
                    </label>
                    <input type="text" name="name" size="50" autofocus="yup" required value="" id="name" />
                </div>

                <div class="fieldcontain required">
                    <label for="description">
                        Description
                        <span class="required-indicator">*</span>
                    </label>
                    <textarea name="description" maxlength="1000" required id="description" ></textarea>
                </div>
                <br/>

            <fieldset class="buttons">
                <input type="submit" name="button" value="Submit" class="save" />
            </fieldset>
        </form>
    </div>
</body>
</html>
