package jdev.Service;

import jdev.GPSPoint;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by jenia on 06.03.22.
 */
public class GPSSimService {
    private static final Logger log = LoggerFactory.getLogger(GPSSimService.class);

    GPSPoint point = new GPSPoint(54.25, 48.15, 35.2, 36.5);
    private BlockingDeque<GPSPoint> queue =  new LinkedBlockingDeque<>(100);

    @Scheduled (fixedDelay = 2_000)
    void take() throws JsonProcessingException, InterruptedException {
        log.info(point.toJson());
        queue.take();
    }

    @Scheduled (fixedDelay = 1_000)
    void put() throws InterruptedException {
        point.gpsRandom();
        queue.put(point);
    }
}
