import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Puzzles implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String room_id;
	private String question;
	private String answer;
	private String hint;
	
	private int attempts;
	private String message_correct;
	private String message_incorrect;
	private String message_failure;
	private ArrayList<String> acceptable_answers;
	private ArrayList<ArrayList<String>> rewards;

	// Constructors
	public Puzzles(String id, String room_id, String question, String answer, String hint, 
			int attempts, String message_correct, String message_incorrect, String message_failure, 
			ArrayList<String> acceptable_answers, ArrayList<ArrayList<String>> rewards) {
		this.setId(id);
		this.setRoomId(room_id);
		this.setQuestionData(question, answer, hint);
		this.setAttemptData(attempts, message_correct, message_incorrect, message_failure);
		this.setAcceptableAnswers(acceptable_answers);
		this.setRewards(rewards);		
	}
	public Puzzles() {
		
	}
	
	// Bulk Setters
	public void setQuestionData(String question, String answer, String hint) {
		this.setQuestion(question);
		this.setAnswer(answer);
		this.setHint(hint);
	}
	public void setAttemptData(int attempts, String message_correct, String message_incorrect, String message_failure) {
		this.setAttempts(attempts);
		this.setMessageCorrect(message_correct);
		this.setMessageIncorrect(message_incorrect);
		this.setMessageFailure(message_failure);
	}
	
	// Class Methods
	
	// Load Puzzles from File
	public static ArrayList<Puzzles> loadPuzzlesFromFile(String filename) {
		Scanner s = new Scanner(Main.class.getResourceAsStream(filename));
		ArrayList<Puzzles> puzzles = new ArrayList<Puzzles>();
		
		int cur_line_num = 1;
		String reward_type = "";
		Puzzles cur_puzzle = new Puzzles();
        while(s.hasNextLine()) {
        	String line = s.nextLine();
        	if (line.equals("")) {
        		puzzles.add(cur_puzzle);
        		cur_line_num = 1;
        		cur_puzzle = new Puzzles();
        		continue;
        	} else {
        		switch(cur_line_num) {
        			case 1: // id
        				cur_puzzle.setId(line);
        				break;
        			case 2: // room_id
        				cur_puzzle.setRoomId(line);
        				break;
        			case 3: // question
        				cur_puzzle.setQuestion(line);
        				break;
        			case 4: // answer
        				cur_puzzle.setAnswer(line);
        				break;
        			case 5: // hint
        				cur_puzzle.setHint(line);
        				break;
        			case 6: // attempts
        				cur_puzzle.setAttempts(Integer.parseInt(line));
        				break;
        			case 7: // message_incorrect
        				cur_puzzle.setMessageIncorrect(line);
        				break;
        			case 8: // acceptable_answers
        				cur_puzzle.setAcceptableAnswers(cur_puzzle.parseAcceptableAnswers(line, "/"));
        				break;
        			case 9: // message_failure
        				cur_puzzle.setMessageFailure(line);
        				break;
        			case 10: // message_correct
        				cur_puzzle.setMessageCorrect(line);
        				break;
    				default:
    					// rewards
    					if (reward_type.equals("")) {
    						// New reward
    						reward_type = line;
    					} else {
    						// Continuing reward, set amount
    						cur_puzzle.addReward(reward_type, line);
    						reward_type = ""; // Done with this reward, reset it for the next possible reward
    					}
    					break;
        		}
        		cur_line_num++;
        	}
        }
        s.close();
        
        return puzzles;
	}
	
	// Debug readout of Puzzles
	public static void __debugView(ArrayList<Puzzles> puzzles) {
		System.out.println("-----------------------");
		System.out.println("DEBUG: LIST OF PUZZLES:");
		System.out.println("-----------------------");
		for (int i = 0; i < puzzles.size(); i++) {
			Puzzles cur_puzzle = puzzles.get(i);
			System.out.println("Index: "+i);
			System.out.println("id: "+cur_puzzle.getId());
			System.out.println("room_id: "+cur_puzzle.getRoomId());
			System.out.println("question: "+cur_puzzle.getQuestion());
			System.out.println("answer: "+cur_puzzle.getAnswer());
			System.out.println("hint: "+cur_puzzle.getHint());
			System.out.println("attempts: "+cur_puzzle.getAttempts());
			System.out.println("message_incorrect: "+cur_puzzle.getMessageIncorrect());
			System.out.println("acceptable_answers: "+cur_puzzle.getAcceptableAnswers());
			System.out.println("message_failure: "+cur_puzzle.getMessageFailure());
			System.out.println("message_correct: "+cur_puzzle.getMessageCorrect());
			System.out.println("rewards: "+cur_puzzle.getRewards());
			System.out.println("-----------------------");
		}
		System.out.println("END DEBUG");
		System.out.println("-----------------------");
	}
	
	// Setters & Getters
	
	// id
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return this.id;
	}
	
	// room_id
	public void setRoomId(String room_id) {
		this.room_id = room_id;
	}
	public String getRoomId() {
		return this.room_id;
	}
	
	// question
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getQuestion() {
		return this.question;
	}
	
	// answer
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getAnswer() {
		return this.answer;
	}
	public boolean checkAnswer(String input_answer) {
		return this.getAnswer().equals(input_answer);
	}
	
	// hint
	public void setHint(String hint) {
		this.hint = hint;
	}
	public String getHint() {
		return this.hint;
	}
	
	// attempts
	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}
	public int getAttempts() {
		return this.attempts;
	}
	
	// message_correct
	public void setMessageCorrect(String message) {
		this.message_correct = message;
	}
	public String getMessageCorrect() {
		return this.message_correct;
	}
	
	// message_incorrect
	public void setMessageIncorrect(String message) {
		this.message_incorrect = message;
	}
	public String getMessageIncorrect() {
		return this.message_incorrect;
	}
	
	// message_failure
	public void setMessageFailure(String message) {
		this.message_failure = message;
	}
	public String getMessageFailure() {
		return this.message_failure;
	}
	
	// acceptable_answers
	public void setAcceptableAnswers(ArrayList<String> acceptable_answers) {
		this.acceptable_answers = acceptable_answers;
	}
	public ArrayList<String> getAcceptableAnswers() {
		if (this.acceptable_answers == null) {
			return new ArrayList<String>();
		}
		return this.acceptable_answers;
	}
	public ArrayList<String> addAcceptableAnswer(String answer) {
		ArrayList<String> acceptable_answers = this.getAcceptableAnswers();
		acceptable_answers.add(answer);
		this.setAcceptableAnswers(acceptable_answers);
		
		return acceptable_answers;
	}
	public ArrayList<String> parseAcceptableAnswers(String input) {
		String delimiter = "/";
		String[] split_input = input.split(delimiter);
		ArrayList<String> acceptable_answers = new ArrayList(Arrays.asList(split_input));
		
		return acceptable_answers;
	}
	public ArrayList<String> parseAcceptableAnswers(String input, String delimiter) {
		String[] split_input = input.split(delimiter);
		ArrayList<String> acceptable_answers = new ArrayList(Arrays.asList(split_input));
		
		return acceptable_answers;
	}
	public boolean checkAcceptableAnswer(String input) {
		return this.getAcceptableAnswers().contains(input);
	}
	
	// rewards - TODO: Once Item class has been completed, convert these Strings into actual Item objects
	public void setRewards(ArrayList<ArrayList<String>> rewards) {
		this.rewards = rewards;
	}
	public ArrayList<ArrayList<String>> getRewards() {
		if (this.rewards == null) {
			return new ArrayList<ArrayList<String>>();
		}
		return this.rewards;
	}
	public ArrayList<ArrayList<String>> addReward(String reward_type, String reward_amount) {
		ArrayList<String> reward = new ArrayList(Arrays.asList(new String[]{reward_type, reward_amount}));
		ArrayList<ArrayList<String>> rewards = this.getRewards();
		rewards.add(reward);
		this.setRewards(rewards);
		
		return rewards;
	}

}
