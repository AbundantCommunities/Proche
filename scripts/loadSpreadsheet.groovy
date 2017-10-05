@Grab('com.xlson.groovycsv:groovycsv:1.2')
import static com.xlson.groovycsv.CsvParser.parseCsv
import groovy.sql.Sql

String left( String s, Integer max ) {
    if( s.length() <= max ) {
        s
    } else {
        s.getAt(0..(max-1))
    }
}

println "Which table, Asset or AssetSuggestion?"
def tableName = System.in.newReader().readLine()

db = Sql.newInstance( 'jdbc:postgresql://localhost/abcd', 'myapp', 'sloj92GOM', 'org.postgresql.Driver' )

def csvFile = new File('abcdAssets.csv')

long pk = 0

csvFile.withReader{ reader ->
    def assets = parseCsv( reader )
    for(asset in assets) {
        String suggesterName = asset[1]
        String suggesterContactInfo = asset[2]
        String suggesterComment = left( asset[12], 2000 )  //  embedded shit?
        String name = left( asset[3].replace( "'", "''" ), 255 )
        String description = left( asset[6].replace( "'", "''"), 1000 )
        String organization = asset[4]
        String location = asset[5]
        Boolean zeroCost = asset[7].equals('Free')       // check for NEITHER !
        String phoneOrEmail = asset[9]
        String url = left( asset[10], 2000 )
        String schedule = left( asset[8], 255 )    // CRAP
        def dateCreated = new Date().parse('MM/dd/yyyy hh:mm:ss', asset[0]).toTimestamp()

        String emailAddress
        String phoneNumber

        if( phoneOrEmail.contains('@') ) {
            emailAddress = phoneOrEmail
            phoneNumber = ''
        } else {
            emailAddress = ''
            phoneNumber = phoneOrEmail
        }
        switch( tableName.toLowerCase() ) {
        case "asset":
            db.execute """
            INSERT INTO asset( id, version, name, description,
                organization, location, zero_cost, phone_number, email_address, url,
                schedule, keywords, date_created, last_updated )
            VALUES
                ( ${++pk}, 0, ${name}, ${description},
                ${organization}, ${location}, ${zeroCost}, ${phoneNumber}, ${emailAddress}, ${url},
                ${schedule}, '', ${dateCreated}, CURRENT_TIMESTAMP );
            """
            break
        case "assetsuggestion":
            db.execute """
            INSERT INTO asset_suggestion( id, version, name, description,
                organization, location, zero_cost, phone_number, email_address, url,
                schedule, keywords, date_created, last_updated,
                administrator_comment, resolution, suggester_comment,
                suggester_contact_info, suggester_name )
            VALUES
                ( ${++pk}, 0, ${name}, ${description},
                ${organization}, ${location}, ${zeroCost}, ${phoneNumber}, ${emailAddress}, ${url},
                ${schedule}, '', ${dateCreated}, CURRENT_TIMESTAMP,
                'no admin comment', 'N', 'no suggester comment',
                'suggester contact info', 'suggester name' );
            """
        }
    }
}

println "Loaded ${pk} rows to ${tableName}"
db.connection.close( )
