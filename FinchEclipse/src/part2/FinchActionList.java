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
package part2;
import finchRobot.Finch;
import java.util.ArrayList;

public class FinchActionList {
 
  private final String fileName;
  private ArrayList<FinchAction> actions;
  private final Finch finch;
  
  
  public FinchActionList(String fileName) {
    this.fileName = fileName;
    this.actions = null;
    this.finch = null;
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
  }
  
  public void removeAction(FinchAction finchAction){
    
  }
  
  public void removeDataBaseTable(){
    
  }
  
  public void importOrders(){
    
  }
  
  public void exportOrders(){
    
  }
  
  public void displayOrders(){
    
  }
  
  public void removeOrders(){
    
  }
  
  public void execute(String seconds) {
    
  }
  
  public void executeOrder(String order) {
    
  }

}
