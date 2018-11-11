package com.example.vasilii.project_05;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCall();
        buttonMail();
        buttonMap();
        buttonWeb();
    }

    private void buttonCall() {
        Button buttonCall = findViewById(R.id.button_call);
        buttonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri number = Uri.parse("tel: ");
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);

                if (isIntentSafe(callIntent)) {
                    startActivity(callIntent);
                } else {
                    Toast.makeText(
                        getApplicationContext(),
                        "Your phone have no app can dial",
                        Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });
    }

    private void buttonMap() {
        Button buttonMap = findViewById(R.id.button_map);
        buttonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri location = Uri.parse("geo: 37.422219, -122.08364?z=14");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);

                if (isIntentSafe(mapIntent)) {
                    startActivity(mapIntent);
                } else {
                    Toast.makeText(
                            getApplicationContext(),
                            "Your phone have no app open map",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });
    }

    private void buttonWeb() {
        Button buttonWeb = findViewById(R.id.button_web);
        buttonWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webPage = Uri.parse("https://vk.com");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webPage);

                if (isIntentSafe(webIntent)) {
                    startActivity(webIntent);
                } else {
                    Toast.makeText(
                            getApplicationContext(),
                            "Your phone have no app open web page",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });
    }

    private void buttonMail() {
        Button buttonMail = findViewById(R.id.button_mail);
        buttonMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(
                    Intent.ACTION_SENDTO,
                    Uri.fromParts(
                        "mailto",
                        "example@gamil.com",
                        null
                    )
                );

                if (isIntentSafe(emailIntent)) {
                    emailIntent.putExtra(
                            Intent.EXTRA_EMAIL,
                            new String[] {"hello@mail.ru, hi@all.ru"}
                    );
                    emailIntent.putExtra(
                            Intent.EXTRA_SUBJECT,
                            "Send Intent Message"
                    );
                    emailIntent.putExtra(
                            Intent.EXTRA_TEXT,
                            "I text my mail by Android App"
                    );

                    startActivity(emailIntent);
                } else {
                    Toast.makeText(
                            getApplicationContext(),
                            "Your phone have no app can send email",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });
    }

    private boolean isIntentSafe(Intent intent) {
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);

        return activities.size() > 0;
    }
}
