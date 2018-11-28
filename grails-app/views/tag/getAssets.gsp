<!DOCTYPE html>
<html>
<head>
    <title>TEST PROCHE REST API</title>
    <meta name="layout" content="basic">

    <!-- On smaller displays prevent browser from simply scaling our content to teeny, tiny sized. -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

<style>
section {
    width: 100vw;
    max-width: 100ch;

    margin: 0 auto;
    padding: 1.5em 1em;
}<</style>
</head>

<body>
<section>
    <p id="proche-assets"></p>
</section>

<script type="text/javascript">

getAssets( 'food' );

function getAssets( taggedBy ) {
    var xmlhttp = new XMLHttpRequest( );
//  var url = 'https://proche.abundantcommunityinitiative.org/tag?q=' + taggedBy
    var url = 'http://localhost:8080/Proche/tag?q=' + taggedBy

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
            /* The argument to hitMe is the div that defines the onclick. */
            rend += '<div class="proche-one-asset" id="' + asset.id + '" onclick="hitMe(this)">';

            /* We expect exactly TWO div elements within proche-one-asset. */
            /* We expect proche-asset-brief to be one of those two children. */
            rend += '<div class="proche-asset-brief" style="display:block;">';
            rend += '<div id="name" style="font-style: italic;">' + asset.name + '</div>';
            rend += '<div id="descr" style="margin-left: 1em; margin-right: 0.2em; margin-top:6px; margin-bottom:11px;">' + asset.shortDescription + '</div>';            rend += '</a>';
            rend += '</div>';

            /* We expect proche-asset-full to be the other child of proche-one-asset. */
            rend += '<div class="proche-asset-full" style="display:none;">';
            rend += '<div id="name" style="font-style: italic;">' + asset.name + '</div>';
            rend += '<div id="descr" style="margin-left: 1em; margin-right: 0.2em; margin-top:6px; margin-bottom:11px;">';
            rend += asset.description + '</br></br>ORGANIZATION is ' + asset.organization + '<br/><br/>';
//          rend += '<a href="https://proche.abundantcommunityinitiative.org/asset/view/' + asset.id + '">CLICK ME!</a>';
            rend += '<a href="http://localhost:8080/Proche/asset/viewPublic/' + asset.id + '">CLICK ME!</a>';
            rend += '</div>';
            rend += '</div>';
            rend += '</div>';
        }
        rend += '</div>';
        document.getElementById('proche-assets').innerHTML = rend;
    }
}

function hitMe( e ) {
    for( i = 0; i < e.children.length; i++ ) {
        var child = e.children[i];
        if( child.style.display == 'none' ) {
            child.style.display = 'block';
        } else {
            child.style.display = 'none';
        }
    }
}

function loadAsset( id ) {
//  window.location.assign( "https://proche.abundantcommunityinitiative.org/asset/view/" + id );
    window.location.assign( "http://localhost:8080/Proche/asset/view/" + id );
}

</script>
</body>
</html>