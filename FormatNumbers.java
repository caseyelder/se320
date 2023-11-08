import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Currency;
import java.text.ParseException;

public class FormatNumbers {
    
    public static void main(String[] args){
        UKLocale();
        USLocale();
        ParseNumber();
    }
    
    public static void UKLocale() {
        double number = 12345.678;

        Locale ukLocale = new Locale("en", "UK");
        NumberFormat ukFormat = NumberFormat.getNumberInstance(ukLocale);
        DecimalFormat df = (DecimalFormat) ukFormat;
        df.applyPattern("#,##0.00");

        String formattedNumber = df.format(number);
        System.out.println("Formatted number in UK locale: " + formattedNumber);
    }
    public static void USLocale() {
        double number = 12345.678;

        Locale usLocale = new Locale("en", "US");
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(usLocale);
        Currency usd = Currency.getInstance("USD");
        currencyFormat.setCurrency(usd);

        String formattedCurrency = currencyFormat.format(number);
        System.out.println("Formatted currency in U.S. currency: " + formattedCurrency);
    }
    public static void ParseNumber() {
        String numberString = "12,345.678";

        Locale defaultLocale = Locale.getDefault();
        NumberFormat numberFormat = NumberFormat.getNumberInstance(defaultLocale);

        try {
            Number parsedNumber = numberFormat.parse(numberString);
            double parsedDouble = parsedNumber.doubleValue();
            System.out.println("Parsed number: " + parsedDouble);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}