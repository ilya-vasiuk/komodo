package by.heap.komodo.di

/**
 * Interface for user modules.
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
typealias Module = (Binder) -> Binder

/**
 * Helper function to create new modules with ease.
 */
fun moduleOf(builder: Binder.() -> Unit): Module {
    return { binder ->
        builder(binder)
        binder
    }
}


