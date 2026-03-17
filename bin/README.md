The  project is an a trial to showcase Object Oriented Progrmamming concepts by making a console based uber app

Since there is no map  or connection between all the other users its impossible to impliment other features such as live location so there is a void in dataflow within the system and there is also other assumptions i had to make to make the system functional ,so there might be some logical voids in some areas where i could not find alternatives.

Due to limitations in java I had to use  preset distances for only three possible locations and used a distance matrix to store  the different locations and  the distance between them 

Rather then calling  the scanner class in each class that expected input I decided to use  an Input handler  class than controls all the types of input expected throughout the whole system and also adde a try catch in that class to prevent errors

I also had to  Impliment an App Menu class that handles all the menus that are in the system  making sure the  Main class stays minimal

I used enum states(I know it from GD script so my explanation might be how i understand it from GD script) for already predifined states e.g passger and driver  in user.java and ride status in ride.java

I Used HashMaps for storing variables rather than databases since its far much easier to deal but comes with the expense of losing data when the systmem is closed(RAM based) database would have been a better option but the  completely changed the whole project'slogic , so i dediced to just use hashmaps