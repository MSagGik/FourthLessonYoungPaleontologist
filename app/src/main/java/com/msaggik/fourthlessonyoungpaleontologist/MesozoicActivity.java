package com.msaggik.fourthlessonyoungpaleontologist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MesozoicActivity extends AppCompatActivity {

    // задание полей
    private ListView mesozoicList; // поле вывода информации на экран
    private TextView mesozoicOut; // поле вывода выбранного значения с ListView

    // массив данных животных кайнозойского периода
    private String[] arrayMesozoic = {"Аллозавр", "Велоцираптор", "Диплодок", "Стегозавр", "Цзяньчанозавр", "Ютараптор", "Мегалодон"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesozoic);

        // присваивание id полям
        mesozoicList = findViewById(R.id.mesozoicList);
        mesozoicOut = findViewById(R.id.mesozoicOut);

        // создание адаптера (текущий объект активити, стандартный шаблон разметки вывода информации, массив данных)
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayMesozoic);

        // устанавливаем для списка (вывода информации на экран) адаптер
        mesozoicList.setAdapter(adapter);

        // создадим слушатель выбора элементов списка
        mesozoicList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override // (элемент AdapterView, нажатый виджет внутри AdapterView, индекс нажатого виждета внутри AdapterView, идентификатор строки нажатого элемента)
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // считываем выбранный индекс из массива данных
                String selectedItem = arrayMesozoic[position];
                // вывод в окно TextView выбранного животного
                mesozoicOut.setText(selectedItem);
            }
        });
    }
}