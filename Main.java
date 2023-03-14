import java.io.*;
import java.util.Scanner;
import java.util.Arrays;



public class Main {
    
    public static void main(String[] args) throws IOException {
        
        
        Scanner sc = new Scanner(System.in);
        
        Toy[] toys = new Toy[4];
        toys[0] = new Toy(1, "Konstruktor", 10, 20);
        toys[1] = new Toy(2, "Robot", 10, 20);
        toys[2] = new Toy(3, "Kukla", 10, 30);
        toys[3] = new Toy(4, "Pistolet", 10, 30);
        
        System.out.println("Первоначальный массив игрушек: ");
        for(int i = 0; i < toys.length; i++){
            System.out.println("ID: " + toys[i].getId() + ", Toy_name: " + toys[i].getName() +", quantity:" + toys[i].getQuantity() +", weight:" + toys[i].getWeight() );
        }
        
        System.out.println(" ");
        System.out.println("Массив выигранных игрушек");
        Toy[]winToy = new Toy[toys.length]; // список игрушек, ожидающих выдачи
        for (int i = 0; i < winToy.length; i++){
            Double random = Math.floor(Math.random() * 100) + 1; // в зависимости от выпавшей цифры выбираем диапазон, в которой находится определенная игрушка
                if (random <= toys[0].getWeight()) {  // разбиваем наш диапазон от 1 до 100 на интервалы, в зависимости от веса игрушки
                    winToy[i] = toys[0];
                    toys[0].minusOneItem();
                } else if (random <= toys[1].getWeight() + toys[1].getWeight()) { 
                    winToy[i] = toys[1];
                    toys[1].minusOneItem();
                } else if (random <= toys[2].getWeight() + toys[1].getWeight()+ toys[2].getWeight()) {
                    winToy[i] = toys[2];
                    toys[2].minusOneItem();
                } else if (random <= toys[3].getWeight() + toys[1].getWeight()+ toys[2].getWeight()+ toys[3].getWeight()) {
                    winToy[i] = toys[3];
                    toys[3].minusOneItem();
                }       
            System.out.println("ID: " + winToy[i].getId() + ", Toy_name: " + winToy[i].getName() +", quantity:" + winToy[i].getQuantity() +", weight:" + winToy[i].getWeight() );
        }

        try {  // запись выданных игрушек в файл
            FileWriter writer = new FileWriter("givenToyList.csv", true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write("ID: " + winToy[0].getId() + ", Toy_name: " + winToy[0].getName() +", quantity:" + winToy[0].getQuantity() +", weight:" + winToy[0].getWeight()+"\r\n");
            bufferWriter.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
        winToy[0].minusOneItem();
        
        winToy[0] = null; // обнуляем первый элемент в массиве (выдали игрушку)
        for (int i = 1; i < winToy.length; i++) { //выполняем перемещение элементов к началу, в результате чего пустой элемент окажется в конце
            winToy[i-1] = winToy[i];
            winToy[i] = null;
        }
        System.out.println(" ");
        System.out.println("Массив выигранных игрушек после отдачи первой:");
        for(int i = 0; i < winToy.length; i++){
            if (winToy[i] == null)  System.out.println ("ID: 0, Toy_name: 0, quantity: 0 , weight: 0" );
            else System.out.println("ID: " + winToy[i].getId() + ", Toy_name: " + winToy[i].getName() +", quantity:" + winToy[i].getQuantity() +", weight:" + winToy[i].getWeight() );
            
        }
        
        System.out.println(" ");
        System.out.println(" Добавить новую игрушку - 1\n Поменять значения веса у игрушек - 2\n Ничего не делать - 3 ");
           
            switch (sc.nextInt()) {
                case 1 :
                    toys = append(toys);
                    break;
                case 2 :
                    for(int i = 0; i < toys.length; i++){ 
                        System.out.println("Введите новое значение веса у " + toys[i].getName());
                        int newWeight = sc.nextInt();
                        toys[i].changeWeight(newWeight);
                        System.out.println("Новое значение веса у "+ toys[i].getName()+": "+ toys[i].getWeight());
                    }
                    break;
                case 3 :
                    break;
                default: System.out.println("Неверная команда"); break;
                    
            } 
            
           
                    
        System.out.println(" ");
        System.out.println("Первоначальный массив игрушек после розыгрыша");
        for(int i = 0; i < toys.length; i++){
            
            System.out.println("ID: " + toys[i].getId() + ", Toy_name: " + toys[i].getName() +", quantity:" + toys[i].getQuantity() +", weight:" + toys[i].getWeight() );
            
        }
        
        sc.close();
    }

    private static <T> Toy[] append(Toy[] arr) // метод добавления новой игрушки в список
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите id игрушки ");
        int tempid = sc.nextInt();
        for(int i = 0; i<arr.length; i++){    
            while (arr[i].getId().equals(tempid)){ 
                System.out.println("Такой id существует, придумайте новый:");
                tempid = sc.nextInt();
            }
        }
        Integer id = tempid;
        System.out.println("Введите наименование игрушки: ");
        String name = sc.next();
        System.out.println("Введите количество игрушкек " + name);
        Integer quantity = sc.nextInt();
        System.out.println("Введите вес игрушки " + name);
        Integer weight = sc.nextInt();
        Toy[] temp = new Toy[1];
        
        
        Toy[] array = Arrays.copyOf(arr, arr.length + 1);
        array[arr.length] = temp[0] = new Toy(id, name, quantity, weight);
        sc.close();
        return array;
    }
    
}