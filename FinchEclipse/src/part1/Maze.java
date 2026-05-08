package part1;
import finchRobot.Finch;
import java.util.Scanner;

public class Maze {
    
    private FinchActionList actionList;
    private Scanner scanner;
    
    public Maze() {
        scanner = new Scanner(System.in);
        System.out.print("Nom de l'arxiu d'ordres: ");
        String fileName = scanner.nextLine();
        actionList = new FinchActionList(fileName);
    }
    
    public void showMenu() {
        int option;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Executar una ordre/s");
            System.out.println("2. Importar ordres d'un arxiu");
            System.out.println("3. Exportar ordres a un arxiu");
            System.out.println("4. Afegir una ordre");
            System.out.println("5. Esborrar una ordre");
            System.out.println("6. Executar totes les ordres");
            System.out.println("7. Esborrar l'arxiu que conte les ordres");
            System.out.println("8. Llistar les ordres per pantalla");
            System.out.println("9. Esborrar totes les ordres");
            System.out.println("0. Sortir");
            System.out.print("Opcio: ");
            
            option = scanner.nextInt();
            scanner.nextLine();
            
            switch(option) {
                case 1:
                    executeOrderMenu();
                    break;
                case 2:
                    importOrdersMenu();
                    break;
                case 3:
                    exportOrdersMenu();
                    break;
                case 4:
                    addActionMenu();
                    break;
                case 5:
                    removeActionMenu();
                    break;
                case 6:
                    executeAllMenu();
                    break;
                case 7:
                    removeFileMenu();
                    break;
                case 8:
                    displayOrdersMenu();
                    break;
                case 9:
                    removeOrdersMenu();
                    break;
                case 0:
                    System.out.println("Adeu!");
                    actionList.getFinch().quit();
                    break;
                default:
                    System.out.println("Opcio no valida");
            }
        } while(option != 0);
    }
    
    private void executeOrderMenu() {
        System.out.println("Introdueix les ordres (escriu 'FI' per acabar):");
        StringBuilder orders = new StringBuilder();
        String line;
        while(true) {
            line = scanner.nextLine();
            if(line.equals("FI")) break;
            orders.append(line).append("\n");
        }
        actionList.executeOrder(orders.toString());
    }
    
    private void importOrdersMenu() {
        actionList.importOrders();
        if (actionList.getActions().isEmpty()) {
            System.out.println("No s'han carregat ordres (el fitxer pot estar buit o no existir)");
        } else {
            System.out.println("Ordres importades");
        }
    }
    
    private void exportOrdersMenu() {
        actionList.exportOrders();
        System.out.println("Ordres exportades");
    }
    
    private void addActionMenu() {
        System.out.print("Tipus (MOVE/NOSE): ");
        String type = scanner.nextLine();
        
        if(type.equals("MOVE")) {
            System.out.print("Durada leftVelocity rightVelocity: ");
            String data = scanner.nextLine();
            FinchMove move = new FinchMove("MOVE " + data, actionList.getFinch());
            actionList.addAction(move);
        } 
        else if(type.equals("NOSE")) {
            System.out.print("Red Green Blue: ");
            String data = scanner.nextLine();
            FinchNose nose = new FinchNose("NOSE " + data, actionList.getFinch());
            actionList.addAction(nose);
        }
        System.out.println("Ordre afegida");
    }
    
    private void removeActionMenu() {
        actionList.displayOrders();
        System.out.print("Numero de l'ordre a esborrar: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        
        if(index > 0 && index <= actionList.getActions().size()) {
            FinchAction action = actionList.getActions().get(index - 1);
            actionList.removeAction(action);
            System.out.println("Ordre esborrada");
        }
    }
    
    private void executeAllMenu() {
        System.out.print("Pausa entre ordres (ms): ");
        String seconds = scanner.nextLine();
        actionList.execute(seconds);
    }
    
    private void removeFileMenu() {
        actionList.removeFile();
        System.out.println("Arxiu esborrat");
    }
    
    private void displayOrdersMenu() {
        actionList.displayOrders();
    }
    
    private void removeOrdersMenu() {
        actionList.removeOrders();
        System.out.println("Totes les ordres esborrades");
    }
    
    public static void main(String[] args) {
        Maze maze = new Maze();
        maze.showMenu();
    }
}