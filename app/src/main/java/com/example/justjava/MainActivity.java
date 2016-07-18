package com.example.justjava;

import android.app.Activity;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends Activity {

    int numberOfCoffees = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculatePrice(numberOfCoffees);
        String priceMessage = createOrderSummary(price);
        displayMessage(priceMessage);
    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView order_summary_text_view = (TextView) findViewById(R.id.order_summary_text_view);
        order_summary_text_view.setText(message);
    }
    /**
     * This method is called when the plus button is clicked. asdf
     */
    public void increment(View view) {
        numberOfCoffees = numberOfCoffees + 1;
        display(numberOfCoffees);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view){
            numberOfCoffees = numberOfCoffees - 1;
            display(numberOfCoffees);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * Calculates the price of the order.
     *
     * @param quantity is the number of cups of coffee ordered
     */
    private int calculatePrice(int quantity) {
        int price = quantity * 5;
        return price;
    }

    private String createOrderSummary(int price){
        String message = "Name: Shine Yi\n";
        message += "Quantity: " + numberOfCoffees;
        message += "\nTotal: $" + price;
        message += "\nThank you!";
        return message;
    }

}
