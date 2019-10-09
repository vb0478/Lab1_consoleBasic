package academy.learnprogramming;
import java.util.Scanner;
import java.util.Random;
public class Main {

    public static void main(String[] args) {
        Scanner _input = new Scanner(System.in);
        while(true){
            System.out.println("Select exercise: \n " +
                    " type 1, 2, 3 or 4 \n  exit: type 0");
            switch (_input.nextShort()){
                case 1: cwiczenie1(_input);
                break;
                case 2: cwiczenie2(_input);
                break;
                case 3: cwiczenie3(_input);
                break;
                case 4: cwiczenie4(_input);
                    break;
                case 0: System.exit(0);;
                default:
                    System.out.println("Wrong command, try 1-4");
                    break;
            }
        }
}

    private static void cwiczenie4(Scanner _input) {
        //4. Policzy´c i wy´swietli´c ile razy z N pr´ob wylosowana liczba mie´sci sie˛
        // w przedziale (MIN, MAX).
        // Liczba ma by´c losowana z zakresu (MIN, MAX * 10)
        System.out.println("Podaj liczbe MIN >= 0:  ");
        int min = validInt(_input);
        System.out.println("Podaj liczbe MAX > 0:  ");
        int max = validInt(_input, min);
        System.out.println("Podaj ilosc prob > 0: ");
        int iloscProb = validInt(_input);
        int counter = 0;
        Random random = new Random();
        for (int i=0; i<iloscProb; i++){
            int x = random.nextInt(max*10-min) + min;
            if(x>=min && x<=max)
                counter++;
        }
        System.out.println("Po "+ iloscProb + " probach naliczono " + counter + " trafien do przedzialu min/max");
    }

    private static void cwiczenie3(Scanner _input) {
        //3. Policzy´c i wy´swietli´c ´srednia˛ waz˙ona˛ z elemento´w przekazanych jako warto´sci,
        // waga kaz˙dej liczby ma by´c warto´scia˛ losowa˛
        Random rand = new Random();
        int sum = 0;
        int suma_wag = 0;
        while(true){
            System.out.println("Podaj wartosc liczbowa (wyjscie z petli - 111):  ");
            int value = validInt(_input);
            if(value==111)
                break;
            else{
                int waga = rand.nextInt(100);
                sum +=value*waga;
                suma_wag +=waga;
                System.out.println("Srednia warzona wynosi " + sum/(double)suma_wag);
            }
        }
    }

    private static void cwiczenie2(Scanner _input) {
        //2. Wypisa´cnaekransume˛cia˛guarytmetycznegooNelemntach,rozpoczynaja˛cego sie˛
        // od elemetu A1 i rosna˛cego o losowa˛ warto´s´c
        System.out.println("Podaj liczbe A1:  ");
        int start = validInt(_input);
        System.out.println("Podaj dlugosc ciagu liczb: ");
        int dlugosc = validInt(_input);
        Random random = new Random();
        long sum = 0;
        int r = random.nextInt();
        for (int i=0; i<dlugosc; i++)
            sum += r;
        //sum = (2*start + (long)(r*(dlugosc - 1))*dlugosc/2;
        if (sum < 0)
            System.out.println("Przekroczono zakres...");
        else
            System.out.println("Suma ciagu arytmetycznego to: " + sum);
    }

    private static void cwiczenie1(Scanner _input) {
        // 1. Wypisa´c na ekran cia˛g liczb podzielnych przez wylosowana˛ liczbe˛
        // z przedzia lu (MIN, MAX)
        System.out.println("Podaj liczbe MIN > 0:  ");
        int min = validInt(_input);
        System.out.println("Podaj liczbe MAX > MIN:  ");
        int max = validInt(_input, min);
        System.out.println("Podaj dlugosc ciagu liczb: ");
        int dlugosc = validInt(_input);
        String lista = "";
        Random random = new Random();
        int divider = random.nextInt(max - min) + min;
        int i = 0;
        while(dlugosc > 0){
            i++;
            if(i%divider ==0){
                lista+= " " + i;
                dlugosc--;
            }
        }
        System.out.println("Podzielne przez " + divider + ": " + lista);
    }
    public static int validInt(Scanner _input){
        int number;
        while(true){
            while (!_input.hasNextInt() ) {
                System.out.println("That's not a number!");
                _input.next();
            }
            number = _input.nextInt();
            if(number > 0){
                System.out.println("Got " + number);
                return number;
            }
             else
                System.out.println("Please enter a positive number!");
        }



    }
    public static int validInt(Scanner _input, int min){
        int number;
        while(true){
            while (!_input.hasNextInt() ) {
                System.out.println("That's not a number!");
                _input.next();
            }
            number = _input.nextInt();
            if(number > min){
                System.out.println("Got " + number);
                return number;
            }
            else
                System.out.println("Please enter a number greater of MIN!");
    }
}
}
