# Colors

[![CircleCI](https://circleci.com/gh/saantiaguilera/kotlin-api-colors/tree/master.svg?style=svg)](https://circleci.com/gh/saantiaguilera/kotlin-api-colors/tree/master) [![codecov](https://codecov.io/gh/saantiaguilera/kotlin-api-colors/branch/master/graph/badge.svg)](https://codecov.io/gh/saantiaguilera/kotlin-api-colors) [ ![Download](https://api.bintray.com/packages/saantiaguilera/maven/com.saantiaguilera.colors.colors/images/download.svg) ](https://bintray.com/saantiaguilera/maven/com.saantiaguilera.colors.colors/_latestVersion)

Colors is a Kotlin library for changing the style of a string.

Colors has no dependencies (besides kotlin stdlib)

## Installing

Be sure you have `jcenter()` as a repository
```gradle
repositories {
  jcenter()
}
```

Add the dependency
```gradle
implementation "com.saantiaguilera.colors:colors:latest.version"
```

## Usage

### Setting a default color

The library supports the colors defined per ANSI 3/4 bit colors. For changing to a specific color simply call it!

```kotlin
"This is black".black()
"This is red".red()
"This is blue".blue()
...
```

If more than one is specified, it will use the last one.
```kotlin
"This is blue".red().green().blue()
```

### Background and foreground colors

If you with to set background or foreground colors just:
```kotlin
"With red background".background(Colors.Color.RED)
"With red foreground".foreground(Colors.Color.RED)
"With red foreground".red()
```

### Setting modes

```kotlin
"Underlined".underline()
"Italic".italic()
"Bold".bold()
...
```

### Chaining

```kotlin
"What should this be?".red().italic().bold().strikethrough()
```

### Creating customs
```kotlin
"Some red in italics".colorize(color = Colors.Color.RED, mode = Colors.Mode.ITALIC)
```

## License

BSD License

Copyright (c) 2017-present. All rights reserved.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
