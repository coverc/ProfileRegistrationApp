

package com.example.inclass04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements WelcomeFragment.IListener, RegistrationFragment.JListener, DepartmentFragment.departmentListener {
    //boolean registerButtonClicked = false;
    //FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
    User userProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainerView, new WelcomeFragment()).commit();
        }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void setButtonClicked(boolean isClicked) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, new RegistrationFragment(), "regFrag").addToBackStack(null).commit();
        }

    @Override
    public void selectButtonClicked(boolean isSelectClicked) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, new DepartmentFragment()).addToBackStack(null).commit();
    }


    @Override
    public void departmentChosen(String department) {
        //getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, RegistrationFragment.newInstance(department)).commit();
        getSupportFragmentManager().findFragmentByTag("regFrag");
        RegistrationFragment.setDepartment(department);
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void cancelClicked(boolean cancel) {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void profileCreated(User user) {
        userProfile = user;
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, ProfileFragment.newInstance(user)).addToBackStack(null).commit();
    }
}
