package com.msaggik.fourthlessonyoungpaleontologist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class SecondActivity extends AppCompatActivity {

    // создание полей
    private ImageButton imageButtonCenozoic;
    private ImageButton imageButtonMesozoic;
    private ImageButton imageButtonPaleozoic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // присваивание id полям
        imageButtonCenozoic = findViewById(R.id.imageButtonCenozoic);
        imageButtonMesozoic = findViewById(R.id.imageButtonMesozoic);
        imageButtonPaleozoic = findViewById(R.id.imageButtonPaleozoic);

        // обработка нажатия кнопки
        imageButtonCenozoic.setOnClickListener(listener);
        imageButtonMesozoic.setOnClickListener(listener);
        imageButtonPaleozoic.setOnClickListener(listener);
    }

    // создание слушателя
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            // переключение на новую активность
            switch (view.getId()) {
                case R.id.imageButtonCenozoic:
                    Intent intentCenozoic = new Intent(getApplicationContext(), CenozoicActivity.class); // переключение на новую активность кайнозойского периода
                    intentCenozoic.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT); // использование флага перемещения нужной активности на вершину стека
                    startActivity(intentCenozoic);
                    break;
                case R.id.imageButtonMesozoic:
                    Intent intentMesozoic = new Intent(getApplicationContext(), MesozoicActivity.class); // переключение на новую активность мезозойского периода
                    intentMesozoic.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // использование флага уничтожения всех активности кроме той которая требуется
                    startActivity(intentMesozoic);
                    break;
                case R.id.imageButtonPaleozoic:
                    Intent intentPaleozoic = new Intent(getApplicationContext(), PaleozoicActivity.class); // переключение на новую активность палеозойского периода
                    intentPaleozoic.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP); // использование флага перехода к нужной активности
                    // без перемещения данной активности в стеке
                    startActivity(intentPaleozoic);
                    break;
            }
        }
    };
}