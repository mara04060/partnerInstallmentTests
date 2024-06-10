package task2.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class UsersIsCardAllData {
        @JsonProperty("modelUserData")
        private List<UserIsCardData> modelUserData;

        @JsonProperty("modelUserData")
        public List<UserIsCardData> getUserData() {
            return this.modelUserData;
        }

        @JsonProperty("modelUserData")
        public void ModelUserData(List<UserIsCardData> userData) {
            this.modelUserData = userData;
        }

    public UsersIsCardAllData(List<UserIsCardData> modelUserData) {
        this.modelUserData = modelUserData;
    }
    public UsersIsCardAllData(){}

    @Override
            public String toString() {

                return "\t {" +
                        "\n \t " + this.modelUserData  +
                        "\n }";
            }
        }
