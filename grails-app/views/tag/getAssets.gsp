<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="basic">
    <title>TEST PROCHE REST API</title>

</head>

<body>
<form>
    <select id="tagSelect" name="tagName" onchange="getAssets()">
      <option value="easter-egg">Select a tag...
      <option value="food">Food
      <option value="training">Training
      <option value="after-school">After school
    </select>
</form>
<p id="cool"></p>

<script type="text/javascript">
function getAssets() {
    var tagSelected = document.getElementById('tagSelect').value;
    var xmlhttp = new XMLHttpRequest( );
    var url = 'https://proche.abundantcommunityinitiative.org/tag?q=' + tagSelected

    xmlhttp.onreadystatechange = function( ) {
        if( xmlhttp.readyState == 4 /* && xmlhttp.status == 200 */ ) {
            var assets = JSON.parse( xmlhttp.responseText );
            displayAssets( assets );
        }
    };

    xmlhttp.open( "GET", url, true );
    xmlhttp.send( );

    function displayAssets( assets ) {
        var rend = '<div style="font-family: Arial, Helvetica, sans-serif;">';
        for( i = 0; i < assets.length; i++ ) {
            var asset = assets[i];
            /* The argument to hitMe is the div that defines the onclick */
            rend += '<div id="' + asset.id + '" onclick="hitMe(this)">';
            rend += '<div id="name" style="font-style: italic;">' + asset.name + '</div>';
            rend += '<div id="descr" style="width: 450px; margin-left: 50px; margin-top:6px; margin-bottom:11px;">' + asset.shortDescription + '</div>';            rend += '</a>';
            rend += '</div>';
        }
        rend += '</div>';
        document.getElementById('cool').innerHTML = rend;
    }
}

function hitMe( e ) {
    window.location.assign( "https://proche.abundantcommunityinitiative.org/asset/view/" + e.id );
}
</script>
</body>
</html>