package alertMonitor.services;

import alertMonitor.utils.config.ServiceEventAlertConfig;

public class AlertingService implements LoggerService {
    private static volatile AlertingService INSTANCE;

    public static AlertingService getInstance() {
        if (INSTANCE == null) {
            synchronized (AlertingService.class) {
                if (INSTANCE == null)
                    INSTANCE = new AlertingService();
            }
        }
        return INSTANCE;
    }

    private AlertingService() {
    }

    public void triggerAlert(ServiceEventAlertConfig config) {
        config.getDispatchStrategyList().forEach(dispatchStrategy -> {
            switch(dispatchStrategy.getType()) {
                case CONSOLE -> logInfo("Dispatching to Console");
                case EMAIL -> logInfo("Dispatching an Email");
                default -> {
                    logWarning("Unknown Dispatch strategy -> " + dispatchStrategy);
                    return;
                }
            }
            dispatchStrategy.dispatch(config);
        });
    }
}
