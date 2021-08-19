package sg.edu.np.practical6;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    static ArrayList<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        MyDBHandler db = new MyDBHandler(this);


        userList = db.getUsers();
//        new ArrayList<>();
//        for(int i=0; i<20; i++)
//        {
//            User u = new User();
//            u.name = "Name" + new Random().nextInt();
//            u.description = "Description " + new Random().nextInt();
//            u.followed = new Random().nextInt()%2 == 0;
//            userList.add(u);
//        }

        RecyclerView rv = findViewById(R.id.rv);
        ItemsAdapter itemsAdapter = new ItemsAdapter(userList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(itemsAdapter);
    }
}