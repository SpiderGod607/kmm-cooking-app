package com.spidergod.myapplication.domain.util

import com.spidergod.myapplication.domain.model.GenericMessageInfo

class GenericMessageInfoQueueUtil {

    fun doesMessageAlreadyExistInQueue(
        queue: Queue<GenericMessageInfo>,
        messageInfo: GenericMessageInfo
    ): Boolean {
        for (items in queue.items) {
            if (items.id == messageInfo.id) {
                return true
            }
        }
        return false
    }

}