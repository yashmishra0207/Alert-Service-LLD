package alertMonitor.utils.eventProcessor;

import alertMonitor.entities.Event;
import alertMonitor.services.repositoryServices.EventsRepositoryService;
import alertMonitor.utils.config.WindowAlertConfig;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.PriorityQueue;

public class TumblingWindowEventProcessor extends WindowEventProcessor {

    public TumblingWindowEventProcessor(WindowAlertConfig config, EventsRepositoryService eventsRepositoryService) {
        super(config, eventsRepositoryService);
    }

    private LocalDateTime getStartTime() {
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime midNight = currentTime.toLocalDate().atStartOfDay();
        Integer noOfTumblesTillNow = (int) (Duration.between(midNight, currentTime).getSeconds() / config.getWindowSizeInSecs());
        return midNight.plusSeconds((long) noOfTumblesTillNow * config.getWindowSizeInSecs());
    }

    @Override
    public Boolean isThresholdReached(Event event) {
        LocalDateTime startTime = getStartTime();
        LocalDateTime endTime = startTime.plusSeconds(config.getWindowSizeInSecs());
        return eventsRepositoryService.countAllOccurrencesBetween(event, startTime, endTime) > config.getCount();
    }
}
