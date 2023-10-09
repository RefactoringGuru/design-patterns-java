# Design Patterns in Java

This repository is part of the [Refactoring.Guru](https://refactoring.guru/design-patterns) project.

It contains Java examples for all classic GoF design patterns.


## Requirements

The examples were written in Java 8, but also tested in Java 9.

For the best experience, we recommend working with examples in IntelliJ IDEA. The Community Edition of IDE is available for free (https://www.jetbrains.com/idea/download/).

After downloading or cloning this repository to your computer, import its root directory into a New project:

- Either through start dialog: Select "Import Project" option and skip through the rest of the steps.

- Or via the main menu: File > New > Project from Existing Sources...

After importing the project, you will be able to run examples by right-clicking "Demo" files inside every example and selecting the "Run" command from the context menu.


## Roadmap

- [ ] Add detailed comments all classes.
- [ ] Add structure-only examples.


## Contributor's Guide

We appreciate any help, whether it's a simple fix of a typo or a whole new example. Just [make a fork](https://help.github.com/articles/fork-a-repo/), do your change and submit a [pull request](https://help.github.com/articles/creating-a-pull-request-from-a-fork/).

Here's a style guide which might help you to keep your changes consistent with our code:

1. All code should meet the [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)

2. Try to hard wrap the code at 80th's character. It helps to list the code on the website without scrollbars.

3. Examples should match following package convention: refactoring_guru.{pattern}.{example_name}. Example:

    ```java
    package refactoring_guru.factory_method.ui_example.buttons;

    class Button {
    ...
    ```

4. Places classes into separate files.

5. Group classes into sub-packages. It helps people to understand dependencies of a class by glancing over its imports. Example:

    ```java
    package refactoring_guru.factory_method.example.buttons;

    class Button {
    ...
    ```

    ```java
    package refactoring_guru.factory_method.example.factories;

    import Button;

    class Factory {
    ...
    ```

6. Comments may or may not have language tags in them, such as this:

    ```java
    /**
     * EN: All products families have the same varieties (MacOS/Windows).
     *
     * This is a MacOS variant of a button.
     *
     * RU: Все семейства продуктов имеют одни и те же вариации (MacOS/Windows).
     *
     * Это вариант кнопки под MacOS.
     */
    ```

    Don't be scared and ignore the non-English part of such comments. If you want to change something in a comment like this, then do it. Even if you do it wrong, we'll tell you how to fix it during the Pull Request.


## License

This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License.

<a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/80x15.png" /></a>


## Credits

Authors: Bohdan Herashchenko ([@b1ger](https://github.com/b1ger)) and Alexander Shvets ([@neochief](https://github.com/neochief))
