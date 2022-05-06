package com.asad.coffeeitapp.data.mapper

import com.asad.coffeeitapp.core.ResponseMapper
import com.asad.coffeeitapp.data.dataSource.remote.model.SizeResponseModel
import com.asad.coffeeitapp.domain.model.SizeModel
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class SizeResponseMapper @Inject constructor() : ResponseMapper<SizeModel, SizeResponseModel> {
    override fun mapToModel(model: SizeResponseModel): SizeModel {
        return with(model) {
            SizeModel(id, name, v)
        }
    }

    override fun mapFromModel(model: SizeModel): SizeResponseModel {
        return with(model) {
            SizeResponseModel(id, name, v)
        }
    }
}
