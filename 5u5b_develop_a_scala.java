import java.util.List;
import java.util.Map;

public interface ModelMonitorAPI {
    // Initialize model monitoring with model metadata
    void initModelMonitoring(String modelName, String modelVersion, String modelType);

    // Send model prediction data for monitoring
    void sendPredictionData(List<Prediction> predictions);

    // Get model performance metrics
    Map<String, Double> getModelPerformanceMetrics();

    // Get model data drift metrics
    Map<String, Double> getModelDataDriftMetrics();

    // Get model concept drift metrics
    Map<String, Double> getModelConceptDriftMetrics();

    // Get alerts for model performance degradation
    List<Alert> getAlerts();

    // Update model with new training data
    void updateModelWithNewData(List<TrainingData> trainingData);

    static class Prediction {
        private double predictedValue;
        private double actualValue;

        public Prediction(double predictedValue, double actualValue) {
            this.predictedValue = predictedValue;
            this.actualValue = actualValue;
        }

        public double getPredictedValue() {
            return predictedValue;
        }

        public double getActualValue() {
            return actualValue;
        }
    }

    static class Alert {
        private String alertType;
        private String alertMessage;

        public Alert(String alertType, String alertMessage) {
            this.alertType = alertType;
            this.alertMessage = alertMessage;
        }

        public String getAlertType() {
            return alertType;
        }

        public String getAlertMessage() {
            return alertMessage;
        }
    }

    static class TrainingData {
        private double feature1;
        private double feature2;
        private double targetValue;

        public TrainingData(double feature1, double feature2, double targetValue) {
            this.feature1 = feature1;
            this.feature2 = feature2;
            this.targetValue = targetValue;
        }

        public double getFeature1() {
            return feature1;
        }

        public double getFeature2() {
            return feature2;
        }

        public double getTargetValue() {
            return targetValue;
        }
    }
}