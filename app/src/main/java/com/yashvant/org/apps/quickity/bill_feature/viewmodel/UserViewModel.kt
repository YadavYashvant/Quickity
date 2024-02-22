package com.yashvant.org.apps.quickity.bill_feature.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yashvant.org.apps.quickity.bill_feature.Dao.MyAppDatabase
import com.yashvant.org.apps.quickity.bill_feature.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

/*class UserViewModel : ViewModel() {
    private val userDao = MyAppDatabase.getInstance().userDao()

    val name = MutableStateFlow("")
    val email = MutableStateFlow("")
    //val users = userDao.getAllUsers().asFlow().stateIn(viewModelScope)

    fun onNameChange(newName: String) {
        name.value = newName
    }

    fun onEmailChange(newEmail: String) {
        email.value = newEmail
    }

    fun onSaveClicked() {
        viewModelScope.launch(Dispatchers.IO) {
            userDao.insertUser(User(0, name.value, email.value))
        }
    }
}*/
