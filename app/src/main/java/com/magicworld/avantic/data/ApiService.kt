package com.magicworld.avantic.data

import com.magicworld.avantic.model.Lugares
import retrofit2.http.GET

interface ApiService {

    @GET("kevindives/Avantic/blob/master/lugares")
    suspend fun getLugares(): Lugares
}