package hu.bme.aut.android.hazifeladat.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import hu.bme.aut.android.hazifeladat.data.entities.PizzaEntity
import kotlinx.coroutines.flow.Flow
@Dao
interface PizzaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPizza(pizza: PizzaEntity)

    @Query("SELECT * FROM cart_table")
    fun getAllPizzas(): Flow<List<PizzaEntity>>

    @Query("SELECT * FROM cart_table WHERE id = :id")
    fun getPizzaById(id: Int): Flow<PizzaEntity>

    @Update
    suspend fun updatePizza(todo: PizzaEntity)

    @Query("DELETE FROM cart_table WHERE id = :id")
    suspend fun deletePizza(id: Int)

    @Query("DELETE FROM cart_table")
    suspend fun deletePizzas()

    @Query("SELECT (SELECT COUNT(*) FROM cart_table) == 0")
    suspend fun isEmpty(): Boolean
}