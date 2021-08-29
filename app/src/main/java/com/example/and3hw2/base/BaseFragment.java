package com.example.and3hw2.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.example.and3hw2.ui.adapters.CharacterAdapter;

public abstract class BaseFragment<ViewModel extends BaseViewModel, Binding extends ViewBinding > extends Fragment {

    protected ViewModel viewModel;
    protected Binding binding;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize();
        setUpRequests();
        setUpObserves();
        isConnectInternet();
    }

    protected  void isConnectInternet(){
    }

    protected void setUpObserves(){
    }

    protected  void setUpRequests(){
    }

    protected  void initialize(){
    }

}
