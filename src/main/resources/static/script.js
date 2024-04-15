const container = document.querySelector(".container");
const search = document.querySelector(".search-box button");
const weatherBox = document.querySelector(".weather-box");
const weatherDetails = document.querySelector(".weather-details");
const error404 = document.querySelector(".not-found");

search.addEventListener("click", () => {
    const city = document.getElementById("search-btn").value;

    fetch(`/search?city=${city}`)
        .then(response => response.json())
        .then(data => {
            if (data.error) {
                // Location not found
                showError(data.error);
            } else {
                // Location found, update UI with weather data
                updateUI(data);
            }
        })
        .catch(error => {
            console.error("Error fetching weather data:", error);
            showError("An error occurred while fetching weather data.");
        });
});

function showError(message) {
    // Display error message on the UI
    error404.classList.add("active");
    error404.querySelector("p").innerText = message;
    weatherBox.classList.remove("active");
    weatherDetails.classList.remove("active");
}

function updateUI(data) {
    // Update UI with weather data
    error404.classList.remove("active");
    weatherBox.classList.add("active");
    weatherDetails.classList.add("active");

    const image = document.querySelector(".weather-box img");
    const temperature = document.querySelector(".weather-box .temperature");
    const description = document.querySelector(".weather-box .description");
    const humidity = document.querySelector(".weather-details .humidity span");
    const wind = document.querySelector(".weather-details .wind span");

    // Update image, temperature, description, humidity, and wind
    // based on the data received from the API
    image.src = `images/${data.weather[0].main.toLowerCase()}.jpg`; // Assuming images are named based on weather conditions
    temperature.innerHTML = `${parseInt(data.main.temp)}<span>°C</span>`;
    description.innerHTML = `${data.weather[0].description}`;
    humidity.innerHTML = `${data.main.humidity}%`;
    wind.innerHTML = `${parseInt(data.wind.speed)}Km/h`;
}
