# GoldRush

A two-player JavaFX game where players compete to collect as much gold as possible before the timer runs out. Avoid the coal — picking it up costs you points!

## Requirements

- Java 21
- Maven 3.6+

## Maven Goals

| Command | Description |
|---------|-------------|
| `mvn compile` | Compile the source code |
| `mvn test` | Run all unit tests |
| `mvn exec:java` | Run the application |
| `mvn package` | Build the fat jar |
| `mvn site` | Generate project documentation |

## How to Build

```bash
mvn package
```

This produces a fat jar at `target/GoldRush-1.0-SNAPSHOT-jar-with-dependencies.jar`.

## How to Run

**Using Maven:**
```bash
mvn exec:java
```

**Without Maven (using the shell scripts):**
```bash
./package.sh   # Build the project and create a self-contained runtime image
./run.sh       # Run the application
```

## Design Documentation

- [Design documentation, UML class diagram, and design patterns](src/site/markdown/design.md)

## Documentation

Generated project documentation including Javadoc reports can be produced with:

```bash
mvn package site
```

Then open `target/site/index.html` in a browser.

## License

This project is licensed under the MIT License — see [LICENSE](LICENSE) for details.
