package alertMonitor.utils.dispatchStrategy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.ToString;
import alertMonitor.enums.AlertType;
import alertMonitor.utils.config.ServiceEventAlertConfig;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, visible = true, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ConsoleAlert.class, name = "CONSOLE"),
        @JsonSubTypes.Type(value = EmailAlert.class, name = "EMAIL")
})
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
@Data
public abstract class Alert {
    private AlertType type;
    public abstract void dispatch(ServiceEventAlertConfig config);
}
