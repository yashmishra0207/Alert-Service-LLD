package alertMonitor.utils.eventProcessor;

import alertMonitor.entities.Event;
import alertMonitor.services.repositoryServices.EventsRepositoryService;
import alertMonitor.utils.config.AlertConfig;

public class SimpleEventProcessor extends EventProcessor {
    AlertConfig config;
    public SimpleEventProcessor(AlertConfig config, EventsRepositoryService eventsRepositoryService) {
        super(eventsRepositoryService);
        this.config = config;
    }

    @Override
    public Boolean isThresholdReached(Event event) {
        Boolean thresholdExceeded = eventsRepositoryService.countAllOccurrences(event) > config.getCount();
        if (thresholdExceeded) {
            reset();
        }
        return thresholdExceeded;
    }

    private void reset() {
        // TODO: have some reset logic else every event, after the threshold is reached, will generate alert.
        //  This will ultimately result in noise
    }

    @Override
    public void processEvent(Event event) {
        eventsRepositoryService.saveTimeToEvent(event);
    }
}
