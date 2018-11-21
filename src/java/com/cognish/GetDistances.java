package com.cognish;

import com.google.maps.DirectionsApi;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.LatLng;
import com.google.maps.model.TravelMode;
import java.io.IOException;
import java.time.Instant;

public class GetDistances {
    
    public static void main( String[] argv ) {
        System.out.println("hi");
    }

    private static final String API_KEY = "YOUR_API_KEY";

    GeoApiContext context = new GeoApiContext.Builder()
		    .apiKey(API_KEY)
		    .build();

//    private static final GeoApiContext context = new GeoApiContext().setApiKey(API_KEY);


    public DistanceMatrix estimateRouteTime(Instant time, Boolean calculateArrivalTime, DirectionsApi.RouteRestriction routeRestriction, LatLng departure, LatLng... arrivals) {
        try {
            DistanceMatrixApiRequest req = DistanceMatrixApi.newRequest(context);
            if (calculateArrivalTime) {
                req.departureTime(time);
            } else {
                req.arrivalTime(time);
            }
            if (routeRestriction == null) {
                routeRestriction = DirectionsApi.RouteRestriction.TOLLS;
            }
            DistanceMatrix trix = req.origins(departure)
                    .destinations(arrivals)
                    .mode(TravelMode.DRIVING)
                    .avoid(routeRestriction)
                    .language("fr-FR")
                    .await();
            return trix;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}