package com.taylorsloan.jobseer.dagger.module

import android.app.Application
import com.taylorsloan.jobseer.dagger.scope.DataScope
import com.taylorsloan.jobseer.data.model.MyObjectBox
import dagger.Module
import dagger.Provides
import io.objectbox.BoxStore

/**
 * Created by taylorsloan on 10/28/17.
 */
@Module
class StorageModule {

    @Provides
    @DataScope
    fun provideBoxStore(application: Application) : BoxStore{
        return MyObjectBox.builder().androidContext(application).build()
    }
}