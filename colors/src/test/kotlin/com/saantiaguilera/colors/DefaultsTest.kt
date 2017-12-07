package com.saantiaguilera.colors

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("String injections")
class DefaultsTest {

    companion object {
        val specialChar = 27.toChar()
    }

    @DisplayName("Test of default colors")
    @Nested
    class ColorsTest {

        @Test
        fun `Test a string turns black`() {
            assertThat("$specialChar[30mTestString$specialChar[0m").isEqualTo("TestString".black())
        }

        @Test
        fun `Test a string turns red`() {
            assertThat("$specialChar[31mTestString$specialChar[0m").isEqualTo("TestString".red())
        }

        @Test
        fun `Test a string turns green`() {
            assertThat("$specialChar[32mTestString$specialChar[0m").isEqualTo("TestString".green())
        }

        @Test
        fun `Test a string turns yellow`() {
            assertThat("$specialChar[33mTestString$specialChar[0m").isEqualTo("TestString".yellow())
        }

        @Test
        fun `Test a string turns blue`() {
            assertThat("$specialChar[34mTestString$specialChar[0m").isEqualTo("TestString".blue())
        }

        @Test
        fun `Test a string turns magenta`() {
            assertThat("$specialChar[35mTestString$specialChar[0m").isEqualTo("TestString".magenta())
        }

        @Test
        fun `Test a string turns cyan`() {
            assertThat("$specialChar[36mTestString$specialChar[0m").isEqualTo("TestString".cyan())
        }

        @Test
        fun `Test a string turns white`() {
            assertThat("$specialChar[37mTestString$specialChar[0m").isEqualTo("TestString".white())
        }

        @Test
        fun `Test a string doesnt change if color is default`() {
            assertThat("TestString").isEqualTo("TestString".default())
        }

    }

    @Nested
    @DisplayName("Test types of colors")
    class TypesTest {

        @Test
        fun `Test I can set a foreground color`() {
            assertThat("$specialChar[37mTestString$specialChar[0m").isEqualTo("TestString".foreground(Colors.Color.WHITE))
        }

        @Test
        fun `Test I can set a background color`() {
            assertThat("$specialChar[47mTestString$specialChar[0m").isEqualTo("TestString".background(Colors.Color.WHITE))
        }

    }

    @Nested
    @DisplayName("Test modes of colors")
    class ModesTest {

        @Test
        fun `Test bold`() {
            assertThat("$specialChar[1mTestString$specialChar[0m").isEqualTo("TestString".bold())
        }

        @Test
        fun `Test italic`() {
            assertThat("$specialChar[3mTestString$specialChar[0m").isEqualTo("TestString".italic())
        }

        @Test
        fun `Test underline`() {
            assertThat("$specialChar[4mTestString$specialChar[0m").isEqualTo("TestString".underline())
        }

        @Test
        fun `Test blink`() {
            assertThat("$specialChar[5mTestString$specialChar[0m").isEqualTo("TestString".blink())
        }

        @Test
        fun `Test conceal`() {
            assertThat("$specialChar[8mTestString$specialChar[0m").isEqualTo("TestString".conceal())
        }

        @Test
        fun `Test faint`() {
            assertThat("$specialChar[2mTestString$specialChar[0m").isEqualTo("TestString".faint())
        }

        @Test
        fun `Test fast blink`() {
            assertThat("$specialChar[6mTestString$specialChar[0m").isEqualTo("TestString".fastBlink())
        }

        @Test
        fun `Test inverse`() {
            assertThat("$specialChar[7mTestString$specialChar[0m").isEqualTo("TestString".inverse())
        }

        @Test
        fun `Test strikethrough`() {
            assertThat("$specialChar[9mTestString$specialChar[0m").isEqualTo("TestString".strikethrough())
        }
    }

    @Nested
    @DisplayName("Test creating customs")
    class CustomColorizationTest {

        @Test
        fun `Test creating a red background with italic`() {
            assertThat("$specialChar[41;3mTestString$specialChar[0m").isEqualTo("TestString".colorize(color = Colors.Color.RED, type = Colors.Type.BACKGROUND, mode = Colors.Mode.ITALIC))
        }

        @Test
        fun `Test creating a blue foreground with bold`() {
            assertThat("$specialChar[34;1mTestString$specialChar[0m").isEqualTo("TestString".colorize(color = Colors.Color.BLUE, type = Colors.Type.FOREGROUND, mode = Colors.Mode.BOLD))
        }

    }

    @Nested
    @DisplayName("Test chains")
    class ChainTest {

        @Test
        fun `Test chaining only modes`() {
            assertThat("$specialChar[1;3;4mTestString$specialChar[0m").isEqualTo("TestString".bold().italic().underline())
        }

        @Test
        fun `Test chaining only colors appends all but keeps the last one as shown`() {
            assertThat("$specialChar[34;32;31mTestString$specialChar[0m").isEqualTo("TestString".blue().green().red())
        }

        @Test
        fun `Test chaining colors of foreground and background`() {
            assertThat("$specialChar[34;44mTestString$specialChar[0m").isEqualTo("TestString".foreground(Colors.Color.BLUE).background(Colors.Color.BLUE))
        }

        @Test
        fun `Test chaining everything`() {
            assertThat("$specialChar[3;34;1;44;4mTestString$specialChar[0m").isEqualTo("TestString".italic().foreground(Colors.Color.BLUE).bold().background(Colors.Color.BLUE).underline())
        }

    }

}