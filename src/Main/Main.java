package Main;

import Tree.NaryNode;
import Tree.NaryTree;

class Mian{

    public static void main(String[] args) {
        NaryTree objTree = new NaryTree();
        NaryNode raiz = objTree.insertroot("0");

        objTree.Insert(raiz, "1", "0");
        objTree.Insert(raiz, "2", "0");
        objTree.Insert(raiz, "3", "0");
        objTree.Insert(raiz, "4", "0");

        objTree.Insert(raiz, "1.1", "1");
        objTree.Insert(raiz, "2.1", "2");
        objTree.Insert(raiz, "3.1", "3");

        objTree.Insert(raiz, "3.1.1", "3.1");
        objTree.Insert(raiz, "3.1.1.4", "3.1.1");
        objTree.Insert(raiz, "1.1.1", "1.1");
        objTree.Insert(raiz, "1.1.1.2", "1.1.1");

        objTree.recorreer(raiz);
        System.out.println("Buscar  " + objTree.Buscar(raiz, "2", false));
        System.out.println("Altura  " + objTree.altura(raiz));
        System.out.println("Altura2  " + objTree.altura2(raiz));
        System.out.println("Altura3  " + objTree.altura3(raiz, 0));

        System.out.println("hojas  " + objTree.numeroHojas(raiz));
        System.out.println("Nivel de elemento  " + objTree.nivelElemento(raiz, "1", 0));
        System.out.println("Nivel de elemento  " + objTree.nivelElemento(raiz, "1.1", 0));
        System.out.println("Nivel de elemento  " + objTree.nivelElemento(raiz, "1.1.1", 0));
        System.out.println("Nivel de elemento  " + objTree.nivelElemento(raiz, "1.1.1.2", 0));


    }

}