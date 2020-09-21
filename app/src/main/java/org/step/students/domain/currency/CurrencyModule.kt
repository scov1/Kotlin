package org.step.students.domain.currency

import dagger.Module
import dagger.Provides


@Module
class CurrencyModule {

    @Provides
    fun providesCurrenciesUseCase(): CurrencyUseCase {
        return CurrencyUseCase()
    }
}