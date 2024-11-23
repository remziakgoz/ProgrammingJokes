package com.remziakgoz.programmingjokes.util

enum class Status {
    LOADING,
    SUCCESS,
    ERROR
}

data class ApiResponse<T>(
    val status: Status,
    val data: T? = null,
    val message: String? = null
)