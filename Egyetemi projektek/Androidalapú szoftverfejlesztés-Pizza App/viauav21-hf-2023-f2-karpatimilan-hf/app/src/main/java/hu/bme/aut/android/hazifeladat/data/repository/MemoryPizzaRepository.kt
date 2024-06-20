package hu.bme.aut.android.hazifeladat.data.repository

import hu.bme.aut.android.hazifeladat.R
import hu.bme.aut.android.hazifeladat.domain.model.Pizza
import kotlinx.coroutines.delay
object MemoryPizzaRepository : PizzaRepository {
    private val pizzas = mutableListOf(
        Pizza(
            id = 1,
            name = "Margherita",
            toppings = "Paradicsomszósz, mozarella, paradicsom",
            price = 2500,
            imageResId = R.drawable.margherita
        ),
        Pizza(
            id = 2,
            name = "Sonkás",
            toppings = "Paradicsomszósz, mozarella, sonka",
            price = 2800,
            imageResId = R.drawable.sonka
        ),
        Pizza(
            id = 3,
            name = "Négysajtos",
            toppings = "Paradicsomszósz, mozzarella, cheddar, parmezán, gorgonzola",
            price = 3000,
            imageResId = R.drawable.negysajt
        ),

        Pizza(
            id = 4,
            name = "Szalámis",
            toppings = "Paradicsomszósz, szalámi",
            price = 2800,
            imageResId = R.drawable.szalami
        ),
        Pizza(
            id = 5,
            name = "Sonkás gombás",
            toppings = "Paradicsomszósz, sonka, gomba",
            price = 2800,
            imageResId = R.drawable.sonkagomba
        ),
        Pizza(
            id = 6,
            name = "Camambert",
            toppings = "Tejfölös alap, mozarella, camambert, brokkoli, újhagyma",
            price = 3500,
            imageResId = R.drawable.camembert
        ),
        Pizza(
            id = 7,
            name = "Bianca",
            toppings = "Tejfölös\u00A0alap, mozarella, ricotta, pecorino, paradicsom",
            price = 3300,
            imageResId = R.drawable.bianca
        ),
        Pizza(
            id = 8,
            name = "Magyaros",
            toppings = "Paradicsomszósz, kolbász, szalonna, lilahagyma, csípős paprika",
            price = 3000,
            imageResId = R.drawable.magyaros
        ),
        Pizza(
            id = 9,
            name = "Szárított paradicsomos",
            toppings = "Paradicsomszósz, mozarella, szárított paradicsom, olivabogyó",
            price = 2800,
            imageResId = R.drawable.aszalt_paradicsom
        ),

    )


    override suspend fun insertPizza(pizza: Pizza) {
        delay(1000)
        pizzas.add(pizza)
    }

    override suspend fun deletePizza(pizza: Pizza) {
        delay(1000)
        pizzas.remove(pizza)
    }

    override suspend fun getPizzaById(id: Int): Pizza {
        delay(1000)
        for (pizza in pizzas) {
            if (pizza.id == id) return pizza
        }
        return pizzas.first()
    }

    override suspend fun getAllPizzas(): List<Pizza> {
        delay(1000)
        return pizzas.toList()
    }

    override suspend fun updatePizza(updatedPizza: Pizza) {
        delay(1000)
        for (pizza in pizzas) {
            if (pizza.id == updatedPizza.id)
                pizzas[pizzas.indexOf(pizza)] = updatedPizza
        }
    }
}