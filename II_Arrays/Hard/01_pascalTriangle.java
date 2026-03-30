/*
 * Case 1: Find element at given row & column
 * //Brute force
 * public class PascalElementBrute {
 * 
 * public static int pascalElement(int r, int c) {
 * int[][] triangle = new int[r][r];
 * 
 * for(int i = 0; i < r; i++) {
 * for(int j = 0; j <= i; j++) {
 * 
 * if(j == 0 || j == i)
 * triangle[i][j] = 1;
 * else
 * triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
 * }
 * }
 * 
 * return triangle[r-1][c-1];
 * }
 * 
 * public static void main(String[] args) {
 * System.out.println(pascalElement(5,3));
 * }
 * }
 * //TC - O(n²)
 * 
 *
 * //Optimal
 * class Solution {
 * 
 * public long nCr(int n, int r) {
 * long res = 1;
 * 
 * for (int i = 0; i < r; i++) {
 * res = res * (n - i);
 * res = res / (i + 1);
 * }
 * 
 * return res;
 * }
 * 
 * public int pascalElement(int row, int col) {
 * return (int)nCr(row - 1, col - 1);
 * }
 * }
 * //TC - O(C)
 * 
 * 
 * 
 * 
 * Case 2: Print nth row
 * //Brute Force
 * public class PascalNthRowBrute {
 * 
 * public static void main(String[] args) {
 * 
 * int n = 5;
 * 
 * int[][] triangle = new int[n][n];
 * 
 * for(int i = 0; i < n; i++) {
 * for(int j = 0; j <= i; j++) {
 * 
 * if(j == 0 || j == i)
 * triangle[i][j] = 1;
 * else
 * triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
 * }
 * }
 * 
 * for(int j = 0; j < n; j++)
 * System.out.print(triangle[n-1][j] + " ");
 * }
 * }
 * //TC - O(n²)
 * 
 * 
 * //Optimal
 * import java.util.*;
 * 
 * class Solution {
 * 
 * public List<Integer> getRow(int rowIndex) {
 * 
 * List<Integer> row = new ArrayList<>();
 * 
 * long ans = 1;
 * row.add((int)ans);
 * 
 * for (int i = 1; i <= rowIndex; i++) {
 * 
 * ans = ans * (rowIndex - i + 1);
 * ans = ans / i;
 * 
 * row.add((int)ans);
 * }
 * 
 * return row;
 * }
 * }
 * //TC - O(N)
 * 
 * 
 * 
 * 
 * 
 * Case 3: Print entire Pascal Triangle
 * //Brute Force
 * public class PascalNthRowBrute {
 * 
 * public static void main(String[] args) {
 * 
 * int n = 5;
 * 
 * int[][] triangle = new int[n][n];
 * 
 * for(int i = 0; i < n; i++) {
 * for(int j = 0; j <= i; j++) {
 * 
 * if(j == 0 || j == i)
 * triangle[i][j] = 1;
 * else
 * triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
 * }
 * }
 * 
 * for(int j = 0; j < n; j++)
 * System.out.print(triangle[n-1][j] + " ");
 * }
 * }
 * //TC - O(n²)
 * 
 * 
 * import java.util.*;
 * 
 * class Solution {
 * 
 * public List<List<Integer>> generate(int numRows) {
 * 
 * List<List<Integer>> triangle = new ArrayList<>();
 * 
 * for (int i = 0; i < numRows; i++) {
 * 
 * List<Integer> row = new ArrayList<>();
 * 
 * long ans = 1;
 * row.add((int) ans);
 * 
 * for (int j = 1; j <= i; j++) {
 * 
 * ans = ans * (i - j + 1);
 * ans = ans / j;
 * 
 * row.add((int) ans);
 * }
 * 
 * triangle.add(row);
 * }
 * 
 * return triangle;
 * }
 * }
 * //TC - O(N²)
 * 
 */