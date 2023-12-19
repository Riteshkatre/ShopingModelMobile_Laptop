package com.example.shopingmodel.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.shopingmodel.LaptopDatamodel;
import com.example.shopingmodel.LaptopRecyclerAdapter;
import com.example.shopingmodel.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LaptopFregment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LaptopFregment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView rcv;
    Context context;
    EditText searchbar;
    LaptopRecyclerAdapter laptopRecyclerAdapter;

    public LaptopFregment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LaptopFregment.
     */
    // TODO: Rename and change types and number of parameters
    public static LaptopFregment newInstance(String param1, String param2) {
        LaptopFregment fragment = new LaptopFregment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_laptop_fregment, container, false);

        searchbar=view.findViewById(R.id.searchbar);
        rcv=view.findViewById(R.id.rcv);
        List<LaptopDatamodel> laptopDatamodels=new ArrayList<>();

        laptopDatamodels.add(new LaptopDatamodel("ASUS","Asus","50,000","2015","pune","laptop","https://m.media-amazon.com/images/I/51c+NXm8zLL.jpg"));
        laptopDatamodels.add(new LaptopDatamodel("Samsung","samsung","10,000","2016","Asam","Tab","https://cdn1.smartprix.com/rx-iZpeHskvL-w1200-h1200/ZpeHskvL.jpg"));
        laptopDatamodels.add(new LaptopDatamodel("Dell","dell","35,000","2010","Raipur","Compuer","data:image/jpeg;base64,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"));
        laptopDatamodels.add(new LaptopDatamodel("Apple","mackbook","10,0000","2020","Delhi","laptop","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTBPN4tNyvh7emWmSxflTjEMRx3wqffhh2iYYtQ04vGhdg6YiR3kgW4yTs195YZZebApK8&usqp=CAU"));

        laptopRecyclerAdapter=new LaptopRecyclerAdapter(this,laptopDatamodels);
        rcv.setAdapter(laptopRecyclerAdapter);
        rcv.setLayoutManager(new LinearLayoutManager(getContext()));

        searchbar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(laptopRecyclerAdapter!=null){

                    laptopRecyclerAdapter.search(charSequence,rcv);

                }




            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        return view;
    }
}