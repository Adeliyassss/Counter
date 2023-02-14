package com.example.counter;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class FirstFragment extends Fragment {

    private Button btn1,btn2,btnSend;
    private TextView textView;
    private Integer num1,num2;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView=requireActivity().findViewById(R.id.tv_null);
        btn1=requireActivity().findViewById(R.id.btn_fr_first);
        btn2=requireActivity().findViewById(R.id.btn_fr_second);
        btnSend=requireActivity().findViewById(R.id.btn_send);

        initListener();
    }

    private void initListener() {

        btn1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                num1 = Integer.valueOf(textView.getText().toString());
                num2 = num1+1;
                textView.setText(num2.toString());
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                num1 = Integer.valueOf(textView.getText().toString());
                num2 = num1-1;
                textView.setText(num2.toString());
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("key",textView.getText().toString() );
                SecondFragment secondFragment=new SecondFragment();
                secondFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.container,secondFragment).commit();
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new SecondFragment()).addToBackStack(null).commit();
            }
        });
    }
}