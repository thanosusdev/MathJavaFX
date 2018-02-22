package application;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Model {

    private final String msg1Prime = "Number must be > 2.";

        /*** to remember to change the ArrayList to List sketo ***/
        ArrayList<Integer> primefactorsOfY = new ArrayList<>();
        ArrayList<Integer> primefactorsOfX = new ArrayList<>();
        ArrayList<Integer> lcmList = new ArrayList<>(); // Alt + Enter


        HashSet<Integer> discretePrimeFactorsOfX = new HashSet<>(primefactorsOfX);
        HashSet<Integer> discretePrimeFactorsOfY = new HashSet<>(primefactorsOfY);

    protected double absoluteValue(double absv) {
        return absv;
    }
    protected double sqrRoot(double sqrt) {
        double root;
        return root = Math.sqrt(sqrt);
    }
    protected double lcm(int x, int y) {

        primefactorsOfX = calculatePrimeFactorization(x);
        primefactorsOfY = calculatePrimeFactorization(y);
        discretePrimeFactorsOfX.addAll(primefactorsOfX);
        discretePrimeFactorsOfY.addAll(primefactorsOfY);

            /* X = (2, 2, 2)
                    (2)

               Y = (2, 2, 3)
                    (2, 3)

               commonAndNonCommonFactors         = 2, 2, 2, 2, 2, 3
               discreteCommonAndNonCommonFactors = 2, 3

               final = 2 ^ 3 * 3
             */

        List<Integer> commonAndNonCommonFactors = Stream.concat(primefactorsOfX.stream(), primefactorsOfY.stream())
                .collect(Collectors.toList());

        Set<Integer> discreteCommonAndNonCommonFactors = new HashSet<> (commonAndNonCommonFactors);

        int maximumExp;

        double result = 1;

        for (Integer  i: discreteCommonAndNonCommonFactors) {
            int occurenceInX = Collections.frequency(primefactorsOfX, i);
            int occurenceInY = Collections.frequency(primefactorsOfY, i);

            if ( occurenceInX > occurenceInY ) {
                maximumExp = occurenceInX;
            }
            else {
                maximumExp = occurenceInY;
            }

            result = result * Math.pow(i, maximumExp);
        }
        return result;
    }

    /*** <p>This Method is connected with primefactorsOfX List</p> ***/
    protected ArrayList calculatePrimeFactorization(int x) {
        ArrayList<Integer> list = new ArrayList<>();

        if (isPrimeForMyJobTemporaly(x)) {
            list.add(x);
        }else {
            while (x % 2 == 0) {
                list.add(2);
                x = x / 2;
            }
            for(int i = 3; i <= x;) {
                if (isPrimeForMyJobTemporaly(i)) { //isPrime?
                    if (isPrimeForMyJobTemporaly(x)) {
                        list.add(x);
                        return list;
                    }
                    if (x % i == 0) {
                        x = x / i;
                        list.add(i);
                    }else {
                        i = i + 2;
                    }
                }else {
                    i = i + 2;
                }
            }
        }
        return list;
    }

    public int factorial(int n) {
        //6!  = 1*2*3...*6
        if (n == 0 || n == 1) {
            return 1;
        }else {
            return n * factorial(n - 1);
        }
    }

    protected double exponent(int bs, int pwr) {
    	if(pwr == 0) {
			return 1;
		}
		/* a ^-n = 1 / a^n */
        if(pwr < 0) {
    	    return 1 / exponent(bs, -pwr);
        }

        int tempBs = 1;
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
                return  false; // isnt't prime
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
