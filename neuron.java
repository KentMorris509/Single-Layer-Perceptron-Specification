import java.util.Random;

public class neuron{
    double[] weights;
    private final double weight_threshold = 0.0001;
    
    public neuron(int numInputs){
        weights = new double[numInputs];
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
                weights[i] = gen.nextDouble() - 0.5;
            }
        }
    }

    public boolean trainNeuron(int[] inputs, float answer, double alpha, double theta){
        double neurAns = 0;
        int y;
        boolean noChange = true;
        for (int i=0; i<inputs.length; i++){
            neurAns += inputs[i]*weights[i];
        }
        if (neurAns > theta){
            y = 1;
        }
        else if (neurAns < -theta){
            y = -1;
        }
        else {
            y = 0;
        }
        //account for very similar value/imperfect convergence
        if (Math.abs(y-answer) > weight_threshold){
            noChange = false;
            for (int i=0; i<inputs.length; i++){
                weights[i] = weights[i] + answer*inputs[i]*alpha;
            }
        }
        return noChange;
    }

    public int calcAnswer(int[] inputs, double theta){
        double yin = 0;
        int y;
        for (int i=0; i<inputs.length; i++){
            yin += inputs[i]*weights[i];
        }
        if (yin > theta){
            return 1;
        }
        else if (yin < -theta){
            return -1;
        }
        return 0;
    }

    public double[] getWeights(){
        return weights;
    }
}
