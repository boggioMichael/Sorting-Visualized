# Sorting-Visualized

## Description
sorting visualization software using java, swing and Runnable.

## Notes

### First Update (Commit 30ce801)
The first commit is with the base requirement,
that is, sorting an array of items (rectangles in this case) in a visualized way.

Right now the only sort available is Bubble sort, but there is an abstract class that 
allows users to create sub Classes (Sorters of their own) called GraphicSorter.
it takes the array and the panel pointer (in order to be able to paint every step)
and also has an optional-use function called "paintPointers" that allows 
users to draw stuff of their own on the panel (using the panel pointer).

for now the design is by no means complete, and I still haven't gave too much thought
on good design for easy and secure additions by users writing extra code on top of that.

I would love if someone can try and contact me, and maybe send a review of my code,
after I'll finish writing comments on the code, in order to be perfectly clear about how each
line works and why each line exists.

Thank you, and enjoy!

#### DEMO
![](demo.gif)

