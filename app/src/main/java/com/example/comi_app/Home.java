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

        ls.add(new Comic("Miệng kẻ sang","cotich.net ", "https://cotich.net/uploads/news/a_738690227_mieng-ke-sang.jpg", "Bấy giờ Quỳnh đã hơi lớn, đang độ thiếu niên. Trên đường từ phủ về khát quá, Quỳnh vào một quán nước bên đường. Trong quán có một viên quan, dáng oai vệ, đang ngồi nhai trầu bỏm bẻm. Cạnh đó, có một lính vệ đứng hầu. Quan nhai xong, hách dịch vứt miếng bã trầu ra đất.\n" +
                "\n" +
                "Quỳnh đang ngồi uống nước, thấy ngứa mắt liền bước lại cúi nhặt lên, ngắm nghía như muốn tìm kiếm cái gì, rồi đút vào túi.\n" +
                "\n" +
                "Quan thấy lạ, hỏi:\n" +
                "\n" +
                "– Mày là ai? Làm gì vậy?\n" +
                "\n" +
                "Quỳnh làm bộ khúm núm đáp:\n" +
                "\n" +
                "– Bẩm, con là học trò nghèo, lâu nay thường nghe người ta nói “Miệng nhà quan có gang có thép” muốn nhặt lên đem về coi thử có đúng thế không?\n" +
                "\n" +
                "Biết mình bị xỏ, lại không biết tên học trò xấc xược này là Quỳnh, quan liền bảo:\n" +
                "\n" +
                "– Đã xưng là học trò thì người phải đối ngay câu tục ngữ mà người vừa nói đó đi, hay thì ta thưởng, dở sẽ đánh đòn. Mà nhớ là tục ngữ phải đối bằng tục ngữ, nghe chưa!\n" +
                "\n" +
                "Quỳnh giả bộ rụt rè, thưa thưa bẩm bẩm:\n" +
                "\n" +
                "– Con sợ mang tiếng xấc xược… Không dám đối.\n" +
                "\n" +
                "Tưởng anh chàng học trò đang bí, quan bảo:\n" +
                "\n" +
                "– Ta cho người cứ nói, còn đối không được thì nằm xuống để ta đánh đòn.\n" +
                "\n" +
                "– Nếu thế thì con xin đối ạ.\n" +
                "\n" +
                "– Được. Đối ngay đi, ta nghe thử!\n" +
                "\n" +
                "Quỳnh thong thả đọc vế đối:\n" +
                "\n" +
                "– “Đồ nhà khó vừa nhọ vừa thâm.”\n" +
                "\n" +
                "Nghe xong, mặt quan xám lại như tro bếp. Câu đối lại đúng là câu tục ngữ, không thể bắt bẻ vào đâu được.\n" +
                "\n" +
                "Biết ngồi lâu không tiện, quan giục lính hầu ra đi, quên bẵng lời hứa thưởng tiền cho anh học trò nghèo.\n" +
                "\n" +
                "Chẳng bao lâu, chuyện ấy lan ra khắp vùng, tên quan kia thì xấu hổ vì làm miệng cười cho thiên hạ còn tiếng tăm của Quỳnh thì nổi như cồn."));
        ls.add(new Comic("Poseidon và Apollo","no body", "https://cotich.net/uploads/news/a_567646228_poseidon-va-apollo.jpg", "POSEIDON (Thần thoại La Mã gọi là Neptune) là vị thần của cai quản biển cả bao gồm các đại dương, hải đảo và các bờ biển. Mặc dù ông là một trong những vị thần tối cao của núi Olympus, nhưng phần lớn thời gian ông ở trong lãnh thổ của mình dưới sâu tận đáy biển của mình.\n" +
                "\n" +
                "Poseidon là anh của thần Zeus và thần Hades. Ba vị thần năng chia nhau những quyền năng sáng tạo : thần Zeus thống trị bầu trời, thần Hades cai quản địa ngục và Poseidon được giao cho tất cả những gì thuộc về nước – cả sông và biển.\n" +
                "\n" +
                "Với vẻ đẹp rực rỡ của một vị thần hùng mạnh cai trị biển cả, " +
                "Poseidon có một cung điện tráng lệ nguy nga dưới đáy biển sâu." +
                " Mỗi khi Thần Poseidon trầm lặng, uy nghi ngồi trên chiếc xe do những con hải sư dũng mãnh kéo chạy trên mặt biển mênh mông, " +
                "khi đó thì sóng biển dạt sang hai bên nhường đường cho thần, xung quanh có những con cá heo nhào lộn đón mừng và từng đàn cá tung tăng bám theo cỗ xe thần thánh." +
                " Khi Poseidon khua chiếc đinh ba xuống mặt nước thì biển cả dậy sóng, bão tố kinh hoàng, gây nên nhựng cơn địa chấn rung chuyển mặt đất." +
                " Nhưng khi thần chĩa đinh ba lên đầu các ngọn sóng thì chúng ngoan ngoãn dịu đi. Bão tố ngừng thổI và mặt biển trở nên êm dịu hiền hoà như cũ." +
                " Chính tay Poseidon chặt ngang các lục địa tạo thành những eo biển, cửa sông. Thần cũng tự tay phát ra các mạch nước nguồn, làm nổi lên những hải đảo." +
                " Cũng chính Poseidon đã giữ gìn cho các lục địa khỏi sụp đổ."));
        ls.add(new Comic("Biên niên sử nhà Kane – Kim tự tháp đỏ","Rick Riordan", "https://isach.info/images/story/cover/bien_nien_su_nha_kane_1_kim_tu_thap_do__rick_riordan.jpg", "CHÚNG TÔI CHỈ CÓ MỘT VÀI TIẾNG THÔI, vì thế hãy nghe cho kỹ nhé.\n" +
                "Nếu bạn đang nghe câu chuyện này, bạn đang gặp nguy hiểm. Sadie và tôi có thể là cơ hội duy nhất dành cho bạn.\n" +
                "\n" +
                "Hãy đi đến trường. Tìm chiếc tủ có khóa. Tôi sẽ không nói cho bạn đó là ngôi trường nào và chiếc tủ nào, vì nếu bạn chính là người đó, bạn sẽ tìm thấy được. Dãy số dùng để mở ở khóa là 13/32/33. Vào thời điểm bạn nghe xong đoạn băng này, bạn sẽ biết những con số đó có nghĩa là gì. Nhưng hãy nhớ câu chuyện chúng tôi sắp kể cho bạn hoàn toàn chưa kết thúc. Nó kết thúc như thế nào phụ thuộc vào bạn.\n" +
                "\n" +
                "Điều quan trọng nhất là: khi bạn mở gói hàng và tìm thấy thứ bên trong, đừng giữ nó lâu hơn một tuần. Đương nhiên, sẽ cám dỗ lắm đấy. Ý tôi là, nó sẽ mang đến cho bạn một sức mạnh gần như không giới hạn. Nhưng nếu bạn sở hữu nó quá lâu, nó sẽ phá hủy bạn. Hãy nhanh chóng khám phá các bí mật và gửi nó đi. Hãy giấu nó cho một người tiếp theo, cách mà Sadie và tôi đã làm cho bạn. Rồi hãy chuẩn bị cho việc cuộc đời bạn sẽ trở nên vô cùng thú vị.\n" +
                "Được rồi, Sadie đang bảo tôi ngừng vòng vo mà hãy bắt đầu câu chuyện. Tốt thôi. Tôi nghĩ câu chuyện bắt đầu xảy ra ở London, cái đêm mà cha tôi đã làm nổ tung Bảo tàng Anh.\n" +
                "\n" +
                "Tôi là Carter Kane. Tôi 14 tuổi và nhà tôi là một cái vali.Bạn nghĩ tôi đang nói đùa sao? Kể từ lúc tôi lên 8, cha tôi và tôi đã chu du khắp thế giới. " +
                "Tôi sinh ra ở L.A (Los Angeles - người đánh máy) nhưng cha tôi là một nhà khảo cổ, vì vậy công việc đưa ông đi khắp nơi. Phần lớn chúng tôi đến Ai Cập, vì đó là chuyên ngành của ông. " +
                "Hãy đi vào một nhà sách, tìm một cuốn sách viết về Ai Cập, khả năng khá cao là cuốn sách do Tiến sĩ Julius Kane viết. " +
                "Bạn muốn biết cách những người Ai Cập lôi các bộ não ra khỏi xác ướp, hoặc xây kim tự tháp, hay ếm bùa lăng mộ của vua Tut ư? " +
                "Dĩ nhiên, có nhiều nguyên nhân khác cho việc cha tôi phải di chuyển khắp nơi quá nhiều như thế, nhưng khi đấy thì tôi chẳng biết gì đến bí mật của ông cả."));
        ls.add(new Comic("Lừa và ngựa","Ngụ ngôn nhân gian", "https://cotich.net/uploads/news/a_606246469_lua-va-ngua.jpeg", "Có chú Lừa đi cùng một con Ngựa trông sang trọng bảnh bao lắm. Trên lưng ngựa chỉ có bộ yên thồ hàng, còn trên lưng Lừa lại chồng chất hàng hoá nặng đến mức nó không chịu nổi. Lừa cầu xin Ngựa chia sẻ giúp nó một chút gánh nặng nếu không nó sẽ chết gục trước khi tới được thành phố. Nói nói:\n" +
                "\n" +
                "- Cầu xin anh giúp tôi với một nửa gánh nặng này, đối với anh cũng chỉ như trò đùa thôi.\n" +
                "\n" +
                "Ngựa ta nghe xong từ chối thẳng thừng, thậm chí còn phì một tràng hơi vào mặt anh bạn đồng hành.\n" +
                "\n" +
                "Lừa không chịu thêm được gánh nặng trên vai, nó đã gục ngã. Sau đó, con ngựa đã phải chở toàn bộ số hàng, và còn thêm cả bộ da lừa nữa. "));
        ls.add(new Comic("Ăn mày xin vàng", "No Body", "https://cotich.net/uploads/news/a_788118988_an-may-xin-vang.jpg","Phú ông nọ giàu có nhất trong vùng nhưng rất hà tiện. Bao nhiêu vàng bạc, ông giấu cất trong nhà, không đem bố thí cho một ai.\n" +
                "\n" +
                "Hôm ấy, có lão ăn mày đến năn nỉ phú ông mà xin cho kỳ một nén vàng. Phú ông quát tháo, sai người đuổi đi. Nhưng lão ấy vẫn gan lì trở lại xin vàng, ngày này qua ngày khác, năm này qua năm khác. Rốt cuộc phú ông cho lão một nén rồi sai người đầy tớ theo rình. Ban đầu lão ăn mày mừng rỡ, cười hớn hở.\n" +
                "\n" +
                "Nhưng đến khoảng đất trống, lão đặt nén vàng bên mình rồi ngủ khì. Tên đầy tớ bèn lén lại gần ăn cắp nén vàng nọ đem về cho chủ. Hôm sau, lão ăn mày trở lại nhà phú ông xin vàng như cũ. Phú ông nói:\n" +
                "\n" +
                "– Hôm qua tôi cho ông một nén đâu rồi.\n" +
                "\n" +
                "Ông lão ăn mày vuốt râu rồi trả lời:\n" +
                "\n" +
                "– Tôi để nó kế bên mình. Nhưng khi tôi vừa nhắm mắt thì nó cũng mất đi. Bởi vậy tôi trở lại.\n" +
                "\n" +
                "Phú ông suy nghĩ về câu nói của lão ăn mày, hiểu rằng khi nhắm mắt chết thì sự nghiệp không còn gì hết. " +
                "Ông bèn đem vàng bạc dùng vào việc phước thiện. Gặp những người trong vùng, phú ông thuật lại chuyện lão ăn mày nọ. " +
                "Ai nấy đoán rằng: “Không chừng lão ấy là Tiên trá hình để răn đời."));
        ls.add(new Comic("Ông già và biển cả", "Ernest Hemingway", "https://cdn.khosachonline.com/uploads/2020/01/386/ong-gia-va-bien-ca.jpg","Lão đã già, một mình một thuyền câu cá trên dòng Nhiệt lưu và đã tám mươi tư ngày qua lão không bắt được lấy một mống cá nào. Bốn mươi ngày đầu thằng bé đi với lão. Nhưng sau bốn mươi ngày không câu được cá, cha mẹ thằng bé bảo nó rằng rốt cuộc bây giờ ông lão đã hoàn toàn salao, cách diễn đạt tệ nhất của vận rủi, rồi buộc nó đi theo thuyền khác và ngay trong tuần lễ đầu tiên chiếc thuyền ấy đã câu được ba con cá lớn. Điều đó khiến thằng bé buồn khi hằng ngày thấy ông lão trở về với chiếc thuyền không, nó luôn xuống giúp lão mang khi thì cuộn dây, cái lao móc săn cá, khi thì cái sào hay tấm buồm quấn quanh cột. Tấm buồm được vá bằng bao bột, cuộn lại trông như một lá cờ bại trận triền miên. ông lão gầy gò, giơ cả xương, gáy hằn sâu nhiều nếp nhăn. Những vệt nám vô hại trên làn da má của lão do bị ung thư bởi ánh mặt trời phản hồi trên mặt biển nhiệt đới. Những vệt ấy kéo dài xuống cả hai bên má, tay lão hằn những vết sẹo sâu bởi kéo những con cá lớn. Nhưng chẳng có vết nào trong số sẹo ấy còn mới cả. Chúng cũ kỹ như mấy vệt xói mòn trên sa mạc không cá. Mọi thứ trên cơ thể lão đều toát lên vẻ già nua, trừ đôi mắt, chúng có cùng màu với nước biển, vui vẻ và không hề thất bại.\n" +
                "\n" +
                "Ông Santiago, thằng bé nói khi hai người leo lên bờ nơi con thuyền được kéo lên:\n" +
                "\n" +
                "-Cháu có thể lại đi cùng ông. Chúng ta đã có ít tiền rồi.\n" +
                "\n" +
                "ông lão dạy thằng bé câu cá và nó quý lão.\n" +
                "Đừng\n" +
                "lão nói:\n" +
                "\n" +
                "-Cháu đang đi với con thuyền may mắn. Hãy ở lại với họ.Nhưng ông còn nhớ có hồi suốt tám mươi bảy ngày ta không bắt được cá nhưng sau đó trong ba tuần lễ ngày nào ta cũng vớ được cá lớn.\n" +
                "\n" +
                "ông nhớ\n" +
                "ông lão nói:\n" +
                "-ông biết cháu đã không rời bỏ ông vì thiếu lòng tin.Tại cha cháu bắt làm như thế. Cháu còn nhỏ, cháu phải nghe lời cha, ông hiểu\n" +
                "ông lão nói:\n" +
                "Đấy là chuyện thường\n" +
                "Cha cháu chẳng tin đâu\n" +
                "Phải\n" +
                "ông lão nói."));
        ls.add(new Comic("Nhà giả kim", "Paulo Coelho", "https://upload.wikimedia.org/wikipedia/vi/thumb/9/9c/Nh%C3%A0_gi%E1%BA%A3_kim_%28s%C3%A1ch%29.jpg/150px-Nh%C3%A0_gi%E1%BA%A3_kim_%28s%C3%A1ch%29.jpg","Nhà luyện kim đan cầm lấy quyển sách mà một người trong đoàn lữ hành mang theo. Quyển sách đã cũ và long gáy nhưng ông vẫn đọc được tên tác giả : Oscar Wilde. Mở ra đọc, ông thấy có một câu chuyện về hoa thủy tiên. Dĩ nhiên, ông không lạ gì truyền thuyết về chàng Narziss xinh trai, ngày ngày soi mặt trên hồ nước để tự chiêm ngưỡng sắc đẹp của mình. Chàng say mê chính mình đến nỗi một ngày kia nghiêng quá đà, ngã xuống hồ và chết đuối. Thế là từ nơi đó mọc lên một bông hoa đẹp, mang tên chàng Narziss nọ. Nhưng Oscar Wilde không kết thúc câu chuyện như thế mà kể rằng sau khi chàng chết, những nàng tiên trong rừng hiện ra, thấy hồ nước ngọt kia giờ đã biến thành một đầm lầy mặn vì nước mắt.\n" +
                "\n" +
                "Vì sao em khóc ? – các nàng tiên hỏi.\n" +
                "\n" +
                "Vì em thương tiếc chàng Narziss, hồ nước đáp.\n" +
                "\n" +
                "Phải rồi. Các chị chẳng ngạc nhiên tí nào. Và tuy tất cả chúng ta đều theo đuổi chàng nhưng chỉ mình em được chiêm ngưỡng sắc đẹp tuyệt vời ấy.\n" +
                "\n" +
                "Chàng xinh trai đến thế ư ?, hồ nước ngơ ngác hỏi.\n" +
                "\n" +
                "Còn ai biết điều này rõ hơn là em chứ ? – các nàng tiên ngạc nhiên – \"ngày nào mà chàng chẳng củi người soi mình trên mặt hồ.\n" +
                "\n" +
                "Nghe thế, hồ nước im lăng hồi lâu rồi mới đáp : \"Đúng là em khóc chàng Narziss, nhưng em chưa bao giờ để ý rằng chàng đẹp trai đến thế. Em khóc chàng vì mỗi lần chàng soi người trên mặt hồ thì em mới thấy được sắc đẹp của chính em hiện lên rõ trong dôi mắt chàng."));

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