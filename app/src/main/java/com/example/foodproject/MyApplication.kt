package com.example.foodproject

import android.app.Application
import com.example.foodproject.di.AppModule

import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class])
interface ApplicationComponent {
   fun inject(mainActivity: MainActivity)
}
class MyApplication : Application(){
    val appComponent = DaggerApplicationComponent.create()
}