package org.example.model;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.example.model.dto.EdgeDTO;
import org.example.model.dto.NodesDTO;

import javax.sound.sampled.Line;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Read {

    private String edgesPath;
    private String nodesPath;
    private CSVReader csvReader ;

    public Read() {
        this.nodesPath = "src/main/resources/Nodes_GOT.csv";
        this.edgesPath = "src/main/resources/Edges_GOT.csv";
    }

    public ArrayList<EdgeDTO> readEdges() throws CsvValidationException, IOException {
        try{
            csvReader = new CSVReader(new FileReader(edgesPath));
        }catch (Exception e){
            System.out.println("Error: " + e);
        }

        String[] line;
        ArrayList<EdgeDTO> edgeDTOS = new ArrayList<>();
        while ((line = csvReader.readNext()) != null) {
            if(line[0].equals("Source")){
                continue;
            }

            edgeDTOS.add(new EdgeDTO(line[0],line[1],line[2]));

        }
        return edgeDTOS;
    }

    public ArrayList<NodesDTO> readNodes() throws CsvValidationException, IOException {
        try{
            csvReader = new CSVReader(new FileReader(nodesPath));
        }catch (Exception e){
            System.out.println("Error: " + e);
        }
        String[] line;
        ArrayList<NodesDTO> nodes = new ArrayList<>();
        while ((line = csvReader.readNext()) != null) {
            try{
                Integer.parseInt(line[2]);
                Double.parseDouble(line[4]);
            }catch (Exception e){
                if(line[2] == null){
                    line[2] = "0";
                }
                if(line[4] == null){
                    line[4] = "0";
                }
            }



            if(line[0].equals("Id")){
                continue;
            }
            nodes.add(new NodesDTO(line[0],Integer.parseInt(line[1]),line[2],line[3],Double.parseDouble(line[4])));
        }
        return nodes;
    }


}
