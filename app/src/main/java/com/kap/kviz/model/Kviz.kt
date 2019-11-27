package com.kap.kviz.model

class Kviz {
    var prvoPItanje1: PItanje =
        PItanje("Pariz je glavni grad Njemacke", false)
    var drugoPItanje2: PItanje =
        PItanje("Sarajevo je glavni grad Spanije", false)
    var trecePItanje3: PItanje =
        PItanje("London je glavni grad Engleske", true)
    var cetvrtoPItanje4: PItanje =
        PItanje("Zagreb je glavni grad Hrvatske", true)

    var PItanja : List <PItanje> = listOf(prvoPItanje1, drugoPItanje2, trecePItanje3, cetvrtoPItanje4)

}