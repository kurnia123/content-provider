package com.example.filmgan2.tvshow;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.filmgan2.R;
import com.example.filmgan2.film.DetailFilm;
import com.example.filmgan2.localization.LocaleHelper;
import com.example.filmgan2.tvshow.model.TvShowData;
import com.squareup.picasso.Picasso;

import java.util.Locale;

public class DetailTVShow extends AppCompatActivity implements View.OnClickListener {

    TvShowData data;
    public static String EXTRA_NAME = "data";
    public static String KEY_CONFIGURATION = "key_configuration";
    ImageView imagebackground;
    ImageView imagedetail;
    ImageView like;
    ImageView detailBack;
    TextView judul;
    TextView kategori;
    TextView kreator;
    TextView rating;
    TextView description;

    String urlPoster = "https://image.tmdb.org/t/p/w185/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tvshow);
        updateLanguage(LocaleHelper.getLanguage(this));
        this.data = getIntent().getParcelableExtra(EXTRA_NAME);

        detailBack = findViewById(R.id.detail_back_tv);
        like = findViewById(R.id.detail_fav_tv);
        imagebackground = findViewById(R.id.image_tv_background);
        imagedetail = findViewById(R.id.detail_image_tv);
        judul = findViewById(R.id.detail_judul_tv);
        kategori = findViewById(R.id.detail_kategori_tv);
        kreator = findViewById(R.id.creator_tv);
        rating = findViewById(R.id.detail_rating);
        description = findViewById(R.id.detail_description_tv);

        Picasso.with(this).load(urlPoster + data.getImageTv()).into(imagedetail);
        Picasso.with(this).load(urlPoster + data.getImageTv()).into(imagebackground);

        judul.setText(data.getJudulTv());
        kreator.setText("Creator : " + data.getCreator());
//        kategori.setText(data.getGenreTV());
        rating.setText(String.valueOf(data.getRating()));
        description.setText(data.getDescription());

        like.setOnClickListener(this);
        detailBack.setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("AWALonCreate",LocaleHelper.getLanguage(this));
    }

    private void updateLanguage(String language){
        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Configuration config = new Configuration();
        config.locale = locale;

        getResources().updateConfiguration(
                config,
                getResources().getDisplayMetrics()
        );
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.detail_fav_tv:
                like.setImageResource(R.drawable.ic_favorite_pink_24dp);
                break;
            case R.id.detail_back_tv:
                finish();
                break;
        }
    }

    private void setActionBarTitle(String title){
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle(title);
        }
    }
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              