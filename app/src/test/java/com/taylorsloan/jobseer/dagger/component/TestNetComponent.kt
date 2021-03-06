package com.taylorsloan.jobseer.dagger.component

import com.taylorsloan.jobseer.dagger.module.TestNetModule
import com.taylorsloan.jobseer.dagger.scope.DataScope
import com.taylorsloan.jobseer.data.job.net.service.GeocodingServiceTest
import com.taylorsloan.jobseer.data.job.net.service.GitHubJobsServiceTest
import dagger.Component

/**
 * Created by taylorsloan on 10/28/17.
 */
@DataScope
@Component(modules = arrayOf(TestNetModule::class))
interface TestNetComponent : NetComponent{
    fun inject(serviceTest: GitHubJobsServiceTest)
    fun inject(serviceTest: GeocodingServiceTest)
}