package util;

public class Util {
    public static String formatCurrency(double salary) {
        return String.format("%,.0f %s", salary, "VNĐ");
    }

    public static String formatCurrency(double salary, String currency) {
        return String.format("%,.0f %s", salary, currency);
    }

}
