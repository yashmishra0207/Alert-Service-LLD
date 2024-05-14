package alertMonitor.utils.config;

import lombok.*;
import alertMonitor.enums.Client;
import alertMonitor.enums.EventType;
import alertMonitor.utils.dispatchStrategy.Alert;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class ServiceEventAlertConfig {
    private Client client;
    private EventType eventType;
    private AlertConfig alertConfig;
    private List<Alert> dispatchStrategyList;
}
