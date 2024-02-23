public class neuralNet {
    //initialize specified number of neurons in this class and create higher level
    //training program.
    //For actual tests, take results off all neurons and decide what result was
    //basically ties together the individual neurons
    //higher level class should handle receive output vector and interpret appropriately
    //Goal of this class and the neuron is class is to not be tied to this specific assignment
    neuron[] net;

    public neuralNet(int numInputs, int numNeurons) {
        net = new neuron[numNeurons];
        for (int i=0; i<numNeurons; i++){
            net[i] = new neuron(numInputs);
        }
    }


    public void initWeightViaInput(int userChoice){
        for (neuron i : net){
            i.createWeights(userChoice);
        }
    }

    public int trainNet(double alpha, double theta){
        boolean converged = false;
        int numOfEpochs = 0;
        int testsPerEpoch;
        //add some file reading stuff for inputs here??
        while (!converged){
            for (int i=0; i<testsPerEpoch; i++){

            }
        }

        return numOfEpochs;
    }
}
