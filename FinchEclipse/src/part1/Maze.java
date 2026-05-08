/*
 * Maze.java        1.0 Feb 1, 2022
 *
 * Models the program.
 *
 * Copyright 2022 Rafel Botey Agusti <rbotey@escoladeltreball.org>
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

package part1;
import java.security.AlgorithmConstraints;
import java.util.concurrent.Delayed;

import javax.naming.ldap.PagedResultsControl;

import org.apache.commons.collections.functors.IfClosure;

import finchRobot.Finch;
import java.util.Scanner;

public class Maze {
	
	public void mechanism(int derecha, int izquierda, int tiempo, Finch myFinch) {
		myFinch.setWheelVelocities(derecha, izquierda, tiempo);
	}
	
	
	
	
	 public static void main(String[] args) {
		 Maze maze = new Maze();
		 Finch myFinch = new Finch();
		 boolean algo  = false;
		 int numero1 = 0;
		 int numero2 = 0;
		 int numero3 = 0;
		 int seguir = 0;
		 Scanner s = new Scanner(System.in);
		 System.out.println("deseas moverte? 0 = si, 1 = no");
		 seguir = s.nextInt();
		 if (seguir == 1) {
			 algo = true;
		 }
		 while (!algo) {
			 System.out.println("cuanto quieres moverte a la derecha? del -255 al 255");
			 numero1 = s.nextInt();
			 System.out.println("cuanto quieres moverte a la izquierda? del -255 al 255");
			 numero2 = s.nextInt();
			 System.out.println("cuanto tiempo? en ms");
			 numero3 = s.nextInt();
			 maze.mechanism(numero1, numero2, numero3, myFinch);
			 System.out.println("deseas moverte? 0 = si, 1 = no");
			 seguir = s.nextInt();
			 if (seguir == 1) {
				 algo = true;
			 }
		 }
		 
		
	 }
	
}
