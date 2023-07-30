package PROJELER;

import java.util.Scanner;

public class xox_oyunu {
    public static void main(String[] args) {

        Scanner oku=new Scanner(System.in);
        String tablo[][]= new String[3][3];

        for (int satir = 0; satir < tablo.length; satir++) {
            for (int sutun = 0; sutun < tablo[satir].length; sutun++) {
                tablo[satir][sutun]= " ";
            }
        }

        for (int hamle = 0; hamle < 9; hamle++) {
            tabloYaz(tablo);
            String oyuncu;

            oyuncu=siraHangiOyuncuda(hamle);

            int satir, sutun; // tanımla sadece

            System.out.print(oyuncu + " oyuncusu için satırı girin (1,2,3) = ");
            satir= oku.nextInt();
            System.out.print(oyuncu + " oyncusu için sutunu girin (1,2,3) = ");
            sutun= oku.nextInt();

            boolean kazanan=false;

            if ((satir>=1 && satir<=3) && ( sutun>=1 && sutun<=3)){

                if (tablo[satir-1][sutun-1].equals(" ")) { // boş olan bir yere yazmışsa eğer

                    tablo[satir - 1][sutun - 1] = oyuncu;

                    kazanan = kontrol(tablo);
                    if (kazanan) {
                        tabloYaz(tablo);
                        System.out.println("!!!!!!!!!!!!!!!!!! OYUNCU " + oyuncu + " KAZANDI !!!!!!!!!!!!!!!!!!");
                        return;
                    }
                }
                    else { // hatalı girilen değerler için
                        System.out.println(" satır veya sutun numarası yanlış girildi");
                        hamle--;
                    }

                }
                else { // dolu kareye yazmaya çlışılmışsa
                    System.out.println(" satir sutun dolu, hatalı girdiniz");
                    hamle--; // sıra tekrar o oyuncuya geri gelsin diye
                }

        }

        System.out.println("çiziniz");
    }

    public static boolean kontrol(String[][] tablo) {

        boolean saglamiyorsa= false;

        saglamiyorsa=satirKontrol(tablo);
        if (saglamiyorsa){
            return true;
        }

        saglamiyorsa=sutunKontrol(tablo);
        if (saglamiyorsa){
            return true;
        }

        saglamiyorsa=caprazKontrol(tablo);
        if (saglamiyorsa){
            return true;
        }

        return false;
    }

    public static boolean caprazKontrol(String[][] tablo)  {

        String kare00=tablo[0][0];
        String kare11=tablo[1][1];
        String kare22=tablo[2][2];
        String kare02=tablo[0][2];
        String kare20=tablo[2][0];

        if (!kare00.equals(" ") && kare00.equals(kare11) && kare11.equals(kare22)){
            return true;
        }

        if (!kare02.equals(" ") && kare02.equals(kare11) && kare11.equals(kare20)){
            return true;
        }
        return false;
    }

    public static boolean satirKontrol(String[][] tablo) {
        for (int sutun = 0; sutun < 3; sutun++) {

            String satir0= tablo[0][sutun];
            String satir1= tablo[1][sutun];
            String satir2= tablo[2][sutun];

            if (!satir0.equals(" ") && satir0.equals(satir1) && satir1.equals(satir2)){ // satırların içi boş değilse ve aynıysa anlamına geliyor
                return true;
            }

        }
        return false;
    }
    public static boolean sutunKontrol(String[][] tablo) {
        for (int satir = 0; satir < 3; satir++) {

            String sutun0= tablo[satir][0];
            String sutun1= tablo[satir][1];
            String sutun2= tablo[satir][2];

            if (!sutun0.equals(" ") && sutun0.equals(sutun1) && sutun1.equals(sutun2)){
                return true;
            }

        }
        return false;
    }


    public static String siraHangiOyuncuda( int hamle) {

        String oyuncu;

        if (hamle%2==0) {
            oyuncu = "X";
        }
        else {
            oyuncu="O";
        }

        return oyuncu;
    }

    public static void tabloYaz(String[][] tablo) {
        for (int satir = 0; satir < 3; satir++) {
            System.out.println("\n******TEAM4******");
            System.out.print("||");
            for (int sutun = 0; sutun < 3; sutun++) {
                System.out.print(" ");
                System.out.print(tablo[satir][sutun]);
                System.out.print(" ");
                System.out.print("||");

            }
            System.out.println(""); // alt satıra geçmesi için
        }
        System.out.println("******TEAM4******"); // tekrarlanmaması için for dışında
    }


}

