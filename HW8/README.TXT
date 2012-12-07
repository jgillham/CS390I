------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all he/she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE:
PURPOSE OF PROJECT:
VERSION or DATE:
HOW TO START THIS PROJECT:
AUTHORS:
USER INSTRUCTIONS:

REFLECTIONS:
Implementing sum() and product() were relatively easy. I asked myself how I could get a smaller piece of the list without changing the original list. I used subList() to pass the values of the next to the end  elements. Now, each call will look at a smaller view of the list until the view has only two elements. On those two, I simply perform the specified operation.
Implementing strCount() was similarly easy. The startsWith() functions checks for a match. I use substring() to get the string from the next character or the character after the match. Now each call will look at the next part of the string. When the search string becomes too small, the function knows no matches will be found. Therefore, each call will return the number of matches found in its part of the string.
Implementing groupExists() was challenging. The problem was that I need to try every combination of numbers in the list. I thought that if I could select each number using bit flags, then I could add 1 to go to the next combination, therefore, using addition as the means of iteration through all combinations. My first idea was the beginning.
My first idea evolved into something like a tree. I thought to myself, if I have a group of two, then I will have one tree with the first element selected and the two children with alternating selections and the second tree with the first element unselected and the two children with alternating selections. With a group of three, there will be two trees also with the first alternating on the selection and children of each will have the roots of the group of two both selected and unselected. So as you can see, while seemly complicated in explanation, this idea is elementary in implementation. The resulting tree will have all possible combinations of elements.
In testing this method, I used a for loop to generate all possible combinations. Each pass through the loop tests for the presence of the combination. I feel the utmost confidence using one paradigm to generate and the other paradigm to test.



