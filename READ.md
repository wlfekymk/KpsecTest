안녕하세요.  과제의 대한 설명을 작성합니다.

1. 패키지 구성 
   com.kpsec.algorithm : 과제2 코딩문제를 패키지
   com.kpsec.config : spring boot 를 이용한 설정 패키지
   com.kpsec.controller : api 를 Controller 패키지  (controller 및 advice) 
   com.kpsec.exception : 프로젝트의 커스텀 exception  패키지
   com.kpsec.init : 프로젝트 초기화 패키지
   com.kpsec.model : DTO 등의 model 패키지
   com.kpsec.repository : DB 핸들링 및 JPA 구현체 패키지
   com.kpsec.service : 프로젝트의 서비스 구현 패키지
   com.kpsec.util : 프로젝트의 UTIL 패키지
   com.kpsec.common : 공통 로깅 설정 및 AOP 사용

2. 과제 1 특정 고객 거래내역 조회 서비스 개발

  ㅇ 고객 거래내역 데이터(첨부)
  ㅇ 고객 데이터(첨부)
  ㅇ 지점 데이터(첨부)
  ㅇ 데이터는 CSV 파일로 각 레코드에 컬럼값은 ‘,’ 구분자로 저장이 되어 있습니다.
  ㅇ in memory DB에 테이블 구성 및 데이터를 Insert 하여 구성한다.
     - com.kpsec.init.initData.java sample를 참고하여, JPA를 이용한 DB2에 테이블 구성 및 데이터를 Insert 함
  
  ㅇ기본 제약사항(필수)
	-  API 기능명세에서 기술된 API를 모두 개발하세요.
    	1.  API 방식 : GET
			URL : 	http://localhost:8080/transaction/sumMaxTotalData
		2.  API 방식 : GET
	     	URL : http://localhost:8080/transaction/notTransClientData		
	    3.  API 방식 : GET
	  		URL : http://localhost:8080/transaction/yearByBranchSumAmtData
		4.  API 방식 : PUT
	  		URL : http://localhost:8080/transaction/updateMoveBranch  >> 분당점 통폐합 판교점 이관 API
			API 방식 : POST
	  		URL : http://localhost:8080/transaction/branchSumAmtData  >> 지점명 입력 해당지점 조회 API

   - Spring boot 기반의 프레임웍을 사용하세요.
        Spring boot 2.5.5  사용
        
-  단위 테스트(Unit Test) 코드를 개발하여 각 기능을 검증하세요. (필수사항)
	   controller, service 각 단위 테스트를 spring  mock 을 이용하여 구현
	   repository 영역은 @MybatisTest로 하였으며, sample 데이터의 초기 데이터를 메모리에 jpa로 넣는 방식을 사용 하고 있어서, 
	   inmemory의 테이블과 데이터가 들어가 있어야 함.
	   appliction.yml의 hibernate: ddl-auto 를 update로 바꿔야 함. 초기에는 테이블이 없기 때문에 한번 실행해서 테이블 및 데이터를 
	   만들어준뒤에 테스트를 해야함
	   
		
-  모든 입/출력은 JSON 형태로 주고 받습니다.
		work 파일의 요구 양식대로 구현 
		content-type :  application/json 
   
   - 단, 각 API에 HTTP Method들(GET|POST|PUT|DEL)은 자유롭게 선택하세요.
  	 	1.  API 방식 : GET 단순조회
  	 	2.  API 방식 : GET 단순조회
  	 	3.  API 방식 : GET 단순조회
  	 	4.  API 방식 : PUT 데이터 이관, POST 이관후 데이터 입력을 받아 조회
   
	README.md 파일을 추가하여, 개발 프레임웍크, 문제해결 방법, 빌드 및 실행 방법을 기술하세요.


       
      
  
  
  
  