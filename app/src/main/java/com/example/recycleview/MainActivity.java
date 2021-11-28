package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.recycleview.databinding.ActivityMainBinding;
import com.example.recycleview.utils.FileUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private BookModel item;

    private final Gson gson = new Gson();
    private final String BOOK_FILENAME = "book_data.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        File book = new File(getFilesDir(), BOOK_FILENAME);
        if (!book.exists()) {
            String bookJson = readFromAssets(this, "books.json");
            List<BookModel> array = gson.fromJson(bookJson, new TypeToken<List<BookModel>>(){
            }.getType());
        }

        ArrayList<String> data = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            data.add(String.format("%d번 입니다", i));
        }

        StudeAdapter adapter = new StudeAdapter(data);
        binding.recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.recyclerView.setLayoutManager(layoutManager);

    }
    public String readFromAssets(String name) throws IOException {
        InputStream inputStream = getAssets().open(name);
        return FileUtils.readStream(inputStream);
    }







}