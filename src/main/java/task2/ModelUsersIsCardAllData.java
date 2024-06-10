package task2;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class ModelUsersIsCardAllData {
        @JsonProperty("modelUserData")
        private List<ModelUserIsCardData> modelUserData;

        @JsonProperty("modelUserData")
        public List<ModelUserIsCardData> getUserData() {
            return this.modelUserData;
        }

        @JsonProperty("modelUserData")
        public void ModelUserData(List<ModelUserIsCardData> userData) {
            this.modelUserData = userData;
        }

    public ModelUsersIsCardAllData(List<ModelUserIsCardData> modelUserData) {
        this.modelUserData = modelUserData;
    }
    public ModelUsersIsCardAllData(){}

    @Override
            public String toString() {

                return "\t {" +
                        "\n \t " + this.modelUserData  +
                        "\n }";
            }
        }
