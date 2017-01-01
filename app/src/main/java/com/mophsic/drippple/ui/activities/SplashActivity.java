package com.mophsic.drippple.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;

import com.daimajia.androidanimations.library.Techniques;
import com.mophsic.drippple.R;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

/**
 * 作者：xiaofei
 * 日期：2016/10/15
 * 邮箱：paozi.xiaofei.123@gmail.com
 */

public class SplashActivity extends AwesomeSplash{

    @Override
    public void initSplash(ConfigSplash configSplash) {
        //background
        configSplash.setBackgroundColor(R.color.colorPrimary);
        configSplash.setAnimCircularRevealDuration(1500);
        configSplash.setRevealFlagX(Flags.REVEAL_RIGHT);  //or Flags.REVEAL_LEFT
        configSplash.setRevealFlagY(Flags.REVEAL_BOTTOM); //or Flags.REVEAL_TOP

        // logo
        configSplash.setLogoSplash(R.drawable.ic_dribble); //or any other drawable
        configSplash.setAnimLogoSplashDuration(1500); //int ms
        configSplash.setAnimLogoSplashTechnique(Techniques.BounceInDown); //choose one form Techniques (ref: https://github.com/daimajia/AndroidViewAnimations)

        //Customize Title
        configSplash.setTitleSplash(this.getString(R.string.app_name));
        configSplash.setTitleTextColor(R.color.colorPlanText);
        configSplash.setTitleTextSize(40f); //float value
        configSplash.setAnimTitleDuration(1500);
        configSplash.setAnimTitleTechnique(Techniques.FadeIn);
        configSplash.setTitleFont("fonts/streatwear.otf"); //provide string to your font located in assets/fonts/

    }

    @Override
    public void animationsFinished() {

        final Activity activity = this;
        new Handler().postDelayed(() -> {

            Intent intent = new Intent(SplashActivity.this, LoggingActivity.class);
            startActivity(intent);
            activity.finish();
        }, 3000);
    }
}
