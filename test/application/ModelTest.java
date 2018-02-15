package application;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    Model model = new Model();

    @Test
    void analysisTest() {
    }

    @Test
    void xAnalysis() {
        ArrayList actual = new ArrayList();

        int[] actualList = { 2, 3, 4, 9, 12, 90, 200, 25};

        // { {2}, {3}, {2, 2},  {3, 3}, {2, 2, 3} }
        ArrayList<ArrayList<Integer>> expectedList = new ArrayList<ArrayList<Integer>>() {{
            add(new ArrayList<>(Arrays.asList(2)));
            add(new ArrayList<>(Arrays.asList(3)));
            add(new ArrayList<>(Arrays.asList(2, 2)));
            add(new ArrayList<>(Arrays.asList(3, 3)));
            add(new ArrayList<>(Arrays.asList(2, 2, 3)));
            add(new ArrayList<>(Arrays.asList(2, 3, 3, 5)));
            add(new ArrayList<>(Arrays.asList(2, 2, 2, 5, 5)));
            add(new ArrayList<>(Arrays.asList(5, 5)));
            //add(new ArrayList<>(Arrays.asList(0)));
        }};

        for(int i = 0; i <= actualList.length-1; i++) {
            actual = model.xAnalysis(actualList[i]);
            assertEquals(expectedList.get(i), actual);
        }

    }

    @Test
    void factorial() {

        int actual;

        int[] listActual = { 0, 2, 3, 5, 6};
        int[] listExpected = { 1, 2, 6, 120, 720};

        for (int i  =0; i <= listActual.length - 1; i++) {
            actual  = model.factorial(listActual[i]);
            assertEquals(listExpected[i], actual);
        }
    }

    @Test
    void exponent() {
    }

    @Test
    void isPrimeForMyJobTemporaly() {
    }

    @Test
    void isPrime() {
    }


}