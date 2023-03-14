package com.msaggik.fourthlessonyoungpaleontologist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class PaleozoicActivity extends AppCompatActivity {

    // задание полей
    private ListView paleozoicList; // поле вывода информации на экран
    private EditText paleozoicIn; // поле ввода новых данных
    private ImageButton btnAdd; // поле кнопки добавить данные
    private ImageButton btnDelete; // поле кнопки удалить данные

    // массив данных животных палеозойского периода
    private ArrayList<String> animal = new ArrayList<String>(); // создание коллекции массива для хранения данных о животных
    private ArrayList<String> selectedAnimal = new ArrayList<String>(); // создание временной коллекции выбранных животных

    // создание адаптера
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paleozoic);

        // присваивание id полям
        paleozoicList = findViewById(R.id.paleozoicList);
        paleozoicIn = findViewById(R.id.paleozoicIn);
        btnAdd = findViewById(R.id.btnAdd);
        btnDelete = findViewById(R.id.btnDelete);

        // добавляем начальные элементы в коллекцию массива данных
        Collections.addAll(animal, "Аномалокарис", "Виваксия", "Нектокарис", "Опабиния", "Камероцерас", "Тиктаалик", "Акантостега", "Капетус");

        // инициализация адаптера (текущий объект активити, стандартный шаблон разметки вывода информации для выбора значений, массив данных)
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, animal);

        // устанавливаем для списка (вывода информации на экран) адаптер
        paleozoicList.setAdapter(adapter);

        // слушатель выбора элементов списка
        paleozoicList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override // (элемент AdapterView, нажатый виджет внутри AdapterView, индекс нажатого виждета внутри AdapterView, идентификатор строки нажатого элемента)
            public void onItemClick(AdapterView<?> adapterView, View v, int position, long l) {
                // получаем выбранный элемент
                String animalItem = adapter.getItem(position); // создание новой переменной и инициализация её выбранным значением
                if(paleozoicList.isItemChecked(position)) // если в чек боксе данного элемента поставлена галочка (isItemChecked() - значение true)
                    selectedAnimal.add(animalItem); // то во временный массив добавится данная переменная
                else { // иначе
                    selectedAnimal.remove(animalItem); // данная переменная удаляется из временного массива
                }
            }
        });

        // обработка нажатия на кнопки
        btnAdd.setOnClickListener(listener);
        btnDelete.setOnClickListener(listener);
    }

    // создание слушателя нажатия кнопок
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnAdd:

                    String animalIn = paleozoicIn.getText().toString(); // считывание вводимого значения из EditText

                    if (!animalIn.isEmpty()) { // если введённое слово не пустое, то
                        adapter.add(animalIn); // добавление в коллекцию массива довых данных
                        paleozoicIn.setText(""); // очищение поля ввода данных
                        adapter.notifyDataSetChanged(); // обновление списка вывода на экран
                    }
                    break;

                case R.id.btnDelete:

                    // получение данные из временного массива и удаление их из постоянного массива
                    for (int i = 0; i < selectedAnimal.size(); i++) {
                        adapter.remove(selectedAnimal.get(i));
                    }
                    selectedAnimal.clear(); // очистка временного массива
                    paleozoicList.clearChoices(); // снятие галочки с выбранных элементов
                    adapter.notifyDataSetChanged(); // // обновление списка вывода на экран
                    break;
            }
        }
    };
}