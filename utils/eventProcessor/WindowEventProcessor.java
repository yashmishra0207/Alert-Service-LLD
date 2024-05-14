package alertMonitor.utils.eventProcessor;

import lombok.RequiredArgsConstructor;
import alertMonitor.entities.Event;
import alertMonitor.services.repositoryServices.EventsRepositoryService;
import alertMonitor.utils.config.WindowAlertConfig;

@RequiredArgsConstructor
public abstract class WindowEventProcessor extends EventProcessor {
    public WindowAlertConfig config;

    public WindowEventProcessor(WindowAlertConfig config, EventsRepositoryService eventsRepositoryService) {
        super(eventsRepositoryService);
        this.config = config;
    }

    @Override
    public void processEvent(Event event) {
        eventsRepositoryService.saveEventToTime(event);
    }
}
