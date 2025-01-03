package org.wizard.project.di

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import org.wizard.project.Car
import org.wizard.project.repository.movie_details.SingleMovieDetails
import org.wizard.project.repository.movie_list.MoviePager
import org.wizard.project.repository.movie_list.MoviePagingSource
import org.wizard.project.repository.movie_list.SignInRepository
import org.wizard.project.ui.page.MovieDetails
import org.wizard.project.viewmodel.MyViewModel



val networkModule = module {

    factory {
        Car()
    }

    factory {
        SignInRepository(httpClient = get())
    }

    factory {
        SingleMovieDetails(
            httpClient = get()
        )
    }

    factory {
        MoviePagingSource(signInRepository = get())
    }

    factory {
        MoviePager(
            httpClient = get()
        )
    }

    viewModel {
        MyViewModel(car = get(), moviePager = get(), singleMovieDetails = get())
    }
}
