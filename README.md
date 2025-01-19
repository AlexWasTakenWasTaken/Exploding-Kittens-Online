# Knockoff Exploding Kittens

A multiplayer card game inspired by **Exploding Kittens**, built in Java with networking capabilities. This project highlights object-oriented design, real-time multiplayer functionality, and graphical rendering using Java Swing.

## Features
- **Multiplayer Gameplay**:
  - Host a server and connect multiple players.
  - Real-time interaction between players with synchronized game states.
- **Card Functionality**:
  - Implements custom cards like "Attack", "Bomb", "Defuse", and more.
  - Each card has unique behaviors and effects.
- **Graphical User Interface**:
  - Interactive gameplay with a grid-based UI rendered using `Graphics`.
  - Animated card movements and intuitive visual feedback.
- **Networking**:
  - Server-client architecture for multiplayer communication.
  - Built using Java sockets for real-time player interactions.

## Skills and Technologies
### Object-Oriented Programming
- Encapsulation and inheritance for card hierarchy (`Card`, `CatCard`, etc.).
- Modular design for game elements like `Player`, `Game`, and `Server`.

### Networking
- Multi-threaded server to handle multiple client connections.
- Socket programming for data exchange between players and server.

### Graphics
- Java Swing for window management (`JFrame` and `JPanel`).
- Custom rendering of game elements (cards, grid, player visuals) using `Graphics`.

### Game Logic
- Deck and discard pile management.
- Turn-based logic and dynamic player interactions.
- Event-driven programming for mouse-based inputs.

## File Structure
- **`Card.java`**: Abstract base class for all cards, providing common properties and methods.
- **`CatCard.java`**: Example of a specific card implementation with unique behavior.
- **`Game.java`**: Core game logic, including card management and player turns.
- **`Player.java`**: Represents a player, managing their hand and interactions.
- **`Client.java`**: Manages the client-side logic, including UI and communication with the server.
- **`Server.java`**: Hosts the game, manages connections, and synchronizes player states.
- **`Const.java`**: Stores constants like screen dimensions and card sizes.

## How It Works
1. **Server**:
   - Start the server (`Server.java`) to allow clients to connect.
   - Manages the game state and distributes cards.
2. **Client**:
   - Players connect to the server and receive their cards.
   - Interact with the game via mouse events.
3. **Gameplay**:
   - Players take turns playing cards or drawing from the deck.
   - The goal is to avoid drawing the "Bomb" card while strategically using other cards.

## Highlights
- **Scalable Architecture**: Designed to accommodate multiple players with a consistent game state.
- **Interactive Design**: Dynamic UI that responds to player actions.
- **Networking Expertise**: Implements robust server-client communication using threads.

## Purpose
This project demonstrates proficiency in Java programming, object-oriented design, graphical rendering, and networking. It's an engaging example of combining technical skills with creativity in game development.

---

Thank you for exploring this project! Feedback and suggestions are always welcome.
