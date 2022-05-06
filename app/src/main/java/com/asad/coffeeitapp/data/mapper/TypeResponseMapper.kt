package com.asad.coffeeitapp.data.mapper

import com.asad.coffeeitapp.core.ResponseMapper
import com.asad.coffeeitapp.data.dataSource.remote.model.TypeResponseModel
import com.asad.coffeeitapp.domain.model.TypeModel
import javax.inject.Inject

class TypeResponseMapper @Inject constructor() : ResponseMapper<TypeModel, TypeResponseModel> {
    override fun mapToModel(model: TypeResponseModel): TypeModel {
        return with(model) {
            TypeModel(id, name, sizes, extras)
        }
    }

    override fun mapFromModel(model: TypeModel): TypeResponseModel {
        return with(model) {
            TypeResponseModel(id, name, sizes, extras)
        }
    }
}
