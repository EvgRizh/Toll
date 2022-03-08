package jdev.gps;


import com.fasterxml.jackson.databind.ObjectMapper;
import jdev.GPSPoint;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by jdev on 06.03.2017.
 */
public class GPSPointTest {

    private String expected = "{\"lat\":54.289,\"lon\":48.118,\"azimuth\":35.239,\"speed\":36.457}";
    private double speed = 36.457;

    @Test
    public void toJson() throws Exception {
        GPSPoint point = new GPSPoint(54.289, 48.118, 35.239, 36.457);
        assertTrue(point.toJson().contains("\"lat\":54.289"));
        assertTrue(point.toJson().contains("\"speed\":36.457"));
        System.out.println(point.toJson());
    }

    @Test
    public void decodeGPS() throws Exception {
        GPSPoint point = GPSPoint.decodeGPS(expected);
        assertTrue(speed == point.getSpeed());
    }
}