public class Main  {
    public static void main(String[] args){
        ATM cashMachine = new ATM();
        while(true){
            if(cashMachine.countTotalSum()==0){
                int choice = ValueVerifier.intInput(1,2,Msg.EMPTY_ATM);
                if(choice == 1) insertCash(cashMachine);
                else {
                    System.out.println(Msg.GOODBYE);
                    return;
                }
            }
            System.out.println(Msg.MENU);
            int choice = ValueVerifier.intInput(0,3,Msg.MAIN_MENU_INPUT);
            switch (choice){
                case 1 :{ insertCash(cashMachine); break;}
                case 2 :{ withdrawCash(cashMachine); break;}
                case 3: {System.out.println(cashMachine); break;}
                default : {System.out.println(Msg.GOODBYE); return;}
            }
        }
    }
    public static void insertCash(ATM cashMachine){
        int choice = ValueVerifier.intInput(0,4,Msg.INSERT_BILL_CHOICE);
        switch (choice){
            case 1: {insertDifferentBills(cashMachine); break;}
            case 2: {
                int amount =  BillAmountInput();
                cashMachine.insertCash(Bill.HUNDRED,amount);
                break;
            }
            case 3:{
                int amount = BillAmountInput();
                cashMachine.insertCash(Bill.FIFTY,amount);
                break;
            }
            case 4: {
                int amount = BillAmountInput();
                cashMachine.insertCash(Bill.TWENTY, amount);
            }
        }
        System.out.println(cashMachine);
    }

    public static int BillAmountInput(){
        return ValueVerifier.intInput(0,Msg.INSERT_BILL_TYPE_REQUEST+Msg.POSITIVE_NUM_INPUT);
    }
    public static void insertDifferentBills(ATM cashMachine){
        int hundreds = ValueVerifier.intInput(0,Msg.INSERT_HUNDREDS+Msg.POSITIVE_NUM_INPUT);
        int fifties = ValueVerifier.intInput(0,Msg.INSERT_FIFTIES+Msg.POSITIVE_NUM_INPUT);
        int twenties = ValueVerifier.intInput(0,Msg.INSERT_TWENTIES+Msg.POSITIVE_NUM_INPUT);

        cashMachine.insertCash(twenties,fifties,hundreds);
    }

    public static void withdrawCash(ATM cashMachine){
        int choice = ValueVerifier.intInput(0,1,Msg.WITHDRAWAL_MENU);
        if(choice==1) {
            int withdrawal_request = ValueVerifier.intInput(20, Msg.WITHDRAWAL_REQUEST);
            cashMachine.withdrawCash(withdrawal_request);
        }
    }
}