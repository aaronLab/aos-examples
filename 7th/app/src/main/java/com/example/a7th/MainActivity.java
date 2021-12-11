package com.example.a7th;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

class MyView extends View {

    int key;
    String str;
    int x, y;

    public MyView(Context context) {
        super(context);

        setBackgroundColor(Color.YELLOW);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = (int) event.getX();
        y = (int) event.getY();

        invalidate();

        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        @SuppressLint("DrawAllocation") Paint paint = new Paint();
        paint.setTextSize(50);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(20);
        canvas.drawLine(100, 900, 700, 900, paint);
//        canvas.drawCircle(x, y, 30, paint);
        canvas.drawCircle(300, 1200, 200, paint);
//        canvas.drawText(x + "," + y, x, y + 100, paint);

        super.onDraw(canvas);
    }
}

class YourView extends View {

    int key;
    String str;
    int x, y;

    public MyView(Context context) {
        super(context);

        setBackgroundColor(Color.YELLOW);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = (int) event.getX();
        y = (int) event.getY();

        invalidate();

        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        @SuppressLint("DrawAllocation") Paint paint = new Paint();
        paint.setTextSize(50);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(20);
        canvas.drawLine(100, 900, 700, 900, paint);
//        canvas.drawCircle(x, y, 30, paint);
        canvas.drawCircle(300, 1200, 200, paint);
//        canvas.drawText(x + "," + y, x, y + 100, paint);

        super.onDraw(canvas);
    }
}

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        MyView view = new MyView(this);
        setContentView(view);
//        configureButton();
    }

    // Configure Button
    private void configureButton() {
        button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "Button Pressed!",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
