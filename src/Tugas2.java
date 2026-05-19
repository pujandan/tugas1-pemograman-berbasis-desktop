import java.util.ArrayList;
import java.util.Scanner;

public class Tugas2 {


    // array untuk menyimpan daftar menu
    static ArrayList<Menu> daftarMenu = new ArrayList<Menu>();

    // scan untuk input user
    static Scanner input = new Scanner(System.in);


    public static void main(String[] args) {

        // daftar awal menu makanan
        daftarMenu.add(new Menu("Nasi Goreng", 25000, "Makanan"));
        daftarMenu.add(new Menu("Mie Ayam", 20000, "Makanan"));
        daftarMenu.add(new Menu("Ayam Geprek", 30000, "Makanan"));
        daftarMenu.add(new Menu("Sate Ayam", 35000, "Makanan"));

        // daftar awal menu minuman
        daftarMenu.add(new Menu("Es Teh", 5000, ""));
        daftarMenu.add(new Menu("Jus Alpukat", 15000, ""));
        daftarMenu.add(new Menu("Kopi", 10000, ""));
        daftarMenu.add(new Menu("Air Mineral", 5000, ""));


        // menjalankan menu utama
        menuUtama();
    }

    // method untuk mengelola menu utama
    public static void menuUtama() {
        // proses berulang
        while (true) {
            System.out.println("===== Menu Utama =====");
            System.out.println("1. Pesanan");
            System.out.println("2. Kelola Menu");
            System.out.println("3. Keluar");
            System.out.print("Pilih: ");
            int option = input.nextInt();

            // percabangan pilihan menu
            switch (option) {
                case 1:
                    // menjalankan pesanan
                    prosesPesanan();
                    break;
                case 2:
                    // menjalankan kelola menu
                    kelolaMenu();
                    break;
                case 3:
                    // keluar
                    System.out.println("Program Selesai");
                    System.exit(0);
                    break;
                default:
                    // informasi tidak valid
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }
    }

    // method untuk menampilkan menu
    public static void tampilMenu(ArrayList<Menu> menus) {
        System.out.println("===== Daftar Semua menu =====");

        // perulangan untuk menampilkan seluruh menu yang ada
        for (int i = 0; i < menus.size(); i++) {
            Menu menu = menus.get(i);
            // format : 1. Nama Menu | Rp. 10000 | Makanan
            System.out.println( i + 1 +". " + menu.name + " | Rp. "+ menu.price + " | "+ menu.category);
        }
    }


    // method pemesanan makanan
    public static void prosesPesanan() {
        // menyimpan pesanan
        ArrayList<Menu> orders = new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();

        while(true) {

            // menampilkan menu dahulu
            tampilMenu(daftarMenu);

            System.out.println("===== Pilih Nomor Menu (pilih 0 untuk selesai)=====");
            int option = input.nextInt();

            // jika pilihan 0 maka selesai
            if(option == 0) break;

            // validasi menu
            if(option < 1 || option > daftarMenu.size()) {
                System.out.println("Pilihan menu tidak valid.");
                continue;
            }

            // jumlah pesanan
            System.out.print("Jumlah: ");
            int qty = input.nextInt();


            // menyimpan pesanan
            orders.add(daftarMenu.get(option - 1));
            quantities.add(qty);
        }


        // menhitung total keseluruhan ketika proses pemesanan telah selesai
        hitungTotal(orders, quantities);
    }

    // method untuk menghitung total keseluruhan
    public static void hitungTotal(ArrayList<Menu> orders, ArrayList<Integer> quantities) {

        double total = 0;

        System.out.println("===== STRUK =====");

        // perulangan seluruh pesanan
        for (int i = 0; i < orders.size(); i++) {

            //  hitung subtotal:  price * quantity
            double subtotal = orders.get(i).price * quantities.get(i);

            // tambahkan ke total
            total += subtotal;

            // menampilkan ke console: Nama Menu x2 = Rp. 10000
            System.out.println(
                    orders.get(i).name + " x" + quantities.get(i) + " = Rp. "+ subtotal
            );
        }

        // kalkulasi diskon: jika > 100rb maka dapat discount 10%
        double discount = 0;
        if(total > 100000){
            discount = total * 0.1;
        }

        // kalkulasi pajak 10%
        double tax = total * 0.1;

        // biaya service tetap 20rb
        double service = 20000;

        double grandTotal = total - discount + tax + service;

        // tampilkan struk
        System.out.println("-----------");
        System.out.println("Total : Rp. "+total);
        System.out.println("Diskon (10%): Rp. "+discount);
        System.out.println("Pajak (10%) : Rp. "+tax);
        System.out.println("Biaya Pelayanan : Rp. "+service);
        System.out.println("Total Bayar : Rp. "+grandTotal);
        System.out.println("-----------");
    }


    static public void kelolaMenu(){

        while (true) {
            System.out.println("===== Kelola Menu =====");
            System.out.println("1. Tambah Menu");
            System.out.println("2. Ubah Menu");
            System.out.println("3. Hapus Menu");
            System.out.println("4. Kembali");
            System.out.println("5. Selesai");

            System.out.print("Pilih: ");
            int option = input.nextInt();

            switch (option) {
                case 1:
                    // proses tambah Menu
                    prosesTambahMenu();
                    break;
                case 2:
                    // proses ubah Menu
                    prosesUbahMenu();
                    break;
                case 3:
                    // proses hapus Menu
                    prosesHapusMenu();
                    break;
                case 4:
                    // kembali
                    return;
                case 5:
                    // keluar
                    System.out.println("Program Selesai");
                    System.exit(0);
                    break;
                default:
                    // informasi tidak valid
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }
    }

    static public void prosesTambahMenu(){
        System.out.println("===== Tambah Menu Baru ======");
        input.nextLine();
        System.out.print("Nama : ");
        String name = input.nextLine();
        System.out.print("Harga : ");
        double price = input.nextDouble();
        System.out.print("Kategori : ");
        input.nextLine();
        String category = input.nextLine();

        // tambahkan ke array daftar menu
        daftarMenu.add(new Menu(name, price, category));
        System.out.println("Proses penambahan menu baru berhasil");
    }

    static public void prosesUbahMenu(){
        // menampilkan daftar menu terkini
        tampilMenu(daftarMenu);

        System.out.println("===== Ubah Menu ======");
        System.out.print("Pilih Nomor : ");
        int option = input.nextInt() - 1;
        input.nextLine();

        // validasi inputan
        if(option >= 0 && option < daftarMenu.size()){
            System.out.print("Nama Baru : ");
            daftarMenu.get(option).name = input.nextLine();
            System.out.print("Harga Baru: ");
            daftarMenu.get(option).price = input.nextDouble();
            System.out.print("Kategori Baru: ");
            input.nextLine();
            daftarMenu.get(option).category = input.nextLine();

            System.out.println("Proses perubahan menu berhasil");
        }else{
            System.out.println("Menu yang dipilih tidak valid.");
        }
    }

    static public void prosesHapusMenu(){
        // menampilkan daftar menu terkini
        tampilMenu(daftarMenu);

        System.out.println("===== Hapus Menu ======");
        System.out.println("Pilih Nomor : ");
        int option = input.nextInt() - 1;

        // validasi inputan
        if(option >= 0 && option < daftarMenu.size()){
            daftarMenu.remove(option);
            System.out.println("Proses penghapusan menu berhasil");
        }else{
            System.out.println("Menu yang dipilih tidak valid.");
        }
    }
}
