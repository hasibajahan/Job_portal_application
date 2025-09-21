// Handle search button click
document.addEventListener("DOMContentLoaded", function () {
    const searchBtn = document.getElementById("searchBtn");
    const jobInput = document.getElementById("jobInput");
    const locationInput = document.getElementById("locationInput");

    searchBtn.addEventListener("click", function () {
        const job = jobInput.value.trim();
        const location = locationInput.value.trim();

        if (job || location) {
            alert(`Searching for: ${job} in ${location}`);
            // Later you can integrate backend API call here
        } else {
            alert("Please enter a job title or location.");
        }
    });
});
