import java.util.Scanner;

public class busservice {
	public static void main(String args[]) {

		int count = 0;
		int a[] = new int[2];// count of trips from both way
		int b[] = new int[2];

		int time[][] = new int[10][10];// Time for Total number of trips
		Scanner sc = new Scanner(System.in);
		int D = sc.nextInt();// Day
		for (int i = 0; i < D; i++) {

			int T = sc.nextInt();// Break Time
			for (int j = 0; j < a.length; j++) {
				a[j] = sc.nextInt();
				b[j] = a[j];
				count = count + a[j];
			}

			System.out.println(count);
			for (int k = 0; k < count; k++) {
				for (int j = 0; j < count - 1; j++) {
					time[k][j] = sc.nextInt();
				}
			}
		}

		for (int i = 1; i <= D; i++) {

			System.out.print("Day-" + i + ": ");
			for (int j = 0; j < b.length; j++) {
				System.out.print(b[j] + " ");
			}
			System.out.println();

		}
	}

}
