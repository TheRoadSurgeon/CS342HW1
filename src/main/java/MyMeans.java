import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * This class will eventually work with a user interface to calculate various investment 
 * strategies for the user. 
 */
public class MyMeans {
	
	private double[] values;
	private double[] weights;


	public MyMeans(String valuesfilename, int size){
		values = new double[size];
		readInValues(valuesfilename);
		System.out.println("Values in file "+valuesfilename);
		this.printArrays();
	}

	public MyMeans(String valuesfilename, String weightsfilename, int size){
		values = new double[size];
		weights = new double[size];
		readInValues(valuesfilename);
		readInWeights(weightsfilename);
		System.out.println("Values in file "+valuesfilename);
		System.out.println("Weights in file "+weightsfilename);
		this.printArrays();
	}
	
	/*
	 * displays the future value at a fixed rate of interest of an
	 * initial principle balance for a fixed amount of years
	 */
	public void arithmeticMeanCalc() {
		
		double total = MeansCalculations.arithmeticMean(values);
		
	}
	
	/*
	 * displays the future value of an initial principle balance for a fixed
	 * amount of years at a variable interest rate.
	 */
	public void geometricMeanCalc() {
		
		double total = MeansCalculations.geometricMean(values);
	}
	
	/*
	 * displays the future value of identical yearly contributions over a fixed
	 * amount of years at fixed interest rates
	 */
	public void weightedArithmeticMeanCalc(double[] weights) {
		
		double total = MeansCalculations.weightedArithmeticMean(values, weights);
	}
	
	/*
	 * displays the future value of variable yearly contributions over a fixed 
	 * amount of years at a constant interest rate
	 */
	public void movingGeometricMeanCalc() {
	
		double[] total = MeansCalculations.movingGeometricMean(values);
		
	}
	
	
	/*
	 * method reads in double values from named file passed in. Format of the file
	 * is one value per line
	 */
	private void readInValues(String filename) {
		
		try {
			File f = new File("src/main/resources/"+filename);
			
			Scanner s = new Scanner(f);
			
			int i = 0;
			while(s.hasNextDouble()) {
				values[i] = s.nextDouble();
				i++;
			}
			
			s.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void readInWeights(String filename) {

		try {
			File f = new File("src/main/resources/"+filename);

			Scanner s = new Scanner(f);

			int i = 0;
			while(s.hasNextDouble()) {
				weights[i] = s.nextDouble();
				i++;
			}

			s.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/*
	 * utility functions for testing....will eventually remove
	 */
	private void printArrays() {
		System.out.println("values:");
		for(int i = 0; i < values.length; i++) {
			System.out.println(values[i]+ " ");
		}

		if(weights != null){
			System.out.println("weights:");
			for(int i = 0; i < values.length; i++) {
				System.out.println(weights[i]+ " ");
			}
		}
	}
	
	/* getter for private data member values
	 * this is where the double values from the file read in are stored
	 */
	public double[] getValues() {
		return values;
	}

	public double[] getWeights() {
		return weights;
	}
	

}
