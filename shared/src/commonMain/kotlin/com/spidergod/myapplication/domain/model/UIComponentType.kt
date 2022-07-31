package com.spidergod.myapplication.domain.model

sealed class UIComponentType {
    object Dialog : UIComponentType()
    object None : UIComponentType()
}
