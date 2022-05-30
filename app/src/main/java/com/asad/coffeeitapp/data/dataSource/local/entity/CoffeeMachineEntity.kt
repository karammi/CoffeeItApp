package com.asad.coffeeitapp.data.dataSource.local.entity

//@Entity(tableName = CoffeeMachineConstants.TABLE_NAME)
data class CoffeeMachineEntity(
//    @PrimaryKey(autoGenerate = false)
//    @ColumnInfo(name = CoffeeMachineConstants.COFFEE_MACHINE_ID)
    val id: String,
    val typeEntities: List<TypeEntity>? = null,
    val sizeEntities: List<SizeEntity>? = null,
    val extraEntities: List<ExtraEntity>? = null,
) {
//    @Ignore
//    @Transient


//    @Ignore
//    @Transient

//    @Ignore
//    @Transient

}
