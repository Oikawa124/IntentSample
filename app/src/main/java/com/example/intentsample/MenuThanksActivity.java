package com.example.intentsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MenuThanksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_thanks);


        // インテントオブジェクトの取得
        Intent intent = getIntent();

        // リスト画面から渡されたデータを取得
        String menuName = intent.getStringExtra("menuName");
        String menuPrice = intent.getStringExtra("menuPrice");

        // 定食名と金額を表示させるtextviewを取得

        TextView tvMenuName = findViewById(R.id.tvmenuName);
        TextView tvMenuPrice = findViewById(R.id.tvMenuPrice);

        // textViewに定食名と金額を表示

        tvMenuName.setText(menuName);
        tvMenuPrice.setText(menuPrice);

    }

    // 戻るボタンをタップ

    public void onbackButton(View view) {
        finish();
    }
}
