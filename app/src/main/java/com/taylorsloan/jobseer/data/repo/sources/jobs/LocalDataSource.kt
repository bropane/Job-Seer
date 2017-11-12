package com.taylorsloan.jobseer.data.repo.sources.jobs

import com.taylorsloan.jobseer.data.DataModule
import com.taylorsloan.jobseer.data.model.DataResult
import com.taylorsloan.jobseer.data.model.Job
import com.taylorsloan.jobseer.data.model.Job_
import io.objectbox.Box
import io.objectbox.BoxStore
import io.objectbox.rx.RxQuery
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by taylorsloan on 10/28/17.
 */
class LocalDataSource(dataModule: DataModule) : DataSource {

    @Inject
    lateinit var boxStore : BoxStore

    init {
        dataModule.storageComponent().inject(this)
        initJobBox()
    }

    private lateinit var jobBox : Box<Job>

    private fun initJobBox(){
        jobBox = boxStore.boxFor(Job::class.java)
    }

    override fun jobs(description: String?,
                      location: String?,
                      lat: Double?,
                      long: Double?,
                      fullTime: Boolean?,
                      page: Int): Observable<DataResult<List<Job>>> {
        return RxQuery.observable(jobBox.query().build())
                .map { DataResult(data = it) }
    }

    override fun job(id: String): Observable<DataResult<Job>> {
        return RxQuery.observable(jobBox.query().equal(Job_.id, id).build())
                .map{ DataResult(data = it [0]) }
    }

    override fun clearJobs() {
        jobBox.removeAll()
    }
}