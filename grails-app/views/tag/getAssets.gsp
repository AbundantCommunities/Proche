<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="basic">
    <title>TEST PROCHE REST API</title>

</head>

<body>
<form>
    <select id="mySelect" onchange="getAssets()">
      <option value="easter-egg">Select a tag...
      <option value="food">Food
      <option value="training">Training
      <option value="after-school">After school
    </select>
</form>
<p id="cool"></p>

<script type="text/javascript">
function getAssets() {
    var xmlhttp = new XMLHttpRequest( );
    var url = 'https://proche.abundantcommunityinitiative.org/tag?q=food'

    xmlhttp.onreadystatechange = function( ) {
        if( xmlhttp.readyState == 4 /* && xmlhttp.status == 200 */ ) {
            var assets = JSON.parse( xmlhttp.responseText );
            displayAssets( assets );
        }
    };

    xmlhttp.open( "GET", url, true );
    xmlhttp.send( );

    function displayAssets( assets ) {
        var outString = "";
        for( i = 0; i < assets.length; i++ ) {
            var asset = assets[i];
            outString += "<b>" + asset.name + "</b><br/>";
            outString += "<i>&nbsp;&nbsp;&nbsp;&nbsp;" + asset.shortDescription + "</i><br/><br/>";
        }
        document.getElementById('cool').innerHTML = outString;
    }
}
</script>
</body>
</html>