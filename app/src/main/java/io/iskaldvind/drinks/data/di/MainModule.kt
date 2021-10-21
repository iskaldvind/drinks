package io.iskaldvind.drinks.data.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.iskaldvind.drinks.presentation.MainActivity

@Module
interface MainModule {

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity
}