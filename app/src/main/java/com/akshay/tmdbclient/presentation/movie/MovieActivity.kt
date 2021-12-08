package com.akshay.tmdbclient.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.akshay.tmdbclient.R
import com.akshay.tmdbclient.databinding.ActivityMovieBinding
import com.akshay.tmdbclient.presentation.di.Injector
import javax.inject.Inject


class MovieActivity : AppCompatActivity() {
    private val TAG = "MovieActivity"
    lateinit var binding:ActivityMovieBinding

    private lateinit var adapter: MovieAdapter

    @Inject
    lateinit var movieViewModelFactory: MovieViewModelFactory

    private lateinit var movieViewModel: MovieViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_movie)
        (application as Injector).createMovieSubComponent()
            .inject(this)


        movieViewModel = ViewModelProvider(this,movieViewModelFactory)
            .get(MovieViewModel::class.java)
        initRecyclerView()

    }

    private fun initRecyclerView() {
        binding.rvMovie.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter()
        binding.rvMovie.adapter = adapter
        displayPopularMovies()
    }

    private fun displayPopularMovies() {
        binding.pbMovie.visibility = View.VISIBLE
        val responseLiveData = movieViewModel.getMovies()
        responseLiveData.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.pbMovie.visibility = View.GONE
            }else{
                binding.pbMovie.visibility = View.GONE
                Toast.makeText(applicationContext,"No data available", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_update -> {
                updateMovies()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun updateMovies(){
        binding.pbMovie.visibility = View.VISIBLE
        val response = movieViewModel.updateMovies()
        response.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.pbMovie.visibility = View.GONE
            }else{
                binding.pbMovie.visibility = View.GONE
            }
        })
    }
}