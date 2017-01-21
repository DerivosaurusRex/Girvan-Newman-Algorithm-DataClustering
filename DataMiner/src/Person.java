import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.event.GraphEvent;

/**
 * Created by petar on 17.11.2016..
 */
public class Person {
    Integer id;
    String label = "";
    String sex = "";
    Integer agerank;
    Integer wallcount;
    String locale;

    public Person(Integer id, String label, String sex, int agerank, int wallcount, String locale) {
        this.id = id;
        this.label = label;
        this.sex = sex;
        this.agerank = agerank;
        this.wallcount = wallcount;
        this.locale = locale;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public String getSex() {
        return sex;
    }

    public int getAgerank() {
        return agerank;
    }

    public int getWallcount() {
        return wallcount;
    }

    public String getLocale() {
        return locale;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAgerank(int agerank) {
        this.agerank = agerank;
    }

    public void setWallcount(int wallcount) {
        this.wallcount = wallcount;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", sex='" + sex + '\'' +
                ", agerank=" + agerank +
                ", wallcount=" + wallcount +
                ", locale='" + locale + '\'' +
                '}';
    }
}
