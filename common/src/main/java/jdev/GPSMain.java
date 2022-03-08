package jdev;

import java.io.IOException;

import static jdev.GPSPoint.*;

/**
 * Created by jenia on 08.03.22.
 */
public class GPSMain {
    public static void main(String[] args) throws IOException {
        String expected = "{\"lat\":54.289,\"lon\":48.118,\"azimuth\":35.239,\"speed\":36.457}";

        System.out.println(decodeGPS(expected));
    }
}
