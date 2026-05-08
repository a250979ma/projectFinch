/*
 * FinchActionList.java        1.0 Feb 1, 2022
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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class FinchActionList {
 
  private final String fileName;
  private ArrayList<FinchAction> actions;
  private final Finch finch;
  
  
  public FinchActionList(String fileName) {
    this.fileName = fileName;
    this.actions = new ArrayList<FinchAction>();
    this.finch = new Finch();
  }
  
  public ArrayList<FinchAction> getActions() {
    return actions;
  }
  
  public Finch getFinch() {
    return finch;
  }
  
  public void setActions(ArrayList<FinchAction> actions) {
    this.actions = actions;
  }
  
  public String getFileName() {
    return fileName;
  }
  
  public void addAction(FinchAction finchAction) {
	  actions.add(finchAction);
  }
  
  public void removeAction(FinchAction finchAction){
	  actions.remove(finchAction);
  }
  
  public void removeFile(){
	  File file = new File(fileName);
	  
	  if(file.exists()) {
		  file.delete();
	  }
	  
  }
  
  public void importOrders(){
	  actions = new ArrayList<FinchAction>();
	    
	    Reader reader = new Reader(fileName);
	    String line;
	    while ((line = reader.readLine()) != null) {
	        String[] parts = line.trim().split("\\s+");
	        
	        if (parts[0].equals("MOVE")) {
	            String actionData = parts[1] + " " + parts[2] + " " + parts[3];
	            FinchMove move = new FinchMove(actionData, finch);
	            actions.add(move);
	        } 
	        else if (parts[0].equals("NOSE")) {
	            String actionData = parts[1] + " " + parts[2] + " " + parts[3];
	            FinchNose nose = new FinchNose(actionData, finch);
	            actions.add(nose);
	        }
	    }
	    reader.close();
  
  }
  
  public void exportOrders(){
	  Writer writer = new Writer(fileName);
	    for (FinchAction a : actions) {
	        writer.println(a.toString());
	    }
	    writer.close();
	  
  }
  
  public void displayOrders(){
	   System.out.println("=== Llista d'ordres ===");
	   for (int i = 0; i < actions.size(); i++) {
		   System.out.println((i+1) + ". " + actions.get(i).toString());
	   }
	   System.out.println("========================");
  }
  
  public void removeOrders(){
	  this.actions.clear();
  }
  
  public void execute(String seconds) {
      int pause = Integer.parseInt(seconds) * 1000;
      
      for (FinchAction action : actions) {
          action.execute();
          try {
              Thread.sleep(pause);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
  }
  
  public void executeOrder(String order) {
	  try {
          int index = Integer.parseInt(order);
          if (index >= 0 && index < actions.size()) {
              actions.get(index).execute();
          } else {
              System.err.println("Índice fuera de rango");
          }
      } catch (NumberFormatException e) {
          System.err.println("Debe proporcionar un número de orden");
      }
  }

}