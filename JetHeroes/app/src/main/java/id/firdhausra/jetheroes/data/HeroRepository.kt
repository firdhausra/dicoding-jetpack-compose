package id.firdhausra.jetheroes.data

import id.firdhausra.jetheroes.model.Hero
import id.firdhausra.jetheroes.model.HeroesData

class HeroRepository {
    fun getHeroes(): List<Hero> {
        return HeroesData.heroes
    }
}