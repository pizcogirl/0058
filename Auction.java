import java.util.ArrayList;

/**
 * A simple model of an auction.
 * The auction maintains a list of lots of arbitrary length.
 *
 * @author David J. Barnes and Michael Kölling.
 * @version 2011.07.31
 */
public class Auction
{
    // The list of Lots in this auction.
    private ArrayList<Lot> lots;
    // The number that will be given to the next lot entered
    // into this auction.
    private int nextLotNumber;

    /**
     * Create a new auction.
     */
    public Auction()
    {
        lots = new ArrayList<Lot>();
        nextLotNumber = 1;
    }

    /**
     * Enter a new lot into the auction.
     * @param description A description of the lot.
     */
    public void enterLot(String description)
    {
        lots.add(new Lot(nextLotNumber, description));
        nextLotNumber++;
    }

    /**
     * Show the full list of lots in this auction.
     */
    public void showLots()
    {
        for(Lot lot : lots) {
            System.out.println(lot.toString());
        }
    }

    /**
     * Make a bid for a lot.
     * A message is printed indicating whether the bid is
     * successful or not.
     * 
     * @param lotNumber The lot being bid for.
     * @param bidder The person bidding for the lot.
     * @param value  The value of the bid.
     */
    public void makeABid(int lotNumber, Person bidder, long value)
    {
        Lot selectedLot = getLot(lotNumber);
        if(selectedLot != null) {
            boolean successful = selectedLot.bidFor(new Bid(bidder, value));
            if(successful) {
                System.out.println("The bid for lot number " +
                    lotNumber + " was successful.");
            }
            else {
                // Report which bid is higher.
                System.out.println("Lot number: " + lotNumber +
                    " already has a bid of: " +
                    selectedLot.getHighestBid().getValue());
            }
        }
    }

    /**
     * Return the lot with the given number. Return null
     * if a lot with this number does not exist.
     * @param lotNumber The number of the lot to return.
     */
    public Lot getLot(int lotNumber)
    {
        Lot selectedLot = null;
        if((lotNumber >= 1) && (lotNumber < nextLotNumber)) {
            // The number seems to be reasonable.
            // Recorremos la lista de elementos buscando el que tenga ese numero
            // si existe, hacemos las demas operaciones
            // sino devuelve un mensaje de errror
            int indice = 0;
            while ((indice < lots.size()) && (selectedLot == null))
            {
                if (lots.get(indice).getNumber() == lotNumber)
                {
                    // Si es correcto, devuelve el lot
                    selectedLot = lots.get(indice);
                }
                indice++;
            }
        }
        if (selectedLot == null) {
            System.out.println("Lot number: " + lotNumber +
                " does not exist.");
        }
        return selectedLot;
    }

    /**
     * Show the details of all the lots in the auction.
     */
    public void close()
    {
        Bid puja;
        for(Lot lot : lots) {
            puja = lot.getHighestBid();
            String details = lot.getNumber() + " : " + lot.getDescription();
            if (puja != null)
            {
                details = details + "(Highest bid : " + lot.getHighestBid().getValue() + " from: " + 
                                    puja.getBidder().getName();
            }
            else
            {
                details = details + "(There's no bid yet)";
            }
            System.out.println(details);
        }
    }

    /**
     * Return a collection of all the unsold lots.
     */
    public ArrayList<Lot> unsold()
    {
        ArrayList<Lot> unSoldLots = new ArrayList<Lot>();
        for (Lot lot :lots)
        {
            if (lot.getHighestBid() == null)
            {
                unSoldLots.add(lot);
            }
        }
        return unSoldLots;
    }

    /**
     * Remove a lot with the given number
     */
    public Lot remove(int index)
    {
        // Recorremos la lista hasta encontrar el objeto que buscamos
        // y lo borramos
        int indice = 0;
        Lot lot = null;;
        while ((indice < (lots.size())) && (lot == null))
        {
            if (lots.get(indice).getNumber() == index)
            {
                // Si es correcto, devuelve el lot
                lot = lots.remove(indice);
            }
            indice++;
        }
        return lot;
    }

}
