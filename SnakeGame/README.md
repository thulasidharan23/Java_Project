# Snake Game

This is a simple implementation of the classic Snake game using Java and Swing. The game includes basic functionalities such as moving the snake, eating apples to grow, and collision detection.

## Table of Contents
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Code Structure](#code-structure)
- [Contributing](#contributing)
- [License](#license)

## Features
- Move the snake using arrow keys
- Grow the snake by eating apples
- End the game when the snake collides with itself or the wall
- Display a "Game Over" message upon collision

## Installation

To run this project locally, you need to have Java installed on your machine. Follow the steps below to set up the project:

1. **Clone the repository**:
    ```bash
    git clone https://github.com/yourusername/snake-game.git
    ```
2. **Navigate to the project directory**:
    ```bash
    cd snake-game
    ```
3. **Compile the Java files**:
    ```bash
    javac -d bin -sourcepath src src/SnakeGame/Main/*.java
    ```
4. **Run the game**:
    ```bash
    java -cp bin SnakeGame.Main.Snake
    ```

## Usage

- Use the arrow keys to control the direction of the snake:
  - Up arrow: Move up
  - Down arrow: Move down
  - Left arrow: Move left
  - Right arrow: Move right
- The goal is to eat the apples that appear on the board.
- The game ends when the snake collides with itself or the walls.

## Code Structure

The project consists of two main Java files:

1. **Board.java**: This file contains the main game logic, including the snake's movement, collision detection, and rendering the game board.
2. **Snake.java**: This file initializes the game window and sets up the main game loop.

The directory structure is as follows:

SnakeGame/
Main/
Board.java
Snake.java
assets/
apple.png
dot.png
head.png


## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the repository
2. Create a new branch (`git checkout -b feature-branch`)
3. Commit your changes (`git commit -am 'Add new feature'`)
4. Push to the branch (`git push origin feature-branch`)
5. Create a new Pull Request

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
