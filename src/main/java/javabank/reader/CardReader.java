package javabank.reader;

import javabank.domain.Card;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CardReader implements Reader<Card>{
    /**
     * Method that reads a Card from System.in
     * @return Card, representing the read Card
     * @throws IOException, representing an exception
     * @throws ParseException, representing an exception
     */
    @Override
    public Card read() throws IOException, ParseException {
        System.out.println("Please introduce card details!");
        Long idCard = new ReaderID().read();

        String cardNumber;
        System.out.print("Card number: ");
        cardNumber = bufferedReader.readLine();

        String cardHolder;
        System.out.print("Card holder: ");
        cardHolder = bufferedReader.readLine();

        Date validThru;
        SimpleDateFormat formatter = new SimpleDateFormat("MM/yyyy", Locale.ENGLISH);
        String dateInString;
        System.out.print("Expiry date (MM/YYYY): ");
        dateInString = bufferedReader.readLine();
        validThru = formatter.parse(dateInString);

        int cvvCode;
        System.out.print("CVV Code: ");
        cvvCode = Integer.parseInt(bufferedReader.readLine());

        int PIN;
        System.out.print("PIN: ");
        PIN = Integer.parseInt(bufferedReader.readLine());

        Card card = new Card(cardNumber, cardHolder, validThru, cvvCode, PIN);
        card.setId(idCard);
        return card;
    }
}
