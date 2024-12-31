package org.wizard.project.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import org.wizard.project.Car
import org.wizard.project.repository.movie_details.SingleMovieDetails
import org.wizard.project.repository.movie_list.MoviePager

class MyViewModel constructor(
    private val car: Car,
    private val moviePager: MoviePager,
    private val singleMovieDetails: SingleMovieDetails
) : ViewModel() {

    fun getCar() : String =car.displayCar()

    val moviepage = moviePager.movie.cachedIn(viewModelScope)

    //todo single movie details -----
    val movieDetailsStateFlow = singleMovieDetails.stateFlow
    fun getSingleMovieDetails(movieId : String){
        try {
            viewModelScope.launch(Dispatchers.IO) {
                singleMovieDetails.getSingleMovie(
                    movieId = movieId
                )
            }
        }catch (e : Exception){
            e.printStackTrace()
        }
    }
    //todo single movie details -----
}