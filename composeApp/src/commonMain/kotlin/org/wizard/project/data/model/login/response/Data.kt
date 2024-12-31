package org.wizard.project.data.model.login.response


import androidx.annotation.Keep

@Keep
data class Data(
    val token: String,
    val userInfo: UserInfo
)