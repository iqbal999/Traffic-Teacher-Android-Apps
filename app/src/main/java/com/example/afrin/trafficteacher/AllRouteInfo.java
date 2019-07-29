package com.example.afrin.trafficteacher;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.afrin.trafficteacher.api.RetrofitClient;
import com.example.afrin.trafficteacher.model.showRouteResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllRouteInfo extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner_source, spinner_dest;
    private Button btn_search;
    private String text_source, text_dest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_route_info);

        spinner_source = findViewById(R.id.select_source);
        spinner_dest = findViewById(R.id.select_dest);

        btn_search = findViewById(R.id.btn_search);

        ArrayAdapter<CharSequence> sourceadapter = ArrayAdapter.createFromResource(this, R.array.source_list, R.layout.spinner_item);
        sourceadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_source.setAdapter(sourceadapter);
        spinner_source.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> destadapter = ArrayAdapter.createFromResource(this, R.array.dest_list, R.layout.spinner_item);
        destadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_dest.setAdapter(destadapter);
        spinner_dest.setOnItemSelectedListener(this);

        showAllRouteList();

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Call<List<showRouteResponse>> searchRoute = RetrofitClient
                        .getInstance()
                        .getApi()
                        .searchRoute(text_source, text_dest);

                searchRoute.enqueue(new Callback<List<showRouteResponse>>() {
                    @Override
                    public void onResponse(Call<List<showRouteResponse>> call, Response<List<showRouteResponse>> response) {
                        populateListView(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<showRouteResponse>> call, Throwable t) {
                        Toast.makeText(AllRouteInfo.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }

    private void showAllRouteList() {
        Call<List<showRouteResponse>> call = RetrofitClient
                .getInstance()
                .getApi()
                .getAllRouteInfo();

        call.enqueue(new Callback<List<showRouteResponse>>() {
            @Override
            public void onResponse(Call<List<showRouteResponse>> call, Response<List<showRouteResponse>> response) {
                populateListView(response.body());
            }

            @Override
            public void onFailure(Call<List<showRouteResponse>> call, Throwable t) {
                Toast.makeText(AllRouteInfo.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    class ListAdapter extends BaseAdapter {

        private List<showRouteResponse> showRouteResponses;
        private Context context;

        public ListAdapter(List<showRouteResponse> showRouteResponses, Context context) {
            this.showRouteResponses = showRouteResponses;
            this.context = context;
        }

        @Override
        public int getCount() {
            return showRouteResponses.size();
        }

        @Override
        public Object getItem(int position) {
            return showRouteResponses.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView_toute_title, textView_route_desc;
            if(convertView == null){
                convertView = LayoutInflater.from(context).inflate(R.layout.list_item,null);
            }

            textView_toute_title = convertView.findViewById(R.id.textView_route_title);
            textView_route_desc = convertView.findViewById(R.id.textView_route_desc);

            final showRouteResponse showResponse = showRouteResponses.get(position);

            textView_toute_title.setText(showResponse.getRoute_name());
            textView_route_desc.setText(showResponse.getRoute_desc());


            return convertView;
        }
    }

    private ListView listView;
    private ListAdapter listAdapter;

    private void populateListView (List<showRouteResponse> routeList){
        listView = findViewById(R.id.listView_route);
        listAdapter = new ListAdapter( routeList, this);
        listView.setAdapter(listAdapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent.getId() == R.id.select_source)
        {
            text_source = parent.getItemAtPosition(position).toString();
        }
        else if(parent.getId() == R.id.select_dest)
        {
            text_dest = parent.getItemAtPosition(position).toString();
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
