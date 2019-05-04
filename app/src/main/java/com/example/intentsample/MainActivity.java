package com.example.intentsample;

import android.app.LauncherActivity;
import android.content.Intent;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 画面部品ListViewを取得。
        ListView lvMenu = findViewById(R.id.lvMenu);

        // SimpleAdapterで使用するListオブジェクトを用意。
        List<Map<String, String>> menuList = new ArrayList<>();

        // 定食のデータを格納する
        Map<String, String> menu = new HashMap<>();
        menu.put("name", "唐揚げ定食");
        menu.put("price", "800円");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "ハンバーグ定食");
        menu.put("price", "940円");
        menuList.add(menu);

        // SimpleAdapterの第4引数の用意
        String[] from = {"name", "price"};

        // SimpleAdapterの第5引数の用意
        int[] to = {android.R.id.text1, android.R.id.text2};
        // text1, text2とは一体・・・

        // SimpleAdapterの生成

        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, menuList,
                android.R.layout.simple_list_item_2, from, to);

        // アダプタの登録
        lvMenu.setAdapter(adapter);
        lvMenu.setOnItemClickListener(new ListItemClickListener());

    }

    private class ListItemClickListener implements android.widget.AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            // タップされた行のデータを取得
            Map<String, String> item = (Map<String, String>) parent.getItemAtPosition(position);

            // 定食と金額を取得

            String menuName = item.get("name");
            String menuPrice = item.get("price");

            // インテントオブジェクトを生成
            Intent intent = new Intent(MainActivity.this, MenuThanksActivity.class);

            // 第2画面に送るデータを格納
            intent.putExtra("menuName", menuName);
            intent.putExtra("menuPrice", menuPrice);

            startActivity(intent);
        }
    }
}
