package alertMonitor.entities;

import lombok.*;
import alertMonitor.enums.Client;
import alertMonitor.enums.EventType;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@EqualsAndHashCode(of = {"client", "eventType"}) // Uniqueness of an Event is determined combined by client and eventType
@ToString
@Builder
public class Event implements Serializable {
    private Client client;
    private EventType eventType;
    private LocalDateTime eventTime;
}
