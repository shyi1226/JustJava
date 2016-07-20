package com.example.justjava;

import android.app.Activity;
import android.os.Bundle;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends Activity {

    int numberOfCoffees = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText text = (EditText) findViewById(R.id.name_field);
        String nameValue = text.getText().toString();

        CheckBox creamCheck = (CheckBox) findViewById(R.id.whipped_cream);
        CheckBox chocoCheck = (CheckBox) findViewById(R.id.topping_chocolate);
        boolean hasWhippedCream = creamCheck.isChecked();
        boolean hasChocolate = chocoCheck.isChecked();

        int price = calculatePrice(numberOfCoffees, hasWhippedCream, hasChocolate);
        String priceMessage = createOrderSummary(price, nameValue, hasWhippedCream, hasChocolate);
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
        if(numberOfCoffees==100){
            Toast.makeText(this, "You cannot have more than 100 coffees", Toast.LENGTH_SHORT).show();
            return;
        }
        numberOfCoffees = numberOfCoffees + 1;
        display(numberOfCoffees);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view){
        if(numberOfCoffees==1) {
            Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
            return;
        }
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
    private int calculatePrice(int quantity, boolean hasWhippedCream, boolean hasChocolate) {
        int price = quantity * 5;

        if(hasWhippedCream){
            price = price+1;
        }

        if(hasChocolate){
            price = price+2;
        }
        return price;
    }

    private String createOrderSummary(int price, String nameValue, boolean hasWhippedCream, boolean hasChocolate){
        String message = "Name: " + nameValue;
        message += "\nAdd whipped cream? " + hasWhippedCream;
        message += "\nAdd chocolate? " + hasChocolate;
        message += "\nQuantity: " + numberOfCoffees;
        message += "\nTotal: $" + price;
        message += "\nThank you!";
        return message;
    }

}
