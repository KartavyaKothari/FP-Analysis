import java.util.*;

class UserResponse {

    int noOfInputs;
    int noOfOutputs;
    int noOfEnquiries;
    int noOfFiles;
    int noOfInterfaces;
}

class FP{

    static int getVAF() {

        Scanner sc = new Scanner(System.in);

        int sum = 0;
        int vaf[] = new int[14];

        String ques[] = {

            "The data and communication between the process - ",
            "Data backup and recovery in case of failure - ",
            "Questions related with the design of network for which the system is build - ",
            "Questions related with operating environment - ",
            "Questions related with the installation procedures - ",
            "Data entry related details whether they are online data entries or offline data entries for serving the requests - ",
            "Questions related with performance and its criticality - ",
            "Is the system adaptable to changes - ",
            "This change information about the reusable components - ",
            "Questions related with updation of data maintained in local or master files - ",
            "Is it related with the design models delivered time to time with and without changes - ",
            "Input processing complexities which are useful during test case generation - ",
            "The information being processed and displayed on single or multiple screens - ",
            "The information domain values need to be identified - "
        };

        System.out.println();
        System.out.println("Enter values between 0-4 :");
        System.out.println();

        for (int i=0; i<14; i++) {

            System.out.print(ques[i]);
            vaf[i] = sc.nextInt();

            if ((vaf[i] < 0) || (vaf[i] > 4)) {

                System.out.println("Enter values between 0-4 !!!!");
                return 0;
            }

            sum = sum + vaf[i];
        }

        return sum;
    }

    static UserResponse getUserResponse() {

        Scanner sc = new Scanner(System.in);
        UserResponse ur = new UserResponse();

        System.out.print("How many inputs expected? - ");
        ur.noOfInputs = sc.nextInt();

        System.out.print("How many outputs expected? - ");
        ur.noOfOutputs = sc.nextInt();

        System.out.print("How many enquiries expected? - ");
        ur.noOfEnquiries = sc.nextInt();

        System.out.print("How many files expected? - ");
        ur.noOfFiles = sc.nextInt();

        System.out.print("How many interfaces expected? - ");
        ur.noOfInterfaces = sc.nextInt();

        return ur;
    }

    static int getCountTotal(UserResponse ur, int metrics[]) {

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

        System.out.print("Is it expected to be\n\n1 - simple\n2 - average\n3 - complex\n\nResponse: ");
        response = sc.nextInt();
        System.out.println();

        UserResponse ur = getUserResponse();

        int countTotal = 0;

        switch(response) {

            case 1: countTotal = getCountTotal(ur,metricsS);
                    break;

            case 2: countTotal = getCountTotal(ur,metricsA);
                    break;

            case 3: countTotal = getCountTotal(ur,metricsC);
                    break;
        }

        System.out.println();
        System.out.println("Count total = " + countTotal);

        int adjustmentFactor = getVAF();

        double fp = countTotal*(0.65+0.01*adjustmentFactor);

        System.out.println();
        System.out.println("FP = "+fp);
        System.out.println();

        if(fp<50) {

            System.out.println("System FP not in expected range, redo the analysis, please :)");
        }

        else if(fp<70) {

            if(response == 1) {

                System.out.println("System FP in expected range :) (Simple system)");
            }

            else System.out.println("System FP not in expected range, redo the analysis, please :)");
        }

        else if(fp<80) {

            if(response == 2) {

                System.out.println("System FP in expected range :) (Average system)");
            }

            else System.out.println("System FP not in expected range, redo the analysis, please :)");
        }

        else if(fp<100) {

            if(response == 3) {

                System.out.println("System FP in expected range :) (Complex system)");
            }

            else System.out.println("System FP not in expected range, redo the analysis, please :)");
        }

        else System.out.println("System FP not in expected range, redo the analysis, please :)");
    }
}
