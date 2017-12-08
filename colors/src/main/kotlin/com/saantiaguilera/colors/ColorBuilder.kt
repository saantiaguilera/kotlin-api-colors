package com.saantiaguilera.colors

/**
 * Class in charge of building a string, supplying different formats and input strings with already
 * applied formats
 */
internal class ColorBuilder(string: String) {

    /**
     * Constants
     */
    private val keyReset = "0"
    private val sequenceStarter = "${27.toChar()}"
    private val sequenceIntroducer = "["
    private val sequenceTerminator = "m"
    private val sequenceControl = ";"
    private val empty = ""
    private val builderPrefix = "$sequenceStarter$sequenceIntroducer"
    private val builderSuffix = "$sequenceStarter$sequenceIntroducer$keyReset$sequenceTerminator"

    /**
     * Buffer where we will build lazily the whole formatted string
     */
    private val buffer by lazy {
        val buffer = StringBuffer()

        // If the text is empty, dont even waste time.
        if (text.isNotEmpty()) {
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

        buffer
    }

    /**
     * Input text this is the user input
     */
    private var text: String

    /**
     * Format blocks to apply
     */
    private val blocks: MutableList<Int>

    /**
     * Constructor, will strip text and blocks from the current formatted text (if it is formatted, else
     * it will just strip the text)
     */
    init {
        text = string
                .replace(Regex("^${Regex.escape(builderPrefix)}[\\d$sequenceControl]*$sequenceTerminator"), empty)
                .removeSuffix(builderSuffix)
        blocks = string
                .removeSuffix(builderSuffix)
                .replace(text, empty)
                .removeSuffix(sequenceTerminator)
                .removePrefix(builderPrefix)
                .split(sequenceControl)
                .filter { value -> value.isNotEmpty() }
                .map { value: String -> value.toInt() }
                .toMutableList()
    }

    /**
     * Add a format block to the text
     */
    fun add(format: Int) = blocks.add(format)

    /**
     * {@link #toString()}
     */
    fun string() = toString()

    /**
     * Consume the attached blocks and create the requested formatted string.
     * Note that once generated it wont be formatted again (its done lazily, so it will
     * always return the same formatted string).
     * So do it wisely
     */
    override fun toString() = buffer.toString()

}