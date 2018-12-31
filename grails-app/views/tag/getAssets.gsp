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
    <h3>Job Training Opportunities</h3>
    <p id="proche-assets"></p>
</section>

<script type="text/javascript">

getAssets( '${tagName}' );

function getAssets( taggedBy ) {
    var xmlhttp = new XMLHttpRequest( );
    var url = 'https://proche.abundantcommunityinitiative.org/tag?q=' + taggedBy

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
            rend += '<div class="proche-asset-brief" style="display:block;" onmouseover="highlightMe(this)" onmouseout="downplayMe(this)">';
            rend += '<div id="name" style="font-style: italic;">' + asset.name + '</div>';
            rend += '<div id="descr" style="margin-left: 1em; margin-right: 0.2em; margin-top:6px; margin-bottom:8px;">';
            rend += asset.shortDescription + '<span style="color:red;"> Click for more</span>';
            rend += '</div>'; // descr
            rend += '</div>'; // proche-asset-brief

            /* We expect proche-asset-full to be the other child of proche-one-asset. */
            rend += '<div class="proche-asset-full" style="display:none;" onmouseover="highlightMe(this)" onmouseout="downplayMe(this)">';
            rend += '<div id="name" style="font-style: italic;">' + asset.name + '</div>';
            rend += '<div id="descr" style="margin-left: 1em; margin-right: 0.2em; margin-top:6px; margin-bottom:8px;">';
            rend += asset.description + '</br></br>';
            if( asset.zeroCost ) {
                rend += 'Offered for FREE by ';
            } else {
                rend += 'Run by ';
            }
            rend += asset.organization + '. ';
            rend += '<a href="https://proche.abundantcommunityinitiative.org/asset/viewPublic/' + asset.id + '">';
            rend += 'Click for contact info</a><br/><br/>';
            rend += '</div>'; // descr
            rend += '</div>'; // proche-asset-full
            
            rend += '</div>'; // proche-one-asset
        }
        rend += '</div>';
        document.getElementById('proche-assets').innerHTML = rend;
    }
}

function highlightMe( e ) {
    e.style.background = "#D8ECF3";
}

function downplayMe( e ) {
        e.style.background = "inherit";
}

// We expect e to be a div element with exactly two children. One child has a display value
// of 'block', the other 'none' (none --> invisible). We will toggle the two values of display,
// so that the invisible one becomes visible (display: 'block') and the other becomes invisible.
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

</script>
</body>
</html>
