
class reservation implements Runnable
{
    int totalavailablleTickets=50;
    public void reserverSeat()
     {
        if(totalavailablleTickets>=1)
          totalavailablleTickets--;
        else
         {
            System.out.println("Sorry,No Seat vaccent...");
            System.exit(0);
         }
     }
    public void run()
    {
        synchronized(this)
        {
            System.out.println("Vaccent Seats are:"+totalavailablleTickets);
            try
            {
            Thread.currentThread().sleep(1000);
            }
            catch(Exception ex){}
            reserverSeat();
            System.out.println(Thread.currentThread().getName()+"Booked One ticket");
        }
    }
   
}
public class OnLineBusReservationSystem
{
 public static void main(String args[])
    {
    
    reservation rev=new reservation();
    for(int i=1;i<100;i++)
    {
    Thread t=new Thread(rev);
    t.setName("Seat"+i +" is Booking..");
    t.start();
    }
    
    }
}