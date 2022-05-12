package com.asad.coffeeitapp.data.dataSource.local.dao

import androidx.room.*
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
