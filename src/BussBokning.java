import java.util.Scanner;

public class BussBokning {
    Scanner Scan = new Scanner(System.in);

    String[] PLATSERNAMN = new String[21];
    String[] PLATSERKÖN = new String[21];
    int[] PLATSERNUM = new int[21];
    int val;
    String kön;
    int personnummer;

    BussBokning() {




        System.out.println("Välkommen till bokningsprogrammmet, ange nummret för vad du vill göra");

        do {
            System.out.println("1. Boka en plats");
            System.out.println("2. Avboka en plats");
            System.out.println("3. Se lediga platser");
            System.out.println("4. Räkna ut vinst");  //300 vuxen, 150 barn, 200 pensionär 69 upp
            System.out.println("5. Skriv ut åldrar"); //äldst först yngst sist
            System.out.println("6. Exit");
            System.out.print("> ");
            val = Scan.nextInt();

            switch (val) {
                case 1:
                    for (int i = 0; i < PLATSERNUM.length; i++){
                            if (PLATSERNUM[i] == 0){
                                System.out.print("Ange namn: ");
                                String namn = Scan.nextLine();

                                System.out.println("Ange kön: ");
                                System.out.println("1. Man");
                                System.out.println("2. Kvinnna");
                                System.out.println("3. Annnat");
                                System.out.println("4. Vill ej uppge");
                                System.out.print("> ");
                                int könval = Scan.nextInt();

                                do{
                                    switch(könval) {
                                        case 1:
                                            kön = "man";
                                            break;
                                        case 2:
                                            kön = "kvinna";
                                            break;
                                        case 3:
                                            kön = "annat";
                                            break;
                                        case 4:
                                            kön = "ville j uppge";
                                            break;
                                        default:
                                            System.out.println("fel input");
                                            kön = null;
                                            break;
                                    }
                                }while(kön == null);

                                System.out.println("Ange personnummer: ");
                                System.out.print("> ");
                                personnummer = Scan.nextInt();

                                break;
                            }
                    }


                case 2:
                    System.out.println("omar");
                    break;
                case 3:
                    for (int i =0; i< PLATSERNUM.length; i++){
                        if(PLATSERNUM[i] == 0){
                            System.out.println("Plats: "+ (i+1) +" är ledig");
                        }
                    }
                    break;
                default:
                    System.out.println("Fel input, skriv ett nummer mellan 1-6");
                    break;

            }
        }while(val!=6);
    }


}



