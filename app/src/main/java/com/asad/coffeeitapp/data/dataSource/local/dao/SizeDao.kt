package com.asad.coffeeitapp.data.dataSource.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.asad.coffeeitapp.data.dataSource.local.entity.SizeEntity
import com.asad.coffeeitapp.data.dataSource.local.util.SizeConstants

@Dao
interface SizeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSize(sizeEntity: SizeEntity)

    @Delete
    suspend fun deleteSize(sizeEntity: SizeEntity)

    @Query(value = "SELECT * FROM ${SizeConstants.TABLE_NAME} WHERE ${SizeConstants.COLUMN_ID} IN (:id)")
    suspend fun fetchSize(id: List<String>): List<SizeEntity>
}
