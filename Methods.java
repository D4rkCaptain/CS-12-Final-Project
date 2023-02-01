import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import  java.util.Comparator;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;

//Declaring a class Methods 
public class Methods {
    
    //ArrayList woodsList to store objects of type Woods
    static ArrayList<Woods> woodsList = new ArrayList<>();

    //ArrayList metalsList to store objects of type Metals
    static ArrayList<Metals> metalsList = new ArrayList<>();

    //A variable counterWood to keep track of number of woods
    static int counterWood = 1;

    //A variable counterMetals to keep track of number of woods
    static int counterMetals = 1;



    /*****************************************
   * /*Method Name: ShowWoodlist
   * /*Programmer Name: Ali Karimi
   * /*Method Date: 1/30/2023
   * /*Method Description: This Method showes the list of all Items + their characteristics and its called from the main File
   * /*Method Inputs/Outputs: input: User inputs
   * output: List of all Items with their characteristics.
   ******************************************/
    public static void ShowWoodList() {

        //If the list is empty, it shows a message
        if (woodsList.isEmpty()) {
            System.out.println("The list is empty");

        //Otherwise, it shows the list of woods with table format
        } else {
            System.out.println("This is your Wood list.");
            //A variable to keep count of woods in the list
            int counter2 = 1;

            //Showing the header for table
            System.out.println("______________________________________________________________________________________________");
            //Displaying the columns with table format
            System.out.println(String.format("| %4s | %-15s | %-10s | %-15s | %-15s| %-15s|", "List", "Wood number code", "Wood Type", "Wood Weight (Kg)", "Wood Space(M^2)", "Wood Value($/Kg)"));
            System.out.println("______________________________________________________________________________________________");
    
            //Iterating through the list to display all the woods in table format
            for (Woods wood : woodsList) {
                System.out.println(String.format("| %4d | %-15s  | %-10s | %-15.2f | %-15.2f | %-15.2f |", counter2, wood.getName(), wood.getItemType(), wood.getItemWeight(), wood.getItemSpaceOccupied(), wood.getItemValue()));
                System.out.println("______________________________________________________________________________________________");
                //Increasing the counter2 by 1
                counter2 += 1;
            }
        }
    }


      /*****************************************
   * /*Method Name: ShowWoodlist
   * /*Programmer Name: Ali Karimi
   * /*Method Date: 1/30/2023
   * /*Method Description: This Method showes the list of all Items + their characteristics and its called from the main File
   * /*Method Inputs/Outputs: input: User inputs
   * output: List of all Items with their characteristics.
   ******************************************/
    public static void ShowMetalsList() {

        //If the list is empty, it shows a message
        if (woodsList.isEmpty()) {
            System.out.println("The list is empty");

        //Otherwise, it shows the list of woods with table format
        } else {
            System.out.println("This is your Metals list.");
            //A variable to keep count of woods in the list
            int counter2 = 1;

            //Showing the header for table
            System.out.println("_________________________________________________________________________________________________");
            //Displaying the columns with table format
            System.out.println(String.format("| %4s | %-15s | %-10s | %-15s | %-15s| %-15s|", "List", "Metal number code", "Metal Type", "Metal Weight (Kg)", "Metal Space(M^2)", "Metal Value($/Kg)"));
            System.out.println("_________________________________________________________________________________________________");

            //Iterating through the list to display all the woods in table format
            for (Metals metal : metalsList) {
                System.out.println(String.format("| %4d | %-15s  | %-10s | %-15.2f | %-15.2f | %-15.2f |", counter2, metal.getName(), metal.getItemType(), metal.getItemWeight(), metal.getItemSpaceOccupied(), metal.getItemValue()));
                System.out.println("_________________________________________________________________________________________________");
                //Increasing the counter2 by 1
                counter2 += 1;
            }
    }
}


    /*****************************************
   * /*Method Name: Add to List
   * /*Programmer Name: Ali Karimi
   * /*Method Date: 1/30/2023
   * /*Method Description: Ask the use about the new I tem and add it to the array list
 
   * /*Method Inputs/Outputs: input: User inputs
   * output: A new memeber added to the list of Items
   ******************************************/
    public static void Add() {


        //Creating an object of Scanner class to take input from user
        Scanner scanner = new Scanner(System.in);
        //A variable to store the type of item user wants to add
        String item = "";
        //A variable to exit the loop when user enters valid input
        int commandExit = 0;
        
        //A infinite loop to ask for type of item user wants to add, until he enters valid input
        while(true) {

            //A loop to ask for type of item user wants to add, until he enters valid input
            while (true){
                System.out.println("What Item would you like to add?(Type Wood for Wood),(Type Metal for Metals)");
                //Taking input from user for type of item
                String commandItem = scanner.nextLine();
                //If user entered "Wood", setting item variable to "Wood" and breaking the loop
                if (commandItem.equals("Wood")){
                    item = commandItem;
                    break;
                } else if (commandItem.equals("Metal")) {
                    item = commandItem;
                    break;   
                } else {
                  System.out.println("Invalid input. Please try again");
                }
                
            }
    
            // Check if item selected is "Wood"
            if (item.equals("Wood")) {
                // Reset item variable
                item = "";
                // Read input for wood type
                System.out.println("Enter Wood Type:");
                // Read input for wood type
                String woodType = scanner.nextLine();

                float weight = 0;
                // Loop to get valid weight input
                while(true){
                    System.out.println("Enter Wood Weight(Kg):");
                    String woodWeight = scanner.nextLine();
                    
                    try {
                        // Try to parse the input to float
                        weight = Float.parseFloat(woodWeight);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number for wood weight.");
                    }
                }
                
                float space = 0;
                // Loop to get valid space occupied input
                while(true){
                    System.out.println("Enter Wood Space Occupied(Metre squared):");
                    String woodSpaceOccupied = scanner.nextLine();
                    
                    try {
                        // Try to parse the input to float
                        space = Float.parseFloat(woodSpaceOccupied);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number for wood space occupied.");
                        
                    }
                }
                
                float value = 0;
                // Loop to get valid value input
                while(true){
                    System.out.println("Enter Wood Value($ per Kg):");
                    String woodValue = scanner.nextLine();
                    
                    try {
                        // Try to parse the input to float
                        value = Float.parseFloat(woodValue);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number for wood value.");
                        
                    }
                }
                
                // Create new Wood object with inputs
                Woods newWood = new Woods(woodType, weight, space, value);
                // Set name of the Wood object
                newWood.setName("Wood " + counterWood);
                // Add Wood object to the list
                woodsList.add(newWood);
                // Increment counter for Wood
                counterWood++;
                System.out.println("The Wood has succesfully added!");
                // Break out of the loop
                break;



            } else if(item.equals("Metal")) {
                // Reset item variable
                item = "";
                // Read input for Metal type
                System.out.println("Enter Metal Type:");
                // Read input for Metal type
                String MetalsType = scanner.nextLine();

                float weight = 0;
                // Loop to get valid weight input
                while(true){
                    System.out.println("Enter Metal Weight(Kg):");
                    String MetalWeight = scanner.nextLine();
                    
                    try {
                        // Try to parse the input to float
                        weight = Float.parseFloat(MetalWeight);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number for Metal weight.");
                    }
                }
                
                float space = 0;
                // Loop to get valid space occupied input
                while(true){
                    System.out.println("Enter Metal Space Occupied(Metre squared):");
                    String MetalSpaceOccupied = scanner.nextLine();
                    
                    try {
                        // Try to parse the input to float
                        space = Float.parseFloat(MetalSpaceOccupied);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number for Metal space occupied.");
                        
                    }
                }
                
                float value = 0;
                // Loop to get valid value input
                while(true){
                    System.out.println("Enter Metal Value($ per Kg):");
                    String MetalValue = scanner.nextLine();
                    
                    try {
                        // Try to parse the input to float
                        value = Float.parseFloat(MetalValue);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number for Metal value.");
                        
                    }
                }
                
                // Create new Metal object with inputs
                Metals newMetal = new Metals(MetalsType, weight, space, value);
                // Set name of the Metal object
                newMetal.setName("Metal " + counterWood);
                // Add Metal object to the list
                metalsList.add(newMetal);
                // Increment counter for Metal
                counterMetals++;
                System.out.println("The Metal has succesfully added!");
                // Break out of the loop
                break;

            }




              
        }
  
        
    }
    


    /*****************************************
   * /*Method Name: Remove from the list
   * /*Programmer Name: Ali Karimi
   * /*Method Date: 1/30/2023
   * /*Method Description: Ask the user that which value they want to remove from the list
 
   * /*Method Inputs/Outputs: input: User inputs
   * output: A member removed from the list of Items
   ******************************************/
    public static void Remove() {

         // Create a scanner object to get input from the user
        Scanner scanner = new Scanner(System.in);

        // Check if the list of woods is empty
        if (woodsList.isEmpty()) {
            //System.out.println("The list is empty");

         // If the list is not empty, prompt user to remove an item
        } else {

            // Run a loop to allow the user to continue to remove items
            while (true) {
                System.out.println("Please selecet the number before the name to Remove Item. If you dont want to delete, Please Type Back ");
                String commandRemove = scanner.nextLine();

                // Check if user input is "Back"
                if (commandRemove.equals("Back")) {
                    break;
                }
                // Try to parse the user input as an integer
                try {
                    int index = Integer.parseInt(commandRemove);
                    // Check if the input number is between 1 and the size of the list
                    if (index < 1 || index > woodsList.size()) {
                        System.out.println("Invalid input. Please enter a number between 1 and " + woodsList.size());

                     // If the input is valid, remove the item from the list and print a success message
                    } else {
                        woodsList.remove(index-1);
                        System.out.println("Item removed successfully");
                        break;
                    }
                } catch (NumberFormatException e) {
                    // If the input is not an integer, print an error message
                    System.out.println("Invalid input. Please enter a valid number or 'Back'");
                }
            }
        }
    }


    /*****************************************
   * /*Method Name: Sorting the list
   * /*Programmer Name: Ali Karimi
   * /*Method Date: 1/30/2023
   * /*Method Description: Ask the user which criteria they choose for Sorting 
 
   * /*Method Inputs/Outputs: input: User inputs
   * output: optimize the list based on the criteria choosen
   ******************************************/
    public static void sort() {
        // Create a scanner object to get input from the user
        Scanner scanner = new Scanner(System.in);

        // Run a loop to prompt user for sorting criteria
        while (true){
            System.out.println("What criteria would you choose? (Weight)(Space)(Value)");
            String criteria = scanner.nextLine();


            // Check if the user input is "Weight"
            if (criteria.equalsIgnoreCase("Weight")) {
                // Sort the list of woods by weight using a custom comparator
                woodsList.sort(new Comparator<Woods>() {
                    @Override
                    public int compare(Woods o1, Woods o2) {
                        return Float.compare(o2.getItemWeight(), o1.getItemWeight());
                    }
                });
                break;
            }
            // Check if the user input is "Space"
            else if (criteria.equalsIgnoreCase("Space")) {
                // Sort the list of woods by space occupied using a custom comparator
                woodsList.sort(new Comparator<Woods>() {
                    @Override
                    public int compare(Woods o1, Woods o2) {
                        return Float.compare(o2.getItemSpaceOccupied(), o1.getItemSpaceOccupied());
                    }
                });
                break;
            } 
            // Check if the user input is "Value"
            else if (criteria.equalsIgnoreCase("Value")) {
                // Sort the list of woods by value using a custom comparator
                woodsList.sort(new Comparator<Woods>() {
                    @Override
                    public int compare(Woods o1, Woods o2) {
                        return Float.compare(o2.getItemValue(), o1.getItemValue());
                    }
                });
                break;
            } 
            else {
                System.out.println("Invalid criteria");
            }



        }
            
    }


    
    public static void PAGE() {



        JFrame frame = new JFrame("Tabs with Buttons");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());

        // Create the table for the Woods tab
        String[] columnNames = {"List", "Wood Number Code", "Wood Type", "Wood Weight (Kg)", "Wood Space (M^2)", "Wood Value ($/Kg)"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        panel1.add(scrollPane, BorderLayout.CENTER);

        JPanel buttons1 = new JPanel();
        buttons1.setLayout(new GridLayout(1, 5));
        JButton addWoodButton = new JButton("Add Wood");
        addWoodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog addWoodDialog = new JDialog(frame, "Add Wood", true);
                addWoodDialog.setLayout(new GridLayout(5, 2));
                addWoodDialog.add(new JLabel("Wood Type:"));
                JTextField woodTypeField = new JTextField();
                addWoodDialog.add(woodTypeField);
                addWoodDialog.add(new JLabel("Wood Weight (Kg):"));
                JTextField woodWeightField = new JTextField();
                addWoodDialog.add(woodWeightField);
                addWoodDialog.add(new JLabel("Wood Space (M^2):"));
                JTextField woodSpaceField = new JTextField();
                addWoodDialog.add(woodSpaceField);
                addWoodDialog.add(new JLabel("Wood Value ($/Kg):"));
                JTextField woodValueField = new JTextField();
                addWoodDialog.add(woodValueField);
                JButton addWoodConfirmButton = new JButton("Add");
                addWoodConfirmButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String woodType = woodTypeField.getText();
                        float woodWeight = Float.parseFloat(woodWeightField.getText());
                        float woodSpace = Float.parseFloat(woodSpaceField.getText());
                        float woodValue = Float.parseFloat(woodValueField.getText());
                        // Create new Wood object with inputs
                        Woods newWood = new Woods(woodType, woodWeight, woodSpace, woodValue);
                        // Set name of the Wood object
                        newWood.setName("Wood " + counterWood);
                        // Add Wood object to the list
                        woodsList.add(newWood);
                        // Increment counter for Wood
                        counterWood++;
                        model.addRow(new Object[] {model.getRowCount() + 1, "Wood " + (model.getRowCount() + 1), woodType, woodWeight, woodSpace, woodValue});
                        addWoodDialog.dispose();
                    }
                });
                addWoodDialog.add(addWoodConfirmButton);
                addWoodDialog.pack();
                addWoodDialog.setVisible(true);
            }
        });
        buttons1.add(addWoodButton);
        panel1.add(buttons1, BorderLayout.SOUTH);
        tabbedPane.addTab("Woods", panel1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());

        // Create the table for the Metals tab
        String[] columnNames2 = {"List", "Metal Number Code", "Metal Type", "Metal Weight (Kg)", "Metal Space (M^2)", " Metal Value ($/Kg)"};
        DefaultTableModel model2 = new DefaultTableModel(columnNames2, 0);
        JTable table2 = new JTable(model2);
        JScrollPane scrollPane2 = new JScrollPane(table2);
        panel2.add(scrollPane2, BorderLayout.CENTER);

        JPanel buttons2 = new JPanel();
        buttons2.setLayout(new GridLayout(1, 5));
        JButton addMetalButton = new JButton("Add Metal");
        addMetalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog addMetalDialog = new JDialog(frame, "Add Metal", true);
                addMetalDialog.setLayout(new GridLayout(5, 2));
                addMetalDialog.add(new JLabel("Metal Type:"));
                JTextField metalTypeField = new JTextField();
                addMetalDialog.add(metalTypeField);
                addMetalDialog.add(new JLabel("Metal Weight (Kg):"));
                JTextField metalWeightField = new JTextField();
                addMetalDialog.add(metalWeightField);
                addMetalDialog.add(new JLabel("Metal Space (M^2):"));
                JTextField metalSpaceField = new JTextField();
                addMetalDialog.add(metalSpaceField);
                addMetalDialog.add(new JLabel("Metal Value ($/Kg):"));
                JTextField metalValueField = new JTextField();
                addMetalDialog.add(metalValueField);
                JButton addMetalConfirmButton = new JButton("Add");
                addMetalConfirmButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String metalType = metalTypeField.getText();
                        float metalWeight = Float.parseFloat(metalWeightField.getText());
                        float metalSpace = Float.parseFloat(metalSpaceField.getText());
                        float metalValue = Float.parseFloat(metalValueField.getText());
                        // Create new Metal object with inputs
                        Metals newMetal = new Metals(metalType, metalWeight, metalSpace, metalValue);
                        // Set name of the Metal object
                        newMetal.setName("Metal " + counterMetals);
                        // Add Metal object to the list
                        metalsList.add(newMetal);
                        // Increment counter for Metal
                        counterMetals++;
                        model2.addRow(new Object[] {model2.getRowCount() + 1, "Metal " + (model2.getRowCount() + 1), metalType, metalWeight, metalSpace, metalValue});
                        addMetalDialog.dispose();
                    }
                });
                addMetalDialog.add(addMetalConfirmButton);
                addMetalDialog.pack();
                addMetalDialog.setVisible(true);
            }



        });
        buttons2.add(addMetalButton);
        panel2.add(buttons2, BorderLayout.SOUTH);
        tabbedPane.addTab("Metals", panel2);

        frame.add(tabbedPane, BorderLayout.CENTER);
        frame.setVisible(true);

    }



}
        

    

