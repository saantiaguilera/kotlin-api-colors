package com.saantiaguilera.testapp

import com.saantiaguilera.colors.*

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            System.out.println("Negro".black())
            System.out.println("Blanco".white())
            System.out.println("Rojo".red())
            System.out.println("Azul".blue())
            System.out.println("Magenta".magenta())
            System.out.println("Cyan".cyan())

            System.out.println("Hola como te va"
                    .bold()
                    .underline()
                    .red() // This will get overwritten
                    .foreground(Colors.Color.WHITE)
                    .background(Colors.Color.RED)
            )
        }
    }
}