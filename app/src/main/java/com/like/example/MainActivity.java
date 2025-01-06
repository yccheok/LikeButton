package com.like.example;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.like.LikeButton;
import com.like.OnAnimationEndListener;
import com.like.OnLikeListener;
import com.like.example.databinding.ActivityMainBinding;
import com.mikepenz.community_material_typeface_library.CommunityMaterial;
import com.mikepenz.iconics.IconicsDrawable;
public class MainActivity extends AppCompatActivity implements OnLikeListener,
    OnAnimationEndListener {

    public static final String TAG = "MainActivity";

    Toolbar toolbar;
    LikeButton starButton;
    LikeButton likeButton;
    LikeButton thumbButton;
    LikeButton smileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize View Binding
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        toolbar = binding.toolbar;
        starButton = binding.contentMain.starButton;
        likeButton = binding.contentMain.heartButton;
        thumbButton = binding.contentMain.thumbButton;
        smileButton = binding.contentMain.smileButton;

        binding.contentMain.button.setOnClickListener(v -> {
            navigateToList();
        });

        setSupportActionBar(toolbar);

        starButton.setOnAnimationEndListener(this);
        starButton.setOnLikeListener(this);

        likeButton.setOnLikeListener(this);
        likeButton.setOnAnimationEndListener(this);

        smileButton.setOnLikeListener(this);
        smileButton.setOnAnimationEndListener(this);

        thumbButton.setOnLikeListener(this);
        thumbButton.setOnAnimationEndListener(this);

        thumbButton.setLiked(true);

        usingCustomIcons();

    }

    public void usingCustomIcons() {

        //shown when the button is in its default state or when unLiked.
        smileButton.setUnlikeDrawable(new BitmapDrawable(getResources(), new IconicsDrawable(this, CommunityMaterial.Icon.cmd_emoticon).colorRes(android.R.color.darker_gray).sizeDp(25).toBitmap()));

        //shown when the button is liked!
        smileButton.setLikeDrawable(new BitmapDrawable(getResources(), new IconicsDrawable(this, CommunityMaterial.Icon.cmd_emoticon).colorRes(android.R.color.holo_purple).sizeDp(25).toBitmap()));
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

    @Override
    public void liked(LikeButton likeButton) {
        Toast.makeText(this, "Liked!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void unLiked(LikeButton likeButton) {
        Toast.makeText(this, "Disliked!", Toast.LENGTH_SHORT).show();
    }

    @Override public void onAnimationEnd(LikeButton likeButton) {
        Log.d(TAG, "Animation End for %s" + likeButton);
    }

    public void navigateToList()
    {
        Intent intent = new Intent(this,ListActivity.class);
        startActivity(intent);
    }
}
