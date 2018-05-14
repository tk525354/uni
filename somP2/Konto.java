
/**
 * Beschreiben Sie hier die Klasse Konto.
 * 
 * @author (Tim Klüter, Frederik Ameling) 
 * @version (0.1V 25.04.2018)
 */
public class Konto
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    String nummer; 
    private float Kontostand, dispolimit;
    private Inhaber kunde;
    
    
    /**
     * Std. Konstruktor
     * Init. Inhaber Objekt
     */
    public Konto()
    {
     kunde = new Inhaber();
    }
    
    /**
     * Konstruktor mit Argument Kontonummer , Inhaberdaten.
     * Setzt Inhaber mit Parametern 
     * Setzt Kontonummer
     */
    public Konto(String neueNummer, String Vorname, String Nachname, String Adresse)
    {
      kunde = new Inhaber(Vorname, Nachname, Adresse);
      nummer = neueNummer;
      
    }
    
    /**
     * Konstruktor mit Argument Inhaber und Kontonummer
     * Konstr. Punkt 1
     */
    public Konto(Inhaber besitzer, String nnummer)
    {
      kunde = besitzer;
      nummer = nnummer;
      
    }
    
    /**
     * Konstruktor mit Argument Inhaber und Kontonummer und init. überweisung
     * Konstr. Punkt 2
     */
    public Konto(Inhaber besitzer, String nnummer, float betrag)
    {
      kunde = besitzer;
      nummer = nnummer;
      Kontostand += betrag;
    }
    
    /**
     * Konstruktor mit Argument EmpfängerKonto für Freundschaftswerbung
     * Konstr. Punkt 3
     */
    public Konto(Inhaber besitzer, Konto empfänger)
    {
      kunde = besitzer;
      if(kunde == empfänger.kunde){
          System.out.println("Error in Konto(Konto empfänger))");
      } else {
      empfänger.einzahlen(60);
      }
    }
    
   
    /**
     * Method setKunde
     *
     * @param Vorname A parameter
     * @param Nachname A parameter
     * @param Adresse A parameter
     */
    public void setKunde(String Vorname , String Nachname, String Adresse)
    {
      kunde.setInhaber(Vorname,Nachname,Adresse);

    }
    
    
     /**
      * Method getInhaber
      *
      * @return The return value
      */
     String getInhaber()
    {
      
      return kunde.getInhaber();
    }
    
    
    /**
     * Method getKontostand
     *
     * @return The return value
     */
    float getKontostand()
    {
     return Kontostand;   
    }

    
    /**
     * Method einzahlen
     *
     * @param Betrag A parameter
     */
    void einzahlen(float Betrag)
    {
      if(Betrag >0)  
      Kontostand += Betrag;
      else{
          System.out.println("Nur positive Werte!");
        }
        
    }
    
    
    /**
     * Method abheben
     *
     * @param Betrag A parameter
     */
    void abheben(float Betrag)
    {
      if(Betrag>0){
          
              if(Betrag >= (Kontostand + dispolimit)){
                  System.out.println("Kontostand nicht ausreichend!");
                }
                else
                {
                    Kontostand -= Betrag;
                    if(Kontostand + dispolimit == 0)
                    System.out.println("Dispo erreicht!");
                }
            }   
            else
            {
                System.out.println("Positive Werte eingeben!");
            }

    }
    
    
    /**
     * Method überweisen
     *
     * @param empfänger A parameter
     * @param Betrag A parameter
     */
    void überweisen (Konto empfänger, float Betrag)
    {
        
        if (Betrag < Kontostand + dispolimit ){
             
            abheben(Betrag);
            empfänger.einzahlen(Betrag);
        }
        else
            System.out.println("Kontostand nicht gedeckt!");
        
    }

    
    /**
     * Method setdispo
     *
     * @param dispo A parameter
     */
    void setDispo(float dispo)
    {
     if(dispo>0)
        dispolimit = dispo;
     else{
         System.out.println("Nur positive Werte!");
        }
    }
    
 
    /**
     * Method getdispo
     *
     * @return The return value
     */
    float getDispo()
    {
        return dispolimit;
    }
}
