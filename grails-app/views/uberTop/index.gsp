<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Communities United Public Assets</title>

    <meta name="layout" content="main">
</head>

<body>
    <h1>Public Assets in Bannerman, Clareview Campus, Fraser, Hairsine & Kirkness</h1>
    <br/>
    <p>
        This website is not ready for general use.
        We are building up a list of
        <a href="https://en.wikipedia.org/wiki/Asset-based_community_development">assets</a>
        that anyone living in Bannerman, Clareview, Fraser, Hairsine or Kirkness can take
        advantage of.
    </p>
    <br/>
    <p>
        We have ${assetCount} assets on file so far.
        Use the links above to have a look at them
        or to <em>suggest an asset we don't have</em>.
    </p>
    <br/>
    <g:if test="${suggestionCount>0}">
        <p>We have ${suggestionCount} suggestions waiting for approval.</p>
    </g:if>
</body>
</html>
