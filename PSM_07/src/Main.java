import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) {
        Matrix matrix = new Matrix(40, 200, 150, 50, 100);
        double[] solution = Gauss.solve(matrix.getMatrix(), matrix.getVector());

        // csv
        try (PrintWriter out = new PrintWriter(new FileWriter("solution.csv"))) {
            for (int i = 39; i >= 0; i--) {
                StringBuilder line = new StringBuilder();
                for (int j = 39; j >= 0; j--) {
                    line.append(formatOutput(solution[40 * i + j]));
                    if (j > 0) {
                        line.append(";");
                    }
                }
                out.println(line.toString());
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static String formatOutput(double value) {
        return String.format("%.12f", value).replace('.', ',').replaceAll("-", "");
    }
}
