package guest;
 
import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
 
@Entity
public class Guest implements Serializable {
    private static final long serialVersionUID = 1L;
 
    // Persistent Fields:
    @Id @GeneratedValue
    Long id;
    private String name;
    private String roomno;
    private String signingDate;
    
 
    // Constructors:
    public Guest() {
    }

    Guest(String name, String roomno) {
        this.name = name;
        this.roomno = roomno;
        this.signingDate = new SimpleDateFormat("dd'-'MM'-'yyyy' at ' HH':'mm':'ss a").format(Calendar.getInstance().getTime());
        
    }
 
    // String Representation:
    @Override
    public String toString() {
        return name + " (Room Number " + roomno + " ) (signed in on " + signingDate + ") ";
    }
}