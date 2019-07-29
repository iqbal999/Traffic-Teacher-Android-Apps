package com.example.afrin.trafficteacher;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.afrin.trafficteacher.api.RetrofitClient;
import com.example.afrin.trafficteacher.model.showGarageResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllGarageInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_garage_info);

        showAllGarageList();
    }

    private void showAllGarageList() {
        Call<List<showGarageResponse>> call = RetrofitClient
                .getInstance()
                .getApi()
                .getAllGarageInfo();

        call.enqueue(new Callback<List<showGarageResponse>>() {
            @Override
            public void onResponse(Call<List<showGarageResponse>> call, Response<List<showGarageResponse>> response) {
                populateListView(response.body());
            }

            @Override
            public void onFailure(Call<List<showGarageResponse>> call, Throwable t) {
                Toast.makeText(AllGarageInfo.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    class ListAdapter extends BaseAdapter {

        private List<showGarageResponse> showGarageResponses;
        private Context context;

        public ListAdapter(List<showGarageResponse> showGarageResponses, Context context) {
            this.showGarageResponses = showGarageResponses;
            this.context = context;
        }

        @Override
        public int getCount() {
            return showGarageResponses.size();
        }

        @Override
        public Object getItem(int position) {
            return showGarageResponses.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView_garage_title, textView_contact_no, textView_garage_address;
            if(convertView == null){
                convertView = LayoutInflater.from(context).inflate(R.layout.list_item_garage,null);
            }

            textView_garage_title = convertView.findViewById(R.id.textView_garage_title);
            textView_contact_no = convertView.findViewById(R.id.textView_contact_no);
            textView_garage_address = convertView.findViewById(R.id.textView_garage_address);


            final showGarageResponse showGarage = showGarageResponses.get(position);

            textView_garage_title.setText(showGarage.getGarage_name());
            textView_contact_no.setText(showGarage.getContact());
            textView_garage_address.setText(showGarage.getAddress());


            return convertView;
        }
    }

    private ListView listView;
    private ListAdapter listAdapter;

    private void populateListView (List<showGarageResponse> garageList){
        listView = findViewById(R.id.listView_garage);
        listAdapter = new ListAdapter( garageList, this);
        listView.setAdapter(listAdapter);

    }
}
