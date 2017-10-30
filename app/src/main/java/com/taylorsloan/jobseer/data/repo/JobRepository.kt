package com.taylorsloan.jobseer.data.repo

import com.taylorsloan.jobseer.data.model.Job
import io.reactivex.Observable

/**
 * Created by taylo on 10/29/2017.
 */
interface JobRepository {
    fun getJobs(description: String? = null,
                location: String? = null,
                lat: Double? = null,
                long: Double? = null,
                fullTime: Boolean? = null) : Observable<List<Job>>

    fun getMoreJobs(description: String? = null,
             location: String? = null,
             lat: Double? = null,
             long: Double? = null,
             fullTime: Boolean? = null,
             page: Int = 0)

    fun job(id: String) : Observable<Job>
}