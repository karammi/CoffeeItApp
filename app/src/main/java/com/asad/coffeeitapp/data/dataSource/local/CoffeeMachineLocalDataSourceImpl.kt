package com.asad.coffeeitapp.data.dataSource.local

import com.asad.coffeeitapp.data.dataSource.local.dao.SizeDao
import com.asad.coffeeitapp.data.dataSource.local.dao.SubSelectionDao
import com.asad.coffeeitapp.data.dataSource.local.entity.CoffeeMachineEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

// @ViewModelScoped
class CoffeeMachineLocalDataSourceImpl @Inject constructor(
//    private val coffeeMachineDao: CoffeeMachineDao,
//    private val typeDao: TypeDao,
    private val sizeDao: SizeDao,
//    private val extraDao: ExtraDao,
    private val subSelectionDao: SubSelectionDao,
) : CoffeeMachineLocalDataSource {

    override suspend fun insertCoffeeMachine(coffeeMachineEntity: CoffeeMachineEntity) {
        println("${coffeeMachineEntity.sizeEntities}")
        withContext(Dispatchers.IO) {
            coffeeMachineEntity.sizeEntities?.forEach {
                sizeDao.insertSize(it)
            }
            coffeeMachineEntity.extraEntities?.forEach { currentExtra ->
                currentExtra.subSelectionEntities?.forEach { currentSubSelection ->
                    subSelectionDao.insertSubSelection(currentSubSelection)
                }
            }
        }

/*        withContext(Dispatchers.IO) {
            val sizeList = coffeeMachineEntity.sizeEntities
            if (sizeList != null) {
                for (item in sizeList) {
                    sizeDao.insertSize(item)
                }
            }

            val extraList = coffeeMachineEntity.extraEntities
            if (extraList != null) {
                for (item in extraList) {
                    extraDao.insertExtra(item)
                }
            }

            val typeList = coffeeMachineEntity.typeEntities
            if (typeList != null) {
                for (item in typeList) {
                   typeDao.insertType(item)
                }
            }

        }*/
    }
}
