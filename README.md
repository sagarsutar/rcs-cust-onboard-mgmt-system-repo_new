# rcs-cust-onboard-mgmt-system-repo_new


Dockerfile

FROM openjdk:17-jdk-slim
COPY target/assignemnt-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]


Deployment Instructions

mvn clean package
java -jar target/assignemnt-0.0.1-SNAPSHOT.jar

DB console
http://localhost:8080/h2-console



## Swagger url
http://localhost:8080/swagger-ui/index.html#/submission-controller/submit


Submit form 
http://localhost:8080//api/submissions/submit

Request Body

    {
        "customerId": "CUST-002",
    "formId": 1,
    "responseJson": " {\"title\": \"Customer Order Form\",\"organisation_name\":\"Tata Sons\",\"legal_company_name\":\"Tata Sons\",\"business_ein\":\"12-1234567\",\"organization_type\":\"public_profit\",\"brand_logo_image\":\"qwqwq\",\"brand_banner_image\":\"wqwqwq\",\"sid\":\"HSNXXXXXXXdfdfdfdfdfdfdfddddddddddddddddddddddddfddfdfdfdfd\",\"brand_name\":\"Tata Communications\",\"business_brand_description\":\"Tata Communications is a global digital ecosystem enabler\",\"agent_name\":\"Tata Communications\",\"agent_purpose\":\"OTP\",\"agent_billing_cateogry\":\"BASIC_MESSAGE\",\"agent_service_code\":\"tata-12345\",\"agent_logo\":\"same as above\",\"agent_banner\":\"same as above\",\"address_line_1\":\"Tata Communication Mumbai india\",\"address_line_2\":\"Nariman point \",\"address_city\":\"Mumbai\",\"address_state\":\"411001\",\"address_zip_code\":\"456666\",\"phone_number\":\"33353535\",\"website_url\":\"xvdfdsf\",\"terms_conditions\":\"sdfdsf\",\"privacy\":\"sdfds\",\"contact_name\":\"Vijay Ghuge\",\"contact_position\":\"Service Manager\",\"contact_email\":\"rbm@tatacommunications.com\",\"contact_phone_number\":\"344334543534\",\"message_webhook_url\":\"sfasasdasd\",\"color\":\"sfsafsaf\"\n    } ",
    "submissionStatus": "DRAFT"
    }
	
	
	
Review  api 

Valid status are below 
DRAFT,
SUBMITTED,
IN_REVIEW,
APPROVED,
REJECTED


http://localhost:8080/api/reviews/1001
request Body
{
  "status": "DRAFT",
  "remarks": "read"
}



creating new for 
valid formType are  CUSTOMER_ORDER, QUALIFICATION

http://localhost:8080/api/forms/createForm

requet Body
{
   "createdBy": "customer",
    "formType": "CUSTOMER_ORDER",
      "schemaJson": "{\n      \"title\": \"Customer Order Form\",\n      \"fields\": [\n        { \"name\": \"thhhh\", \"type\": \"string\", \"required\": true },\n        { \"name\": \"pune\", \"type\": \"string\", \"required\": true },\n        { \"name\": \"tckkkl1123.com\", \"type\": \"email\", \"required\": true },\n        { \"name\": \"56444\", \"type\": \"number\", \"required\": true }\n      ]\n    }",
  
    "version": 3
}


get latest form  passs parameter CUSTOMER_ORDER, QUALIFICATION

http://localhost:8080/api/forms/latest/CUSTOMER_ORDER


users details to hit url you have to use basic authontication in postman

CUSTOMER, TPM, SALES, ADMIN

use PASSWORD as password

GET http://localhost:8080/api/submissions/customer/CUST-001 



Valid status are below 
DRAFT,
SUBMITTED,
IN_REVIEW,
APPROVED,
REJECTED

GET http://localhost:8080/api/submissions/status?status=SUBMITTED

GET /api/submissions/date-range?startDate=2026-01-03T00:00:00&endDate=2026-01-31T23:59:59
