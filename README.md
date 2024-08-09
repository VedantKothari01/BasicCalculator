
## Basic Calculator App

### Overview

This Basic Calculator app is an Android application designed to perform basic arithmetic operations such as addition, subtraction, multiplication, and division. The app features a clean and intuitive user interface, providing users with a seamless experience to carry out simple calculations.

### Features

- **Arithmetic Operations**: Perform addition, subtraction, multiplication, and division.
- **Clear Function**: Easily clear input fields and results with the clear button.
- **Result Display**: Display results accurately, only showing decimal points when necessary.
- **Responsive UI**: Ensures a consistent and user-friendly experience across different devices.
- **Tactile Feedback**: Provides vibration feedback when interacting with buttons.
- **About Page**: Includes an About page with a toggleable heart icon to show appreciation.

### Technologies Used

- **Java**: Primary programming language for the app.
- **Android Studio**: Integrated Development Environment (IDE) used for development.
- **XML**: For designing the user interface layouts.
- **ConstraintLayout**: Used for designing responsive layouts.

### How It Works

1. **MainActivity**: The main interface of the app where users can enter numbers, select operators, and view results.
    - **EditText**: For entering the two numbers to be calculated.
    - **Spinner**: To select the desired arithmetic operation.
    - **TextView**: To display the result of the calculation.
    - **Buttons**: For performing calculations (`equal` button) and clearing inputs (`clear` button).

2. **AboutActivity**: A secondary interface providing information about the app.
    - **ImageButton**: A heart icon that users can toggle to show appreciation.
    - **Button**: To navigate back to the main interface.

### Code Highlights

- **Intents**: Used for navigating between `MainActivity` and `AboutActivity`.
- **Vibration Feedback**: Implemented to enhance user interaction.
- **Snackbar**: Provides feedback after performing actions such as calculations.
- **Input Validation**: Ensures valid numeric inputs for calculations and handles division by zero.

### Usage

1. **Enter Numbers**: Type in the two numbers you want to perform calculations on.
2. **Select Operation**: Choose the arithmetic operation from the dropdown.
3. **Calculate**: Press the `Equal` button to view the result.
4. **Clear**: Use the `Clear` button to reset the inputs and result.
5. **About Page**: Click the `About` button to learn more about the app and show your appreciation with the heart icon.

### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/VedantKothari01/BasicCalculator.git
    ```
2. Open the project in Android Studio.
3. Build and run the project on an emulator or physical device.

### Contributing

Feel free to contribute to this project by submitting issues or pull requests. Any contributions are highly appreciated!

### License

This project is licensed under the MIT License. See the LICENSE file for more details.
---
