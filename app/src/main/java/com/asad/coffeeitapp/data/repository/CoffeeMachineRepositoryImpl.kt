package com.asad.coffeeitapp.data.repository

import com.asad.coffeeitapp.core.ResponseMapper
import com.asad.coffeeitapp.core.Result
import com.asad.coffeeitapp.data.dataSource.local.entity.CoffeeMachineEntity
import com.asad.coffeeitapp.data.dataSource.local.entity.ExtraEntity
import com.asad.coffeeitapp.data.dataSource.local.entity.SizeEntity
import com.asad.coffeeitapp.data.dataSource.local.entity.SubSelectionEntity
import com.asad.coffeeitapp.data.dataSource.local.entity.TypeEntity
import com.asad.coffeeitapp.data.dataSource.remote.CoffeeMachineRemoteDataSource
import com.asad.coffeeitapp.data.dataSource.remote.model.mapper
import com.asad.coffeeitapp.domain.model.CoffeeMachineModel
import com.asad.coffeeitapp.domain.model.ExtraModel
import com.asad.coffeeitapp.domain.model.SizeModel
import com.asad.coffeeitapp.domain.model.SubSelectionModel
import com.asad.coffeeitapp.domain.model.TypeModel
import com.asad.coffeeitapp.domain.repository.CoffeeMachineRepository
import javax.inject.Inject

// @ViewModelScoped
class CoffeeMachineRepositoryImpl @Inject constructor(
    private val coffeeMachineRemoteDataSource: CoffeeMachineRemoteDataSource,
//    private val coffeeMachineLocalDataSource: CoffeeMachineLocalDataSource,
//    private val coffeeMachineResponseMapper: CoffeeMachineResponseMapper,
) : CoffeeMachineRepository {
    override suspend fun fetchCoffeeMachineInfo(id: String): Result<CoffeeMachineModel> {
        return when (val response = coffeeMachineRemoteDataSource.fetchCoffeeMachineInfo(id)) {
            is Result.Error -> Result.Error(response.apiErrorBody)
            Result.Loading -> Result.Loading
            is Result.Success -> {
                Result.Success(response.data.mapper())
            }
        }
    }

    override suspend fun checkDeviceConnection(): Result<String> {
        return coffeeMachineRemoteDataSource.checkDeviceConnection()
    }
}

class CoffeeMachineModelToDataBaseEntityMapper @Inject constructor() :
    ResponseMapper<CoffeeMachineEntity, CoffeeMachineModel> {
    override fun mapToModel(model: CoffeeMachineModel): CoffeeMachineEntity {
        return CoffeeMachineEntity(
            model.id,
        )
    }

    override fun mapFromModel(model: CoffeeMachineEntity): CoffeeMachineModel {
        return CoffeeMachineModel(
            model.id,
            emptyList(),
            emptyList(),
            emptyList()
        )
    }
}

class TypeModelToDataBaseEntityMapper @Inject constructor() :
    ResponseMapper<TypeEntity, TypeModel> {
    override fun mapToModel(model: TypeModel): TypeEntity {
        return TypeEntity(
            model.id,
            model.name
        )
    }

    override fun mapFromModel(model: TypeEntity): TypeModel {
        return TypeModel(
            model.id,
            model.name,
            emptyList(),
            emptyList()
        )
    }
}

class SizeModelToDataBaseEntityMapper @Inject constructor() :
    ResponseMapper<SizeEntity, SizeModel> {
    override fun mapToModel(model: SizeModel): SizeEntity {
        return SizeEntity(
            model.id,
            model.name
        )
    }

    override fun mapFromModel(model: SizeEntity): SizeModel {
        return SizeModel(
            model.id,
            model.name
        )
    }
}

class ExtraModelToDataBaseEntityMapper @Inject constructor(
    private val mapper: SubSelectionModelToDataBaseEntityMapper,
) :
    ResponseMapper<ExtraEntity, ExtraModel> {
    override fun mapToModel(model: ExtraModel): ExtraEntity {
        return ExtraEntity(
            model.id,
            model.name
        )
    }

    override fun mapFromModel(model: ExtraEntity): ExtraModel {
        return ExtraModel(
            model.id, model.name,
            model.subSelectionEntities?.map {
                mapper.mapFromModel(it)
            } ?: emptyList()
        )
    }
}

class SubSelectionModelToDataBaseEntityMapper @Inject constructor() :
    ResponseMapper<SubSelectionEntity, SubSelectionModel> {
    override fun mapToModel(model: SubSelectionModel): SubSelectionEntity {
        return SubSelectionEntity(model.id, model.name)
    }

    override fun mapFromModel(model: SubSelectionEntity): SubSelectionModel {
        return SubSelectionModel(model.id, model.name)
    }
}
