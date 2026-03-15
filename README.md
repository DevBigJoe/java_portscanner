# Java Port Scanner

## Overview

This project contains a simple **Java-based TCP port scanner**.
The program attempts to connect to every port in the range **1–65535** on a specified host.
If a connection to a port succeeds within a short timeout, the port is considered **open**.
Otherwise, it is treated as **closed**.

The scanner is useful for basic **network diagnostics**, testing **local services**, or learning about **socket programming in Java**.

---

## How It Works

The program performs the following steps:

1. Defines a target host (`127.0.0.1` by default).
2. Iterates through all possible TCP ports from **1 to 65535**.
3. Attempts to open a socket connection to each port.
4. Uses a **200 ms timeout** for each connection attempt.
5. If the connection succeeds:

   * The port is reported as **open**.
6. If the connection fails:

   * The port number is stored in a list of **closed ports**.

---

## Key Components

### Socket

The `Socket` class is used to create a TCP connection to the target host.

### InetSocketAddress

`InetSocketAddress` specifies the **host and port** combination used for the connection attempt.

### Timeout

The connection uses a **200 ms timeout**, which prevents the program from waiting too long on unresponsive ports.

### Closed Port Storage

Closed ports are stored in an `ArrayList<String>`.
The printing of closed ports is currently **commented out** in the code.

---

## Example Output

```text
Starting...
Port open: 22
Port open: 80
Port open: 443
Done...
```

---

## Configuration

You can change the scanned host by modifying the following line:

```java
String host = "127.0.0.1";
```

Examples:

```java
String host = "192.168.1.1";
String host = "scanme.nmap.org";
```

---

## Limitations

* The scanner runs **sequentially**, which makes scanning all ports relatively slow.
* Only **TCP ports** are checked.
* No distinction is made between filtered and closed ports.
* Exception handling is very general (`catch (Exception)`).

---

## Possible Improvements

* Implement **multithreading** to speed up scanning.
* Add **port range arguments**.
* Display **service names** for common ports.
* Differentiate between **filtered, closed, and unreachable** ports.
* Add **CLI parameters** for host and timeout configuration.

---

## Disclaimer

This tool is intended for **educational purposes and testing systems you own or have permission to scan**.
Unauthorized port scanning may violate network policies or laws.
