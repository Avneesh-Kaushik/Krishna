package com.example.avneesh.krishna;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    List<ListItem> mylist;
    int[] id= {
            R.drawable.a7_opt,
            R.drawable.h4_opt,
            R.drawable.k3_opt,
            R.drawable.r5,
            R.drawable.s4,
            R.drawable.s5,
            R.drawable.k1,
            R.drawable.a3
    };
    int[] sid={
            R.raw.jai_ambe_gauri,
            R.raw.hanuman_chalisa,
            R.raw.aarti_kunj_bihari_ki,
            R.raw.shri_radhe_radhe,
            R.raw.jai_shiv_omkara,
            R.raw.mahamrityunjaya_mntra,
            R.raw.o_murli_wale,
            R.raw.devi_stotra_mantra
    };

    String[] str= {"Jai Ambe Gauri","Hanuman Chalisa","Aarti kunj Bihari ki","Shri Radhe Radhe",
            "Jai Shiv Omkara","Mahamrithyunjaya Mantra","O Murli wale","Devi Stotra Mantra"
    };
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);

        recyclerView= (RecyclerView) this.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mylist = new ArrayList<>();

        for(int i=0; i<str.length; i++)
        {
            ListItem listItem= new ListItem(id[i],str[i],sid[i]);
            mylist.add(listItem);

        }
        adapter = new MyAdapter(this,mylist, sid);
        recyclerView.setAdapter(adapter);
    }
}