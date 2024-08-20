/* PROBLEM: A room design takes input in the form of width, height, color1, color2 and fills the 2D grid 
such that first row alternates between the pixels of color <color1> and <color2> with a period of <height>. 
For each row that follows, the period shall be <height> - <row number>. Note that <color1> always begins the row.
*/
//Asked in Multicoreware Coding Assessment.
//NOTE: This is not the exact actual solution for this problem. The original question expects the output in the form actual color pixels to fill the grid.

import java.util.Scanner;

public class Room_Design_Grid {
    static void fillGrid(int width, int height, char color1, char color2) {
        char grid[][] = new char[height][width];

        for (int row = 0; row < height; row++) {
            int period = height - row;
            for (int col = 0; col < width; col++) {
                if ((col / period) % 2 == 0) {
                    grid[row][col] = color1;
                } else {
                    grid[row][col] = color2;
                }
            }
        }

        // Print the grid after filling colors
        for (int row = height - 1; row >= 0; row--) {
            for (int col = 0; col < width; col++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int width = sc.nextInt();
        int height = sc.nextInt();
        char color1 = sc.next().charAt(0);
        char color2 = sc.next().charAt(0);

        fillGrid(width, height, color1, color2);
    }
}
