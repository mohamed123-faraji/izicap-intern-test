

## **How to run**
You have to build the project manually with maven and then build the image with docker. Run the container and  you'll need to specify any required environment variables and port mappings.

## **Architecture**

This microservice was built using the MVC architecture, with two services: GetResponseService and StockResponseService.
The first service is responsible for taking the question from the incoming request and sending a POST request to the ChatGPT API to retrieve the corresponding answer.
The second service, StockResponseService, is responsible for saving the question and its corresponding answer in a CSV file using a repository that has a method to save the data into the file.
One controller is used, called TestController, which consumes these services and responds to the user with the question and answer.
Finally, there is one model which contains the class of Question.

## **Testing**
I have created a unit test to verify the functionality of querying the ChatGPT API and ensuring that the correct answer is returned for a given question.

## **Issues**
I'm encountering an error when trying to run a Docker container on my machine,I suspect that the error is related to Docker itself rather than my container, as I'm able to build the image without any issues.

## **About me**
Sure, here's an example description based on the information you provided:
My name is Elfarrji Mohamed, and I am a Masters student in Networks and Computer Systems at the Faculty of Science and Technology in Settat. I am a fullstack developer with experience in Java/JEE, MERN stack, Laravel, and Flutter. However, my true passion is working with Java/JEE microservices.
I am a quick learner and highly motivated to expand my skillset and knowledge in the field of software development. I am committed to staying up-to-date with the latest technologies and trends, and I am always eager to take on new challenges and projects.
With my strong background in both front-end and back-end development, I am confident in my ability to deliver high-quality solutions that meet the needs of clients and users. I am a dedicated team player who values collaboration and open communication, and I believe that strong relationships and effective teamwork are key to achieving success in any project.

## **SKILLS**
skills:Jave/Jee, Spring framework, Spring Boot, MERN Stack, Flutter , Laravel
