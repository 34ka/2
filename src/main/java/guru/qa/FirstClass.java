package guru.qa;

public class FirstClass {

    byte aByte = 10; //8 bit -128 ... 127
    short aShort = 100; // 16 bit -32768 ... 32767
    // самый используемый
    int aInt = 100_000; // 32 bit -2 ^ 31 ... (2 ^ 31) -1
    long aLong = 100L; // 64 bit -2 ^ 63 ... (2 ^ 63) -1

    float aFloat = 0.0F; // 32 bit
    // самый используемый (если просто хранить, но не использовать арифметику)
    double aDouble = 0.0; // 64 bit

    char aChar = 'c';
    boolean aBoolean = false;
    String aString = "Hello, qa.guru";

    // + -- сложение
    // - -- вычитание
    // * -- умножение
    // / -- целочисленное деление
    // % -- остаток от деления
    // инкремент ++
    // декремент --

    // >
    // <
    // >=
    // <=
    // ==
    // !=

    // =
    // +=
    // -=...

    //a++
    //++a

    public static void main(String[] args) {
        byte aByte = 10;
        byte bByte = 10;
        byte cByte = 127;
        //переполнение в min и max сторону
        //byte dByte = -150;
        //byte eByte = 150;

        short aShort = 300;
        short bShort = 300;
        short cShort = 32700;
        short dShort = 128;
        //переполнение в min и max сторону
        short eShort = 128;
        //short fShort = -128000;
        //short jShort = 128000;

        int aInt = 50000;
        int bInt = 2_000_000_000;
        int cInt = 2_000_000_000;
        int dInt = 32767;
        //переполнение в min и max сторону
        //int eInt = -11_100_032_767;
        //int fInt = 11_100_032_767;

        long aLong = 3_000_000_000L;
        long bLong = 3_000_000_000L;
        long cLong = 9_000_000_000_000_000_000L;
        //переполнение в min и max сторону
        //long dLong = -90_000_000_000_000_000_000L;
        //long eLong = 90_000_000_000_000_000_000L;

        float aFloat = 0.0000000000000000000000023F;
        float bFloat = 1.0000000000000000000000023F;

        double aDouble = 100.0000000000000000000000023;
        double bDouble = 200.0000000000000000000000023;

        char aChar = 'a';
        char bChar = 'b';
        String aString = "Hello ";
        String bString = "cat";

        System.out.println("сложение одинаковых типов данных");
        System.out.println(aByte + bByte);
        System.out.println(aShort + bShort);
        System.out.println(aInt + bInt);
        System.out.println(aLong + bLong);
        System.out.println(aFloat + aFloat);
        System.out.println(aDouble + aDouble);
        System.out.println(aChar + bChar);
        System.out.println(aString + aString);
        System.out.println();

        System.out.println("вычитание одинаковых типов данных");
        System.out.println(cByte - bByte);
        System.out.println(cShort - bShort);
        System.out.println(cInt - aByte);
        System.out.println(cLong - bLong);
        System.out.println(bFloat - aFloat);
        System.out.println(bDouble - aDouble);
        System.out.println(bChar - aChar);
        //ошибка из String не даёт вычитать String
        //System.out.println(aString - aString);
        System.out.println();

        System.out.println("Умножение типов данных");
        System.out.println(aByte * bByte);
        System.out.println(dShort * dShort);
        System.out.println(dInt * dInt);
        System.out.println(aLong * aLong);
        System.out.println(aFloat * bFloat);
        System.out.println(aDouble * bDouble);
        System.out.println(aChar * bChar);
        //ошибка String не даёт умножать на String
        //System.out.println(aString * aString);
        System.out.println();

        System.out.println("Умножение типов данных");
        System.out.println(aByte / bByte);
        System.out.println(cShort / dShort);
        System.out.println(bInt / dInt);
        System.out.println(cLong / aLong);
        System.out.println(bFloat / aFloat);
        System.out.println(bDouble / aDouble);
        //результат деления char всегда =0
        System.out.println(aChar / bChar);
        //ошибка String не даёт делить на String
        //System.out.println(aString / aString);
        System.out.println();

        System.out.println("остаток от деления типов данных");
        System.out.println(aByte % bByte);
        System.out.println(cShort % dShort);
        System.out.println(bInt % dInt);
        System.out.println(cLong % aLong);
        System.out.println(bFloat % aFloat);
        System.out.println(bDouble % aDouble);
        System.out.println(aChar % bChar);
        //ошибка String не даёт делить на String
        //System.out.println(aString % aString);
        System.out.println();

        System.out.println("инкремент типов данных в конце");
        System.out.println(aByte++);
        System.out.println(cShort++);
        System.out.println(bInt++);
        System.out.println(cLong++);
        System.out.println(bFloat++);
        System.out.println(bDouble++);
        System.out.println(aChar++);
        //ошибка String не даёт прибавить 1
        //System.out.println(aString++);
        System.out.println();

        System.out.println("инкремент типов данных в начале");
        System.out.println(++aByte);
        System.out.println(++cShort);
        System.out.println(++bInt);
        System.out.println(++cLong);
        System.out.println(++bFloat);
        System.out.println(++bDouble);
        System.out.println(++aChar);
        //ошибка String не даёт прибавить 1
        //System.out.println(++aString);
        System.out.println();

        System.out.println("декремент типов данных в конце");
        System.out.println(aByte--);
        System.out.println(cShort--);
        System.out.println(bInt--);
        System.out.println(cLong--);
        System.out.println(bFloat--);
        System.out.println(bDouble--);
        System.out.println(aChar--);
        //ошибка String не даёт вычесть 1
        //System.out.println(aString--);
        System.out.println();

        System.out.println("декремент типов данных в начале");
        System.out.println(--aByte);
        System.out.println(--cShort);
        System.out.println(--bInt);
        System.out.println(--cLong);
        System.out.println(--bFloat);
        System.out.println(--bDouble);
        System.out.println(--aChar);
        //ошибка String не даёт вычесть 1
        //System.out.println(--aString);
        System.out.println();

        System.out.println(">, <, >=, <=, ==, !=, &&, ||, !");
        System.out.println(cByte > aByte);
        System.out.println(aShort < cShort);
        System.out.println(bInt >= aInt);
        System.out.println(aLong <= cLong);
        System.out.println(aFloat == aFloat);
        System.out.println(aDouble != bDouble);
        //ошибка с типом String
        //System.out.println(aString > bString);
        System.out.println((cByte > aByte) && (cByte>bByte));
        System.out.println((cByte > aByte) || (cByte>bByte));
        System.out.println(!((cByte > aByte) || (cByte>bByte)));

        System.out.println("=, +=, -=");
        System.out.println(bInt = 5);
        System.out.println(bInt += aInt);
        System.out.println(aInt -= bInt);
        System.out.println(aString += aString);
        System.out.println(aString = bString);
        //ошибка с типом String
        //System.out.println(aString -= aString);
        System.out.println();

        System.out.println("операции с разными типами данных");
        System.out.println(aByte + aShort);
        System.out.println(aShort + bInt);
        System.out.println(bInt + cLong);
        System.out.println(cLong + bFloat);
        System.out.println(aFloat + bDouble);
        System.out.println(aDouble + aChar);
        System.out.println(aChar + aString);
        System.out.println(aString + aString);
        System.out.println();
    }
}