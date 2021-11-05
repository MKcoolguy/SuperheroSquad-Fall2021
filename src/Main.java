import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            //methods that read from text files.
            readRoom();
            //readMonster(); need to set these up
            //readItems(); need to set these up
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        Scanner sc = new Scanner(System.in);
        String[] arrMainMenu = {"Start", "Reload", "Help", "Quit"};
        UserInterface ui = new UserInterface("Welcome to adventure south", arrMainMenu);

        mainMenu(sc); // launches the main menu and game goes from there
    }


    //game starting menu
    public static void mainMenu(Scanner sc) {
        String playerInput = sc.next();
        if (playerInput.equalsIgnoreCase("start")) {
            startGame(sc);
        } else if (playerInput.equalsIgnoreCase("reload")) {
            //reload game feature goes here
        } else if (playerInput.equalsIgnoreCase("help")) {
            // help feature
        } else if (playerInput.equalsIgnoreCase("quit")) {
            sc.close();
            System.out.println("Game aborted.");
        } else {
            System.out.println("Not a valid command.");
        }
    }


    //when user selects start game
    public static void startGame(Scanner sc) {
        Player player = new Player();
        //GameMap map = new GameMap();
        boolean playGame = true;

        player.setPlayerLocation(1); //set player location room 1
        int currentRoom = player.getPlayerLocation(); // shortcut variable for getting players location

        System.out.println("You are in " + GameMap.getRooms().get(currentRoom).getRoomName());
        System.out.println(GameMap.getRooms().get(currentRoom).getRoomDesc());
        System.out.println("Which direction do you want to go? N S E W?");

        while (playGame) {


            String playerInput = sc.next();

            //navigate rooms command
            if (GameMap.getRooms().get(currentRoom).getExitRooms().containsKey(playerInput)) {
                currentRoom = GameMap.getRooms().get(currentRoom).getExitRooms().get(playerInput); //updates what room player is in.
                player.setPlayerLocation(currentRoom); //sets player location to currentRoom
                System.out.println("You are in room: " + GameMap.rooms.get(currentRoom).getRoomName());
                System.out.println(GameMap.rooms.get(currentRoom).getRoomDesc());
            } else {
                System.out.println("Oop, can't go that way!");
            }
            //if monster is in room command

        }

    }

    public static void readMonster() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/Monsters.txt"));

        while (scanner.hasNextLine()) {
            String monsterNum = scanner.nextLine().trim();
            if (monsterNum.trim().equals("")) {
                monsterNum = scanner.nextLine().trim();
            }
            String monsterName = scanner.nextLine().trim();
            String monsterDesc = scanner.nextLine().trim();
            int monsterHp = Integer.parseInt(scanner.nextLine().trim());
            String monsterItemCarried = scanner.nextLine().trim();  // attack / Hp potion
        }
    }

    public static void readRoom() throws FileNotFoundException {
        Scanner roomsReader = new Scanner(new File("src/rooms.txt"));

        //assigns each line with a variable
        int roomID = 0;
        String roomName = "";
        String roomDesc = "";
        HashMap<String, Integer> possibleExits = new HashMap<>();
        while (roomsReader.hasNext()) {
            String result = roomsReader.nextLine();
            if (result.matches("\\d+")) {
                roomID = Integer.parseInt(result);
                roomName = roomsReader.nextLine();
                roomDesc = roomsReader.nextLine();
                possibleExits = new HashMap<>();
            } else {
                if (!result.trim().equals("")) {
                    String[] splitter = result.split("\\s+");
                    Integer value = Integer.parseInt(splitter[1]);
                    possibleExits.put(splitter[0], Integer.parseInt(splitter[1]));
                    if (splitter[0].equals("North")) {
                        possibleExits.put("N", value);
                        possibleExits.put("north", value);
                        possibleExits.put("n", value);
                    } else if (splitter[0].equals("East")) {
                        possibleExits.put("E", value);
                        possibleExits.put("east", value);
                        possibleExits.put("e", value);
                    } else if (splitter[0].equals("South")) {
                        possibleExits.put("S", value);
                        possibleExits.put("south", value);
                        possibleExits.put("s", value);
                    } else if (splitter[0].equals("West")) {
                        possibleExits.put("W", value);
                        possibleExits.put("west", value);
                        possibleExits.put("w", value);
                    }
                }
            }
            Rooms room = new Rooms(roomID, roomName, roomDesc, possibleExits);
            GameMap.addRoom(roomID, room);
            }
        }

    public static void readItems() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/GameItems.txt"));
        while (scanner.hasNextLine()) {
            String itemNum = scanner.nextLine().trim();
            if (itemNum.trim().equals("")) {
                itemNum = scanner.nextLine().trim();
            }
            String itemName = scanner.nextLine().trim();
            String itemType = scanner.nextLine().trim();
            String itemPower = scanner.nextLine().trim();
            String itemRooms = scanner.nextLine().trim();
            //System.out.println(itemNum);
        }
    }

    public static void readPuzzle() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/Puzzles.txt"));
        while (scanner.hasNextLine()) {
            String puzzleNum = scanner.nextLine().trim();
            if (puzzleNum.trim().equals("")) {
                puzzleNum = scanner.nextLine().trim();

            }
            String puzzleLocation = scanner.nextLine().trim();
            String puzzleQuestion = scanner.nextLine().trim();
            String puzzleAnswer = scanner.nextLine().trim();
            String puzzleHint = scanner.nextLine().trim();
            int attemptsAllowed = Integer.parseInt(scanner.nextLine().trim());
            String outputForIncorrectAns = scanner.nextLine().trim();
            // Y/N
            String outputForCorrectAns = scanner.nextLine().trim();
            String reward = scanner.nextLine().trim();
            //hp number
        }
    }

    // save and load
    public static void saveGame() throws FileNotFoundException {
        //using seralization
        //output stream to save
        //object = room ,since everything is in the room

        FileOutputStream file = new FileOutputStream("saveGame.txt");  // need to use .Sav file
        try {
            ObjectOutputStream output = new ObjectOutputStream(file);
            output.flush();
            output.close();
            //output.writeObject(room);
            System.out.println("Game saved");

        } catch (IOException e) {
            // TODO Auto-generated catch block

            e.printStackTrace();
        }


    }

    public static void loadGame() throws FileNotFoundException {
        //using seralization
        //input stream to save
        //object = room ,since everything is in the room

        FileInputStream fileInput = new FileInputStream("saveGame.txt");  // need to use .Sav file
        try {
            ObjectInputStream input = new ObjectInputStream(fileInput);
            //room = (Room) input.readObject();

            input.close();

            System.out.println("Game loded");

        } catch (Exception e) {
            System.out.println("can't load data");
        }

    }
}
