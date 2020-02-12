#Code challange interview [TravelPort]
==================================

### Weather App <br/>

<img src ="https://github.com/douglasalipio/travel_port_code_douglas_challage/blob/master/app/photo1.jpg"  width="360"/>&nbsp;&nbsp;
<img src ="https://github.com/douglasalipio/travel_port_code_douglas_challage/blob/master/app/foto2.jpg" width="360" />&nbsp;&nbsp;

### Requirements achieved

Fetching all required data from the folowing API endpoints:

- GET http://api.openweathermap.org/data/2.5/weather?q=${cityName}&APPID=bd8326266ffeb1b662cf75fadf5dee2a&&units=metric
- GET http://api.openweathermap.org/data/2.5/forecast?q=${cityName}&APPID=bd8326266ffeb1b662cf75fadf5dee2a&&units=metric

Extras

- Weather list view
- Unit tests
- Language (Kotlin)

### Relevant 3rd party libraries

- Retrofit2
- Coroutines
- Dagger2
- Groupie
- Gson
- Espresso
- Mockito
- Junit4 
- Glid 

### Architecture

The MPV design pattern has been implemented to make views reusable and to isolate business rules from the Presenter layer, which makes it easier to test.
The application is divided into three layers, namely View, Presenter, and Data. In addition, there is an interactor responsible to fetch the weather forecast data.

### Installation

- Android Studio 3.5
- Gradle 5.4.1

