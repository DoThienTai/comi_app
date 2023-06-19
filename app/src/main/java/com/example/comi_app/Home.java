package com.example.comi_app;

import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ListView listView;
    RecyclerView recyclerView;
    List<Comic> ls =new ArrayList<>();
    ComicAdapter comicAdapter;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        listView = findViewById(R.id.listView);
        recyclerView = (RecyclerView) findViewById(R.id.rcv_comic);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        searchView.clearFocus();
        actionBar();

        ls.add(new Comic("Đồng cỏ","Ray Bradbury", "https://www.ikkaro.com/wp-content/uploads/2016/09/la-pradera-al-parker-400x574.jpg", "Bấy giờ, những bộ phận phát âm thanh và mùi vị, đặt giấu ở đâu" +
                ", bắt đầu thổi một làn gió đầy hương vị đến hai người ở giữa cánh đồng nung cháy.  " +
                "Mùi rơm nóng của cỏ sư tử, mùi xanh mát của một ao nước đâu đó, mùi khét nồng của súc vật, mùi bụi cay hăng như ớt trong không khí nóng." +
                "  Rồi đến những âm thanh:  tiếng chân hươu chạy thùm thụp từ đồng cỏ phía xa, tiếng xoàn xoạt như vò giấy của bầy kên kên." +
                "  Một bóng đen vụt ngang bầu trời.  Cái bóng chớp trên khuôn mặt ngước ngửa đẫm mồ hôi của Hoạt."));
        ls.add(new Comic("Đồng cỏ","Ray Bradbury", "https://www.ikkaro.com/wp-content/uploads/2016/09/la-pradera-al-parker-400x574.jpg", "Bấy giờ, những bộ phận phát âm thanh và mùi vị, đặt giấu ở đâu" +
                ", bắt đầu thổi một làn gió đầy hương vị đến hai người ở giữa cánh đồng nung cháy.  " +
                "Mùi rơm nóng của cỏ sư tử, mùi xanh mát của một ao nước đâu đó, mùi khét nồng của súc vật, mùi bụi cay hăng như ớt trong không khí nóng." +
                "  Rồi đến những âm thanh:  tiếng chân hươu chạy thùm thụp từ đồng cỏ phía xa, tiếng xoàn xoạt như vò giấy của bầy kên kên." +
                "  Một bóng đen vụt ngang bầu trời.  Cái bóng chớp trên khuôn mặt ngước ngửa đẫm mồ hôi của Hoạt."));
        ls.add(new Comic("Đồng cỏ","Ray Bradbury", "https://www.ikkaro.com/wp-content/uploads/2016/09/la-pradera-al-parker-400x574.jpg", "Bấy giờ, những bộ phận phát âm thanh và mùi vị, đặt giấu ở đâu" +
                ", bắt đầu thổi một làn gió đầy hương vị đến hai người ở giữa cánh đồng nung cháy.  " +
                "Mùi rơm nóng của cỏ sư tử, mùi xanh mát của một ao nước đâu đó, mùi khét nồng của súc vật, mùi bụi cay hăng như ớt trong không khí nóng." +
                "  Rồi đến những âm thanh:  tiếng chân hươu chạy thùm thụp từ đồng cỏ phía xa, tiếng xoàn xoạt như vò giấy của bầy kên kên." +
                "  Một bóng đen vụt ngang bầu trời.  Cái bóng chớp trên khuôn mặt ngước ngửa đẫm mồ hôi của Hoạt."));
        ls.add(new Comic("Đồng cỏ","Ray Bradbury", "https://www.ikkaro.com/wp-content/uploads/2016/09/la-pradera-al-parker-400x574.jpg", "Bấy giờ, những bộ phận phát âm thanh và mùi vị, đặt giấu ở đâu" +
                ", bắt đầu thổi một làn gió đầy hương vị đến hai người ở giữa cánh đồng nung cháy.  " +
                "Mùi rơm nóng của cỏ sư tử, mùi xanh mát của một ao nước đâu đó, mùi khét nồng của súc vật, mùi bụi cay hăng như ớt trong không khí nóng." +
                "  Rồi đến những âm thanh:  tiếng chân hươu chạy thùm thụp từ đồng cỏ phía xa, tiếng xoàn xoạt như vò giấy của bầy kên kên." +
                "  Một bóng đen vụt ngang bầu trời.  Cái bóng chớp trên khuôn mặt ngước ngửa đẫm mồ hôi của Hoạt."));
        ls.add(new Comic("Cây khế", "No Body", "https://truyencotich.vn/wp-content/uploads/2012/10/11284_full-660x440.jpg","Một nhà kia có hai anh em, cha mẹ đều chết cả. Hai anh em chăm lo làm lụng" +
                ", nên trong nhà cũng đủ ăn. Muốn cho vui cửa vui nhà" +
                ", hai người cùng lấy vợ. Nhưng từ khi có vợ, người anh sinh ra lười biếng, bao nhiêu công việc khó nhọc, đều trút cả cho hai vợ chồng người em," +
                "Hai vợ chồng người em thức khuya dậy sớm" +
                ", lại cố gắng cày cấy, làm cỏ, bỏ phân, lúa tốt hơn trước, nên đến mùa, được bội thu." +
                " Thấy thế, người anh sợ em kể công chiếm lấy phần hơn," +
                " vội bàn với vợ cho hai vợ chồng người em ra ở riêng."));
        ls.add(new Comic("Cây khế", "No Body", "https://truyencotich.vn/wp-content/uploads/2012/10/11284_full-660x440.jpg","Một nhà kia có hai anh em, cha mẹ đều chết cả. Hai anh em chăm lo làm lụng" +
                ", nên trong nhà cũng đủ ăn. Muốn cho vui cửa vui nhà" +
                ", hai người cùng lấy vợ. Nhưng từ khi có vợ, người anh sinh ra lười biếng, bao nhiêu công việc khó nhọc, đều trút cả cho hai vợ chồng người em," +
                "Hai vợ chồng người em thức khuya dậy sớm" +
                ", lại cố gắng cày cấy, làm cỏ, bỏ phân, lúa tốt hơn trước, nên đến mùa, được bội thu." +
                " Thấy thế, người anh sợ em kể công chiếm lấy phần hơn," +
                " vội bàn với vợ cho hai vợ chồng người em ra ở riêng."));

        comicAdapter = new ComicAdapter(Home.this,ls);
        recyclerView.setAdapter(comicAdapter);
        //hiding the title bar



    }



    private void actionBar() {
        setSupportActionBar(toolbar);

        navigationView.setNavigationItemSelectedListener(this);
        //icon
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.email);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu,menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView =(SearchView) menu.findItem(R.id.action_search).getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                comicAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                comicAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return true;
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        if (item.getItemId() == R.id.logout) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Bạn có chắc chắn muốn thoát khỏi ứng dụng? ");
            builder.setCancelable(true);

            builder.setPositiveButton(
                    "có",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Intent intent = new Intent(Home.this, Login.class);
                            startActivity(intent);
                        }
                    });

            builder.setNegativeButton(
                    "Không",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            AlertDialog alert = builder.create();
            alert.show();
        }
        return true;
    }



    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}