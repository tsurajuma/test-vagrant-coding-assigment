# Test Vagrant Coding Assignment

# To run Test Vagrant Coding Assignment from GitHub, run the following code:
git clone https://github.com/tsurajuma/test-vagrant-coding-assigment.git

# Navigate to the Project Directory: 
# Change your current directory to the root directory of the cloned project. Use the cd command followed by the project directory name.
cd test-vagrant-coding-assigment

# Build the Project: 
# Run the Maven build command mvn clean install to compile the source code, run tests, and generate the project artifacts.
# to run tests
mvn clean install

# Execute the Project:
# command for execution.
java -cp target/classes musicplayer.Main
