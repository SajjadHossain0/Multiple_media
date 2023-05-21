package com.example.multiple_media;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        MaterialToolbar AppBar = (MaterialToolbar) findViewById(R.id.AppBar);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);


        AppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                drawerLayout.closeDrawer(GravityCompat.START);
                switch (id){
                    case R.id.facebook:
                        replaceFrag(new facebook_frag());break;
                    case R.id.youtube:
                        replaceFrag(new youtube_frag());break;
                    case R.id.tiktok:
                        replaceFrag(new tiktok_frag());break;
                    case R.id.instagram:
                        replaceFrag(new instagram_frag());break;
                    case R.id.linkedin:
                        replaceFrag(new linkedin_frag());break;
                    case R.id.twitter:
                        replaceFrag(new twitter_frag());break;
                    case R.id.messenger:
                        replaceFrag(new messenger_frag());break;
                        case R.id.whatsapp:
                        replaceFrag(new whatsapp_frag());break;
                    case R.id.telegram:
                        replaceFrag(new telegram_frag());break;
                    case R.id.wechat:
                        replaceFrag(new wechat_frag());break;
                    case R.id.google:
                        replaceFrag(new google_frag());break;
                    case R.id.gmail:
                        replaceFrag(new gmail_frag());break;
                    case R.id.drive:
                        replaceFrag(new drive_frag());break;


                    default:
                        return true;
                }
                return true;
            }
        });
    }
    private  void replaceFrag(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frameLayout);
        if (fragment instanceof OnBackPressedListener) {
            ((OnBackPressedListener) fragment).onBackPressed();
        } else {
            super.onBackPressed();
        }
    }
}