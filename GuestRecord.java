import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import Model.EventOrganizer;

public class GuestRecord {

    static Scanner input_pilihan = new Scanner(System.in);
    static BufferedReader input_data_tamu = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        //variabel untuk menyimpan data inputan sememtara
        boolean ulang = true;
        char input_pilihan_menu;

        EventOrganizer[] daftar_tamu = new EventOrganizer[10];

        while (ulang) {
            System.out.println("\n================================================");
            System.out.println("=================Program Undang=================");
            System.out.println("================================================");
            System.out.println("Pilih Menu");
            System.out.println("a.input data");
            System.out.println("b.cetak data");
            System.out.println("c.exit");
            System.out.print("pilih : ");
            input_pilihan_menu = input_pilihan.next().charAt(0);

            switch (input_pilihan_menu) {
                case 'a':
                    InputTamuUndangan(daftar_tamu);
                    break;

                case 'b':
                    ArrayList<EventOrganizer> para_tamu = new ArrayList<EventOrganizer>(Arrays.asList(daftar_tamu));
                    EventOrganizer.PrintGuests(para_tamu);
                    break;

                case 'c':
                    ulang = false;
                    break;
            
                default:
                    System.out.println("\nmohon pilih huruf yang ada di menu\n");
                    break;
            }
        }
    }

    private static void InputTamuUndangan(EventOrganizer[] daftar_tamu) {
        System.out.println("\n===================Input Data===================");

        for (int i = 0; i < daftar_tamu.length; i++) {
            try {
                EventOrganizer tamu = new EventOrganizer();

                System.out.print("ID\t: ");
                tamu.setID(Integer.parseInt(input_data_tamu.readLine()));

                System.out.print("Nama\t: ");
                tamu.setNAMA(input_data_tamu.readLine());

                System.out.print("Alamat\t: ");
                tamu.setALAMAT(input_data_tamu.readLine());

                System.out.print("Email\t: ");
                tamu.setEMAIL(input_data_tamu.readLine());

                System.out.print("No HP\t: ");
                tamu.setNO_HP(input_data_tamu.readLine());

                daftar_tamu[i] = tamu;
                if (i != daftar_tamu.length) {
                    System.out.println("================================================");
                }
            } catch (Exception e) {
                System.out.println("error : " + e.getMessage());
            }
        }
    }
}