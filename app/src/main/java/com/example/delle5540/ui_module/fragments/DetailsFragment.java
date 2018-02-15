package com.example.delle5540.ui_module.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.delle5540.ui_module.R;
import com.example.delle5540.ui_module.commons.IDetailListener;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DetailsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailsFragment extends Fragment {
    private EditText mEdLogin;
    private EditText mEdPassword;
    private Button mBtMore;
    private IDetailListener onDetailsListener;


    public DetailsFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public DetailsFragment (IDetailListener detailsListener)
    {
        this.onDetailsListener = detailsListener;
    }

    public static DetailsFragment newInstance(IDetailListener detailsListener) {
        DetailsFragment fragment = new DetailsFragment(detailsListener);

        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_details, container, false);
        mEdLogin = (EditText) v.findViewById(R.id.edLogin);
        mEdPassword = (EditText) v.findViewById(R.id.edPassword);
        mBtMore = (Button) v.findViewById(R.id.btnInfo);

        mBtMore.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onDetailsListener.getInfo(mEdLogin.getText().toString(),
                        mEdPassword.getText().toString());
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
