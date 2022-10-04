package com.example.mobileclient.data.network

import android.util.Base64
import com.example.mobileclient.data.network.model.UserDataDto
import com.example.mobileclient.data.network.model.UserDto
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("{imei}" + NetConst.GET_USERS_URL)
    suspend fun getUsersList(
        @Header(NetConst.AUTHORIZATION) header: String,
        @Path(NetConst.IMEI) imei: String,
    ): Response<UserDto>

    @GET("{imei}" + NetConst.AUTHENTICATION_URL)
    suspend fun authentication(
        @Path(NetConst.IMEI) imei: String,
        @Query(NetConst.UID) uid: String,
        @Query(NetConst.PASS) pass: String,
        @Query(NetConst.COPY_FROM_DEVICE) copyFromDevice: Boolean,
        @Query(NetConst.NFC) nfc: String,
    ): Response<*>
}