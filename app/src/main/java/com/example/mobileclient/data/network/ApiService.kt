package com.example.mobileclient.data.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("{imei}" + NetConst.GET_USERS_URL)
    suspend fun getUsers(@Path("imei") imei: String): Response<*>

    @GET("{imei}" + NetConst.AUTHENTICATION_URL)
    suspend fun authentication(
        @Path(NetConst.IMEI) imei: String,
        @Query(NetConst.UID) uid: String,
        @Query(NetConst.PASS) pass: String,
        @Query(NetConst.COPY_FROM_DEVICE) copyFromDevice: Boolean,
        @Query(NetConst.NFC) nfc: String,
    ): Response<*>
}