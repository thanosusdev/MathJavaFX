package application;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Model {

    final String msg1Prime = "Number must be > 2.";

        /*** to remember to change the ArrayList to List sketo ***/
        ArrayList<Integer> local = new ArrayList<>();
        ArrayList<Integer> analysis = new ArrayList<>();
        ArrayList<Integer> lcmArrList = new ArrayList<>();
        List<Integer> lcmList = new ArrayList<>();

        HashSet<Integer> hsetLCM1 = new HashSet<>(analysis);
        Set<Integer> hSetLCM2 = new HashSet<>(local);
        public void fillAll() {
        	hsetLCM1.addAll(analysis);
        	hSetLCM2.addAll(local);
        	System.out.println("first hash set"+hsetLCM1);
            System.out.println("second hash set"+hSetLCM2);
        }

    protected List<Integer> lcm(int x, int y) {

        xAnalysis(x);
        localAnalysis(y);
        int COUNTER = 0;
        int COUNTER2 = 0;
        int var = 0;
        int flirt = 0;
        int temp = 0;
        fillAll();
        Iterator itr = hsetLCM1.iterator();
        while(itr.hasNext())
        {	
        	for (int i = 0; i <= analysis.size() -1; i++) {
        		temp = analysis.get(i);
        		lcmList.add(temp);
        		if (hsetLCM1.contains(temp)) {
                    COUNTER++;
                }
//        		if (itr.equals(temp)) {
//        		COUNTER++;
//        	}
        	}
        	
            System.out.println(itr.next());
        }
        int temp2 = 0;
        Iterator itr2 = hSetLCM2.iterator();
        while(itr2.hasNext())
        {
            for (int i = 0; i <= local.size() -1; i++) {
                temp2 = local.get(i);
                lcmList.add(temp);
                if (hSetLCM2.contains(temp2)) {
                    COUNTER2++;
                }
//        		if (itr.equals(temp)) {
//        		COUNTER++;
//        	}
            }

            //System.out.println(itr.next());
        }
        System.out.println(hsetLCM1);
        //foreach r in t :
        return lcmList;
    }
    
    /*** <p>This Method is connected with local List</p> ***/
    protected ArrayList localAnalysis(int y) {
        local.clear();
        if (isPrimeForMyJobTemporaly(y)) {
            local.add(y);
        }else {
            while (y % 2 == 0) {
                local.add(2);
                y = y / 2;
            }
            for(int i = 3; i <= y;) {
                if (isPrimeForMyJobTemporaly(i)) { //isPrime?
                    if (isPrimeForMyJobTemporaly(y)) {
                        local.add(y);
                        return local;
                    }
                    if (y % i == 0) {
                        y = y / i;
                        local.add(i);
                    }else {
                        i = i + 2;
                    }
                }else {
                    i = i + 2;
                }
            }
        }
        return local;
    }

    void  bar() {
        // some code here
    }
    
    /*** <p>This Method is connected with analysis List</p> ***/
    protected ArrayList xAnalysis(int x) {
        analysis.clear();
        if (isPrimeForMyJobTemporaly(x)) {
            analysis.add(x);
        }else {
            while (x % 2 == 0) {
                analysis.add(2);
                x = x / 2;
            }
            for(int i = 3; i <= x;) {
                if (isPrimeForMyJobTemporaly(i)) { //isPrime?
                    if (isPrimeForMyJobTemporaly(x)) {
                        analysis.add(x);
                        return analysis;
                    }
                    if (x % i == 0) {
                        x = x / i;
                        analysis.add(i);
                    }else {
                        i = i + 2;
                    }
                }else {
                    i = i + 2;
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
