import java.util.Scanner;

public class Gauss {
    private static final double EPSILON = 1e-10;

    public static double[] solve(double[][] A, double[] B) {
        // eliminacja Gaussa
        int n = A.length;
        for (int p = 0; p < n; p++) {
            int max = findPivot(A, p);
            swapRows(A, B, p, max);
            if (Math.abs(A[p][p]) <= EPSILON) {
                throw new RuntimeException();
            }
            eliminate(A, B, p);
        }
        return backSubstitution(A, B);
    }

    private static int findPivot(double[][] A, int p) {
        // znalezienie pivotu
        int max = p;
        for (int i = p + 1; i < A.length; i++) {
            if (Math.abs(A[i][p]) > Math.abs(A[max][p])) {
                max = i;
            }
        }
        return max;
    }

    private static void swapRows(double[][] A, double[] B, int p, int max) {
        // zamiana wierszy
        double[] temp = A[p];
        A[p] = A[max];
        A[max] = temp;
        double t = B[p];
        B[p] = B[max];
        B[max] = t;
    }

    private static void eliminate(double[][] A, double[] B, int p) {
        // eliminacja wierszy ponizej pivotu
        int n = A.length;
        for (int i = p + 1; i < n; i++) {
            double alpha = A[i][p] / A[p][p];
            B[i] -= alpha * B[p];
            for (int j = p; j < n; j++) {
                A[i][j] -= alpha * A[p][j];
            }
        }
    }

    private static double[] backSubstitution(double[][] A, double[] B) {
        // podstawienie
        int n = A.length;
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += A[i][j] * x[j];
            }
            x[i] = (B[i] - sum) / A[i][i];
        }
        return x;
    }
}
