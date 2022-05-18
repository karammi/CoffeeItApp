package com.asad.coffeeitapp.data.dataSource.local.dao

import androidx.room.*
import com.asad.coffeeitapp.data.dataSource.local.entity.TypeEntity
import com.asad.coffeeitapp.data.dataSource.local.util.TypeConstants

@Dao
interface TypeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertType(typeEntity: TypeEntity)

    @Delete
    suspend fun deleteType(typeEntity: TypeEntity)

    @Query("SELECT * FROM ${TypeConstants.TABLE_NAME} WHERE ${TypeConstants.ID_COLUMN} IN (:id)")
    suspend fun fetchAllType(id: List<String>): List<TypeEntity>
}
