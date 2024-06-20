package hu.bme.aut.android.hazifeladat.data.auth



import hu.bme.aut.android.hazifeladat.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MemoryAuthService : AuthService {
    override val currentUserId: String? get() = currentUserMutableFlow.value?.id?.toString()
    override val hasUser: Boolean get() = currentUserMutableFlow.value != null
    override val currentUser: Flow<User?> get() = currentUserMutableFlow.asStateFlow()

    private val currentUserMutableFlow = MutableStateFlow<User?>(null)

    override suspend fun signUp(email: String, password: String) {
        val userId = generateUserIdFromEmail(email)
        currentUserMutableFlow.value = User(email.hashCode().toString())
    }

    override suspend fun authenticate(email: String, password: String) {
        val userId = generateUserIdFromEmail(email)
        currentUserMutableFlow.value = User(email.hashCode().toString())
    }

    override suspend fun sendRecoveryEmail(email: String) = Unit

    override suspend fun deleteAccount() {
        currentUserMutableFlow.value = null
    }

    override suspend fun signOut() {
        currentUserMutableFlow.value = null
    }

    private fun generateUserIdFromEmail(email: String): Int {
        // You can use a hashing or other methods to generate an integer ID from the email.
        // For simplicity, let's use the hashCode() method for demonstration purposes.
        return email.hashCode()
    }
}