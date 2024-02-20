import java.lang.Math;
public class MeansCalculations {

    public static double arithmeticMean(double[] values){
        double sum = 0;
        int size = values.length;
        for(int i = 0; i < size; i++){
            sum += values[i];
        }
        double mean = sum/size;

        return mean;
    }
    public static double geometricMean(double[] values){
        double sum = values[0];
        int size = values.length;
        for(int i = 1; i < size; i++){
            sum *= values[i];
        }
        double gMean = Math.pow(sum, (1.0/size));
        return gMean;

    }
    public static double weightedArithmeticMean(double[] values, double[] weights ){
        double sum = 0;
        double weightTotal = 0;
        int size = values.length;
        for(int i = 0; i < size; i++){
            sum += values[i] * weights[i];
            weightTotal += weights[i];
        }
        double gMean = sum/weightTotal;
        return gMean;
    }
    public static double[] movingGeometricMean(double[] values){
        double[] newValues = new double[values.length];
        int size = values.length;
        double helper = 1.0;
        for(int i = 0; i < size; i++){

            helper = values[i] * helper;
            newValues[i] = Math.pow(helper, 1.0/(i+1));
        }

        return newValues;
    }



}
