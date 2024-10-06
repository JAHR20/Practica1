package com.jahr.practica1.models

sealed class items_lista(
    val image: Int?,
    val title: String,
    val details: String
){
    object item1: items_lista(
        null,
        "Pasteles",
        "deliciosos y ricos pasteles"
    )
    object item2: items_lista(
        null,
        "gelatinas",
        "deliciosas y ricas gelatinas"
    )
    object item3: items_lista(
        null,
        "panes",
        "deliciosos y ricos panes"
    )
    object item4: items_lista(
        null,
        "donas",
        "deliciosas y ricas donas"
    )
    object item5: items_lista(
        null,
        "carlota",
        "deliciosas y ricas carlota"
    )


}