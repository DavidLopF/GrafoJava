package org.example.controller;

import com.opencsv.exceptions.CsvValidationException;
import org.example.model.Graph;
import org.example.model.Read;
import org.example.model.dto.EdgeDTO;
import org.example.model.dto.NodesDTO;
import org.example.view.View;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    private Read read;
    private View view;

    private Graph graph;

    Controller() throws CsvValidationException, IOException {
        read = new Read();
        view = new View();

        run();
    }

    private void run() throws CsvValidationException, IOException {
        ArrayList< EdgeDTO> edges = read.readEdges();
        ArrayList<NodesDTO> nodes = read.readNodes();
        graph = new Graph(edges,nodes);
        view.printTitle("Datos Grafo");
        view.printMessage("Cantidad de nodos: " + nodes.size());
        view.printMessage("Cantidad de aristas: " + edges.size());
        view.divider();

        view.printTitle("Matriz de adyasencia");
        view.printMatrix(graph.createGraph());
        view.divider();
        int[] centrality =  graph.graphCentralty();
        if(centrality != null) {
            view.printTitle("Centralidad");
            for (int i = 0; i < centrality.length; i++) {
                view.printMessage("Nodo: " + nodes.get(i).getId() + " Centralidad: " + centrality[i]);
            }
        }
        view.divider();




    }

}
