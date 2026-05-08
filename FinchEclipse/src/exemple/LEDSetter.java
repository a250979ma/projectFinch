
package exemple;

import finchRobot.Finch;
import java.util.Scanner;

public class LEDSetter {
   public static void main(final String[] args) {
	   
      Finch myFinch = new Finch();
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter the red, green, and blue intensity for the LED (values from 0 to 255)");
      System.out.print("Red:  ");
      int red = sc.nextInt();
      System.out.print("Green:  ");
      int green = sc.nextInt();
      System.out.print("Blue:  ");
      int blue = sc.nextInt();
      // Potential improvement here - check the user input to make sure that it is in range (0-255) 
      System.out.println("Thanks, the beak will now glow for 8 seconds according to your specifications");
      myFinch.setLED(red,green,blue);
      myFinch.sleep(8000);
      // Always end your program with finch.quit()
      myFinch.quit();
      sc.close();
  }
}

