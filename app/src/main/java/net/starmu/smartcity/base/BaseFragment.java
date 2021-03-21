package net.starmu.smartcity.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayout(),container,false);
    }

    protected abstract int getLayout();

    public void initToolbar(String title,boolean flag){
        if (getContext() instanceof BaseActivity){
            ((BaseActivity) getContext()).initToolbar(title,flag);
        }
    }
    public void hideToolbar(){
        if (getContext() instanceof BaseActivity){
            ((BaseActivity) getContext()).hideToolbar();
        }
    }
}
