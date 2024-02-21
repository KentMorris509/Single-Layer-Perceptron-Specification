import java.util.Random;

public class neuron{
    float[] weights;
    
    public neuron(int numInputs){
        this.weights = new float[numInputs];
    }

    public void createWeights(int userChoice){
        if (userChoice == 0){
            for (int i=0; i<weights.length; i++){
                weights[i] = 0;
            }
        }
        else{
            Random gen = new Random();
            for (int i=0; i<weights.length; i++){
                weights[i] = gen.nextFloat() - 0.5;
            }
        }
    }

    public boolean trainNeuron(int[] inputs, float answer, float alpha, float theta){
        float neurAns = 0;
        int y;
        boolean noChange = true;
        for (int i=0; i<inputs.length; i++){
            neurAns += inputs[i]*weights[i];
        }
        if (neurAns > theta){
            y = 1;
        }
        else if (neurAns < theta){
            y = -1;
        }
        else {
            y = 0;
        }
        if (y != answer){
            noChange = false;
            for (int i=0; i<inputs.length; i++){
                weights[i] = weights[i] + answer*inputs[i]*alpha;
            }
        }
        return noChange;
    }
    //Need to add a method that calculates and returns the answer (for non training)

    //Need a method to return the weights for storage in a file
}
