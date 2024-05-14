package alertMonitor.utils.eventProcessor;

import alertMonitor.services.repositoryServices.EventsRepositoryService;
import alertMonitor.utils.config.AlertConfig;
import alertMonitor.utils.config.WindowAlertConfig;

public class EventProcessorFactory {
    public static EventProcessor getEventProcessor(AlertConfig config, EventsRepositoryService eventsRepositoryService) {
        switch (config.getType()) {
            case SIMPLE_COUNT -> {
                return new SimpleEventProcessor(config, eventsRepositoryService);
            }
            case SLIDING_WINDOW -> {
                return new SlidingWindowEventProcessor((WindowAlertConfig) config, eventsRepositoryService);
            }
            case TUMBLING_WINDOW -> {
                return new TumblingWindowEventProcessor((WindowAlertConfig) config, eventsRepositoryService);
            }
            default -> throw new RuntimeException("No EventProcessor found for type " + config.getType());
        }
    }
}
