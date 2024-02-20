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

    public void trainNeuron(int[] inputs, float answer, float alpha, float theta){
        float neurAns = 0;
        for (int i=0; i<inputs.length; i++){
            neurAns += inputs[i]*weights[i];
        }
        
    }
}
