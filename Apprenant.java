import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Apprenant {
    private String Nom;
    private String Prenom;
    private Calendar DateNais;
    private String Adresse;
    private int  Numtelephone;
    private int Numclasse;
    String nom2;

    Scanner scan=new Scanner(System.in);
    //constructor
    public Apprenant() {
        this.Nom = getNom();
        this.Prenom = getPrenom();
        this.DateNais=getDateNais();
        this.Adresse = getAdresse();
        this.Numtelephone= getNumtelephone();
        this.Numclasse = getNumclasse();

    }

    public static void menuApprenanet() {
        int choix;
        Apprenant app = new Apprenant();
        ArrayList<Apprenant> list = new ArrayList<>();
        do {
            System.out.println("**************** Menu ****************");
            System.out.println("1--------Ajouter un nouvel apprenant");
            System.out.println("2--------Modifier les informations ");
            System.out.println("3--------Supprimer un apprenant ");
            System.out.println("4--------Consulter la liste ");
            System.out.println("5--------Rechercher un apprenant ");
            System.out.println("   Enter votre choix : ");
            Scanner scanner1 = new Scanner(System.in);
            choix = scanner1.nextInt();
            switch (choix) {
                case 1:
                    //Ajouter
                    app.AjouterApprent(list);
                    break;
                case 2:
                    //Modifier
                    app.Modifier(list);
                    break;
                case 3:
                    //Supprimer
                    app.Supprimer(list);
                    break;
                case 4:
                    //Consulter
                    app.Afficher(list);
                    break;
                case 5:
                    //Rechercher
                    app.Rechercher(list);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choix);
            }
        }while (choix!=6);
    }
    public void AjouterApprent(ArrayList<Apprenant> Tab){
        int jour, mois,annee;
        Apprenant app1 = new Apprenant();
        System.out.printf("Nom :");
        app1.Nom=scan.next();
        System.out.printf("Prenom :");
        app1.Prenom = scan.next();
        System.out.printf("le jour est");
        jour = scan.nextInt();
        System.out.printf("le mois est");
        mois = scan.nextInt();
        System.out.printf("le annee est");
        annee = scan.nextInt();
        app1.DateNais = Calendar.getInstance();
        app1.DateNais.set(annee, mois - 1, jour);
        System.out.printf("Adresse :");
        app1.Adresse=scan.next();
        System.out.printf("Tel :");
        app1.Numtelephone=scan.nextInt();
        System.out.printf("NumClasse :");
        app1.Numclasse=scan.nextInt();
        app1.DateNais.set(annee,mois,jour);
        Tab.add(app1);
        System.out.println("Lapprenant a été ajouter  avec succès.");
    }
    public  void  Afficher(ArrayList<Apprenant> Tab) {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEEE dd/MM/YYYY");
        for(Apprenant A:Tab)
        {
            System.out.println("le Nom est :" + A.Nom);
            System.out.println("le pre est :" + A.Prenom);
            System.out.println("la date est :" +sdf.format(A.DateNais.getTime()));
            System.out.println("le Add est :" + A.Adresse);
            System.out.println("le tel est :" + A.Numtelephone);
            System.out.println("le classe est :" + A.Numclasse);
            System.out.println("*****************************");
        }
    }

    //qui afficher un seul list sur recharcher
    public  void  AfficherunAppre(Apprenant A) {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEEE dd/MM/YYYY");
        System.out.println("le Nom est :" + A.Nom);
        System.out.println("le pre est :" + A.Prenom);
        System.out.println("la date est :" + sdf.format(A.DateNais.getTime()));
        System.out.println("le Add est :" + A.Adresse);
        System.out.println("le tel est :" + A.Numtelephone);
        System.out.println("le classe est :" + A.Numclasse);

    }
    public void Modifier(ArrayList<Apprenant> Tab)
    {
        String prenom2 ;
        System.out.println("enter le prenom");
        prenom2 = scan.next();
        for (Apprenant C:Tab)
        {
            if (prenom2.equals(C.getPrenom()))
            {
                int jour, mois,annee;
                System.out.printf("Nom :");
                C.Nom=scan.next();
                System.out.printf("Prenom :");
                C.Prenom = scan.next();
                System.out.printf("le jour est");
                jour = scan.nextInt();
                System.out.printf("le mois est");
                mois = scan.nextInt();
                System.out.printf("le annee est");
                annee = scan.nextInt();
                C.DateNais = Calendar.getInstance();
                C.DateNais.set(annee, mois - 1, jour);
                System.out.printf("Adresse :");
                C.Adresse=scan.next();
                System.out.printf("Tel :");
                C.Numtelephone=scan.nextInt();
                System.out.printf("NumClasse :");
                C.Numclasse=scan.nextInt();
                System.out.println("Lapprenant a été modifiée avec succès.");
                return;
            }
        }
        System.out.println("Le Prenom de lapprenant spécifié n'a pas été trouvé.");
    }
    public void Supprimer(ArrayList<Apprenant> Tab){
        System.out.println("enter le nom");
        nom2 = scan.next();
        for (Apprenant B :Tab){
            if (nom2.equals(B.getNom())) {
                Tab.remove(B);
                System.out.println("lapprenant a ete  supprimer avec succes");
                return;
            }
        }
        System.out.println("Le nom de lapprenant spécifié n'a pas été trouvé.");
    }

    public void Rechercher(ArrayList<Apprenant> Tab)
    {
        System.out.println("enter le nom");
        nom2 = scan.next();
        for (Apprenant appr :Tab) {
            if (nom2.equals(appr.getNom())) {
                appr.AfficherunAppre(appr);
            }
        }
    }
    public String getNom() {
        return Nom;
    }
    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }
    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public Calendar getDateNais() {
        return DateNais;
    }

    public void setDateNais(Calendar dateNais) {
        DateNais = dateNais;
    }

    public String getAdresse() {
        return Adresse;
    }
    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public int getNumtelephone() {
        return Numtelephone;
    }

    public void setNumtelephone(int numtelephone) {
        Numtelephone = numtelephone;
    }

    public int getNumclasse() {
        return Numclasse;
    }
    public void setNumclasse(int numclasse) {
        Numclasse = numclasse;
    }

}