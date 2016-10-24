package za.ac.cput.www.assignment6ver2.domain;

/**
 * Created by fatimam on 2016-05-22.
 */
public class AccountType extends Discount {
    private String member;
    private double membership;

    public AccountType() {
    }


    public void memberType(int num) {
        if (num == 1) {
            member = "Silver";
        } else if (num == 2) {
            member = "Gold";
        } else if (num == 3) {
            member = "Platinum";
        } else {
            member = "New";
        }
    }

    public String getMemberType() {
        return member;
    }


    public double getMemberDiscount() {


        if (member.equalsIgnoreCase("Platinum")) {
            membership = getPlatinumClient();
        } else if (member.equalsIgnoreCase("Gold")) {
            membership = getGoldClient();
        } else if (member.equalsIgnoreCase("Silver")) {
            membership = getSilverClient();
        } else {
            membership = getNewClient();
        }
        return membership;
    }




    public static void main(String[]args)
    {
        AccountType acc=new AccountType();

        acc.memberType(2);
        System.out.println(acc.getMemberType()+" "+acc.getMemberDiscount());
    }

}