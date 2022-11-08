

package com.example.inclass04;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {
    private static String name;
    private static String email;
    private static String idNumber;
    private static String dept;
    TextView textviewName;
    TextView textviewEmail;
    TextView textviewID;
    TextView textviewDept;
    //String name;
//    String email;
//    String idNumber;
//    String dept;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private Bundle userProfile;


    public ProfileFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(User userProfile) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, String.valueOf(userProfile));
        fragment.setArguments(args);
        name = userProfile.name;
        email = userProfile.email;
        idNumber = userProfile.ID;
        dept = userProfile.department;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            userProfile = getArguments().getBundle(ARG_PARAM1);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        textviewName = view.findViewById(R.id.profileEditName);
        textviewEmail = view.findViewById(R.id.profileEditEmail);
        textviewID = view.findViewById(R.id.profileEditID);
        textviewDept = view.findViewById(R.id.profileEditDept);

        textviewName.setText(name);
        textviewEmail.setText(email);
        textviewID.setText(idNumber);
        textviewDept.setText(dept);
        return view;
    }
}