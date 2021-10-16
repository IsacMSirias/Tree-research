package Tree;

import java.util.ArrayList;
public class NaryNode{

    int cantidadH;
    String dato;
    ArrayList <NaryNode> hijos;

    public NaryNode(String dato){
        hijos = new ArrayList<NaryNode>();
        this.dato = dato;
    }

    public void AumentarHijo (NaryNode nodo){
        hijos.add(nodo);
        cantidadH =hijos.size();
    }

    public void ActualizarNodosHijos(){
        cantidadH = hijos.size();
    }

    public void verInfo(){
        System.out.println("{ "+dato+" }");
    }

    public void Verhijos(){
        System.out.println(cantidadH);
    }

    public void setDato(String dato){
        this.dato = dato;
    }

    public String getDato(){
        return dato;
    }

    public int getHijos(){
        return cantidadH;
    }

    public void RestarHijos(){
        cantidadH--;
    }

    public NaryNode retornarNodo(){
        return this;
    }

}