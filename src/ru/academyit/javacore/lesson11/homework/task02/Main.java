package ru.academyit.javacore.lesson11.homework.task02;

// Дано предложение. Необходимо проверить его на наличие ошибок в буквосочетании «жи» и «ши» и исправить их.
public class Main {

    public static void main(String[] args) {

        String strSource = "У Дашы жывёт кот Рыжык. Он рыжый и пушистый. " +
                "Рыжык часто сидит на крыльце. А под крыльцом мышы. Кот чует добычу.Ж";

        assert spellCheck(strSource).equals("У Даши живёт кот Рыжик. Он рыжий и пушистый. " +
                "Рыжик часто сидит на крыльце. А под крыльцом мыши. Кот чует добычу.Ж");

        String strResult = spellCheck(strSource);
        System.out.printf("Исходная строка: %s\nРезультат: %s", strSource, strResult);
    }

    /**
     * Проверяет правописание строки.
     * @param s строка для проверки
     * @return исправленная строка
     */
    private static String spellCheck(String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            try {
                if (charArray[i] == 'ж' || charArray[i] == 'Ж' || charArray[i] == 'ш' || charArray[i] == 'Ш') {
                    if (charArray[i + 1] == 'ы') {
                        charArray[i + 1] = 'и';
                    } else if (charArray[i + 1] == 'Ы') {
                        charArray[i + 1] = 'И';
                    }
                }
            } catch (ArrayIndexOutOfBoundsException ignore){}
        }
        return String.valueOf(charArray);
    }

}
