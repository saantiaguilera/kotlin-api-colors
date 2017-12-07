package com.saantiaguilera.colors

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.jvm.isAccessible

@DisplayName("Color tests")
class ColorsTest {

    companion object {
        val specialChar = 27.toChar()
    }

    @Test
    fun `Test Colors class cant be instantiated`() {
        try {
            Colors::class.primaryConstructor!!.apply {
                isAccessible = true
            }.call()
            Assertions.fail<Void>("It shouldn'b be possible to instantiate the class")
        } catch(exception: Exception) {
            assertThat(exception.cause).isExactlyInstanceOf(IllegalAccessException::class.java)
        }
    }

    @Test
    fun `Test colorize adds color`() {
        assertThat("$specialChar[30mTestString$specialChar[0m").isEqualTo(Colors.colorize("TestString", Colors.Color.BLACK, type = Colors.Type.FOREGROUND))
    }

    @Test
    fun `Test colorize adds mode`() {
        assertThat("$specialChar[3mTestString$specialChar[0m").isEqualTo(Colors.colorize("TestString", mode = Colors.Mode.ITALIC))
    }

    @Test
    fun `Test colorize adds type`() {
        assertThat("$specialChar[40mTestString$specialChar[0m").isEqualTo(Colors.colorize("TestString", Colors.Color.BLACK, type = Colors.Type.BACKGROUND))
    }

    @Test
    fun `Test colorize supports color and mode at a same time`() {
        assertThat("$specialChar[30;1mTestString$specialChar[0m").isEqualTo(Colors.colorize("TestString", Colors.Color.BLACK, Colors.Mode.BOLD, Colors.Type.FOREGROUND))
    }

    @Test
    fun `Can overlap with others`() {
        val color = Colors.colorize(Colors.colorize("TestString", Colors.Color.BLACK), mode = Colors.Mode.BOLD)
        assertThat("$specialChar[30;1mTestString$specialChar[0m").isEqualTo(color)
    }

    @Test
    fun `Test default color is none`() {
        assertThat("TestString").isEqualTo(Colors.colorize("TestString", mode = Colors.Mode.NONE))
    }

    @Test
    fun `Test default mode is none`() {
        assertThat("TestString").isEqualTo(Colors.colorize("TestString", color = Colors.Color.DEFAULT))
    }

    @Test
    fun `Test default type is foreground`() {
        assertThat("$specialChar[34mTestString$specialChar[0m").isEqualTo(Colors.colorize("TestString", Colors.Color.BLUE))
    }

    @Test
    fun `Test obtaining type from integer`() {
        assertThat(Colors.Type.FOREGROUND).isEqualTo(Colors.Type.valueOf(0))
    }

    @Test
    fun `Test obtaining mode from integer`() {
        assertThat(Colors.Mode.CONCEAL).isEqualTo(Colors.Mode.valueOf(8))
    }

    @Test
    fun `Test obtaining color from integer`() {
        assertThat(Colors.Color.BLUE).isEqualTo(Colors.Color.valueOf(4))
    }

    @Test
    fun `Test obtaining no type from integer`() {
        assertThat(Colors.Type.valueOf(Integer.MAX_VALUE)).isNull()
    }

    @Test
    fun `Test obtaining no mode from integer`() {
        assertThat(Colors.Mode.valueOf(Integer.MAX_VALUE)).isNull()
    }

    @Test
    fun `Test obtaining no color from integer`() {
        assertThat(Colors.Color.valueOf(Integer.MAX_VALUE)).isNull()
    }

}