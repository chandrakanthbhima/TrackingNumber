# Tracking Number Generator API

# Description
A RESTful API to generate unique tracking numbers for parcels. Built using Spring Boot.

## Setup 

1. **Clone the repository**: 
	```sh 
	git clone https://github.com/example/trackingnumber.git 
	cd trackingnumber 
	``` 

2. **Build the project**: 
	```sh 
	./mvnw clean install 
	```
3. **Run the application**: 
	```sh 
	./mvnw spring-boot:run 
	``` 
	
## API Endpoint 
### GET /next-tracking-number 

#### Parameters 
- `origin_country_id` (String): The order’s origin country code in ISO 3166-1 alpha-2 format. 
- `destination_country_id` (String): The order’s destination country code in ISO 3166-1 alpha-2 format. 
- `weight` (double): The order’s weight in kilograms, up to three decimal places. 
- `created_at` (String): The order’s creation timestamp in RFC 3339 format. 
- `customer_id` (String): The customer’s UUID. 
- `customer_name` (String): The customer’s name. 
- `customer_slug` (String): The customer’s name in slug-case/kebab-case. 

#### Response 
```json 
{ 
	"tracking_number": "AB123CD456EF7890", 
	"created_at": "2024-11-06T15:53:00Z" 
}