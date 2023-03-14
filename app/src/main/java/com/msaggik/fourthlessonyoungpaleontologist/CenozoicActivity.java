package com.msaggik.fourthlessonyoungpaleontologist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CenozoicActivity extends AppCompatActivity {

    // задание полей
    private ListView cenozoicList; // поле вывода информации на экран

    // массив данных животных кайнозойского периода
    private String[] arrayCenozoic = {"Глиптодон", "Астрапотерии", "Цератогаулюс", "Сумчатый лев", "Палеопарадоксия", "Дорудон", "Индрикотерий", "Мегатерий"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cenozoic);

        // присваивание id полям
        cenozoicList = findViewById(R.id.cenozoicList);

        // создание адаптера (текущий объект активити, стандартный шаблон разметки вывода информации, массив данных)
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayCenozoic);

        // устанавливаем для списка (вывода информации на экран) адаптер
        cenozoicList.setAdapter(adapter);
    }
}