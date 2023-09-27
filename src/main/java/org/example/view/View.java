package org.example.view;

public class View {

    public void printTitle(String title){
        System.out.println( "================== " + title + " ==================");
    }

    public void printMessage(String message){
        System.out.println( message );
    }

    public void divider(){
        System.out.println("===============================================");
    }

    public void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println("\n");
        }
    }
}

