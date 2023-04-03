
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BussBokning {

    Scanner scan = new Scanner(System.in);

    static String[] PLATSERNAMN = new String[21];
    static String[] PLATSERKÖN = new String[21];
    static int[] PLATSERNUM = new int[21];
    static int[] BOKADPLATS = new int[21];
    int val;
    String kön;
    String personnummer;
    Boolean fullt = false;
    Boolean finns = false;
    String namnFör;
    String namnEft;
    int valueV;
    int valueB;
    int valueP;
    int sub;
    String SubString;
    int index;
    String check;
    int[] SORTERADNUM = new int[21];
    String[] SORTERADNAMN = new String[21];
    int[] SORTERADPLATS = new int[21];


    BussBokning() {

        Arrays.fill(PLATSERNAMN, "null");
        Arrays.fill(PLATSERKÖN, "null");
        Arrays.fill(BOKADPLATS, -1);

        System.out.println("Välkommen till bokningsprogrammmet, ange nummret för vad du vill göra");

        do {
            System.out.println("1. Boka en plats"); //om en plats%4 = 3 elr 0 (förutom 20) och plats 21 är platsen en fönsterplats
            System.out.println("2. Avboka en plats");
            System.out.println("3. Se min bokning");
            System.out.println("4. Se lediga platser");
            System.out.println("5. Räkna ut vinst");  //300 vuxen, 150 barn, 200 pensionär 69 upp
            System.out.println("6. Skriv ut åldrar"); //äldst först yngst sist, innehålla alla uppgifter
            System.out.println("7. Exit");
            System.out.print("> ");
            val = scan.nextInt();
            check = String.valueOf(val);

            if(check.matches("[0-9]+")) {
                switch (val) {
                    case 1 -> Bokning();
                    case 2 -> AvBokning();
                    case 3 -> SeBokning();
                    case 4 -> SkrivLediga();
                    case 5 -> BeräknaVinst();
                    case 6 -> SkrivÅldrar();
                    case 7 -> {}
                    default -> System.out.println("Fel input, skriv ett nummer mellan 1-7");
                }
            }else {
                System.out.println("Skriv endast in ett nummer mellan 1-7");
            }


        } while (val != 7);
    }


    public void Bokning() {                        //metod för bokning

        fullt = true;

        System.out.println("Vill du ha en fönsterplats eller inte?");
        System.out.println("1. Fönsterplats");
        System.out.println("2. Inte");
        System.out.print("> ");
        val = scan.nextInt();
        check = String.valueOf(val);

        if(check.matches("[0-9]+")){
            switch (val){
                case 1 -> {
                    for(int i = 0; i < PLATSERNUM.length; i++){
                        if (i%4 == 3 || i%4 == 0 || i == 21) if(PLATSERNUM[i] == 0 && i != 20){
                            System.out.println("Plats "+(i+1)+" är ledig");
                            fullt = false;
                            index = i;
                            break;

                        }
                    }

                    if(fullt){
                        System.out.println("Det finns inga fönsterplatser kvar, kolla gärna om det finns andra vanliga kvar");
                    }

                }
                case 2 -> {
                    for(int i = 0; i < PLATSERNUM.length; i++){
                        if (i%4 == 2 || i%4 == 1 || i == 20) if (PLATSERNUM[i] == 0) {
                            System.out.println("Plats " + (i + 1) + " är ledig");
                            fullt = false;
                            index = i;
                            break;
                        }
                    }
                    if(fullt){
                        System.out.println("Det finns inga vanliga platser kvar, kolla gärna om det finns andra fönsterplatser kvar");
                    }
                }
                default -> System.out.println("Fel input");
            }
        } else {
            System.out.println("Skriv bara in ett nummer mellan 1-7");
        }



            if (!fullt) {

                System.out.print("Ange förnamn: ");
                namnFör = scan.next();

                System.out.print("Ange efternamn: ");
                namnEft = scan.next();

                System.out.println("Ange kön: ");
                System.out.println("1. Man");
                System.out.println("2. Kvinnna");
                System.out.println("3. Annnat");
                System.out.println("4. Vill ej uppge");
                System.out.print("> ");
                int könval = scan.nextInt();

                do {
                    switch (könval) {
                        case 1 -> kön = "Man";
                        case 2 -> kön = "Kvinna";
                        case 3 -> kön = "Annat";
                        case 4 -> kön = "Vill ej uppge";
                        default -> {
                            System.out.println("Fel input");
                            kön = null;
                            System.out.println("Ange ett tal mellan 1-4");
                            System.out.print("> ");
                            könval = scan.nextInt();
                        }
                    }
                } while (kön == null);

                System.out.println("Ange personnummer, ååååmmdd: ");
                System.out.print("> ");
                personnummer = scan.next();

                if (personnummer.matches("[0-9-]+") && personnummer.length() == 8) { //kollar om värdet för personnumret är rätt

                    for (int i = 0; PLATSERNUM.length > i; i++){

                        if (PLATSERNUM[i] == Integer.parseInt(personnummer) || PLATSERNAMN[i].equalsIgnoreCase(namnFör + namnEft)) {
                        System.out.println("Det finnns redan en bokning för dem här uppgifterna");
                        fullt = true;
                        }
                    }

                    if (!fullt) {
                        PLATSERNUM[index] = Integer.parseInt(personnummer);
                        PLATSERKÖN[index] = kön;
                        PLATSERNAMN[index] = namnFör + namnEft;
                        BOKADPLATS[index] = index;
                        System.out.println("Bokningen lyckades");
                        System.out.println("Plats \"" + (index + 1) + "\" är din");
                    }

                } else {
                    System.out.println("Skriv bara nummer och i formatet ååååmmdd");
                }
            }
    }

    public void AvBokning() {             //metod för avbokning

        finns = false;

        System.out.println("Vill du avboka med namn eller personnummer?");
        System.out.println("1. Personummer");
        System.out.println("2. Namn");
        System.out.print("> ");
        val = scan.nextInt();
        check = String.valueOf(val);

        if(check.matches("[0-9]+")){
            switch (val) {
                case 1 -> {
                    System.out.println("Ange personummer, ååååmmdd: ");
                    System.out.print("> ");
                    personnummer = scan.next();

                    if (personnummer.matches("[0-9]+") && personnummer.length() == 8){
                        for (int j = 0; j < PLATSERNUM.length; j++) {
                            if (PLATSERNUM[j] == Integer.parseInt(personnummer)) {
                                System.out.println("Plats \"" + (j + 1) + "\" är nu avbokad");
                                PLATSERNAMN[j] = "null";
                                PLATSERKÖN[j] = "null";
                                PLATSERNUM[j] = 0;
                                BOKADPLATS[j] = -1;
                                finns = true;
                                break;
                            }
                        }
                        if (!finns) {
                            System.out.println("Det finnns ingen befintlig bokning för dem här uppgifterna");
                        }
                    } else {
                        System.out.println("Skriv bara nummer och i formatet ååååmmdd");
                    }
                }
                case 2 -> {
                    System.out.println("Ange förnamn ");
                    System.out.print("> ");
                    namnFör = scan.next();

                    System.out.println("Ange efternamn ");
                    System.out.print("> ");
                    namnEft = scan.next();

                    for (int i = 0; i < PLATSERNAMN.length; i++) {
                        if (PLATSERNAMN[i].equalsIgnoreCase(namnFör + namnEft)) {
                            System.out.println("Plats \"" + (i + 1) + "\" är nu avbokad");
                            finns = true;
                            PLATSERNAMN[i] = "null";
                            PLATSERKÖN[i] = "null";
                            PLATSERNUM[i] = 0;
                            BOKADPLATS[i] = -1;
                            break;
                        }
                    }
                    if (!finns) {
                        System.out.println("Det finnns ingen befintlig bokning för dem här uppgifterna, kolla så du skrev rätt");
                    }
                }
            }
        } else {
            System.out.println("Skriv bara in ett nummer mellan 1-7");
        }
    }

    public void SeBokning() {
        finns = false;

        System.out.println("Vill du checka för namn eller personnummer?");
        System.out.println("1. Personummer ");
        System.out.println("2. Namn");
        System.out.print("> ");
        val = scan.nextInt();
        check = String.valueOf(val);

        if (check.matches("[0-9]+")){
            switch (val) {
                case 1 -> {
                    System.out.println("Ange personnummer för bokningen");
                    personnummer = scan.next();

                    if (personnummer.matches("[0-9]+") && personnummer.length() == 8){

                        for (int j = 0; j < PLATSERNUM.length; j++) {
                            if (PLATSERNUM[j] == Integer.parseInt(personnummer)) {
                                System.out.println("Du har plats \"" + (j + 1) + "\"");
                                finns = true;
                                break;
                            }
                        }
                        if (!finns) {
                            System.out.println("Det finns ingen bokning för dem hör uppgifterna");
                        }
                    } else {
                        System.out.println("Skriv bara nummer och i formatet ååååmmdd");
                    }

                }
                case 2 -> {
                    System.out.println("Ange förnamn för bokningen");
                    System.out.print("> ");
                    namnFör = scan.next();
                    System.out.println("Ange efternamn för bokningen");
                    System.out.print("> ");
                    namnEft = scan.next();
                    for (int j = 0; j < PLATSERNAMN.length; j++) {
                        if (PLATSERNAMN[j].equalsIgnoreCase(namnFör + namnEft)) {
                            System.out.println("Du har plats \"" + (j + 1) + "\"");
                            finns = true;
                            break;
                        }
                    }
                    if (!finns) {
                        System.out.println("Det finns ingen bokning för dem hör uppgifterna");
                    }
                }
                default -> {
                    System.out.println("Fel input, skriv 1 eller 2");
                    System.out.print("> ");
                    val = scan.nextInt();
                }
            }
        } else {
            System.out.println("Skriv bara in ett nummer mellan 1-7");
        }

    }

    public void SkrivLediga() {
        for (int i = 0; i < PLATSERNUM.length; i++) {
            if (PLATSERNUM[i] == 0) {
                System.out.println("Plats: " + (i + 1) + " är ledig");
            }
        }
    }


    public void BeräknaVinst(){
        valueP = 0;
        valueV = 0;
        valueB = 0;

        for(int i = 0; PLATSERNUM.length > i; i++){

            if (PLATSERNUM[i] != 0){

                SubString = String.valueOf((PLATSERNUM[i]));
                sub = Integer.parseInt(SubString.substring(0,4));

                if(2023 - sub < 18){
                    valueB +=1;
                } else if (2023 - sub > 69) {
                    valueP +=1;
                } else {
                    valueV +=1;
                }
            }
        }
        System.out.println(Upptagna(valueB,valueP,valueV));
    }

    public int Upptagna(int valueB, int valueP, int valueV) {
        if (valueB > 0){
            return 150 + (Upptagna( valueB-1, valueP, valueV));
        }
        if (valueP > 0){
            return 200 + (Upptagna( valueB, valueP -1, valueV));
        }
        if (valueV > 0){
            return 300 + (Upptagna( valueB, valueP, valueV -1));
        } else {
            return 0;
        }
    }

    public void SkrivÅldrar () {

        int n = PLATSERNUM.length;
        int tempÅlder;
        int tempPlats;

        SORTERADNUM = Arrays.copyOf(PLATSERNUM, 21);
        SORTERADNAMN = Arrays.copyOf(PLATSERNAMN, 21);
        SORTERADPLATS = Arrays.copyOf(BOKADPLATS, 21);

        //för varje plats så den är nested
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (SORTERADNUM[j] > SORTERADNUM[j+1]) {

                    //Sorterar åldern
                    tempÅlder = SORTERADNUM[j];
                    SORTERADNUM[j] = SORTERADNUM[j+1];
                    SORTERADNUM[j+1] = tempÅlder;

                    //Sorterar namnen
                    String tempNamn = SORTERADNAMN[j];
                    SORTERADNAMN[j] = SORTERADNAMN[j+1];
                    SORTERADNAMN[j+1] = tempNamn;

                    //Sorterar platserna
                    tempPlats = SORTERADPLATS[j];
                    SORTERADPLATS[j] = SORTERADPLATS[j+1];
                    SORTERADPLATS[j+1] = tempPlats;
                }
            }
        }

        //Skriver ut allt
        for (int i = 0; i < n; i++) {
            if (SORTERADNUM[i] != 0) {
                System.out.println(SORTERADNUM[i] + " " + SORTERADNAMN[i] +" Plats nummer "+ (SORTERADPLATS[i]+1));
            }
        }
    }
}
