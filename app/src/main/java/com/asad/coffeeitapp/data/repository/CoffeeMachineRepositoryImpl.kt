package com.asad.coffeeitapp.data.repository

import com.asad.coffeeitapp.core.ResponseMapper
import com.asad.coffeeitapp.core.Result
import com.asad.coffeeitapp.core.data
import com.asad.coffeeitapp.data.dataSource.local.CoffeeMachineLocalDataSource
import com.asad.coffeeitapp.data.dataSource.local.entity.*
import com.asad.coffeeitapp.data.dataSource.remote.CoffeeMachineRemoteDataSource
import com.asad.coffeeitapp.data.mapper.CoffeeMachineResponseMapper
import com.asad.coffeeitapp.domain.model.*
import com.asad.coffeeitapp.domain.repository.CoffeeMachineRepository
import javax.inject.Inject

// @ViewModelScoped
class CoffeeMachineRepositoryImpl @Inject constructor(
    private val coffeeMachineRemoteDataSource: CoffeeMachineRemoteDataSource,
    private val coffeeMachineLocalDataSource: CoffeeMachineLocalDataSource,
    private val coffeeMachineResponseMapper: CoffeeMachineResponseMapper,
) : CoffeeMachineRepository {
    override suspend fun fetchCoffeeMachineInfo(id: String): Result<CoffeeMachineModel> {
        val temp = coffeeMachineRemoteDataSource.fetchCoffeeMachineInfo(id)
        return when (temp) {
            is Result.Error -> Result.Error(temp.apiErrorBody)
            Result.Loading -> Result.Loading
            is Result.Success -> {
//                coffeeMachineLocalDataSource.insertCoffeeMachine()
                Result.Success(coffeeMachineResponseMapper.mapToModel(temp.data))
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
