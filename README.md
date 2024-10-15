# Desafio Oracle One
Conversor de Moneda usando el Api [Exchange Rate API](https://www.exchangerate-api.com).

# Currency Exchange Converter

This Java-based currency exchange converter allows users to retrieve live exchange rates from an API and perform conversions between different currencies. It also maintains a history of recent conversions for easy tracking.

## Features

- Fetches real-time currency exchange rates using an external API.
- Converts a specified amount between two selected currencies.
- Keeps a history of the last 5 currency conversions, including the time of each transaction.
- Simple command-line interface for input and output using Java Scanner.

## Technologies Used

- **Java 17**: The project is built using Java version 17.
- **HttpClient**: For making API requests to retrieve exchange rates.
- **Gson**: For parsing JSON responses from the API.
- **Java.time**: Used for handling time and dates (i.e., timestamps for conversion history).
- **LinkedList**: Used to store the last 10 conversion records.

## Getting Started

### Prerequisites

- Java 17 or higher installed on your system.
- An IDE (like IntelliJ IDEA) or a text editor to run the project.
- An API key for the [Exchange Rate API](https://www.exchangerate-api.com).

### Installation

1. Clone the repository:

   \`\`\`
   git clone https://github.com/yourusername/currency-exchange-converter.git
   \`\`\`

2. Open the project in your preferred Java IDE or text editor.

3. Add your API key to the project in the \`ConsultaApi\` class:

   \`\`\`java
   String apiKey = "your-api-key-here";
   \`\`\`

4. Build the project and ensure all dependencies (like Gson) are properly imported.

### Usage

1. Run the main application:

   \`\`\`
   java Main
   \`\`\`

2. The application will display available exchange rates and prompt you to input:

    - The base currency (e.g., USD, EUR, COP).
    - The amount to convert.
    - The target currency (e.g., USD, EUR, ARS).

3. The result will display the converted amount, and the conversion will be saved to the history.

### Example Output

\`\`\`
=== Conversor de Monedas ===  
Enter base currency (e.g., USD): USD  
Enter target currency (e.g., COP): COP  
Enter the amount to convert: 100  
Conversion Result: 400000.00 COP  

Recent Conversions:  
1. From USD, to COP, Amount 100, result 400000.00, rate 4000.00, at 2024-10-14 12:00:00  
2. ...  
\`\`\`

## API Usage

The project uses the [Exchange Rate API](https://www.exchangerate-api.com) to retrieve live exchange rates. The response is processed to extract conversion rates for the required currencies.

Example API URL:

\`\`\`
https://v6.exchangerate-api.com/v6/your-api-key/latest/USD
\`\`\`

## Conversion History

The program stores the last 5 conversions, which include:

- The base currency.
- The target currency.
- The amount converted.
- The result of the conversion.
- The timestamp when the conversion was made.

## Error Handling

If an error occurs during the API request (e.g., network issues or invalid input), the application will handle it gracefully and display a meaningful error message.

Example error message:

\`\`\`
Error: Unable to connect to the API. Please check your internet connection.
\`\`\`

## Autor

**Andrés Echeverría**  
Fordragon Dev Company.