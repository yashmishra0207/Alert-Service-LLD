package alertMonitor.utils.dispatchStrategy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import alertMonitor.services.LoggerService;
import alertMonitor.utils.config.ServiceEventAlertConfig;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConsoleAlert extends Alert implements LoggerService {
    private String message;
    @Override
    public void dispatch(ServiceEventAlertConfig config) {
        logSourceWarning(message, "Alert");
    }
}
