import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Entities.ImportedProduct;
import Entities.Product;
import Entities.UsedProduct;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        ArrayList <Product> lista = new ArrayList<>();

        System.out.print("Enter the number of products: ");

        int productNumber = sc.nextInt();

        for(int p = 0; p < productNumber; p++){

            System.out.printf("Product #%d data: %nCommon, used or imported (c/u/i)?", (p+1));
            char aux = sc.next().toLowerCase().charAt(0);

            System.out.print("Name: ");
            String nome = sc.next();

            System.out.print("Price: ");
            Double preco = sc.nextDouble();

            Product prod = null;

            switch(aux){    
                case('c'):
                    prod = new Product(nome, preco);

                    lista.add(prod);
                break;
               case ('u'):
                    System.out.print("Manufacture date (DD/MM/YYYY): ");

                    String dateStr = sc.next();

                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    sdf.setLenient(false); 

                    Date manufactureDate = sdf.parse(dateStr);

                    prod = new UsedProduct(nome, preco, manufactureDate);

                    lista.add(prod);
                    break;

                case('i'):
                    System.out.print("Customs fee: ");
                    Double taxa = sc.nextDouble();

                    prod = new ImportedProduct(nome, preco, taxa);

                    lista.add(prod);
                break;

                default:
                throw new IllegalArgumentException("A opção escolhida não é uma alternativa.");
            }
            
        }

        System.out.println("PRICE TAGS: ");
        for(Product p : lista){
            System.out.println(p.priceTag());
        }


    }
}
