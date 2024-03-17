import java.util.HashMap;

public class Lenguaje {
    char[] noTerminales = {'X', 'Y', 'Z', 'W'};
    char [] terminales = {'1' , '2', '3'};
    char inicial;
    //Nodo raiz;
   
    HashMap<Character, String[]> tr = new HashMap<>();
   
    public Lenguaje() {
       
        tr.put('X', new String[] {"YZ1", "W2W3", "2"});
        tr.put('Y', new String[]{"Z1Z2Z3", "YW1", "1"});
        tr.put('Z', new String[] {"W", "YZ", "3"});
        tr.put('W', new String[]{"2", "YZ", "1"});
        inicial = 'X';
    }
   
    public boolean esNoTerminal(char letra){
        boolean esNT = false;
        for(Character elemento : noTerminales){
            if(elemento == letra){
                esNT = true;
            }
        }
        return esNT;
    }
   
    public boolean esTerminal(char letra){
        boolean esT = false;
        for(Character elemento : terminales){
            if(elemento == letra){
                esT = true;
            }
        }
        return esT;
    }
    /*public Nodo construirArbol() {
        Nodo raiz = new Nodo();
        raiz.setDato(inicial);
        return raiz;
    }*/
     
    public void traslate(){
       
        String[] reglas1 = tr.get(inicial);
       
    }
   
     public static void main(String[] args) {
        Lenguaje lenguaje = new Lenguaje();
        lenguaje.traslate(); // Llamar al método traslate() para que se ejecute
    }
   
}