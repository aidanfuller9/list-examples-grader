CPATH='.;lib/hamcrest-core-1.3.jar;lib/junit-4.13.2.jar'

rm -rf student-submission
rm -rf grading-area

mkdir grading-area

# Step 1 - Clone student's repository
git clone $1 student-submission
echo 'Finished cloning'

# Step 2 - Check that student's code contains ListExamples.java

if [[ -f student-submission/ListExamples.java ]] 
then 
    echo "ListExamples.java exists"
else 
    echo "ListExamples.java does not exist"
    echo "Grade: 0"
    exit 
fi 

# Step 3 - Put all relevant files in grading-area directory
cp student-submission/ListExamples.java TestListExamples.java grading-area
cp -r lib grading-area

# Step 4 - Compile java files, ensure successful compilation
cd grading-area
javac -cp $CPATH ListExamples.java TestListExamples.java 

if [[ $? == 0 ]] 
then
    echo "Compilation was successful"
else 
    echo "Compilation was not sucessful"
    echo "Grade: 0"
    exit 
fi 

echo "The exit code of javac is $?" 


# Step 5 - Run the tests, report grade based on JUnit output
# java -cp $CPATH org.junit.runner.JUnitCore TestListExamples
java -cp $CPATH org.junit.runner.JUnitCore TestListExamples > results.txt 

failures=`grep "Tests run:" results.txt | cut  -d ':' -f 3`
testsRun=`grep "Tests run:" results.txt | cut  -d ':' -f 2 | cut -d ',' -f 1` 

result=$(($testsRun - $failures))
echo Total Score Is: $result out of $testsRun 

rm -rf student-submission
rm -rf grading-area

# Draw a picture/take notes on the directory structure that's set up after
# getting to this point

# Then, add here code to compile and run, and do any post-processing of the
# tests
