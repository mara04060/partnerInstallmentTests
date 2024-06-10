package task2.pojo;
import com.fasterxml.jackson.annotation.JsonProperty;
import task2.InterfaceJson;

import java.util.Arrays;

public class CardData implements InterfaceJson {
        @JsonProperty("isCardAccount")
        private Boolean isCardAccount;

        @JsonProperty("data")
        private DocIdsData data;

        @JsonProperty("isRevaluation")
        private Boolean isRevaluation;

        @JsonProperty("userId")
        private Integer userId;

        @JsonProperty("userLogin")
        private String userLogin;

        @JsonProperty("docIds")
        private Integer[] docIds;

        @JsonProperty("locale")
        private String locale;

        // геттеры и сеттеры
        public Boolean isCardAccount() {
            return isCardAccount;
        }

        public void setCardAccount(Boolean cardAccount) {
            this.isCardAccount = cardAccount;
        }

        public DocIdsData getData() {
            return data;
        }

        public void setData(DocIdsData data) {
            this.data = data;
        }

        public boolean isRevaluation() {
            return isRevaluation;
        }

        public void setRevaluation(boolean revaluation) {
            this.isRevaluation = revaluation;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public String getUserLogin() {
            return userLogin;
        }

        public void setUserLogin(String userLogin) {
            this.userLogin = userLogin;
        }

        public Integer[] getDocIds() {
            return docIds;
        }

        public void setDocIds(Integer[] docIds) {
            this.docIds = docIds;
        }

        public String getLocale() {
            return locale;
        }

        public void setLocale(String locale) {
            this.locale = locale;
        }

        @Override
        public String toString() {
            return "/* ModelIsCartData */{" +
                    "\n \tisCardAccount: " + isCardAccount +
                    ", \n \tdata: " + data +
                    ", \n \tisRevaluation: " + isRevaluation +
                    ", \n \tuserId: " + userId +
                    ", \n \tuserLogin: '" + userLogin + '\'' +
                    ", \n \tdocIds: " + Arrays.toString(docIds) +
                    ", \n \tlocale: '" + locale + '\'' +
                    "\n}";
        }
    }