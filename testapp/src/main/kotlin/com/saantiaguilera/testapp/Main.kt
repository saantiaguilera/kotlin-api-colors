package com.saantiaguilera.testapp

import com.saantiaguilera.colors.*

class Main {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            // Show some colors
            println("Black".black())
            println("White".white())
            println("Red".red())
            println("Blue".blue())
            println("Magenta".magenta())
            println("Cyan".cyan())

            // Create something tricky
            println("Bold underline red on white"
                    .bold()
                    .underline()
                    .red() // This will get overwritten
                    .foreground(Colors.Color.WHITE)
                    .background(Colors.Color.RED))

            // Enumerate all the colors we support
            val nOfColors = Colors.Color.values().size
            println((1..nOfColors)
                    .map { num -> num.toString().colorize(Colors.Color.values()[num - 1]).bold() }
                    .reduce { left, right -> "$left, $right" })
        }
    }
}