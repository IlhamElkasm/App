import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Classes {
    public int numClasse;
    public String Nom;
    public  String effectif;

    public Classes() {
        this.Nom = getNom();
        this.numClasse =getNumClasse();
        this.effectif = getEffectif();
    }

    public static void Menuclass() {
        int choix = 0;
        Classes clase = new Classes();
        ArrayList<Classes> listC = new ArrayList<>();
        do {
            System.out.println("**************** Menu ****************");
            System.out.println("1--------Ajouter une nouvelle classe");
            System.out.println("2--------Modifier une classe ");
            System.out.println("3--------Supprimer une classe ");
            System.out.println("4--------Afficher la liste ");
            System.out.println("5--------Filtrer les apprenants par classe");
            System.out.println("   Enter votre choix : ");
            Scanner scanner1 = new Scanner(System.in);
            choix = scanner1.nextInt();
            switch (choix) {
                case 1:
                    //Ajouter
                    clase.AjouterClasse(listC);
                    break;
                case 2:
                    //Modifier
                    clase.ModifierClasses(listC);
                    break;
                case 3:
                    //Supprimer
                    clase.SupprimerClasses(listC);
                    break;
                case 4:
                    //Consulter
                    clase.AfficherClasse(listC);
                    break;
                case 5:
                    //Filter
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choix);
            }
        }while (choix!=6);
    }
    public void AjouterClasse(ArrayList<Classes> Tab){
        Classes clas1 = new Classes();
        Scanner scan=new Scanner(System.in);
        System.out.printf("Nom :");
        clas1.Nom=scan.next();
        System.out.printf("NumClasse :");
        clas1.numClasse=scan.nextInt();
        System.out.printf("Effectif :");
        clas1.effectif=scan.next();
        Tab.add(clas1);
    }
    public  void  AfficherClasse(ArrayList<Classes> Tab) {
        for(Classes A:Tab)
        {
            System.out.println("le Nom est :" + A.Nom);
            System.out.println("le classe est :" + A.numClasse);
            System.out.println("le effectif :" + A.effectif);
            System.out.println("*****************************");
        }
    }
    public void ModifierClasses(ArrayList<Classes> Tab)
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("enter le prenom");
         String nom2 = scan.next();
        for (Classes C:Tab)
        {
            if (nom2.equals(C.getNom()))
            {
                System.out.printf("Nom :");
                C.Nom=scan.next();
                System.out.printf("NumClasse :");
                C.numClasse=scan.nextInt();
                System.out.printf("Effectif :");
                C.effectif=scan.next();
                System.out.println("La classe a été modifiée avec succès.");
                return;
            }
        }
        System.out.println("Le nom de la classe spécifié n'a pas été trouvé.");
    }
    public void SupprimerClasses(ArrayList<Classes> Tab){
        Scanner scan=new Scanner(System.in);
        System.out.println("enter le nom");
        String nom = scan.next();
        for (Classes B:Tab){
            if (nom.equals(B.getNom())){
                Tab.remove(B);
                System.out.println("La classe a été supprimer avec succès.");
                return;
            }
        }
        System.out.println("Le nom de la classe spécifié n'a pas été trouvé.");
    }
    public int getNumClasse() {
        return numClasse;
    }

    public void setNumClasse(int numClasse) {
        this.numClasse = numClasse;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getEffectif() {
        return effectif;
    }

    public void setEffectif(String effectif) {
        this.effectif = effectif;
    }
}
