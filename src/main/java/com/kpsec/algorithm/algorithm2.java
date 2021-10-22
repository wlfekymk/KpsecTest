package com.kpsec.algorithm;

/**
 * @author 이로얌
 *
 *         2. 가로가 x, 세로가 y이고 각 칸에는 숫자 s가 적혀 있는 말판이 있습니다. 네오와 프로도는 자기 말을 각각 왼쪽
 *         상단과 오른쪽 상단에 두고 게임을 시작하려고 합니다. 말은 자기의 위치에서 아래 3칸(왼쪽아래, 아래, 오른쪽아래)중에
 *         한곳으로만 이동할 수 있고, 두 말이 이동한 위치에 적힌 숫자의 총합이 게임의 점수가 됩니다. 각 칸에 점수가 적힌 말판이
 *         주어질 때, 네오와 프로도가 얻을 수 있는 가장 높은 점수를 구하는 코드를 작성해주세요.
 * 
 *         규칙 - 말판의 가로 x, 세로 y의 범위는 3 < x, y < 50, - 각 칸의 점수 s의 범위는 -100 < s <
 *         100 - 입력은 2차원 배열로 주어집니다. - 말은 말판 밖으로 나갈 수 없습니다. - 두 말이 같은 칸으로 이동할 수
 *         있지만, 점수는 한명에게만 주어집니다. - 입력처리 첫번째 입력 : 가로 x 값  두번째 입력 : 세로 y 값 세번째 입력
 *         : 맵 데이터 , 로 구분
 * 
 *         예제 입출력 
 *         				입력 : 	3 
 *           						4 
 *         						   	3,1,1,2,5,1,1,5,5,2,1,1 
 *         				출력 :		24
 * 
 *         -------- 
 *         2 1 1 
 *         -------- 
 *         1 5 5 
 *         -------- 
 *         2 5 1 
 *         -------- 
 *         3 1 1 
 *         --------
 *         네오 : 2 - 5 - 2 - 3 (2+5+2+3=12) 프로도 : 1 - 5 - 5 - 1 (1+5+5+1=12)
 * 
 *         				입력 : 	7 
 *         							5
 *         							1,0,0,0,0,0,1,2,0,0,0,0,3,0,2,0,9,0,0,0,0,0,3,0,5,4,0,0,1,0,2,3,0,0,6
 *         				출력 : 	28
 * 
 *         ---------- 
 *         2 3 0 0 6
 *         ---------- 
 *         4 0 0 1 0 
 *         ---------- 
 *         0 0 3 0 5
 *         ---------- 
 *         0 9 0 0 0
 *         ---------- 
 *         0 0 3 0 2 
 *         ---------- 
 *         0 1 2 0 0
 *         ---------- 
 *         1 0 0 0 0 
 *         ----------
 *
 */
public class algorithm2 {
	public static void main(String[] args) throws Exception {
		arrayInit(3, 4, "3,1,1,2,5,1,1,5,5,2,1,1");
//		arrayInit(7, 5, "1,0,0,0,0,0,1,2,0,0,0,0,3,0,2,0,9,0,0,0,0,0,3,0,5,4,0,0,1,0,2,3,0,0,6");
	}

	public static void arrayInit(int x, int y, String s) {
		System.out.println("=================================");
		String[][] arr = new String[y][x];
		String[] array = s.split(",");
		int arrayCnt = 0;
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				arr[i][j] = array[arrayCnt];
//				System.out.println("arr[" + i + "][" + j + "] : " + arr[i][j]);
				arrayCnt++;
			}
		}
		System.out.println("=================================");
		sumGame(x, y, arr);
	}

	

	public static void sumGame(int x, int y, String[][] arr) {

		int[] moves = { -1, 0, 1 }; 	// 이동가능 위치
		// y값이 0이 될때까지 반복
		// 초기 좌표
		int neoX = y - 1; 			// 왼쪽 상단
		int neoY = 0; 				// 왼쪽 상단  3,0 -> 2,0 -> 1,0 -> 0,0
		int frodoX = y - 1; 		// 오른쪽 상단
		int frodoY = x - 1; 		// 오른쪽 상단
		System.out.println("neo 시작 좌표 : " + neoX + "," + neoY + " >> 시작 값 : " + arr[neoX][neoY]);
		y=y-1;

		int neoSumTop = 0;
		int frodoSumTop = 0;

		int total = Integer.valueOf(arr[neoX][neoY]);
		for (; y > 0; y--) {
			System.out.println("y : " + y);
			neoX = y - 1; 			// y값이 감소하면 끝
			// 재귀호출 필요
			// neoY는 move 가능영역을 돌아야함 단 neoY가 0보다 작을순 없다
			recCall(neoX, neoY, arr, total);
			// System.out.println("frodo 현재 좌표 : " + frodoX + "," + frodoY + " >> 현재 값 : " + arr[frodoX][frodoY]);
		}		
	}
	/**         -------- 
	 *         2 1 1 
	 *         -------- 
	 *         1 5 5 
	 *         -------- 
	 *         2 5 1 
	 *         -------- 
	 *         3 1 1 
	 *         --------
	 **/
	// 재귀호출
	public static int recCall(int neoX, int neoY, String[][] arr, int total) {
		int top = 0;
		int[] moves = { -1, 0, 1 }; // 이동가능 위치
		for (int move : moves) {
			int now = neoY + move;

			if (now >= 0) {

				if (neoX >= 0) {
					System.out.println("neoY : " + now);
					System.out.println("neo 현재 좌표 : " + neoX + "," + now + " >> 현재 값 : " + arr[neoX][now]);
					total = total + Integer.valueOf(arr[neoX][now])  ;
					System.out.println("total : "+ total );
					
					if(top<total) {
						top= total;
					}
					total = recCall(neoX - 1, now, arr, total);
				}
			}
		}
		return total;
	}
}
