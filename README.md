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
Casino 프로젝트는 카지노의 기능을 구현한 프로젝트로, 칩을 추가하고 금액을 증감시키며, 딜러를 통해 칩을 교환하여 게임을 즐기는 프로젝트입니다.
객체의 책임과 역할을 나누어 객체들 사이 결합도를 낮게 유지하는 리팩토링 과정을 진행했습니다.
SRP, OCP 원칙을 통해 결합도를 낮추면서 응집도에 대한 트레이드 오프를 생각하며 균형 있는 설계를 고민했습니다.
리팩토링에 중점을 두고 반복적인 if else 처리 대신 정적인 경우 Enum, 확장 가능성이 존재하는 케이스는 디자인패턴을 적용했습니다.
</br>
  
**Comp(콤푸 입출금 내역)**    
Comp는 카지노 이용객의 게임 금액과 시간에 따라 포인트를 지급받아 호텔 내에서 사용 할 수 있는 마일리지입니다. 입력 파일을 분석하여 콤푸(마일리지) 기록의 합계, 월별 합계, 카테고리별 합계 등을 계산하여 내역을 분석하는 프로젝트입니다.
소프트웨어 개발원칙 중 KISS, DRY, SRP를 코드에 적용했고 Java 8의 Lambda를 활용하여 가독성을 높였습니다.
단위 테스트를 진행할 때는 직관적으로 읽기 쉽게 Given-When-Then 패턴을 적용했습니다.
Getter, Setter와 메소드를 제외하고는 테스트 커버리지 목표를 70~90%로 하였습니다. 
</br>  
  
**Agent(고객 관리)**  
Agent 프로젝트는 카지노에 방문한 고객 관리를 위한 시스템으로, 고객들의 숙소 예약, 환전, 식사 준비를 대신 도와주는 서비스를 제공합니다. 
NPE를 해결하기 위해 Optional을 활용하여 신뢰성 있는 코드를 구현했습니다. 이상적인 예외 처리 방법에 대해 고민했습니다.
불변성을 보장하기 위해 변경 가능성이 없는 필드 변수들은 모두 final을 사용했고 컬렉션 사용 가능성과 객체의 행위와 상태를 한곳에서 관리하기 위해 일급 컬렉션을 사용했습니다.  
<hr> 

### 주요 목표
클린 코드, 테스트, 리팩토링 중심의 좋은 품질의 서비스 개발
- 복잡한 요구사항을 추상화시키며 기능 추가와 수정에 확장성 있는 대응
- 클린 코드를 통한 유지 보수하기 좋은 코드 구현
- 테스트 주도 개발로 신뢰성 있는 환경
<hr>

### [기술적고민](https://github.com/JayFreemandev/Casino/wiki)  
- [변경에 취약하고 객체의 책임을 분리해야하는 상황](https://github.com/JayFreemandev/Casino/wiki/%EB%B3%80%EA%B2%BD%EC%97%90-%EC%B7%A8%EC%95%BD%ED%95%98%EA%B3%A0-%EA%B0%9D%EC%B2%B4%EC%9D%98-%EC%B1%85%EC%9E%84%EC%9D%84-%EB%B6%84%EB%A6%AC%ED%95%B4%EC%95%BC%ED%95%98%EB%8A%94-%EC%83%81%ED%99%A9)
- [반복되는 if문을 처리하는 다양한 방법](https://github.com/JayFreemandev/Casino/wiki/%EB%B0%98%EB%B3%B5%EB%90%98%EB%8A%94-if%EB%AC%B8%EC%9D%84-%ED%94%BC%ED%95%98%EB%8A%94-%EB%B0%A9%EB%B2%95)
- [객체 지향에서 getter과 setter를 지향하는 이유](https://github.com/JayFreemandev/Casino/wiki/%EA%B0%9D%EC%B2%B4%EC%A7%80%ED%96%A5%EC%97%90%EC%84%9C-getter%EC%99%80-setter%EB%A5%BC-%EC%A7%80%EC%96%91%ED%95%B4%EC%95%BC%ED%95%98%EB%8A%94-%EC%9D%B4%EC%9C%A0)
- [보다 효율적이고 보기좋은 패키지 구조에 대한 고민](https://github.com/JayFreemandev/Casino/wiki/%ED%9A%A8%EC%9C%A8%EC%A0%81%EC%9D%B4%EA%B3%A0-%EB%B3%B4%EA%B8%B0%EC%A2%8B%EC%9D%80-%ED%8C%A8%ED%82%A4%EC%A7%80-%EA%B5%AC%EC%A1%B0%EC%97%90-%EB%8C%80%ED%95%9C-%EA%B3%A0%EB%AF%BC)
- [정적 팩토리 메소드가 필요한 순간과 사용시 기본 생성자 private 이유](https://github.com/JayFreemandev/Casino/wiki/%EC%A0%95%EC%A0%81-%ED%8C%A9%ED%86%A0%EB%A6%AC-%EB%A9%94%EC%86%8C%EB%93%9C%EA%B0%80-%ED%95%84%EC%9A%94%ED%95%9C-%EC%88%9C%EA%B0%84%EA%B3%BC-%EC%82%AC%EC%9A%A9%EC%8B%9C-%EA%B8%B0%EB%B3%B8-%EC%83%9D%EC%84%B1%EC%9E%90-private-%EC%A7%80%EC%A0%95-%ED%95%98%EB%8A%94-%EC%9D%B4%EC%9C%A0)
<hr>

- [좋은 테스트 코드는 무엇일까](https://github.com/JayFreemandev/Casino/wiki/%EC%A2%8B%EC%9D%80-%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%BD%94%EB%93%9C%EB%8A%94-%EB%AC%B4%EC%97%87%EC%9D%BC%EA%B9%8C%3F)
- [적절한 테스트 코드의 커버리지 수치는 어떻게 정할까](https://github.com/JayFreemandev/Casino/wiki/%EC%A0%81%EC%A0%88%ED%95%9C-%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%BD%94%EB%93%9C%EC%9D%98-%EC%BB%A4%EB%B2%84%EB%A6%AC%EC%A7%80-%EC%88%98%EC%B9%98%EB%8A%94-%EC%96%B4%EB%96%BB%EA%B2%8C-%EC%A0%95%ED%95%A0%EA%B9%8C)
- [같은 클래스내 생성자가 두개 이상인 경우 생성자 체인 기법](https://github.com/JayFreemandev/Casino/wiki/%EA%B0%99%EC%9D%80-%ED%81%B4%EB%9E%98%EC%8A%A4%EB%82%B4-%EC%83%9D%EC%84%B1%EC%9E%90%EA%B0%80-%EB%91%90%EA%B0%9C-%EC%9D%B4%EC%83%81%EC%9D%B8-%EA%B2%BD%EC%9A%B0-%EC%83%9D%EC%84%B1%EC%9E%90-%EC%B2%B4%EC%9D%B8-%EA%B8%B0%EB%B2%95)
- [Stream 으로 리팩토링하며 고려해야할 상황](https://github.com/JayFreemandev/Casino/wiki/Stream-%EC%9C%BC%EB%A1%9C-%EB%A6%AC%ED%8C%A9%ED%86%A0%EB%A7%81%ED%95%98%EB%A9%B0-%EA%B3%A0%EB%A0%A4%ED%95%B4%EC%95%BC%ED%95%A0-%EC%83%81%ED%99%A9)
- [equals와 hashCode를 재정의 하는 이유](https://github.com/JayFreemandev/Casino/wiki/equals%EC%99%80-hashCode%EB%A5%BC-%EA%B0%99%EC%9D%B4-%EC%9E%AC%EC%A0%95%EC%9D%98-%ED%95%98%EB%8A%94-%EC%9D%B4%EC%9C%A0)
<hr>

- [NPE를 방지하기 위한 optional 상황](https://github.com/JayFreemandev/Casino/wiki/NPE-%EB%B0%A9%EC%A7%80%EC%9A%A9-optional-%EC%82%AC%EC%9A%A9-%EB%B0%A9%EB%B2%95)
- [불변 객체 사용과 일급 컬렉션을 사용하는 이유는 무엇일까](https://github.com/JayFreemandev/Casino/wiki/%EB%B6%88%EB%B3%80-%EA%B0%9D%EC%B2%B4%EB%A5%BC-%EB%A7%8C%EB%93%9C%EB%8A%94-%EB%B0%A9%EB%B2%95%EA%B3%BC-%EB%A7%8C%EB%93%9C%EB%8A%94-%EC%9D%B4%EC%9C%A0(feat.-%EC%9D%BC%EA%B8%89-%EC%BB%AC%EB%A0%89%EC%85%98))
- [static을 사용하여 utlity를 만드는건 나쁘게 봐야할까](https://github.com/JayFreemandev/Casino/wiki/static%EC%9D%84-%EC%82%AC%EC%9A%A9%ED%95%9C-utility%EC%97%90-%EB%8C%80%ED%95%9C-%EC%83%9D%EA%B0%81)
- [자주 사용되는 상수들을 글로벌하게 관리하는것은 어떨까?](https://github.com/JayFreemandev/Casino/wiki/%EC%9E%90%EC%A3%BC-%EC%82%AC%EC%9A%A9%EB%90%98%EB%8A%94-%EC%83%81%EC%88%98%EB%93%A4%EC%9D%84-%EA%B8%80%EB%A1%9C%EB%B2%8C%ED%95%98%EA%B2%8C-%EA%B4%80%EB%A6%AC%ED%95%98%EB%8A%94%EA%B2%83%EC%9D%80-%EC%96%B4%EB%96%A8%EA%B9%8C%3F)
- [방어적 복사시 UnmodifiableList가 불변을 보장해주지는 않았다](https://github.com/JayFreemandev/Casino/wiki/UnmodifiableList%EA%B0%80-%EB%B6%88%EB%B3%80%EC%9D%84-%EB%B3%B4%EC%9E%A5%ED%95%B4%EC%A3%BC%EC%A7%80%EB%8A%94-%EC%95%8A%EB%8A%94%EB%8B%A4.)
- [이상적인 예외 처리에 대한 고민](https://github.com/JayFreemandev/Casino/wiki/%EC%9D%B4%EC%83%81%EC%A0%81%EC%9D%B8-%EC%98%88%EC%99%B8-%EC%B2%98%EB%A6%AC%EC%97%90-%EB%8C%80%ED%95%9C-%EA%B3%A0%EB%AF%BC)
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
