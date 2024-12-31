package org.wizard.project.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import org.wizard.project.Car
import org.wizard.project.repository.MoviePager

class MyViewModel constructor(
    private val car: Car,
    private val moviePager: MoviePager
) : ViewModel() {

    fun getCar() : String =car.displayCar()

    val moviepage = moviePager.movie.cachedIn(viewModelScope)
}