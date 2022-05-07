package com.asad.coffeeitapp.core

/**
 * interface to map json response to domain model
 * M : Domain Model
 * T : Json model
 * */
interface ResponseMapper<M, T> {
    fun mapToModel(model: T): M
    fun mapFromModel(model: M): T
}
