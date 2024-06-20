package hu.bme.aut.android.hazifeladat.data.pizzas.firebase

import com.google.firebase.firestore.DocumentId
import hu.bme.aut.android.hazifeladat.domain.model.Points


data class FirebasePoints(
    @DocumentId val id: String = "",
    val points:Int=0
)
fun FirebasePoints.asPoints()= Points(
    points=points,
    id = id
)
fun Points.asFirebasePoints() = FirebasePoints(
    points=points,
    id = id
)