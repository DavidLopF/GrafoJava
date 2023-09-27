package org.example.model;

import org.example.model.dto.EdgeDTO;
import org.example.model.dto.NodesDTO;

import java.util.ArrayList;
import java.util.List;


public class Graph {

    private ArrayList<EdgeDTO> edges;
    private ArrayList<NodesDTO> nodes;

    private int[][] matrix;

    public Graph(ArrayList<EdgeDTO> edges, ArrayList<NodesDTO> nodes) {
        this.edges = edges;
        this.nodes = nodes;
        this.matrix = new int[nodes.size()][nodes.size()];
        //llena la matrix de 0
        for (int i = 0; i < nodes.size(); i++) {
            for (int j = 0; j < nodes.size(); j++) {
                matrix[i][j] = 0;
            }
        }
    }
    public int[][] createGraph() {
        for (int i = 0; i < nodes.size(); i++) {
            for (int j = 0; j < nodes.size(); j++) {
                if(nodes.get(i).getId().equals(edges.get(j).getSource())){
                    //en la variable target se encuentra el id del nodo destino,pero hay que buscar su posicion en el arraylist de nodos
                    int target = findNodeById(edges.get(j));
                    matrix[i][target] = 1;
                }
            }
        }
        return matrix;
    }

    public int[] graphCentralty(){
        try{
            int[] centralty = new int[nodes.size()];
            for (int i = 0; i < nodes.size(); i++) {
                for (int j = 0; j < nodes.size(); j++) {
                    centralty[i] += this.matrix[i][j];
                }
            }
            return centralty;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public int findNodeById(EdgeDTO edge){
        int result = 0;
        for (int i = 0; i < nodes.size(); i++) {
            if(nodes.get(i).getId().equals(edge.getTarget())){
                result = i;
            }
        }
        return result;
    }
}
