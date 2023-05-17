package it.unibs.fp.phidieulero;

import it.kibo.fp.lib.InputData;

public class Main {
    public static void main(String[] args) {

        boolean riprova = true;
        do
        {

            int n = InputData.readIntegerWithMinimum("Inserisci un numero intero: ", 1);
            System.out.printf("Il numero %d ha %d numeri coprimi\n", n, phiDiEulero(n));
            riprova = InputData.readYesOrNo("Vuoi ripetere ?");

        } while (riprova);

    }

    public static int phiDiEulero(int n) {

        if (n == 1) {
            return 1;
        }

        int p;
        int k = 0;

        int x = n;


        if (isPrime(n)) {
            return n-1;
        }


        for (p = 2; p <= Math.sqrt(x); p++) {
            k = 0;
            while (x % p == 0) {
                x /= p;
                k++;
            }
            if (k > 0 && x == 1.0) {
                break;
            }
        }

        if (Math.pow(p, k) == n) {
            if (isPrime(p)) {
                return (p - 1) * (int) Math.pow((double) p, (double) k - 1);
            }
        }

        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                int j = n / i;
                if (areRelativePrimes(i, j)) {
                    return phiDiEulero(i) * phiDiEulero(j);
                }
            }
        }

        return 0;

    }

    public static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // MCD == 1
    public static boolean areRelativePrimes(int a, int b) {

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        if (a == 1) {
            return true;
        }
        return false;
    }

}