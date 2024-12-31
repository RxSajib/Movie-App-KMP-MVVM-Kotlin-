package org.wizard.project.data.model.login.response



data class UserInfo(
    val agencyID: String,
    val id: String,
    val isActive: Boolean,
    val propertyID: String,
    val propertyName: String,
    val userName: String
)