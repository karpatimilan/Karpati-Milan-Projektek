package hu.bme.aut.android.hazifeladat.data.pizzas.firebase

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.snapshots
import com.google.firebase.firestore.toObject
import hu.bme.aut.android.hazifeladat.data.auth.AuthService
import hu.bme.aut.android.hazifeladat.data.pizzas.PizzaService
import hu.bme.aut.android.hazifeladat.domain.model.Points
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

import kotlinx.coroutines.tasks.await

class FirebasePointsService(
    private val firestore: FirebaseFirestore,
    private val authService: AuthService
) : PizzaService {

    override val points: Flow<Points?> = authService.currentUser.flatMapLatest { user ->
        if (user == null) {
            flow { emit(null) }
        } else {
            currentCollection(user.id)
                .document(POINTS_DOCUMENT)
                .snapshots()
                .map { snapshot ->
                    snapshot.toObject<FirebasePoints>()?.asPoints()
                }
        }
    }

    override suspend fun getPoints(id:String): Points? =
        authService.currentUserId?.let { currentUserId ->
            try {
                val documentSnapshot = currentCollection(currentUserId).document(POINTS_DOCUMENT).get().await()

                if (documentSnapshot.exists()) {
                    val firebasePoints = documentSnapshot.toObject<FirebasePoints>()
                    val points = firebasePoints?.asPoints()

                    if (points != null) {
                        return points
                    } else {
                        // Log a warning if conversion to Points is null
                        Log.w("FirebasePointsService", "Failed to convert FirebasePoints to Points")
                    }
                } else {
                    // Log a warning if the document doesn't exist
                    Log.w("FirebasePointsService", "Document $POINTS_DOCUMENT does not exist for user $currentUserId")
                }
            } catch (e: Exception) {
                // Log the exception for debugging purposes
                Log.e("FirebasePointsService", "Error getting points: ${e.message}", e)
            }
            return null
        }

    override suspend fun savePoints(points: Points) {
        authService.currentUserId?.let { currentUserId ->
            try {
                currentCollection(currentUserId).document(POINTS_DOCUMENT).set(points.asFirebasePoints())
            } catch (e: Exception) {
                // Handle exception, log, or notify user
            }
        }
    }


    override suspend fun updatePoints(points: Points) {
        authService.currentUserId?.let { currentUserId ->
            try {
                currentCollection(currentUserId).document(POINTS_DOCUMENT).set(points.asFirebasePoints()).await()
            } catch (e: Exception) {
                // Handle exception, log, or notify user
            }
        }
    }


    private fun currentCollection(userId: String) =
        firestore.collection(USER_COLLECTION).document(userId).collection(POINTS_COLLECTION)

    companion object {
        private const val USER_COLLECTION = "users"
        private const val POINTS_COLLECTION = "points"
        private const val POINTS_DOCUMENT = "user_points"
    }
}