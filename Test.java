import java.util.ArrayList;
public class Test
{
    public void test1()
    {
        Auction auction = new Auction();

        auction.enterLot("1");
        auction.enterLot("2");
        auction.enterLot("A");
        auction.enterLot("B");
        auction.enterLot("C");
        
        Person bb = new Person("bb");
        Person aa = new Person("aa");
        Person cc = new Person("cc");
        
        auction.makeABid(1, bb, 100);
        auction.makeABid(2, aa, 200);
        auction.makeABid(3, cc, 300);

        auction.close();
    } 
    
    public void test2()
    {
         Auction auction = new Auction();
         ArrayList<Lot> prueba = new ArrayList<Lot>();

        auction.enterLot("1");
        auction.enterLot("2");
        auction.enterLot("A");
        auction.enterLot("B");
        auction.enterLot("C");
        
        Person bb = new Person("bb");
        Person aa = new Person("aa");
        Person cc = new Person("cc");
        
        auction.makeABid(1, bb, 100);
        auction.makeABid(2, aa, 200);
        auction.makeABid(3, cc, 300);
        prueba = auction.unsold();
        for (Lot lots : prueba)
        {
            System.out.println(lots.toString());
        }
    }
    
     public void test3()
    {
         Auction auction = new Auction();

        auction.enterLot("1");
        auction.enterLot("2");
        auction.enterLot("A");
        auction.enterLot("B");
        auction.enterLot("C");
        
        auction.remove(2);
        auction.getLot(2);
        auction.getLot(3);
        auction.close();
    }
}