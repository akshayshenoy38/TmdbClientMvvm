package com.akshay.tmdbclient.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.akshay.tmdbclient.R
import com.akshay.tmdbclient.databinding.ActivityHomeBinding
import com.akshay.tmdbclient.presentation.artist.ArtistActivity
import com.akshay.tmdbclient.presentation.movie.MovieActivity
import com.akshay.tmdbclient.presentation.tvShows.TvShowsActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding:ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_home)

        binding.movieButton.setOnClickListener {
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }

        binding.tvButton.setOnClickListener {
            val intent = Intent(this,TvShowsActivity::class.java)
            startActivity(intent)
        }

        binding.artistsButton.setOnClickListener {
            val intent = Intent(this, ArtistActivity::class.java)
            startActivity(intent)
        }

    }
}