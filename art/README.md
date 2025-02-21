# Fetch Home App

## Definition
The Fetch Home App showcases a sorted list of products based on their "ItemId" and "name," 
allowing users the choice to browse products grouped by their respective "ItemId."
The App employs the standard MVVM architecture to facilitate the organization and transmission of data across its defined layers.

<img src="/art/mvvm_pattern.webp" width="260">

## Description
The initial phase involves establishing a connection with the remote data source or API, I have used Retrofit to accomplish this. 
The data is fetched in JSON format and converted into POJO data classes (referred to as data classes in Kotlin) to enable data manipulation.

Utilizing the designated data models, the business logic is implemented via the viewModel. 
Here, the tasks such as filtering, sorting, and grouping the data are performed before encapsulating it within the LiveData data type for transmission to our View layer.

Ultimately, in the presentation layer or View, the data is showcased, providing users with the ability to interact and manipulate it as needed.

## Architecture

The most important principle to follow is separation of concerns. These UI-based classes should only contain logic that handles UI and operating system interactions. 
By keeping these classes as lean as possible, you can avoid many problems related to the component lifecycle, and improve the testability of these classes.


## Products API
[Products Item API](https://fetch-hiring.s3.amazonaws.com/hiring.json) is the API to get the "data" for the products. 

## Screenshots
<img src="/art/Screen4.jpg" width="260">&emsp;<img src="/art/Screen1.jpg" width="260">&emsp;<img src="/art/Screen2.jpg" width="260">&emsp;<img src="/art/Screen3.jpg" width="260">

## Stack

- `Coding Language:` -> Kotlin
- `Architecture Pattern:` -> Model-View-ViewModel (MVVM)
- `Network library:` -> Retrofit
- `Network concurrency:` -> Kotlin Coroutines
- `Dependency Injection:` -> Hilt
- `UI:` -> JetPack Compose
- `Missing:` -> Testing, Clean Architecture & handling errors.
