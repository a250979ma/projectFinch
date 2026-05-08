/*
 * FinchMove.java        1.0 Feb 1, 2022
 *
 * Models the program.
 *
 * Copyright 2022 Rafel Botey Agusti <rbotey@escoladeltreball.org>
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

package part1;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import finchRobot.Finch;

public class FinchMove extends FinchAction {

 public FinchMove(String action, Finch finch) {
  super(action, finch); 
 }

 public void execute() {
	    String[] parts = getAction().split(" ");
	    int duration = Integer.parseInt(parts[0]);
	    int leftVelocity = Integer.parseInt(parts[1]);
	    int rightVelocity = Integer.parseInt(parts[2]);
	    getFinch().setWheelVelocities(leftVelocity, rightVelocity, duration);
 }
 
 @Override
 public String toString() {
  // TO DO
  return null;
 }
 

}
