package com.asad.coffeeitapp.core

interface DbMapper<E, M> {
    fun mapToEntity(model: M): E
    fun mapFromEntity(entity: E): M
}
