import java.util.ArrayList;
import java.util.Arrays;

enum Bill{
    TWENTY,
    FIFTY,
    HUNDRED
}
public class ATM {
    private int twenty_bill_amount;
    private int fifty_bill_amount;
    private int hundred_bill_amount;

    private static int total_withdrawal_cash;

    public void insertCash (int twenty_bill_amount, int fifty_bill_amount, int hundred_bill_amount){

        this.twenty_bill_amount+=twenty_bill_amount;
        this.fifty_bill_amount+=fifty_bill_amount;
        this.hundred_bill_amount+=hundred_bill_amount;
    }

    public void insertCash(Bill bill, int amount){
        switch (bill){
            case HUNDRED -> this.hundred_bill_amount+=amount;
            case FIFTY -> this.fifty_bill_amount+=amount;
            case TWENTY -> this.twenty_bill_amount+=amount;
        }
    }

    public void withdrawCash(int withdrawal_request){
        total_withdrawal_cash=withdrawal_request;
        if(!isWithdrawalRequestLessThan20(total_withdrawal_cash)
                &&isThereEnoughCashInATM(total_withdrawal_cash)){
            if(total_withdrawal_cash%20==0){
                withdrawEvenTensCashAmount();
            }
            else if(this.fifty_bill_amount>0 && total_withdrawal_cash>=50){
                withdrawOddTensCashAmount();
            }
            else{
                System.out.println(ErrorMsg.CANT_SPLIT);
            }
        }
        total_withdrawal_cash=0;
    }

    protected void withdrawEvenTensCashAmount(){
        ArrayList<Integer> output_bills = split(total_withdrawal_cash);
        //0 - withdrawal_hundreds; 1-withdrawal_fifties; 2-withdrawal_twenties
        if(!output_bills.isEmpty())
            withdrawalOutput(output_bills.get(0), output_bills.get(1),output_bills.get(2));
    }
    protected void withdrawOddTensCashAmount(){
        //subtracting 50 if withdrawal request tens are odd (e.g. 130 can be split 100+20+10 or 50+20*4)
        this.fifty_bill_amount-=1;
        if((total_withdrawal_cash-=50)>0){
            ArrayList<Integer> output_bills = split(total_withdrawal_cash);
            if(output_bills.isEmpty()) {
                this.fifty_bill_amount+=1;
            }
            else{
                int index = output_bills.get(1);
                output_bills.set(1, index + 1); //add an extra 50 bill to the array
                //0 - withdrawal_hundreds; 1-withdrawal_fifties; 2-withdrawal_twenties
                withdrawalOutput(output_bills.get(0), output_bills.get(1), output_bills.get(2));
            }
        }
        else{
            withdrawalOutput(0, 1,0);
        }
    }
    protected ArrayList<Integer> split(int cash){
        int stored_hundreds=this.hundred_bill_amount;
        int stored_fifties=this.fifty_bill_amount;
        int stored_twenties=this.twenty_bill_amount;
        int withdrawal_hundreds=splitIntoHundreds();
        int withdrawal_fifties=splitIntoFifties();
        int withdrawal_twenties=splitIntoTwenties();
        int remains = cash - withdrawal_twenties*20-withdrawal_fifties*50-withdrawal_hundreds*100;
        if(remains==0){
            return new ArrayList<>(Arrays.asList(withdrawal_hundreds,withdrawal_fifties,withdrawal_twenties));
        }
        else {
            System.out.println(ErrorMsg.BILL_MISMATCH);
            this.hundred_bill_amount=stored_hundreds;
            this.fifty_bill_amount=stored_fifties;
            this.twenty_bill_amount=stored_twenties;
            return new ArrayList<>();
        }
    }

    protected int splitIntoHundreds(){
        int withdrawal_hundreds=0;
        for(; total_withdrawal_cash >= 100&&this.hundred_bill_amount>0; withdrawal_hundreds++){
            total_withdrawal_cash -=100;
            this.hundred_bill_amount-=1;
        }
        return withdrawal_hundreds;
    }

    protected int splitIntoFifties(){
        int withdrawal_fifties=0;
        //using fifties in pairs to compensate for absent hundreds
        for(; total_withdrawal_cash >=100&&this.fifty_bill_amount>1; withdrawal_fifties+=2) {
            total_withdrawal_cash -= 100;
            this.fifty_bill_amount -= 2;
        }
        return withdrawal_fifties;
    }
    protected int splitIntoTwenties(){
        int withdrawal_twenties=0;
        for(; total_withdrawal_cash >= 20&&this.twenty_bill_amount>0; withdrawal_twenties++){
            total_withdrawal_cash -=20;
            this.twenty_bill_amount-=1;
        }
        return withdrawal_twenties;
    }
    public int countTotalSum(){
        return this.twenty_bill_amount*20 + this.fifty_bill_amount*50 + this.hundred_bill_amount*100;
    }


    protected boolean isThereEnoughCashInATM(int withdrawal_request){
        if(countTotalSum()<withdrawal_request){
            System.out.println(ErrorMsg.NOT_ENOUGH_CASH);
            return false;
        }
        return true;
    }
    protected boolean isWithdrawalRequestLessThan20(int withdrawal_request){
        if(withdrawal_request<20){
            System.out.println(ErrorMsg.LESS_THAN_20);
            return true;
        }
        return false;
    }
    protected void withdrawalOutput(int withdrawal_hundreds, int withdrawal_fifties, int withdrawal_twenties){
        System.out.println(Msg.TOTAL_WITHDRAWAL+" "
                +withdrawal_hundreds+" "
                +((withdrawal_hundreds==1)? Msg.ONE_HUNDRED_BILL:Msg.HUNDREDS)+" "
                +withdrawal_fifties+" "
                +((withdrawal_fifties==1)? Msg.ONE_FIFTY:Msg.FIFTIES)+" "
                +withdrawal_twenties+" "
                +((withdrawal_twenties==1)? Msg.ONE_TWENTY:Msg.TWENTIES));
    }
    @Override
    public String toString(){
        return Msg.STORED_BILLS +" "
                +this.hundred_bill_amount+" "
                +((this.hundred_bill_amount==1)? Msg.ONE_HUNDRED_BILL:Msg.HUNDREDS)+" "
                +this.fifty_bill_amount+" "
                +((this.fifty_bill_amount==1)? Msg.ONE_FIFTY:Msg.FIFTIES)+" "
                +this.twenty_bill_amount+" "
                +((this.twenty_bill_amount==1)? Msg.ONE_TWENTY:Msg.TWENTIES);
    }
}