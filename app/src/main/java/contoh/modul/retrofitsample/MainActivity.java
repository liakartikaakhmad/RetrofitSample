package contoh.modul.retrofitsample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import contoh.modul.retrofitsample.databinding.ActivityMainBinding;
import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    private Activity activity = MainActivity.this;
    private ActivityMainBinding binding;
    private View view;

    private NetworkEndpoint networkEndpoint;
    private List<ItemsItem> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        setContentView(view);

        networkEndpoint = NetworkRetrofit.getRetrofit(activity).create(NetworkEndpoint.class);

        Call<Response> call = networkEndpoint.getDataBlog("2972308624851198092",null,
                "AIzaSyBMI5r0VzQBMrdc46CTh1JQR2Xb7FkUaNY", null);

        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if(response.isSuccessful()){
                    list.addAll(response.body().getItems());
                    for(int i = 0; i < list.size(); i++){
                        Log.e("SSSSSSSS", list.get(i).getTitle());
                    }
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });
    }


}
