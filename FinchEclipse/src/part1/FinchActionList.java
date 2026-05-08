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
  public void importOrders() {
	    actions = new ArrayList<FinchAction>();
	    
	    File file = new File(fileName);
	    if (file.exists()) {
	        Reader reader = new Reader(fileName);
	        String line = reader.readLine();
	        while (line != null) {
	            if (line.startsWith("MOVE")) {
	                FinchMove move = new FinchMove(line, finch);
	                actions.add(move);
	            } else if (line.startsWith("NOSE")) {
	                FinchNose nose = new FinchNose(line, finch);
	                actions.add(nose);
	            }
	            line = reader.readLine();
	        }
	        reader.close();
	    }
	}

	public void exportOrders() {
	    Writer writer = new Writer(fileName);
	    for (FinchAction a : actions) {
	        writer.println(a.toString());
	    }
	    writer.close();
	}

	public void displayOrders() {
	    for (FinchAction a : actions) {
	        System.out.println(a.toString());
	    }
	}

	public void removeOrders() {
	    actions.clear();
	}

	public void execute(String seconds) {
	    int pause = Integer.parseInt(seconds);
	    for (FinchAction a : actions) {
	        a.execute();
	        finch.sleep(pause);
	    }
	}

	public void executeOrder(String order) {
	    String[] lines = order.split("\n");
	    for (String line : lines) {
	        if (line.startsWith("MOVE")) {
	            FinchMove move = new FinchMove(line, finch);
	            move.execute();
	        } else if (line.startsWith("NOSE")) {
	            FinchNose nose = new FinchNose(line, finch);
	            nose.execute();
	        }
	    }
	}

}

