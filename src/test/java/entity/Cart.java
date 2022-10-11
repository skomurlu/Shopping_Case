package entity;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    //----------------------Fields-------------------------------------------------------------------------
    // Alisveris sepetinde, sepete eklenen urunleri CartItem sinifi cinsinden "items" isimli bir List de tutacagiz...
    // Sepete birden fazla CartItem eklenebileceginden instance degiskeniniz List seklende tanimlanmalidir.
    // Ayrica sepetteki CartItem larin toplam fiyatini bir double totalCartCost degiskeninde tutacagiz...
    private List<CartItem> items = new ArrayList<>();
    private double totalCartCost;

    //----------------------Constructor---------------------------------------------------------------------
    // Alisveris sepeti olusturulurken herhangi bir degiskeni initilize etmemize gerek yoktur...


    //----------------------Instance Methods----------------------------------------------------------------
    // Return tipi void olan addToCart methodu tanimlayin...
    // Bu method cagirildiginda, parametre olarak aldigi CartItem'i yukarida tanimlanan "items" List ine eklesin...
    // Ayni urun daha once eklenmis ise bu urunun sadece miktarini guncellemeniz gerekmektedir...
    // Sepete yeni urun eklenmesi veya miktarinin artmasi "totalCartCost" sepetteki fiyati etkileyecektir...
    public void addToCart(CartItem item){
        for (CartItem cartItem : items){
            if (item.getItem().equals(cartItem.getItem())){
                cartItem.setQuantity(cartItem.getQuantity() + item.getQuantity());
                calculateTotalCartCost();
                return;
            }
        }
        this.items.add(item);
        calculateTotalCartCost();
    }

    // Return tipi void olan calculateTotalCartCost() methodu tanimlayin...
    // Bu method cagirildiginda, sepete eklenen tum urunlerin adetine gore toplam sepet fiyatini hesaplasin...
    // Instance degisken olarak tanimladigimiz totalCartCost degiskenini guncelleyin...
    // addToCart methodu icerisinde bu methodu cagirabilirsiniz...
    private void calculateTotalCartCost() {
        this.totalCartCost = 0;
        for(CartItem cartItem: items){
            totalCartCost += cartItem.getQuantity() * cartItem.getItem().getPrice();
        }
    }

    // Return tipi void olan emptyCart() isimli bir method tanimlayin
    // Bu method cagirildiginda, sepetinizdeki urunleri-"items" silsin-temizlesin-bosaltsin...
    public void emptyCart(){
        this.items.clear();
    }


    //----------------------Getter and Setter ---------------------------------------------------------------------

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public double getTotalCartCost() {
        return totalCartCost;
    }

    public void setTotalCartCost(double totalCartCost) {
        this.totalCartCost = totalCartCost;
    }
}
