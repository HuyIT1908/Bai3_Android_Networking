package com.quangcao.bai3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.quangcao.bai3.POST.POSTinterface;
import com.quangcao.bai3.POST.SVResponseProductsPOST;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView tv_kq;
    EditText edt_name , edt_price , edt_description;
    Button btn_GET , btn_POST;
    String kq = "";
    List<Products> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_name = findViewById(R.id.edt_name);
        edt_price = findViewById(R.id.edt_price);
        edt_description = findViewById(R.id.edt_description);
        tv_kq = findViewById(R.id.tv_kq);
        btn_GET = findViewById(R.id.btn_GET);
        btn_POST = findViewById(R.id.btn_POST);

        btn_GET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDATA();
            }
        });

        btn_POST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postDATA();
            }
        });
    }

    public void postDATA(){
        // https://batdongsanabc.000webhostapp.com/mob403lab5/
        // gửi dữ liệu lên Server vào phương thức POST
        // Lấy dữ liệu từ Edit
        String name = edt_name.getText().toString();
        String price = edt_price.getText().toString();
        String description = edt_description.getText().toString();
        // 1. Tạo đối tượng retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://batdongsanabc.000webhostapp.com/mob403lab5/")
                .addConverterFactory(GsonConverterFactory.create() )
                .build();
        // 2. Gọi Interface
        POSTinterface posTinterface = retrofit.create(POSTinterface.class);
        // 2.2 chuẩn bị hàm
        Call<SVResponseProductsPOST> call = posTinterface.postDATA(name , price , description);
        // 3. Thực thi hàm
        call.enqueue(new Callback<SVResponseProductsPOST>() {

            // khi thành công
            @Override
            public void onResponse(Call<SVResponseProductsPOST> call, Response<SVResponseProductsPOST> response) {
                // Trả về kết quả
                SVResponseProductsPOST productsPOST = response.body();
                tv_kq.setText( productsPOST.getMessage() );
            }
            // khi thất bại
            @Override
            public void onFailure(Call<SVResponseProductsPOST> call, Throwable t) {
                tv_kq.setText( t.getMessage() );
            }
        });
    }

    // Lấy dữ liệu từ Server bằng Retrofit
    // https://batdongsanabc.000webhostapp.com/mob403lab4/getall.json
    public void getDATA(){
        // 1. Tạo đối tượng Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://batdongsanabc.000webhostapp.com/mob403lab4/")
                .addConverterFactory(GsonConverterFactory.create() )
                .build();
        // 2. lấy request
        GetDATAInterface getDATAInterface = retrofit.create(GetDATAInterface.class);

        Call<SvResponseProducts> call = getDATAInterface.GetJson();
        // 3. thực thi request
        call.enqueue(new Callback<SvResponseProducts>() {
            // Nếu thành công
            @Override
            public void onResponse(Call<SvResponseProducts> call, Response<SvResponseProducts> response) {
                // Lấy kết quả do Server trả về
                SvResponseProducts svResponseProducts = response.body();
                // chuyển kết quả sang List
                list = new ArrayList<>(Arrays.asList(svResponseProducts.getProducts()) );
                // chuyển kết quả sang chuỗi
                for (Products p: list){
                    kq += "Name : " + p.getName() + " - Price : " + p.getPrice() + "\n\n";
                }
                // hiển thị kết quả lên client
                tv_kq.setText(kq);
            }
            // Nếu thất bại
            @Override
            public void onFailure(Call<SvResponseProducts> call, Throwable t) {
                tv_kq.setText( t.getMessage() );
            }
        });
    }

}