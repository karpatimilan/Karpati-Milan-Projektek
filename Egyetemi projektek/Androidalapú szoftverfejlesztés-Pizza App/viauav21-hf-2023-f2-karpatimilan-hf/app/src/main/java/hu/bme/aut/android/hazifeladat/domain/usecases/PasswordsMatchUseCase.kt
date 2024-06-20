package hu.bme.aut.android.hazifeladat.domain.usecases

class PasswordsMatchUseCase {

    operator fun invoke(password: String, confirmPassword: String): Boolean =
        password == confirmPassword
}