package abcd

import grails.transaction.Transactional
import java.net.URLEncoder

@Transactional
class MapService {

    String locateOnMap( String loc ) {
        if( loc.endsWith("NW") ) {
            loc += ", Edmonton, AB, Canada"
        } else {
            def tail = loc.indexOf(" NW,")
            if( tail > 0 ) {
                loc = loc.substring( 0, tail ) + " NW, Edmonton, AB, Canada"
            } else {
                loc += " NW, Edmonton, AB, Canada"
            }
        }
        log.info "Created Google Maps link for ${loc}"
        loc = URLEncoder.encode(loc, "UTF-8")
        return "https://www.google.ca/maps/place/${loc}"
    }
    
    def walkingTime( BigDecimal aLat, aLon, bLat, bLon ) {
       // For first go at this, simply calculate an arbitrary measure of distance
       def latDiff = aLat - bLat
       def lonDiff = aLon - bLon
       return (latDiff^2 + lonDif^2) ** 0.5
    }
}
