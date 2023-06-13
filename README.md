### 프로젝트 소개
재미있게 보았던 "카지노" 드라마를 객체지향적으로 바라보며 설계하고 구현한 프로젝트입니다.  
</br>
**Casino(카지노)**  
카지노, 매표소, 매표소 직원, 손님 객체로 이루어져있습니다.  
객체들의 명확한 역할을 나누고 가독성과 결합도를 낮추며 클린코드에 집중했습니다.  
리팩토링에 중점을 두고 반복적인 IF 분기문 처리 대신 Enum과 Switch를 이용하여 진행했습니다.  
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

카지노의 손님들은 가방을 가져와야되고 가방에는 아래만 소지가 가능합니다.

- 티켓
- 초대장
- 돈

초대장을 받은 VIP 손님은 매표소에서 티켓으로 교환할 수 있고 초대장이 없다면 구매해야됩니다.

매표소에는 아래와 같은 필드들이 존재합니다.

- 판매할 티켓
- 티켓 판매 금액

매표소에서 티켓을 판매할 판매원은 아래와 같은 필드가 필요합니다.

- 자신이 일하는 매표소(ticketOffice)

![Untitled 1](https://user-images.githubusercontent.com/72185011/218302171-298e2cd5-0720-469d-98ca-f3047602be3d.png)

Casino 클래스

```java
public class Casino {
    private TicketSeller ticketSeller;

    public Casino(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }
    
    public void enter(Player player){
        if(player.getBag().hasInvitation()){
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            player.getBag().setTicket(ticket);
        }else{
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            player.getBag().minusAmount(ticket.getFee());
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
            player.getBag().setTicket(ticket);
        }
    }
}
```

문제점이 보이나요?
<details>
<summary>클린 코드 관점</summary>
클린 코드 관점
    1. 정상 동작
    2. 변경에 용이
    3. 쉽게 이해 가능한 가독성
    
    2번과 3번을 충족하지 못했다. 
    위 Casino 클래스 enter 메소드를 보면 가방을 뒤져서 초대권이 있으면 직원이 매표소 티켓꺼내서 가방에 넣어주고 입장권이 없으면 
    가방에서 돈빼서 매표소에 넣고 티켓을 손님 가방에 넣어준다.
    
    → 손님과 직원은 카지노의 수동적인 존재
    
    문제
    
    1. 손님
        1. 카지노에서 내 가방을 마음대로 뒤진다.
    2. 직원
        1. 카지노에서 허락도없이 티켓과 현금에 마음대로 접근한다.
        2. 관람객 가방에 티켓을 넣어주고 돈을 계산하는 일을 카지노가 하고있다.
    
    현실에서는 불가능한 일이다.  
    
    enter 메소드를 이해하기 위해서는 전체적인 내용을 모두 이해하고 있어야 사용 가능하다.
    하나의 클래스에서 너무 많은 내용을 가지고있기에 코드를 작성하는 사람이나 읽는 사람이나 악취를 느낄 수 있다.
    
    마지막 문제는 만약 직원이나 손님 클래스를 변경 할 경우 카지노 클래스까지 영향을 주게된다.
    객체 사이의 의존성을 완전히 제거 할 수는 없다. **객체지향 설계란 서로 의존하며 협력하는 객체들의
    공동체를 구축하는것**이기 때문이다. 
</details>

[해결 과정](https://github.com/JayFreemandev/Casino/blob/main/Docs/%EC%B9%B4%EC%A7%80%EB%85%B8%EC%9D%98%20%ED%81%B4%EB%A6%B0%EC%BD%94%EB%93%9C%20%EB%A6%AC%ED%8C%A9%ED%86%A0%EB%A7%81.md)  
<hr>

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
