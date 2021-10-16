package Tree;

public class NaryTree {

    NaryNode raiz;

    public NaryTree(){}

    public NaryNode insertroot(String dato){

        raiz = new NaryNode(dato);
        return raiz;

    }

    public void Insert (NaryNode nodo, String dato, String Padre){
        NaryNode nuevo = new NaryNode(dato);

        //Si el padre es la raiz
        if(nodo.getDato().equals(Padre)){
            nodo.AumentarHijo(nuevo);
        }else{
            //Busca entre los hijos que tiene el padre
            for(int i = 0; i<nodo.getHijos(); i++){
                if(nodo.hijos.get(i).getDato().equals(Padre)){

                    //Se coloca el hijo en el nodo
                    nodo.hijos.get(i).AumentarHijo(nuevo);
                }else{
                    Insert(nodo.hijos.get(i), dato, Padre);
                }
            }
        }
    }

    public void recorreer(NaryNode raiz){
        raiz.verInfo();
        for(int i = 0; i < raiz.getHijos(); i++){
            recorreer(raiz.hijos.get(i));
        }
    }

    public void recorreerHijosRaiz(NaryNode raiz){
        for(int i = 0; i < raiz.getHijos(); i++){
            recorreerHijosRaiz(raiz.hijos.get(i));
        }
        raiz.verInfo();
    }


    public boolean Buscar(NaryNode raiz, String buscar, boolean Encontrado){
        if(raiz.getDato().equals(buscar)){
            Encontrado = true;
        }
        for (int i = 0; i < raiz.getHijos(); i++){
            Encontrado = Buscar(raiz.hijos.get(i), buscar, Encontrado);
        }
        return Encontrado;

    }

    public int cantidadNodos(NaryNode raiz){
        int mayor= 0;
        if(raiz == null){
            return 0;
        }else{
            for(int i  = 0; i < raiz.getHijos(); i++){
                mayor += cantidadNodos(raiz.hijos.get(i));
            }
            return mayor+1;
        }
    }

    public int altura (NaryNode raiz){
        int mayor = 0,  tempo = 0;
        if(raiz == null){
            return 0;
        }else{

            for(int i = 0; i < raiz.getHijos(); i++){
                tempo = altura(raiz.hijos.get(i));
                if(tempo > mayor){
                    mayor = tempo;
                }
            }
            return mayor+1;
        }
    }

    public int altura2 (NaryNode raiz){
        int nivel = 0;
        if(raiz == null){
            return 0;
        }else{

            for(int i = 0; i < raiz.getHijos(); i++){
                nivel+= altura2(raiz.hijos.get(i));
                if(i == 0){
                    nivel ++;
                }
            }
            return nivel;
        }
    }

    public int altura3 (NaryNode raiz, int nivel){

        if(raiz == null){
            return 0;
        }else{
            for (int i = 0; i < raiz.getHijos(); i++){
                nivel = altura3(raiz.hijos.get(i), nivel);
                if(i == 0)
                    nivel++;

            }
            return nivel;
        }
    }

    //retorna el numero de hijos sin hojas
    public int numeroHojas(NaryNode raiz){

        int acum = 0;
        if (raiz.getHijos() == 0){
            return 1;
        }else{
            for(int i = 0; i< raiz.getHijos(); i++){
                acum += numeroHojas(raiz.hijos.get(i));
            }
            return acum;
        }

    }

    //Toma el nivel del elemento 0 hasta el elemento n-1
    public int nivelElemento(NaryNode raiz, String elemento, int nivel){
        int tempo = 0;
        if(raiz == null){
            return -1;
        }else if(raiz.getDato().equals(elemento)) {
            return nivel;
        }else{
            //se buscan los hijos
            for(int i= 0;i<raiz.getHijos(); i++){
                tempo = nivelElemento(raiz.hijos.get(i), elemento, nivel+1);
                if(tempo != 1){
                    return tempo;
                }
            }
            return -1;
        }
    }

    public void BorrarNodo(NaryNode raiz, String borrar, boolean rama){
        for(int i = 0; i < raiz.getHijos(); i++){
            if(raiz.hijos.get(i).getDato().equals(borrar) && raiz.hijos.get(i).getHijos() != 0  && rama){
                raiz.hijos.remove(i);
                raiz.ActualizarNodosHijos();
                break;
            }else if(raiz.hijos.get(i).getDato().equals(borrar) && raiz.hijos.get(i).getHijos() == 0){
                //Si ve que no tiene nodos asociados si no tienen hijos el nodo
                raiz.hijos.remove(i);
                raiz.ActualizarNodosHijos();
                break;
            }
            BorrarNodo(raiz.hijos.get(i), borrar, rama);
        }
    }

}