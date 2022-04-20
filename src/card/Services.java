package card;

import java.time.LocalDateTime;

/**
 * Singleton Class to get the DeckID in case the ID will be provided by Webservice and not locally
 */
public class Services {
    
    private static Services instance = null;
    
    private Services() {
        super();
    }
    
    public static Services getSingleton(){
        instance = instance == null ? new Services(): instance;
        return instance;
    }
    
    public String getDeckID(){
        LocalDateTime now = LocalDateTime.now();  
        StringBuffer sb = new StringBuffer();
        sb.append(now.getYear());
        sb.append(now.getMonthValue());
        sb.append(now.getDayOfMonth());
        sb.append(now.getHour());
        sb.append(now.getMinute());
        sb.append(now.getSecond());
        return sb.toString();
    }
}
