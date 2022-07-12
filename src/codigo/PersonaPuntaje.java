package codigo;

public class PersonaPuntaje {
    public String nombre;
    public int[][] punt;
    
    public PersonaPuntaje(String nombre) {
        this.nombre = nombre;
        punt = new int[2][3];
        for (int i = 0; i < punt.length; ++i) {
            for (int j = 0; j < punt[i].length; ++j) {
                punt[i][j] = -1;
            }
        }
    }
}
