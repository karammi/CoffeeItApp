package com.asad.coffeeitapp.data.dataSource.remote

import com.asad.coffeeitapp.data.dataSource.remote.model.*
import com.asad.coffeeitapp.domain.model.*

object FakeData {
    val FakeCoffeeMachineResponse = CoffeeMachineResponseModel(
        id = "60ba1ab72e35f2d9c786c610",
        typeResponseModels = listOf(
            TypeResponseModel(
                id = "60ba1a062e35f2d9c786c56d",
                name = "Ristretto",
                sizes = listOf("60ba18d13ca8c43196b5f606", "60ba3368c45ecee5d77a016b"),
                extras = listOf("60ba197c2e35f2d9c786c525")
            ),
            TypeResponseModel(
                id = "60be1db3c45ecee5d77ad890",
                name = "Espresso",
                sizes = listOf("60ba3368c45ecee5d77a016b", "60ba33dbc45ecee5d77a01f8"),
                extras = listOf("60ba34a0c45ecee5d77a0263")
            ),
            TypeResponseModel(
                id = "60be1eabc45ecee5d77ad960",
                name = "Cappuccino",
                sizes = listOf(
                    "60ba18d13ca8c43196b5f606",
                    "60ba3368c45ecee5d77a016b",
                    "60ba33dbc45ecee5d77a01f8"
                ),
                extras = listOf("60ba197c2e35f2d9c786c525", "60ba34a0c45ecee5d77a0263")
            )
        ),
        sizeResponseModels = listOf(
            SizeResponseModel(
                id = "60ba18d13ca8c43196b5f606",
                name = "Large",
                v = 0
            ),
            SizeResponseModel(
                id = "60ba3368c45ecee5d77a016b",
                name = "Venti",
                v = null
            ),
            SizeResponseModel(id = "60ba33dbc45ecee5d77a01f8", name = "Tall", v = null)
        ),
        extraResponseModels = listOf(
            ExtraResponseModel(
                id = "60ba197c2e35f2d9c786c525",
                name = "Select the amount of sugar",
                subSelectionResponseModels = listOf(
                    SubSelectionResponseModel(
                        id = "60ba194dfdd5e192e14eaa75",
                        name = "A lot"
                    ),
                    SubSelectionResponseModel(
                        id = "60ba195407e1dc8a4e33b5e5",
                        name = "Normal"
                    )
                )
            ),
            ExtraResponseModel(
                id = "60ba34a0c45ecee5d77a0263",
                name = "Select type of milk",
                subSelectionResponseModels = listOf(
                    SubSelectionResponseModel(
                        id = "611a1adeff35e4db9df19667",
                        name = "Soy"
                    ),
                    SubSelectionResponseModel(
                        id = "60ba348d8c75424ac5ed259e",
                        name = "Oat"
                    ),
                    SubSelectionResponseModel(
                        id = "60ba349a869d7a04642b41f4",
                        name = "Cow"
                    )
                )
            )
        )
    )
    val FakeCoffeeMachine = CoffeeMachineModel(
        id = "60ba1ab72e35f2d9c786c610",
        typeModels = listOf(
            TypeModel(
                id = "60ba1a062e35f2d9c786c56d",
                name = "Ristretto",
                sizes = listOf("60ba18d13ca8c43196b5f606", "60ba3368c45ecee5d77a016b"),
                extras = listOf("60ba197c2e35f2d9c786c525")
            ),
            TypeModel(
                id = "60be1db3c45ecee5d77ad890",
                name = "Espresso",
                sizes = listOf("60ba3368c45ecee5d77a016b", "60ba33dbc45ecee5d77a01f8"),
                extras = listOf("60ba34a0c45ecee5d77a0263")
            ),
            TypeModel(
                id = "60be1eabc45ecee5d77ad960",
                name = "Cappuccino",
                sizes = listOf(
                    "60ba18d13ca8c43196b5f606",
                    "60ba3368c45ecee5d77a016b",
                    "60ba33dbc45ecee5d77a01f8"
                ),
                extras = listOf("60ba197c2e35f2d9c786c525", "60ba34a0c45ecee5d77a0263")
            )
        ),
        sizeModels = listOf(
            SizeModel(
                id = "60ba18d13ca8c43196b5f606",
                name = "Large",
                v = 0
            ),
            SizeModel(
                id = "60ba3368c45ecee5d77a016b",
                name = "Venti",
                v = null
            ),
            SizeModel(id = "60ba33dbc45ecee5d77a01f8", name = "Tall", v = null)
        ),
        extraModels = listOf(
            ExtraModel(
                id = "60ba197c2e35f2d9c786c525",
                name = "Select the amount of sugar",
                subSelectionModels = listOf(
                    SubSelectionModel(
                        id = "60ba194dfdd5e192e14eaa75",
                        name = "A lot"
                    ),
                    SubSelectionModel(
                        id = "60ba195407e1dc8a4e33b5e5",
                        name = "Normal"
                    )
                )
            ),
            ExtraModel(
                id = "60ba34a0c45ecee5d77a0263",
                name = "Select type of milk",
                subSelectionModels = listOf(
                    SubSelectionModel(
                        id = "611a1adeff35e4db9df19667",
                        name = "Soy"
                    ),
                    SubSelectionModel(
                        id = "60ba348d8c75424ac5ed259e",
                        name = "Oat"
                    ),
                    SubSelectionModel(
                        id = "60ba349a869d7a04642b41f4",
                        name = "Cow"
                    )
                )
            )
        )
    )
}
