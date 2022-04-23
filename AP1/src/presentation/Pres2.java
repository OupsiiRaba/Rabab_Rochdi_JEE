package presentation;

import dao.IDao;
import metier.IMetier;
import metier.IMetierImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Pres2 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("C:/Users/rabab/IdeaProjects/JEE/src/config.txt"));
        String daoClassName = scanner.nextLine();
        Class cDao = Class.forName(daoClassName);

        IDao o = (IDao) cDao.newInstance();


        //pour changer la version il suffit juste de revenir vers le ficher de cofiguration

        //verdsion 2
        String metierClassName = scanner.nextLine();
        Class cMetier = Class.forName(metierClassName);
        IMetier metier = (IMetier) cMetier.newInstance();
        Method method = cMetier.getMethod("setiDao", IDao.class);

        method.invoke(metier, o);
        System.out.println("Résultat ==>" + metier.Calcul());

    }
}
