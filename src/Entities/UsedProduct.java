package Entities;

import java.util.Date;
import java.text.SimpleDateFormat;

public class UsedProduct extends Product{

    private Date manufactureDate;

    public UsedProduct (String name, Double price, Date manufactureDate){
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    @Override
    public String priceTag(){
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String dateStr = (manufactureDate == null) ? "" : sdf.format(manufactureDate);
    return getName() + " (used) $ " + String.format("%.2f", getPrice()) + " (Manufacture date: " + dateStr + ")";
}


}
