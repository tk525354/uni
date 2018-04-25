
/**
 * Beschreiben Sie hier die Klasse konto.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class konto
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    int nummer, Betrag, Kontostand;
    public inhaber Kunde;

    /**
     * Konstruktor für Objekte der Klasse konto
     */
    public konto(int neueNummer)
    {
     nummer = neueNummer;
     Kunde = new inhaber();
    }
    
    public konto(String Kunde, int nummer)
    {
        
    }
    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public void setKunde(String Vorname , String Nachname, String Adresse)
    {
      Kunde.setInhaber(Vorname,Nachname,Adresse);

    }
    
     String getInhaber()
    {
      
      return Kunde.getInhaber();
    }
    
    int getKontostand()
    {
     return Kontostand;   
    }

    void einzahlen(int Betrag)
    {
      Kontostand += Betrag;
        
    }
    
    void abheben(int Betrag)
    {
      if(Betrag>=Kontostand){
        System.out.println("Kontostand nicht ausreichend!");
        }
        else
            Kontostand -= Betrag;
        
    }
    
    void überweisen (konto empfänger, int Betrag)
    {
        if (Betrag >= 0){
            abheben(Betrag);
            empfänger.einzahlen(Betrag);
        }
        else
            System.out.println("ERROR");
        
    }

}
