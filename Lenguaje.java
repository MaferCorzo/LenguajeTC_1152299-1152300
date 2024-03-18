import java.util.*;


public class Lenguaje {
    char[] noTerminales = {'X', 'Y', 'Z', 'W'};
    char [] terminales = {'1' , '2', '3'};
    char inicial;
    char visitado;
    //Nodo raiz;
   
    HashMap<Character, String[]> tr = new HashMap<>();
   
    public Lenguaje() {
       
        tr.put('X', new String[] {"YZ1", "W2W3", "2"});
        tr.put('Y', new String[]{"Z1Z2Z3", "YW1", "1"});
        tr.put('Z', new String[] {"W", "Y2", "3"});
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

    public void producciones(char noTerminales, Set<Character> visitado, List<String> terminales){
        if(visitado.contains(noTerminales)){
            return;
        }
        visitado.add(noTerminales);

        String [] reglas= tr.getOrDefault(noTerminales, new String[0]);

        for(String regla: reglas){
            StringBuilder terminal= new StringBuilder();
            String[] simbolos= regla.split("");
            for(String simbolo: simbolos){
                if(!simbolo.isEmpty()){
                    char caracter= simbolo.charAt(0);
                    if(esNoTerminal(caracter)){
                    producciones(caracter, visitado, terminales);
                    } else if(esTerminal(caracter)){
                        terminal.append(caracter);

                    }
                }
            }
            if(terminal.length()>0){
            terminales.add(terminal.toString());
            }

        }
    }
    
    /*public Nodo construirArbol() {
        Nodo raiz = new Nodo();
        raiz.setDato(inicial);
        return raiz;
    }*/
     
    public void traslate(){
       
        Set<Character> visitado = new HashSet<>();
        List<String> terminales= new ArrayList<>();
        producciones(inicial, visitado, terminales);

        System.out.println("Lenguaje{" + String.join(", ", terminales) + "}");

       
    }
   
}