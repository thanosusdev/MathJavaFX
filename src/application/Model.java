package application;

import java.util.ArrayList;
import java.util.Map.Entry;

import javafx.util.converter.BooleanStringConverter;

public class Model {

    final String msg1Prime = "Number must be > 2.";
    ArrayList<Integer> analysis = new ArrayList<>();

    protected ArrayList analysisTest(int x) {
        analysis.clear();
        if (isPrimeForMyJobTemporaly(x)) {
//    		als = als % 2;
            analysis.add(x);
        }else {
            int index = 2;
            x = x / 2;
            analysis.add(2);
            do {
                /*x = x / 2;
                analysis.add(2);*/
                if (x % index != 0) {
                    index++;
                }else {
                    x = x / index;
                }
            }while (x % index != 0 && index >= 2);
            //x = x / index;
            /*if (x % index != 0) {
                index++;
            }*/

            /*for(int i = 2; i <= y; i++) {
                if (isPrimeForMyJobTemporaly(i)) {
                    //int z;
                    y = y / i;
                    analysis.add(i);
                }
            }*/
        }
        return analysis;
    }

    protected ArrayList xAnalysis(int x) {
        analysis.clear();
        if (isPrimeForMyJobTemporaly(x)) {
//    		als = als % 2;
            analysis.add(x);
        }else {
            int y = 0;
            y = x / 2;
            analysis.add(2);
            for(int i = 2; i <= y;) {
                if (isPrimeForMyJobTemporaly(i)) {
                    y = y / i;
                    analysis.add(i);
                    if (y % i != 0) {
                        i++;
                    }
                }
            }
        }
        return analysis;
    }

    protected ArrayList analysis(int x) {
        analysis.clear();
    	if (isPrimeForMyJobTemporaly(x)) {
//    		als = als % 2;
    		analysis.add(x);
		}else {
            int y = 0;
            y = x / 2;
            analysis.add(2);
            for(int i = 2; i <= y; i++) {
                if (isPrimeForMyJobTemporaly(i)) {
                    //int z;
                    y = y / i;
                    analysis.add(i);
                }
            }
        }
		return analysis;
    }

    public int factorial(int n) {
        //6!  = 1*2*3...*6
        if (n == 0 || n == 1) {
            return 1;
        }else {
            return n * factorial(n - 1);
        }
    }

    protected int exponent(int bs, int pwr) {
    	if(pwr == 0) {
			return 1;
		}
        int tempBs = 1;
        //int tempPwr = 1;
        //bs * tempPwr * pwr;
        int exp = 0;
        for (int i = 1; i <= pwr; i++) {
            tempBs = tempBs * bs;
            exp = tempBs;
        }return exp;
    }

    protected boolean isPrimeForMyJobTemporaly(int prm) {
        int i = 2;
        while ( i < prm ) {
            if (prm % i == 0) {
                return false; // isnt't prime
            }
            i++;
        }
        return true;
    }
    
    protected String isPrime(int prm) {
        if (prm < 2) {
            return  msg1Prime;
        }
        if(prm == 2) {
            return "Number is prime.";
        }
        else if( prm % 2 == 0) {
            return "Number is not prime.";
        }
        return  "Number is prime.";
    }
}
