package com.quoders.apps.androidbootstrap.rxjava;


import android.app.Fragment;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.quoders.apps.androidbootstrap.LogHelper;
import com.quoders.apps.androidbootstrap.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RxFragment extends Fragment {

    @Bind(R.id.textViewRxLog) TextView mTvLog;

    @OnClick(R.id.buttonExample1)
    public void onExample1Click(View v) {
        Observer observer = getOddNumbersObserver();
        Observable<List<Integer>> observable = getOddNumbersObservable();
        observable.subscribe(observer);
    }

    @OnClick(R.id.buttonExample2)
    public void onExample2Click(View v) {
        Observer<List<Integer>> observer = getOddNumbersObserver();
        Observable observable = getOddNumbersObservable();
        observable.subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public RxFragment() {
        // Required empty public constructor
    }

    public static RxFragment newInstance() {
        RxFragment fragment = new RxFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rx, container, false);
        ButterKnife.bind(this, view);
        mTvLog.setMovementMethod(new ScrollingMovementMethod());
        return view;
    }

    private Observable<List<Integer>> getOddNumbersObservable() {
        return Observable.just(getOddNumbers());
    }

    private List<Integer> getOddNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for(int i=0; i<50; i++) {
            if(i%2 == 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                numbers.add(i);
            }
        }
        return numbers;
    }

    private Observer<List<Integer>> getOddNumbersObserver() {
        return new Observer<List<Integer>>() {
            @Override
            public void onCompleted() {
                LogHelper.addLog(mTvLog, "getOddNumbers() -> onCompleted)");
            }

            @Override
            public void onError(Throwable e) {
                LogHelper.addLog(mTvLog, "getOddNumbers() -> onError)");
            }

            @Override
            public void onNext(List<Integer> integers) {
                LogHelper.addLog(mTvLog, "getOddNumbers() -> onNext: )" + integers);
            }
       };
    }
}
