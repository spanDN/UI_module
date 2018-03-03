package com.example.delle5540.ui_module.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.delle5540.ui_module.R;
import com.example.delle5540.ui_module.commons.IAuthListener;
import com.example.delle5540.ui_module.commons.SocialType;

import static com.example.delle5540.ui_module.commons.SocialType.FACEBOOK;


public class SignInFragment extends Fragment {

    private AppCompatButton btSignIn;
    private AppCompatButton btSignUp;
    private AppCompatTextView btvReset;
    private AppCompatEditText btvEmail;
    private AppCompatEditText btvPassword;
    private AppCompatImageButton bibFBsignIn;

    private IAuthListener onAuthListener;

    public SignInFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public SignInFragment(IAuthListener onAuthListener){
        this.onAuthListener = onAuthListener;
    }

    public static SignInFragment newInstance(IAuthListener onAuthListener) {
        SignInFragment fragment = new SignInFragment(onAuthListener);
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        onAuthListener.signIn("Email", "Password");
        View v = inflater.inflate(R.layout.fragment_sign_in2, container, false);
        btSignIn = (AppCompatButton) v.findViewById(R.id.btn_sign_in_enter);
        btvReset = (AppCompatTextView) v.findViewById(R.id.tv_sing_in_forgot_password);
        btvEmail = (AppCompatEditText) v.findViewById(R.id.et_sing_in_username);
        btvPassword = (AppCompatEditText) v.findViewById(R.id.et_sing_in_password);
        bibFBsignIn = (AppCompatImageButton) v.findViewById(R.id.fb_sign_in);

        bibFBsignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAuthListener.loginSocial(SocialType.FACEBOOK);
            }
        });

        btSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAuthListener.signIn(btvEmail.getText().toString(), btvPassword.getText().toString() );
            }
        });
//        btSignUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onAuthListener.openSignUp();
//            }
//        });
        btvReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAuthListener.openReset();
            }
        });



        return v;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
