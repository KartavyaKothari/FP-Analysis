import java.util.*;

class UserResponse{
    int noOfInputs;
    int noOfOutputs;
    int noOfEnquiries;
    int noOfFiles;
    int noOfInterfaces;
}

class FP {

    static UserResponse getUserResponse(){
        Scanner sc = new Scanner(System.in);
        UserResponse ur = new UserResponse();
        
        Sytem.out.print("How many inputs expected? ");
        ur.noOfInputs = sc.nextInt();
        Sytem.out.print("How many outputs expected? ");
        ur.noOfOutputs = sc.nextInt();
        Sytem.out.print("How many enquiries expected? ");
        ur.noOfEnquiries = sc.nextInt();
        Sytem.out.print("How many files expected? ");
        ur.noOfFiles = sc.nextInt();
        Sytem.out.print("How many interfaces expected? ");
        ur.noOfInterfaces = sc.nextInt();
        
        return ur;
    }
    
    static int getCountTotal(UserResponse ur, int metrics[]){
        int countTotal = ur.noOfInputs*metrics[0]+
                            ur.noOfOutputs*metrics[1]+
                            ur.noOfEnquiries*metrics[2]+
                            ur.noOfFiles*metrics[3]+
                            ur.noOfInterfaces*metrics[4];
        
        return countTotal;
    }
        
    public static void main(String[] args) {
        int metricsS[] = {3,4,3,7,5};
        int metricsA[] = {4,5,4,10,7};
        int metricsC[] = {6,7,6,15,10};
        
        Scanner sc = new Scanner(System.in);
        
        int response;
        
        System.out.print("Is it expected to be\n1 - simple\n2 - average\n3 - complex\nResponse: ");
        response = sc.nextInt();
        
        UserResponse ur = getUserResponse();
        
        int countTotal;
        
        switch(response){
            case 1: countTotal = getCountTotal(ur,metricsS);
                    break;
            case 2: countTotal = getCountTotal(ur,metricsA);
                    break;
            case 3: countTotal = getCountTotal(ur,metricsC);
                    break;
        }
        
        int adjustmentFactor = getVAF();
        
        double fp = countTotaL*(0.65+0.01*adjustmentFactor);
        
        if(fp<50){
            System.out.println("System FP not in expected range, redo the analysis, please :)");
        }else if(fp<70){
            if(response == 1){
                System.out.println("System FP in expected range :) (Simple system)");
            } else System.out.println("System FP not in expected range, redo the analysis, please :)");
        }else if(fp<80){
            if(response == 2){
                System.out.println("System FP in expected range :) (Average system)");
            } else System.out.println("System FP not in expected range, redo the analysis, please :)");
        }else if(fp<100){
            if(response == 3){
                System.out.println("System FP in expected range :) (Complex system)");
            } else System.out.println("System FP not in expected range, redo the analysis, please :)");
        }
    }
}
