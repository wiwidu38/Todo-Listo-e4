package com.example.todolisto;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newTodo(new Todo("Sacar al perro"));
        newTodo(new Todo("comprar el pan"));
        newTodo(new Todo("revisar el correo de la salle"));
        newTodo(new Todo("preparar reuniones del día"));
        newTodo(new Todo("hacer ejercicio"));
    }

    private void newTodo(Todo todo){
        LinearLayout todoListo = (LinearLayout) findViewById(R.id.todoListo);
        GradientDrawable border = new GradientDrawable();
        border.setColor(0xFFFFFFFF);
        border.setStroke(1, 0xFF000000);
        todoListo.setBackground(border);
        LinearLayout todoComposent = new LinearLayout(getApplicationContext());
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        param.bottomMargin = 30;
        todoComposent.setLayoutParams(param);
        todoComposent.setOrientation(LinearLayout.HORIZONTAL);
        TextView textName = new TextView(getApplicationContext());
        LinearLayout.LayoutParams param3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f);
        textName.setLayoutParams(param3);
        textName.setText(todo.getName());
        textName.setTextSize(20);
        todoComposent.addView(textName);
        LinearLayout checkComposent = new LinearLayout(getApplicationContext());
        param = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        checkComposent.setLayoutParams(param);
        checkComposent.setOrientation(LinearLayout.HORIZONTAL);
        checkComposent.setGravity(Gravity.CENTER);
        TextView checkName = new TextView(getApplicationContext());
        checkName.setLayoutParams(new TableLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        checkName.setTextSize(20);
        checkName.setText("realizado ?");
        checkComposent.addView(checkName);
        CheckBox checkBox = new CheckBox(getApplicationContext());
        checkBox.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        checkComposent.addView(checkBox);
        todoComposent.addView(checkComposent);
        todoListo.addView(todoComposent);
    }

    public void addTask(View view) {
        TextView txt = findViewById(R.id.addTaskTextView);
        newTodo(new Todo(txt.getText().toString()));
        return;
    }
}