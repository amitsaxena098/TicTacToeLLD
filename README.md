> ## Documentation Index
> Fetch the complete documentation index at: https://mintlify.com/amitsaxena098/TicTacToeLLD

# TicTacToe LLD: Java OOP and Low-Level Design Study

> Learn how TicTacToe LLD applies the Strategy pattern, interface-driven architecture, and clean separation of concerns across five focused Java packages.

TicTacToe LLD is a Java project that implements the classic Tic-Tac-Toe game as a hands-on study in **Low-Level Design (LLD)**. Rather than focusing on a polished product, the goal is to demonstrate how a small, real problem can be structured with good OOP principles — making it an ideal reference for LLD interview preparation and design pattern practice.

## Project purpose

The project was built to explore three core ideas:

* **Strategy pattern** — player behavior is encapsulated behind an interface, so different input methods or AI strategies can be swapped without touching the game loop.
* **Interface-driven programming** — `Board` and `Move` depend on `IPlayerStrategy`, not on concrete player classes.
* **Separation of concerns** — state management, move validation, win detection, and rendering each live in their own class.

## Package structure

The source lives under `src/tictactoe/` and is divided into five packages:

```text  theme={null}
src/tictactoe/
├── enums/
│   ├── State.java
│   └── Symbol.java
├── game/
│   ├── TicTacToe.java
│   └── Board.java
├── interfaces/
│   └── IPlayerStrategy.java
├── strategy/
│   ├── PlayerAStrategy.java
│   └── PlayerBStrategy.java
└── util/
    ├── GameContext.java
    └── Move.java
```

<AccordionGroup>
  <Accordion title="enums — shared constants">
    Two enums define the vocabulary of the game.

    * `State` — tracks the current game status: `InProgress`, `Draw`, `PlayerAWon`, `PlayerBWon`.
    * `Symbol` — the three characters a cell can hold: `X`, `O`, and `E` (empty).
  </Accordion>

  <Accordion title="game — entry point and game loop">
    * `TicTacToe` — the `main` method. Constructs the two players and the board, then calls `board.play()`.
    * `Board` — initializes the grid, drives the game loop, and switches turns between players.
  </Accordion>

  <Accordion title="interfaces — player contract">
    `IPlayerStrategy` defines the three methods every player must implement: `playMove(char[][] board)`, `getSymbol()`, and `getDisplayName()`. This is the key extension point in the codebase.
  </Accordion>

  <Accordion title="strategy — concrete player implementations">
    `PlayerAStrategy` and `PlayerBStrategy` each implement `IPlayerStrategy`. Both currently read input from `Scanner`, but they can be replaced with any other implementation — for example, a random AI or a network player — without modifying `Board`.
  </Accordion>

  <Accordion title="util — state and move logic">
    * `GameContext` — holds the current player and game state as static fields, providing a single source of truth for the session.
    * `Move` — validates each move (bounds check, occupancy check, turn check) and runs win/draw detection after every successful placement.
  </Accordion>
</AccordionGroup>

## Key design goals

<CardGroup cols={2}>
  <Card title="Interface-driven" icon="plug">
    `Board` and `Move` program to `IPlayerStrategy`, not to `PlayerAStrategy` or `PlayerBStrategy`. Concrete strategy classes are only referenced in `TicTacToe.java` at construction time.
  </Card>

  <Card title="Pluggable strategy" icon="arrows-rotate">
    Adding a new player type — an AI, a networked client, a test stub — requires only a new class that implements `IPlayerStrategy`. No changes to the game loop or validation logic are needed.
  </Card>

  <Card title="Separated concerns" icon="layer-group">
    Win detection lives in `Move`, game state lives in `GameContext`, turn switching lives in `Board`, and rendering (`printBoard`) lives in `GameContext`. Each class has one reason to change.
  </Card>

  <Card title="Minimal footprint" icon="feather">
    The entire codebase is under ten files. Every class and enum does exactly one job, making the design easy to read and study in a single sitting.
  </Card>
</CardGroup>

## Where to go next

<CardGroup cols={2}>
  <Card title="Architecture overview" icon="sitemap" href="/architecture/overview">
    See how all components connect and why each design decision was made.
  </Card>

  <Card title="Getting started" icon="rocket" href="/getting-started">
    Clone the repo, compile, and run a game in a few commands.
  </Card>
</CardGroup>


Built with [Mintlify](https://mintlify.com).
