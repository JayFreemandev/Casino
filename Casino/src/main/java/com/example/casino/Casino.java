package main.java.com.example.casino;

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
