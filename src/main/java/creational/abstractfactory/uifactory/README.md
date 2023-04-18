# Abstract Factory Design Pattern
Abstract Factory design pattern is a creational pattern that provides an interface for creating families of related or dependent objects without specifying their concrete classes.

In other words, it provides an abstraction over a group of factories that create objects that belong to a certain family, such as different types of buttons, menus, or dialogs.

The Abstract Factory pattern is useful when you want to ensure that a group of related objects are created consistently and in a way that they can work together. It also makes it easier to swap out entire families of objects at runtime, since the client code only depends on the abstract factory interface and not on the concrete implementation.

---

**Code in this folder is example of following usage of Abstract Factory pattern:**

Suppose you are building a GUI toolkit that supports different look and feel themes, such as Windows, Mac, and Linux. Each theme has its own set of UI components, such as buttons, menus, and dialogs, that follow a consistent design style.

To implement this, you can define an abstract factory interface called `UIFactory` that defines methods for creating each type of UI component. Then, you can create concrete factory classes that implement this interface for each theme, such as `WindowsUIFactory`, `MacUIFactory`, and `LinuxUIFactory`. Each factory can create UI components that have the same design style and work well together.

In this example, the `UIFactory` interface defines methods for creating three types of UI components: `Button`, `Menu`, and `Dialog`. The concrete factory classes for each theme implement this interface and create components that have the same design style.

The `Application` class is a client that uses an abstract factory object to create UI components and then calls methods on them to perform actions. The `Client` class demonstrates how different concrete factories can be used to create UI components with different styles.

When the `Client` class is run, it creates an `Application` object with a specific UIFactory object for each theme and then calls the `createUI()` method to create the UI components and perform actions on them. The output of the program will depend on which concrete factory is used.