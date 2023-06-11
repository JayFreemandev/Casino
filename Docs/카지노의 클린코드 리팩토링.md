**해결 과정**

A와 B를 변경하면 C도 변경해야 할 때 커플링을 깨려면 A가 B와 C의 디테일 한 부분을 몰라도 사용가능하게 변경해야한다. 각 클래스가 본인의 역할만을 충족시키도록 만들어야한다. 캡슐화를 진행하자.

Casino의 enter 메소드를 ticketSeller에게 넘겼다.

```java
public class Casino {
    private final TicketSeller ticketSeller;

    public Casino(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

}
```

TicketSeller 클래스에서 ticketOffice 매표소를 private으로 바꿔서 외부에서 직원을 거치지 않고서는 매표소로 직접 접근할 수 없다. 캡슐화의 목적은 변경하기 쉬운 객체를 만드는 것. 이를 통해 객체 사이의 결합도를 낮춰 설계를 유연하게 만들었다.

```java
public class TicketSeller {
    private final TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void sell(Player player){
        if(player.getBag().hasInvitation()){
            Ticket ticket = ticketOffice.getTicket();
            player.getBag().setTicket(ticket);
        }else{
            Ticket ticket = ticketOffice.getTicket();
            player.getBag().minusAmount(ticket.getFee());
            ticketOffice.plusAmount(ticket.getFee());
            player.getBag().setTicket(ticket);
        }
    }
}
```

if else도 솔직히 마음에 들지않는다. 변경과 가독성을 높인후 마지막에 생각하려고한다.

Casino 클래스의 enter은 가벼워졌다. 카지노에서 직접 매표소로 접근 할 수없고 카지노 클래스 입장에서 생각해보면 매표소가 어디에 있는지도 모른다. 몰라도 되기 때문이다. 이로써 카지노는 직원 인터페이스에 의존하게된다. 

인터페이스로 연결한다? 객체 사이의 결합도 낮추고 변경하기 쉽게 만드는 기본 설계이다.

```java
public class Casino {
    private final TicketSeller ticketSeller;

    public Casino(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }
    
    public void enter(Player player){
        ticketSeller.sell(player);
    }
}
```

가장 이상했던 Player 손님의 가방에 멋대로 접근하는 못된 손을 지워야한다. 

```java
public class Player {
    private final Bag bag;
    public Player(Bag bag) {
        this.bag = bag;
    }
   
   /* public Bag getBag(){
        return bag;
    }*/
    
    public Long buy(Ticket ticket){
        if(bag.hasInvitation()){
            bag.setTicket(ticket);
            return 0L;
        }else{
            bag.setTicket(ticket);
            bag.minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }
}
```

기존에 찐따같던 손님은 직접 본인이 가방에서 티켓을 건내며 계산하게된다.

```java
public class TicketSeller {
    private final TicketOffice ticketOffice;
    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void sell(Player player){
        Long amount = player.buy(ticketOffice.getTicket());
        ticketOffice.plusAmount(amount);
    }

  /*  public TicketOffice getTicketOffice(){
        return ticketOffice;
    }*/
}
```

기존에 거만했던 직원은 손님 가방에 손도 못대고 손님이 오면 티켓을 팔고 받은 돈을 매표소로 입금하게 된다. 이것도 손님 인터페이스에 의존하게 한것이다.

직원과 손님 사이의 결합도는 낮아졌고 손님의 구현부분이 수정되더라도 돈만 받는 직원입장에서는 전혀 수정  사항이 없어진다.

![Untitled 2](https://user-images.githubusercontent.com/72185011/218489485-effbad68-03a2-4ce5-865b-3f95e75d3f0f.png)

