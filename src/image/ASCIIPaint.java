package image;

import java.util.Scanner;

/**
 * Command-driven paint program for text-based images.
 * 
 * @author Your name here
 */
public class ASCIIPaint {
	private static int imageRow = 0;
	private static int imageColumn = 0;

    /**
     * Converts the multi-line String into a 2D array of characters.
     * Each line in the String must be the same length.
     */
    public static char[][] stringToImage(String str) {
        char[][] result;
        String[] rows;
        
        rows = str.split("\n");
        imageRow = rows.length;
        result = new char[imageRow][];
        for (int r = 0; r < imageRow; r++) {
            result[r] = rows[r].toCharArray();
        }
        imageColumn = result[0].length;
        return result;
    }
    
    /** Reads the next character the user enters. */
    public static char nextChar(Scanner in) {
        return in.next().charAt(0);
    }
    
    /** Displays the given character-based image with a leading and trailing blank line. */
    public static void displayImage(char[][] image) {
    	for(int i=0;i<imageRow;i++){
    		for(int j=0;j<imageColumn;j++){
    			System.out.print(image[i][j]);
    		}
    		System.out.println();
    	}
    }
    
    /** Returns true if (row, col) is inside the image, false otherwise. */
    public static boolean inBounds(int row, int col, char[][] image) {
        //TODO Revise this
        return false;
    }
    
    /**
     * Displays the 9 cells in the image centred at (row, col). Displays a space
     * for any cell that is outside the image's bounds.
     */
    public static void zoom(char[][] image, int row, int col) {
    	        
    }

    /**
     * Starts a flood fill operation by selecting the replacement colour
     * at the given row and column.
     */
    public static void floodFill(char[][] image, int row, int col, char fill) {
        //must be within the bounds of the image and not already equal to fill
        if (inBounds(row, col, image) && image[row][col] != fill) {
            floodFill(image, row, col, image[row][col], fill);
        }
    }
 
    /** Performs flood fill, replacing replace with fill, starting from (row, col). */
    public static void floodFill(char[][] image, int row, int col, char replace, char fill) {
        //TODO Implement this
    }
  
    public static void main(String[] args) {
        //Commands
        final char CMD_PRINT = 'p', CMD_ZOOM = 'z', CMD_FILL = 'f', CMD_HELP = '?',
                   CMD_LOAD = 'l', CMD_SAVE = 's', CMD_QUIT = 'q';
        Scanner sc = new Scanner(System.in);
        char[][] image; // the character-based 'image'
        char command; //user's entered command
        int row = 0;    //|
        int col;    //|- command parameters
        char brush; //|
        //The initial image source. Edit this to create some holes (or change its size).
        String strImage = "####################\n" +
                          "####################\n" +
                          "####################\n" +
                          "####################\n" +
                          "####################\n" +
                          "####################\n" +
                          "####################\n" +
                          "####################\n" +
                          "####################";
        
        image = stringToImage(strImage);
        System.out.println("ASCII Paint");
        System.out.println("===========");
        System.out.println();
        System.out.println("Enter commands (? for help). There are no further prompts after this point.");
        
        do {
            command = nextChar(sc); //read the next single-character command
            
            switch (command) {
                case CMD_PRINT:
                	displayImage(image);
                	break;
                case CMD_ZOOM:
                	zoom(image, 5, 5);
                	break;
                case CMD_FILL: 
                case CMD_LOAD:  
                case CMD_SAVE: System.err.println("Feature not implemented");
                               break;
                case CMD_QUIT: break;
                case CMD_HELP:
                default: System.out.println("\nCommands:");
                         System.out.println(CMD_PRINT + "             \tDisplay the image");
                         System.out.println(CMD_ZOOM +  " row col     \tShow cells surrounding (row, col)");
                         System.out.println(CMD_FILL +  " row col fill\tFill from (row, col) with fill (a single character)");
                         System.out.println(CMD_HELP +  "             \tShow this list of commands");
                         System.out.println(CMD_LOAD +  " filename    \tLoad the text image from filename");
                         System.out.println(CMD_SAVE +  " filename    \tSave the current image to filename");
                         System.out.println(CMD_QUIT +  "             \tLeave the program");
                         System.out.println("\nCommands may be chained together, separated by whitespace");
                         System.out.println();
            }
        } while (command != CMD_QUIT);
    }
    
}
