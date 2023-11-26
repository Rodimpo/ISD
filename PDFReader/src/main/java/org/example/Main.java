package org.example;

public class Main {
    public static Object[][] table = new String[12][10];
    public static Object[][] table_Eukl = new String[12][12];

    public static void main(String[] args) {
        //Tworzenie dokumentów
        PDF[] D = new PDF[12];
        for(int i=0;i<12;i++){
            D[i] = new PDF("../pdf/D"+i+".pdf");
        }
        //Tworzenie macierzy
        for(int i=0;i<12;i++){
            for(int j=0;j<10;j++){
                table[i][j] = Integer.toString(D[i].termCount[j]);
            }
        }
        //Euklides

        for(int i=0;i<12;i++){

            for(int j=0;j<12;j++){
                double zmienna=0;
                for(int k=0;k<10;k++){
                    zmienna += (D[i].termCount[k]-D[j].termCount[k])*(D[i].termCount[k]-D[j].termCount[k]);
                    table_Eukl[i][j] = Double.toString(Math.sqrt(zmienna));
                }
            }
        }


        wyswietl_macierz();
        odl_eukl();
    }

    private static void wyswietl_macierz() {
        System.out.println("Macierz TDM");
        for(int i=0;i<10;i++){
            System.out.print("      T" + i+"        ");
        }
        System.out.println("");
        int i=0;
        for (Object[] row : table) {
            System.out.print("D"+i);
            System.out.format("%15s%15s%15s%15s%15s%15s%15s%15s%15s%15s%n", row);
            i++;
        }
    }
    public static void odl_eukl() {
        System.out.println("Odległości euklidesowe");
        for (Object[] row : table_Eukl) {
            System.out.format("%20s%20s%20s%20s%20s%20s%20s%20s%20s%20s%20s%20s%n", row);
        }
    }


}
