# ComposeList

ComposeList is an application designed to display a list of items with the ability to view detailed information about each item.

## Functionality

The app features the following key functionalities:

- Main screen with a list of items.
- Each item includes a text description and an image.
- Clicking on an item opens a new screen displaying detailed information about the selected item.
- Memory optimization for efficient resource usage.

## Memory Optimization

To optimize memory usage, the following techniques are employed:

- **Image caching:** Images are loaded and cached for reuse to avoid redundant loading.

- **Bitmap optimization:** Images are optimized in size and format to reduce memory consumption.

- **RecyclerView usage:** RecyclerView is used for displaying the list of items to ensure efficient scrolling and memory management.

- **Release of unused resources:** Resources such as bitmaps and object references are released when they are no longer needed.

## Testing

The application has been tested on various devices and Android versions to ensure stable performance and efficient memory usage.

## Technologies Used and Best Practices

### Technologies

- **Android Jetpack:** Utilized various Jetpack components including Compose, LiveData, ViewModel.

- **Kotlin:** Programming language used for app development.

- **Coil:** Library for image loading and displaying.

- **Coroutines:** Used for asynchronous programming.

- **RecyclerView:** For efficient display of item list.

- **JUnit and Espresso:** For writing and running tests.

### Best Practices

- **MVVM architectural approach:** Separation of view logic from business logic using ViewModel.

- **Memory usage optimization:** Image caching and efficient resource management.

- **Code documentation:** Well-documented and readable code.

- **Testing:** The application is tested on various devices and Android versions.

## Installation and Running

To install and run the application, follow these steps:

1. Clone the repository to your local machine.
2. Open the project in Android Studio.
3. Connect a testing device or use an emulator.
4. Run the application on the device or emulator.

## License

This project is licensed under the [MIT License](LICENSE).
