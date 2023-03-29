import java.util.Arrays;
import java.util.Scanner;

public class BussBokning {

    Scanner scan = new Scanner(System.in);

    static String[] PLATSERNAMN = new String[21];
    static String[] PLATSERKÖN = new String[21];
    static int[] PLATSERNUM = new int[21];
    int val;
    String kön;
    int personnummer;
    Boolean fullt = false;
    Boolean finns = false;
    String namnFör;
    String namnEft;
    int valueV;
    int valueB;
    int valueP;
    int summa;
    int sub;
    String SubString;
    int SubValue;
    int tom;
    int diff;

    BussBokning() {

        Arrays.fill(PLATSERNAMN, "null");

        System.out.println("Välkommen till bokningsprogrammmet, ange nummret för vad du vill göra");

        do {
            System.out.println("1. Boka en plats");
            System.out.println("2. Avboka en plats");
            System.out.println("3. Se min bokning");
            System.out.println("4. Se lediga platser");
            System.out.println("5. Räkna ut vinst");  //300 vuxen, 150 barn, 200 pensionär 69 upp
            System.out.println("6. Skriv ut åldrar"); //äldst först yngst sist
            System.out.println("7. Exit");
            System.out.print("> ");
            val = scan.nextInt();

            switch (val) {
                case 1 -> {Bokning();}
                case 2 -> {AvBokning();}
                case 3 -> {SeBokning();}
                case 4 -> {SkrivLediga();}
                case 5 -> {BeräknaVinst();}
                case 6 -> {SkrivÅldrar();}
                case 7 -> { }
                default -> {System.out.println("Fel input, skriv ett nummer mellan 1-7");}
            }
        } while (val != 7);
    }

    public void Bokning() {

        for (int i = 0; i < PLATSERNUM.length; i++) {
            if (PLATSERNUM[i] == 0) {

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

                System.out.println("Ange personnummer: ");
                System.out.print("> ");
                personnummer = scan.nextInt();

                for (int j = 0; j < PLATSERNUM.length; j++) {
                    if (PLATSERNUM[j] == personnummer || PLATSERNAMN[j].equalsIgnoreCase(namnFör + namnEft)) {
                        System.out.println("Det finnns redan en bokning för dem här uppgifterna");
                        fullt = true;
                    }
                }

                if (!fullt) {
                    PLATSERNUM[i] = personnummer;
                    PLATSERKÖN[i] = kön;
                    PLATSERNAMN[i] = namnFör + namnEft;
                    System.out.println("Bokningen lyckades");
                    System.out.println("Plats \"" + (i + 1) + "\" är din");
                }

                fullt = false;
                break;
            }
        }
    }

    public void AvBokning() {

        finns = false;

        System.out.println("Vill du avboka med namn eller personnummer?");
        System.out.println("1. Personummer");
        System.out.println("2. Namn");
        System.out.print("> ");
        val = scan.nextInt();

        switch (val) {
            case 1 -> {
                System.out.println("Ange personummer ");
                System.out.print("> ");
                personnummer = scan.nextInt();

                for (int j = 0; j < PLATSERNUM.length; j++) {
                    if (PLATSERNUM[j] == personnummer) {
                        System.out.println("Plats \"" + (j + 1) + "\" är nu avbokad");
                        PLATSERNAMN[j] = "null";
                        PLATSERNUM[j] = 0;
                        finns = true;
                        break;
                    }
                }
                if (!finns) {
                    System.out.println("Det finnns ingen befintlig bokning för dem här uppgifterna");
                }
            }
            case 2 -> {
                System.out.println("Ange förnamn ");
                System.out.print("> ");
                namnFör = scan.next();

                System.out.println("Ange efternamn ");
                System.out.print("> ");
                namnEft = scan.next();

                for (int j = 0; j < PLATSERNAMN.length; j++) {
                    if (PLATSERNAMN[j].equalsIgnoreCase(namnFör + namnEft)) {
                        System.out.println("Plats \"" + (j + 1) + "\" är nu avbokad");
                        finns = true;
                        PLATSERNAMN[j] = "null";
                        PLATSERNUM[j] = 0;
                        break;
                    }
                }
                if (!finns) {
                    System.out.println("Det finnns ingen befintlig bokning för dem här uppgifterna");
                }
            }
        }
    }

    public void SeBokning() {
        finns = false;

        System.out.println("Vill du checka för namn eller personnummer?");
        System.out.println("1. Personummer ");
        System.out.println("2. Namn");
        System.out.print(">");
        val = scan.nextInt();

        switch (val) {
            case 1 -> {
                System.out.println("Ange personnummer för bokningen");
                personnummer = scan.nextInt();

                for (int j = 0; j < PLATSERNUM.length; j++) {
                    if (PLATSERNUM[j] == personnummer) {
                        System.out.println("Du har plats \"" + (j + 1) + "\"");
                        finns = true;
                        break;
                    }
                }
                if (!finns) {
                    System.out.println("Det finns ingen bokning för dem hör uppgifterna");
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
    }

    public void SkrivLediga() {
        for (int i = 0; i < PLATSERNUM.length; i++) {
            if (PLATSERNUM[i] == 0) {
                System.out.println("Plats: " + (i + 1) + " är ledig");
            }
        }
    }


    public void BeräknaVinst() {
        for (int i = 0; i < PLATSERNUM.length; i++) {

            sub = (PLATSERNUM[i]);
            if (sub != 0) {
                SubString = String.valueOf(sub).substring(0, 4);
                SubValue = Integer.parseInt(SubString);
            }

            if (sub == 0) {
                tom += 1;
            } else {

                diff = 2023 - SubValue;

                if (diff < 18) {
                    valueB += 1;

                } else if (diff > 69) {
                    valueP += 1;

                } else {
                    valueV += 1;
                }
            }
            if (valueV+valueB+valueB+tom == 21){
                break;
            }
        }
        summa = valueB * 150 + valueP * 200 + valueV * 300;
        System.out.println(summa+" kr totalt");

    }
    public void SkrivÅldrar () {
        for (int i = 0; i < PLATSERNUM.length; i++) {

            sub = (PLATSERNUM[i]);
            if (sub != 0) {
                SubString = String.valueOf(sub).substring(0, 4);
                SubValue = Integer.parseInt(SubString);
            }

            if (sub == 0) {
                tom += 1;
            } else {

                diff = 2023 - SubValue;

                if (diff < 18) {
                    valueB += 1;

                } else if (diff > 69) {
                    valueP += 1;

                } else {
                    valueV += 1;
                }
            }
            if (valueV+valueB+valueB+tom == 21){
                break;
            }
        }

    }
}





