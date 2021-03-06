package com.taylorsloan.jobseer.dagger.module

import com.taylorsloan.jobseer.dagger.scope.DataScope
import dagger.Module
import dagger.Provides
import java.io.File

/**
 * Created by taylo on 10/29/2017.
 */
@Module
class TestStorageModule {

    @Provides
    @DataScope
    fun provideBoxStore() : BoxStore{
        val tempFile = File.createTempFile("object-store-test", "")
        tempFile.delete()
        return MyObjectBox.builder().directory(tempFile).build()
    }
}