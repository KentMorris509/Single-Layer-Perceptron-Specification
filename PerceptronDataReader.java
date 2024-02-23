import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PerceptronDataReader {

    private int inputSize;
    private int outputSize;
    private int numTrainingPairs;
    private double[][] inputData;
    private int[][] outputData;

    public PerceptronDataReader(String fileName) {
        readData(fileName);
    }

    private void readData(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            // Read dimensions
            inputSize = Integer.parseInt(br.readLine().trim());
            outputSize = Integer.parseInt(br.readLine().trim());
            numTrainingPairs = Integer.parseInt(br.readLine().trim());

            inputData = new double[numTrainingPairs][inputSize];
            outputData = new int[numTrainingPairs][outputSize];

            // Read and store the data
            for (int i = 0; i < numTrainingPairs; i++) {
                String[] values = br.readLine().trim().split("\\s+");

                for (int j = 0; j < values.length; j++) {
                    if (j < inputSize) {
                        inputData[i][j] = Double.parseDouble(values[j]);
                    } else {
                        outputData[i][j - inputSize] = Integer.parseInt(values[j]);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printFirstTrainingData() {
        // Example: Print the first training data
        System.out.println("Input for first training data: " + arrayToString(inputData[0]));
        System.out.println("Output for first training data: " + arrayToString(outputData[0]));
    }

    private String arrayToString(double[] array) {
        StringBuilder sb = new StringBuilder("[");
        for (double value : array) {
            sb.append(value).append(", ");
        }
        sb.setLength(sb.length() - 2); // Remove the trailing comma and space
        sb.append("]");
        return sb.toString();
    }

    private String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder("[");
        for (int value : array) {
            sb.append(value).append(", ");
        }
        sb.setLength(sb.length() - 2); // Remove the trailing comma and space
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java PerceptronDataReader <filename>");
            System.exit(1);
        }

        PerceptronDataReader perceptronDataReader = new PerceptronDataReader(args[0]);
        perceptronDataReader.printFirstTrainingData();
    }
}
