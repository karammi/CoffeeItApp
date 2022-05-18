package com.asad.coffeeitapp.data.dataSource.local

import com.asad.coffeeitapp.data.dataSource.local.entity.CoffeeMachineEntity
import javax.inject.Inject

// @ViewModelScoped
class CoffeeMachineLocalDataSourceImpl @Inject constructor(
//    private val coffeeMachineDao: CoffeeMachineDao,
//    private val typeDao: TypeDao,
//    private val sizeDao: SizeDao,
//    private val extraDao: ExtraDao,
//    private val subSelectionDao: SubSelectionDao,
) : CoffeeMachineLocalDataSource {

    override suspend fun insertCoffeeMachine(coffeeMachineEntity: CoffeeMachineEntity) {
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
