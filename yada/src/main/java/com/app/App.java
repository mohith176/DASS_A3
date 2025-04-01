// package com.app;

// import java.util.Scanner;

// public class App 
// {
//     private static final Scanner scanner = new Scanner(System.in);
    
//     public static void main(String[] args)
//     {
//         App app = new App();
//         app.Start();
//     }
    
//     public void Start()
//     {

//         System.out.println("\n" + 
//             "██╗   ██╗ █████╗ ██████╗  █████╗ \n" +
//             "╚██╗ ██╔╝██╔══██╗██╔══██╗██╔══██╗\n" +
//             " ╚████╔╝ ███████║██║  ██║███████║\n" +
//             "  ╚██╔╝  ██╔══██║██║  ██║██╔══██║\n" +
//             "   ██║   ██║  ██║██████╔╝██║  ██║\n" +
//             "   ╚═╝   ╚═╝  ╚═╝╚═════╝ ╚═╝  ╚═╝\n"
//         );
        

        
//         while(true)
//         {
//             printDivider();
//             System.out.println("\n     *** WELCOME TO Y.A.D.A ***     \n");
//             printMenu(new String[] {
//                 "Signup",
//                 "Login",
//                 "Exit"
//             });
            
//             int choice = getIntInput("Enter your choice: ");
            
//             switch(choice) {
//                 case 1:
//                     this.Signup();
//                     break;
//                 case 2:
//                     this.Login();
//                     break;
//                 case 3:
//                     System.out.println("\nThank you for using Y.A.D.A. Goodbye!\n");
//                     return;
//                 default:
//                     System.out.println("\n[!] Invalid choice. Please try again.");
//                     break;
//             }
            
//             // Pause before showing the menu again
//             System.out.print("\nPress Enter to continue...");
//             scanner.nextLine();
//         }
//     }

//     public void Signup()
//     {
//         printDivider();
//         System.out.println("\n     *** USER SIGNUP ***     \n");
        
//         String username = getStringInput("Enter your username: ");
//         String password = getStringInput("Enter your password: ");
        
//         System.out.println("\n--- Gender ---");
//         printMenu(new String[] {
//             "Male",
//             "Female", 
//             "Other"
//         });
        
//         int genderChoice = getIntInput("Select your gender: ");
//         String gender;
//         switch(genderChoice) {
//             case 1:
//                 gender = "Male";
//                 break;
//             case 2:
//                 gender = "Female";
//                 break;
//             default:
//                 gender = "Other";
//                 break;
//         }
        
//         int height = getIntInput("\nEnter your height (in cm): ");
//         int weight = getIntInput("Enter your weight (in kg): ");
//         int age = getIntInput("Enter your age: ");
        
//         System.out.println("\n--- Activity Level ---");
//         printMenu(new String[] {
//             "Sedentary (little or no exercise)",
//             "Light (exercise 1-3 times/week)",
//             "Moderate (exercise 4-5 times/week)",
//             "Active (daily exercise or intense exercise 3-4 times/week)",
//             "Very Active (intense exercise 6-7 times/week)"
//         });
        
//         int activityChoice = getIntInput("Select your activity level: ");
//         String activityLevel;
        
//         switch(activityChoice) {
//             case 1:
//                 activityLevel = "Sedentary";
//                 break;
//             case 2:
//                 activityLevel = "Light";
//                 break;
//             case 3:
//                 activityLevel = "Moderate";
//                 break;
//             case 4:
//                 activityLevel = "Active";
//                 break;
//             case 5:
//                 activityLevel = "Very Active";
//                 break;
//             default:
//                 activityLevel = "Moderate"; // Default value
//                 break;
//         }
        
//         // Create a new user
//         User newUser = new User(username, password, gender, height, weight, age, activityLevel);
        
//         // Save the user to the database
//         printDivider();
//         if(newUser.saveToDatabase()) {
//             System.out.println("\n✅ Signup successful! Welcome " + username + "!");
//             this.Home();
//         } else {
//             System.out.println("\n❌ Signup failed. Please try again with a different username.");
//         }
//     }

//     public void Login()
//     {
//         printDivider();
//         System.out.println("\n     *** USER LOGIN ***     \n");
        
//         String username = getStringInput("Enter your username: ");
//         String password = getStringInput("Enter your password: ");
        
//         // Check if user exists in the database
//         User user = User.getUser(username, password);
        
//         printDivider();
//         if(user != null) {
//             System.out.println("\n✅ Login successful! Welcome back, " + username + "!");
//             this.Home();
//         } else {
//             System.out.println("\n❌ Login failed. Please check your username and password.");
//         }
//     }
    
//     public void Home()
//     {
//         printDivider();
//         System.out.println("\n     *** HOME ***     \n");
//         System.out.println("1. Food Section");
//         System.out.println("2. Log Section");
//         System.out.println("3. Profile Section");
//         System.out.println("4. Logout");
//         System.out.println("5. Exit");
//         int choice = getIntInput("Enter your choice: ");
//         switch(choice) {
//             case 1:
//                 System.out.println("\nFeature yet to be implemnted.");
//                 break;
//             case 2:
//                 System.out.println("\nFeature yet to be implemnted.");
//                 break;
//             case 3:
//                 System.out.println("\nFeature yet to be implemnted.");
//                 break;
//             case 4:
//                 System.out.println("\nYou have been logged out.");
//                 this.Start();
//                 break;
//             case 5:
//                 System.out.println("\nThank you for using Y.A.D.A. Goodbye!\n");
//                 System.exit(0);
//             default:
//                 System.out.println("\n[!] Invalid choice. Please try again.");
//                 break;
//         }

//     }

//     public void FoodSection()
//     {
//         printDivider();
//         System.out.println("\n     *** FOOD SECTION ***     \n");
//         System.out.println("1. View All Food");
//         System.out.println("2. View Basic Food");
//         System.out.println("3. View Composite Food");
//         System.out.println("4. Add Basic Food");
//         System.out.println("5. Create Composite Food");
//         System.out.println("Home(H)          Logout(L)          Exit(E)");
//         int choice = getIntInput("Enter your choice: ");
//         switch(choice) {
//             case 1:
//                 System.out.println("\nFeature yet to be implemnted.");
//                 break;
//             case 2:
//                 System.out.println("\nFeature yet to be implemnted.");
//                 break;
//             case 3:
//                 System.out.println("\nFeature yet to be implemnted.");
//                 break;
//             case 4:
//                 System.out.println("\nFeature yet to be implemnted.");
//                 break;
//             case 5:
//                 System.out.println("\nFeature yet to be implemnted.");
//                 break;
//             case 6:
//                 this.Home();
//                 break;
//             case 7:
//                 System.out.println("\nYou have been logged out.");
//                 this.Start();
//                 break;
//             case 8:
//                 System.out.println("\nThank you for using Y.A.D.A. Goodbye!\n");
//                 System.exit(0);
//             default:
//                 System.out.println("\n[!] Invalid choice. Please try again.");
//                 break;
//         }

//     }

//     // Helper methods for better input handling and formatting
//     private static String getStringInput(String prompt) {
//         System.out.print(prompt);
//         return scanner.nextLine().trim();
//     }
    
//     private static int getIntInput(String prompt) {
//         while (true) {
//             System.out.print(prompt);
//             try {
//                 int value = Integer.parseInt(scanner.nextLine().trim());
//                 return value;
//             } catch (NumberFormatException e) {
//                 System.out.println("[!] Please enter a valid number.");
//             }
//         }
//     }
    
//     private static void printMenu(String[] options) {
//         for (int i = 0; i < options.length; i++) {
//             System.out.println((i+1) + ". " + options[i]);
//         }
//         System.out.println();
//     }
    
//     private static void printDivider() {
//         System.out.println("\n========================================");
//     }
// }

package com.app;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class App 
{
    private static final Scanner scanner = new Scanner(System.in);
    private User currentUser = null;
    private FoodDatabase foodDB = new FoodDatabase();
    
    public static void main(String[] args)
    {
        App app = new App();
        app.initialize();
        app.showMainMenu();
    }
    
    private void initialize() {
        // Load food database
        foodDB.loadDatabase();
        
        System.out.println("\n" + 
            "██╗   ██╗ █████╗ ██████╗  █████╗ \n" +
            "╚██╗ ██╔╝██╔══██╗██╔══██╗██╔══██╗\n" +
            " ╚████╔╝ ███████║██║  ██║███████║\n" +
            "  ╚██╔╝  ██╔══██║██║  ██║██╔══██║\n" +
            "   ██║   ██║  ██║██████╔╝██║  ██║\n" +
            "   ╚═╝   ╚═╝  ╚═╝╚═════╝ ╚═╝  ╚═╝\n"
        );
    }
    
    public void showMainMenu()
    {
        while(true)
        {
            printDivider();
            System.out.println("\n     *** WELCOME TO Y.A.D.A ***     \n");
            printMenu(new String[] {
                "Signup",
                "Login",
                "Exit"
            });
            
            int choice = getIntInput("Enter your choice: ");
            
            switch(choice) {
                case 1:
                    this.Signup();
                    break;
                case 2:
                    if(this.Login()) {
                        this.Home();
                    }
                    break;
                case 3:
                    System.out.println("\nSaving database before exit...");
                    foodDB.saveDatabase();
                    System.out.println("\nThank you for using Y.A.D.A. Goodbye!\n");
                    return;
                default:
                    System.out.println("\n[!] Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public void Signup()
    {
        printDivider();
        System.out.println("\n     *** USER SIGNUP ***     \n");
        
        String username = getStringInput("Enter your username: ");
        String password = getStringInput("Enter your password: ");
        
        System.out.println("\n--- Gender ---");
        printMenu(new String[] {
            "Male",
            "Female", 
            "Other"
        });
        
        int genderChoice = getIntInput("Select your gender: ");
        String gender;
        switch(genderChoice) {
            case 1:
                gender = "Male";
                break;
            case 2:
                gender = "Female";
                break;
            default:
                gender = "Other";
                break;
        }
        
        int height = getIntInput("\nEnter your height (in cm): ");
        int weight = getIntInput("Enter your weight (in kg): ");
        int age = getIntInput("Enter your age: ");
        
        System.out.println("\n--- Activity Level ---");
        printMenu(new String[] {
            "Sedentary (little or no exercise)",
            "Light (exercise 1-3 times/week)",
            "Moderate (exercise 4-5 times/week)",
            "Active (daily exercise or intense exercise 3-4 times/week)",
            "Very Active (intense exercise 6-7 times/week)"
        });
        
        int activityChoice = getIntInput("Select your activity level: ");
        String activityLevel;
        
        switch(activityChoice) {
            case 1:
                activityLevel = "Sedentary";
                break;
            case 2:
                activityLevel = "Light";
                break;
            case 3:
                activityLevel = "Moderate";
                break;
            case 4:
                activityLevel = "Active";
                break;
            case 5:
                activityLevel = "Very Active";
                break;
            default:
                activityLevel = "Moderate"; // Default value
                break;
        }
        
        // Create a new user
        User newUser = new User(username, password, gender, height, weight, age, activityLevel);
        
        // Save the user to the database
        printDivider();
        if(newUser.saveToDatabase()) {
            System.out.println("\n✅ Signup successful! Welcome " + username + "!");
        } else {
            System.out.println("\n❌ Signup failed. Please try again with a different username.");
        }
        
        // Pause before showing the menu again
        System.out.print("\nPress Enter to continue...");
        scanner.nextLine();
    }

    public boolean Login()
    {
        printDivider();
        System.out.println("\n     *** USER LOGIN ***     \n");
        
        String username = getStringInput("Enter your username: ");
        String password = getStringInput("Enter your password: ");
        
        // Check if user exists in the database
        User user = User.getUser(username, password);
        
        printDivider();
        if(user != null) {
            System.out.println("\n✅ Login successful! Welcome back, " + username + "!");
            currentUser = user;
            return true;
        } else {
            System.out.println("\n❌ Login failed. Please check your username and password.");
            System.out.print("\nPress Enter to continue...");
            scanner.nextLine();
            return false;
        }
    }
    
    public void Home()
    {
        while(true) {
            printDivider();
            System.out.println("\n     *** HOME MENU ***     \n");
            
            printMenu(new String[] {
                "Food Database",
                "My Diet Diary",
                "Calculate Nutritional Needs",
                "My Profile",
                "Save Database",
                "Logout"
            });
            
            int choice = getIntInput("Enter your choice: ");
            
            switch(choice) {
                case 1:
                    this.FoodSection();
                    break;
                case 2:
                    System.out.println("\n[i] Diet Diary feature coming soon!");
                    break;
                case 3:
                    System.out.println("\n[i] Nutritional calculator feature coming soon!");
                    break;
                case 4:
                    System.out.println("\n[i] Profile management feature coming soon!");
                    break;
                case 5:
                    foodDB.saveDatabase();
                    System.out.println("\n✅ Database saved successfully!");
                    break;
                case 6:
                    currentUser = null;
                    System.out.println("\n[i] Logged out successfully!");
                    System.out.print("\nPress Enter to continue...");
                    scanner.nextLine();
                    return;
                default:
                    System.out.println("\n[!] Invalid choice. Please try again.");
                    break;
            }
            
            if (choice != 6) {
                System.out.print("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
    }

    public void FoodSection()
    {
        while(true) {
            printDivider();
            System.out.println("\n     *** FOOD DATABASE ***     \n");
            
            printMenu(new String[] {
                "Browse Foods by Category",
                "Search Foods",
                "Add New Basic Food",
                "Create Composite Food",
                "View My Custom Foods",
                "Return to Home Menu"
            });
            
            int choice = getIntInput("Enter your choice: ");
            
            switch(choice) {
                case 1:
                    browseFoodsByCategory();
                    break;
                case 2:
                    searchFoods();
                    break;
                case 3:
                    addNewBasicFood();
                    break;
                case 4:
                    createCompositeFood();
                    break;
                case 5:
                    viewMyCustomFoods();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("\n[!] Invalid choice. Please try again.");
                    break;
            }
            
            if (choice != 6) {
                System.out.print("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
    }
    
    private void browseFoodsByCategory() {
        printDivider();
        System.out.println("\n     *** FOOD CATEGORIES ***     \n");
        
        List<String> categories = foodDB.getCategories();
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i+1) + ". " + categories.get(i));
        }
        System.out.println();
        
        int choice = getIntInput("Select a category (0 to cancel): ");
        if (choice == 0 || choice > categories.size()) {
            return;
        }
        
        String selectedCategory = categories.get(choice-1);
        // Make sure to pass the current username to filter foods appropriately
        List<Food> foods = foodDB.getFoodsByCategory(selectedCategory, currentUser.getUserName());        
        printDivider();
        System.out.println("\n     *** " + selectedCategory.toUpperCase() + " FOODS ***     \n");
        
        if (foods.isEmpty()) {
            System.out.println("No foods found in this category.");
            return;
        }
        
        for (int i = 0; i < foods.size(); i++) {
            Food food = foods.get(i);
            System.out.println((i+1) + ". " + food.getName() + " (" + food.getCaloriesPerServing() + " calories/serving)");
        }
        
        System.out.println("\nEnter a food number to see details (0 to go back): ");
        choice = getIntInput("");
        
        if (choice > 0 && choice <= foods.size()) {
            Food selectedFood = foods.get(choice-1);
            displayFoodDetails(selectedFood);
        }
    }
    
    private void searchFoods() {
        printDivider();
        System.out.println("\n     *** SEARCH FOODS ***     \n");
        
        String searchTerm = getStringInput("Enter search term: ");
        // Make sure to pass the current username to filter foods appropriately
        List<Food> results = foodDB.searchFoods(searchTerm, currentUser.getUserName());
        
        printDivider();
        System.out.println("\n     *** SEARCH RESULTS FOR \"" + searchTerm + "\" ***     \n");
        
        if (results.isEmpty()) {
            System.out.println("No matching foods found.");
            return;
        }
        
        for (int i = 0; i < results.size(); i++) {
            Food food = results.get(i);
            System.out.println((i+1) + ". " + food.getName() + " (" + food.getCaloriesPerServing() + " calories/serving)");
        }
        
        System.out.println("\nEnter a food number to see details (0 to go back): ");
        int choice = getIntInput("");
        
        if (choice > 0 && choice <= results.size()) {
            Food selectedFood = results.get(choice-1);
            displayFoodDetails(selectedFood);
        }
    }
    
    private void displayFoodDetails(Food food) {
        printDivider();
        System.out.println("\n     *** FOOD DETAILS ***     \n");
        
        System.out.println("Name: " + food.getName());
        System.out.println("Calories per serving: " + food.getCaloriesPerServing());
        System.out.println("Keywords: " + String.join(", ", food.getKeywords()));
        
        if (food instanceof BasicFood) {
            BasicFood basicFood = (BasicFood) food;
            System.out.println("Category: " + basicFood.getCategory());
        }
        
        if (food instanceof CompositeFood) {
            CompositeFood composite = (CompositeFood) food;
            System.out.println("\nIngredients:");
            
            List<FoodComponent> components = composite.getComponentsList();
            for (FoodComponent component : components) {
                System.out.println("- " + component.getServings() + " serving(s) of " + 
                                   component.getFood().getName() + " (" + 
                                   (component.getFood().getCaloriesPerServing() * component.getServings()) + " calories)");
            }
        }
        
        if (food.getOwner() != null && food.getOwner().equals(currentUser.getUserName())) {
            System.out.println("\n(This is a custom food created by you)");
        }
    }
    
    private void addNewBasicFood() {
        printDivider();
        System.out.println("\n     *** ADD NEW BASIC FOOD ***     \n");
        
        String name = getStringInput("Enter food name: ");
        String category = getStringInput("Enter food category: ");
        int calories = getIntInput("Enter calories per serving: ");
        
        System.out.println("\nEnter keywords (separated by commas): ");
        String keywordsInput = scanner.nextLine();
        
        // Create a BasicFood with all required parameters
        BasicFood newFood = new BasicFood(name, keywordsInput, calories, category, currentUser.getUserName());
        
        foodDB.addFood(newFood);
        
        System.out.println("\n✅ New basic food added successfully!");
    }
    
    private void createCompositeFood() {
        printDivider();
        System.out.println("\n     *** CREATE COMPOSITE FOOD ***     \n");
        
        String name = getStringInput("Enter composite food name: ");
        String category = getStringInput("Enter food category: ");
        
        System.out.println("\nEnter keywords (separated by commas): ");
        String keywordsInput = scanner.nextLine();
        
        // Create a CompositeFood with the category parameter
        CompositeFood newComposite = new CompositeFood(name, keywordsInput, currentUser.getUserName());        
        boolean addingIngredients = true;
        while(addingIngredients) {
            printDivider();
            System.out.println("\n     *** ADD INGREDIENT ***     \n");
            
            String searchTerm = getStringInput("Search for ingredient (or type 'done' to finish): ");
            
            if (searchTerm.equalsIgnoreCase("done")) {
                addingIngredients = false;
                continue;
            }
            
            List<Food> results = foodDB.searchFoods(searchTerm, currentUser.getUserName());
            
            if (results.isEmpty()) {
                System.out.println("No matching foods found.");
                continue;
            }
            
            for (int i = 0; i < results.size(); i++) {
                Food food = results.get(i);
                System.out.println((i+1) + ". " + food.getName() + " (" + food.getCaloriesPerServing() + " calories/serving)");
            }
            
            int choice = getIntInput("\nSelect an ingredient (0 to cancel): ");
            
            if (choice > 0 && choice <= results.size()) {
                Food selectedFood = results.get(choice-1);
                int servings = getIntInput("Enter number of servings: ");
                
                newComposite.addComponent(new FoodComponent(selectedFood, servings));
                System.out.println("\n✅ Ingredient added: " + servings + " serving(s) of " + selectedFood.getName());
                
                System.out.println("\nCurrent ingredients in " + newComposite.getName() + ":");
                List<FoodComponent> components = newComposite.getComponentsList();
                for (FoodComponent component : components) {
                    System.out.println("- " + component.getServings() + " serving(s) of " + 
                                       component.getFood().getName());
                }
                
                System.out.println("\nTotal calories so far: " + newComposite.getCaloriesPerServing());
            }
        }
        
        if (newComposite.getComponents().isEmpty()) {
            System.out.println("\n❌ Composite food must contain at least one ingredient!");
            return;
        }
        
        foodDB.addFood(newComposite);
        System.out.println("\n✅ New composite food created successfully!");
    }
    
    private void viewMyCustomFoods() {
        printDivider();
        System.out.println("\n     *** MY CUSTOM FOODS ***     \n");
        
        List<Food> customFoods = foodDB.getUserFoods(currentUser.getUserName());
        
        if (customFoods.isEmpty()) {
            System.out.println("You haven't created any custom foods yet.");
            return;
        }
        
        for (int i = 0; i < customFoods.size(); i++) {
            Food food = customFoods.get(i);
            System.out.println((i+1) + ". " + food.getName() + " (" + 
                               (food instanceof CompositeFood ? "Composite" : "Basic") + 
                               ", " + food.getCaloriesPerServing() + " calories/serving)");
        }
        
        System.out.println("\nEnter a food number to see details (0 to go back): ");
        int choice = getIntInput("");
        
        if (choice > 0 && choice <= customFoods.size()) {
            Food selectedFood = customFoods.get(choice-1);
            displayFoodDetails(selectedFood);
        }
    }
    
    // Helper methods for better input handling and formatting
    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
    
    private static int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("[!] Please enter a valid number.");
            }
        }
    }
    
    private static void printMenu(String[] options) {
        for (int i = 0; i < options.length; i++) {
            System.out.println((i+1) + ". " + options[i]);
        }
        System.out.println();
    }
    
    private static void printDivider() {
        System.out.println("\n========================================");
    }
}