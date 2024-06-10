package task2;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ModelUserIsCardData {
        @JsonProperty("isCard")
        private Boolean isCard;

        @JsonProperty("userPass")
        private String userPass;

        @JsonProperty("userLogin")
        private String userLogin;

        @JsonProperty("locale")
        private String locale;

        // геттеры и сеттеры
        @JsonProperty("isCard")
        public Boolean isCard() {
            return isCard;
        }

        @JsonProperty("isCard")
        public void setCard(boolean card) {
            isCard = card;
        }

        @JsonProperty("userPass")
        public String getUserPass() {
            return userPass;
        }

        @JsonProperty("userPass")
        public void setUserPass(String userPass) {
            this.userPass = userPass;
        }

        @JsonProperty("userLogin")
        public String getUserLogin() {
            return userLogin;
        }

        @JsonProperty("userLogin")
        public void setUserLogin(String userLogin) {
            this.userLogin = userLogin;
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
            return " /* ModelUserIsCardData */ {\n" +
                    "\n \t isCard=" + isCard +
                    ", \n \t userPass: '" + userPass + '\'' +
                    ", \n \t userLogin: '" + userLogin + '\'' +
                    ", \n \t locale: '" + locale + '\'' +
                    "}\n";
        }
    }