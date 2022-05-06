package com.asad.coffeeitapp.data.mapper

import com.asad.coffeeitapp.core.ResponseMapper
import com.asad.coffeeitapp.data.dataSource.remote.model.ExtraResponseModel
import com.asad.coffeeitapp.domain.model.ExtraModel
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class ExtraResponseMapper @Inject constructor(
    private val subSelectionResponseMapper: SubSelectionResponseMapper,
) : ResponseMapper<ExtraModel, ExtraResponseModel> {
    override fun mapToModel(model: ExtraResponseModel): ExtraModel {
        return ExtraModel(
            model.id,
            model.name,
            subSelectionModels = model.subSelectionResponseModels.map {
                subSelectionResponseMapper.mapToModel(it)
            }
        )
    }

    override fun mapFromModel(model: ExtraModel): ExtraResponseModel {
        return with(model) {
            ExtraResponseModel(
                id,
                name,
                subSelectionModels.map {
                    subSelectionResponseMapper.mapFromModel(it)
                }
            )
        }
    }
}
