package presentation;

import dao.DaoImpl;
import ext.DaoImpl2;
import metier.IMetierImpl;

public class Presentation {
    public static void main(String[] args) {
        //injection des depedances par instanciation statique
        //==> new

        //se pose toijours u probleme que l app est toujours ouverte a la modificatio
        DaoImpl dao = new DaoImpl();
        //injection via constructeur
        IMetierImpl metier = new IMetierImpl(dao);
        //metier.setiDao(dao);
        System.out.println("Resultat ==> " + metier.Calcul());
    }
}

