package backlog;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Scanner;

class Customer {
    private String name;
    private boolean member = false;
    private String memberType;

    public Customer(String name, boolean member, String memberType) {
        this.name = name;
        this.member = member;
        this.memberType = memberType;
    }

    public String getName() {
        return name;
    }

    public boolean isMember() {
        return member;
    }

    public void setMember(boolean member) {
        this.member = member;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    @Override
    public String toString() {
        return "backlog.Customer [name='" + name + "', member=" + member + ", memberType='" + memberType + "']";
    }
}

class Visit {
    private Customer customer;
    private Calendar date;
    private int serviceExpense;
    private int productExpense;

    public Visit(Customer customer, Calendar date) {
        this.customer = customer;
        this.date = date;
        Random rand = new Random();
        this.serviceExpense = (rand.nextInt(20) + 1) * 1000; // 1000 ~ 20000
        this.productExpense = (rand.nextInt(20) + 1) * 1000; // 1000 ~ 20000
    }

    public String getName() {
        return customer.getName();
    }

    public Calendar getDate() {
        return date;
    }

    public int getServiceExpense() {
        return serviceExpense;
    }

    public int getProductExpense() {
        return productExpense;
    }

    public int getTotalExpense() {
        double serviceDiscount = DiscountRate.getServiceDiscountRate(customer.getMemberType());
        double productDiscount = DiscountRate.getProductDiscountRate(customer.getMemberType());

        int totalServiceCost = (int) (serviceExpense * (1 - serviceDiscount));
        int totalProductCost = (int) (productExpense * (1 - productDiscount));

        return totalServiceCost + totalProductCost;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/d");
        String formattedDate = sdf.format(date.getTime());

        NumberFormat currencyFormat = NumberFormat.getNumberInstance();
        String formattedServiceExpense = currencyFormat.format(serviceExpense) + " 원";
        String formattedProductExpense = currencyFormat.format(productExpense) + " 원";
        String formattedTotalExpense = currencyFormat.format(getTotalExpense()) + " 원";

        return "backlog.Visit[backlog.Customer=" + customer + ", Date=" + formattedDate +
                ", 제품비용=" + formattedServiceExpense + ", 서비스 비용=" + formattedProductExpense +
                ", 총 사용 비용=" + formattedTotalExpense + "]";
    }
}

class DiscountRate {
    private static final double serviceDiscountPremium = 0.2;
    private static final double serviceDiscountGold = 0.15;
    private static final double serviceDiscountSilver = 0.1;
    private static final double productDiscountPremium = 0.1;
    private static final double productDiscountGold = 0.1;
    private static final double productDiscountSilver = 0.1;

    public static double getServiceDiscountRate(String type) {
        if (type == null) return 0;
        switch (type) {
            case "Premium": return serviceDiscountPremium;
            case "Gold": return serviceDiscountGold;
            case "Silver": return serviceDiscountSilver;
            default: return 0;
        }
    }

    public static double getProductDiscountRate(String type) {
        if (type == null) return 0;
        return 0.1; // 모든 회원에 대해 10% 할인
    }
}

public class Market {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Visit[] visits = new Visit[5]; // 방문 기록을 저장할 배열

        for (int i = 0; i < visits.length; i++) {
            System.out.println("고객의 이름, 회원여부, 등급을 입력하세요");
            String input = scan.nextLine();
            String[] data = input.split(" ");

            String name = data[0];
            boolean isMember = Boolean.parseBoolean(data[1]);
            String memberType = data.length > 2 ? data[2] : null;

            Customer customer = new Customer(name, isMember, memberType);

            Calendar randomDate = new GregorianCalendar(2024, Calendar.JANUARY, new Random().nextInt(31) + 1);
            visits[i] = new Visit(customer, randomDate);
        }

        // 방문 기록 출력
        for (Visit visit : visits) {
            System.out.println(visit);
        }

        scan.close();
    }
}
