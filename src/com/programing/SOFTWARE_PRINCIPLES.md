# Thanks to https://www.callicoder.com/software-development-principles

KISS (Keep It Simple, Stupid)

The first on my list of the most important software engineering principles is KISS. It is an acronym for “Keep It Simple, Stupid”
Software systems work best when they are kept simple. Avoiding unnecessary complexity will make your system more robust, easier to understand, easier to reason about, and easier to extend.
It’s so obvious. But we, engineers, often tend to complicate things. We use those fancy language features that no one knows about and feel proud. We introduce countless dependencies in our project for every simple thing and end up in a dependency hell. We create endless micro-services for every simple thing.
Remember that whenever you add a new dependency to your project, or start using that fancy new framework, or create a new micro-service, you’re introducing additional complexity to your system. You need to think whether that complexity is worth it or not.
Venkat Subramaniam, an award-winning author, gave this talk at a conference titled Do not walk away from complexity, Run!
This talk is so apt. It explains why you should avoid complexities whenever you can.

DRY (Don’t Repeat Yourself)

The DRY principle aims at reducing the repetition of code and effort in software systems.
It basically means that you should not write the same code/configuration in multiple places. If you do that, then you’ll have to keep them in sync; and any changes to the code at one place will require changes at other places as well.
The following excerpt from the Pragmatic programmer book sums it up in a single sentence:
"Every piece of knowledge must have a single, unambiguous, authoritative representation within a system" - The Pragmatic Programmer
The DRY principle promotes reusability. It makes the code more maintainable, more extensible, and less buggy.
Following are some concepts in software engineering that are based on the DRY principle -
Inheritance and Composition
    Both inheritance and composition allow you to write code in one place and then reuse it at other places.
Database Normalization
    Database normalization is a design technique used in databases to eliminate redundancy (repetition) of data.

YAGNI (You Aren’t Gonna Need It)

Like KISS principle, YAGNI also aims at avoiding complexity, especially the kind of complexity that arises from adding functionality that you think you may need in the future.
It states that you should not introduce things in order to solve a future problem that you don’t have right now. Always implement things when you actually need them. It will help you keep your software lean and simple. It will also save you extra money and effort.
Moreover, you may think that you need that functionality in the future. But a lot of times, you may not even need it due to the ever-changing requirements of our software world.
Remember, “Premature optimization is the root of all evil” - Donald knuth

SOLID Principles

SOLID is a list of 5 software engineering principles. It is a meta acronym where each letter corresponds to another acronym:
S  -   SRP (Single Responsibility Principle)
O -   OCP (Open Closed Principle)
L  -   LSP (Liskov Substitution Principle)
I   -   ISP (Interface Segregation Principle)
D -   DIP (Dependency Inversion Principle)
Let’s go through each of the above software engineering principles one by one:

1. SRP (Single Responsibility Principle)
The Single Responsibility Principle states that every function, class, module, or service should have a single clearly defined responsibility. In other words, A class/function/module should have one and only one reason to change.
But why is this important? Well, when you define your functions or classes in such a way that they’re focused and responsible for a single functionality, your code becomes a lot easier to understand, maintain, and modify. Whenever you want to make any changes to a functionality, you would exactly know that single DRY place where you have to change the code that is responsible for that functionality.
Let’s understand the Single Responsibility Principle with some real-world analogies:
In a house, the kitchen is for cooking and bedroom is for sleeping. Both have a single clearly defined responsibility. You don’t cook in the bedroom or sleep in the kitchen. When you want to eat, you go to the kitchen; and when you’re feeling sleepy, you go to the bedroom. It makes things so convenient.
In a company, the Project managers, Engineers, HRs, Sales people, and everyone else has a clearly defined responsibility. The PMs collect requirements and track the progress of the project. The engineers write code. The Sales people are responsible for marketing and selling the product.
The SRP principle makes the code more organized. It improves the readability of the code. It also contributes a lot to reusability. If you have short and focused functions/classes, you’ll be able to reuse them easily. But if you have a single function that does too many things then you wouldn’t be able to use it if you only need a fraction of the functionality implemented by the function.

2. OCP (Open/Closed Principle)
When we develop software, we do it in phases. We implement a bunch of functionalities, test it, and then release it to the users. Then we start implementing the next set of functionalities.
When we develop new functionalities, the last thing we want is to make changes to the existing functionality that works and is tested. We instead try to build the new functionality on top of the existing functionality.
The Open/Closed principle is a facilitator of the above idea. It advises that we should build our functions/classes/modules in such a way that they are open for extension, but closed for modification.
Open for Extension
    We should be able to add new features to the classes/modules without breaking existing code. This can be achieved using inheritance and composition.
Closed for Modification
    We should strive not to introduce breaking changes to the existing functionality, because that would force us to refactor a lot of existing code and write a whole bunch of tests to make sure that the changes work.

3. LSP (Liskov Substitution Principle)
The Liskov Substitution Principle simply means that every child/derived class should be substitutable for their parent/base class without altering the correctness of the program. In other words, the objects of your subclass should behave in the same way as the objects of your superclass.
Let’s understand this with an example. Let’s say that you have a class called Bird and a subclass of it called Penguin.

class Bird {
    public void fly() {
        System.out.println("Bird flying...");
    }
    public void eat() {
        System.out.println("Bird eating...");
    }
}

class Penguin extends Bird {
    public void fly() {
        throw new UnsupportedOperationException("Can't fly.");
    }
}

class LSPTest {
    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.fly();
    }
}

According to Liskov Substitution Principle, if you have a piece of code that uses a Bird object, then you should be able to replace it with a Penguin object and the code will still behave the same.
But, the above example violates the Liskov Substitution Principle. You can’t replace an object of the Bird class with an object of the Penguin class. If you do that, the program will throw an exception.
To fix this, you could create another abstraction which captures the flying capability of a Bird -

class Bird {
    public void eat() {
        System.out.println("Bird eating...");
    }
}

class FlightBird extends Bird {
    public void fly() {
        System.out.println("Bird flying...");
    }
}

class FlightlessBird extends Bird {

}

4. ISP (Interface Segregation Principle)
The Interface Segregation Principle states that a client should never be forced to depend on methods it does not use.
And how do you achieve this? Well, By making your interfaces small and focused.
You should split large interfaces into more specific ones that are focused on a specific set of functionalities so that the clients can choose to depend only on the functionalities they need.

5. DIP (Dependency Inversion Principle)
The Dependency Inversion Principle tries to avoid tight coupling between software modules. It states that High-level modules should not depend on low-level modules, but only on their abstractions. In simple words, It suggests that you should use interfaces instead of concrete implementations wherever possible.
This decouples a module from the implementation details of its dependencies. The module only knows about the behavior on which it depends, not how that behavior is implemented. This allows you to change the implementation whenever you want without affecting the module itself.