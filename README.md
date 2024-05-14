# Monitoring and Alert Service

Functional Requirements doc - [Click Here](https://docs.google.com/document/d/18sZVKPpOHt-IfaB4y4JNezmkjouANNmLK0I2k8XxTZY/edit)

NOTE:
- On running program, in case of Event having TUMBLING_WINDOW alert strategy, the possibility of threshold breach will be intermittent because of the way in which tumbling window works. <br/>Running 2-3 times will show the threshold breached log for such case (i.e. Client X USER_SERVICE_EXCEPTION).

Areas of Improvements:
- In a real-world scenario having a queue is a must to handle incoming requests as it’s a central service used by multiple services, so it can have high number of concurrent requests.
