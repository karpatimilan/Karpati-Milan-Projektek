package hu.bme.aut.android.hazifeladat.util

import hu.bme.aut.android.hazifeladat.ui.model.UiText

sealed class UiEvent {
    object Success: UiEvent()

    data class Failure(val message: UiText): UiEvent()
}

