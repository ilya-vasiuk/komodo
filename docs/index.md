# Komodo Documentations

> This documentation describes default Komodo setup. You can customize like every part of komodo, even rewrite all implementations of standard services and replace interfaces and DI. But more practical and easy - use default services.

## Pages:

* [Vision](./vision)
* [Contributors](./contributors)

## Hello, World!

```kotlin
komodo {
    module(TestModule1::class)
}
```

## Configuration

Configuration stored in Kotlin Script `.kts` files. Every configuration return either one configuration object, of list of objects.
You can pass list of configuration files to Komodo and objects of one type will be overwrited by rule - last write wins. So if you pass two files with instances of one class - object in second passed file will win.
