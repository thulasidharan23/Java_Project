OTP Generator

This project is a simple Java program to generate a One-Time Password (OTP) using the Random class. The OTP consists of numerical digits only.

Getting Started
These instructions will help you set up and run the OTP generator on your local machine.

Prerequisites
Java Development Kit (JDK) installed
Git installed
Installation
Clone the repository:

git clone https://github.com/thulasidharan23/otp-generator.git
Navigate to the project directory:


cd otp-generator

Usage
Compile the Java file:


javac otp.java

Run the program:

java otp

By default, the program generates a 4-digit OTP.

Customizing the OTP Length
To generate an OTP of a different length, modify the length variable in the main method of the otp.java file:

public static void main(String[] args) {
    int length = 6; // Change this to your desired OTP length
    System.out.println(OTP(length));
}

Example Output

Generating OTP using random():
Your OTP is : 
[1, 4, 5, 8]


Contributing
Fork the repository
Create your feature branch (git checkout -b feature/AmazingFeature)
Commit your changes (git commit -m 'Add some AmazingFeature')
Push to the branch (git push origin feature/AmazingFeature)
Open a pull request


License
This project is licensed under the MIT License - see the LICENSE file for details.