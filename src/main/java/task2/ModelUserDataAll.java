package task2;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class ModelUserDataAll {
        @JsonProperty("modelUserData")
        private List<ModelUserData> modelUserData;

        @JsonProperty("modelUserData")
        public List<ModelUserData> getUserData() {
            return this.modelUserData;
        }

        @JsonProperty("modelUserData")
        public void ModelUserData(List<ModelUserData> userData) {
            this.modelUserData = userData;
        }

    public ModelUserDataAll(List<ModelUserData> modelUserData) {
        this.modelUserData = modelUserData;
    }
    public ModelUserDataAll(){}

    @Override
            public String toString() {

                return "\t {" +
                        "\n \t " + this.modelUserData  +
                        "\n }";
            }
        }
