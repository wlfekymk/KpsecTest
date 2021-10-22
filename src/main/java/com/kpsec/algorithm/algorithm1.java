package com.kpsec.algorithm;
/**
 * @author 이로얌
 *
 1. 편의점 알바를 하던 죠르디는 알파벳 문자로 이루어진 상품코드가 너무 길어 별도의 규칙을 만들어 인코딩하려고 합니다. 
    죠르디는 문자열 안에 연속적으로 반복되는 문자를 "반복되는횟수 [문자]"형태로 인코딩할 계획입니다. 
    예를들어 aaaz는 3[a]z로 인코딩되고 accccaccccacccc는 a4[c]a4[c]a4[c]로 1회 인코딩 되고 다시3[a4[c]]로 인코딩 됩니다. 
    인코딩에 너무 집중한 죠르디는 인코딩한 문자열을 다시 원래 문자열로 만드는 디코딩 프로그램 작성을 깜빡했습니다. 
    죠르디 대신 인코딩된 문자열이 들어왔을 때, 디코딩된 문자열을 반환하는 프로그램을 작성해 주세요.

	규칙
		- 입력되는 문자열은 숫자, 문자, 괄호로만 이루어져 있습니다.
		- 숫자는 양의 정수이며, 문자에는 숫자가 포함되지 않습니다. 예를 들어 3a, 2[4]와 같은 입력은 존재하지 않습니다.
		- 입력되는 문자열의 길이는 L은 0 < L < 128 입니다.
	예제 입출력
		- 입력 : 3[a]z
		- 출력 : aaaz

		- 입력 : 3[a4[c]]
		- 출력 : accccaccccacccc
 *
 */
public class algorithm1 {

	public static void main(String[] args) throws Exception {
		String test1 = "3[a]z";
		String test2 = "3[a4[c]]";
		String test3 = "3[ab]a";
		String test4 = "2[3[ab]a]";
		decProgram(test1);
		decProgram(test2);
		decProgram(test3);
		decProgram(test4);
	}

	public static String decProgram(String encStr) {
		System.out.println("=================================");
		System.out.println("인코딩 문자열 : " + encStr);
	    
		if ((encStr == null) || (0>encStr.length()) || (encStr.length()>128)) {
	    	return encStr;
	    }
	    
		int closeCnt;
		// 닫는 괄호 위치 찾아야 함
		while ((closeCnt = encStr.indexOf(']')) > -1) {
			// 뒤에서 부터 여는 괄호 위치 찾기
			int openCnt = encStr.lastIndexOf('[', closeCnt);
			String partStr = encStr.substring(openCnt + 1, closeCnt);
			String countStr = "";
			int index = openCnt - 1;
			while (index >= 0 && Character.isDigit(encStr.charAt(index))) {
				countStr = encStr.charAt(index) + countStr;
				index--;
			}
			int count = Integer.parseInt(countStr);
			//재귀호출
			
			StringBuilder buffer = new StringBuilder(count * partStr.length());
			for (int i = 0; i < count; i++) {
				buffer.append(partStr);
			}
			System.out.println("치환될 문자열 : " + buffer.toString());
			encStr = encStr.substring(0, index + 1) + buffer.toString() + encStr.substring(closeCnt + 1);
		}
		
		System.out.println("디코딩 된 문자열 : " + encStr);
		System.out.println("=================================");
		
		return encStr;
	}
}
