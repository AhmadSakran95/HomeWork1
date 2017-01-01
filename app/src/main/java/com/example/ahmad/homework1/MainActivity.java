package com.example.ahmad.homework1;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=(ListView)findViewById(R.id.listview11);
        list.setAdapter(new Adapter(this));

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                     Toast.makeText(MainActivity.this,"Lesson " + (position + 1),Toast.LENGTH_SHORT).show();
            }
        });




    }


    class SingleRow{
        String titles;
        String desc;
        int img;
        String dates;

        SingleRow(String titles,String desc,int img,String dates){
            this.titles=titles;
            this.desc=desc;
            this.img=img;
            this.dates=dates;
        }
    }

    class Adapter extends BaseAdapter{

        ArrayList<SingleRow>list;
        Context context;
        Adapter(Context c){
            context=c;
            list=new ArrayList<SingleRow>();
            Resources res=c.getResources();
            String[] title=res.getStringArray(R.array.titles);
            String[] desc=res.getStringArray(R.array.desc);
            String[] dates=res.getStringArray(R.array.dates);

            int[] img={R.drawable.img1,R.drawable.img2,R.drawable.img4,R.drawable.img6,R.drawable.img2,R.drawable.img1};
            for (int i=0;i<=5;i++){
               list.add(new SingleRow(title[i],desc[i],img[i],dates[i]));
            }
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {

            LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row=inflater.inflate(R.layout.singlerow,parent,false);

            TextView title=(TextView)row.findViewById(R.id.textViewTitle);
            TextView desc=(TextView)row.findViewById(R.id.textViewDec);
            ImageView img=(ImageView)row.findViewById(R.id.imageView2);
            TextView dates=(TextView)row.findViewById(R.id.textViewDate);

            SingleRow temp=list.get(position);

            title.setText(temp.titles);
            desc.setText(temp.desc);
            img.setImageResource(temp.img);
            dates.setText(temp.dates);

            return row;
        }
    }
}
