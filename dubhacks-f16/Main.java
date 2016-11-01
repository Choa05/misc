/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Misc;

/**
 *
 * @author Choa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        float[][] a = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        Matrix A = new Matrix(a);
        System.out.println("A\n" + A.toString());
        float[][] b = {{10, 9, 8, 7}, {6, 5, 4, 3}, {2, 1, 2, 3}, {4, 5, 6, 7}};
        Matrix B = new Matrix(b);
        System.out.println("B\n" + B.toString());
        
        System.out.println(A.multiply(B).toString());
        
    }
    
}
