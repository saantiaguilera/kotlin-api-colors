package com.saantiaguilera.testapp

import com.saantiaguilera.colors.*

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            System.out.println("Black".black())
            System.out.println("White".white())
            System.out.println("Red".red())
            System.out.println("Blue".blue())
            System.out.println("Magenta".magenta())
            System.out.println("Cyan".cyan())

            System.out.println("Bold underline red on white"
                    .bold()
                    .underline()
                    .red() // This will get overwritten
                    .foreground(Colors.Color.WHITE)
                    .background(Colors.Color.RED))

            val nOfColors = Colors.Color.values().size
            System.out.println((1..nOfColors)
                    .mapIndexed { i, num -> num.toString().colorize(Colors.Color.values()[i % nOfColors]) }
                    .map { colorizedString -> colorizedString.bold() }
                    .reduce { left, right -> "$left, $right" })
        }
    }
}