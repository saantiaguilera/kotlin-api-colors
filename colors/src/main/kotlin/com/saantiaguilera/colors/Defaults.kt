package com.saantiaguilera.colors

import com.saantiaguilera.colors.Colors.Companion.colorize

/**
 * Define default colors for easy access
 */
fun String.black(): String = colorize(this, color = Colors.Color.BLACK)
fun String.red(): String = colorize(this, color = Colors.Color.RED)
fun String.green(): String = colorize(this, color = Colors.Color.GREEN)
fun String.yellow(): String = colorize(this, color = Colors.Color.YELLOW)
fun String.blue(): String = colorize(this, color = Colors.Color.BLUE)
fun String.magenta(): String = colorize(this, color = Colors.Color.MAGENTA)
fun String.cyan(): String = colorize(this, color = Colors.Color.CYAN)
fun String.white(): String = colorize(this, color = Colors.Color.WHITE)
fun String.default(): String = colorize(this, color = Colors.Color.DEFAULT)

/**
 * Define background and foreground setters with a color
 */
fun String.background(color: Colors.Color = Colors.Color.DEFAULT) = colorize(this, color, type = Colors.Type.BACKGROUND)
fun String.foreground(color: Colors.Color = Colors.Color.DEFAULT) = colorize(this, color)

/**
 * Define the supported modes
 */
fun String.bold() = colorize(this, Colors.Color.DEFAULT, mode = Colors.Mode.BOLD)
fun String.italic() = colorize(this, Colors.Color.DEFAULT, mode = Colors.Mode.ITALIC)
fun String.underline() = colorize(this, Colors.Color.DEFAULT, mode = Colors.Mode.UNDERLINE)
fun String.blink() = colorize(this, Colors.Color.DEFAULT, mode = Colors.Mode.BLINK)
fun String.conceal() = colorize(this, Colors.Color.DEFAULT, mode = Colors.Mode.CONCEAL)
fun String.faint() = colorize(this, Colors.Color.DEFAULT, mode = Colors.Mode.FAINT)
fun String.fastBlink() = colorize(this, Colors.Color.DEFAULT, mode = Colors.Mode.FAST_BLINK)
fun String.inverse() = colorize(this, Colors.Color.DEFAULT, mode = Colors.Mode.INVERSE)
fun String.strikethrough() = colorize(this, Colors.Color.DEFAULT, mode = Colors.Mode.STRIKETHROUGH)

/**
 * Define a colorize function to use if they wanna play with customizations
 */
fun String.colorize(color: Colors.Color = Colors.Color.DEFAULT, mode: Colors.Mode = Colors.Mode.NONE, type: Colors.Type = Colors.Type.FOREGROUND) =
        colorize(this, color, mode, type)