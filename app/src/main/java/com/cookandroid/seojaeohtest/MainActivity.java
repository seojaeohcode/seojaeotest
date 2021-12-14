package com.cookandroid.seojaeohtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView.Adapter adapter, adapter2;
private RecyclerView recyclerViewCategoryList, recyclerViewPopularList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
        recyclerViewPopular();
    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList=findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<EngineDomain> enginelist = new ArrayList<>();
        enginelist.add(new EngineDomain("Unity", "unitybox","developer: Unity Technologies, language:c#, major work:(ori,pokemon go...), last ver:2021.1.14", 2160.0));
        enginelist.add(new EngineDomain("unreal", "unrealbox","developer: Epic Games , language:(c++,unrealscript,python..), major work:(Lineage,outlast...), last ver:5.0.0", 1500.0));
        enginelist.add(new EngineDomain("rpgVX", "rpgmakerbox","developer: KADOKAWA, language:ruby, pitted kalmata, major work:(Lisa,paranomal syndrome...), last ver:MZ", 82.0));

        adapter2 = new PopularAdapter(enginelist);
        recyclerViewPopularList.setAdapter(adapter2);
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList=findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("game", "gicon"));
        categoryList.add(new CategoryDomain("app", "aicon"));
        categoryList.add(new CategoryDomain("web", "wicon"));
        categoryList.add(new CategoryDomain("database", "dicon"));
        categoryList.add(new CategoryDomain("machine", "micon"));

        adapter = new CategoryAdapter(categoryList);
        recyclerViewCategoryList.setAdapter(adapter);
    }
}