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
  
**Comp(콤푸(식권) 입출금 내역)**  
소프트웨어 개발원칙 중 KISS, DRY, SRP를 코드에 적용했고 Java 8의 Lambda를 활용하여 가독성을 높였습니다.
단위 테스트를 진행할 때는 직관적으로 읽기 쉽게 Given-When-Then 패턴을 적용했습니다.
Getter, Setter와 메소드를 제외하고는 테스트 커버리지 목표를 70~90%로 하였습니다. 
</br>  
  
**Agent(고객 관리)**  
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
- 변경에 취약하고 객체의 책임을 분리해야하는 상황
- 반복되는 if문을 처리하는 다양한 방법
- 객체 지향에서 getter과 setter를 지향하는 이유
- 보다 효율적이고 보기좋은 패키지 구조에 대한 고민
- 정적 팩토리 메소드가 필요한 순간과 사용시 기본 생성자 private 이유
- 좋은 테스트 코드는 무엇일까([좋은 테스트를 갖췄는지의 여부를 어떻게 알 수 있는가?](https://currenjin.github.io/wiki/TDD/#%EC%A2%8B%EC%9D%80-%ED%85%8C%EC%8A%A4%ED%8A%B8%EB%A5%BC-%EA%B0%96%EC%B7%84%EB%8A%94%EC%A7%80%EC%9D%98-%EC%97%AC%EB%B6%80%EB%A5%BC-%EC%96%B4%EB%96%BB%EA%B2%8C-%EC%95%8C-%EC%88%98-%EC%9E%88%EB%8A%94%EA%B0%80)
[긴 셋업 코드](https://currenjin.github.io/wiki/TDD/#%EA%B8%B4-%EC%85%8B%EC%97%85-%EC%BD%94%EB%93%9C)
[셋업 중복](https://currenjin.github.io/wiki/TDD/#%EC%85%8B%EC%97%85-%EC%A4%91%EB%B3%B5)
[실행 시간이 오래 걸리는 테스트](https://currenjin.github.io/wiki/TDD/#%EC%8B%A4%ED%96%89-%EC%8B%9C%EA%B0%84%EC%9D%B4-%EC%98%A4%EB%9E%98-%EA%B1%B8%EB%A6%AC%EB%8A%94-%ED%85%8C%EC%8A%A4%ED%8A%B8)
[지기 쉬운 테스트](https://currenjin.github.io/wiki/TDD/#%EC%A7%80%EA%B8%B0-%EC%89%AC%EC%9A%B4-%ED%85%8C%EC%8A%A4%ED%8A%B8)
- 적절한 테스트 코드의 커버리지 수치는 어떻게 정할까
- 같은 클래스내 생성자가 두개 이상인 경우 생성자 체인 기법
- 생성자에서 모든 필드를 초기화 해야할까?
- Stream 사용시 findFirst와 findAny를 사용(stateful 순서와 병렬 처리)
- Stream 처리시 메서드 체이닝의 개수와 가독성
- equals와 hashCode를 재정의 하는 이유
- NPE를 방지하기 위한 optional 상황
- 불변 객체 사용과 일급 컬렉션을 사용하는 이유는 무엇일까
- static을 사용하여 utlity를 만드는건 나쁘게 봐야할까(아이템4, 인스턴스화 막아라)
- assertThat 대신 assertAll
- 자주 사용되는 상수들을 글로벌하게 관리하는것은 어떨까?
- [UnmodifiableList은 만능이 아니더라(방어적 복사)](https://ecsimsw.tistory.com/795)
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
