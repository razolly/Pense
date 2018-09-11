package com.example.razli.pense

class Repository {

    companion object {
        private var INSTANCE: Repository? = null

        @JvmStatic
        fun getInstance(): Repository {
            return INSTANCE ?: Repository().apply { INSTANCE = this }
        }

        @JvmStatic
        fun destroyInstance() {
            INSTANCE = null
        }
    }

}