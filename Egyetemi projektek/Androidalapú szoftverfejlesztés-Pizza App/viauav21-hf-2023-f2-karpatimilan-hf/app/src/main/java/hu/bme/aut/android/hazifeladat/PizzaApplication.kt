package hu.bme.aut.android.hazifeladat

import android.app.Application
import androidx.room.Room
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import hu.bme.aut.android.hazifeladat.data.PizzaDatabase
import hu.bme.aut.android.hazifeladat.data.auth.AuthService
import hu.bme.aut.android.hazifeladat.data.auth.FirebaseAuthService



import hu.bme.aut.android.hazifeladat.data.pizzas.PizzaService
import hu.bme.aut.android.hazifeladat.data.pizzas.firebase.FirebasePointsService
import hu.bme.aut.android.hazifeladat.data.repository.PizzaPersistentRepositoryImpl


class PizzaApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        authService = FirebaseAuthService(FirebaseAuth.getInstance())
        pointsService = FirebasePointsService(FirebaseFirestore.getInstance(), authService)

        db = Room.databaseBuilder(
            applicationContext,
                PizzaDatabase::class.java,
                "pizza_database"
            ).fallbackToDestructiveMigration().build()

            repository = PizzaPersistentRepositoryImpl(db.dao)

    }

    companion object{
        lateinit var authService: AuthService
        lateinit var pointsService:PizzaService

        private lateinit var db: PizzaDatabase
        lateinit var repository: PizzaPersistentRepositoryImpl
    }
}