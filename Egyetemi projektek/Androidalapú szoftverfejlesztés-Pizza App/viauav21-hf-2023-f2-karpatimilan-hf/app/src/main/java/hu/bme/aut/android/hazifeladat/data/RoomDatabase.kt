package hu.bme.aut.android.hazifeladat.data

import androidx.room.Database
import androidx.room.RoomDatabase
import hu.bme.aut.android.hazifeladat.data.dao.PizzaDao
import hu.bme.aut.android.hazifeladat.data.entities.PizzaEntity

@Database(entities = [PizzaEntity::class], version = 1)
abstract class PizzaDatabase : RoomDatabase() {
    abstract val dao: PizzaDao
}