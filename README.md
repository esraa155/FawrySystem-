# Fawry-System
To run the project on Eclipse IDE:
1. Download Java EE
2. Download Tomcat
3. Add Tomcat to Eclipse server
4. Import maven project
5. Run the project
6. Open postman then make request
7. Enter URL, ex. Signup Customer: http://localhost:8080/Customer/signup
8. Choose request, ex. POST
9. If needed, Enter data in params
10. Click send
=======================================================================================
To run the project on IntelliJ or VS Code IDEs:
1. Import maven project
2. Run the project
3. Open postman then make request
4. Enter URL, ex. Signup Customer: http://localhost:8080/Customer/signup
5. Choose request, ex. POST
6. If needed, Enter data in params
7. Click send
=======================================================================================

Java 17 or higher is required to run the project

=======================================================================================
When using Postman, you should know some information to know how to use my Project

----------------------------------- Use the System as Admin ----------------------------------------

1. login admin (POST) --> (url) http://localhost:8080/Admin/loginadmin?name=admin&password=admin --> take 2 fixed arguments name & password
2. addDiscount (POST) --> (url) http://localhost:8080/Admin/addDiscount --> take 2 arguments service_name & Percentage --> It takes the name of the service to which it will add a percentage
3. View all receipts (GET) --> (url) http://localhost:8080/Admin/allreceipt --> not take arguments --> display all receipts made from customers or users
4. Show refund array (GET) --> (url) http://localhost:8080/Admin/Refund --> not take arguments --> display all refund requests made from customers or users
5. action with refund (PUT) --> (url) http://localhost:8080/Admin/actionrefund --> take 3 arguments username , action & id --> It takes the username who wants to do action with refund and the action will be accept or refuse and id operation 
6. show transaction added to wallet (GET) --> (Url) http://localhost:8080/Admin/addedmoney --> not take arguments --> display all operations added to wallet made from customers or users
7. logout admin (GET) --> (url) http://localhost:8080/Admin/logoutadmin --> not take arguments --> loggedout because there only one account (fixed)

----------------------------------- use the System as customer or user -----------------------------------

1. sign up (POST) --> (url) http://localhost:8080/Customer/signup --> take 5 arguments name , password , email , phonenumber & amount --> it takes username , password , email , phonenumber and amount  of money that customer wants to put in his wallet   
2. login customer (POST) --> (url) http://localhost:8080/Customer/logincustomer --> take 2 arguments username , password --> it takes username and password to Check if it is the same username and password that the customer entered when signing up
3. Sreach (GET) --> (url) http://localhost:8080/Customer/Sreach --> take 2 arguments sername & username --> it takes servicenume(sername) to search for servicename is it there or not and username who wants to search 
4. checkDiscount (GET) --> (url) http://localhost:8080/Customer/GetDiscount --> take 1 argument username --> it takes username who wants to display all services that have discount (percentage)
5. payment (GET) --> (url) http://localhost:8080/Customer/Service/Internet/Provider/WEInternet/Paymentway/Wallet --> take 2 arguments username & amount --> username who wants to pay and The amount of money that will be paid and there in url The name of the service you want to perform (intrernet) , providername (WEInternet) and paymentway (wallet) 
6. my receipt (GET) --> (url) http://localhost:8080/Customer/Myreceipt --> take 1 argument username --> it takes username to print all operations that he did them
7. request refund (PUT) --> (url) http://localhost:8080/Customer/Sendrefund --> take 2 arguments username & id --> it takes username who wants to do request refund and id operation that he wants his money back 
8. add to wallet (POST) --> (url) http://localhost:8080/Customer/Addwallet --> take 2 arguments username & amount --> it takes username and amount that he wants to add to his wallet 
9. logout customer (POST) --> (url) http://localhost:8080/Customer/logoutcustomer --> take 1 argument username --> it takes username who wants to logged out but must check if same username that customer entered when logging in


  
