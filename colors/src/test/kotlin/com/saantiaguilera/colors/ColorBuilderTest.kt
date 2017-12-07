package com.saantiaguilera.colors

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Color tests")
class ColorBuilderTest {

    companion object {
        val specialChar = 27.toChar()
    }

    @Test
    fun `Test empty string doesnt do anything`() {
        assertThat("").isEqualTo(ColorBuilder("").string())
    }

    @Test
    fun `Test empty string colorized doesnt do anything`() {
        assertThat("").isEqualTo(ColorBuilder("").apply { add(Colors.Color.BLUE.code + 30) }.string())
    }

    @Test
    fun `Test adding color to a string`() {
        assertThat("$specialChar[30mTestString$specialChar[0m").isEqualTo(ColorBuilder("TestString").apply { add(Colors.Color.BLACK.code + 30) }.string())
    }

    @Test
    fun `Test adding a mode to a string`() {
        assertThat("$specialChar[3mTestString$specialChar[0m").isEqualTo(ColorBuilder("TestString").apply { add(Colors.Mode.ITALIC.code) }.string())
    }

    @Test
    fun `Test existing colorized string add another appearance`() {
        val colorized = ColorBuilder("TestString").apply { add(Colors.Mode.ITALIC.code) }.string()
        assertThat("$specialChar[3;34mTestString$specialChar[0m").isEqualTo(ColorBuilder(colorized).apply { add(Colors.Color.BLUE.code + 30) }.string())
    }

}