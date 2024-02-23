import java.util.*;

public class proj1 {
    
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to my first neural network - A Perceptron Net!\n");
        System.out.println("Enter 1 to train using a training data file, enter 2 to use a trained weight settings data file:");
        int userTrainDecision = scan.nextInt();
        if (userTrainDecision == 1){
            System.out.println("\nEnter the training data file name:");
            String dataFileName = scan.next();
            System.out.println(dataFileName);
            PerceptronDataReader reader = new PerceptronDataReader(dataFileName);

            System.out.println("\nEnter 0 to initialize weights to 0, enter 1 to initialize weights to random values between -0.5 and 0.5:");
            int userInitWeight = scan.nextInt();

            System.out.println("\nEnter the maximum number of training epochs:");
            int maxEpochs = scan.nextInt();

            System.out.println("\nEnter a file name to save the trained weight settings:");
            String trainedWeightFileName = scan.next();

            System.out.println("\nEnter the learning rate alpha from 0 to 1 but not including 0:");
            double learningRateAlpha = scan.nextDouble();

            System.out.println("Enter the threshold theta:");
            double thresholdTheta = scan.nextDouble();

            System.out.println("Enter the threshold to be used for measuring weight changes:");
            double weightThreshold = scan.nextDouble();
        }
        else if (userTrainDecision == 2){
            System.out.println("Enter the trained weight settings input data file name:");
            String trainingWeightFileName = scan.next();
        }
        else{
            System.out.println("Wrong Input");
        }







        
    }
}
