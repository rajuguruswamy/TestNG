
# Test NG Annotations

   ## Execution of Test NG Annotations
        @BeforeSuite
        @BeforeTest
        @BeforeClass
        @BeforeMethod
        @Test
        @AfterSuite
        @AfterTest
        @AfterClass
        @AfterMethod

   ## Prioritizing Tests
        @Test(priority = 2)

   ## Disabling Test
         @Test(priority = 3,enabled = false)

   ## Dependency Testing in TestNG
         @Test(dependsOnMethods = {"driveCar"})
         @Test(dependsOnMethods = {"driveCar","stopCar"})
   ## AlwaysRun Property
        @Test(dependsOnMethods = {"driveCar","stopCar"},alwaysRun = true)
    
   ## Grouping Tests
        @Test(groups = {"sanity"})
        @Test(groups = {"regression"})
        @Test(groups = {"sanity","regression"})

   ## Assertion in TestNG
        Assert.assertTrue();
        Assert.assertFalse();
        Assert.assertEquals();
   ## Parameters in TestNG
         @Parameters({"browser","url"})
         void setup(String browser, String app)  {}
         xml file ::   
            <suite name="Parameter Test Suite">
                <parameter name="browser" value="chrome"/>
                <parameter name="url" value="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"/>
                <test name="ParameterTest">
                    <classes>
                        <class name="ParameterExample"/>
                    </classes>
                </test>
            </suite>
  ## Data Provider in TestNg 
   ### if data in same  class
        @Test(dataProvider = "LoginDataProvider")
        public void loginTest(String email, String pwd) {
            System.out.println( email  + " " + pwd  );
        }
    
        @DataProvider(name="LoginDataProvider")
        public Object[][] getData() {
            Object[][] data = {{"abc@gmail.com", "abc"}, {"xyz@gmail.com", "xyz"}, {"mno@gmail.com", "mno"}};
            return data;
        }
        
   ### if data in another class
        @Test(dataProvider = "LoginDataProvider", dataProviderClass = CustomerDataProvider.class)

  ##  Parallel Tests
   ###  Run test methods parallel
       <suite name="All Test Suite" parallel="methods" thread-count="2" >
            <test name="Test1">
                <classes>
                    <class name="paralleltesting.ParallelTest1"/>
                </classes>
            </test>
        </suite>
    
   ###  Run test classes in parallel
            <suite name="All Test Suite" parallel="classes" thread-count="2">
                <test name="Test1">
                    <classes>
                        <class name="paralleltesting.ParallelTest1"/>
                        <class name="paralleltesting.ParallelTest2"/>            
                    </classes>
                </test>
            </suite>
    
   ###  Run tests suites in parallel
        <suite name="All Test Suite" parallel="tests" thread-count="2">
            <test name="Test1">
                <classes>
                    <class name="paralleltesting.ParallelTest1"/>
                    <class name="paralleltesting.ParallelTest2"/>
                </classes>
            </test>
            <test name="Test2" >
                <classes>
                    <class name="paralleltesting.ParallelTest2"/>
                </classes>
            </test>
         </suite>
 
##  TestNG Listeners
 ### Type of Listeners
    onStart()       - Invoked after the test class instantiated and before any configuration method is called.               
    onFinish()      - Invoked after all the test have run and after all their configuration methods hav been called.  
    onTestFailure() - Invoked each time when test fails.
    onTestSkipped() - Invoked each time when test skips
    onTestStart()   - Iinvoked each time before a test will be invoked. 
    onTestSuccess() - Invoked each time when test succeeds.
     
    
                
 ### How to use Listeners
  #### solution 1:
  create new CustomListeners class and implements ITestListener interface
  annotate @Listeners(CustomListeners.class)

  #### solution 2:
    create new CustomListeners class and implements ITestListener interface
    create testing.sml file
    configure following
        <suite name="All Test Suite">
            <listeners>
                <listener class-name="listeners.CustomListeners"/>
            </listeners>
            <test verbose="2" preserve-order="true" name="C:/raju/study/SoftwareEngineering/QA/TestNG/SampleJavaProject/src/listeners/ListenersTest.java">
                <classes>
                    <class name="listeners.ListenersTest">
                    </class>
                </classes>
            </test>
        </suite>
       
