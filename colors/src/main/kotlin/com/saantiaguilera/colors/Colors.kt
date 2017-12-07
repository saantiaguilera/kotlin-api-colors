package com.saantiaguilera.colors

/**
 * Colors class, this class has the configurations and possible values for each type of element
 * This class also has the main method `colorize` which is in charge of creating a color from a string
 *
 * NOTES: https://en.wikipedia.org/wiki/ANSI_escape_code
 */
class Colors private constructor() {

    init {
        throw IllegalAccessException("This class shouldn't be instantiated")
    }

    companion object {
        /**
         * Sets a string with a color / mode / type
         */
        internal fun colorize(string: String, color: Color = Color.DEFAULT, mode: Mode = Mode.NONE, type: Type = Type.FOREGROUND): String {
            val builder = ColorBuilder(string)

            if (color != Color.DEFAULT) {
                when (type) {
                    Type.FOREGROUND -> builder.add(color.code + 30)
                    Type.BACKGROUND -> builder.add(color.code + 40)
                }
            }

            if (mode != Mode.NONE) {
                builder.add(mode.code)
            }

            return builder.string()
        }
    }

    /**
     * Type of color to apply
     */
    enum class Type(val code: Int) {
        FOREGROUND(0),
        BACKGROUND(1);

        companion object {
            fun valueOf(code: Int): Type? = Type.values().firstOrNull { code == it.code }
        }
    }

    /**
     * Available colors, based on ANSI 3/4 bit colors
     */
    enum class Color(val code: Int) {
        BLACK(0),
        RED(1),
        GREEN(2),
        YELLOW(3),
        BLUE(4),
        MAGENTA(5),
        CYAN(6),
        WHITE(7),
        DEFAULT(9),
        BRIGHT_BLACK(60),
        BRIGHT_RED(61),
        BRIGHT_GREEN(62),
        BRIGHT_YELLOW(63),
        BRIGHT_BLUE(64),
        BRIGHT_MAGENTA(65),
        BRIGHT_CYAN(66),
        BRIGHT_WHITE(67);

        companion object {
            fun valueOf(code: Int): Color? = Color.values().firstOrNull { code == it.code }
        }
    }

    /**
     * Modes to apply to the string
     */
    enum class Mode(val code: Int) {
        NONE(0),
        BOLD(1),
        FAINT(2),
        ITALIC(3),
        UNDERLINE(4),
        BLINK(5),
        FAST_BLINK(6),
        INVERSE(7),
        CONCEAL(8),
        STRIKETHROUGH(9);

        companion object {
            fun valueOf(code: Int): Mode? = Mode.values().firstOrNull { code == it.code }
        }
    }

}