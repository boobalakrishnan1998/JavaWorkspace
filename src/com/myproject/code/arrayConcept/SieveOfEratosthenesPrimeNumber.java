package com.myproject.code.arrayConcept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SieveOfEratosthenesPrimeNumber {
    public static void main(String[] args) {
        System.out.println(checkPrimeNumber(100));
    }

    private static List<Integer> checkPrimeNumber(int N) {
        // code here
        boolean[] bolArr = new boolean[N+1];
        Arrays.fill(bolArr, true);

        for(int i = 2; i*i<=N; i++){
            if(bolArr[i]){
                for(int j = i*i; j<=N; j+=i){
                    bolArr[j]=false;
                }
            }
        }
        ArrayList<Integer> primeList=new ArrayList<>();
        for(int i = 2; i<=N; i++){
            if(bolArr[i]==true){
                primeList.add(i);
            }
        }
        return primeList;
    }
}
