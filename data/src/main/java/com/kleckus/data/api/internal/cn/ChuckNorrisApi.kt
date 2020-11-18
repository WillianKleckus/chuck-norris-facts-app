package com.kleckus.data.api.internal.cn

import com.kleckus.data.api.internal.RetrofitBuilder
import com.kleckus.domain.models.Joke
import com.kleckus.domain.services.ApiService

internal class ChuckNorrisApi : ApiService {
    companion object{
        const val BASE_URL = "https://api.chucknorris.io/jokes/"
    }

    private val service : CNApiDefinition by lazy{
        RetrofitBuilder
            .getRetrofitService(
                RetrofitBuilder
                    .buildRetrofit(BASE_URL)
            ) as CNApiDefinition
    }

    override suspend fun getRandomJoke(): Joke {
        return service.getRandomJoke()
    }

}