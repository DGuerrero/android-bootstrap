package com.quoders.apps.androidbootstrap.rest;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.quoders.apps.androidbootstrap.R;
import com.quoders.apps.androidbootstrap.rest.model.CommentItem;
import com.quoders.apps.androidbootstrap.rest.retrofit.RestClient;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RestExampleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RestExampleFragment extends Fragment  {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    private OnFragmentInteractionListener mListener;

    @InjectView(R.id.textViewRestResponse)
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


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment RestExampleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RestExampleFragment newInstance(String param1) {
        RestExampleFragment fragment = new RestExampleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    public RestExampleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_rest_example, container, false);
        ButterKnife.inject(this, view);
        mTextViewLogs.setMovementMethod(new ScrollingMovementMethod());
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



    private void testRetrofitGetAsync() {

        RestClient.getInstance().getCommentsAsync("1", new Callback<List<CommentItem>>() {

            @Override
            public void success(List<CommentItem> commentItem, Response response) {
                addLog("- retrofit async response success - " + response.getStatus());
            }

            @Override
            public void failure(RetrofitError error) {
                addLog("- retrofit async response error - " + error.getCause().getMessage());
            }
        });
    }

    private void testRetrofitGetSync() {

        List<CommentItem> comments =  RestClient.getInstance().getCommentsSync("1");
        if(comments != null && !comments.isEmpty()) {
            addLog("- retrofit sync response success - ");
        } else {
            addLog("- retrofit sync response error - ");
        }
    }

    private void testRetrofitPostAsync() {
        //  TODO
    }



    private void addLog(String s) {
        mTextViewLogs.setText(mTextViewLogs.getText().toString() + "\n\n" + s);
    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
