


public class Toy {
    
    private int id;
    private String name;
    private int quantity;
    private int weight;

     
    public Toy(int id, String name, int quantity, int weight) {
       
        this.id = id;
        this.name = name; 
        this.quantity = quantity;
        this.weight = weight;

      
    }

   
    public int changeWeight(int num) {
        weight = num;
        
        return weight;
    }
    
    public int minusOneItem() {
        quantity -= 1;
        
        return quantity;
    }

      
    public Integer getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getQuantity(){
        return quantity;
    }
    public int getWeight(){
        return weight;
    }
    
     
 
}   


        


