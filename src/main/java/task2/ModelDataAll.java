package task2;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class ModelDataAll implements ModelJson {
        @JsonProperty("isCardAccount")
        private Boolean isCardAccount;

        @JsonProperty("data")
        private ModelData data;

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
        @JsonProperty("isCardAccount")
        public Boolean isCardAccount() {
            return isCardAccount;
        }

        @JsonProperty("isCardAccount")
        public void setCardAccount(Boolean cardAccount) {
            isCardAccount = cardAccount;
        }

        @JsonProperty("data")
        public ModelData getData() {
            return data;
        }

        @JsonProperty("data")
        public void setData(ModelData data) {
            this.data = data;
        }

        @JsonProperty("isRevaluation")
        public boolean isRevaluation() {
            return isRevaluation;
        }

        @JsonProperty("isRevaluation")
        public void setRevaluation(boolean revaluation) {
            isRevaluation = revaluation;
        }

        @JsonProperty("userId")
        public Integer getUserId() {
            return userId;
        }

        @JsonProperty("userId")
        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        @JsonProperty("userLogin")
        public String getUserLogin() {
            return userLogin;
        }

        @JsonProperty("userLogin")
        public void setUserLogin(String userLogin) {
            this.userLogin = userLogin;
        }

        @JsonProperty("docIds")
        public Integer[] getDocIds() {
            return docIds;
        }

        @JsonProperty("docIds")
        public void setDocIds(Integer[] docIds) {
            this.docIds = docIds;
        }

        @JsonProperty("locale")
        public String getLocale() {
            return locale;
        }

        @JsonProperty("locale")
        public void setLocale(String locale) {
            this.locale = locale;
        }

        @Override
        public String toString() {
            return "ModelDataAll {" +
                    "\n \tisCardAccount=" + isCardAccount +
                    ", \n \tdata=" + data +
                    ", \n \tisRevaluation=" + isRevaluation +
                    ", \n \tuserId=" + userId +
                    ", \n \tuserLogin='" + userLogin + '\'' +
                    ", \n \tdocIds=" + Arrays.toString(docIds) +
                    ", \n \tlocale='" + locale + '\'' +
                    "\n}";
        }
    }