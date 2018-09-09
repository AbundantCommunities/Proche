import csv
import json
import requests


from time import sleep

urlTempl = 'http://maps.googleapis.com/maps/api/geocode/json?address=%(address)s&sensor=false'
print "Template for Google API request: ", urlTempl

with open('cuDataLoad.csv', 'rb') as csvfile:
    rdr = csv.reader( csvfile )
    for row in rdr:
        title = row[0]
        organization = row[1]
        line = row[2]

        # Avoid Google Maps returning body = {"results": [], "status" : "OVER_QUERY_LIMIT"}
        # Sleep 250 msec:
        sleep( 0.25 )

        if( line == "N/A" ):
            continue

        line = line.replace( " ", "+" )
        if line.find("+NW") == -1 :
            # there is no NW in the address
            line += "+NW,Edmonton,AB"

        elif line.find("Edmonton") == -1:
            # There is NW but no Edmonton in the address
            line += ",Edmonton,AB"

        r = requests.get( urlTempl % {'address': line} )
        if r.status_code == requests.codes.ok:
            jsdict = json.loads( r.text )
            if len(jsdict['results']) < 1:
                print 'WTF??', row
                print r
                print r.text
            else:
                location = jsdict['results'][0]['geometry']['location']
                lat = location['lat']
                lng = location['lng']
                print '"{title}","{organization}","{address}","{latitude}","{longitude}"'.format( title=title, organization=organization, address=line, latitude=lat, longitude=lng )
        else:
            print 'Requests returned status', r.status_code
            print 'Address =', line

#end