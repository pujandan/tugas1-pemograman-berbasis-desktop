import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // 1. Inisialisasi Data Menu
        Menu[] daftarMenu = {
                new Menu("Iga Bakar", 45000, "Makanan"),
                new Menu("Sop Jando", 35000, "Makanan"),
                new Menu("Sate Sapi", 55000, "Makanan"),
                new Menu("Air Mineral", 5000, "Minuman"),
                new Menu("Es Jeruk", 10000, "Minuman"),
                new Menu("Air Kelapa", 15000, "Minuman"),
        };

        // 2. Menampilkan Daftar Menu
        printTitle("DAFTAR MENU");
        printTitle("MAKANAN");
        System.out.println("1. "+daftarMenu[0].name +" Rp. "+daftarMenu[0].price);
        System.out.println("2. "+daftarMenu[1].name +" Rp. "+daftarMenu[1].price);
        System.out.println("3. "+daftarMenu[2].name +" Rp. "+daftarMenu[2].price);
        printTitle("MINUMAN");
        System.out.println("4. "+daftarMenu[3].name +" Rp. "+daftarMenu[3].price);
        System.out.println("5. "+daftarMenu[4].name +" Rp. "+daftarMenu[4].price);
        System.out.println("6. "+daftarMenu[5].name +" Rp. "+daftarMenu[5].price);

        // 3. Proses Pemesanan
        Scanner input = new Scanner(System.in);
        printTitle("Masukan Pesanan Anda (Maksimal 4 Pesanan)");


        System.out.print("Masukan Pesanan Ke-1 (Nama Item):");
        String orderName1 = input.nextLine();
        System.out.print("Jumlah Order: ");
        int qtyOrder1 = input.nextInt();
        input.nextLine();

        System.out.print("Masukan Pesanan Ke-2 (Nama Item):");
        String orderName2 = input.nextLine();
        System.out.print("Jumlah Order: ");
        int qtyOrder2 = input.nextInt();
        input.nextLine();

        System.out.print("Masukan Pesanan Ke-3 (Nama Item):");
        String orderName3 = input.nextLine();
        System.out.print("Jumlah Order: ");
        int qtyOrder3 = input.nextInt();
        input.nextLine();

        System.out.print("Masukan Pesanan Ke-4 (Nama Item):");
        String orderName4 = input.nextLine();
        System.out.print("Jumlah Order: ");
        int qtyOrder4 = input.nextInt();
        input.nextLine();

        // 4. Kalkulasi Total Biaya
        double price1 = searchPrice(orderName1, daftarMenu);
        double price2 = searchPrice(orderName2, daftarMenu);
        double price3 = searchPrice(orderName3, daftarMenu);
        double price4 = searchPrice(orderName4, daftarMenu);

        double subTotal = (price1 * qtyOrder1) + (price2 * qtyOrder2) + (price3 * qtyOrder3) + (price4 * qtyOrder4);

        // 5. Logika Diskon & Info Promosi
        double discount = 0;
        String infoPromo = "";

        if(subTotal > 100000){
            discount = subTotal * 0.10;
            infoPromo = "Discount 10% (Belanja lebih dari 100rb)";
        } else if(subTotal > 50000) {
            infoPromo = "Promo Beli 1 Gratis 1 Minuman (Sudah Diterapkan)";
        }

        // 6. Perhitungan Final
        double totalAfterDiscount = subTotal - discount;
        double tax = totalAfterDiscount * 0.10;
        double service = 20000;
        double grandTotal = totalAfterDiscount + tax + service;

        // 7. Cetak Struk
        printTitle("STRUK PEMBAYARAN");
        printItem(orderName1, qtyOrder1, price1);
        printItem(orderName2, qtyOrder2, price2);
        printItem(orderName3, qtyOrder3, price3);
        printItem(orderName4, qtyOrder4, price4);
        printTitle("__________________________");
        System.out.println("Total Harga Item    : Rp. "+ subTotal);
        System.out.println("Promo               : Rp. "+ infoPromo);
        if(discount > 0 ) System.out.println("Potongan Diskon       : -Rp. "+discount);
        System.out.println("Pajak (10%)         : Rp. "+ tax);
        System.out.println("Biaya Pelayanan     : Rp. "+service);
        System.out.println("Total Pembayaram    : Rp. "+ grandTotal);
        printTitle("__________________________");

    }

    public static double searchPrice(String name, Menu[] daftarMenu) {
        if(name.equalsIgnoreCase(daftarMenu[0].name)){
            return daftarMenu[0].price;
        }else
        if(name.equalsIgnoreCase(daftarMenu[1].name)){
            return daftarMenu[1].price;
        }else
        if(name.equalsIgnoreCase(daftarMenu[2].name)){
            return daftarMenu[2].price;
        }else
        if(name.equalsIgnoreCase(daftarMenu[3].name)){
            return daftarMenu[3].price;
        }else
        if(name.equalsIgnoreCase(daftarMenu[4].name)){
            return daftarMenu[4].price;
        }else
        if(name.equalsIgnoreCase(daftarMenu[5].name)){
            return daftarMenu[5].price;
        }

        return 0;
    }

    public static void printItem(String name, int qty, double price){
        if(qty > 0){
            System.out.println(name + " x" + qty + " \t Rp. "+ (qty * price));
        }
    }

    public static void printTitle(String title) {
        System.out.println("========== " + title + " ==========");
    }
}