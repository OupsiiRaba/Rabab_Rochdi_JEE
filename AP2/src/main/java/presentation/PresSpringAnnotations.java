package presentation;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PresSpringAnnotations {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext("dao", "metier");
        IMetier metier = context.getBean(IMetier.class);
        System.out.println("Le résulat de la version Annotations est :" + metier.Calcul());
    }
}
