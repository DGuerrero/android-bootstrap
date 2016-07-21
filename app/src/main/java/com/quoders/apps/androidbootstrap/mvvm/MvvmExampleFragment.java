package com.quoders.apps.androidbootstrap.mvvm;

import android.app.Activity;
import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.quoders.apps.androidbootstrap.R;
import com.quoders.apps.androidbootstrap.databinding.FragmentMvvmExampleBinding;
import com.quoders.apps.androidbootstrap.rest.model.CommentItem;
import com.quoders.apps.androidbootstrap.rest.retrofit.RestClient;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MvvmExampleFragment extends Fragment {

    FragmentMvvmExampleBinding mBinding;
    private CommentItem mComentItem;


    public MvvmExampleFragment() {
        // Required empty public constructor
    }

    public static MvvmExampleFragment newInstance() {
        MvvmExampleFragment fragment = new MvvmExampleFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mComentItem = new CommentItem();

        fetchData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mvvm_example, container, false);

        mBinding = DataBindingUtil.setContentView(getActivity(), R.layout.fragment_mvvm_example);

        return v;
    }

    public void fetchData() {

        RestClient.getInstance().getCommentsAsync("1", new Callback<List<CommentItem>>() {

            @Override
            public void success(List<CommentItem> commentItem, Response response) {
                mComentItem = commentItem.get(0);
                mBinding.setCommentItem(mComentItem);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("mvvm_example", "- retrofit async response error - " + error.getCause().getMessage());
            }
        });
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }

}
