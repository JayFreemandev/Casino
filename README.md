# 객체 설계 
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

[해결 과정](https://github.com/JayFreemandev/Casino/tree/main/Casino)  


#### reference
<details>
<summary> </summary>
- 오브젝트: 코드로 이해하는 객체지향 설계  
- 객체지향의 사실과 오해
</details>
