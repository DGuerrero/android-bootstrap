package com.quoders.apps.androidbootstrap.rest;

import android.app.Activity;
import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.quoders.apps.androidbootstrap.LogHelper;
import com.quoders.apps.androidbootstrap.R;
import com.quoders.apps.androidbootstrap.rest.model.CommentItem;
import com.quoders.apps.androidbootstrap.rest.retrofit.RestClient;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class RestExampleFragment extends Fragment {

    @Bind(R.id.textViewRestResponse)
    TextView mTextViewLogs;

    @OnClick(R.id.buttonTestRetrofit)
    public void testRetrofit() {

        //  Async GET example
        testRetrofitGetAsync();

        //  Sync GET example
        testRetrofitGetSync();
        
        //  Sync POST example
        testRetrofitPostAsync();
    }


    @OnClick(R.id.buttonTestVolley)
    public void testVolley() {
        //  TODO
    }


    public static RestExampleFragment newInstance(String param1) {
        RestExampleFragment fragment = new RestExampleFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public RestExampleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_rest_example, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    /***
     *   Asynchronous Retrofit request
     **/
    private void testRetrofitGetAsync() {

        RestClient.getInstance().getCommentsAsync("1", new Callback<List<CommentItem>>() {

            @Override
            public void success(List<CommentItem> commentItem, Response response) {
                LogHelper.addLog(mTextViewLogs, "- retrofit async response success - " + response.getStatus());
                if(response.getStatus() == 200) {
                    LogHelper.addLog(mTextViewLogs, commentItem.get(0).getName() + "\n" + commentItem.get(0).getEmail());
                }
            }

            @Override
            public void failure(RetrofitError error) {
                LogHelper.addLog(mTextViewLogs, "- retrofit async response error - " + error.getCause().getMessage());
            }
        });
    }

    /***
     *   Synchronous Retrofit request. In Android has to be done not in the UI thread
     **/
    private void testRetrofitGetSync() {

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                List<CommentItem> comments =  RestClient.getInstance().getCommentsSync("1");
            }
        });
    }


    private void testRetrofitPostAsync() {
        //  TODO
    }
}
