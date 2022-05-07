package com.asad.coffeeitapp.data.mapper

import com.asad.coffeeitapp.core.ResponseMapper
import com.asad.coffeeitapp.data.dataSource.remote.model.SubSelectionResponseModel
import com.asad.coffeeitapp.domain.model.SubSelectionModel
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class SubSelectionResponseMapper @Inject constructor() :
    ResponseMapper<SubSelectionModel, SubSelectionResponseModel> {
    override fun mapToModel(model: SubSelectionResponseModel): SubSelectionModel {
        return with(model) {
            SubSelectionModel(id, name)
        }
    }

    override fun mapFromModel(model: SubSelectionModel): SubSelectionResponseModel {
        return with(model) {
            SubSelectionResponseModel(id, name)
        }
    }
}
