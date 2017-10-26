# Shop-Online
Online shop.
Types of goods on sale: input devices, displays, accessories,
storage devices, peripherals.

For each type of product there are both general characteristics (price, amount , the country of production), and depending on the type of goods (for
input devices color, for output device size, etc.,
2-3 characteristics per type of product).
 
For different types of goods there are various actions:

1.On the input devices of pink color the discount is 40%. 
2.On storage devices, the discount is 10 / n, where n depends on
manufacturer (1 for seagate, 2 for kingston, 3 for samsung).
3. On the display, the discount is equal to the display of the monitor (21 inches = 21%).
4. In all other cases, the discount is 5%.

The following technologies were used:JDK 8, Spring boot, Hibernate, DB(MySql), Thymeleaf as a view and Maven.

With goods used standart CRUD (create, remove, update, delete) operations, and purchase of goods with a save check in DB.
The build file is in the project root path (pom.xml)
