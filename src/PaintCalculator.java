import java.util.*;
public class PaintCalculator {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        System.out.println("Paint Calculator\n");

        //Get amount of rooms

        int rooms_amount;

        do{
            System.out.print("How many rooms are you painting? ");
            rooms_amount = sc.nextInt();
        }
        while(rooms_amount <= 0);

        //Declare arrays to store user input

        double [][] room_sizes = new double[rooms_amount][3];
        char [] ceilings = new char [rooms_amount];
        double [] obstructions = new double [rooms_amount];
        double [] room_area = new double[rooms_amount];
        double final_area = 0;


        //Get paint area info for each room
        for(int i = 0; i<rooms_amount; i++){

            //Get Room dimensions

            System.out.println("Please enter the length of room "+ (i+1) + ":");
            room_sizes [i][0] = sc.nextDouble();
            System.out.println("Please enter the breadth of room "+ (i+1) + ":");
            room_sizes [i][1] = sc.nextDouble();
            System.out.println("Please enter the height of room "+ (i+1) + ":");
            room_sizes [i][2] = sc.nextDouble();
            System.out.println("Are you painting the ceiling in this room? (y or n)");
            ceilings [i] = sc.next().charAt(0);

            //Calculate room area and add ceiling if required

           room_area [i] = (2*(room_sizes [i][0] + room_sizes [i][1])*room_sizes[i][2]);

            if (ceilings [i]=='y'){
                room_area [i] = room_area [i] + (room_sizes [i][0]*room_sizes [i][1]);
            }

            //Get Info on doors

            System.out.print("How many doors in this room?");
            int num_doors = sc.nextInt();
            double [][] doors = new double [num_doors][2];
            double door_area = 0;

            for(int j = 0; j<num_doors; j++){
                System.out.println("Please enter the height of door " + (j+1) + ":");
                doors[j][0] = sc.nextDouble();
                System.out.println("Please enter the breadth of door " + (j+1) + ":");
                doors[j][1] = sc.nextDouble();
                door_area = door_area + (doors[j][0]*doors[j][1]);

            }

            //Get Info on Windows

            System.out.print("How many windows in this room?");
            int num_windows = sc.nextInt();
            double [][] windows = new double [num_windows][2];
            double window_area = 0;

            for(int k = 0; k<num_windows; k++){
                System.out.println("Please enter the height of window " + (k+1) + ":");
                windows[k][0] = sc.nextDouble();
                System.out.println("Please enter the breadth of window " + (k+1) + ":");
                windows[k][1] = sc.nextDouble();
                window_area = window_area + (windows[k][0]*windows[k][1]);

            }

            //Get Info on other obstacles

            System.out.print("How many other obstacles are there in this room (e.g. sockets)?");
            int num_other = sc.nextInt();
            double [][] other = new double [num_other][2];
            double other_area = 0;

            for(int l = 0; l<num_other; l++){
                System.out.println("Please enter the height of the obstacle " + (l+1) + ":");
                other[l][0] = sc.nextDouble();
                System.out.println("Please enter the breadth of the obstacle " + (l+1) + ":");
                other[l][1] = sc.nextDouble();
                other_area = other_area + (other[l][0]*other[l][1]);
            }
            //Add to the running total of area and correct for doors/windows/obstacles

            obstructions [i] = (window_area + door_area + other_area);
            final_area = final_area + room_area [i] -obstructions [i];

        }

        //Get brand of paint and set a cost factor to calculate cost

        int brand = 0;
        double cost_factor = 0;

        while(brand<1 || brand>3){
            System.out.println("\nPlease select the brand of paint you are using:\nPlease type 1,2 or 3\n");
            System.out.println("1. Homebase\n2. Dulux\n3. Farrow and Ball");
            brand = sc.nextInt();
        }

        switch (brand) {
            case 1 -> cost_factor = 4;
            case 2 -> cost_factor = 6;
            case 3 -> cost_factor = 15;
        }

        //Round off number and multiply by 0.1 to give amount of paint needed
        double paint_rounded = (double) Math.round(final_area*100)/1000;

        //Show results

        System.out.println("You need " + (paint_rounded) + " total litres of Paint for this job. ");
        System.out.println("This will cost £" + (cost_factor*paint_rounded));

        for(int i = 0; i<rooms_amount; i++){
            System.out.println("Room " + (i+1) + " needs " + (room_area[i]*0.1) + " litres");
        }

    }

}
