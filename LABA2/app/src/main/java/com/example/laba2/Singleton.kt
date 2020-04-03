package com.example.laba2

class Singleton { //design pattern, guaranteeing only one instance of class
    val position: Int = 0
    lateinit var name: Array<String?>
    lateinit var helptext: Array<String?>

    private var instance: Singleton? = null

    fun getInstance(): Singleton{ //method for access to instance
        if (instance == null) {
            instance = Singleton()
            instance!!.name = arrayOfNulls<String>(200)
            instance!!.helptext = arrayOfNulls<String>(200)
        }
        return instance as Singleton
    }
}