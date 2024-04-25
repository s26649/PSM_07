public class Matrix {
    private final int size;
    private final double[][] matrix;
    private final double[] vector;
    private final double up;
    private final double down;
    private final double right;
    private final double left;

    public Matrix(int size, int up, int left, int down, int right) {
        this.size = size;
        this.up = up;
        this.down = down;
        this.right = right;
        this.left = left;
        this.matrix = new double[size * size][size * size];
        this.vector = new double[size * size];
        initializeMatrix();
    }

    private void initializeMatrix() {
        int index = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                processCell(i, j, index++);
            }
        }
    }

    private void processCell(int i, int j, int index) {
        count(i, j, index);
        matrix[index][index] = -4;  // Each cell corresponds to -4 in its position in the matrix
    }

    private void count(int i, int j, int index) {
        // up
        if (i == size - 1) {
            vector[index] += up;
        } else {
            matrix[index][(i + 1) * size + j] = 1;
        }

        // down
        if (i == 0) {
            vector[index] += down;
        } else {
            matrix[index][(i - 1) * size + j] = 1;
        }

        // left
        if (j == size - 1) {
            vector[index] += left;
        } else {
            matrix[index][i * size + (j + 1)] = 1;
        }

        // right
        if (j == 0) {
            vector[index] += right;
        } else {
            matrix[index][i * size + (j - 1)] = 1;
        }
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public double[] getVector() {
        return vector;
    }
}
