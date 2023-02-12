# 객체 설계
![Untitled](https://user-images.githubusercontent.com/72185011/218302167-a3664fef-7f1f-4698-842d-7786a3b50c9d.png)  
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
