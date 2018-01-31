/*
Lukas Heading
LPHZQD
18131083
8/29/16
 */
package lphzqdlanguagebasics;

/**
 *
 * @author lukas
 */
public class LphzqdLanguageBasics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        byte sample1 = 0x3A;
        byte sample2 = 58;
        short heartRate = 85;
        long deposits = 135002796;
        float acceleration = 9.584f;
        float mass = 14.6f;
        double distance = 129.763001;
        boolean lost = true;
        boolean expensive = true;
        int choice = 1;
        char intergral = '\u222b';
        char letter1 = 'a';
        char letter2 = 97;
        String greeting = "Hello";
        String name = "Karen";
        
        if(sample1 == sample2){
            System.out.println("The samples are equal.");
        }
        
        if(sample1 != sample2){
            System.out.println("The samples are not equal.");
        }
        
        if((heartRate > 40) && (heartRate < 80)){
            System.out.println("Heart rate is normal.");
        }
        
        if((heartRate > 80) || (heartRate < 40)){
            System.out.println("Heart rate is not normal.");
        }
        
        if(deposits >= 100000000){
            System.out.println("You are exceedingly wealthy.");
        }
        
        if(deposits < 100000000){
            System.out.println("You are exceedingly wealthy.");
        }
        
        float force = (mass * acceleration);
        
        System.out.printf("force = %f\n", force);
        
        System.out.printf("%f is the distance\n", distance);
        
        if((lost == true) && (expensive == true)){
            System.out.println("I am really sorry! I will get the manager.");
        }
        
        if((lost == true) && (expensive == false)){
            System.out.println("Here is coupon for 10% off.");
        }
        
        switch(choice){
            case 1: 
                    System.out.println("You chose 1");
                     break;
            case 2: 
                    System.out.println("You chose 2");
                    break;
            case 3: 
                    System.out.println("You chose 3");
                    break;
            default:
                    System.out.println("You made an unknown choice");
                    break;
        }
        
        System.out.printf("%c is an integral\n",intergral);
        
        if(letter1 == letter2){
            System.out.printf("%c and %c are the same\n",letter1, letter2);
        }
        
        if(letter1 != letter2){
            System.out.printf("%c and %c are not the same\n",letter1, letter2);
        }
        
        for(int i = 5; i<11; i++){
           System.out.println("i = " + i);
        }
        int age = 0;
        while(age < 6) {
           System.out.println("age = " + age);
           age++;
        }
        System.out.println(greeting + " " + name);
    }
    
}
