package task2.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import task2.InterfaceJson;

public class DocIdsData implements InterfaceJson {
        @JsonProperty("order_id")
        private String orderId;

        @JsonProperty("message_id")
        private String messageId;

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getMessageId() {
            return messageId;
        }

        public void setMessageId(String messageId) {
            this.messageId = messageId;
        }

        @Override
        public String toString() {
            return "\t /* ModelOrderIsCard */  {" +
                    "\n \t \t order_id: '" + orderId + '\'' +
                    ", \n \t \t message_id: '" + messageId + '\'' +
                    "\n \t }";
        }
    }