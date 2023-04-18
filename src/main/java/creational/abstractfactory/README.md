# Abstract Factory Design Pattern
Abstract Factory design pattern is a creational pattern that provides an interface for creating families of related or dependent objects without specifying their concrete classes.

In other words, it provides an abstraction over a group of factories that create objects that belong to a certain family, such as different types of buttons, menus, or dialogs.

The Abstract Factory pattern is useful when you want to ensure that a group of related objects are created consistently and in a way that they can work together. It also makes it easier to swap out entire families of objects at runtime, since the client code only depends on the abstract factory interface and not on the concrete implementation.

----

**Examples in this package:**
- UIFactory