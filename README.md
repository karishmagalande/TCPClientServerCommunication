# TCP Client Server Communication

A minimal TCP client and server in Java using `java.net` sockets. The server listens on a port and sends the current date and time to each client that connects. The client connects, prints that line, and exits.

## How it works

- **`TCPServer`:** opens a `ServerSocket` on the given port and loops forever. For each client it accepts the connection, writes `new Date()` to the socket, and closes it.
- **`TCPClient`:** opens a `Socket` to the host and port, reads one line, and prints it. It reports a clear error if the host is unknown or the server isn't running.

## Run it

```bash
javac TCPServer.java TCPClient.java
```

In one terminal:

```bash
java TCPServer 6868
```

In another:

```bash
java TCPClient localhost 6868
```

## Example

Server terminal:

```
Server is listening on port 6868
New client connected
New client connected
```

Client terminal, run twice:

```
Thu Oct 22 18:31:25 EDT 2026
Thu Oct 22 18:31:25 EDT 2026
```

Running either program without arguments prints its usage line.
