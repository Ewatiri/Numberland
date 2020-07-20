/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mejustme.numberland;

import java.util.Scanner;

/**
 *
 * @author eva
 */
public class Numberland {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the members of the Even family in attendance: ");
        
        int E = scan.nextInt();
        
        System.out.println("Enter the members of the Odd family in attendance: ");
        int O = scan.nextInt();
        
        long photos = 0;
        if ( E > 0 && O > 0){
           photos = countPhotos(E, O);
        }
        
        System.out.println("Photos taken "+photos);
        
    }
    
    public static long countPhotos(int E, int O) {
        int min = E < O ? E : O;
        int max = E > O ? E : O;
        int maxLoop = 0;

        boolean evenLargest = E >= O;

        if (evenLargest) {
            maxLoop = max * 2;
        } else {
            maxLoop = (max * 2) - 1;
        }
        
        long photos = 0;
        // calculate the photos taken by each family member
        for (int i = 2; i <= maxLoop; i++) {
            int younger = i / 2;
            if (younger >= min) {
                younger = min;
            }

            // skip if we are out of family members
            if (i % 2 == 0 && i > E * 2) {
                continue;
            } else if (i % 2 == 1 && i > (O * 2) - 1) {
                continue;
            }

            photos += (Math.pow(2, younger)-1);
        }
        return photos;
        //System.out.println("Photos taken " + photos);
    }

    /**public static void countPhotosNoPow(int E, int O) {
        int min = E < O ? E : O;
        int max = E > O ? E : O;
        int maxLoop = 0;

        boolean evenLargest = E >= O;

        if (evenLargest) {
            maxLoop = max * 2;
        } else {
            maxLoop = (max * 2) - 1;
        }

        //System.out.print("maxloop " + maxLoop);

        long[] pascal;
        if (min < 3) {
            pascal = new long[3];
        } else {
            pascal = new long[min + 1];
        }
        // initialize the pascal array with binomial coefficients
        pascal[0] = 1;
        pascal[1] = 1;
        pascal[2] = 3;

        for (int i = 3; i <= min; i++) {
            pascal[i] = (pascal[i - 1] * 2) + 1;
        }

        long photos = 0;
        // calculate the photos taken by each family member
        for (int i = 2; i <= maxLoop; i++) {
            int younger = i / 2;
            if (younger >= min) {
                younger = min;
            }

            // skip if we are out of family members
            if (i % 2 == 0 && i > E * 2) {
                continue;
            } else if (i % 2 == 1 && i > (O * 2) - 1) {
                continue;
            }

          //  System.out.println("At " + i + " younger " + younger + " photos " + pascal[younger]);
            photos += pascal[younger];
        }
        System.out.println("Photos taken " + photos);
    }**/
    
    
    

}
