package com.mophsic.drippple.ui.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.mophsic.drippple.R;
import com.mophsic.drippple.data.DribbblePrefs;
import com.orhanobut.logger.Logger;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // 点击FAB 跳转到登录页
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(view -> InnerBrowserActivity.toHere(this, DribbblePrefs.LOGIN_URL));

        handleIntent(getIntent());
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        setIntent(intent);
        handleIntent(intent);
    }

    /**
     * Handle code from dribbble.
     * @param intent intent
     */
    private void handleIntent(Intent intent) {
        if (intent != null) {
            String action  = intent.getAction();
            if (Intent.ACTION_VIEW.equals(action)) {
                Uri data = intent.getData();
                if (data != null) {
                    String code = data.getQueryParameter("code");
                    Logger.d("code:" + code);
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

        return super.onOptionsItemSelected(item);
    }

}
