import java.util.*;

class FP {

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

            System.out.println();
            System.out.print(ques[i]);
            vaf[i] = sc.nextInt();

            sum = sum + vaf[i];
        }

        return sum;
    }

    public static void main(String[] args) {

    }
}
