package com.asad.coffeeitapp.data.mapper

import com.asad.coffeeitapp.core.ResponseMapper
import com.asad.coffeeitapp.data.dataSource.remote.model.CoffeeMachineResponseModel
import com.asad.coffeeitapp.domain.model.CoffeeMachineModel

class FakeCoffeeMachineResponseMapper :
    ResponseMapper<CoffeeMachineModel, CoffeeMachineResponseModel> {
    override fun mapToModel(model: CoffeeMachineResponseModel): CoffeeMachineModel {
        TODO("Not yet implemented")
    }

    override fun mapFromModel(model: CoffeeMachineModel): CoffeeMachineResponseModel {
        TODO("Not yet implemented")
    }
}
