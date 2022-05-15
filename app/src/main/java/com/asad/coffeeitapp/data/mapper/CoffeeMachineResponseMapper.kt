package com.asad.coffeeitapp.data.mapper

import com.asad.coffeeitapp.core.ResponseMapper
import com.asad.coffeeitapp.data.dataSource.remote.model.CoffeeMachineResponseModel
import com.asad.coffeeitapp.domain.model.CoffeeMachineModel
import javax.inject.Inject

// @ViewModelScoped
class CoffeeMachineResponseMapper @Inject constructor(
    private val typeResponseMapper: TypeResponseMapper,
    private val sizeResponseMapper: SizeResponseMapper,
    private val extraResponseMapper: ExtraResponseMapper,
) : ResponseMapper<CoffeeMachineModel, CoffeeMachineResponseModel> {

    override fun mapToModel(model: CoffeeMachineResponseModel): CoffeeMachineModel {
        return CoffeeMachineModel(
            model.id,
            model.typeResponseModels.map {
                typeResponseMapper.mapToModel(it)
            },
            model.sizeResponseModels.map {
                sizeResponseMapper.mapToModel(it)
            },
            model.extraResponseModels.map {
                extraResponseMapper.mapToModel(it)
            }
        )
    }

    override fun mapFromModel(model: CoffeeMachineModel): CoffeeMachineResponseModel {
        return CoffeeMachineResponseModel(
            model.id,
            model.typeModels.map {
                typeResponseMapper.mapFromModel(it)
            },
            model.sizeModels.map {
                sizeResponseMapper.mapFromModel(it)
            },
            model.extraModels.map {
                extraResponseMapper.mapFromModel(it)
            }
        )
    }
}
