package ly.count.android.demo;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import java.util.HashMap;

import ly.count.android.sdk.Countly;
import org.json.JSONObject;

@SuppressWarnings("UnusedParameters")
public class MainActivity extends AppCompatActivity {
    private String demoTag = "CountlyDemo";
    InstallReferrerClient referrerClient;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Countly.onCreate(this);

        /*
        To send Referrer follow these steps.
        Steps:
        1. Start Google Play on the device using campaign link,
        for example, https://play.google.com/store/apps/details?id=ly.count.android.demo&referrer=utm_source%3Dtest_source%26utm_medium%3Dtest_medium%26utm_term%3Dtest-term%26utm_content%3Dtest_content%26utm_campaign%3Dtest_name
        (You can use google play generator: https://developers.google.com/analytics/devguides/collection/android/v3/campaigns#google-play-url-builder)
        2. DON'T TAP ON INSTALL BUTTON
        3. Install your test build using adb.

        Google Play will be returning your test campaign now.
         */
        referrerClient = InstallReferrerClient.newBuilder(this).build();
        referrerClient.startConnection(new InstallReferrerStateListener() {
            @Override
            public void onInstallReferrerSetupFinished(int responseCode) {
                switch (responseCode) {
                    case InstallReferrerClient.InstallReferrerResponse.OK:
                        try {
                            ReferrerDetails response = referrerClient.getInstallReferrer();

                            String referrerUrl = response.getInstallReferrer();

                            HashMap<String, Object> custom = new HashMap<>();
                            custom.put("install_referrer_url", referrerUrl);

                            JSONObject jsonObject = new JSONObject(custom);
                            Countly.userData.setProperty("custom_referrer", jsonObject.toString(1));
                            Countly.userData.save();

                            referrerClient.endConnection();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case InstallReferrerClient.InstallReferrerResponse.FEATURE_NOT_SUPPORTED:
                        // API not available on the current Play Store app.
                        break;
                    case InstallReferrerClient.InstallReferrerResponse.SERVICE_UNAVAILABLE:
                        // Connection couldn't be established.
                        break;
                }
            }

            @Override
            public void onInstallReferrerServiceDisconnected() {
            }
        });
    }

    public void onClickButtonCustomEvents(View v) {
        startActivity(new Intent(this, ActivityExampleCustomEvents.class));
    }

    public void onClickButtonCrashReporting(View v) {
        startActivity(new Intent(this, ActivityExampleCrashReporting.class));
    }

    public void onClickButtonUserDetails(View v) {
        startActivity(new Intent(this, ActivityExampleUserDetails.class));
    }

    public void onClickButtonAPM(View v) {
        startActivity(new Intent(this, ActivityExampleAPM.class));
    }

    public void onClickButtonViewTracking(View v) {
        startActivity(new Intent(this, ActivityExampleViewTracking.class));
    }

    public void onClickButtonMultiThreading(View v) {
        //
    }

    public void onClickButtonOthers(View v) {
        startActivity(new Intent(this, ActivityExampleOthers.class));
    }

    public void onClickButtonRemoteConfig(View v) {
        startActivity(new Intent(this, ActivityExampleRemoteConfig.class));
    }

    public void onClickButtonDeviceId(View v) {
        startActivity(new Intent(this, ActivityExampleDeviceId.class));
    }

    public void onClickButtonRatings(View v) {
        startActivity(new Intent(this, ActivityExampleFeedback.class));
    }


    public void enableCrashTracking(){
        //add some custom segments, like dependency library versions
        HashMap<String, String> data = new HashMap<>();
        data.put("Facebook", "3.5");
        data.put("Admob", "6.5");
        Countly.sharedInstance().setCustomCrashSegments(data);
        Countly.sharedInstance().enableCrashReporting();
    }

    @Override
    public void onStart()
    {
        super.onStart();
        Countly.sharedInstance().onStart(this);
    }

    @Override
    public void onStop()
    {
        Countly.sharedInstance().onStop();
        super.onStop();
    }

    @Override
    public void onConfigurationChanged (Configuration newConfig){
        super.onConfigurationChanged(newConfig);
        Countly.sharedInstance().onConfigurationChanged(newConfig);
    }

}
