# PDP_group

NOTE: OPEN THE TERMINAL IN "res" DIRECTORY AND EXECUTE THE JAR FILE.

We have implemented the Model-View-Controller design in this application.

VIEW:

• The view is the part of the application that interacts with the user. 

•  It has functions which can get inputs from the user, display an appropriate message when an error is encountered and display the result to  the user. 

		 
CONTROLLER:

• The controller is like the brain of the entire design which decides the flow of the whole application and. Delegates work on both the model and the view.

• It is responsible for invoking the view and model based on the situation encountered. 

• The controller passes on the operation from the view to model and vice-versa depending upon the situation. 

		 
MODEL:

• The Model represents the image data and various functionalities available to the user. 

• Based on the user input, the controller interacts with the model to complete the task and revert back to the controller. 

• Testing is done in a separate package and is used to check and verify the precision and the correctness of the application.
• 
		 
ENHANCEMENTS FROM PREVIOUS VERSION:

• The command design pattern is implemented to make the controller more maintainable and extendable.

• Additional functionalities like blur, sharpen, greyscale, sepia and dithering are implemented as additional features.

• View object was passed as an argument to the controller.

• Part of the load and save functionality which involves communicating with the OS and file systems are moved to the controller.

  Support for loading and saving images in multiple formats have been implemented in this iteration.






COMPLETE PARTS OF THE PROGRAM:

• Controller is completed end to end in the sense that any new commands to be implemented in the future can be implemented by just adding the command to the hashmap and adding the corresponding command classes and interfaces. There won't be any design-level changes in the controller.

• FileIO is complete where users can now load and work on any format of images and save them in other formats as well.

• Model is designed and developed keeping code maintenance and extendability in mind where adding a new function renders no change in the codebase rather can be achieved by inheritance and interfaces for the new set of functionalities. Sharpen, Blur, Dither etc were added to the application using inheritance and interfaces.


DESIGN CHANGES AND THEIR JUSTIFICATIONS:

• CHANGE: 		 The conventional switch case in the controller to manage the model was replaced with the 
		    		command design pattern.

  JUSTIFICATION: The command design pattern was implemented as it makes the controller work efficiently 
				 without the codebase expanding exponentially everytime after adding support for a new 
				 command.
				 Command design pattern also made the controller more readable and concise as all the 
				 command execution is stored in a hashmap which is indexed based on the command
				 name.


• CHANGE:  		 Moved the load and save functionalities from model to controller.
  
  JUSTIFICATION: Moving the load and save to controller made the model independent of fileIO operations.
				 Model stays true to its purpose where it doesn't know the source of the data, but keeps track of the data and the operations to be performed on the data.


• CHANGE:		 Abstracted the common aspects of both horizontal flip and vertical flip.

  JUSTIFICATION: Abstraction resulted in lesser lines of code and reduced redundancy in the code base.
				 Abstraction has helped in making the flip feature more flexible in the sense where it made it easier to add other new types of flips into the model without changing the existing code base.


• CHANGE: 		 Modified all the model functions from returning String to returning boolean values.

  JUSTIFICATION: The return type was changed to boolean in order to know if the function in the model 
				 performed the operation successfully.
				 This way, we can check in the controller the return value of the functions and determine the status of the operation. If True is returned, then the operation was successful, otherwise the operation failed.



------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

DESIGN CHANGES FOR ASSIGNMENT 6


• CHANGE: 		 A new GUI was built for this assignment.

  JUSTIFICATION: As part of implementing the changes for assignment 6 a new GUI was created using Java Swing. The design was created inorder to make the application more user friendly. 





IMAGE SOURCE: 
1 http://artpaw.com/images/dog_highres_2.jpg
2 https://upload.wikimedia.org/wikipedia/commons/1/18/Dog_Breeds.jpg
3 https://www.freepnglogos.com/uploads/dog-png/bow-wow-gourmet-dog-treats-are-healthy-natural-low-4.png
