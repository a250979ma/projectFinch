/*
 * FinchNose.java        1.0 Feb 1, 2022
 *
 * Models the program.
 *
 * Copyright 2022 Rafel Botey Agusti <rbotey@escoladeltreball.org>
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

package part1;
import finchRobot.Finch;

public class FinchNose extends FinchAction {
 
 public FinchNose(String action, Finch finch) {
  super(action, finch);
 }

 public void execute() {
	    String[] parts = getAction().split(" ");
	    int red = Integer.parseInt(parts[1]);
	    int green = Integer.parseInt(parts[2]);
	    int blue = Integer.parseInt(parts[3]);
	    getFinch().setLED(red, green, blue);
	}

	@Override
	public String toString() {
	    return this.getAction();
	}
}