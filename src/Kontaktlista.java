/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author sarmo01
 */
public class Kontaktlista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner input = new Scanner(System.in);// för att användaren ska kunna skriva in
        ArrayList<Kontakt> konList = new ArrayList<>(); // skapar en arraylist
        FileManager list = new FileManager(); 
        //int räknare = 0;
        int MenyVal; 
        
        do{// do-while loop
        System.out.println("1. Ny kontakt");// presenterar val
        System.out.println("2. Skriv ut förnamn först");
        System.out.println("3. Skriv ut efternamn först");
        System.out.println("4. Spara");
        System.out.println("5. Hämta");
        System.out.println("0. Avsluta");
        MenyVal = input.nextInt();
        
        switch(MenyVal){
            case 1:
                
               nyKontakt(konList, input); //anropar metod
            
                 break;
                
            case 2:
                skrivUtFörnamn(konList); //anropar metod
                
                break;
                
            case 3:
                skrivUtEfternamn(konList); //anropar metod
                
                break;
                
            case 4:
                list.saveToFile(konList); 
                
                break;
                
            case 5:
                konList = FileManager.readFromFile();
                /*for( int i = 0; i<konList.size(); i++){
            konList.get(i).skrivUtFörnamn();
                }*/
                
                break;
                
            case 0:
                break;
            default:
                System.out.println("ogitigt val"); // skriver ut ogiltigt val
        }
        
    }while(MenyVal!=0);
        
    }
    //metoder
    public static void nyKontakt(ArrayList<Kontakt> konList, Scanner input){
            input.nextLine();
            System.out.print("Ange förnamn: "); // frågar om uppgifter
            String förnamn = input.nextLine();
            
            System.out.print("Ange efternamn: ");
            String efternamn = input.nextLine();
            
            System.out.print("Ange telefonnummer: ");
            String telefonnummer = input.nextLine();
            
             Kontakt kon = new Kontakt(förnamn,efternamn,telefonnummer);
             konList.add(kon);// skapar nytt objekt
    }
    public static void skrivUtFörnamn(ArrayList<Kontakt> konList){
        for( int i = 0; i<konList.size(); i++){ // for-loop för att skriva ut kontakterna
            konList.get(i).skrivUtFörnamn();
        }
    }
    public static void skrivUtEfternamn(ArrayList<Kontakt> konList){
            for( int i = 0; i<konList.size(); i++){  // for-loop för att skriva ut kontakterna
            konList.get(i).skrivUtEfternamn();
        }
    }
}

/*
Scanner input = new Scanner(System.in);
        Kontakt[] kontaktlista = new Kontakt[100];
        int räknare = 0;
        int MenyVal;
        
        do{
        System.out.println("1. Ny kontakt");
        System.out.println("2. Skriv ut förnamn först");
        System.out.println("3. Skriv ut efternamn först");
        System.out.println("0. Avsluta");
        MenyVal = input.nextInt();
        
        switch(MenyVal){
            case 1:
                
               nyKontakt(kontaktlista,räknare, input);
                
            räknare++;
            
                 break;
                
            case 2:
                skrivUtFörnamn(kontaktlista,räknare);
                /*for( int i = 0; i<räknare; i++){
            kontaktlista[i].skrivUtFörnamn();
        }
                break;
                
            case 3:
                skrivUtEfternamn(kontaktlista,räknare);
                /*for( int i = 0; i<räknare; i++){
            kontaktlista[i].skrivUtEfternamn();
        }
                break;
                
            case 0:
                
                break;
            default:
                System.out.println("ogitigt val");
        }
        
    }while(MenyVal!=0);
        
    }
    public static int nyKontakt(Kontakt[] kontaktlista, int räknare, Scanner input){
            input.nextLine();
            System.out.print("Ange förnamn: ");
            String förnamn = input.nextLine();
            
            System.out.print("Ange efternamn: ");
            String efternamn = input.nextLine();
            
            System.out.print("Ange telefonnummer: ");
            String telefonnummer = input.nextLine();
            
            kontaktlista[räknare] = new Kontakt(förnamn,efternamn,telefonnummer);
            return räknare;
    }
    public static void skrivUtFörnamn(Kontakt[] kontaktlista, int räknare){
        for( int i = 0; i<räknare; i++){
            kontaktlista[i].skrivUtFörnamn();
        }
    }
    public static void skrivUtEfternamn(Kontakt[] kontaktlista, int räknare){
            for( int i = 0; i<räknare; i++){
            kontaktlista[i].skrivUtEfternamn();
        }
    }
}*/

