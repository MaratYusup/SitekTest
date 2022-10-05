package com.example.mobileclient.data.database

import androidx.room.*

@Dao
interface UserAuthDataModelDao {

    @Transaction
    fun updateItemByUID(userAuthDataModelDb: UserAuthDataModelDb?, uid: String?) {
        deleteItemByUid(uid)
        addItem(userAuthDataModelDb)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addItem(userAuthDataModelDb: UserAuthDataModelDb?)

    @Query("DELETE FROM userAuthDbTable")
    fun deleteAllItems()

    @Query("DELETE FROM userAuthDbTable where userAuth_uid ==:uid")
    fun deleteItemByUid(uid: String?)

    @Query("select * from userAuthDbTable where userAuth_uid ==:uid ")
    fun getItemByUid(uid: String?): UserAuthDataModelDb?

}