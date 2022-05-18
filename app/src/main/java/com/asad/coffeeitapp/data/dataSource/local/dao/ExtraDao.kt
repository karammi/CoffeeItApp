package com.asad.coffeeitapp.data.dataSource.local.dao

import androidx.room.*
import com.asad.coffeeitapp.data.dataSource.local.entity.ExtraEntity
import com.asad.coffeeitapp.data.dataSource.local.util.ExtraConstants

@Dao
interface ExtraDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExtra(vararg extraEntity: ExtraEntity)

    @Delete
    suspend fun deleteExtra(extraEntity: ExtraEntity)

    @Query(value = "SELECT * FROM ${ExtraConstants.TABLE_NAME} WHERE ${ExtraConstants.COLUMN_ID} IN (:id)")
    suspend fun fetchExtras(id: List<String>): List<ExtraEntity>
}
