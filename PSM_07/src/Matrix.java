public class Matrix {
    private final int size;
    private final double[][] matrix;
    private final double[] vector;

    public Matrix(int size, double up, double left, double down, double right) {
        this.size = size;
        this.matrix = new double[size * size][size * size];
        this.vector = new double[size * size];
        fillMatrixAndVector(up, left, down, right);
    }

    private void fillMatrixAndVector(double up, double left, double down, double right) {
        int index;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                index = i * size + j;
                matrix[index][index] = -4;
                if (i > 0) matrix[index][index - size] = 1;
                if (i < size - 1) matrix[index][index + size] = 1;
                if (j > 0) matrix[index][index - 1] = 1;
                if (j < size - 1) matrix[index][index + 1] = 1;

                if (i == 0) vector[index] = -down;
                if (i == size - 1) vector[index] = -up;
                if (j == 0) vector[index] = -left;
                if (j == size - 1) vector[index] = -right;
            }
        }
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public double[] getVector() {
        return vector;
    }
}
