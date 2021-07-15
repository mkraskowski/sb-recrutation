1. Requirements for project which is wrote in Selenium:
 <br> -Java at least 8 version
 <br> -Maven
2. How to run:
 <br> In command line in project folder put command: mvn clean install -Dlocal.browser=<TYPE_BROWSER>  (for example: mvn clean install -Dlocal.browser=CHROME)
 <br> Available browser:
 <br> -for Firefox put FIREFOX in <TYPE_BROWSER> place
 <br> -for Chrome put CHROME in <TYPE_BROWSER> place
 <br> -for Edge put EDGE in <TYPE_BROWSER> place
3. Raport:
 <br> After test will be created test raport in folder target/cucumber-JVM-reports/cucumber-html-reports file overview-features.html
4. Test scenario:
 <br>It is the  simplest scenario for full order path.
 <br>User add to first book from new arrivals, then he procced order to 3rd page where he fill biling data.
 On this page, test checking if order product list and subtotal price are equals. If everything is ok then user click on place order button to accept order. Otherwise test will fail.
 On last page, test checking: order list size, book name, subtotal price, total price and payment method with data save in previous pages.
5. Task for the future:
<br>- add screenshot when test will fail
<br>- add other browser
<br>- add configuration for remote runs - now test could be run local
<br>- upgrade test report for more data
<br>- create longer or different order path scenario
