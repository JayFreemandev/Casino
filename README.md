# Casino
<div align="center">
  <img src="https://github.com/JayFreemandev/Casino/assets/72185011/d15176c3-5cbf-4763-a88f-deaa9096a859" width="50%"> <br>
  <img src="https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=https%3A%2F%2Fgithub.com%2FJayFreemandev%2FCasino&count_bg=%2379C83D&title_bg=%23555555&icon=&icon_color=%23E7E7E7&title=hits&edge_flat=false" width="9%">
</div>
<hr>

### 프로젝트 소개
재미있게 보았던 "카지노" 드라마와 객체지향 기술서적들의 예제를 이용하여 구현한 프로젝트입니다.  
</br>  
  
**Casino(카지노)**  
객체의 책임과 역할을 나누어 객체들 사이 결합도를 낮게 유지하는 리팩토링 과정을 진행했습니다.
SRP, OCP 원칙을 통해 결합도를 낮추면서 응집도에 대한 트레이드 오프를 생각하며 균형 있는 설계를 고민했습니다.
리팩토링에 중점을 두고 반복적인 if else 처리 대신 정적인 경우 Enum, 확장 가능성이 존재하는 케이스는 디자인패턴을 적용했습니다.
</br>
  
**Transaction(입출금)**  
소프트웨어 개발원칙 중 KISS, DRY, SRP를 코드에 적용했고 Java 8의 Lambda를 활용하여 가독성을 높였습니다.
단위 테스트를 진행할 때는 직관적으로 읽기 쉽게 Given-When-Then 패턴을 적용했습니다.
Getter, Setter와 메소드를 제외하고는 테스트 커버리지 목표를 70~90%로 하였습니다. 
</br>  
  
**Management(관리)**  
SOLID중 리스코프 치환 원칙과 인터페이스 분리 원칙, 의존관계 역전을 생각하며 구현했습니다.
NPE를 해결하기 위해 Optional을 활용하여 신뢰성 있는 코드를 구현했습니다.
불변성을 보장하기 위해 변경 가능성이 없는 필드 변수들은 모두 final을 사용했고 컬렉션 사용 가능성과 객체의 행위와 상태를 한곳에서 관리하기 위해 일급 컬렉션을 사용했습니다.  
<hr> 

### 주요 목표
클린 코드, 테스트, 리팩토링 중심의 좋은 품질의 서비스 개발
- 복잡한 요구사항을 추상화시키며 기능 추가와 수정에 확장성 있는 대응
- 클린 코드를 통한 유지 보수하기 좋은 코드 구현
- 테스트 주도 개발로 신뢰성 있는 환경
<hr>

### 기술적고민  
*Casino의 클린코드 관점* 
wiki 작성중

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
