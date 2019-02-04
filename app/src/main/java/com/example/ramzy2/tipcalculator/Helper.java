package com.example.ramzy2.tipcalculator;

import android.content.Intent;

/**
 * Created by Acer on 6/6/2018.
 */

public class Helper {
    private static int bill_amount=0, tips_percent=0, numberOfpeople=1;

    private static double bill=0,tip_amount=0,each_amount=0;

    public static double getBill() {
        return bill;
    }

    public static void setBill(double bill) {
        Helper.bill = bill;
    }

    public static double getTip_amount() {
        return tip_amount;
    }

    public static void setTip_amount(double tip_amount) {
        Helper.tip_amount = tip_amount;
    }

    public static double getEach_amount() {
        return each_amount;
    }

    public static void setEach_amount(double each_amount) {
        Helper.each_amount = each_amount;
    }

    Helper(int amount, int tip, int people)
    {
        bill_amount=amount;
        tips_percent=tip;
        numberOfpeople=people;

    }
    Helper(double a, double b, double c)
    {
        bill=a;
        tip_amount=b;
        each_amount=c;
    }
    Helper()
    {}

    public static int getBill_amount() {
        return bill_amount;
    }

    public static void setBill_amount(int bill_amount) {
        Helper.bill_amount = bill_amount;
    }

    public static int getTips_percent() {
        return tips_percent;
    }

    public static void setTips_percent(int tips_percent) {
        Helper.tips_percent = tips_percent;
    }

    public static int getNumberOfpeople() {
        return numberOfpeople;
    }

    public static void setNumberOfpeople(int numberOfpeople) {
        Helper.numberOfpeople = numberOfpeople;
    }

}
