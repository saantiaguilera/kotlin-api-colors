package com.saantiaguilera.colors

internal class ColorBuilder(string: String) {

    private val builderPrefix = "${27.toChar()}["
    private val builderSuffix = "${27.toChar()}[0m"
    private val sequenceTerminator = "m"
    private val sequenceControl = ";"
    private val empty = ""

    private val buffer = StringBuffer()

    private var text: String
    private val blocks: MutableList<Int>

    init {
        text = string
                .removePrefix(builderPrefix)
                .replace(Regex("^[\\d$sequenceControl]*$sequenceTerminator"), empty)
                .removeSuffix(builderSuffix)
        blocks = string.replace(text, empty)
                .removeSuffix(builderSuffix)
                .removeSuffix(sequenceTerminator)
                .removePrefix(builderPrefix)
                .split(sequenceControl)
                .filter { value -> value.isNotEmpty() }
                .map { value: String -> value.toInt() }
                .toMutableList()
    }

    fun string() = build()

    fun add(format: Int) = blocks.add(format)

    override fun toString() = string()

    private fun build(): String {
        // If the text is empty, return an empty string.
        if (text.isEmpty()) return empty

        if (buffer.isEmpty()) {
            if (blocks.isEmpty()) {
                // If there are no blocks for appearance, return the text raw
                buffer.append(text)
            } else {
                buffer.append(builderPrefix)
                blocks.forEachIndexed { index, block ->
                    buffer.append("$block")
                    if (index != blocks.size - 1) {
                        buffer.append(sequenceControl)
                    } else {
                        buffer.append(sequenceTerminator)
                    }
                }
                buffer.append(text)
                buffer.append(builderSuffix)
            }
        }
        return buffer.toString()
    }

}