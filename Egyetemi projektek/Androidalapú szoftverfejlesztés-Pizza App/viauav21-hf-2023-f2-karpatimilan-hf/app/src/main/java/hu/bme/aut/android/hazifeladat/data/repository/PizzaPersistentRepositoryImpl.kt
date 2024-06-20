package hu.bme.aut.android.hazifeladat.data.repository

import androidx.room.Dao
import hu.bme.aut.android.hazifeladat.data.dao.PizzaDao
import hu.bme.aut.android.hazifeladat.data.entities.PizzaEntity
import kotlinx.coroutines.flow.Flow

class PizzaPersistentRepositoryImpl(private val dao: PizzaDao) : PizzaPersistentRepository {

    override fun getAllPizzas(): Flow<List<PizzaEntity>> = dao.getAllPizzas()

    override fun getPizzaById(id: Int): Flow<PizzaEntity> = dao.getPizzaById(id)

    override suspend fun insertPizza(pizza: PizzaEntity) { dao.insertPizza(pizza)
        println("Inserting pizza: $pizza")}

    override suspend fun updatePizza(pizza: PizzaEntity) { dao.updatePizza(pizza) }

    override suspend fun deletePizza(id: Int) { dao.deletePizza(id) }

    override suspend fun deletePizzas() { dao.deletePizzas() }

   override suspend fun isEmpty(): Boolean=dao.isEmpty()
}