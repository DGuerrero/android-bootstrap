package com.quoders.apps.androidbootstrap.invites;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.appinvite.AppInviteInvitation;
import com.quoders.apps.androidbootstrap.R;


public class InvitesFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final int REQUEST_INVITE = 0x1001;

    private String mParam1;


    public static InvitesFragment newInstance(String param1) {
        InvitesFragment fragment = new InvitesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    public InvitesFragment() {
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_invite, container, false);

        initialiseInviteButton(view);

        return view;
    }

    private void initialiseInviteButton(View view) {
        Button inviteButton = (Button)view.findViewById(R.id.buttonInvite);
        inviteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new AppInviteInvitation.IntentBuilder(getString(R.string.invitation_title))
                        .setMessage(getString(R.string.invitation_message))
                        //.setDeepLink(Uri.parse(getString(R.string.invitation_deep_link)))
                        .build();

                startActivityForResult(intent, REQUEST_INVITE);
            }
        });
    }
}
