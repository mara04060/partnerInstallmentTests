package task2;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class ModelUsersIsCartAllData {
        @JsonProperty("modelUserData")
        private List<ModelUserIsCartData> modelUserData;

        @JsonProperty("modelUserData")
        public List<ModelUserIsCartData> getUserData() {
            return this.modelUserData;
        }

        @JsonProperty("modelUserData")
        public void ModelUserData(List<ModelUserIsCartData> userData) {
            this.modelUserData = userData;
        }

    public ModelUsersIsCartAllData(List<ModelUserIsCartData> modelUserData) {
        this.modelUserData = modelUserData;
    }
    public ModelUsersIsCartAllData(){}

    @Override
            public String toString() {

                return "\t {" +
                        "\n \t " + this.modelUserData  +
                        "\n }";
            }
        }
