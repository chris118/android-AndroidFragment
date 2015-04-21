package com.example.xiaopeng_wang.androidsample;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Choreographer;
import android.view.Menu;
import android.view.MenuItem;


public class SecondActivity extends ActionBarActivity
        implements FirstFragment.OnFragmentInteractionListener,
        SecondFragment.OnFragmentInteractionListener {

    private Fragment firstFragment;
    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onBackPressed(){
        //实现Home键效果

        //super.onBackPressed();这句话一定要注掉,不然又去调用默认的back处理方式了
        FragmentManager fm = getFragmentManager();
        if(fm.getBackStackEntryCount() == 0){
            super.onBackPressed();
        }else{
            fm.popBackStack();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
//        actionBar.setHomeButtonEnabled(true);
//        actionBar.setDisplayShowHomeEnabled(true);

        firstFragment = new FirstFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id._container, firstFragment);
        //ft.addToBackStack(null);
        ft.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        switch (id) {
            case android.R.id.home:
               this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
