package com.magicworld.avantic.data

class LugaresRepository {

    suspend fun getlugares() =ApiFactory.retrofit.getLugares()
}