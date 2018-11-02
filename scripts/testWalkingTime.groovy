    def walkingTime( BigDecimal aLat, aLon, bLat, bLon ) {
       // For first go at this, simply calculate an arbitrary measure of distance
       def latDiff = aLat - bLat
       def lonDiff = aLon - bLon
       return (latDiff*latDiff + lonDiff*lonDiff) ** 0.5
    }

BigDecimal aLat = 53.0
BigDecimal aLon = 115.0
BigDecimal bLat = 54.0
BigDecimal bLon = 116.0

def r = walkingTime( aLat, aLon, bLat, bLon )
println "r is ${r}"
