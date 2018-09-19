@Grab('com.xlson.groovycsv:groovycsv:1.1')
import static com.xlson.groovycsv.CsvParser.parseCsv

def csvFile = new File('goodOsmCoords.csv')
// const, assetId, latitude, longitude

csvFile.withReader{ reader ->
	def homes = parseCsv( reader )
	for(home in homes) {
		// home is a com.xlson.groovycsv.PropertyMapper
		// home.columns is [const:0,  assetId:1,  longitude:2,  latitude:3]
		// home.values is like [%COORD,  1018,  53.6039795357143,  -113.377735078571]
		println "${home.values[1]} is at [${home.values[2]},${home.values[3]}]"
	}
}
