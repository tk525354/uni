
/**
 * Beschreiben Sie hier die Klasse inhaber.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class inhaber
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private String Vorname, Nachname, Adresse, sInhaber;
    private int knummer;
    
    /**
     * Konstruktor für Objekte der Klasse inhaber
     */
    public inhaber()
    {
        // Instanzvariable initialisieren
     
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public void setInhaber(String nVorname,String nNachname,String nAdresse){
        Vorname = nVorname;
        Nachname = nNachname;
        Adresse = nAdresse;
    }
        
    public String getInhaber(){
        
       sInhaber = Vorname + ", " + Nachname + ", " + Adresse;
       return sInhaber;
        
    }
    

}
