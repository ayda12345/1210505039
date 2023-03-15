import java.util.Random;

public class MaxBulmaAlgoritmalari {
    public static void main(String[] args) {
        int[] dizi = new int[10000];
        Random rastgele = new Random();

        // Diziye rastgele sayılar ekleme
        for (int i = 0; i < dizi.length; i++) {
            dizi[i] = rastgele.nextInt();
        }

        // Max Bulma Algoritması
        long baslangicZamani = System.nanoTime();
        int max = maxBulma(dizi);
        long bitisZamani = System.nanoTime();
        long calismaSuresi = bitisZamani - baslangicZamani;

        System.out.println("Max Bulma Algoritması çalışma süresi: " + calismaSuresi + " nanosaniye.");
        // BruteForce Algoritması
        baslangicZamani = System.nanoTime();
        int maxBrute = maxBulmaBruteForce(dizi);
        bitisZamani = System.nanoTime();
        calismaSuresi = bitisZamani - baslangicZamani;

        System.out.println("BruteForce Algoritması çalışma süresi: " + calismaSuresi + " nanosaniye.");
    }

    public static int maxBulma(int[] dizi) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dizi.length; i++) {
            if (dizi[i] > max) {
                max = dizi[i];
            }
        }
        return max;
    }

    public static int maxBulmaBruteForce(int[] dizi) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dizi.length; i++) {
            for (int j = i + 1; j < dizi.length; j++) {
                if (dizi[j] > max) {
                    max = dizi[j];
                }
            }
        }
        return max;
    }
}
