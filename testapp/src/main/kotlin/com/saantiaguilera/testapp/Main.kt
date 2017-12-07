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

            System.out.println("Rainbow"
                    .mapIndexed { index, char -> char.toString().colorize(Colors.Color.valueOf(index + 1)!!) }
                    .map { colorizedString -> colorizedString.bold() }
                    .reduce { left, right -> left + right })
        }
    }
}