# Creating a Movie Booing App

We will try to mould the problem in following steps.

* Class Diagram
* Schema Design
* Code

Following will be the models required -

Movie, Theatre, Screen, Seat,

Movie -> id, name <br>
Theatre -> List(Screen) <br>
Screen -> id, name, Theatre, List(Seat) <br>
Seat -> id, rowNo, SeatNo

