public class Msg {
    public static final String STORED_BILLS = "The ATM contains";
    public static final String TOTAL_WITHDRAWAL="SUCCESS! You're total withdrawal is";

    //BILL MESSAGES
    public static final String TWENTIES = "twenties";
    public static final String ONE_TWENTY = "twenty";
    public static final String FIFTIES = "fifties";
    public static final String ONE_FIFTY = "fifty";
    public static final String HUNDREDS = "hundreds";
    public static final String ONE_HUNDRED_BILL = "hundred";


    public static final String EMPTY_ATM = "ATM is currently empty, would you like to insert cash?\n1.Yes\n2.No\n";
    public static final String MENU="1.Insert cash into the ATM\n" +
            "2.Withdraw cash\n" +
            "3.Get contents info\n" +
            "0.Exit";

    public static final String MAIN_MENU_INPUT = "Please, enter integer values between 0 and 3\n";
    public static final String POSITIVE_NUM_INPUT="Please, enter only an integer number, 0 or more\n";

    public static final String INSERT_BILL_CHOICE = "Would you like to insert:\n" +
            "1.Different bills\n"+
            "2.Only $100 bills\n" +
            "3.Only $50 bills\n" +
            "4.Only $20 bills\n" +
            "0.Return\n";
    public static final String INSERT_BILL_TYPE_REQUEST = "How many bills would you like to insert?\n";

    public static final String INSERT_HUNDREDS = "How many $100 would you like to insert?\n";
    public static final String INSERT_FIFTIES = "How many $50 would you like to insert?\n";
    public static final String INSERT_TWENTIES = "How many $20 would you like to insert?\n";

    public static final String WITHDRAWAL_MENU = "1.Withdraw cash\n" +
            "0.Return\n";
    public static final String WITHDRAWAL_REQUEST = "How much cash would you like to withdraw?\n" +
            "(Please, enter an integer number, 20 or more)";

    public static final String GOODBYE = "Thank you for using our ATM, goodbye";
}
