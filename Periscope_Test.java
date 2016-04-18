import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Periscope_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("./input.txt");
		Scanner s;
		try {
			s = new Scanner(f);

			int m = s.nextInt();
			int n = s.nextInt();
			boolean[][] ds = new boolean[m][n];
			int count = 0;
			int x = s.nextInt();
			int y = s.nextInt();
			while (s.hasNextInt()) {
				int i = s.nextInt();
				int j = s.nextInt();
				ds[i][j] = true;
			}
			if (ds[x][y] == true) {
				ds[x][y] = false;
				count++;
			}
			s.nextLine();
			String st = s.nextLine();
			int i = 0;
			while (i < st.length()) {
				if (st.charAt(i) == 'N' && y < m - 1) {
					y++;
				} else if (st.charAt(i) == 'S' && y > 0) {
					y--;
				} else if (st.charAt(i) == 'E' && x < n - 1) {
					x++;
				} else if (st.charAt(i) == 'W' && x > 0) {
					x--;
				}
				if (ds[x][y] == true) {
					ds[x][y] = false;
					count++;
				}
				i++;
			}
			System.out.println(x + " " + y);
			System.out.println(count);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
