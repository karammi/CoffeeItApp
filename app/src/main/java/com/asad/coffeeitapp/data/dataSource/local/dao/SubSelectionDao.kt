package com.asad.coffeeitapp.data.dataSource.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.asad.coffeeitapp.data.dataSource.local.entity.SubSelectionEntity
import com.asad.coffeeitapp.data.dataSource.local.util.SubSelectionConstants

@Dao
interface SubSelectionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubSelection(subSelectionEntity: SubSelectionEntity)

    @Delete
    suspend fun deleteSubSelection(subSelectionEntity: SubSelectionEntity)

    @Query("SELECT * FROM ${SubSelectionConstants.TABLE_NAME} WHERE ${SubSelectionConstants.COLUMN_ID} IN (:id)")
    suspend fun fetchSubSelections(id: List<String>): List<SubSelectionEntity>
}
