package alertMonitor.utils.config;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import alertMonitor.enums.AlertStrategy;
import alertMonitor.services.repositoryServices.EventsRepositoryService;

import java.io.Serializable;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, visible = true, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = SlidingWindowAlertConfig.class, name = "SLIDING_WINDOW"),
        @JsonSubTypes.Type(value = TumblingWindowAlertConfig.class, name = "TUMBLING_WINDOW"),
        @JsonSubTypes.Type(value = SimpleAlertConfig.class, name = "SIMPLE_COUNT"),
})
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public abstract class AlertConfig implements Serializable {
    private AlertStrategy type;
    private Integer count;
}
