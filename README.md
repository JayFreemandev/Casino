# Casino
<div align="center">
  <img src="https://github.com/JayFreemandev/Casino/assets/72185011/d15176c3-5cbf-4763-a88f-deaa9096a859" width="50%"> <br>
  <img src="https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=https%3A%2F%2Fgithub.com%2FJayFreemandev%2FCasino&count_bg=%2379C83D&title_bg=%23555555&icon=&icon_color=%23E7E7E7&title=hits&edge_flat=false" width="9%">
</div>
<hr>

### 프로젝트 소개
재미있게 보았던 "카지노" 드라마를 객체지향적으로 바라보며 설계하고 구현한 프로젝트입니다.  
</br>

**Casino(카지노)**  
카지노, 카지노 데스크, 딜러와 손님 객체로 책임과 역할을 나누며 가독성과 결합도를 낮추며 클린코드에 집중했습니다.  
리팩토링에 중점을 두고 반복적인 if 분기문 처리 대신 Enum과 Switch를 이용하여 진행했습니다.  
</br>

**Transaction(입출금)**  
소프트웨어 개발원칙중 KISS, DRY, SRP를 코드에 적용했고 Java8의 Lambda를 활용하여 가독성을 높혔습니다.  
유닛 테스트를 진행할때는 직관적으로 읽기 쉽게 Given-When-Then 패턴을 적용했습니다.  
Getter, Setter와 메소드를 제외하고는 테스트 커버리지 목표를 70~90%로 하였습니다.  
</br>  

**Management(관리)**  
모킹을 이용한 테스트 주도 개발(TDD)을 적용하면서 좋은 테스트 코드란 무엇인가에 대해 생각했습니다.   
SOLID중 리스코프 치환 원칙과 인터페이스 분리 원칙, 의존관계 역전을 생각하며 구현했습니다.   
NPE를 해결하기 위해 Optional을 활용하여 신뢰성있는 코드를 구현했습니다.
</br> 
<hr> 

### 주요 목표
클린 코드, 테스트, 리팩토링 중심의 좋은 품질의 서비스 개발
- 복잡한 요구사항을 추상화 시키며 기능 추가와 수정에 확장성있는 대응
- 클린 코드를 통한 유지보수하기 좋은 코드 구현
- 테스트 주도 개발로 신뢰성있는 환경
<hr>

### 기술적고민  
  
*Casino의 클린코드 관점* 

**위시리스트**   
1. 객체지향 생활체조 원칙중 일급 컬렉션 사용과 getter/setter가 없다고 생각하고 리팩토링 진행  
2. 자바 버전을 17까지 높여보며 변경된 Switch 표준식으로 리팩토링 진행  
3. 자바 -> 코틀린 전환

<hr>
<details>
<summary> reference </summary>
- 오브젝트: 코드로 이해하는 객체지향 설계  
- 객체지향의 사실과 오해
- 좋은 코드, 나쁜 코드
- 실전 자바 소프트웨어
- 자바 코딩의 기술
- 쏙쏙 들어오는 함수형 코딩
- 단위 테스트
</details>
