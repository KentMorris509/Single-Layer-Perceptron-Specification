import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileWriter;

public class neuralNet {
    //initialize specified number of neurons in this class and create higher level
    //training program.
    //For actual tests, take results off all neurons and decide what result was
    //basically ties together the individual neurons
    //higher level class should handle receive output vector and interpret appropriately
    //Goal of this class and the neuron is class is to not be tied to this specific assignment
    neuron[] net;
    int numInputs;
    int numNeurons;

    public neuralNet(int numInputs, int numNeurons, double weight_threshold) {
        net = new neuron[numNeurons];
        for (int i=0; i<numNeurons; i++){
            net[i] = new neuron(numInputs, weight_threshold);
        }
        this.numInputs = numInputs;
        this.numNeurons = numNeurons;
    }

    public void initWeightViaFile(){
        //figure this out later lol
    }

    public void initWeightViaInput(int userChoice){
        for (neuron i : net){
            i.createWeights(userChoice);
        }
    }

    public int trainNet(double alpha, double theta, int maxEpochs, int testsPerEpoch, File training, File saveTo){
        boolean converged = false;
        int numOfEpochs = 0;
        Scanner inputScan = null;
        try {
            inputScan = new Scanner(training);
            //jump past the three header integers
            inputScan.nextInt();
            inputScan.nextInt();
            inputScan.nextInt();
        }
        catch(Exception e){
            System.out.println("File not found");
        }
        int[] inputs = new int[numInputs];
        int[] outputs = new int[numNeurons];

        while (!converged && numOfEpochs < maxEpochs){
            int changePerEpoch = 0;
            for (int i=0; i<testsPerEpoch; i++){
                inputs = getInputs(inputScan);
                outputs = getOutputs(inputScan);

                int changePerTest = 0;
                for (int j=0; j<numNeurons; j++){
                    boolean noChange = net[j].trainNeuron(inputs, outputs[j], alpha, theta);
                    if(!noChange){
                        changePerTest++;
                    }
                }
                if(changePerTest > 0){
                    changePerEpoch++;
                }
            }
            if(changePerEpoch == 0){
                converged = true;
            }
            numOfEpochs++;
            try {
                inputScan = new Scanner(training);
                inputScan.nextInt();
                inputScan.nextInt();
                inputScan.nextInt();
            }
            catch(Exception e) {
                System.out.println(e);
            }
            try{
                FileWriter outputScan = new FileWriter(saveTo);
                for (int n = 0; n < numNeurons; n++){
                    double[] weight_vector = net[n].getWeights();
                    int len = weight_vector.length;
                    for (int w = 0; w < len; w++){
                        if ((w+1)%7 == 0 && w != 0){
                            outputScan.write(Double.toString(weight_vector[w])+"\n");
                        }
                        else{
                            outputScan.write(Double.toString(weight_vector[w])+", ");
                        }
                    }
                    outputScan.write("\n\n");
                }
                outputScan.close();
            }
            catch(Exception e) {
                System.out.println(e);
            }
        }

        return numOfEpochs;
    }
    public int[] getInputs(Scanner inputFile){
        int[] inputs = new int[numInputs];
        for (int i=0; i<numInputs; i++){
            inputs[i] = inputFile.nextInt();
        }
        return inputs;
    }

    public int[] getOutputs(Scanner inputFile){
        int[] outputs = new int[numNeurons];
        for (int i=0; i<numNeurons; i++){
            outputs[i] = inputFile.nextInt();
        }
        String b = inputFile.next();
        return outputs;
    }

    public neuron[] getNet(){
        return net;
    }
}
