package org.wizard.project.di

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import org.wizard.project.Car
import org.wizard.project.repository.MoviePager
import org.wizard.project.repository.MoviePagingSource
import org.wizard.project.repository.SignInRepository
import org.wizard.project.viewmodel.MyViewModel


val networkModule = module {

    factory {
        Car()
    }

    factory {
        SignInRepository(httpClient = get())
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
        MyViewModel(car = get(), moviePager = get())
    }
}
