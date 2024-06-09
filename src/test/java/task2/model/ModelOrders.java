package task2.model;

import task2.ServiceData;

import java.util.ArrayList;

public class ModelOrders {
        private String orderId;
        private String messageId;
        private String statusCode;
        private String statusText;

        private String orderVat;
        private String orderSum;
        private String cancelId;
        private String reasonCancel;
        private ArrayList<Object> orderNom;
        private String orderTerm;
        private String panEnd;

        private String mPhone;
        private String shopId;

        private String orderAdd;
        private String eMailPartner;
        private String callBackURL;


        public ModelOrders(){};

        public ModelOrders( String orderId,
                            String messageId,
                            String statusText,
                            String statusCode){
                this.orderId = orderId;
                this.messageId = messageId;
                this.statusText = statusText;
                this.statusCode = statusCode;
        }
        public ModelOrders(String orderId,
                           String messageId,
                           String cancelId,
                           String reasonCancel,
                           String statusCode) {
            this.orderId = orderId;
            this.messageId = messageId;
            this.statusCode = statusCode;
            this.cancelId = cancelId;
            this.reasonCancel = reasonCancel;
        }
        public ModelOrders (String mPhone,
                              String panEnd,
                              String shopId,
                              String orderId,
                              String orderSum,
                              String orderTerm,
                              String eMailPartner,
                              String callBackURL) {
                this.mPhone = mPhone;
                this.panEnd = panEnd;
                this.shopId = shopId;
                this.orderId = orderId;
                this.orderSum = orderSum;
                this.orderTerm = orderTerm;
                this.eMailPartner = eMailPartner;
                this.callBackURL = callBackURL;
        }

        public ModelOrders(
                String orderId,
                String messageId,
                String statusText,
                String statusCode,
                String orderTerm,
                String panEnd,
                String orderVat,
                String orderSum,
                String mPhone,
                String shopId,
                ArrayList<Object> orderNom,
                String orderAdd
        ) {
                this.orderAdd = orderAdd;
                this.orderId = orderId;
                this.messageId = messageId;
                this.orderVat = orderVat;
                this.orderSum = orderSum;
                this.orderNom = orderNom;
                this.orderTerm = orderTerm;
                this.panEnd = panEnd;
                this.statusText = statusText;
                this.mPhone = mPhone;
                this.shopId = shopId;
                this.statusCode = statusCode;
        }



    public ModelOrders(String orderId, String messageId, String statusText, ServiceData.StatusCode cancelIsOk) {
    }

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

        public String getStatusCode() {
                return statusCode;
        }

        public void setStatusCode(String statusCode) {
                this.statusCode = statusCode;
        }

        public String getStatusText() {
                return statusText;
        }

        public void setStatusText(String statusText) {
                this.statusText = statusText;
        }

        public String getOrderVat() {
                return orderVat;
        }

        public void setOrderVat(String orderVat) {
                this.orderVat = orderVat;
        }

        public String getOrderSum() {
                return orderSum;
        }

        public void setOrderSum(String orderSum) {
                this.orderSum = orderSum;
        }

        public String getCancelId() {
                return cancelId;
        }

        public void setCancelId(String cancelId) {
                this.cancelId = cancelId;
        }

        public String getReasonCancel() {
                return reasonCancel;
        }

        public void setReasonCancel(String reasonCancel) {
                this.reasonCancel = reasonCancel;
        }

        public ArrayList<Object> getOrderNom() {
                return orderNom;
        }

        public void setOrderNom(ArrayList<Object> orderNom) {
                this.orderNom = orderNom;
        }

        public String getOrderTerm() {
                return orderTerm;
        }

        public void setOrderTerm(String orderTerm) {
                this.orderTerm = orderTerm;
        }

        public String getPanEnd() {
                return panEnd;
        }

        public void setPanEnd(String panEnd) {
                this.panEnd = panEnd;
        }

        public String getmPhone() {
                return mPhone;
        }

        public void setmPhone(String mPhone) {
                this.mPhone = mPhone;
        }

        public String getShopId() {
                return shopId;
        }

        public void setShopId(String shopId) {
                this.shopId = shopId;
        }

        public String getOrderAdd() {
                return orderAdd;
        }

        public void setOrderAdd(String orderAdd) {
                this.orderAdd = orderAdd;
        }

        public String geteMailPartner() {
                return eMailPartner;
        }

        public void seteMailPartner(String eMailPartner) {
                this.eMailPartner = eMailPartner;
        }

        public String getCallBackURL() {
                return callBackURL;
        }

        public void setCallBackURL(String callBackURL) {
                this.callBackURL = callBackURL;
        }

        @Override
        public String toString() {
                return "ModelOrders{" +
                        ( orderId != null && !orderId.isEmpty() && ! orderId.equals("null")  ? "orderId='" + orderId + "\', " : "" ) +
                        ( messageId != null && !messageId.isEmpty() && ! orderId.equals("null") ? "messageId='" + messageId + "\', " : "" ) +
                        ( statusCode != null && !statusCode.isEmpty() ? "statusCode='" + statusCode + "\', " : "" ) +
                        ( statusText != null && !statusText.isEmpty() ? "statusText='" + statusText + "\', " : "" ) +
                        ( orderVat != null && !orderVat.isEmpty() ? "orderVat='" + orderVat + "\', " : "" ) +
                        ( orderSum != null && !orderSum.isEmpty() ?"orderSum='" + orderSum +  "\', " : "" ) +
                        ( orderNom != null && !orderNom.isEmpty() ?"rderNom=" + orderNom : "") +
                        ( orderTerm != null && !orderTerm.isEmpty() ?"orderTerm='" + orderTerm +  "\', " : "" ) +
                        ( panEnd != null && !panEnd.isEmpty() ?"panEnd='" + panEnd +  "\', " : "" ) +
                        ( mPhone != null && !mPhone.isEmpty() ?"mPhone='" + mPhone +  "\', " : "" ) +
                        ( shopId != null && !shopId.isEmpty() ?"shopId='" + shopId +  "\', " : "" ) +
                        ( orderAdd != null && !orderAdd.isEmpty() ?"orderAdd='" + orderAdd +  "\', " : "" ) +
                        ( eMailPartner != null && !eMailPartner.isEmpty() ?"eMailPartner='" + eMailPartner + "\', " : "" ) +
                        ( callBackURL != null && !callBackURL.isEmpty() ?"callBackURL='" + callBackURL +  "\', " : "" ) +
                        ( cancelId != null && !cancelId.isEmpty() ?"cancelId='" + cancelId +  "\', " : "" ) +
                        ( reasonCancel != null && !reasonCancel.isEmpty() ?"reasonCancel='" + reasonCancel +  "\', " : "" ) +
                        '}';
        }

}
