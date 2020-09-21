package org.step.students.domain

import dagger.Module
import dagger.Provides
import org.step.students.domain.api.ApiImplementation


@Module
class NetworkModule {
    @Provides
    fun providesApi() : ApiImplementation {
        return ApiImplementation()
    }
}