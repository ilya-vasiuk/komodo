# What is Komodo

Core of Komodo - Dependency Injection and set of ready to use services like: configuration, module loading, etc.

So it should be easy to replace any service with own implementation, or even replace all parts of Komodo, even DI library itself.

We heavily use Kotlin features, and doesn't care about Java users of framework. For example we use Kotlin Coroutines, which currently (Kotlin 1.1) has experimental status.

## When to Use?

We hope that framework will be ideal for small applications, microservices, web-servers. This is replacement for JavaEE webservers, and Spring-*.