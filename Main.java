package alertMonitor;

import alertMonitor.repositories.EventRepository;
import alertMonitor.entities.Event;
import alertMonitor.enums.Client;
import alertMonitor.enums.EventType;
import alertMonitor.services.MonitoringService;
import alertMonitor.services.AlertingService;
import alertMonitor.services.repositoryServices.EventsRepositoryService;

import java.io.IOException;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        EventsRepositoryService eventsRepositoryService = new EventsRepositoryService(new EventRepository());
        AlertingService alertingService = AlertingService.getInstance();
        MonitoringService monitoringService;
        try {
            monitoringService = MonitoringService.getInstance(eventsRepositoryService, alertingService);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        LocalDateTime currentTime = LocalDateTime.now();

        monitoringService.processEvent(Event.builder().client(Client.X).eventType(EventType.PAYMENT_SERVICE_EXCEPTION).eventTime(currentTime.minusSeconds(10)).build());
        monitoringService.processEvent(Event.builder().client(Client.Y).eventType(EventType.PAYMENT_SERVICE_EXCEPTION).eventTime(currentTime.minusSeconds(8)).build());
        monitoringService.processEvent(Event.builder().client(Client.X).eventType(EventType.PAYMENT_SERVICE_EXCEPTION).eventTime(currentTime.minusSeconds(7)).build());
        monitoringService.processEvent(Event.builder().client(Client.X).eventType(EventType.PAYMENT_SERVICE_EXCEPTION).eventTime(currentTime.minusSeconds(6)).build());
        monitoringService.processEvent(Event.builder().client(Client.X).eventType(EventType.PAYMENT_SERVICE_EXCEPTION).eventTime(currentTime.minusSeconds(5)).build());
        monitoringService.processEvent(Event.builder().client(Client.X).eventType(EventType.USER_SERVICE_EXCEPTION).eventTime(currentTime.minusSeconds(4)).build());
        monitoringService.processEvent(Event.builder().client(Client.X).eventType(EventType.USER_SERVICE_EXCEPTION).eventTime(currentTime.minusSeconds(3)).build());
        monitoringService.processEvent(Event.builder().client(Client.X).eventType(EventType.USER_SERVICE_EXCEPTION).eventTime(currentTime.minusSeconds(2)).build());
        monitoringService.processEvent(Event.builder().client(Client.X).eventType(EventType.UNAUTHORIZED_EXCEPTION).eventTime(currentTime.minusSeconds(2)).build());
        monitoringService.processEvent(Event.builder().client(Client.X).eventType(EventType.UNAUTHORIZED_EXCEPTION).eventTime(currentTime.minusSeconds(1)).build());
    }
}
