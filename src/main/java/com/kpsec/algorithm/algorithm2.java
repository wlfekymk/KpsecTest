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

	public static int arrayInit(int x, int y, String s) {
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
		return sumGame(x, y, arr);
	}

	

	public static int sumGame(int x, int y, String[][] arr) {

		int[] moves = { -1, 0, 1 }; 	// 이동가능 위치
		// y값이 0이 될때까지 반복
		// 초기 좌표
		int X = y - 1; 				// 왼쪽 상단
		int neoY = 0; 				// 왼쪽 상단  3,0 -> 2,0 -> 1,0 -> 0,0
		int frodoY = x - 1; 		// 오른쪽 상단
		System.out.println(X + "층");
		System.out.println("neo 시작 좌표 : " + X + "," + neoY + " >> 시작 값 : " + arr[X][neoY]);
		System.out.println("frodo 시작 좌표 : " + X + "," + frodoY + " >> 시작 값 : " + arr[X][frodoY]);
		int total = Integer.valueOf(arr[X][neoY]) + Integer.valueOf( arr[X][frodoY]);
		
		
		total = total + recCall(X-1, neoY, frodoY, arr, 0);
		
		return total;
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
	
	/**
	 * 맨윗층을 제외한 아래층의 최고합산을 리턴하는 재귀호출이 나와야함
	 * @param neofrodoX 초기 네오 프로도 위치 
	 * @param neoY 
	 * @param frodoY
	 * @param arr
	 * @param total 맨윗층을 제외한 아랫층 최고합산 
	 * @return
	 */
	public static int recCall(int X, int neoY, int frodoY, String[][] arr, int max) {
		int result = 0;
		int top = 0;
		int[] moves = { -1, 0, 1 }; // 이동가능 위치
		int sum = 0;  //중간 저장
		for (; X >= 0; X--) {
			System.out.println(X + "층");
			int neoYnow = 0;
			int frodoYnow = 0;
			
			//아래로 이동 가능 좌표를 루프 돌면서
			for (int neoMove : moves) {
				neoYnow = neoY + neoMove;
				// 네오의 말이 말판 밖으로 나가는지 확인 
				if(neoYnow >=0 && neoYnow <= frodoY){
					System.out.println("======================================");
					System.out.println("neo 현재 좌표 : " + X + "," + neoYnow + " >> 현재 값 : " + arr[X][neoYnow]);
	
					for(int frodoMove : moves) {
						frodoYnow = frodoY + frodoMove;

						// 프로도의 말이 말판 밖으로 나가는지 확인 
						if(frodoYnow <= frodoY && frodoYnow >=0 ) { 
							System.out.println("frodo 현재 좌표 : " + X + "," + frodoYnow + " >> 현재 값 : " + arr[X][frodoYnow]);
							
							// 두말이 같은 같으로 이동할수 있지만 점수는 한명에만 주어진다
							if (neoYnow == frodoYnow) 
								result = max + Integer.valueOf(arr[X][neoYnow]);
							else
								result = max + Integer.valueOf(arr[X][neoYnow]) + Integer.valueOf(arr[X][frodoYnow]);
							
							System.out.println("현재 합산 : " +sum);
							
							int total = recCall(X-1, neoYnow, frodoYnow, arr, sum);
							
							if(top>total) {
								return top;
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
						}
					}
				}
			}
		}
		
		return result;
	}


}
