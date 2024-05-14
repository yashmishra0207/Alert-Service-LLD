package alertMonitor.utils.dispatchStrategy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import alertMonitor.utils.config.ServiceEventAlertConfig;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmailAlert extends Alert {
    private String subject;
    @Override
    public void dispatch(ServiceEventAlertConfig config) {
//        System.out.println("Dispatching to Email");
    }
}
