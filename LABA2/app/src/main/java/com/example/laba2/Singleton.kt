package com.example.laba2

class Singleton { //design pattern, guaranteeing only one instance of class
    var name: Array<String?> = arrayOfNulls(100)
    var helptext: Array<String?> = arrayOfNulls(100)
    var image: Array<String?> = arrayOfNulls(100)

    companion object {
        private var instance = Singleton()
        fun getInstance(): Singleton? { //method for access to instance
            if (instance == null) {
                instance = Singleton()
                instance.name = arrayOfNulls(100)
                instance.helptext = arrayOfNulls(100)
                instance.image = arrayOfNulls(100) //for connect to image
            }
            return instance
        }
    }
}