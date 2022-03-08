package jdev;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by jenia on 06.03.22.
 */
public class GPSPoint {
    private double lat;
    private double lon;
    private double azimuth;
    private double speed;

    public GPSPoint() {
        this.lat = 0;
        this.lon = 0;
        this.azimuth = 0;
        this.speed = 0;
    }

    public GPSPoint(double lat, double lon, double azimuth, double speed) {
        this.lat = lat;
        this.lon = lon;
        this.azimuth = azimuth;
        this.speed = speed;
    }


    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public double getAzimuth() {
        return azimuth;
    }

    public double getSpeed() {
        return speed;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public void setAzimuth(double azimuth) {
        this.azimuth = azimuth;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }


    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

    public void gpsRandom() {
        double rnd = Math.random();
        double pointLat = getLat() + rnd/100;
        double pointLon = getLon() - rnd/100;
        double pointAzimuth = getAzimuth() + rnd/100;
        double pointSpeed = getSpeed() + rnd - 0.5;
        setLat(Math.ceil(pointLat*1000)/1000);
        setLon(Math.ceil(pointLon*1000)/1000);
        setAzimuth(Math.ceil(pointAzimuth*1000)/1000);
        setSpeed(Math.ceil(pointSpeed*1000)/1000);

    }

    public static GPSPoint decodeGPS(String string) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(string, GPSPoint.class);
    }


    @Override
    public String toString() {
        return "GPSPoint{" +
                "lat=" + lat +
                ", lon=" + lon +
                ", azimuth=" + azimuth +
                ", speed=" + speed +'}';
    }
}
