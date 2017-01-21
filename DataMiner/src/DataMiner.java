
import java.awt.Dimension;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.swing.JFrame;

import com.tinkerpop.blueprints.util.io.gml.GMLReader;
import edu.uci.ics.jung.algorithms.cluster.EdgeBetweennessClusterer;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.graph.*;
import edu.uci.ics.jung.graph.event.GraphEvent;
import edu.uci.ics.jung.io.GraphIOException;
import edu.uci.ics.jung.io.GraphReader;
import edu.uci.ics.jung.visualization.VisualizationImageServer;
import edu.uci.ics.jung.graph.Graph.*;

/**
 * Created by petar on 17.11.2016..
 */

public class DataMiner{


    public void GMLParser(String filename, HashMap<Integer, Person> listOfPeople, HashMap<Integer, Edge> listOfEdges) throws IOException {

        int edgeid = 0;

        //gml data components

        Integer id;
        String label = "";
        String sex = "";
        Integer agerank;
        Integer wallcount;
        String locale = "";

        Integer source;
        Integer target;

        String[] line = new String[5];


        BufferedReader br = new BufferedReader(new FileReader(filename));
        String sCurrentLine = "";


        while ((sCurrentLine = br.readLine()) != null) {

            //reading persons from gml file

            if (sCurrentLine.equals("\tnode [")) {

                line = br.readLine().split("\\s+"); //id
                id = Integer.parseInt(line[2]);
                line = null;

                line = br.readLine().split("\\s+"); //label
                label = line[2];
                line = null;

                line = br.readLine().split("\\s+"); //sex
                sex = line[2];
                line = null;

                line = br.readLine().split("\\s+"); //agerank
                agerank = Integer.parseInt(line[2]);
                line = null;

                line = br.readLine().split("\\s+"); //wallcount
                wallcount = Integer.parseInt(line[2]);
                line = null;

                line = br.readLine().split("\\s+"); //locale
                locale = line[2];
                line = null;

                //System.out.print(id + " " + label + " " + sex + " " + agerank + " " + wallcount + " " + locale + "\n");

                Person person = new Person(id, label, sex, agerank, wallcount, locale);
                listOfPeople.put(id, person);

                label = null;
                br.readLine(); //]
            }

            //reading edges from gml file
            if (sCurrentLine.equals("\tedge [")) {

                line = br.readLine().split("\\s+"); //id
                source = Integer.parseInt(line[2]);
                line = null;

                line = br.readLine().split("\\s+"); //id
                target = Integer.parseInt(line[2]);
                line = null;

                br.readLine(); //]

                Edge edge = new Edge(source, target);

                listOfEdges.put(edgeid, edge);
                edgeid++;
                //System.out.println(source + " " + target);
            }

        }
        return;
    }


    public void GMLtoPAJEK(HashMap<Integer, Person> listOfPeople, HashMap<Integer, Edge> listOfEdges){

        try{
            PrintWriter writer = new PrintWriter("facebookProfileData.net", "UTF-8");

            writer.println("*Vertices      "+listOfPeople.size());

            for(Person person : listOfPeople.values()) {
                writer.println("    "+person.getId()+"      "+person.getLabel());
            }

            writer.println("*Edges");

            for(Edge edge : listOfEdges.values()) {
               writer.println("    "+edge.getSource()+"      "+edge.getTarget()+"        "+"2");
            }

            writer.close();
        }catch (IOException e){

        }

    }

    public static void main(String[] args) throws IOException {

        DataMiner dataminer = new DataMiner();

        //list of persons and edges
        HashMap<Integer, Person> listOfPeople = new HashMap<>();
        HashMap<Integer, Edge> listOfEdges = new HashMap<>();

        //getting data from a GML file
        dataminer.GMLParser("C:\\Users\\petar\\Desktop\\facebookData.gml", listOfPeople, listOfEdges);


        // GML -> PAJEK

        dataminer.GMLtoPAJEK(listOfPeople, listOfEdges);


        //vizualizacija podataka
         /*
        UndirectedSparseGraph graph = new UndirectedSparseGraph();

        for(Edge edge : listOfEdges.values()) {
            graph.addEdge(edge, edge.getSource(), edge.getTarget());
        }




       VisualizationImageServer vs =
                new VisualizationImageServer(
                        new CircleLayout(graph), new Dimension(1000, 1000));

        JFrame frame = new JFrame();
        frame.getContentPane().add(vs);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);*/

    }

}
