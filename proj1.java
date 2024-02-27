import java.util.Scanner;
import java.io.File;
 class proj1{

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to my Perceptron neural net!");
        System.out.println("\nEnter 1 to train using a training data file\nEnter 2 to use pretrained weights");
        int userChoice = scan.nextInt();
        while (userChoice > 2 || userChoice < 1){
            System.out.println("invalid entry, please enter 1 or 2");
            userChoice = scan.nextInt();
        }
        if (userChoice == 1){
            System.out.println("Enter the training data file name: ");
            String trainingFile = scan.next();
            int[] inOut = getInputAndOutputSize(trainingFile);
            neuralNet perceptron = new neuralNet(inOut[0], inOut[1]);

            System.out.println("Enter 0 for initial weights = 0. Enter 1 to randomize weights: ");
            int weightChoice = scan.nextInt();
            perceptron.initWeightViaInput(weightChoice);

            System.out.println("Enter the maximum number of epochs: ");
            int maxEpochs = scan.nextInt();
            System.out.println("Enter a filename to save weights to: ");
            String saveToFile = scan.next();
            System.out.println("Enter the learning rate alpha from 0 to 1, not including 0: ");
            double alpha = scan.nextDouble();
            System.out.println("Enter the threshold theta: ");
            double theta = scan.nextDouble();

            System.out.println("Enter the threshold to be used for measuring weight changes: ");
            double weightChangeThreshold = scan.nextDouble();

            int timeToConverge = perceptron.trainNet(alpha, theta, maxEpochs, inOut[2], new File(trainingFile), new File(saveToFile));
            System.out.println("Training converged after " + timeToConverge +" epochs.");
        }
    }

    public static int[] getInputAndOutputSize(String filename){
        int[] inputOutput = new int[3];
        try {
            Scanner fileScan = new Scanner(new File(filename));
            inputOutput[0] = fileScan.nextInt();
            inputOutput[1] = fileScan.nextInt();
            inputOutput[2] = fileScan.nextInt();
        }
        catch (Exception e){
            System.out.println("File not found. Exiting");
            System.exit(1);
        }
        return inputOutput;
    }
}