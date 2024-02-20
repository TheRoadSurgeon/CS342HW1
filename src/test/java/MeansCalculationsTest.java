import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MeansCalculationsTest {
	
	static MyMeans s1;
	static MyMeans s2;
	
	@BeforeAll
	static void setup() {
		s1 = new MyMeans("values.txt", 5);
		s2 = new MyMeans("values2.txt","weights2.txt", 6);
	}
	
	@Test
	void arithmeticMeanTest() {
		//test arithmetic mean calculation on values.txt
		assertEquals(12000,Math.round(MeansCalculations.arithmeticMean(s1.getValues())), "Arithmetic mean calculation incorrect");
	}
	
	@Test
	void geometricMeanTest() {
		
		//test geometric mean calculation on values.txt
		assertEquals(9980,Math.round(MeansCalculations.geometricMean(s1.getValues())), "Geometric mean calculation incorrect");
	}
	
	@Test
	void weightedArithmeticMeanTest() {
		
		//weighted arithmetic mean of values2.txt as values and weights2.txt as weights
		assertEquals(43333,Math.round(MeansCalculations.weightedArithmeticMean(s2.getValues(),s2.getWeights())), "Weighted arithmetic mean calculation incorrect");
	}
	
	@Test
	void movingGeometricMeanTest() {
		//calculate the moving geometric mean of values.txt
		double [] result = MeansCalculations.movingGeometricMean(s1.getValues());

		//this creates an array of the expected results. The {x,y,z} notation is for defining an array without needing to define each element
		double[] testresults = new double[]{5000.0,5000.0,6300.0,8190.0,9980.0};
		double temp = 0;
		for(int x = 0; x<result.length; x++){
			assertEquals(testresults[x],Math.round(result[x]), "In the moving geometric mean, result["+x+"] is incorrect");
		}
	}

}
