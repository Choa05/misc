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
public class Matrix {
	// 16 array elements in floats
	// multiply method
	private float[][] matrix = new float[4][4];
    
	// matrix filled with 0;
	public Matrix () {
		
	}
    
	public Matrix(float[][] a){
		matrix = a;
	}

	// Multiply matrix with other matrix and return a resultant matrix
	public Matrix multiply (Matrix other){
		Matrix result = new Matrix();
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++){
				for (int k = 0; k < 4; k++){
					result.matrix[i][j] += matrix[i][k] * other.matrix[k][j];
				}
			}
		}
		return result;
	}

	// Convert matrix data to printable string
	public String toString(){
		String result = "";
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++){
				result += matrix[i][j] + " ";
			}
			result += "\n";
		}
		return result;
	}

	// Multiplication identity
	public static Matrix m_identity() {
		float[][] a = new float[4][4];
		for(int i = 0; i < 4; i++) {
			a[i][i] = 1;
		}
		return new Matrix(a);
	}

	// Rotational Transformation Matrix: Rotate vectors in certain angle
	public static Matrix rot_transformation(Vec3 vector, float angle) {
		float[][] a = new float[4][4];
		float[] v = {vector.x, vector.y, vector.z};
		double theta = (double) angle;

		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if (i == j) {
					a[i][j] = v[i] * v[j] * (float) (1.0 - Math.cos (theta)) + (float) Math.cos (theta);
				} else if (j == (i + 1) % 3){
					a[i][j] = v[i] * v[j] * (float) (1.0 - Math.cos (theta)) - v[(j + 1) % 3] * (float) Math.cos (theta);
				} else {
					a[i][j] = v[i] * v[j] * (float) (1.0 - Math.cos (theta)) + v[(j + 1) % 3] * (float) Math.cos (theta);
				}
			}
		}
		a[3][3] = 1;
		return new Matrix(a);
	}

	// Scale matrix
	public static Matrix m_scale(float x, float y, float z) {
		float[][] a = new float[4][4];
		a[0][0] = x;
		a[1][1] = y;
		a[2][2] = z;
		a[3][3] = 1;
		return new Matrix(a);
	}
	
	// Translation Matrix
	public static Matrix translation(Vec3 vector) {
		float[][] a = new float[4][4];
		float[] v = {vector.x, vector.y, vector.z};

		a[0][0] = 1;
		a[1][1] = 1;
		a[2][2] = 1;
		a[0][3] = v[0];
		a[1][3] = v[1];
		a[2][3] = v[2];
		a[3][3] = 1;
		return new Matrix(a);
		
	}
	
	// Perspective matrix (later)
}
