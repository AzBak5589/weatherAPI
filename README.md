
# WeatherAPI Service

## Overview

This project serves as an API service to provide real-time weather information for any city around the world. It also offers a unit conversion feature to convert temperature from Celsius to Fahrenheit.

## Features

### Weather Information

- Endpoint: /api/weather/{city}
- Parameters: city - Name of the city for which the weather information is required.

### Temperature Conversion

- Endpoint: /api/conversion/celsiusToFahrenheit
- Parameters: celsius - Temperature value in Celsius to convert to Fahrenheit.

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven
- Spring Boot
- Postman or any API testing tool

### Installation

1. Clone the repository:
   git clone https://github.com/bipi5589/WeatherAPI.git
   
2. Navigate to the project directory:
   cd WeatherAPI
3. Build the project:
   mvn clean install
4. Run the application:
   mvn spring-boot:run

## Usage

1. Weather Information
   - Open Postman or any API testing tool.
   - Make a GET request to http://localhost:8080/api/weather/Delhi to retrieve the real-time weather information for Delhi.

2. Temperature Conversion
   - Open Postman or any API testing tool.
   - Make a GET request to http://localhost:8080/api/conversion/celsiusToFahrenheit?celsius=20 to convert 20 degrees Celsius to Fahrenheit.

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
