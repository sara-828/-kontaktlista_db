
import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sarmo01
 */
public class Kontakt implements Serializable{
    // aattribut som lagrar information om kontakter
    private String förnamn;
    private String efternamn;
    private String telefonnummer;
    

public Kontakt (String f, String e, String t) {// konstruktor som tar förnamn, efternamn och telefon
    this.förnamn = f;
    efternamn = e;
    telefonnummer = t;

}
public Kontakt (String f, String e) {// konstruktor som tar förnamn och efternamn
    this.förnamn = f;
    this.efternamn = e;
    this.telefonnummer = "";

}
public Kontakt (String f) {// konstruktor som tar förnamn
    förnamn = f;
}
// returnerar uppgifter
public String getFörnamn(){
    return this.förnamn;
}
public String getEfternamn(){
    return this.efternamn;
}
public String getTelefonnummer(){
    return this.telefonnummer;
}

   public void skrivUtFörnamn(){ // metod för att skriva ut förnamn först
       System.out.print(förnamn + " ");
       System.out.print(efternamn + " ");
       System.out.println(telefonnummer);
       
   }
   public void skrivUtEfternamn(){ // metod för att skriva ut efternamn först
       System.out.print(efternamn + " ");
       System.out.print(förnamn + " ");
       System.out.println(telefonnummer);
       
   }
   
}
