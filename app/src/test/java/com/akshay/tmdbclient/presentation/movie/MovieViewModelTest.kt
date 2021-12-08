package com.akshay.tmdbclient.presentation.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.akshay.tmdbclient.data.model.movie.Movie
import com.akshay.tmdbclient.data.repository.movie.FakeMovieRepository
import com.akshay.tmdbclient.domain.usecases.GetMoviesUsecase
import com.akshay.tmdbclient.domain.usecases.UpdateMoviesUseCase
import com.akshay.tmdbclient.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MovieViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel:MovieViewModel


    @Before
    fun setup() {
        val fakeMovieRepository = FakeMovieRepository()
        val getMovieUseCase = GetMoviesUsecase(fakeMovieRepository)
        val updateMovieUseCase = UpdateMoviesUseCase(fakeMovieRepository)
        viewModel = MovieViewModel(getMovieUseCase,updateMovieUseCase)
    }

    @Test
    fun getMovies_returnsCurrentList() {
        val movies = mutableListOf<Movie>()
        movies.add(Movie(1,"overview1","posterPath1","date1","title1"))
        movies.add( Movie(2,"overview2","posterPath2","date2","title2"))

        val currentMoviesList = viewModel.getMovies().getOrAwaitValue()
        assertThat(currentMoviesList).isEqualTo(movies)
    }

    @Test
    fun updateMovies_returnsUpdatedList(){
        val movies = mutableListOf<Movie>()
        movies.add(Movie(3,"overview3","posterPath3","date3","title3"))
        movies.add( Movie(4,"overview4","posterPath4","date4","title4"))

        val updatedList = viewModel.updateMovies().getOrAwaitValue()
        assertThat(updatedList).isEqualTo(movies)

    }

}