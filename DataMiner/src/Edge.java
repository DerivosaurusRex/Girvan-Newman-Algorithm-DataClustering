/**
 * Created by petar on 21.11.2016..
 */
public class Edge {

    Integer source;
    Integer target;

    public Edge(Integer source, Integer target) {
        this.source = source;
        this.target = target;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "source=" + source +
                ", target=" + target +
                '}';
    }
}
