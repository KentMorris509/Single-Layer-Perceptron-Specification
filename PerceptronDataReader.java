import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PerceptronDataReader {

    private int inputDimension;
    private int outputDimension;
    private int numberOfPairs;

    public PerceptronDataReader(String fileName) {
        readHeader(fileName);
    }

    public int[] getVectorArray(String fileName, int lineNumber) {
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Skipping the header lines
            for (int i = 0; i < 3; i++) {
                bufferedReader.readLine();
            }

            // Reading the line containing the vector array
            String line = bufferedReader.readLine();
            String[] values = line.split("\\s+");

            // Parsing the values into an array of integers
            int[] vectorArray = new int[values.length];
            for (int i = 0; i < values.length; i++) {
                vectorArray[i] = Integer.parseInt(values[i]);
            }

            bufferedReader.close();
            fileReader.close();

            return vectorArray;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getStringPair(String fileName, int lineNumber) {
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Skipping the header lines and reading until the desired line
            for (int i = 0; i < 3 + lineNumber; i++) {
                bufferedReader.readLine();
            }

            // Reading the line containing the string pair
            String line = bufferedReader.readLine();

            bufferedReader.close();
            fileReader.close();

            return line;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int[] getTargetVectorArray(String fileName, int lineNumber) {
        // Similar to getVectorArray, modify as needed based on your file format
        // ...

        return null;
    }

    private void readHeader(String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Reading the first 3 lines of the file for dimension information
            inputDimension = Integer.parseInt(bufferedReader.readLine().trim());
            outputDimension = Integer.parseInt(bufferedReader.readLine().trim());
            numberOfPairs = Integer.parseInt(bufferedReader.readLine().trim());

            bufferedReader.close();
            fileReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getInputDimension() {
        return inputDimension;
    }

    public int getOutputDimension() {
        return outputDimension;
    }

    public int getNumberOfPairs() {
        return numberOfPairs;
    }
}