package abcd

import grails.transaction.Transactional
import java.net.URLEncoder

@Transactional
class MapService {

    static private String googleApiKey = System.getenv("PROCHE_GOOGLE_API_KEY")
    static {
        if( googleApiKey ) {
            println "Picked up PROCHE_GOOGLE_API_KEY from environment"
        } else {
            throw new RuntimeException("Missing environment variable PROCHE_GOOGLE_API_KEY")
        }
    }

    String locateOnMap( asset ) {
        log.info "Creating Google Maps URL for ${asset} with location ${asset.location}"

        def url
        def loc = URLEncoder.encode( asset.location, "UTF-8" )
        def communityName = URLEncoder.encode( asset.community?.name?:"City Hall", "UTF-8" )

        if( loc.equalsIgnoreCase("N/A") || !loc ) {
            url = "https://maps.googleapis.com/maps/api/staticmap?center=${communityName},Edmonton,AB&zoom=15&size=900x900&maptype=roadmap&key=${googleApiKey}"
        } else {
            if( loc.endsWith("NW") ) {
                loc += ",Edmonton,AB,Canada"
            } else {
                def tail = loc.indexOf("+NW,")
                if( tail > 0 ) {
                    loc = loc.substring( 0, tail ) + "+NW,Edmonton,AB,Canada"
                } else {
                    loc += "+NW,Edmonton,AB,Canada"
                }
            }
            url = "https://maps.googleapis.com/maps/api/staticmap?center=${communityName},Edmonton,AB&zoom=15&size=900x900&maptype=roadmap&markers=color:red|${loc}&key=${googleApiKey}"
        }

        return url
    }
    
    def walkingTime( BigDecimal aLat, aLon, bLat, bLon ) {
       // For first go at this, simply calculate an arbitrary measure of distance
       def latDiff = aLat - bLat
       def lonDiff = aLon - bLon
       return (latDiff^2 + lonDif^2) ** 0.5
    }
}
