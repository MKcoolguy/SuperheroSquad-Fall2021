public class UserInterface {

    private String [] message;
    private String tile;


    public UserInterface(String title, String [] message) {
        System.out.println("+--------------------+");
        System.out.println(title);
        System.out.println("+--------------------+");
        for (String s: message) {
            System.out.println(s);
        }
        System.out.println("+--------------------+");
    }

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }

    public String getTile() {
        return tile;
    }

    public void setTile(String tile) {
        this.tile = tile;
    }

    public String displayedElements() {
        return  "";
    }
}
