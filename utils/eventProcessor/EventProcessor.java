package alertMonitor.utils.eventProcessor;

import lombok.RequiredArgsConstructor;
import alertMonitor.entities.Event;
import alertMonitor.services.repositoryServices.EventsRepositoryService;

@RequiredArgsConstructor
public abstract class EventProcessor {
    public EventsRepositoryService eventsRepositoryService;

    public EventProcessor(EventsRepositoryService eventsRepositoryService) {
        this.eventsRepositoryService = eventsRepositoryService;
    }

    public abstract Boolean isThresholdReached(Event event);

    public abstract void processEvent(Event event);
}
