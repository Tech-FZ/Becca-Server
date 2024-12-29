# Becca Server

Becca Server is the server part of Becca, a backup
software which will hopefully be suitable for home
and business users alike.

## System requirements

### Minimum requirements

- OS: Any Linux distro which can run Java 21, Firebird 3
- Java: OpenJDK 17 (?)
- CPU: 2 cores per simultaneous backup process
  - Example: If you plan on only backing up one system at a time, your Intel Core 2 Duo will suffice, assuming you're lacking an IDS.
- RAM: 2 GB for system processes + 2 GB per simultaneous backup process
  - So backing up one system at a time will need 4 GB of RAM.
  - Backing up two systems will need 6 GB, backing up three will need 8 GB and so on.
- HDD: 32 GB + Double the total space of the system with the highest amount of total space you want to back up
    - Example: If you have one computer with one 500 GB SSD and one with a 256 GB SSD and a 1 TB hard drive, the minimum requirements will be a little less than 3 TB.

### Recommended requirements

- OS: Ubuntu 24.04 LTS
- Java: OpenJDK 21
- CPU: 2 cores for OS and security + 2 cores per simultaneous backup process
  - This assumes you're running an IDS on the server.
- RAM: 4 GB for OS and security + 2 GB per simultaneous backup process
  - This assumes you're running an IDS on the server.
- HDD: Double the total space of all systems you want to back up