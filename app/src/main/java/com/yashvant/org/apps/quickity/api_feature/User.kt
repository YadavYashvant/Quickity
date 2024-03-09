package com.yashvant.org.apps.quickity.api_feature

data class User(
    val name: String,
    val password: Int,
    val hasForgotPassword: Boolean,
    val userId: Int
)