import java.io.*;
import java.util.*;

public class Main implements Serializable{
    public static GameMap map = new GameMap();


    public static void main(String[] args) {
        try {
            //methods that read from text files.
            readRoom();
            readItems();
            readMonster();  //need to set these up
            readPuzzles();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Scanner sc = new Scanner(System.in);
        startMenu(sc); // launches the main menu and game goes from there
        //System.out.println(map.getRooms().get(3).getItems().get(0).getItemName());

    }


    //game starting menu
    public static void startMenu(Scanner sc) {
        UserInterface.displayStartMenu(); //game start menu launch

        System.out.print("Adventure South: ");
        String playerInput = sc.nextLine();
        if (playerInput.equalsIgnoreCase("start")) {
            startGame(sc);
        } else if (playerInput.equalsIgnoreCase("reload")) {
            //reload game feature goes here
            try {
                loadGame();
                startGame(sc);
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
        } else if (playerInput.equalsIgnoreCase("help")) {
            // help feature
            UserInterface.displayHelp();
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
        player.setHealth( 500);
        player.setHealthMax(500);
        player.setStength(50);

        //GameMap map = new GameMap();
        boolean playGame = true;

        player.setPlayerLocation(1); //set player location room 1
        int currentRoom = player.getPlayerLocation(); // shortcut variable for getting players location

        System.out.println("You are in " + map.getRooms().get(currentRoom).getRoomName());
        System.out.println(map.getRooms().get(currentRoom).getRoomDesc());
        System.out.println("Which direction do you want to go? N S E W?");

        while (playGame) {

            System.out.print("Command: ");
            String playerInput = sc.nextLine();

            //navigate rooms command
            if (map.getRooms().get(currentRoom).getExitRooms().containsKey(playerInput)) {
                currentRoom = map.getRooms().get(currentRoom).getExitRooms().get(playerInput); //updates what room player is in.
                player.setPlayerLocation(currentRoom); //sets player location to currentRoom
                System.out.println("You are in room: " + GameMap.rooms.get(currentRoom).getRoomName());
                System.out.println(GameMap.rooms.get(currentRoom).getRoomDesc());
                player.movesMade++;
            }
            //menu command
            else if (playerInput.equalsIgnoreCase("m") || playerInput.equalsIgnoreCase("menu")) {
                UserInterface.displayMenu();
            }
            //inventory command
            else if (playerInput.equalsIgnoreCase("i") || playerInput.equalsIgnoreCase("inventory")) {
                player.checkInventory();
            }
            //status command
            else if (playerInput.equalsIgnoreCase("status")) {
                UserInterface.displayStatus(player.movesMade, player.getHealth());
            }
            //help command
            else if (playerInput.equalsIgnoreCase("help")) {
                //feature to display all commands and their descriptions
                UserInterface.displayHelp();
            }
            //start menu command. will bring player back into start screen
            else if (playerInput.equalsIgnoreCase("start menu") || playerInput.equalsIgnoreCase("Main Menu")) {
                startMenu(sc);
                playGame = false;
            }
            //command to display player's health, attack and defense stats
            else if (playerInput.equalsIgnoreCase("check stats")) {
                player.checkStats();
            }
            //exits the game and doesn't save current progress
            else if (playerInput.equalsIgnoreCase("exit")) {
                System.exit(0);
            }
            //explore command - list room contents with descriptions
            else if (playerInput.equalsIgnoreCase("explore") || playerInput.equalsIgnoreCase("explore room")) {
                /*for (GameItem item : map.getRooms().get(currentRoom).getItems()) {
                    System.out.println(item.getItemName());
                }*/
                GameMap.rooms.get(currentRoom).explore();
            }
            //consume item command
            else if (playerInput.startsWith("use")) {
                String item = playerInput.substring(playerInput.indexOf(" ")).trim(); // gets the item string of player input
                player.consumeItem(item, player, currentRoom);
            }
            //inspect item command
            else if (playerInput.startsWith("inspect") || playerInput.startsWith("examine")) { //item MUST be in inventory to inspect
                String itemName = playerInput.substring(playerInput.indexOf(" ")).trim(); // gets the item string of player input
                for (GameItem item : map.getRooms().get(currentRoom).getItems()) {
                    if (itemName.equalsIgnoreCase(item.getItemName())) {
                        player.inspectItem(player, itemName);
                    }
                }
                player.inspectItem(player,itemName);
                for (GameItem item : map.getRooms().get(currentRoom).getItems()) {
                    if (itemName.equalsIgnoreCase(item.getItemName())) {
                        System.out.println(item.getItemDesc());
                    }
                }
                for (int i = 0; i < map.getRooms().get(currentRoom).getMonsters().size(); i++) {
                    if (itemName.equalsIgnoreCase(map.getRooms().get(currentRoom).getMonster().getName())) {
                        player.fight(sc, map, player);
                    }
                }
//                for (Monster monster : map.getRooms().get(currentRoom).getMonsters()) {
//                    if (itemName.equalsIgnoreCase(monster.getName())) {
//                            player.fight(sc, map, player);
//                    }
//                }
            }
            //equip command. only works if item is not currently equipped
            else if (playerInput.startsWith("equip")) {
                String item = playerInput.substring(playerInput.indexOf(" ")).trim(); // gets the item string of player input
                player.equipItem(player, item, map);
            }
            //unequip command. only works if item is equipped
            else if (playerInput.startsWith("unequip")) {
                String item = playerInput.substring(playerInput.indexOf(" ")).trim(); // gets the item string of player input
                player.unequipItem(player, item);
            }
            //drop command
            else if (playerInput.startsWith("drop")) {
                String item = playerInput.substring(playerInput.indexOf(" ")).trim(); // gets the item string of player input
                player.drop(player, item, map.getRooms().get(currentRoom));
            }
            //pickup command
            else if (playerInput.startsWith("pickup")) {
                String itemName = playerInput.substring(playerInput.indexOf(" ")).trim(); // gets the item string of player input
                Iterator<GameItem> iter = map.getRooms().get(currentRoom).getItems().iterator();
                while (iter.hasNext()) {
                    GameItem item = iter.next();
                    if (itemName.equalsIgnoreCase(item.getItemName())) {
                        player.pickupItem(item);
                        iter.remove();
                    }
                }
            }
            else if (playerInput.equalsIgnoreCase("save")) {
                try {
                    saveGame(player);
                } catch (FileNotFoundException e) {
                    System.out.println("file not found");
                }
            }
            //solve puzzle
            else if (playerInput.equalsIgnoreCase("solve puzzle")) {
            	ArrayList<Puzzles> puzzle_result = player.solvePuzzle(sc, map.getRooms().get(currentRoom).getPuzzles(), map.getItems());
            	map.getRooms().get(currentRoom).setPuzzles(puzzle_result);
                System.out.println("You are in room: " + GameMap.rooms.get(currentRoom).getRoomName());
                System.out.println(GameMap.rooms.get(currentRoom).getRoomDesc());
            }
            else if (playerInput.equalsIgnoreCase("restart")) {
                startGame(sc);
            }

        }
    }

    public static void readMonster() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/Monsters.txt"));

        String iD = "";
        String name = "";
        String desc = "";
        String monsterAttack = "";
        int health = 0;
        String rewardType = "";
        int monsterLocation = 0;

        int healthMax = 0;
        int strength = 0;
        HashMap<String, Queue<GameItem>> inventory = new HashMap<>();

        while (scanner.hasNextLine()) {
            String result = scanner.nextLine().trim();
            if (result.matches("^M[0-9]+")) {

                iD = result;
                name = scanner.nextLine().trim();
                desc = scanner.nextLine().trim();
                monsterAttack = scanner.nextLine().trim();
                health  = Integer.parseInt(scanner.nextLine().trim());  //health
                strength = Integer.parseInt(scanner.nextLine().trim());
                rewardType = scanner.nextLine().trim();
                monsterLocation  = Integer.parseInt(scanner.nextLine().trim());
                Monster monster = new Monster(iD,name,health,healthMax,desc,strength,monsterLocation,inventory,monsterAttack,rewardType);
                Rooms roomMonster =  map.getRooms().get(monsterLocation);
                map.getRooms().get(monsterLocation).addMonster(monster);
            }
        }
    }

    public static void readRoom() throws FileNotFoundException {
        Scanner roomsReader = new Scanner(new File("src/rooms.txt"));

        //assigns each line with a variable
        int roomID = 0;
        String roomName = "";
        String roomDesc = "";
        HashMap<String, Integer> possibleExits = new HashMap<>();
        while (roomsReader.hasNextLine()) {
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
        String itemID = "";
        String itemName = "";
        String itemDesc = "";
        String itemType = "";
        String itemPower = "";
        while (scanner.hasNextLine()) {
            String result = scanner.nextLine().trim();
            if (result.matches("^IT[0-9]+")) {
                //System.out.println(result);
                itemID = result;
                itemName = scanner.nextLine().trim();
                itemDesc = scanner.nextLine().trim();
                itemType = scanner.nextLine().trim();
                itemPower = scanner.nextLine().trim();

                // Add item to list of available items, this is needed when giving out Puzzle rewards
                if (itemType.equalsIgnoreCase("consumable")) {
                    Consumable c = new Consumable(itemID, itemName, itemDesc, itemType, itemPower, -1);
                    GameMap.addItem(itemID, c);
                } else if (itemType.equals("Equippable")) {
                    Equippable e = new Equippable(itemID, itemName, itemDesc, itemType, itemPower, -1);
                    GameMap.addItem(itemID, e);
                }
            } else {
                if (!result.trim().equals("")) {
                    String itemRooms = result;
                    String[] splitter = itemRooms.split("[,]");
                    for (String s : splitter) {
                        int room = Integer.parseInt(s.trim());
                        if (map.getRooms().containsKey(room)) {
                            //add each item that belongs in this room
                            if (itemType.equalsIgnoreCase("consumable")) {
                                Consumable c = new Consumable(itemID, itemName, itemDesc, itemType, itemPower, room);
                                map.getRooms().get(room).addItems(c);
                            } else if (itemType.equals("Equippable")) {
                                Equippable e = new Equippable(itemID, itemName, itemDesc, itemType, itemPower, room);
                                map.getRooms().get(room).addItems(e);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void readPuzzles() throws FileNotFoundException {
    	HashMap<Integer, Puzzles> puzzles = Puzzles.loadPuzzlesFromFile("src/Puzzles.txt");
    	GameMap.setPuzzles(puzzles);
    	for (int i = 0; i < puzzles.size(); i++) {
    		Puzzles cur_puzzle = puzzles.get(i);
    		int roomId = cur_puzzle.getRoomId();
    		map.getRooms().get(roomId).addPuzzles(cur_puzzle);
    	}
    }

    // save and load
    public static void saveGame(Player player) throws FileNotFoundException {
        //using seralization
        //output stream to save
        //object = room ,since everything is in the room

        FileOutputStream file = new FileOutputStream("saveGame.txt");  // need to use .Sav file
        try {
            ObjectOutputStream output = new ObjectOutputStream(file);
            output.flush();
            output.writeObject(map);
            output.writeObject(player);
            output.close();
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
            map = (GameMap) input.readObject();
            input.close();
            System.out.println("Game loaded");

        } catch (Exception e) {
            System.out.println("Can't load data");
        }

    }
}
