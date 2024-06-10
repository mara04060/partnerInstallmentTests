package task2;

import com.fasterxml.jackson.annotation.JsonProperty;

    public class ModelDocIds implements InterfaceJson {
        @JsonProperty("order_id")
        private String orderId;

        @JsonProperty("message_id")
        private String messageId;

        @JsonProperty("order_id")
        public String getOrderId() {
            return orderId;
        }

        @JsonProperty("order_id")
        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        @JsonProperty("message_id")
        public String getMessageId() {
            return messageId;
        }

        @JsonProperty("message_id")
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