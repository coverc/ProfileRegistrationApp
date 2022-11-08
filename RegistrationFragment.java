

package com.example.inclass04;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class RegistrationFragment extends Fragment {
    JListener mListener;
    //profileListener pListener;
    boolean isSelectClicked;
    TextView textview;
    Button submitButton;
    EditText name;
    EditText email;
    EditText idNumber;
    User user;
    static String chosenDepartment;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
   // private String chosenDepartment;

    public RegistrationFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static RegistrationFragment newInstance(String chosenDepartment) {
        RegistrationFragment fragment = new RegistrationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, chosenDepartment);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            chosenDepartment = getArguments().getString(ARG_PARAM1);
        }
    }
    Button selectButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registration, container, false);
        selectButton = view.findViewById(R.id.selectButton);
        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.selectButtonClicked(isSelectClicked);
            }

        });
        textview = view.findViewById(R.id.editDept);
        textview.setText(chosenDepartment);

        submitButton = view.findViewById(R.id.submitButtonReg);
        name = view.findViewById(R.id.editName);
        email = view.findViewById(R.id.editEmail);
        idNumber = view.findViewById(R.id.editID);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.getText().toString().length() == 0 || email.getText().toString().length() == 0 || idNumber.getText().toString().length() == 0 || chosenDepartment == null){
                    Toast.makeText(getActivity(), "Enter all required information and choose a department!", Toast.LENGTH_LONG).show();
                }
                else{
                    user = new User(name.getText().toString(), email.getText().toString(), idNumber.getText().toString(), chosenDepartment);
                    Log.d("demo", "onClick: " + user.name);
                    mListener.profileCreated(user);
                }
            }
        });

        return view;

    }
    public static void setDepartment(String department){
        chosenDepartment = department;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof JListener){
            mListener = (JListener) context;
            Log.d("demo", "onAttach: " + mListener);
        }
//        else {
//            pListener = (profileListener) context;
//            Log.d("demo", "onAttach:p " + mListener);
//        }
    }

    public interface JListener{
        void selectButtonClicked(boolean isSelectClicked);
        void profileCreated(User userProfile);
    }

//    public interface profileListener{
//        void profileCreated(User userProfile);
//    }
}