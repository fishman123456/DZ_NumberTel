import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    // validateRawNumber - валидация телефонного номера в сыром виде
    // вход: телефонный номер в сыром виде
    // выход: true, если валидный, иначе false
    // валидный телефонный номер в сыром виде = это строка из десяти цифр, например "0055530203"
    public static boolean validateRawNumber(String rawNumber) {
        //int num = Integer.parseInt(rawNumber);
//        String regex = "\\d{10}";
//            return  rawNumber !=null && rawNumber.length()==10 && rawNumber.matches(regex);
        return rawNumber != null && rawNumber.matches("^[0-9]{10}$"); // by Civova C.
    }

    // validateFormattedNumber - валидация телефонного номера в форматированном виде
    // вход: телефонный номер в форматированном виде
    // выход: true, если валидный, иначе false
    // валидный телефонный номер в форматированном виде, это строка из 10 цифр + код РФ и дефисы в нужных местах
    // например "+7-005-553-02-03"
    public static boolean validateFormattedNumber(String formattedNumber) {
        return formattedNumber != null && formattedNumber.matches("^\\+7-[0-9]{3}-[0-9]{3}-[0-9]{2}-[0-9]{2}$");
//        String regex = "^\\+7-[0-9]{3}-[0-9]{3}-[0-9]{2}-[0-9]{2}$";
//        return  formattedNumber !=null && formattedNumber.length()==16 && formattedNumber.matches(regex);
    }

    // convertRawToFormatted - преобразование телефонного номера в сыром виде в форматированный вид
    // вход: телефонный номер в сыром виде
    // выход: этот же телефонный номер в форматированном виде, если входной номер не валидный, то вернуть null
    // например: "0055530203" -> "+7-005-553-02-03"
    public static String convertRawToFormatted(String rawNumber) {
        if(!validateRawNumber(rawNumber))
        {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(rawNumber);
        stringBuilder.insert(0,"+")
                .insert(1,"7")
                .insert(2,"-")
                .insert(6,"-")
                .insert(10,"-")
                .insert(13,"-");
        return stringBuilder.toString();
    }


    // convertFormattedToRaw - преобразование телефонного номера в форматированном виде в сырой вид
    // вход: телефонный номер в форматированном виде
    // выход: этот же телефонный номер в сыром виде, если входной номер не валидный, то вернуть null
    // например: "+7-005-553-02-03" -> "0055530203"
    public static String convertFormattedToRaw(String formattedNumber) {
        if (!validateFormattedNumber(formattedNumber)){
            return  null;
        }
        return formattedNumber
                .substring(3)
                .replaceAll("-","");
    }

    // generateRawNumber - генерация случайного телефонного номера в сыром виде (должен быть валидный)
    public static String generateRawNumber(Random random) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<10; i++){
        sb.append(random.nextInt(0,9));
        }
        return  sb.toString();
    }

    // generateFormattedNumber - генерация случайного телефонного номера в форматированном виде (должен быть валидный)
    public static String generateFormattedNumber(Random random) {
        String rawNumber =  generateRawNumber(random);
        StringBuilder sb = new StringBuilder(rawNumber);
        sb.insert(0,"+")
                .insert(1,"7")
                .insert(2,"-")
                .insert(6,"-")
                .insert(10,"-")
                .insert(13,"-");
        String str = sb.toString();
        return  sb.toString();
    }

    // доп функция принимает строку - возвращает форматируемую строку
    // generateFormattedNumber - генерация случайного телефонного номера в форматированном виде (должен быть валидный)
    public static String generateFormattedNumberString(String rawNumber) {
        //String rawNumber =  generateRawNumber(random);
        StringBuilder sb = new StringBuilder(rawNumber);
        sb.insert(0,"+")
                .insert(1,"7")
                .insert(2,"-")
                .insert(6,"-")
                .insert(10,"-")
                .insert(13,"-");
        String str = sb.toString();
        return  sb.toString();
    }
    // generateNumbers - генерация случайных телефонных номеров
    // вход: count - кол-во номеров для генерации
    // выход: двумерный массив сгенерированных номеров, в первой строке которого номера в сыром виде,
    // а во второй строке соответствующие им номер в форматированном виде
    public static String[][] generateNumbers(int count, Random random) {

        // Создаём массив двумерный String
        // [] - вводит пользователь(кол-во строк)
        // [2] - фиксированное значение (кол-во столбцов)
        // String [][] mass = new String[][] {{"0","1","2"},{"1","2"}};
        //String[][] mass = null;
        String[][] mass = new String[2][count];
        for (int i = 0; i < count; i++) {
            String rawNumberOne = generateRawNumber(random);
            String rawNumberTwo = generateFormattedNumberString(rawNumberOne);
            mass [0][i] = rawNumberOne;
            mass [1][i] = rawNumberTwo;
        }
        return mass;
    }
    public static void main(String[] args) {
//        System.out.println(validateRawNumber("1234567890"));
//        System.out.println(validateRawNumber("1234567890_"));
//        System.out.println(validateRawNumber("1234567890a"));
//        System.out.println(validateRawNumber("12345678904"));
//        System.out.println(validateRawNumber(null));
//         System.out.println(validateFormattedNumber("+7-904-906-65-89")); // true
//         System.out.println(validateFormattedNumber("+7-000-099-64-89")); // true
//         System.out.println(validateFormattedNumber("r7-000-099-64-89")); // false
//         System.out.println(validateFormattedNumber(null));               // false
//          System.out.println(convertRawToFormatted(null));
//          System.out.println(convertRawToFormatted("9605869954"));
//          System.out.println(convertRawToFormatted("9605869954f"));
//           System.out.println(convertFormattedToRaw("+7-904-906-65-89"));
//           System.out.println(convertFormattedToRaw("+7-904-906-65-895"));
//             System.out.println(generateRawNumber(new Random()));
//             System.out.println(generateRawNumber(new Random()));
//             System.out.println(generateRawNumber(new Random()));
//               System.out.println(generateFormattedNumber(new Random()));
//               System.out.println(generateFormattedNumber(new Random()));
//               System.out.println(generateFormattedNumber(new Random()));
        // для ввода подключаем библиотеку сканер
        Scanner in = new Scanner(System.in);
        System.out.print("Введите ко-во массивов: ");
        int num = in.nextInt();
        System.out.println(Arrays.deepToString(generateNumbers(num,new Random ())));
    }
}